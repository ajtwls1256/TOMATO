package kr.co.tomato.header.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import kr.co.tomato.common.JDBCTemplate;
import kr.co.tomato.header.model.dao.HeaderDao;
import kr.co.tomato.vo.Search;

public class HeaderService {
	public ArrayList<Search> searchBox(){
		Connection conn = JDBCTemplate.getConnection();
		HeaderDao dao = new HeaderDao();
		ArrayList<Search> list = dao.searchBox(conn);
		JDBCTemplate.close(conn);
		return list;
	} 
}
