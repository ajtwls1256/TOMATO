package kr.co.tomato.product.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import kr.co.tomato.common.JDBCTemplate;
import kr.co.tomato.vo.BuySellItem;
import kr.co.tomato.vo.Item;

public class ItemDao {
	public int insertItem(Connection conn, Item i) {
		 PreparedStatement pstmt = null;
	      int result = 0;
	      

	      String query = "INSERT INTO ITEM VALUES(ITEM_NO_SEQ.NEXTVAL, 15, ?, ?, ?, ?, SYSDATE, ?, 0, ?, ?, ?, ?, ?, ?, '거래중', 0)";

	      
	      try {
	         pstmt = conn.prepareStatement(query);
	         pstmt.setString(1, i.getItemName());
	         pstmt.setString(2, i.getItemMainCategory());
	         pstmt.setString(3, i.getItemSubCategory());
	         pstmt.setInt(4, i.getItemPrice());
	         pstmt.setString(5, i.getItemState());
	         pstmt.setString(6, i.getItemContent());
	         pstmt.setInt(7, i.getItemAmount());
	         pstmt.setInt(8, i.getItemDeliveryNY());
	         pstmt.setString(9, i.getItemDealRegion());
	         pstmt.setString(10, i.getItemThumFilename());
	         pstmt.setString(11, i.getItemThumFilepath());
	         result = pstmt.executeUpdate();
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         JDBCTemplate.close(pstmt);
	      }
	      
	      return result;
	}

	public ArrayList<Item> selectAll(Connection conn) {
		ArrayList<Item> list = new ArrayList<Item>();
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = "select * from item";
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			while(rset.next()) {
				Item i = new Item();
				i.setItemNo(rset.getInt("item_no"));
				i.setItemThumFilepath(rset.getString("item_thum_filepath"));
				i.setItemDealState(rset.getString("item_deal_State"));
				i.setItemName(rset.getString("item_Name"));
				i.setItemPrice(rset.getInt("item_Price"));
				i.setItemEnrollDate(rset.getDate("item_Enroll_date"));
				list.add(i);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}
		
		return list;
	}

	public int deleteItem(Connection conn, int itemNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "delete from item where item_no = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, itemNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
	public ArrayList<Item> searchKeywordAll(Connection conn, String keyword) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT * FROM ITEM WHERE ITEM_NAME LIKE ?";
		ArrayList<Item> list = new ArrayList<Item>();
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+keyword+"%");
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Item i = new Item();
				i.setItemNo(rset.getInt("item_no"));
				i.setItemThumFilepath(rset.getString("item_thum_filepath"));
				i.setItemDealState(rset.getString("item_deal_State"));
				i.setItemName(rset.getString("item_Name"));
				i.setItemPrice(rset.getInt("item_Price"));
				i.setItemEnrollDate(rset.getDate("item_Enroll_date"));
				list.add(i);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}
	

	public ArrayList<Item> searchKeywordDealing(Connection conn, String keyword) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT * FROM ITEM WHERE ITEM_DEAL_STATE = '거래중' and ITEM_NAME LIKE ?";
		ArrayList<Item> list = new ArrayList<Item>();
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+keyword+"%");
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Item i = new Item();
				i.setItemNo(rset.getInt("item_no"));
				i.setItemThumFilepath(rset.getString("item_thum_filepath"));
				i.setItemDealState(rset.getString("item_deal_State"));
				i.setItemName(rset.getString("item_Name"));
				i.setItemPrice(rset.getInt("item_Price"));
				i.setItemEnrollDate(rset.getDate("item_Enroll_date"));
				list.add(i);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	public ArrayList<Item> searchKeywordOnsale(Connection conn, String keyword) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT * FROM ITEM WHERE ITEM_DEAL_STATE = '판매중' and ITEM_NAME LIKE ?";
		ArrayList<Item> list = new ArrayList<Item>();
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+keyword+"%");
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Item i = new Item();
				i.setItemNo(rset.getInt("item_no"));
				i.setItemThumFilepath(rset.getString("item_thum_filepath"));
				i.setItemDealState(rset.getString("item_deal_State"));
				i.setItemName(rset.getString("item_Name"));
				i.setItemPrice(rset.getInt("item_Price"));
				i.setItemEnrollDate(rset.getDate("item_Enroll_date"));
				list.add(i);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	public ArrayList<Item> searchKeywordsold(Connection conn, String keyword) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT * FROM ITEM WHERE ITEM_DEAL_STATE = '판매완료' and ITEM_NAME LIKE ?";
		ArrayList<Item> list = new ArrayList<Item>();
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+keyword+"%");
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Item i = new Item();
				i.setItemNo(rset.getInt("item_no"));
				i.setItemThumFilepath(rset.getString("item_thum_filepath"));
				i.setItemDealState(rset.getString("item_deal_State"));
				i.setItemName(rset.getString("item_Name"));
				i.setItemPrice(rset.getInt("item_Price"));
				i.setItemEnrollDate(rset.getDate("item_Enroll_date"));
				list.add(i);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}
	
	public ArrayList<BuySellItem> buyItem(Connection conn) {
		ArrayList<BuySellItem> list = new ArrayList<BuySellItem>();
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = "SELECT * FROM ITEM I INNER JOIN DEAL D ON I.MEMBER_NO = D.BUYER AND I.ITEM_NO = D.ITEM_NO AND DEAL_STATE = '판매완료'";
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			while(rset.next()) {
				BuySellItem bsi = new BuySellItem();
				bsi.setItemThumFilepath(rset.getString("item_thum_filepath"));
				bsi.setItemName(rset.getString("item_Name"));
				bsi.setItemPrice(rset.getInt("item_Price"));
				bsi.setDealEndDate(rset.getDate("deal_End_date"));
				list.add(bsi);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}
		
		return list;
	}
	
	public ArrayList<BuySellItem> sellItem(Connection conn) {
		ArrayList<BuySellItem> list = new ArrayList<BuySellItem>();
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = "SELECT * FROM ITEM I INNER JOIN DEAL D ON I.MEMBER_NO = D.SALER AND I.ITEM_NO = D.ITEM_NO AND DEAL_STATE = '판매완료'";
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			while(rset.next()) {
				BuySellItem bsi = new BuySellItem();
				bsi.setItemThumFilepath(rset.getString("item_thum_filepath"));
				bsi.setItemName(rset.getString("item_Name"));
				bsi.setItemPrice(rset.getInt("item_Price"));
				bsi.setDealEndDate(rset.getDate("deal_End_date"));
				list.add(bsi);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
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
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public ArrayList<Item> selectList(Connection conn, int start, int end) {
		ArrayList<Item> list = new ArrayList<Item>();
		Item i = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from "
				+ "(select ROWNUM as rnum, n.*from"
				+ "(select * from item order by item_no desc)n)"
				+ "where rnum between ? and ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				i = new Item();
				i.setItemNo(rset.getInt("item_no"));
				i.setItemThumFilepath(rset.getString("item_thum_filepath"));
				i.setItemDealState(rset.getString("item_deal_State"));
				i.setItemName(rset.getString("item_Name"));
				i.setItemPrice(rset.getInt("item_Price"));
				i.setItemEnrollDate(rset.getDate("item_Enroll_date"));
				list.add(i);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}
}
