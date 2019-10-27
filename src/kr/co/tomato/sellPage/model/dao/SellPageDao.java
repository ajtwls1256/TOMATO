package kr.co.tomato.sellPage.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.co.tomato.common.JDBCTemplate;
import kr.co.tomato.sellPage.model.vo.Favorite;
import kr.co.tomato.sellPage.model.vo.Item;
import kr.co.tomato.sellPage.model.vo.ItemInquiry;
import kr.co.tomato.sellPage.model.vo.Member;


public class SellPageDao {
	
	/*조회수 +1 dao*/
	public int readcount(Connection conn , int itemNo) {
		PreparedStatement pstmt = null;
		String query = "update item set readcount = readcount_seq.nextval where item_no=?";
		int result=0;
		
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setInt(1, itemNo);
			result=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}return result;
		
		
	}
	
	
	
	/*전체 상품 테이블 받아오는 dao*/
	
	
	
	public Item sellpage(Connection conn , int itemNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Item item = new Item();
		
		String query = "select * from item where item_no = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, itemNo);
			rset =pstmt.executeQuery();
			
			while(rset.next()) {
				
				item.setItemNo(rset.getInt("item_no"));
				item.setMemberNo(rset.getInt("member_no"));
				item.setItemName(rset.getString("item_name"));
				item.setItemMainCategory(rset.getString("item_main_category"));
				item.setItemSubCategory(rset.getString("item_sub_category"));
				item.setItemPrice(rset.getInt("item_price"));
				item.setItemEnrollDate(rset.getDate("item_enroll_date"));
				item.setItemState(rset.getString("item_state"));
				item.setReadcount(rset.getInt("readcount"));
				item.setFavoriteCount(rset.getInt("favorite_count"));
				item.setItemAmount(rset.getInt("item_amount"));
				item.setItemContent(rset.getString("item_content"));
				item.setItemDeliveryNy(rset.getInt("item_delivery_ny"));
				item.setItemDealRegion(rset.getString("item_deal_region"));
				item.setItemThumFilename(rset.getString("item_thum_filename"));
				item.setItemThumFilepath(rset.getString("item_thum_filepath"));
				item.setItemDealState(rset.getString("item_deal_state"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		} 
		
		
		return item;
		
		
	}
	
	/*찜수 받아오기*/
	public Favorite checkFavorite(Connection conn,int shopNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Favorite favorite = new Favorite();
		
		String query = "select * from favorite where item_no = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, shopNo);
			rset =pstmt.executeQuery();
			
			while(rset.next()) {
				favorite.setShopNo(rset.getInt("shop_no"));
					
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		} 
		
		
		return favorite;
		
	}
	/*찜 정보 저장*/
	public int insertFavorite(Connection conn,int itemNo,int shopNo) {
		PreparedStatement pstmt = null;
		int resultf=0;
		
		
		String query = "insert into favorite values(?,?)";
		
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setInt(1, shopNo);
			pstmt.setInt(2, itemNo);
			resultf=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			JDBCTemplate.close(pstmt);
		} 
		
		
		return resultf;
		
	}
	
	
	
	/*찜 수+1*/
	public int insertFavoriteCount(Connection conn,int itemNo,int favoriteCount) {
		PreparedStatement pstmt = null;
		int resultfc=0;
		
		String query = "update item set favorite_count=? where item_no=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, favoriteCount);
			pstmt.setInt(2, itemNo);
			resultfc=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			JDBCTemplate.close(pstmt);
		} 
		return resultfc;
		
	}


	/*상품문의 저장*/
	public int insertItemInquiry(Connection conn, String textarea,int itemNo,String memberName, int inquiryLevel) {
		
		PreparedStatement pstmt = null;
		int result=0;
		
		String query = "insert into item_inquiry values(item_inquiry_no_seq.nextval,?,?,?,sysdate,?,default)";
		
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, memberName);
			pstmt.setInt(2, itemNo);
			pstmt.setString(3, textarea);
			pstmt.setInt(4, inquiryLevel);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}return result;
		
		
	}




	/*상품문의 가져오기*/
	public ArrayList<ItemInquiry> itemInquiry(Connection conn, int itemNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<ItemInquiry> inquiry = new ArrayList<ItemInquiry>();
		
		String query="select * from item_inquiry where item_ref=? ";
		
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setInt(1, itemNo);
			rset=pstmt.executeQuery();
			while(rset.next()) {
				ItemInquiry iteminquiry = new ItemInquiry();
				
				iteminquiry.setItemInquiryNo(rset.getInt("item_inquiry_no"));
				iteminquiry.setItemInquiryWriter(rset.getString("item_inquiry_writer"));
				iteminquiry.setItemRef(rset.getInt("item_ref"));
				iteminquiry.setItemInquiryComment(rset.getString("item_inquiry_comment"));
				iteminquiry.setItemInquiryDate(rset.getDate("item_inquiry_date"));
				iteminquiry.setItemInquiryLevel(rset.getInt("item_inquiry_level"));
				iteminquiry.setItemInquiryRef(rset.getInt("item_inquiry_ref"));
				inquiry.add(iteminquiry);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
			
		}return inquiry;
		
	}



	public int insertItemInquiryReply(Connection conn, int itemInquiryNo, int itemRef, int itemInquiryRef) {

			PreparedStatement pstmt = null;
			int result=0;
			
			String query = "insert into item_inquiry values(item_inquiry_no_seq.nextval,?,?,?,sysdate,?,default)";
			
			try {
				pstmt=conn.prepareStatement(query);
				pstmt.setString(1, memberName);
				pstmt.setInt(2, itemNo);
				pstmt.setString(3, textarea);
				pstmt.setInt(4, inquiryLevel);
				result = pstmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				JDBCTemplate.close(pstmt);
			}return result;
	}



	public ArrayList<ItemInquiry> itemInquiryTotal(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<ItemInquiry> list = new ArrayList<ItemInquiry>();
		
		String query = "select * from Item_Inquiry";
		
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
			 ItemInquiry item = new ItemInquiry();
			 item.setItemInquiryNo(rset.getInt("ITEM_INQUIRY_NO"));
			 item.setItemInquiryWriter(rset.getString("ITEM_INQUIRY_WRITER"));
			 item.setItemRef(rset.getInt("ITEM_REF"));
			 item.setItemInquiryComment(rset.getString("ITEM_INQUIRY_COMMENT"));
			 item.setItemInquiryDate(rset.getDate("ITEM_INQUIRY_DATE"));
			 item.setItemInquiryLevel(rset.getInt("ITEM_INQUIRY_LEVEL"));
			 item.setItemInquiryRef(rset.getInt("ITEM_INQUIRY_REF"));
			 list.add(item);
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
	
	
	
	
	
	
	
	
	
	
	
}
