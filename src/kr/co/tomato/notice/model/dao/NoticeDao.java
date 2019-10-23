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

		String query = "select * from notice order by 1 desc ";

		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();

			while (rset.next()) {
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
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);

		}
		return list;

	}

	public int adminNoticeUpdate(String title, String content, int no, Connection conn) {
		int result = 0;
		PreparedStatement pstmt = null;

		String query = "update notice set notice_title = ? , notice_content =? where notice_no=?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setInt(3, no);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int adminNoticeInsert(String title, String content, Connection conn) {

		int result = 0;
		PreparedStatement pstmt = null;

		String query = "insert into notice values(notice_no_seq.nextval,?,?,'admin',sysdate,0,null,null)";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, title);
			pstmt.setString(2, content);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}


	public int adminNoticDelete(int noticeNo, Connection conn) {
		int result = 0;
		PreparedStatement pstmt = null;

		String query = "delete from notice where notice_no = ?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, noticeNo);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

}
