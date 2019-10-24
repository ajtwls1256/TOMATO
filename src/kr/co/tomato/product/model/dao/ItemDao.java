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
}
