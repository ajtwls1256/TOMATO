package kr.co.tomato.admin.adminItem.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.co.tomato.common.JDBCTemplate;
import kr.co.tomato.sellPage.model.vo.ItemInquiry;
import kr.co.tomato.vo.Item;
import kr.co.tomato.vo.Review;

public class AdminMdDao {
	public ArrayList<Item> adminMdList(Connection conn, int start, int end) {
		ArrayList<Item> list = new ArrayList<Item>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from "
				+ "(select ROWNUM as rnum, n.* from"
				+ "(select * from item order by item_no desc) n) "
				+ "where rnum between ? and ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				int rnum = rset.getInt("rnum");
				int itemNo = rset.getInt("item_no");
				int memberNo = rset.getInt("member_no");
				String itemName = rset.getString("item_name");
				String itemMainCategory = rset.getString("item_main_category");
				String itemSubCategoty = rset.getString("item_sub_category");
				int itemPrice = rset.getInt("item_price");
				Date itemEnrollDate = rset.getDate("item_enroll_date");
				String itemState = rset.getString("item_state");
				int readcount = rset.getInt("readcount");
				String itemContent = rset.getString("item_content");
				int itemAmount = rset.getInt("item_amount");
				int itemDeliveryNY = rset.getInt("item_delivery_ny");
				String itemDealRegion = rset.getString("item_deal_region");
				String itemThumFilename = rset.getString("item_thum_filename");
				String itemThumFilepath = rset.getString("item_thum_filepath");
				String itemDealState = rset.getString("item_deal_state");
				Item i = new Item(rnum, itemNo, memberNo, itemName, itemMainCategory, itemSubCategoty, itemPrice, itemEnrollDate, itemState, readcount, itemContent, itemAmount, itemDeliveryNY, itemDealRegion, itemThumFilename, itemThumFilepath, itemDealState);
						
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

	public int totalCount(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select count(*) as total from item";
		int result = 0;
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				result = rset.getInt("total");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
	public int adminMdUpdate(Connection conn, int itemNo, String itemState, String itemDealState) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "update item set item_state = ?, item_deal_state = ? where item_no = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, itemState);
			pstmt.setString(2, itemDealState);
			pstmt.setInt(3, itemNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
	public int itemNoTotalCount(Connection conn, String keyword) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select count(*) as total from item where item_no like (?)";
		int result = 0;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+keyword+"%");
			rset = pstmt.executeQuery();
			if(rset.next()) {
				result = rset.getInt("total");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int memberNoTotalCount(Connection conn, String keyword) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select count(*) as total from item where member_no like (?)";
		int result = 0;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+keyword+"%");
			rset = pstmt.executeQuery();
			if(rset.next()) {
				result = rset.getInt("total");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int itemNameTotalCount(Connection conn, String keyword) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select count(*) as total from item where item_name like (?)";
		int result = 0;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+keyword+"%");
			rset = pstmt.executeQuery();
			if(rset.next()) {
				result = rset.getInt("total");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int itemDealStateTotalCount(Connection conn, String keyword) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select count(*) as total from item where item_deal_state like (?)";
		int result = 0;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+keyword+"%");
			rset = pstmt.executeQuery();
			if(rset.next()) {
				result = rset.getInt("total");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	
	
	
	
	
	public ArrayList<Item> searchKeywordItemNo(Connection conn, String keyword, int start, int end) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from (select ROWNUM as rnum, n.* from" 
				+ "(select * from item where item_no like (?) order by item_no desc)n)"  
				+ "where rnum between ? and ?" ;
		ArrayList<Item> list = new ArrayList<Item>();
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+keyword+"%");
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Item i = new Item();
				i.setRnum(rset.getInt("rnum"));
				i.setItemNo(rset.getInt("item_no"));
				i.setMemberNo(rset.getInt("member_no"));
				i.setItemName(rset.getString("item_name"));
				i.setItemMainCategory(rset.getString("item_main_category"));
				i.setItemSubCategory(rset.getString("item_sub_category"));
				i.setItemPrice(rset.getInt("item_price"));
				i.setItemEnrollDate(rset.getDate("item_enroll_date"));
				i.setItemState(rset.getString("item_state"));
				i.setReadcount(rset.getInt("readcount"));
				i.setItemContent(rset.getString("item_content"));
				i.setItemAmount(rset.getInt("item_amount"));
				i.setItemDeliveryNY(rset.getInt("item_delivery_ny"));
				i.setItemDealRegion(rset.getString("item_deal_region"));
				i.setItemThumFilename(rset.getString("item_thum_filename"));
				i.setItemThumFilepath(rset.getString("item_thum_filepath"));
				i.setItemDealState(rset.getString("item_deal_state"));
				list.add(i);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	public ArrayList<Item> searchKeywordMemberNo(Connection conn, String keyword, int start, int end) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from (select ROWNUM as rnum, n.* from" 
				+ "(select * from item where member_no like (?) order by item_no desc)n)"  
				+ "where rnum between ? and ?" ;
		ArrayList<Item> list = new ArrayList<Item>();
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+keyword+"%");
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Item i = new Item();
				i.setRnum(rset.getInt("rnum"));
				i.setItemNo(rset.getInt("item_no"));
				i.setMemberNo(rset.getInt("member_no"));
				i.setItemName(rset.getString("item_name"));
				i.setItemMainCategory(rset.getString("item_main_category"));
				i.setItemSubCategory(rset.getString("item_sub_category"));
				i.setItemPrice(rset.getInt("item_price"));
				i.setItemEnrollDate(rset.getDate("item_enroll_date"));
				i.setItemState(rset.getString("item_state"));
				i.setReadcount(rset.getInt("readcount"));
				i.setItemContent(rset.getString("item_content"));
				i.setItemAmount(rset.getInt("item_amount"));
				i.setItemDeliveryNY(rset.getInt("item_delivery_ny"));
				i.setItemDealRegion(rset.getString("item_deal_region"));
				i.setItemThumFilename(rset.getString("item_thum_filename"));
				i.setItemThumFilepath(rset.getString("item_thum_filepath"));
				i.setItemDealState(rset.getString("item_deal_state"));
				list.add(i);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	public ArrayList<Item> searchKeywordItemName(Connection conn, String keyword, int start, int end) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from (select ROWNUM as rnum, n.* from" 
				+ "(select * from item where item_name like (?) order by item_no desc)n)"  
				+ "where rnum between ? and ?" ;
		ArrayList<Item> list = new ArrayList<Item>();
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+keyword+"%");
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Item i = new Item();
				i.setRnum(rset.getInt("rnum"));
				i.setItemNo(rset.getInt("item_no"));
				i.setMemberNo(rset.getInt("member_no"));
				i.setItemName(rset.getString("item_name"));
				i.setItemMainCategory(rset.getString("item_main_category"));
				i.setItemSubCategory(rset.getString("item_sub_category"));
				i.setItemPrice(rset.getInt("item_price"));
				i.setItemEnrollDate(rset.getDate("item_enroll_date"));
				i.setItemState(rset.getString("item_state"));
				i.setReadcount(rset.getInt("readcount"));
				i.setItemContent(rset.getString("item_content"));
				i.setItemAmount(rset.getInt("item_amount"));
				i.setItemDeliveryNY(rset.getInt("item_delivery_ny"));
				i.setItemDealRegion(rset.getString("item_deal_region"));
				i.setItemThumFilename(rset.getString("item_thum_filename"));
				i.setItemThumFilepath(rset.getString("item_thum_filepath"));
				i.setItemDealState(rset.getString("item_deal_state"));
				list.add(i);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	public ArrayList<Item> searchKeywordItemDealState(Connection conn, String keyword, int start, int end) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from (select ROWNUM as rnum, n.* from" 
				+ "(select * from item where item_deal_state like (?) order by item_no desc)n)"  
				+ "where rnum between ? and ?" ;
		ArrayList<Item> list = new ArrayList<Item>();
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+keyword+"%");
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Item i = new Item();
				i.setRnum(rset.getInt("rnum"));
				i.setItemNo(rset.getInt("item_no"));
				i.setMemberNo(rset.getInt("member_no"));
				i.setItemName(rset.getString("item_name"));
				i.setItemMainCategory(rset.getString("item_main_category"));
				i.setItemSubCategory(rset.getString("item_sub_category"));
				i.setItemPrice(rset.getInt("item_price"));
				i.setItemEnrollDate(rset.getDate("item_enroll_date"));
				i.setItemState(rset.getString("item_state"));
				i.setReadcount(rset.getInt("readcount"));
				i.setItemContent(rset.getString("item_content"));
				i.setItemAmount(rset.getInt("item_amount"));
				i.setItemDeliveryNY(rset.getInt("item_delivery_ny"));
				i.setItemDealRegion(rset.getString("item_deal_region"));
				i.setItemThumFilename(rset.getString("item_thum_filename"));
				i.setItemThumFilepath(rset.getString("item_thum_filepath"));
				i.setItemDealState(rset.getString("item_deal_state"));
				list.add(i);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	public int adminMdListDelete(Connection conn, int itemNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "delete from item where item_no=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, itemNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public Review AjaxReview(Connection conn, int no) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Review r = null;
		
		String query = "select * from review where REVIEW_NO = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, no);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				r = new Review();
				r.setReviewNo(rset.getInt("REVIEW_NO"));
				r.setShopNo(rset.getInt("SHOP_NO"));
				r.setReviewWriter(rset.getString("REVIEW_WRITER"));
				r.setReviewDate(rset.getDate("REVIEW_DATE"));
				r.setReviewContent(rset.getString("REVIEW_CONTENT"));
				r.setReviewScore(rset.getInt("REVIEW_SCORE"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
			
		}
		
				
		
		return r;
	}

	public int reviewDelete(Connection conn, int no) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "delete from review where review_no=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, no);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public ItemInquiry AjaxQuestion(Connection conn, int no) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ItemInquiry r = null;
		
		String query = "select * from Item_Inquiry where ITEM_INQUIRY_NO = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, no);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				r = new ItemInquiry();
				r.setItemInquiryNo(rset.getInt("ITEM_INQUIRY_NO"));
				r.setItemInquiryWriter(rset.getString("ITEM_INQUIRY_WRITER"));
				r.setItemRef(rset.getInt("ITEM_REF"));
				r.setItemInquiryComment(rset.getString("ITEM_INQUIRY_COMMENT"));
				r.setItemInquiryDate(rset.getDate("ITEM_INQUIRY_DATE"));
				r.setItemInquiryLevel(rset.getInt("ITEM_INQUIRY_LEVEL"));
				r.setItemInquiryRef(rset.getInt("ITEM_INQUIRY_REF"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
			
		}
		
				
		
		return r;
	}

	public int AdminMDQuestionDelete(Connection conn, int no) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "delete from Item_Inquiry where ITEM_INQUIRY_NO=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, no);
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
