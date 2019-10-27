package kr.co.tomato.main.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.co.tomato.common.JDBCTemplate;
import kr.co.tomato.vo.Item;
import kr.co.tomato.vo.MemberAddress;

public class MainDao {
	public ArrayList<MemberAddress> MainMemberAddrList(Connection conn, String email) {
		ArrayList<MemberAddress> maList = new ArrayList<MemberAddress>();
		System.out.println(email);
		MemberAddress ma = new MemberAddress();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from member_address where email = ?";
		try {
			pstmt = conn.prepareStatement(query); 
			pstmt.setString(1, email);	//Servlet에서 email값이 안넘어옴~~~~~~~~~
			rset = pstmt.executeQuery();
			while(rset.next()) {
				String maEmail = rset.getString("email");
				String addrChoiceCity = rset.getString("addr_choice_city");
				String addrChoiceGungu = rset.getString("addr_choice_gungu");
				ma = new MemberAddress(maEmail, addrChoiceCity, addrChoiceGungu);
				maList.add(ma);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return maList;
	}
	
	public ArrayList<Item> MainItemList(Connection conn, ArrayList<MemberAddress> maList) {
		ArrayList<Item> iList = new ArrayList<Item>();
		Item i = new Item();
		PreparedStatement pstmt = null;
		/*System.out.println("DAO 군구 : "+maList.get(0).getAddrChoiceGungu());*/
		ResultSet rset = null;
		int size = maList.size();
		System.out.println("maList size : "+size);
		String query = "";
		try {
			if(size==1) {
				query = "select * from (select * from item order by readcount desc) where ROWNUM <= 4 and (item_deal_region = ?)";			
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, maList.get(0).getAddrChoiceGungu());
			}else if(size==2) {
				query = "select * from (select * from item order by readcount desc) where ROWNUM <= 4 and (item_deal_region = ? or item_deal_region = ?)";
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, maList.get(0).getAddrChoiceGungu());
				pstmt.setString(2, maList.get(1).getAddrChoiceGungu());
			}else if(size==3) {
				query = "select * from (select * from item order by readcount desc) where ROWNUM <= 4 and (item_deal_region = ? or item_deal_region = ? or item_deal_region = ?)";
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, maList.get(0).getAddrChoiceGungu());
				pstmt.setString(2, maList.get(1).getAddrChoiceGungu());
				pstmt.setString(3, maList.get(2).getAddrChoiceGungu());
			}
			rset = pstmt.executeQuery();
			while(rset.next()) {
				int itemNo = rset.getInt("item_no");
				int memberNo = rset.getInt("member_no");
				String itemName = rset.getString("item_name");
				String itemMainCategory = rset.getString("item_main_category");
				String itemSubCategory = rset.getString("item_sub_category");
				int itemPrice = rset.getInt("item_price");
				Date itemEnrollDate = rset.getDate("item_enroll_date");
				String itemState = rset.getString("item_state");
				int readcount = rset.getInt("readcount");
				String itemContent = rset.getString("item_content");
				int itemAmount = rset.getInt("item_amount");
				int itemDeliveryNy = rset.getInt("item_delivery_ny");
				String itemDealRegion = rset.getString("item_deal_region");//구 == memberAddress -> item_choice_gungu
				String itemThumFilename = rset.getString("item_thum_filename");
				String itemThumFilepath = rset.getString("item_thum_filepath");
				String itemDealState = rset.getString("item_deal_state");
				i = new Item(itemNo, memberNo, itemName, itemMainCategory, itemSubCategory, itemPrice, itemEnrollDate, itemState, readcount, itemContent, itemAmount, itemDeliveryNy, itemDealRegion, itemThumFilename, itemThumFilepath, itemDealState);
				iList.add(i);
				System.out.println("dao : "+itemThumFilepath);
			}
			System.out.println("iList 길이 : " + iList.size());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return iList;
	}

