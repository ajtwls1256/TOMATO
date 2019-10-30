package kr.co.tomato.search.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import kr.co.tomato.common.JDBCTemplate;
import kr.co.tomato.search.model.dao.SearchDao;
import kr.co.tomato.vo.CategoryResult;
import kr.co.tomato.vo.Item;
import kr.co.tomato.vo.Search;
import kr.co.tomato.vo.SearchPageData;

public class SearchService
{
    
    public SearchPageData getSearchList(int reqPage, String keyword, String mainCategory, String subCategory, ArrayList<String> memAddress, String email)
    {
        Connection conn = JDBCTemplate.getConnection();
        SearchDao dao = new SearchDao();
        
        int numPerPage = 25;
        int totalCount = 0;
        
        if(memAddress == null) {
        
            if(subCategory != null) {
                totalCount = dao.itemTotalCount(conn, keyword, mainCategory, subCategory);
            }else if(mainCategory != null) {
                totalCount = dao.itemTotalCount(conn, keyword, mainCategory);
            }else {            
                totalCount = dao.itemTotalCount(conn, keyword);
            }
        
        
        }else {
            
            if(subCategory != null) {
                totalCount = dao.itemTotalCount(conn, keyword, mainCategory, subCategory, memAddress);
            }else if(mainCategory != null) {
                totalCount = dao.itemTotalCount(conn, keyword, mainCategory, memAddress);
            }else {            
                totalCount = dao.itemTotalCount(conn, keyword, memAddress);
            }
            
        }
        
        System.out.println("totalCount : " + totalCount);
        
        
        int totalPage = (totalCount % numPerPage == 0)
                ? (totalCount / numPerPage)
                : (totalCount / numPerPage) + 1;
        int start = (reqPage - 1) * numPerPage + 1;
        int end = reqPage * numPerPage;
        System.out.println("시작번호 : " + start + "/끝번호 : " + end);
        
        
        ArrayList<Item> searchList = null;
        ArrayList<CategoryResult> categorySubResult = null;
        ArrayList<CategoryResult> categoryMainResult = null;
        
        if(memAddress == null) {
        
	        if(subCategory != null) {
	            searchList = dao.getSearchList(conn, keyword, mainCategory, subCategory, start, end);
	            categorySubResult = dao.getCategorySubResult(conn, keyword, mainCategory, subCategory);
	            categoryMainResult = dao.getCategoryMainResult(conn, keyword, mainCategory, subCategory);
	        }else if(mainCategory != null) {
	            searchList = dao.getSearchList(conn, keyword, mainCategory, start, end);
	            categorySubResult = dao.getCategorySubResult(conn, keyword, mainCategory);
	            categoryMainResult = dao.getCategoryMainResult(conn, keyword, mainCategory);
	        }else {            
	            searchList = dao.getSearchList(conn, keyword, start, end);
	            categorySubResult = dao.getCategorySubResult(conn, keyword);
	            categoryMainResult = dao.getCategoryMainResult(conn, keyword);
	        }
        
        }else {
        	
	        if(subCategory != null) {
	            searchList = dao.getSearchList(conn, keyword, mainCategory, subCategory, memAddress, start, end);
	            categorySubResult = dao.getCategorySubResult(conn, keyword, mainCategory, subCategory, memAddress);
	            categoryMainResult = dao.getCategoryMainResult(conn, keyword, mainCategory, subCategory, memAddress);
	        }else if(mainCategory != null) {
	            searchList = dao.getSearchList(conn, keyword, mainCategory, memAddress, start, end);
	            categorySubResult = dao.getCategorySubResult(conn, keyword, mainCategory, memAddress);
	            categoryMainResult = dao.getCategoryMainResult(conn, keyword, mainCategory, memAddress);
	        }else {            
	            searchList = dao.getSearchList(conn, keyword, memAddress, start, end);
	            categorySubResult = dao.getCategorySubResult(conn, keyword, memAddress);
	            categoryMainResult = dao.getCategoryMainResult(conn, keyword, memAddress);
	        }
        	
        }
        
        
        String pageNavi = "";
        int pageNaviSize = 5;
        
        int pageNo = ((reqPage - 1) / pageNaviSize) * pageNaviSize + 1;
        
        if (pageNo != 1)
        {
        	
        	if(memAddress == null) {
        		
        		if(subCategory != null) {
        			pageNavi += "<a class='btn' href='/search?keyword=" + keyword + "&reqPage=" + (pageNo-1) + "&mainCategory=" + mainCategory + "&subCategory=" + subCategory +"'>이전</a>";
        		}else if(mainCategory != null) {
        			pageNavi += "<a class='btn' href='/search?keyword=" + keyword + "&reqPage=" + (pageNo-1) + "&mainCategory=" + mainCategory +"'>이전</a>";
        		}else {
        			pageNavi += "<a class='btn' href='/search?keyword=" + keyword + "&reqPage=" + (pageNo-1) + "'>이전</a>";        			
        		}
        		
        	}else {
        		if(subCategory != null) {
        			pageNavi += "<a class='btn' href='/search?keyword=" + keyword + "&reqPage=" + (pageNo-1) + "&mainCategory=" + mainCategory + "&subCategory=" + subCategory + "&email=" + email +"'>이전</a>";
        		}else if(mainCategory != null) {
        			pageNavi += "<a class='btn' href='/search?keyword=" + keyword + "&reqPage=" + (pageNo-1) + "&mainCategory=" + mainCategory + "&email=" + email +"'>이전</a>";
        		}else {
        			pageNavi += "<a class='btn' href='/search?keyword=" + keyword + "&reqPage=" + (pageNo-1) +  "&email=" + email +"'>이전</a>";        			
        		}
        	}
        }
        
        int i = 1;
        
        while (!(i++ > pageNaviSize || pageNo > totalPage))
        {
            if (reqPage == pageNo)
            {
                pageNavi += "<span class='selectPage'>" + pageNo + "</span>";
            }
            else
            {
            	
            	if(memAddress == null) {
            		
            		if(subCategory != null) {
            			pageNavi += "<a class='btn' href='/search?keyword=" + keyword + "&reqPage=" + pageNo + "&mainCategory=" + mainCategory + "&subCategory=" + subCategory +"'>" + pageNo + "</a>";
            		}else if(mainCategory != null) {
            			pageNavi += "<a class='btn' href='/search?keyword=" + keyword + "&reqPage=" + pageNo + "&mainCategory=" + mainCategory +"'>" + pageNo + "</a>";
            		}else {
            			pageNavi += "<a class='btn' href='/search?keyword=" + keyword + "&reqPage=" + pageNo + "'>" + pageNo + "</a>";        			
            		}
            		
            	}else {
            		if(subCategory != null) {
            			pageNavi += "<a class='btn' href='/search?keyword=" + keyword + "&reqPage=" + pageNo + "&mainCategory=" + mainCategory + "&subCategory=" + subCategory + "&email=" + email +"'>" + pageNo + "</a>";
            		}else if(mainCategory != null) {
            			pageNavi += "<a class='btn' href='/search?keyword=" + keyword + "&reqPage=" + pageNo + "&mainCategory=" + mainCategory + "&email=" + email +"'>" + pageNo + "</a>";
            		}else {
            			pageNavi += "<a class='btn' href='/search?keyword=" + keyword + "&reqPage=" + pageNo + "&email=" + email +"'>" + pageNo + "</a>";        			
            		}
            	}
            
            
            }
            pageNo++;
        }
        
        
        
        if (pageNo <= totalPage)
        {
        	
        	if(memAddress == null) {
        		
        		if(subCategory != null) {
        			pageNavi += "<a class='btn' href='/search?keyword=" + keyword + "&reqPage=" + pageNo + "&mainCategory=" + mainCategory + "&subCategory=" + subCategory +"'>다음</a>";
        		}else if(mainCategory != null) {
        			pageNavi += "<a class='btn' href='/search?keyword=" + keyword + "&reqPage=" + pageNo + "&mainCategory=" + mainCategory +"'>다음</a>";
        		}else {
        			pageNavi += "<a class='btn' href='/search?keyword=" + keyword + "&reqPage=" + pageNo + "'>다음</a>";        			
        		}
        		
        	}else {
        		if(subCategory != null) {
        			pageNavi += "<a class='btn' href='/search?keyword=" + keyword + "&reqPage=" + pageNo + "&mainCategory=" + mainCategory + "&subCategory=" + subCategory + "&email=" + email +"'>다음</a>";
        		}else if(mainCategory != null) {
        			pageNavi += "<a class='btn' href='/search?keyword=" + keyword + "&reqPage=" + pageNo + "&mainCategory=" + mainCategory + "&email=" + email +"'>다음</a>";
        		}else {
        			pageNavi += "<a class='btn' href='/search?keyword=" + keyword + "&reqPage=" + pageNo +  "&email=" + email +"'>다음</a>";        			
        		}
        	}

        }
        
        
        
        
        
        SearchPageData searchpd = new SearchPageData(searchList, pageNavi, categorySubResult, categoryMainResult, totalCount);
        
        
        /* 검색어 검색테이블에 추가 */
        Search search = dao.selectByKeyword(conn, keyword);
        int result = 0;
        if(search == null) {
        	result = dao.insertSearch(conn, keyword);
        }else {
        	result = dao.updateSearch(conn, keyword, search.getSearchCount());
        }
        
        if(result > 0 ) {
        	JDBCTemplate.commit(conn);
        }else {
        	JDBCTemplate.rollback(conn);
        }
        

        
        
        JDBCTemplate.close(conn);
        
        return searchpd;
    }
    
    

