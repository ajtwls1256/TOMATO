package kr.co.tomato.noticeCategory.model.service;

import java.sql.Connection;

import kr.co.tomato.common.JDBCTemplate;
import kr.co.tomato.noticeCategory.model.dao.noticeCategoryDao;
import kr.co.tomato.noticeCategory.model.vo.noticeCategory;

public class noticeCategoryService {

	public noticeCategory searchSub(String sub) {
		Connection conn = JDBCTemplate.getConnection();
		
		noticeCategoryDao dao = new noticeCategoryDao();
		noticeCategory nc = dao.searchSub(conn, sub);
		
		JDBCTemplate.close(conn);
		
		return nc;
	}

}
