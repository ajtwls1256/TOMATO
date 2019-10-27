package kr.co.tomato.admin.adminItem.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import kr.co.tomato.admin.adminItem.model.dao.AdminMdDao;
import kr.co.tomato.common.JDBCTemplate;
import kr.co.tomato.vo.AdminMdListPageData;
import kr.co.tomato.vo.Item;
import kr.co.tomato.vo.Review;

public class AdminMdService {

	public AdminMdListPageData adminMdList(int reqPage) {
		Connection conn = JDBCTemplate.getConnection();
		AdminMdDao dao = new AdminMdDao();
		
		int numPerPage = 10;
		int totalCount = dao.totalCount(conn);
		System.out.println("totalCount : " +totalCount);
		
		int totalPage = (totalCount%numPerPage == 0)?(totalCount/numPerPage):(totalCount/numPerPage)+1;
		
		int start = (reqPage-1)*numPerPage+1;
		int end = reqPage*numPerPage;
		System.out.println("시작번호 : "+start+"/끝번호 : "+end);
		
		ArrayList<Item> list = dao.adminMdList(conn, start, end);

		String pageNavi = "";
		int pageNaviSize = 5;
		
		int pageNo = ((reqPage-1)/pageNaviSize)*pageNaviSize+1;	
		
		if(pageNo != 1) {
			pageNavi += "<a class='btn' href='/adminMdList?reqPage="+(pageNo-1)+"'>이전</a>";
		}
		
		int i = 1;
		
		while(!(i++>pageNaviSize || pageNo>totalPage)) {
			if(reqPage==pageNo) {
				pageNavi += "<span class='selectPage'>"+pageNo+"</span>";
			}else {
				pageNavi += "<a class='btn' href='/adminMdList?reqPage="+pageNo+"'>"+pageNo+"</a>";
			}
			pageNo++;
		}
		
		if(pageNo<=totalPage) {
			pageNavi += "<a class='btn' href='/adminMdList?reqPage="+pageNo+"'>다음</a>";
		}
		
		AdminMdListPageData amlpd = new AdminMdListPageData(list, pageNavi);
		
		JDBCTemplate.close(conn);
		return amlpd;
	}
	public int adminMdUpdate(int itemNo, String itemState, String itemDealState) {
		Connection conn = JDBCTemplate.getConnection();
		AdminMdDao dao = new AdminMdDao();
		int result = dao.adminMdUpdate(conn, itemNo, itemState, itemDealState);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		return result;
	}
	public AdminMdListPageData AdminMdListSearch(int reqPage, String type, String keyword) {
		Connection conn = JDBCTemplate.getConnection();
		AdminMdDao dao = new AdminMdDao();

		
		int numPerPage = 10;
		int totalCount = 0;
		if(type.equals("itemNo")){
			totalCount = dao.itemNoTotalCount(conn, keyword);
		}else if(type.equals("memberNo")) {
			totalCount = dao.memberNoTotalCount(conn, keyword);
		}else if(type.equals("itemName")) {
			totalCount = dao.itemNameTotalCount(conn, keyword);
		}else if(type.equals("itemDealState")) {
			totalCount = dao.itemDealStateTotalCount(conn, keyword);
		}
		System.out.println("totalCount : " +totalCount);
		
		int totalPage = (totalCount%numPerPage == 0)?(totalCount/numPerPage):(totalCount/numPerPage)+1;
		
		int start = (reqPage-1)*numPerPage+1;
		int end = reqPage*numPerPage;
		System.out.println("시작번호 : "+start+"/끝번호 : "+end);
		
		//회원번호,이메일,상점명,이름
		ArrayList<Item> list = null;
		
		switch(type) {
		case "itemNo": list = dao.searchKeywordItemNo(conn,keyword,start,end); break;
		case "memberNo": list = dao.searchKeywordMemberNo(conn,keyword,start,end); break;
		case "itemName": list = dao.searchKeywordItemName(conn,keyword,start,end); break;
		case "itemDealState": list = dao.searchKeywordItemDealState(conn,keyword,start,end); break;
		}
		
		String pageNavi = "";
		int pageNaviSize = 5;
		
		int pageNo = ((reqPage-1)/pageNaviSize)*pageNaviSize+1;	
		
		if(pageNo != 1) {
			pageNavi += "<a class='btn' href='/adminMdsearchKeyword?type="+type+"&keyword="+keyword+"&reqPage="+pageNo+"'>이전</a>";
		}
		
		int i = 1;
		
		while(!(i++>pageNaviSize || pageNo>totalPage)) {
			if(reqPage==pageNo) {
				pageNavi += "<span class='selectPage'>"+pageNo+"</span>";
			}else {
				pageNavi += "<a class='btn' href='/adminMdsearchKeyword?type="+type+"&keyword="+keyword+"&reqPage="+pageNo+"'>"+pageNo+"</a>";			
			}
			pageNo++;
		}
		
		if(pageNo<=totalPage) {
			pageNavi += "<a class='btn' href='/adminMdsearchKeyword?type="+type+"&keyword="+keyword+"&reqPage="+pageNo+"'>다음</a>";
		}
		
		AdminMdListPageData amlpd = new AdminMdListPageData(list, pageNavi);
		
		JDBCTemplate.close(conn);
		return amlpd;
	}
	public int adminMdListDelete(int itemNo) {
		Connection conn = JDBCTemplate.getConnection();
		AdminMdDao dao = new AdminMdDao();
		int result = dao.adminMdListDelete(conn, itemNo);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}
	public Review AjaxReview(int no) {
		Connection conn = JDBCTemplate.getConnection();
		AdminMdDao dao = new AdminMdDao();
		
		Review r = dao.AjaxReview(conn, no);
				
		JDBCTemplate.close(conn);
		
		return r;
	}
	public int reviewDelete(int no) {
		
		Connection conn = JDBCTemplate.getConnection();
		AdminMdDao dao = new AdminMdDao();
		int result = dao.reviewDelete(conn, no);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}
}
