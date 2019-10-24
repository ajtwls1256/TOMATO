package kr.co.tomato.notice.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.co.tomato.common.JDBCTemplate;
import kr.co.tomato.notice.model.vo.Notice;


public class NoticeDao {

	public ArrayList<Notice> noticeList(Connection conn) {
		ArrayList<Notice> list = new ArrayList<Notice>();
		
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		
		String query = "select * from notice";
		
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Notice n = new Notice();
				n.setNoticeNo(rset.getInt("notice_no"));
				n.setNoticeTitle(rset.getString("notice_title"));
				n.setNoticeWriter(rset.getString("notice_writer"));
				n.setNoticeContent(rset.getString("notice_content"));
				n.setNoticeDate(rset.getDate("notice_date"));
				n.setReadcount(rset.getInt("readcount"));
				n.setFileName(rset.getString("file_name"));
				n.setFilePath(rset.getString("file_path"));
				list.add(n);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
			
		}
		return list;
		
		
	}

}
