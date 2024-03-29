﻿package kr.co.tomato.product.model.dao;

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
	      

	      String query = "INSERT INTO ITEM VALUES(ITEM_NO_SEQ.NEXTVAL, ?, ?, ?, ?, ?, SYSDATE, ?, 0, ?, ?, ?, ?, ?, ?, '판매중', 0)";

	      
	      try {
	         pstmt = conn.prepareStatement(query);
	         pstmt.setInt(1, i.getMemberNo());
	         pstmt.setString(2, i.getItemName());
	         pstmt.setString(3, i.getItemMainCategory());
	         pstmt.setString(4, i.getItemSubCategory());
	         pstmt.setInt(5, i.getItemPrice());
	         pstmt.setString(6, i.getItemState());
	         pstmt.setString(7, i.getItemContent());
	         pstmt.setInt(8, i.getItemAmount());
	         pstmt.setInt(9, i.getItemDeliveryNY());
	         pstmt.setString(10, i.getItemDealRegion());
	         pstmt.setString(11, i.getItemThumFilename());
	         pstmt.setString(12, i.getItemThumFilepath());
	         if(i.getItemThumFilename()==null) {
	        	 pstmt.setString(11, "default_img.jpg");
	        	 pstmt.setString(12, "default_img.jpg");
	         }
	         result = pstmt.executeUpdate();
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         JDBCTemplate.close(pstmt);
	      }
	      
	      return result;
	}

	public ArrayList<Item> selectAll(Connection conn, int memberNo) {
		ArrayList<Item> list = new ArrayList<Item>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from item where member_No=? and item_deal_state not like '판매완료'";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, memberNo);
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
	
	public ArrayList<BuySellItem> buyItem(Connection conn, int memberNo) {
		ArrayList<BuySellItem> list = new ArrayList<BuySellItem>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "SELECT * FROM ITEM I INNER JOIN DEAL D ON I.MEMBER_NO = D.BUYER AND I.ITEM_NO = D.ITEM_NO AND DEAL_STATE = '거래완료' WHERE MEMBER_NO = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, memberNo);
			rset = pstmt.executeQuery();
			
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
			JDBCTemplate.close(pstmt);
		}
		
		return list;
	}
	
	public ArrayList<BuySellItem> sellItem(Connection conn, int memberNo) {
		ArrayList<BuySellItem> list = new ArrayList<BuySellItem>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "SELECT * FROM ITEM I INNER JOIN DEAL D ON I.MEMBER_NO = D.SALER AND I.ITEM_NO = D.ITEM_NO AND DEAL_STATE = '거래완료' WHERE MEMBER_NO = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, memberNo);
			rset = pstmt.executeQuery();
			
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

	public Item selectOne(Connection conn, int itemNo, int memberNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Item i = null;
		String query = "SELECT * FROM ITEM WHERE ITEM_NO = ? AND MEMBER_NO = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, itemNo);
			pstmt.setInt(2, memberNo);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				i = new Item();
				i.setItemNo(itemNo);
				i.setItemNo(memberNo);
				i.setItemThumFilename(rset.getString("FILENAME"));
				i.setItemThumFilepath(rset.getString("FILEPATH"));
				i.setItemDealState(rset.getString("ITEM_DEAL_STATE"));
				i.setItemName(rset.getString("ITEM_NAME"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
			
		}
		return i;
	}

	public int readCount(Connection conn, int itemNo, int memberNo) {
		PreparedStatement pstmt = null;
		int result = -1;
		
		String query = "UPDATE ITEM SET READCOUNT = (READCOUNT + 1) WHERE ITEM_NO = ? AND MEMBER_NO = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, itemNo);
			pstmt.setInt(2, memberNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int itemModify(Connection conn, Item i) {
		PreparedStatement pstmt = null;
	      int result = 0;

	      String query = "UPDATE ITEM SET ITEM_THUM_FILEPATH = ?, ITEM_DEAL_STATE = ?, ITEM_NAME = ? ITEM_PRICE = ? WHERE ITEM_NO = ?";
	      
	      try {
	         pstmt = conn.prepareStatement(query);
	         pstmt.setString(1, i.getItemThumFilepath());
	         pstmt.setString(2, i.getItemDealState());
	         pstmt.setString(2, i.getItemName());
	         pstmt.setInt(5, i.getItemPrice());
	         result = pstmt.executeUpdate();
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         JDBCTemplate.close(pstmt);
	      }
	      return result;
	}
}
