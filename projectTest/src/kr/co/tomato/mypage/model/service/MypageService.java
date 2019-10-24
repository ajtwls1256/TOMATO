package kr.co.tomato.mypage.model.service;

import java.sql.Connection;

import kr.co.tomato.common.JDBCTemplate;
import kr.co.tomato.mypage.model.dao.MypageDao;
import kr.co.tomato.vo.Member;

public class MypageService {
	
			public Member mypage(int mypageNo) {
				Connection conn= JDBCTemplate.getConnection();
				MypageDao dao = new MypageDao();
				Member m = dao.mypage(conn,mypageNo);
				
				if(m.getMemberNo() == mypageNo){
					JDBCTemplate.commit(conn);
				}else {
					JDBCTemplate.rollback(conn);
				}
				return m;
				
			}
}
