package kr.co.tomato.admin.adminMember.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import kr.co.tomato.admin.adminMember.model.dao.AdminMemberDao;
import kr.co.tomato.common.JDBCTemplate;
import kr.co.tomato.vo.AdminMdListPageData;
import kr.co.tomato.vo.AdminMemberListPageData;
import kr.co.tomato.vo.Member;

/**
 * @author user1
 *
 */
/**
 * @author user1
 *
 */
public class AdminMemberService {
	/**
	 * @ AdminMemberSearchList(회원관리페이지 회원 리스트)
	 * @param : reqPage(페이징) 
	 * @return : AdminMemberListPageData -> amlpd(페이징 데이터)
	 * @author : 김승현
	 * @date : 2019-10-22
	 */
	public AdminMemberListPageData AdminMemberList(int reqPage) {
		Connection conn = JDBCTemplate.getConnection();
		AdminMemberDao dao = new AdminMemberDao();
		
		int numPerPage = 10;
		int totalCount = dao.totalCount(conn);
		System.out.println("totalCount : " +totalCount);
		
		int totalPage = (totalCount%numPerPage == 0)?(totalCount/numPerPage):(totalCount/numPerPage)+1;
		
		int start = (reqPage-1)*numPerPage+1;
		int end = reqPage*numPerPage;
		System.out.println("시작번호 : "+start+"/끝번호 : "+end);
		
		ArrayList<Member> list = dao.AdminMemberList(conn, start, end);
		
		String pageNavi = "";
		int pageNaviSize = 5;
		
		int pageNo = ((reqPage-1)/pageNaviSize)*pageNaviSize+1;	
		
		if(pageNo != 1) {
			pageNavi += "<a class='btn' href='/adminMemberList?reqPage="+(pageNo-1)+"'>이전</a>";
		}
		
		int i = 1;
		
		while(!(i++>pageNaviSize || pageNo>totalPage)) {
			if(reqPage==pageNo) {
				pageNavi += "<span class='selectPage'>"+pageNo+"</span>";
			}else {
				pageNavi += "<a class='btn' href='/adminMemberList?reqPage="+pageNo+"'>"+pageNo+"</a>";
			}
			pageNo++;
		}
		
		if(pageNo<=totalPage) {
			pageNavi += "<a class='btn' href='/adminMemberList?reqPage="+pageNo+"'>다음</a>";
		}
		
		AdminMemberListPageData amlpd = new AdminMemberListPageData(list, pageNavi);
		
		JDBCTemplate.close(conn);
		return amlpd;
	}

	/**
	 * @param : reqPage(페이징), type(검색 종류), keyword(검색어) 
	 * @return : AdminMemberListPageData amlpd(페이징 데이터)
	 * @see : AdminMemberSearchList(회원관리페이지 회원검색 기능)
	 * @author : 김승현
	 * @date : 2019-10-22
	 */
	public AdminMemberListPageData AdminMemberSearchList(int reqPage, String type, String keyword) {
		Connection conn = JDBCTemplate.getConnection();
		AdminMemberDao dao = new AdminMemberDao();

		
		int numPerPage = 10;
		int totalCount = 0;
		if(type.equals("memberNo")){
			totalCount = dao.memberNoTotalCount(conn, keyword);
		}else if(type.equals("email")) {
			totalCount = dao.EmailTotalCount(conn, keyword);
		}else if(type.equals("shopName")) {
			totalCount = dao.ShopNameTotalCount(conn, keyword);
		}else if(type.equals("memberName")) {
			totalCount = dao.memberNameTotalCount(conn, keyword);
		}
		System.out.println("totalCount : " +totalCount);
		
		int totalPage = (totalCount%numPerPage == 0)?(totalCount/numPerPage):(totalCount/numPerPage)+1;
		
		int start = (reqPage-1)*numPerPage+1;
		int end = reqPage*numPerPage;
		System.out.println("시작번호 : "+start+"/끝번호 : "+end);
		
		//회원번호,이메일,상점명,이름
		ArrayList<Member> list = null;
		
		switch(type) {
		case "memberNo": list = dao.searchKeywordMemberNo(conn,keyword,start,end); break;
		case "email": list = dao.searchKeywordEmail(conn,keyword,start,end); break;
		case "shopName": list = dao.searchKeywordShopName(conn,keyword,start,end); break;
		case "memberName": list = dao.searchKeywordMemberName(conn,keyword,start,end); break;
		}
		
		String pageNavi = "";
		int pageNaviSize = 5;
		
		int pageNo = ((reqPage-1)/pageNaviSize)*pageNaviSize+1;	
		
		if(pageNo != 1) {
			pageNavi += "<a class='btn' href='/searchMemberKeyword?type="+type+"&keyword="+keyword+"&reqPage="+pageNo+"'>이전</a>";//+"?reqPage="+(pageNo-1)+
		}//type=email&keyword=1
		
		int i = 1;
		
		while(!(i++>pageNaviSize || pageNo>totalPage)) {
			if(reqPage==pageNo) {
				pageNavi += "<span class='selectPage'>"+pageNo+"</span>";
			}else {
				pageNavi += "<a class='btn' href='/searchMemberKeyword?type="+type+"&keyword="+keyword+"&reqPage="+pageNo+"'>"+pageNo+"</a>";//"?reqPage="+pageNo
			}
			pageNo++;
		}
		
		if(pageNo<=totalPage) {
			pageNavi += "<a class='btn' href='/searchMemberKeyword?type="+type+"&keyword="+keyword+"&reqPage="+pageNo+"'>다음</a>";//
		}
		
		AdminMemberListPageData amlpd = new AdminMemberListPageData(list, pageNavi);
		
		JDBCTemplate.close(conn);
		return amlpd;
	}

	public int adminMemberDelete(String memberNo) {
		Connection conn = JDBCTemplate.getConnection();
		AdminMemberDao dao = new AdminMemberDao();
		int result = dao.adminMemberDelete(conn, memberNo);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}
}
