package kr.co.tomato.product.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import kr.co.tomato.common.JDBCTemplate;
import kr.co.tomato.product.model.dao.ItemImgDao;
import kr.co.tomato.vo.ItemImg;

public class ItemImgService {
	public int insertPhoto(ItemImg i) {
		Connection conn = JDBCTemplate.getConnection();
		ItemImgDao dao = new ItemImgDao();
		int result = dao.insertPhoto(conn, i);
		if(result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public int ItemImgTotalCount() {
		Connection conn = JDBCTemplate.getConnection();
		ItemImgDao dao = new ItemImgDao();
		int totalCount = dao.ItemImgTotalCount(conn);
		JDBCTemplate.close(conn);
		return totalCount;
	}

	public ArrayList<ItemImg> moreItemImg(int start) {
		Connection conn = JDBCTemplate.getConnection();
		int length = 3;
		ItemImgDao dao = new ItemImgDao();
		ArrayList<ItemImg> list = dao.moreItemImg(conn, start, start+length-1);
		JDBCTemplate.close(conn);
		return list;
	}
}