	public ArrayList<Item> MainCategoryList1(Connection conn) {
		ArrayList<Item> list1 = new ArrayList<Item>();
		Item i = new Item();		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from (select * from item order by readcount desc) where ROWNUM <= 10 and (item_main_category = '여성의류')";			
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				int itemNo = rset.getInt("item_no");
				int memberNo = rset.getInt("member_no");
				String itemName = rset.getString("item_name");
				String itemMainCategory = rset.getString("item_main_category");
				String itemSubCategory = rset.getString("item_sub_category");
				int itemPrice = rset.getInt("item_price");
				Date itemEnrollDate = rset.getDate("item_enroll_date");
				String itemState = rset.getString("item_state");
				int readcount = rset.getInt("readcount");
				String itemContent = rset.getString("item_content");
				int itemAmount = rset.getInt("item_amount");
				int itemDeliveryNy = rset.getInt("item_delivery_ny");
				String itemDealRegion = rset.getString("item_deal_region");//구 == memberAddress -> item_choice_gungu
				String itemThumFilename = rset.getString("item_thum_filename");
				String itemThumFilepath = rset.getString("item_thum_filepath");
				String itemDealState = rset.getString("item_deal_state");
				i = new Item(itemNo, memberNo, itemName, itemMainCategory, itemSubCategory, itemPrice, itemEnrollDate, itemState, readcount, itemContent, itemAmount, itemDeliveryNy, itemDealRegion, itemThumFilename, itemThumFilepath, itemDealState);
				list1.add(i);
				System.out.println("dao : "+itemThumFilepath);
			}
			System.out.println("List1 길이 : " + list1.size());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list1;
	}

	public ArrayList<Item> MainCategoryList2(Connection conn) {
		ArrayList<Item> list2 = new ArrayList<Item>();
		Item i = new Item();		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from (select * from item order by readcount desc) where ROWNUM <= 10 and (item_main_category = '남성의류')";			
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				int itemNo = rset.getInt("item_no");
				int memberNo = rset.getInt("member_no");
				String itemName = rset.getString("item_name");
				String itemMainCategory = rset.getString("item_main_category");
				String itemSubCategory = rset.getString("item_sub_category");
				int itemPrice = rset.getInt("item_price");
				Date itemEnrollDate = rset.getDate("item_enroll_date");
				String itemState = rset.getString("item_state");
				int readcount = rset.getInt("readcount");
				String itemContent = rset.getString("item_content");
				int itemAmount = rset.getInt("item_amount");
				int itemDeliveryNy = rset.getInt("item_delivery_ny");
				String itemDealRegion = rset.getString("item_deal_region");//구 == memberAddress -> item_choice_gungu
				String itemThumFilename = rset.getString("item_thum_filename");
				String itemThumFilepath = rset.getString("item_thum_filepath");
				String itemDealState = rset.getString("item_deal_state");
				i = new Item(itemNo, memberNo, itemName, itemMainCategory, itemSubCategory, itemPrice, itemEnrollDate, itemState, readcount, itemContent, itemAmount, itemDeliveryNy, itemDealRegion, itemThumFilename, itemThumFilepath, itemDealState);
				list2.add(i);
				System.out.println("dao : "+itemThumFilepath);
			}
			System.out.println("List1 길이 : " + list2.size());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list2;
	}

	public ArrayList<Item> MainCategoryList3(Connection conn) {
		ArrayList<Item> list3 = new ArrayList<Item>();
		Item i = new Item();		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from (select * from item order by readcount desc) where ROWNUM <= 10 and (item_main_category = '뷰티/미용')";			
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				int itemNo = rset.getInt("item_no");
				int memberNo = rset.getInt("member_no");
				String itemName = rset.getString("item_name");
				String itemMainCategory = rset.getString("item_main_category");
				String itemSubCategory = rset.getString("item_sub_category");
				int itemPrice = rset.getInt("item_price");
				Date itemEnrollDate = rset.getDate("item_enroll_date");
				String itemState = rset.getString("item_state");
				int readcount = rset.getInt("readcount");
				String itemContent = rset.getString("item_content");
				int itemAmount = rset.getInt("item_amount");
				int itemDeliveryNy = rset.getInt("item_delivery_ny");
				String itemDealRegion = rset.getString("item_deal_region");//구 == memberAddress -> item_choice_gungu
				String itemThumFilename = rset.getString("item_thum_filename");
				String itemThumFilepath = rset.getString("item_thum_filepath");
				String itemDealState = rset.getString("item_deal_state");
				i = new Item(itemNo, memberNo, itemName, itemMainCategory, itemSubCategory, itemPrice, itemEnrollDate, itemState, readcount, itemContent, itemAmount, itemDeliveryNy, itemDealRegion, itemThumFilename, itemThumFilepath, itemDealState);
				list3.add(i);
				System.out.println("dao : "+itemThumFilepath);
			}
			System.out.println("List1 길이 : " + list3.size());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list3;
	}

	public ArrayList<Item> MainCategoryList4(Connection conn) {
		ArrayList<Item> list4 = new ArrayList<Item>();
		Item i = new Item();		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from (select * from item order by readcount desc) where ROWNUM <= 10 and (item_main_category = '디지털/가전')";			
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				int itemNo = rset.getInt("item_no");
				int memberNo = rset.getInt("member_no");
				String itemName = rset.getString("item_name");
				String itemMainCategory = rset.getString("item_main_category");
				String itemSubCategory = rset.getString("item_sub_category");
				int itemPrice = rset.getInt("item_price");
				Date itemEnrollDate = rset.getDate("item_enroll_date");
				String itemState = rset.getString("item_state");
				int readcount = rset.getInt("readcount");
				String itemContent = rset.getString("item_content");
				int itemAmount = rset.getInt("item_amount");
				int itemDeliveryNy = rset.getInt("item_delivery_ny");
				String itemDealRegion = rset.getString("item_deal_region");//구 == memberAddress -> item_choice_gungu
				String itemThumFilename = rset.getString("item_thum_filename");
				String itemThumFilepath = rset.getString("item_thum_filepath");
				String itemDealState = rset.getString("item_deal_state");
				i = new Item(itemNo, memberNo, itemName, itemMainCategory, itemSubCategory, itemPrice, itemEnrollDate, itemState, readcount, itemContent, itemAmount, itemDeliveryNy, itemDealRegion, itemThumFilename, itemThumFilepath, itemDealState);
				list4.add(i);
				System.out.println("dao : "+itemThumFilepath);
			}
			System.out.println("List1 길이 : " + list4.size());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list4;
	}

	public ArrayList<Item> MainCategoryList5(Connection conn) {
		ArrayList<Item> list5 = new ArrayList<Item>();
		Item i = new Item();		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from (select * from item order by readcount desc) where ROWNUM <= 10 and (item_main_category = '도서/티켓')";			
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				int itemNo = rset.getInt("item_no");
				int memberNo = rset.getInt("member_no");
				String itemName = rset.getString("item_name");
				String itemMainCategory = rset.getString("item_main_category");
				String itemSubCategory = rset.getString("item_sub_category");
				int itemPrice = rset.getInt("item_price");
				Date itemEnrollDate = rset.getDate("item_enroll_date");
				String itemState = rset.getString("item_state");
				int readcount = rset.getInt("readcount");
				String itemContent = rset.getString("item_content");
				int itemAmount = rset.getInt("item_amount");
				int itemDeliveryNy = rset.getInt("item_delivery_ny");
				String itemDealRegion = rset.getString("item_deal_region");//구 == memberAddress -> item_choice_gungu
				String itemThumFilename = rset.getString("item_thum_filename");
				String itemThumFilepath = rset.getString("item_thum_filepath");
				String itemDealState = rset.getString("item_deal_state");
				i = new Item(itemNo, memberNo, itemName, itemMainCategory, itemSubCategory, itemPrice, itemEnrollDate, itemState, readcount, itemContent, itemAmount, itemDeliveryNy, itemDealRegion, itemThumFilename, itemThumFilepath, itemDealState);
				list5.add(i);
				System.out.println("dao : "+itemThumFilepath);
			}
			System.out.println("List1 길이 : " + list5.size());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list5;
	}

	public ArrayList<Item> MainCategoryList6(Connection conn) {
		ArrayList<Item> list6 = new ArrayList<Item>();
		Item i = new Item();		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from (select * from item order by readcount desc) where ROWNUM <= 10 and (item_main_category = '스타굿즈')";			
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				int itemNo = rset.getInt("item_no");
				int memberNo = rset.getInt("member_no");
				String itemName = rset.getString("item_name");
				String itemMainCategory = rset.getString("item_main_category");
				String itemSubCategory = rset.getString("item_sub_category");
				int itemPrice = rset.getInt("item_price");
				Date itemEnrollDate = rset.getDate("item_enroll_date");
				String itemState = rset.getString("item_state");
				int readcount = rset.getInt("readcount");
				String itemContent = rset.getString("item_content");
				int itemAmount = rset.getInt("item_amount");
				int itemDeliveryNy = rset.getInt("item_delivery_ny");
				String itemDealRegion = rset.getString("item_deal_region");//구 == memberAddress -> item_choice_gungu
				String itemThumFilename = rset.getString("item_thum_filename");
				String itemThumFilepath = rset.getString("item_thum_filepath");
				String itemDealState = rset.getString("item_deal_state");
				i = new Item(itemNo, memberNo, itemName, itemMainCategory, itemSubCategory, itemPrice, itemEnrollDate, itemState, readcount, itemContent, itemAmount, itemDeliveryNy, itemDealRegion, itemThumFilename, itemThumFilepath, itemDealState);
				list6.add(i);
				System.out.println("dao : "+itemThumFilepath);
			}
			System.out.println("List1 길이 : " + list6.size());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list6;
	}

	public ArrayList<Item> MainCategoryList7(Connection conn) {
		ArrayList<Item> list7 = new ArrayList<Item>();
		Item i = new Item();		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from (select * from item order by readcount desc) where ROWNUM <= 10 and (item_main_category = '생활/가구')";			
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				int itemNo = rset.getInt("item_no");
				int memberNo = rset.getInt("member_no");
				String itemName = rset.getString("item_name");
				String itemMainCategory = rset.getString("item_main_category");
				String itemSubCategory = rset.getString("item_sub_category");
				int itemPrice = rset.getInt("item_price");
				Date itemEnrollDate = rset.getDate("item_enroll_date");
				String itemState = rset.getString("item_state");
				int readcount = rset.getInt("readcount");
				String itemContent = rset.getString("item_content");
				int itemAmount = rset.getInt("item_amount");
				int itemDeliveryNy = rset.getInt("item_delivery_ny");
				String itemDealRegion = rset.getString("item_deal_region");//구 == memberAddress -> item_choice_gungu
				String itemThumFilename = rset.getString("item_thum_filename");
				String itemThumFilepath = rset.getString("item_thum_filepath");
				String itemDealState = rset.getString("item_deal_state");
				i = new Item(itemNo, memberNo, itemName, itemMainCategory, itemSubCategory, itemPrice, itemEnrollDate, itemState, readcount, itemContent, itemAmount, itemDeliveryNy, itemDealRegion, itemThumFilename, itemThumFilepath, itemDealState);
				list7.add(i);
				System.out.println("dao : "+itemThumFilepath);
			}
			System.out.println("List1 길이 : " + list7.size());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list7;
	}
	
	
	
	
	
	
}