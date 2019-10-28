package kr.co.tomato.noitceMTM.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import kr.co.tomato.common.JDBCTemplate;
import kr.co.tomato.noitceMTM.model.dao.NoticeMTMDao;
import kr.co.tomato.noitceMTM.model.vo.NoticeMTM;
import kr.co.tomato.noitceMTM.model.vo.NoticeMTMPageData;

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

	public NoticeMTMPageData noticeMTMAdmin(int reqPage) {

		Connection conn = JDBCTemplate.getConnection();

		NoticeMTMDao dao = new NoticeMTMDao();

		int numPerPage = 5; //한 페이지당 게시물 
		int totalCount = dao.totalCount(conn);
		
		int totalPage = (totalCount % numPerPage ==0) ? (totalCount/numPerPage):(totalCount / numPerPage) +1;
		
		int start = (reqPage -1) * numPerPage +1;
		int end = reqPage * numPerPage;
		
		ArrayList<NoticeMTM> list = dao.noticeMTMAdmin(conn, start, end);
		
		String pageNavi = "";
		int pageNavieSize = 5;
		
		int pageNo = ((reqPage -1) / pageNavieSize) * pageNavieSize + 1;
		if(reqPage<3) {
			pageNo = 1;
		}else {
			pageNo = reqPage-2;
		}
		
		if(pageNo != 1) {
			pageNavi += "<a class='btn' href='/noticeMTMAdminPage?reqPage=" + (reqPage - 1) + "'>이전</a>";
		}
		
		int i = 1;
		
		while(!(i++ > pageNavieSize || pageNo > totalPage)) {
			if(reqPage == pageNo) {
				pageNavi += "<span class='selectPage'>" + pageNo + "</span>";
			}else {
				pageNavi += "<a class='btn' href='/noticeMTMAdminPage?reqPage=" + pageNo + "'>" + pageNo + "</a>";
			}
			pageNo++;
		}
		if(pageNo <= totalPage) {
			pageNavi += "<a class ='btn' href='/noticeMTMAdminPage?reqPage=" + (reqPage+1) + "'>다음</a>";
			
		}
		
		NoticeMTMPageData pd = new NoticeMTMPageData(list, pageNavi);
		
		JDBCTemplate.close(conn);
		
		return pd;
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

	public ArrayList<NoticeMTM> noticeMTMAdmin2() {
		Connection conn = JDBCTemplate.getConnection();
		
		NoticeMTMDao dao = new NoticeMTMDao();
		ArrayList<NoticeMTM> list = dao.noticeMTMAdmin2(conn);
				
		JDBCTemplate.close(conn);
		
		return list;
	}


	
}
