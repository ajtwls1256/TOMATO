package kr.co.tomato.sellPage.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import kr.co.tomato.common.JDBCTemplate;
import kr.co.tomato.sellPage.model.dao.SellPageDao;
import kr.co.tomato.sellPage.model.vo.Favorite;
import kr.co.tomato.sellPage.model.vo.Item;
import kr.co.tomato.sellPage.model.vo.ItemInquiry;
import kr.co.tomato.sellPage.model.vo.Member;

public class SellPageService {
	
	/*전체 상품 테이블 받아오는 service*/
	
	public int readcount(int itemNo) {
		Connection conn = JDBCTemplate.getConnection();
		SellPageDao dao = new SellPageDao();
			int result = dao.readcount(conn,itemNo);
			if(result==1) {
				JDBCTemplate.commit(conn);
			}else {
				JDBCTemplate.rollback(conn);
			}return result;
	}
	
	
	public Item sellpage(int itemNo) {
		Connection conn = JDBCTemplate.getConnection();
		SellPageDao dao = new SellPageDao();
			Item item = dao.sellpage(conn,itemNo);
			
			if(item.getItemNo() == itemNo) {
				JDBCTemplate.commit(conn);
			}else {
				JDBCTemplate.rollback(conn);
			}return item;
			
			
	}
	
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


	public int insertItemInquiry(String textarea, int itemNo, String memberName,int inquiryLevel) {
		Connection conn = JDBCTemplate.getConnection();
		SellPageDao dao = new SellPageDao();
		
		Item item = dao.sellpage(conn, itemNo);
		
		int result = dao.insertItemInquiry(conn,textarea,item,memberName,inquiryLevel);
		
		if(result==1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}return result;
		
		
	}


	


	public ArrayList<ItemInquiry> itemInquiry(int itemNo) {
		Connection conn = JDBCTemplate.getConnection();
		SellPageDao dao = new SellPageDao();
		ArrayList<ItemInquiry> inquiry = dao.itemInquiry(conn,itemNo);
			if(inquiry!=null) {
				JDBCTemplate.commit(conn);
			}else {
				JDBCTemplate.rollback(conn);
			}return inquiry;
		
		
	}
	
}
