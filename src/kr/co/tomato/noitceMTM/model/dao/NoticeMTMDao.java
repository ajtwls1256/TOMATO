package kr.co.tomato.noitceMTM.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.co.tomato.common.JDBCTemplate;
import kr.co.tomato.noitceMTM.model.vo.NoticeMTM;

public class NoticeMTMDao {

	public int insertNoticeMTM(Connection conn, NoticeMTM mtm) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "insert into MTOM_INQUIRY values(MTOM_INQUIRY_NO_SEQ.nextval,?,?,sysdate,?,?,?,?,0,null,null)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, mtm.getMemberMTMNo());
			pstmt.setString(2, mtm.getNoticeMTMContent());
			pstmt.setString(3, mtm.getFileName());
			pstmt.setString(4, mtm.getFilePath());
			pstmt.setString(5, mtm.getNoticeMTMMainCategory());
			pstmt.setString(6, mtm.getNoticeMTMSubCategory());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
			
		}
		return result;
	}

	public ArrayList<NoticeMTM> noticeMTMAdmin(Connection conn) {
		ResultSet rset = null;
		ArrayList<NoticeMTM> list = new ArrayList<NoticeMTM>();
		PreparedStatement pstmt =null;
		
		String query = "select * from MTOM_INQUIRY";
		
		try {
			pstmt = conn.prepareStatement(query);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				NoticeMTM mtm = new NoticeMTM();
				mtm.setNoticeMTMNo(rset.getInt("MTOM_INQUIRY_NO"));
				mtm.setMemberMTMNo(rset.getInt("MEMBER_NO"));
				mtm.setNoticeMTMContent(rset.getString("MTOM_INQUIRY_CONTENT"));
				mtm.setNoticeMTMDate(rset.getDate("MTOM_INQUIRY_DATE"));
				mtm.setFileName(rset.getString("FILE_NAME"));
				mtm.setFilePath(rset.getString("FILE_PATH"));
				mtm.setNoticeMTMMainCategory(rset.getString("MTOM_INQUIRY_MAIN_CATEGORY"));
				mtm.setNoticeMTMSubCategory(rset.getString("MTOM_INQUIRY_SUB_CATEGORY"));
				mtm.setNoticeMTMAnswerState(rset.getInt("MTOM_INQUIRY_ANSWER_STATE"));
				mtm.setNoticeMTMAnswerContent(rset.getString("MTOM_INQUIRY_ANSWER_CONTENT"));
				mtm.setNoticeMTMAnswerDate(rset.getDate("MTOM_INQUIRY_ANSWER_DATE"));
				
				list.add(mtm);
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

	public int NoticeMTMAdminInsert(String content,int no, Connection conn) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = "update MTOM_INQUIRY set MTOM_INQUIRY_ANSWER_CONTENT = ? , MTOM_INQUIRY_ANSWER_STATE = 1 , MTOM_INQUIRY_ANSWER_DATE = sysdate where MTOM_INQUIRY_NO = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, content);
			pstmt.setInt(2, no);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
			
		}
		return result;
	}

	public NoticeMTM AdminAnswerSearch(Connection conn, int no) {
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		NoticeMTM mtm = null;
		String query = "select * from MTOM_INQUIRY where MTOM_INQUIRY_NO =?";
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, no);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				mtm = new NoticeMTM();
				mtm.setMemberMTMNo(rset.getInt("MEMBER_NO"));
				mtm.setNoticeMTMContent(rset.getString("MTOM_INQUIRY_CONTENT"));
				mtm.setNoticeMTMDate(rset.getDate("MTOM_INQUIRY_DATE"));
				mtm.setFileName(rset.getString("FILE_NAME"));
				mtm.setFilePath(rset.getString("FILE_PATH"));
				mtm.setNoticeMTMMainCategory(rset.getString("MTOM_INQUIRY_MAIN_CATEGORY"));
				mtm.setNoticeMTMSubCategory(rset.getString("MTOM_INQUIRY_SUB_CATEGORY"));
				mtm.setNoticeMTMAnswerState(rset.getInt("MTOM_INQUIRY_ANSWER_STATE"));
				mtm.setNoticeMTMAnswerContent(rset.getString("MTOM_INQUIRY_ANSWER_CONTENT"));
				mtm.setNoticeMTMAnswerDate(rset.getDate("MTOM_INQUIRY_ANSWER_DATE"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
			
		}
		return mtm;
	}

	public int totalCount(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result =0;
		String query = "select count(*) as total from mtom_inquiry where MTOM_INQUIRY_ANSWER_STATE =0";
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

	public ArrayList<NoticeMTM> noticeMTMAdmin2(Connection conn, int start, int end) {
		
		ArrayList<NoticeMTM> list = new ArrayList<NoticeMTM>();

		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "select * from " + "(select ROWNUM as rnum, n.*from" // 행번호 삽입
				+ "(select * from mtom_inquiry order by mtom_inquiry_no desc) n) " // n 으로 별칭 지정
				+ "where rnum between ? and ?"; // 원하는 갯수를 다시 지정

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();

			while (rset.next()) {
				NoticeMTM mtm = new NoticeMTM();
				mtm.setrNum(rset.getInt("rnum"));
				mtm.setNoticeMTMNo(rset.getInt("MTOM_INQUIRY_NO"));
				mtm.setMemberMTMNo(rset.getInt("MEMBER_NO"));
				mtm.setNoticeMTMContent(rset.getString("MTOM_INQUIRY_CONTENT"));
				mtm.setNoticeMTMDate(rset.getDate("MTOM_INQUIRY_DATE"));
				mtm.setFileName(rset.getString("FILE_NAME"));
				mtm.setFilePath(rset.getString("FILE_PATH"));
				mtm.setNoticeMTMMainCategory(rset.getString("MTOM_INQUIRY_MAIN_CATEGORY"));
				mtm.setNoticeMTMSubCategory(rset.getString("MTOM_INQUIRY_SUB_CATEGORY"));
				mtm.setNoticeMTMAnswerState(rset.getInt("MTOM_INQUIRY_ANSWER_STATE"));
				mtm.setNoticeMTMAnswerContent(rset.getString("MTOM_INQUIRY_ANSWER_CONTENT"));
				mtm.setNoticeMTMAnswerDate(rset.getDate("MTOM_INQUIRY_ANSWER_DATE"));
				list.add(mtm);
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

}
