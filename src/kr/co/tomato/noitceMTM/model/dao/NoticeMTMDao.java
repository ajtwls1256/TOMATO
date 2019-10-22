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
		String query = "insert into MTOM_INQUIRY values(2,15,'admin',?,sysdate,?,?,?,?,0,null,null)";
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, mtm.getNoticeMTMContent());
			pstmt.setString(2, mtm.getFileName());
			pstmt.setString(3, mtm.getFilePath());
			pstmt.setString(4, mtm.getNoticeMTMMainCategory());
			pstmt.setString(5, mtm.getNoticeMTMSubCategory());
			
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
		
		String query = "select * from MTOM_INQUIRY where MTOM_INQUIRY_ANSWER_STATE = 0";
		
		try {
			pstmt = conn.prepareStatement(query);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				NoticeMTM mtm = new NoticeMTM();
				mtm.setNoticeMTMNo(rset.getInt("MTOM_INQUIRY_NO"));
				mtm.setMemberMTMNo(rset.getInt("MEMBER_NO"));
				mtm.setNoticeMTMWriter(rset.getString("MTOM_INQUIRY_WRITER"));
				mtm.setNoticeMTMContent(rset.getString("MTOM_INQUIRY_CONTENT"));
				mtm.setNoticeMTMDate(rset.getDate("MTOM_INQUIRY_DATE"));
				mtm.setFileName(rset.getString("FILE_NAME"));
				mtm.setFilePath(rset.getString("FILE_PATH"));
				mtm.setNoticeMTMMainCategory(rset.getString("MTOM_INQUIRY_MAIN_CATEGORY"));
				mtm.setNoticeMTMSubCategory(rset.getString("MTOM_INQUIRY_SUB_CATEGORY"));
				mtm.setNoticeMTMAnswerState(rset.getString("MTOM_INQUIRY_ANSWER_STATE"));
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

}
