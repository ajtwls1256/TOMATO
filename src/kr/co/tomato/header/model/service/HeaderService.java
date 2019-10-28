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
		for (int i=0; i<list.size();i++) {
			System.out.println("인기검색어 index"+i+"번 : "+list.get(i).getSearchContent());			
		}
		JDBCTemplate.close(conn);
		return list;
	} 
}
