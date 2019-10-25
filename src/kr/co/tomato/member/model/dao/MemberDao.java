package kr.co.tomato.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sound.midi.Synthesizer;

import kr.co.tomato.common.JDBCTemplate;
import kr.co.tomato.member.model.vo.Member;
import kr.co.tomato.member.model.vo.MemberAddress;


public class MemberDao {
	
	//login Dao
	public Member login(Connection conn, String email, String memberPw) {
		Member m = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from member where email=?and member_pw=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, email);
			pstmt.setString(2, memberPw);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				m = new Member();
				m.setAddress(rset.getString("address"));
				m.setEmail(rset.getString("email"));
				m.setEnrollDate(rset.getDate("enroll_date"));
				m.setFileName(rset.getString("file_name"));
				m.setFilePath(rset.getString("file_path"));
				m.setMemberAccount(rset.getString("member_account"));
				m.setMemberName(rset.getString("member_name"));
				m.setMemberNo(rset.getInt("member_no"));
				m.setMemberPw(rset.getString("member_pw"));
				m.setPhone(rset.getString("phone"));
				m.setShopContent(rset.getString("shop_content"));
				m.setShopName(rset.getString("shop_name"));
				m.setShopReadcount(rset.getInt("shop_readcount"));	
				m.setZipCode(rset.getString("zip_code"));
				m.setMemberBank(rset.getString("member_bank"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return m;
	}
	
	// 중복되는 email 유무 체크 Dao
	public Member selectOne(Connection conn, String checkEmail) {
		Member m = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from member where email=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, checkEmail);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				m = new Member();
				m.setAddress(rset.getString("address"));
				m.setEmail(rset.getString("email"));
				m.setEnrollDate(rset.getDate("enroll_date"));
				m.setFileName(rset.getString("file_name"));
				m.setFilePath(rset.getString("file_path"));
				m.setMemberAccount(rset.getString("member_account"));
				m.setMemberName(rset.getString("member_name"));
				m.setMemberNo(rset.getInt("member_no"));
				m.setMemberPw(rset.getString("member_pw"));
				m.setPhone(rset.getString("phone"));
				m.setShopContent(rset.getString("shop_content"));
				m.setShopName(rset.getString("shop_name"));
				m.setShopReadcount(rset.getInt("shop_readcount"));	
				m.setZipCode(rset.getString("zip_code"));
				m.setMemberBank(rset.getString("member_bank"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return m;
	}

	public int joinMember(Connection conn, Member m) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "insert into member values(MEMBER_NO_SEQ.nextval,?,?,null,sysdate,?,?,?,null,0,null,null,0,null,null)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, m.getEmail());
			pstmt.setString(2, m.getMemberPw());
			pstmt.setString(3, m.getPhone());
			pstmt.setString(4, m.getAddress());
			pstmt.setString(5, m.getZipCode());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
		JDBCTemplate.close(pstmt);
		}
		return result;
	}

	// 회원 관심지역 추가
	public int joinMember(Connection conn, MemberAddress mAddr) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "insert into member_Address values(?,?,?)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, mAddr.getEmail());
			pstmt.setString(2, mAddr.getAddrChoiceCity());
			pstmt.setString(3, mAddr.getAddrChoiceGungu());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public ArrayList<MemberAddress> selectAllAddressChoice(Connection conn, String email) {
		ArrayList<MemberAddress> list = new ArrayList<MemberAddress>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from member_address where email=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, email);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				MemberAddress mAddr = new MemberAddress();
				mAddr.setEmail(email);
				mAddr.setAddrChoiceCity(rset.getString("addr_choice_city"));
				mAddr.setAddrChoiceGungu(rset.getString("addr_choice_gungu"));
				list.add(mAddr);
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

	public int deleteMember(Connection conn, String email) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "delete from member where email = ?";
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, email);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int updateMember(Connection conn, Member m) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "update member set member_pw=?, member_name=?, phone=?, address=?, zip_code=?, member_bank=?, member_account=? where email = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, m.getMemberPw());
			pstmt.setString(2, m.getMemberName());
			pstmt.setString(3,m.getPhone());
			pstmt.setString(4, m.getAddress());
			pstmt.setString(5, m.getZipCode());
			pstmt.setString(6, m.getMemberBank());
			pstmt.setString(7, m.getMemberAccount());
			pstmt.setString(8, m.getEmail());
			result = pstmt.executeUpdate();
			System.out.println(result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int updateMemberAddress(Connection conn, MemberAddress mAddr, String oldGunguAddr) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "update member_address set addr_choice_city=?, addr_choice_gungu=? where email = ? and addr_choice_gungu=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, mAddr.getAddrChoiceCity());
			pstmt.setString(2, mAddr.getAddrChoiceGungu());
			pstmt.setString(3, mAddr.getEmail());
			pstmt.setString(4, oldGunguAddr);
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
