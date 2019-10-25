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

	
	
}
