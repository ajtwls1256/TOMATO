package kr.co.tomato.main.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import kr.co.tomato.common.JDBCTemplate;
import kr.co.tomato.main.model.dao.MainDao;
import kr.co.tomato.vo.Item;
import kr.co.tomato.vo.MemberAddress;

public class MainService {
	public ArrayList<Item> mainItemListData(String email) {
		Connection conn = JDBCTemplate.getConnection();
		MainDao dao = new MainDao();
		System.out.println("email : "+email);
		ArrayList<MemberAddress> maList = dao.MainMemberAddrList(conn, email);
		ArrayList<Item> iList = dao.MainItemList(conn, maList);
		JDBCTemplate.close(conn);
		return iList;
	}
}
