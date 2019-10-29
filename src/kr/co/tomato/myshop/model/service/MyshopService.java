package kr.co.tomato.myshop.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import kr.co.tomato.common.JDBCTemplate;
import kr.co.tomato.member.model.vo.Member;
import kr.co.tomato.myshop.model.dao.MyshopDao;
import kr.co.tomato.myshop.model.vo.DealItem;
import kr.co.tomato.myshop.model.vo.MyshopData;
import kr.co.tomato.myshop.model.vo.Review;
import kr.co.tomato.sellPage.model.vo.Item;

public class MyshopService {
	
	public MyshopData selectMyshop(String email,int memberNo) {
		Connection conn = JDBCTemplate.getConnection();
		MyshopDao dao = new MyshopDao();
		Member mem = dao.selectOne(conn, email);
		ArrayList<Item> iList = dao.selectItems(conn,email); 
		ArrayList<DealItem> dList = dao.selectDealItems(conn, memberNo);
		ArrayList<Item> fList = dao.selectFavoriteItems(conn, memberNo);
		ArrayList<Review> rList = dao.selectShopReview(conn,memberNo);
		MyshopData data = new MyshopData(mem, iList, dList, fList, rList);
		JDBCTemplate.close(conn);
		return data;
	}

	public int updateShopName(String shopName, String updateShopName) {
		Connection conn = JDBCTemplate.getConnection();
		MyshopDao dao = new MyshopDao();
		int result = dao.updateShopName(conn, shopName, updateShopName);
		JDBCTemplate.close(conn);
		return result;
	}

	public int updateShopContent(String shopName, String shopContent) {
		Connection conn = JDBCTemplate.getConnection();
		MyshopDao dao = new MyshopDao();
		int result = dao.updateShopContent(conn, shopName, shopContent);
		JDBCTemplate.close(conn);
		return result;
	}

	public int deleteFavorite(String shopNo, String itemNo) {
		Connection conn = JDBCTemplate.getConnection();
		MyshopDao dao = new MyshopDao();
		int result = dao.deleteFavorite(conn, shopNo, itemNo);
		JDBCTemplate.close(conn);
		return result;
	}
	
	// 상품 구매 확정
	public int updateBuyState(String dealItemNo) {
		Connection conn = JDBCTemplate.getConnection();
		MyshopDao dao = new MyshopDao();
		int result = 0;
		String state="판매완료";
		int result1 = dao.updateDealState(conn, dealItemNo, state);
		int result2 = dao.updateItemDealState(conn, dealItemNo, state);
		result = result1+result2;
		JDBCTemplate.close(conn);
		return result;
	}

	// 상품 반품 신청
	public int updateBuyReturnState(String dealItemNo) {
		Connection conn = JDBCTemplate.getConnection();
		MyshopDao dao = new MyshopDao();
		int result = 0;
		String state="판매중";
		int result1 = dao.updateDealState(conn, dealItemNo, state);
		int result2 = dao.updateItemDealState(conn, dealItemNo, state);
		result = result1+result2;
		JDBCTemplate.close(conn);
		return result;
	}

	public int updateMyshopReadcount(int memberNo, int shopReadCount) {
		Connection conn = JDBCTemplate.getConnection();
		MyshopDao dao = new MyshopDao();
		int result = dao.updateMyshopReadcount(conn, memberNo,shopReadCount);
		JDBCTemplate.close(conn);
		return result;
	}
	
	

}
