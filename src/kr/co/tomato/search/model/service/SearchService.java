package kr.co.tomato.search.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import kr.co.tomato.common.JDBCTemplate;
import kr.co.tomato.search.model.dao.SearchDao;
import kr.co.tomato.vo.Item;
import kr.co.tomato.vo.SearchPageData;

public class SearchService
{
    
    public SearchPageData getSearchList(int reqPage, String itemName)
    {
        Connection conn = JDBCTemplate.getConnection();
        SearchDao dao = new SearchDao();
        
        int numPerPage = 25;
        int totalCount = 0;
        
        totalCount = dao.itemTotalCount(conn, itemName);
        System.out.println("totalCount : " + totalCount);
        
        int totalPage = (totalCount % numPerPage == 0)
                ? (totalCount / numPerPage)
                : (totalCount / numPerPage) + 1;
        int start = (reqPage - 1) * numPerPage + 1;
        int end = reqPage * numPerPage;
        System.out.println("시작번호 : " + start + "/끝번호 : " + end);
        
        ArrayList<Item> searchList = dao.getSearchList(conn, itemName, start,
                                                       end);
        String pageNavi = "";
        int pageNaviSize = 5;
        
        int pageNo = ((reqPage - 1) / pageNaviSize) * pageNaviSize + 1;
        
        if (pageNo != 1)
        {
            pageNavi += "<a class='btn' href='/search?itemName=" + itemName + "&reqPage=" + pageNo
                    + "'>이전</a>";
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
                pageNavi += "<a class='btn' href='/search?itemName=" + itemName + "&reqPage=" + pageNo
                        + "'>" + pageNo + "</a>";
            }
            pageNo++;
        }
        
        if (pageNo <= totalPage)
        {
            pageNavi += "<a class='btn' href='/search?itemName=" + itemName + "&reqPage=" + pageNo
                    + "'>다음</a>";
        }
        
        SearchPageData searchpd = new SearchPageData(searchList, pageNavi);
        
        JDBCTemplate.close(conn);
        
        return searchpd;
    }
    
}
