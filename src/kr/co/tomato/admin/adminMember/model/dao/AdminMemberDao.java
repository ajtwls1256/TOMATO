package kr.co.tomato.admin.adminMember.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.co.tomato.common.JDBCTemplate;
import kr.co.tomato.vo.Member;

public class AdminMemberDao {
	/**
	 * @ AdminMemberSearchList(회원관리페이지 회원목록) 
	 * @param : type(검색 종류), keyword(검색어) 
	 * @return : AdminMemberListPageData amlpd(페이징 데이터)
	 * @author : 김승현
	 * @date : 2019-10-22
	 */
	public ArrayList<Member> AdminMemberList(Connection conn, int start, int end) {
		ArrayList<Member> list = new ArrayList<Member>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from "
				+ "(select ROWNUM as rnum, n.* from"
				+ "(select * from member order by member_no desc) n) "
				+ "where rnum between ? and ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				int rnum = rset.getInt("rnum");
				int memberNo = rset.getInt("member_no");
				String email = rset.getString("email");
				String memberPw = rset.getString("member_pw");
				String memberName = rset.getString("member_name");
				Date enrollDate = rset.getDate("enroll_date");
				String phone = rset.getString("phone");
				String address = rset.getString("address");
				String zipCode = rset.getString("zip_code");
				String memberBank = rset.getString("member_bank");
				String memberAccount = rset.getString("member_account");
				String shopName = rset.getString("shop_name");
				String shopContent = rset.getString("shop_content");
				int shopReadcount = rset.getInt("shop_readcount");
				String fileName = rset.getString("file_name");
				String filePath = rset.getString("file_path");
				Member m = new Member(rnum, memberNo, email, memberPw, memberName, enrollDate, phone, address, zipCode, memberBank, memberAccount, shopName, shopContent, shopReadcount, fileName, filePath);
				list.add(m);
				System.out.println(m.getMemberNo());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	public int totalCount(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select count(*) as total from member";
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
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public ArrayList<Member> searchKeywordMemberNo(Connection conn, String keyword, int start, int end) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from (select ROWNUM as rnum, n.* from" 
				+ "(select * from member where member_no like (?) order by member_no desc)n)"  
				+ "where rnum between ? and ?" ;
		ArrayList<Member> list = new ArrayList<Member>();
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+keyword+"%");
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Member m = new Member();
				m.setRnum(rset.getInt("rnum"));
				m.setMemberNo(rset.getInt("member_no"));
				m.setEmail(rset.getString("email"));
				m.setMemberPw(rset.getString("member_pw"));
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
				list.add(m);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	public ArrayList<Member> searchKeywordEmail(Connection conn, String keyword, int start, int end) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from (select ROWNUM as rnum, n.* from" 
				+ "(select * from member where email like (?) order by member_no desc)n)"  
				+ "where rnum between ? and ?" ;
		ArrayList<Member> list = new ArrayList<Member>();
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+keyword+"%");
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Member m = new Member();
				m.setRnum(rset.getInt("rnum"));
				m.setMemberNo(rset.getInt("member_no"));
				m.setEmail(rset.getString("email"));
				m.setMemberPw(rset.getString("member_pw"));
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
				list.add(m);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	public ArrayList<Member> searchKeywordShopName(Connection conn, String keyword, int start, int end) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from (select ROWNUM as rnum, n.* from" 
				+ "(select * from member where shop_name like (?) order by member_no desc)n)"  
				+ "where rnum between ? and ?" ;
		ArrayList<Member> list = new ArrayList<Member>();
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+keyword+"%");
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Member m = new Member();
				m.setRnum(rset.getInt("rnum"));
				m.setMemberNo(rset.getInt("member_no"));
				m.setEmail(rset.getString("email"));
				m.setMemberPw(rset.getString("member_pw"));
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
				list.add(m);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	public ArrayList<Member> searchKeywordMemberName(Connection conn, String keyword, int start, int end) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from (select ROWNUM as rnum, n.* from" 
				+ "(select * from member where member_name like (?) order by member_no desc)n)"  
				+ "where rnum between ? and ?" ;
		ArrayList<Member> list = new ArrayList<Member>();
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+keyword+"%");
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Member m = new Member();
				m.setRnum(rset.getInt("rnum"));
				m.setMemberNo(rset.getInt("member_no"));
				m.setEmail(rset.getString("email"));
				m.setMemberPw(rset.getString("member_pw"));
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
				list.add(m);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	public int memberNoTotalCount(Connection conn, String keyword) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select count(*) as total from member where member_no like (?)";
		int result = 0;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+keyword+"%");
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

	public int EmailTotalCount(Connection conn, String keyword) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select count(*) as total from member where email like (?)";
		int result = 0;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+keyword+"%");
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

	public int ShopNameTotalCount(Connection conn, String keyword) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select count(*) as total from member where shop_name like (?)";
		int result = 0;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+keyword+"%");
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

	public int memberNameTotalCount(Connection conn, String keyword) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select count(*) as total from member where member_name like (?)";
		int result = 0;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+keyword+"%");
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

	public int adminMemberDelete(Connection conn, String memberNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "delete from member where member_no=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberNo);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

}
