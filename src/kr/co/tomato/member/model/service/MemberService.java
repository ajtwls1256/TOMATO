package kr.co.tomato.member.model.service;

import java.sql.Connection;

import kr.co.tomato.common.JDBCTemplate;
import kr.co.tomato.member.model.dao.MemberDao;
import kr.co.tomato.member.model.vo.Member;
import kr.co.tomato.member.model.vo.MemberAddress;


public class MemberService {

	public Member login(String email, String memberPw) {
		Connection conn = JDBCTemplate.getConnection();
		MemberDao dao = new MemberDao();
		Member m = dao.login(conn, email, memberPw);
		JDBCTemplate.close(conn);
		return m;
	}

	public Member selectOne(String checkEmail) {
		Connection conn = JDBCTemplate.getConnection();
		MemberDao dao = new MemberDao();
		Member m = dao.selectOne(conn, checkEmail);
		JDBCTemplate.close(conn);
		return m;
	}

	public int joinMember(Member m) {
		Connection conn = JDBCTemplate.getConnection();
		MemberDao dao = new MemberDao();
		int result = dao.joinMember(conn, m);
		if(result!=0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public int addAddress(MemberAddress mAddr) {
		Connection conn = JDBCTemplate.getConnection();
		MemberDao dao = new MemberDao();
		int result = dao.joinMember(conn, mAddr);
		if(result!=0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	
	
	
}
