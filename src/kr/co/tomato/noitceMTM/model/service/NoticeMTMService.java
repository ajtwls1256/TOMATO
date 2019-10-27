package kr.co.tomato.noitceMTM.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import kr.co.tomato.common.JDBCTemplate;
import kr.co.tomato.noitceMTM.model.dao.NoticeMTMDao;
import kr.co.tomato.noitceMTM.model.vo.NoticeMTM;

public class NoticeMTMService {

	public int insertNoticeMTM(NoticeMTM mtm) {
		Connection conn = JDBCTemplate.getConnection();

		NoticeMTMDao dao = new NoticeMTMDao();
		int result = dao.insertNoticeMTM(conn, mtm);

		if (result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);

		return result;
	}

	public ArrayList<NoticeMTM> noticeMTMAdmin() {

		Connection conn = JDBCTemplate.getConnection();

		NoticeMTMDao dao = new NoticeMTMDao();

		ArrayList<NoticeMTM> list = dao.noticeMTMAdmin(conn);

		JDBCTemplate.close(conn);

		return list;
	}

	public int NoticeMTMAdminInsert(String content, int no) {
		Connection conn = JDBCTemplate.getConnection();

		NoticeMTMDao dao = new NoticeMTMDao();
		int result = dao.NoticeMTMAdminInsert(content, no, conn);

		if (result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);

		return result;
	}

	public NoticeMTM AdminAnswerSearch(int no) {
		Connection conn = JDBCTemplate.getConnection();

		NoticeMTMDao dao = new NoticeMTMDao();
		NoticeMTM mtm = dao.AdminAnswerSearch(conn, no);

		JDBCTemplate.close(conn);

		return mtm;
	}

	public ArrayList<NoticeMTM> selectList(int reqPage) {

		Connection conn = JDBCTemplate.getConnection();
		NoticeMTMDao dao = new NoticeMTMDao();

		ArrayList<NoticeMTM> list = dao.noticeMTMAdmin(conn);

		JDBCTemplate.close(conn);

		return list;
	}

	
}
