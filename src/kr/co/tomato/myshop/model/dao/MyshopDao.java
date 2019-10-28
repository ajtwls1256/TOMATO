package kr.co.tomato.myshop.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.co.tomato.common.JDBCTemplate;
import kr.co.tomato.member.model.vo.Member;
import kr.co.tomato.myshop.model.vo.DealItem;
import kr.co.tomato.myshop.model.vo.Review;
import kr.co.tomato.sellPage.model.vo.Item;

public class MyshopDao {

	public Member selectOne(Connection conn, String checkEmail) {
		Member m = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from member where email=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, checkEmail);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				m = new Member();
				m.setAddress(rset.getString("address"));
				m.setEmail(rset.getString("email"));
				m.setEnrollDate(rset.getDate("enroll_date"));
				m.setFileName(rset.getString("file_name"));
				m.setFilePath(rset.getString("file_path"));
				m.setMemberAccount(rset.getString("member_account"));
				m.setMemberName(rset.getString("member_name"));
				m.setMemberNo(rset.getInt("member_no"));
				m.setMemberPw(rset.getString("member_pw"));
				m.setPhone(rset.getString("phone"));
				m.setShopContent(rset.getString("shop_content"));
				m.setShopName(rset.getString("shop_name"));
				m.setShopReadcount(rset.getInt("shop_readcount"));	
				m.setZipCode(rset.getString("zip_code"));
				m.setMemberBank(rset.getString("member_bank"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return m;
	}

	public ArrayList<Item> selectItems(Connection conn, String email) {
		ArrayList<Item> list = new ArrayList<Item>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from item where MEMBER_NO = (select member_no from member where email = ?) and item_deal_state='판매중'";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, email);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Item i = new Item();
				i.setFavoriteCount(rset.getInt("favorite_count"));
				i.setItemAmount(rset.getInt("ITEM_AMOUNT"));
				i.setItemContent(rset.getString("ITEM_CONTENT"));
				i.setItemDealRegion(rset.getString("ITEM_DEAL_REGION"));
				i.setItemDealState(rset.getString("ITEM_DEAL_STATE"));
				i.setItemDeliveryNy(rset.getInt("ITEM_DELIVERY_NY"));
				i.setItemEnrollDate(rset.getDate("ITEM_ENROLL_DATE"));
				i.setItemMainCategory(rset.getString("ITEM_MAIN_CATEGORY"));
				i.setItemName(rset.getString("ITEM_NAME"));
				i.setItemNo(rset.getInt("ITEM_NO"));
				i.setItemPrice(rset.getInt("ITEM_PRICE"));
				i.setItemState(rset.getString("ITEM_STATE"));
				i.setItemSubCategory(rset.getString("ITEM_SUB_CATEGORY"));
				i.setItemThumFilename(rset.getString("ITEM_THUM_FILENAME"));
				i.setItemThumFilepath(rset.getString("ITEM_THUM_FILEPATH"));
				i.setMemberNo(rset.getInt("MEMBER_NO"));
				i.setReadcount(rset.getInt("READCOUNT"));
				list.add(i);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);	
		}
		return list;
	}
	
	public ArrayList<DealItem> selectDealItems(Connection conn, int memberNo) {
		ArrayList<DealItem> list = new ArrayList<DealItem>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select DISTINCT item.item_no, item.item_name, item.item_thum_filename, item.item_thum_filepath, payment.payment_date, payment.payment_pay,member.shop_name, member.member_no from item left outer join member on member.member_No=item.member_no left outer join deal on item.member_No=SALER left outer join payment on payment.item_no = item.item_no where item.item_deal_state='거래중' and deal.buyer=? and payment.member_no=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, memberNo);
			pstmt.setInt(2, memberNo);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				DealItem dItem = new DealItem();
				dItem.setItemName(rset.getString("item_name"));
				dItem.setItemNo(rset.getInt("item_no"));
				dItem.setItemThumFilename(rset.getString("item_thum_filename"));
				dItem.setItemThumFilepath(rset.getString("item_thum_filepath"));
				dItem.setMemberNo(rset.getInt("member_no"));
				dItem.setPaymentDate(rset.getDate("payment_date"));
				dItem.setShopName(rset.getString("shop_name"));
				dItem.setPaymentPay(rset.getInt("payment_pay"));
				list.add(dItem);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);	
		}
		return list;
	}
	
	public ArrayList<Item> selectFavoriteItems(Connection conn, int memberNo) {
		ArrayList<Item> fList = new ArrayList<Item>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select item.* from item left outer join favorite on item.item_no=favorite.item_no where favorite.shop_no=? and item.item_deal_state='판매중'";
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setInt(1, memberNo);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Item f = new Item();
				f.setFavoriteCount(rset.getInt("favorite_count"));
				f.setItemAmount(rset.getInt("ITEM_AMOUNT"));
				f.setItemContent(rset.getString("ITEM_CONTENT"));
				f.setItemDealRegion(rset.getString("ITEM_DEAL_REGION"));
				f.setItemDealState(rset.getString("ITEM_DEAL_STATE"));
				f.setItemDeliveryNy(rset.getInt("ITEM_DELIVERY_NY"));
				f.setItemEnrollDate(rset.getDate("ITEM_ENROLL_DATE"));
				f.setItemMainCategory(rset.getString("ITEM_MAIN_CATEGORY"));
				f.setItemName(rset.getString("ITEM_NAME"));
				f.setItemNo(rset.getInt("ITEM_NO"));
				f.setItemPrice(rset.getInt("ITEM_PRICE"));
				f.setItemState(rset.getString("ITEM_STATE"));
				f.setItemSubCategory(rset.getString("ITEM_SUB_CATEGORY"));
				f.setItemThumFilename(rset.getString("ITEM_THUM_FILENAME"));
				f.setItemThumFilepath(rset.getString("ITEM_THUM_FILEPATH"));
				f.setMemberNo(rset.getInt("MEMBER_NO"));
				f.setReadcount(rset.getInt("READCOUNT"));
				fList.add(f);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);	
		}
		return fList;
	}
	
	public ArrayList<Review> selectShopReview(Connection conn, int memberNo) {
		ArrayList<Review> list = new ArrayList<Review>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from review where shop_no=?";
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setInt(1, memberNo);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Review r = new Review();
				r.setReviewContent(rset.getString("REVIEW_CONTENT"));
				r.setReviewDate(rset.getDate("REVIEW_DATE"));
				r.setReviewNo(rset.getInt("REVIEW_NO"));
				r.setReviewScore(rset.getInt("REVIEW_SCORE"));
				r.setReviewWriter(rset.getString("REVIEW_WRITER"));
				r.setShopNo(rset.getInt("SHOP_NO"));
				list.add(r);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);	
		}
		return list;
	}

	public int updateShopName(Connection conn, String shopName, String updateShopName) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "update member set shop_name=? where shop_name=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, updateShopName);
			pstmt.setString(2, shopName);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);	
		}
		return result;
	}

	public int updateShopContent(Connection conn, String shopName, String shopContent) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "update member set shop_content=? where shop_name=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, shopContent);
			pstmt.setString(2, shopName);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);	
		}
		return result;
	}

	public int deleteFavorite(Connection conn, String shopNo, String itemNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "delete from favorite where shop_no=? and item_no=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, shopNo);
			pstmt.setString(2, itemNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);	
		}
		return result;
	}

	public int updateDealState(Connection conn, String dealItemNo, String state) {
		int result = 0;
		PreparedStatement pstmt = null;
		state="거래취소";
		String query = "update deal set deal_state=? where item_no=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, state);
			pstmt.setString(2, dealItemNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);	
		}
		return result;
	}
	
	public int updateItemDealState(Connection conn, String dealItemNo, String state) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "update item set item_deal_state=? where item_no=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, state);
			pstmt.setString(2, dealItemNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);	
		}
		return result;
	}
}
