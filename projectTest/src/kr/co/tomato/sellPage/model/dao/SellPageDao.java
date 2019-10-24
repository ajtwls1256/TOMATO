package kr.co.tomato.sellPage.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.co.tomato.common.JDBCTemplate;
import kr.co.tomato.vo.Favorite;
import kr.co.tomato.vo.Item;
import kr.co.tomato.vo.ItemInquiry;


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


	/*상품문의 가져오기*/
	/*public ArrayList<ItemInquiry> itemInquiry(Connection conn, int itemNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<ItemInquiry> inquiry = new ArrayList<ItemInquiry>();
		
		String query="select * from item_inquiry where item_inquiry_no=? ";
		
		
		
	}*/
	
	
	
	
	
	
	
	
	
	
	
}
