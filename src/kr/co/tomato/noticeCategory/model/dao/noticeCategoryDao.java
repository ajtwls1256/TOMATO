package kr.co.tomato.noticeCategory.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kr.co.tomato.common.JDBCTemplate;
import kr.co.tomato.noticeCategory.model.vo.noticeCategory;

public class noticeCategoryDao {

	public noticeCategory searchSub(Connection conn, String sub) {
		noticeCategory nc = new noticeCategory();
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		
		String query = "select * from category where sub=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, sub);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				nc.setMain(rset.getString("main"));
				nc.setSub(rset.getString("sub"));
				nc.setContent(rset.getString("contnet"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
			
		}
		return nc;
	}

}
