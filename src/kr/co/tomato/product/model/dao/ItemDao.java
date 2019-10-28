package kr.co.tomato.product.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import kr.co.tomato.common.JDBCTemplate;
import kr.co.tomato.vo.Item;

public class ItemDao {
	public int insertItem(Connection conn, Item i) {
		 PreparedStatement pstmt = null;
	      int result = 0;
	      
	      String query = "INSERT INTO ITEM VALUES(ITEM_NO_SEQ.NEXTVAL, 15, ?, ?, ?, ?, SYSDATE, ?, 0, ?, ?, ?, ?, ?, ?, '거래중')";
	      
	      try {
	         pstmt = conn.prepareStatement(query);
	         pstmt.setString(1, i.getItemName());
	         pstmt.setString(2, i.getItemMainCategory());
	         pstmt.setString(3, i.getItemSubCategoty());
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

	public ArrayList<Item> searchKeywordDealing(Connection conn, String keyword) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT * FROM ITEM WHERE ITEM_NAME = ? and ITEM_DEAL_STATE = '거래중'";
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
		String query = "SELECT * FROM ITEM WHERE ITEM_NAME = ? and ITEM_DEAL_STATE = '판매중'";
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
		String query = "SELECT * FROM ITEM WHERE ITEM_NAME = ? and ITEM_DEAL_STATE = '판매완료'";
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
	
	public ArrayList<Item> buyItem(Connection conn) {
		ArrayList<Item> list = new ArrayList<Item>();
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = "SELECT * FROM ITEM AS I JOIN DEAL AS D ON I.iTEM_NO = D.BUYER";
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			while(rset.next()) {
				Item i = new Item();
				i.setItemThumFilepath(rset.getString("i.item_thum_filepath"));
				i.setItemName(rset.getString("i.item_Name"));
				i.setItemPrice(rset.getInt("i.item_Price"));
				i.setItemEnrollDate(rset.getDate("d.item_Enroll_date"));
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
	
	public ArrayList<Item> sellItem(Connection conn) {
		ArrayList<Item> list = new ArrayList<Item>();
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = "SELECT * FROM ITEM AS I JOIN DEAL AS D ON I.iTEM_NO = D.SALER";
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			while(rset.next()) {
				Item i = new Item();
				i.setItemThumFilepath(rset.getString("i.item_thum_filepath"));
				i.setItemName(rset.getString("i.item_Name"));
				i.setItemPrice(rset.getInt("i.item_Price"));
				i.setItemEnrollDate(rset.getDate("d.item_Enroll_date"));
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
}
