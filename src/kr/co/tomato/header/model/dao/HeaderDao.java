package kr.co.tomato.header.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.co.tomato.common.JDBCTemplate;
import kr.co.tomato.vo.Search;

public class HeaderDao {
	public ArrayList<Search> searchBox(Connection conn){
		ArrayList<Search> list = new ArrayList<Search>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from (select * from search order by search_count desc) where ROWNUM <= 10";
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				String searchContent = rset.getString("search_content");
				Date searchDate = rset.getDate("search_date");
				int searchCount = rset.getInt("search_count");
				Search s = new Search(searchContent, searchDate, searchCount);
				list.add(s);
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
