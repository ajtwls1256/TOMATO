package kr.co.tomato.product.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import kr.co.tomato.common.JDBCTemplate;
import kr.co.tomato.vo.ItemImg;

public class ItemImgDao {
	public int insertPhoto(Connection conn, ItemImg i) {
		 PreparedStatement pstmt = null;
	      int result = 0;
	      
	      String query = "INSERT INTO ITEM_IMAGE VALUES(SEQ_Item_NO.NEXTVAL, ?, ?, ?)";
	      
	      try {
	         pstmt = conn.prepareStatement(query);
	         pstmt.setString(1, i.getFilename());
	         pstmt.setString(2, i.getFilepath());
	         pstmt.setInt(3, i.getThumNy());
	         result = pstmt.executeUpdate();
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         JDBCTemplate.close(pstmt);
	      }
	      return result;

	}

	public int ItemImgTotalCount(Connection conn) {
		Statement stmt = null;
		ResultSet rset = null;
		int result = 0;
		String query = "select count(*) cnt from photo";
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			if(rset.next()) {
				result = rset.getInt("cnt");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}
		return result;
	}

	public ArrayList<ItemImg> moreItemImg(Connection conn, int start, int end) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT * FROM (SELECT ROWNUM AS RNUM, P.* FROM (SELECT * FROM ITEM_IMAGE ORDER BY ITEM_NO DESC)P) WHERE RNUM BETWEEN ? AND ?";
		ArrayList<ItemImg> list = new ArrayList<ItemImg>();
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				ItemImg i = new ItemImg();
				i.setItemNo(rset.getInt("Item_no"));
				i.setFilename(rset.getString("filename"));
				i.setFilepath(rset.getString("filepath"));
				i.setThumNy(rset.getInt("thumNy"));
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
