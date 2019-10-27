package kr.co.tomato.noitceMTM.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import kr.co.tomato.common.JDBCTemplate;
import kr.co.tomato.noitceMTM.model.dao.NoticeMTMDao;
import kr.co.tomato.noitceMTM.model.vo.NoticeMTM;
import kr.co.tomato.vo.PageData;
import kr.co.tomato.vo.PageData2;

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

	public PageData2 noticeMTMAdmin2(int reqPage) {
		Connection conn = JDBCTemplate.getConnection();
		NoticeMTMDao dao = new NoticeMTMDao();

		int numPerPage = 5; // 한 페이지당 게시물 수
		int totalCount = dao.totalCount(conn); // 미답변 게시물 수

		System.out.println("totalCount" + totalCount);

		int totalPage = (totalCount % numPerPage == 0) ? (totalCount / numPerPage) : (totalCount / numPerPage) + 1;
		// 총페이지 수
		System.out.println("totalPage :" + totalPage);
		// 1 page -> 1번글 ~10번글, 2page -> 11번글 ~ 20번글 ...

		int start = (reqPage - 1) * numPerPage + 1; // 페이지 시작 게시물 번호
		int end = reqPage * numPerPage; // 페이지 마지막 게시물 번호
		System.out.println("시작번호 : " + start + "/ 끝번호 : " + end);

		ArrayList<NoticeMTM> list = dao.noticeMTMAdmin(conn);

		// 페이지 네비게이션 생성
		String pageNavi = ""; // 페이지 네비 HTML을 저장하는 변수
		int pageNaviSize = 5; // 페이지 넘버 수
		// pageNO는 해당 페이지 시작번호
		// 1~5 > 1 , 6~10 -> 6, 11~ 15 -> 11
		int pageNo = ((reqPage - 1) / pageNaviSize) * pageNaviSize + 1; // 원래코드
		if (reqPage < 3) {
			pageNo = 1;
		} else {
			pageNo = reqPage - 2;
		} /* 선택한 숫자가 중앙으로 오면서 다음숫자가 바로바로 나오게하는 */
		// 이전버튼 생성하는 코드
		if (pageNo != 1) {
			pageNavi += "<a class='btn' href='//noticeMTMAdmin?reqPage=" + (reqPage - 1) + "'>이전</a>"; // pageNo - 1 원래
																										// 코드
		}
		// pageNo - 1 원래 코드
		// 6 7 8 9 10 에서 이전버튼 클릭시 5페이지 요청

		int i = 1;
		// i를 1부터 증가시키면서 pageNaviSize만큼 반복문
		// 단, pageNo가 totalPage보다 크면 마지막페이지에 도달한것이므로 반복문 수행을 멈춤
		while (!(i++ > pageNaviSize || pageNo > totalPage)) {
			if (reqPage == pageNo) {
				pageNavi += "<span class='selectPage'>" + pageNo + "</span>";

			} else {
				pageNavi += "<a class='btn' href='//noticeMTMAdmin?reqPage=" + pageNo + "'>" + pageNo + "</a>";
			}
			pageNo++;
		}
		if (pageNo <= totalPage) {
			pageNavi += "<a class='btn' href='//noticeMTMAdmin?reqPage=" + (reqPage + 1) + "'>다음</a>"; // pageNo + 1 원래
																										// 코드
		}
		// 이전 1 2 3 4 5 다음
		// 이전 6 7 8 9 10 다음
		PageData2 pd = new PageData2(pageNavi, list);

		JDBCTemplate.close(conn);

		return pd;
	}
}
