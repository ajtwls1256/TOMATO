package kr.co.tomato.mypage.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kr.co.tomato.common.JDBCTemplate;
import kr.co.tomato.vo.Member;

public class MypageDao {

	public Member mypage(Connection conn, int mypageNo) {
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			Member m = new Member();
			String query="select * from member where member_no=?";
			
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, mypageNo);
				rset=pstmt.executeQuery();
				
				while(rset.next()) {
					
					m.setMemberNo(rset.getInt("member_no"));
					m.setMemberPw(rset.getString("member_pw"));
					m.setEmail(rset.getString("email"));
					m.setMemberName(rset.getString("member_name"));
					m.setEnrollDate(rset.getDate("enroll_date"));
					m.setPhone(rset.getString("phone"));
					m.setAddress(rset.getString("address"));
					m.setZipCode(rset.getString("zip_code"));
					m.setMemberBank(rset.getString("member_bank"));
					m.setMemberAccount(rset.getString("member_account"));
					m.setShopName(rset.getString("shop_name"));
					m.setShopContent(rset.getString("shop_content"));
					m.setShopReadcount(rset.getInt("shop_readcount"));
					m.setFileName(rset.getString("file_name"));
					m.setFilePath(rset.getString("file_path"));
					
					
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				JDBCTemplate.close(rset);
				JDBCTemplate.close(pstmt);
			}return m;
		
	}

}
