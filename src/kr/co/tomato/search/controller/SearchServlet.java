package kr.co.tomato.search.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.tomato.search.model.service.SearchService;
import kr.co.tomato.vo.Item;
import kr.co.tomato.vo.SearchPageData;


/**
 * Servlet implementation class SearchServlet
 */
@WebServlet(name = "Search", urlPatterns = { "/search" })
public class SearchServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet()
    {
        super();
        // TODO Auto-generated constructor stub
    }
    
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException
    {
        
        request.setCharacterEncoding("utf-8");
        
        String keyword = request.getParameter("keyword");
        System.out.println("searchServlet에 넘어온 값 : " + keyword);
        
        String mainCategory = request.getParameter("mainCategory");
        String subCategory = request.getParameter("subCategory");
        
        
        ArrayList<String> memAddress = new ArrayList<>();
        
        String email = request.getParameter("email");
        if(email != null) {
            SearchService service = new SearchService();
            memAddress = service.getMemberAddress(email);
            for(String s : memAddress)
            	System.out.print("회원의 관심지역 : " + s + ", ");
            System.out.println();
  
        }else {
            System.out.println("searchServlet에 넘어온 memberNo없음");
        }
   
        
        int reqPage;
        try
        {
            reqPage = Integer.parseInt(request.getParameter("reqPage"));
        }
        catch (NumberFormatException e)
        {
            reqPage = 1;
        }
        
        SearchService service = new SearchService();
        SearchPageData searchPd = null;
        
        
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/search/searchList.jsp");
        
        
        if(memAddress.isEmpty()) {
            
        	if(keyword != null) {
    	
	            if(subCategory != null) {
	                searchPd = service.getSearchList(reqPage, keyword, mainCategory, subCategory, null, email);
	            }else if(mainCategory != null) {
	                searchPd = service.getSearchList(reqPage, keyword, mainCategory, null, null, email);
	            }else {
	                searchPd = service.getSearchList(reqPage, keyword, null, null, null, email);
	            }
	            
        	}else {
        		/* 카테고리 검색 = 키워드가 없음 */
        		if(subCategory != null) {
	                searchPd = service.getCategorySearchList(reqPage, mainCategory, subCategory, null, email);
	            }else if(mainCategory != null) {
	                searchPd = service.getCategorySearchList(reqPage, mainCategory, null, null, email);
	            }
        	}
            
        }else {
            
        	
        	if(keyword != null) {
        		
        		if(subCategory != null) {
        			searchPd = service.getSearchList(reqPage, keyword, mainCategory, subCategory, memAddress, email);
        		}else if(mainCategory != null) {
        			searchPd = service.getSearchList(reqPage, keyword, mainCategory, null, memAddress, email);
        		}else {
        			searchPd = service.getSearchList(reqPage, keyword, null, null, memAddress, email);
        		}
        	
        	}else {
        		/* 카테고리 검색 = 키워드가 없음 */
        		if(subCategory != null) {
	                searchPd = service.getCategorySearchList(reqPage, mainCategory, subCategory, memAddress, email);
	            }else if(mainCategory != null) {
	                searchPd = service.getCategorySearchList(reqPage, mainCategory, null, memAddress, email);
	            }
        	}
            
        }
        
        
        
        
        
         request.setAttribute("keyword", keyword);
         request.setAttribute("searchPd", searchPd);
         request.setAttribute("mainCategory", mainCategory);
         request.setAttribute("subCategory", subCategory);
         request.setAttribute("memAddress", memAddress);
         rd.forward(request, response);
    }
    
    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException
    {
        // TODO Auto-generated method stub
        doGet(request, response);
    }
    
}
