package kr.co.tomato.sellPage.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import kr.co.tomato.common.JDBCTemplate;
import kr.co.tomato.vo.Review;
import kr.co.tomato.sellPage.model.dao.SellPageDao;
import kr.co.tomato.vo.Favorite;
import kr.co.tomato.vo.Item;
import kr.co.tomato.vo.ItemInquiry;
import kr.co.tomato.vo.Member;

public class SellPageService {
	
	/*조회수 +1*/
	
	public int readcount(int itemNo) {
		Connection conn = JDBCTemplate.getConnection();
		SellPageDao dao = new SellPageDao();
		Item item = dao.sellpage(conn,itemNo);
		int readcount = item.getReadcount()+1;	
			int result = dao.readcount(conn,itemNo,readcount);
			if(result==1) {
				JDBCTemplate.commit(conn);
			}else {
				JDBCTemplate.rollback(conn);
			}return result;
	}
	
	/*전체 상품 테이블 받아오는 service*/
	public Item sellpage(int itemNo) {
		Connection conn = JDBCTemplate.getConnection();
		SellPageDao dao = new SellPageDao();
		Item item = dao.sellpage(conn,itemNo);
			
			if(item.getItemNo() == itemNo) {
				JDBCTemplate.commit(conn);
			}else {
				JDBCTemplate.rollback(conn);
			}
		return item;
	}
	
	/*찜수 불러오기*/
	public void sellPageFavorite(int itemNo,int shopNo,int favoriteCount) {
		Connection conn = JDBCTemplate.getConnection();
		SellPageDao dao = new SellPageDao();
		
		Favorite favorite = dao.checkFavorite(conn,shopNo);
				
		if(shopNo==favorite.getShopNo()) {
			
		}else {
				
		int resultf = dao.insertFavorite(conn,itemNo,shopNo);
		int resultfc = dao.insertFavoriteCount(conn,itemNo,favoriteCount);
		
			if(resultf==1&&resultfc==1) {
				JDBCTemplate.commit(conn);
			}else {
				JDBCTemplate.rollback(conn);
			}
		
		}return;
		
		
		
		
	}

	/*상품문의 저장*/
	public int insertItemInquiry(String textarea,int index, int itemNo,  String memberName,int inquiryLevel) {
		Connection conn = JDBCTemplate.getConnection();
		SellPageDao dao = new SellPageDao();
		
		
		
		ArrayList<ItemInquiry> inquiry = dao.itemInquiry(conn, itemNo);
		for(ItemInquiry itemInquiry : inquiry ) {
			if(itemNo == itemInquiry.getItemRef()) {
				index=itemInquiry.getItemInquiryNo()+1;
			}
		}
		
		
		
		int result = dao.insertItemInquiry(conn,index,textarea,itemNo,memberName,inquiryLevel);
		
		if(result==1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}return result;
		
		
	}

