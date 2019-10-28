package kr.co.tomato.main.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import kr.co.tomato.common.JDBCTemplate;
import kr.co.tomato.main.model.dao.MainDao;
import kr.co.tomato.vo.Item;
import kr.co.tomato.vo.MemberAddress;

public class MainService {
	public ArrayList<ArrayList<Item>> mainItemListData(String email) {
		Connection conn = JDBCTemplate.getConnection();
		MainDao dao = new MainDao();
		
		ArrayList<ArrayList<Item>> result = new ArrayList<ArrayList<Item>>();
		
		ArrayList<MemberAddress> maList = dao.MainMemberAddrList(conn, email);
		ArrayList<Item> iList = dao.MainItemList(conn, maList);
		/*System.out.println("Service 군구 : "+maList.get(0).getAddrChoiceGungu());*/
		
		ArrayList<Item> list1 = dao.MainCategoryList1(conn);				
		ArrayList<Item> list2 = dao.MainCategoryList2(conn);
		ArrayList<Item> list3 = dao.MainCategoryList3(conn);
		ArrayList<Item> list4 = dao.MainCategoryList4(conn);
		ArrayList<Item> list5 = dao.MainCategoryList5(conn);
		ArrayList<Item> list6 = dao.MainCategoryList6(conn);
		ArrayList<Item> list7 = dao.MainCategoryList7(conn);
		
		result.add(iList);
		result.add(list1);
		result.add(list2);
		result.add(list3);
		result.add(list4);
		result.add(list5);
		result.add(list6);
		result.add(list7);
		
		JDBCTemplate.close(conn);
		return result;
	}
}
