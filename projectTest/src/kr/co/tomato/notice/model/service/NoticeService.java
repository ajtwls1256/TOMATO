package kr.co.tomato.notice.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import kr.co.tomato.common.JDBCTemplate;
import kr.co.tomato.notice.model.dao.NoticeDao;
import kr.co.tomato.notice.model.vo.Notice;


public class NoticeService {

	public ArrayList<Notice> noticeList() {
		Connection conn = JDBCTemplate.getConnection();
		
		NoticeDao dao = new NoticeDao();
		
		ArrayList<Notice> list = dao.noticeList(conn);
		
		JDBCTemplate.close(conn);
		
		return list;
	}

}
