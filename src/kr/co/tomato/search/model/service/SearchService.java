package kr.co.tomato.search.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import kr.co.tomato.search.model.dao.SearchDao;
import kr.co.tomato.vo.Item;

public class SearchService {

	public ArrayList<Item> getSearchList(String itemName) {
		Connection conn = null;
		SearchDao dao = new SearchDao();
		
		ArrayList<Item> searchList = dao.getSearchList(conn, itemName);
		
		
		
		
		return null;
	}

}