	/*멤버 불러오기*/
	public Member Member(int memberNo) {
		Connection conn = JDBCTemplate.getConnection();
		SellPageDao dao = new SellPageDao();
		
		Member member = dao.Member(conn,memberNo);
		
		if(member!=null) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}return member;
	}




	/*상품문의 불러오기*/
	public ArrayList<ItemInquiry> itemInquiry(int itemNo) {
		Connection conn = JDBCTemplate.getConnection();
		SellPageDao dao = new SellPageDao();
		ArrayList<ItemInquiry>  inquiry = dao.itemInquiry(conn,itemNo);
			if(inquiry!=null) {
				JDBCTemplate.commit(conn);
			}else {
				JDBCTemplate.rollback(conn);
			}return inquiry;
		
	
	}




	/*후기 불러오기*/
	public ArrayList<Review> review(int memberNum) {
		Connection conn = JDBCTemplate.getConnection();
		SellPageDao dao = new SellPageDao();
		
		
		ArrayList<Review> review = dao.review(conn,memberNum); 
		
		if(review!=null) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}return  review;
		
	}

	
	
	/*댓글 삭제*/
	public int deleteItemInquiry(int itemInquiryNo,int itemInquiryLevel,int itemRef) {
		Connection conn = JDBCTemplate.getConnection();
		SellPageDao dao = new SellPageDao();
		
		
		
		int result = dao.deleteItemInquiry(conn,itemInquiryNo,itemInquiryLevel,itemRef);
		
		if(result==1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}return result;
		
	}

	/*후기 저장*/
	public int insertReview(int shopNo, String reviewWriter, String reviewContent, int reviewScore) {
		Connection conn = JDBCTemplate.getConnection();
		SellPageDao dao = new SellPageDao();
		
		ArrayList<Review> review = dao.review(conn,shopNo);
		
		int index=1;
		
		for(Review Review : review ) {
			if(shopNo == Review.getShopNo()) {
				index=Review.getReviewNo()+1;
			}
		}
		
		int result = dao.insertReview(conn,index,shopNo,reviewWriter,reviewContent,reviewScore);
			
		
		if(result==1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}return result;
		
	}

	/*후기 삭제*/
	public int deleteReview(int shopNo, int reviewNo) {
		Connection conn = JDBCTemplate.getConnection();
		SellPageDao dao = new SellPageDao();
		int result =0;
		result =dao.deleteReview(conn,shopNo,reviewNo);
		
		
		
		if(result==1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}return result;
		
		
	}
	/*결제정보 저장*/
	public int insertPayment(String merchantUid, int itemNo, int memberNo, String impUid, int paymentPay,
			int paymentDate, String paymentApplyNum, int commission,String paymentState) {
		Connection conn = JDBCTemplate.getConnection();
		SellPageDao dao = new SellPageDao();
		
		int result =0;
		result =dao.insertPayment(conn,merchantUid,itemNo,memberNo,impUid,paymentPay,paymentDate,paymentApplyNum,commission,paymentState);
			
		if(result==1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}return result;
	}
	
	/*거래정보 저장*/
	public int insertDeal(int buyer, int saler, String dealState,int itemNo ) {
		Connection conn = JDBCTemplate.getConnection();
		SellPageDao dao = new SellPageDao();
		
		int result =0;
		result =dao.insertDeal(conn,buyer,saler,dealState,itemNo);
			
		
			
		if(result==1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}return result;
	}
	
	/*답글 저장*/
	public int insertItemInquiryReply(int itemInquiryNo, int itemRef, int itemInquiryRef, int itemInquiryLevel,
			String itemInquiryWriter, String content) {
		
		Connection conn = JDBCTemplate.getConnection();
		SellPageDao dao = new SellPageDao();
		
		int result =0;
		
		ArrayList<ItemInquiry> inquiry = dao.itemInquiryReply(conn, itemRef,itemInquiryLevel);
		
		if(inquiry!=null) {
			for(ItemInquiry itemInquiry : inquiry ) {
				if(itemRef == itemInquiry.getItemRef()&&itemInquiryLevel==2) {
					
					itemInquiryRef=itemInquiry.getItemInquiryRef()+1;
				}
			}	
		}
		
		
		result = dao.insertInquiryReply(conn,itemInquiryNo,itemRef,itemInquiryRef,itemInquiryLevel,itemInquiryWriter,content);
			
		if(result==1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}return result;
	}

	/*답글삭제*/
	public int deleteItemInquiryReply(int itemReplyNo, int itemReplyRef, int itemReplyLevel, int itemReplyInquiryRef) {
		Connection conn = JDBCTemplate.getConnection();
		SellPageDao dao = new SellPageDao();
		
		int result = dao.deleteItemInquiryReply(conn,itemReplyNo,itemReplyRef, itemReplyLevel,itemReplyInquiryRef);
		
		if(result==1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}return result;
	}

	/*아이템의 판매상태 변경*/
	public int itemStateUpdate(int itemNo) {
		Connection conn = JDBCTemplate.getConnection();
		SellPageDao dao = new SellPageDao();
		
		int result = dao.itemStateUpdate(conn,itemNo);
		
		if(result==1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}return result;
	}
	
	/*사진가져오기*/
	public ArrayList<Item> photoList(int memberNo) {
		Connection conn = JDBCTemplate.getConnection();
		SellPageDao dao = new SellPageDao();
		
		ArrayList<Item> photoList = dao.photoList(conn,memberNo);
			
			if(photoList!=null) {	
			JDBCTemplate.commit(conn);
			}else {
				JDBCTemplate.rollback(conn);
			}return photoList;
			
		

	}
	
	/*admin 상품문의 가져오기*/
	public ArrayList<ItemInquiry> itemInquiryTotal() {
		Connection conn = JDBCTemplate.getConnection();
		SellPageDao dao = new SellPageDao();
		
		ArrayList<ItemInquiry>  inquiry = dao.itemInquiry(conn);
		if(inquiry!=null) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}return inquiry;
	}

	
	

	/*admin 상점후기 가져오기*/
	
	public ArrayList<Review> Review() {
		Connection conn = JDBCTemplate.getConnection();
		SellPageDao dao = new SellPageDao();
		
		
		ArrayList<Review> review = dao.review(conn); 
		
		if(review!=null) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}return  review;
	}
	
	
}