    public ArrayList<String> getMemberAddress(String email)
    {
        Connection conn = JDBCTemplate.getConnection();
        SearchDao dao = new SearchDao();
        
        ArrayList<String> result = dao.getMemberAddress(conn, email);
        
        for(String addr : result) {
            System.out.println(email + "회원의 관심지역");
            System.out.println(addr);
        }
        
        
        JDBCTemplate.close(conn);
        
        return result;
    }



	public SearchPageData getCategorySearchList(int reqPage, String mainCategory, String subCategory, ArrayList<String> memAddress,
			String email) {
		
	    Connection conn = JDBCTemplate.getConnection();
	    SearchDao dao = new SearchDao();
	    
        int numPerPage = 25;
        int totalCount = 0;
        
        
        if(memAddress == null) {
            
            if(subCategory != null) {
                totalCount = dao.itemCategoryTotalCount(conn, mainCategory, subCategory);
            }else if(mainCategory != null) {
                totalCount = dao.itemCategoryTotalCount(conn, mainCategory);
            }
        
        
        }else {
        	
			
			if (subCategory != null) {
				totalCount = dao.itemCategoryTotalCount(conn, mainCategory, subCategory, memAddress);
			} else if (mainCategory != null) {
				totalCount = dao.itemCategoryTotalCount(conn, mainCategory, memAddress);
			}
			 
        }
        
        System.out.println("totalCount : " + totalCount);
        
        
        
        int totalPage = (totalCount % numPerPage == 0)
                ? (totalCount / numPerPage)
                : (totalCount / numPerPage) + 1;
        int start = (reqPage - 1) * numPerPage + 1;
        int end = reqPage * numPerPage;
        System.out.println("시작번호 : " + start + "/끝번호 : " + end);
        
        
        ArrayList<Item> searchList = null;
        
        
        if(memAddress == null) {
            
	        if(subCategory != null) {
	            searchList = dao.getCategorySearchList(conn, mainCategory, subCategory, start, end);
	        }else if(mainCategory != null) {
	            searchList = dao.getCategorySearchList(conn, mainCategory, start, end);
	        }
        
        }else {

			if (subCategory != null) {
				searchList = dao.getCategorySearchList(conn, mainCategory, subCategory, memAddress, start, end);
			} else if (mainCategory != null) {
				searchList = dao.getCategorySearchList(conn, mainCategory, memAddress, start, end);
			}
			 
        	
        }
        
        
        String pageNavi = "";
        int pageNaviSize = 5;
        
        int pageNo = ((reqPage - 1) / pageNaviSize) * pageNaviSize + 1;
        
        if (pageNo != 1)
        {
        	
        	if(memAddress == null) {
        		
        		if(subCategory != null) {
        			pageNavi += "<a class='btn' href='/search?&reqPage=" + (pageNo-1) + "&mainCategory=" + mainCategory + "&subCategory=" + subCategory +"'>이전</a>";
        		}else if(mainCategory != null) {
        			pageNavi += "<a class='btn' href='/search?&reqPage=" + (pageNo-1) + "&mainCategory=" + mainCategory +"'>이전</a>";
        		}else {
        			pageNavi += "<a class='btn' href='/search?&reqPage=" + (pageNo-1) + "'>이전</a>";        			
        		}
        		
        	}else {
				
				
				if (subCategory != null) {
					pageNavi += "<a class='btn' href='/search?&reqPage=" + (pageNo - 1) + "&mainCategory="
							+ mainCategory + "&subCategory=" + subCategory + "&email=" + email + "'>이전</a>";
				} else if (mainCategory != null) {
					pageNavi += "<a class='btn' href='/search?&reqPage=" + (pageNo - 1) + "&mainCategory="
							+ mainCategory + "&email=" + email + "'>이전</a>";
				} else {
					pageNavi += "<a class='btn' href='/search?&reqPage=" + (pageNo - 1) + "&email=" + email
							+ "'>이전</a>";
				}
				 
				 
        	}
        }
        
        int i = 1;
        
        while (!(i++ > pageNaviSize || pageNo > totalPage))
        {
            if (reqPage == pageNo)
            {
                pageNavi += "<span class='selectPage'>" + pageNo + "</span>";
            }
            else
            {
            	
            	if(memAddress == null) {
            		
            		if(subCategory != null) {
            			pageNavi += "<a class='btn' href='/search?reqPage=" + pageNo + "&mainCategory=" + mainCategory + "&subCategory=" + subCategory +"'>" + pageNo + "</a>";
            		}else if(mainCategory != null) {
            			pageNavi += "<a class='btn' href='/search?reqPage=" + pageNo + "&mainCategory=" + mainCategory +"'>" + pageNo + "</a>";
            		}else {
            			pageNavi += "<a class='btn' href='/search?reqPage=" + pageNo + "'>" + pageNo + "</a>";        			
            		}
            		
            	}else {
					
					
					if (subCategory != null) {
						pageNavi += "<a class='btn' href='/search?reqPage=" + pageNo + "&mainCategory=" + mainCategory
								+ "&subCategory=" + subCategory + "&email=" + email + "'>" + pageNo + "</a>";
					} else if (mainCategory != null) {
						pageNavi += "<a class='btn' href='/search?reqPage=" + pageNo + "&mainCategory=" + mainCategory
								+ "&email=" + email + "'>" + pageNo + "</a>";
					} else {
						pageNavi += "<a class='btn' href='/search?reqPage=" + pageNo + "&email=" + email + "'>" + pageNo
								+ "</a>";
					}
					 
					 
            	}
            
            
            }
            pageNo++;
        }
        
        
        
        if (pageNo <= totalPage)
        {
        	
        	if(memAddress == null) {
        		
        		if(subCategory != null) {
        			pageNavi += "<a class='btn' href='/search?reqPage=" + pageNo + "&mainCategory=" + mainCategory + "&subCategory=" + subCategory +"'>다음</a>";
        		}else if(mainCategory != null) {
        			pageNavi += "<a class='btn' href='/search?reqPage=" + pageNo + "&mainCategory=" + mainCategory +"'>다음</a>";
        		}else {
        			pageNavi += "<a class='btn' href='/search?reqPage=" + pageNo + "'>다음</a>";        			
        		}
        		
        	}else {
        		if(subCategory != null) {
        			pageNavi += "<a class='btn' href='/search?reqPage=" + pageNo + "&mainCategory=" + mainCategory + "&subCategory=" + subCategory + "&email=" + email +"'>다음</a>";
        		}else if(mainCategory != null) {
        			pageNavi += "<a class='btn' href='/search?reqPage=" + pageNo + "&mainCategory=" + mainCategory + "&email=" + email +"'>다음</a>";
        		}else {
        			pageNavi += "<a class='btn' href='/search?reqPage=" + pageNo +  "&email=" + email +"'>다음</a>";        			
        		}
        	}

        }
        
 
        
        
        
        SearchPageData searchpd = new SearchPageData(searchList, pageNavi, null, null, totalCount);
        
        JDBCTemplate.close(conn);
        
        return searchpd;
        
        
	     
	}
    
}
