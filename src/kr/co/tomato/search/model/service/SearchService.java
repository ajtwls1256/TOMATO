package kr.co.tomato.search.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import kr.co.tomato.search.model.dao.SearchDao;
import kr.co.tomato.vo.Item;

public class SearchService {

	public ArrayList<Item> getSearchList(int reqPage, String itemName) {
		Connection conn = null;
		SearchDao dao = new SearchDao();
		
		
		
		int numPerPage = 10;
                int totalCount = 0;
                
                totalCount = dao.itemTotalCount(conn, itemName);
                System.out.println("totalCount : " +totalCount);
                
                int totalPage = (totalCount%numPerPage == 0)?(totalCount/numPerPage):(totalCount/numPerPage)+1;
                int start = (reqPage-1)*numPerPage+1;
                int end = reqPage*numPerPage;
                System.out.println("시작번호 : "+start+"/끝번호 : "+end);
                
		
//		ArrayList<Item> searchList = dao.getSearchList(conn, itemName);
		
		
		
		
		return null;
	}

}
