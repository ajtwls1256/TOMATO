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

	public int adminNoticeUpdate(String title, String content, int no) {
		Connection conn = JDBCTemplate.getConnection();

		NoticeDao dao = new NoticeDao();

		int result = dao.adminNoticeUpdate(title, content, no, conn);

		if (result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}

		JDBCTemplate.close(conn);

		return result;
	}

	public int adminNoticeInsert(String title, String content) {
		Connection conn = JDBCTemplate.getConnection();

		NoticeDao dao = new NoticeDao();

		int result = dao.adminNoticeInsert(title, content, conn);

		if (result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}

		JDBCTemplate.close(conn);

		return result;
	}


	public int adminNoticeDelete(int noticeNo) {
		Connection conn = JDBCTemplate.getConnection();

		NoticeDao dao = new NoticeDao();

		int result = dao.adminNoticDelete(noticeNo , conn);

		if (result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}

		JDBCTemplate.close(conn);

		return result;
	}

	public Notice NoticeSearch(int no) {
		Connection conn = JDBCTemplate.getConnection();
		
		NoticeDao dao = new NoticeDao();
		
		Notice n = dao.NoticeSearch(conn, no);
		
		JDBCTemplate.close(conn);
		
		return n;
	}


}
