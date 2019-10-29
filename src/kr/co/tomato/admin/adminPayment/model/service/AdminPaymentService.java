package kr.co.tomato.admin.adminPayment.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import kr.co.tomato.admin.adminPayment.model.dao.AdminPaymentDao;
import kr.co.tomato.common.JDBCTemplate;
import kr.co.tomato.vo.AdminPaymentListPageData;
import kr.co.tomato.vo.Payment;

public class AdminPaymentService {

	public AdminPaymentListPageData adminPaymentList(int reqPage) {
		Connection conn = JDBCTemplate.getConnection();
		AdminPaymentDao dao = new AdminPaymentDao();
		
		int numPerPage = 10;
		int totalCount = dao.totalCount(conn);
		System.out.println("totalCount : " +totalCount);
		
		int totalPage = (totalCount%numPerPage == 0)?(totalCount/numPerPage):(totalCount/numPerPage)+1;
		
		int start = (reqPage-1)*numPerPage+1;
		int end = reqPage*numPerPage;
		System.out.println("시작번호 : "+start+"/끝번호 : "+end);
		
		ArrayList<Payment> list = dao.adminPaymentList(conn, start, end);

		String pageNavi = "";
		int pageNaviSize = 5;
		
		int pageNo = ((reqPage-1)/pageNaviSize)*pageNaviSize+1;	
		
		if(pageNo != 1) {
			pageNavi += "<a class='btn' href='/adminPaymentList?reqPage="+(pageNo-1)+"'>이전</a>";
		}
		
		int i = 1;
		
		while(!(i++>pageNaviSize || pageNo>totalPage)) {
			if(reqPage==pageNo) {
				pageNavi += "<span class='selectPage'>"+pageNo+"</span>";
			}else {
				pageNavi += "<a class='btn' href='/adminPaymentList?reqPage="+pageNo+"'>"+pageNo+"</a>";
			}
			pageNo++;
		}
		
		if(pageNo<=totalPage) {
			pageNavi += "<a class='btn' href='/adminPaymentList?reqPage="+pageNo+"'>다음</a>";
		}
		
		AdminPaymentListPageData aplpd = new AdminPaymentListPageData(list, pageNavi);
		
		JDBCTemplate.close(conn);
		return aplpd;
	}

	public int adminPaymentUpdate(String paymentState, String paymentNy,String merchantUid, int itemNo) {
		Connection conn = JDBCTemplate.getConnection();
		AdminPaymentDao dao = new AdminPaymentDao();
		int result = dao.adminPaymentUpdate(conn,paymentState,paymentNy,merchantUid);
		int result2 = dao.adminPaymentUpdate2(conn,itemNo);
		
		int total = result+result2;
		if(total>1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return total;
	}

	public int adminPaymentListDelete(String merchantUid) {
		Connection conn = JDBCTemplate.getConnection();
		AdminPaymentDao dao = new AdminPaymentDao();
		int result = dao.adminPaymentListDelete(conn, merchantUid);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public AdminPaymentListPageData AdminPaymentListSearch(int reqPage, String type, String keyword) {
		Connection conn = JDBCTemplate.getConnection();
		AdminPaymentDao dao = new AdminPaymentDao();

		int numPerPage = 10;
		int totalCount = 0;
		if(type.equals("itemNo")){//상점번호
			totalCount = dao.itemNoTotalCount(conn, keyword);
		}else if(type.equals("memberNo")) {//회원번호
			totalCount = dao.memberNoTotalCount(conn, keyword);
		}else if(type.equals("merchantUid")) {//상점거래
			totalCount = dao.merchantUidTotalCount(conn, keyword);
		}else if(type.equals("paymentState")) {//결제상태
			totalCount = dao.paymentStateTotalCount(conn, keyword);
		}
		System.out.println("totalCount : " +totalCount);
		
		int totalPage = (totalCount%numPerPage == 0)?(totalCount/numPerPage):(totalCount/numPerPage)+1;
		
		int start = (reqPage-1)*numPerPage+1;
		int end = reqPage*numPerPage;
		System.out.println("시작번호 : "+start+"/끝번호 : "+end);
		
		//회원번호,이메일,상점명,이름
		ArrayList<Payment> list = null;
		
		switch(type) {
		case "itemNo": list = dao.searchKeywordItemNo(conn,keyword,start,end); break;
		case "memberNo": list = dao.searchKeywordMemberNo(conn,keyword,start,end); break;
		case "merchantUid": list = dao.searchKeywordMerchantUid(conn,keyword,start,end); break;
		case "paymentState": list = dao.searchKeywordPaymentState(conn,keyword,start,end); break;
		}
		
		String pageNavi = "";
		int pageNaviSize = 5;
		
		int pageNo = ((reqPage-1)/pageNaviSize)*pageNaviSize+1;	
		
		if(pageNo != 1) {
			pageNavi += "<a class='btn' href='/adminPaymentKeyword?type="+type+"&keyword="+keyword+"&reqPage="+pageNo+"'>이전</a>";
		}
		
		int i = 1;
		
		while(!(i++>pageNaviSize || pageNo>totalPage)) {
			if(reqPage==pageNo) {
				pageNavi += "<span class='selectPage'>"+pageNo+"</span>";
			}else {
				pageNavi += "<a class='btn' href='/adminPaymentKeyword?type="+type+"&keyword="+keyword+"&reqPage="+pageNo+"'>"+pageNo+"</a>";			
			}
			pageNo++;
		}
		
		if(pageNo<=totalPage) {
			pageNavi += "<a class='btn' href='/adminPaymentKeyword?type="+type+"&keyword="+keyword+"&reqPage="+pageNo+"'>다음</a>";
		}
		
		AdminPaymentListPageData aplpd = new AdminPaymentListPageData(list, pageNavi);
		
		JDBCTemplate.close(conn);
		return aplpd;
	}
}
