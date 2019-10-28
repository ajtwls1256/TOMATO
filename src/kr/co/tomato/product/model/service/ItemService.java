package kr.co.tomato.product.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import kr.co.tomato.common.JDBCTemplate;
import kr.co.tomato.product.model.dao.ItemDao;
import kr.co.tomato.vo.Item;

public class ItemService {
	
	// 아이템 삽입
	public int insertItem(Item item) {
		
		Connection conn = JDBCTemplate.getConnection();
		ItemDao dao = new ItemDao();
		int result = dao.insertItem(conn, item);
		
		if(result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}

	public ArrayList<Item> selectAll() {
		Connection conn = JDBCTemplate.getConnection();
		ItemDao dao = new ItemDao();
		
		ArrayList<Item> list = dao.selectAll(conn);
		
		if(list != null) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		return list;
	}

	public int deleteItem(int itemNo) {
		Connection conn = JDBCTemplate.getConnection();
		ItemDao dao = new ItemDao();
		int result = dao.deleteItem(conn, itemNo);
		if(result > 0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		return result;
	}

	public ArrayList<Item> searchKeyword(String type, String keyword) {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Item> list = null;
		ItemDao dao = new ItemDao();
		
		switch(type) {
			case "dealingItem" : list = dao.searchKeywordDealing(conn, keyword);
				break;
			case "onsaleItem" : list = dao.searchKeywordOnsale(conn, keyword);
				break;
			case "soldItem" : list = dao.searchKeywordsold(conn, keyword);
				break;
		}
		JDBCTemplate.close(conn);
		return list;
	}

	public ArrayList<Item> buyItem() {
		Connection conn = JDBCTemplate.getConnection();
		ItemDao dao = new ItemDao();
		
		ArrayList<Item> list = dao.buyItem(conn);
		
		if(list != null) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		return list;
	}

	public ArrayList<Item> sellItem() {
		Connection conn = JDBCTemplate.getConnection();
		ItemDao dao = new ItemDao();
		
		ArrayList<Item> list = dao.sellItem(conn);
		
		if(list != null) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		return list;
	}
	
}
