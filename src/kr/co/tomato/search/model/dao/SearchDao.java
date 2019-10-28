package kr.co.tomato.search.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.co.tomato.common.JDBCTemplate;
import kr.co.tomato.vo.Item;

public class SearchDao {

	public ArrayList<Item> getSearchList(Connection conn, String item_Name) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = "select * from item where item_name like '%?%' order by item_no desc;";
		ArrayList<Item> chattingList = new ArrayList<Item>();
		
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, item_Name);


			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				int itemNo = rset.getInt("item_no");
				int memberNo = rset.getInt("member_no");
				String itemName = rset.getString("item_name");
				String itemMainCategory = rset.getString("item_main_category");
				String itemSubCategoty = rset.getString("item_sub_category");
				int itemPrice = rset.getInt("item_price");
				Date itemEnrollDate = rset.getDate("item_enroll_date");
				String chatContent = rset.getString("chat_content");
				String chatTime = rset.getString("chat_time");
			
				Item i = new Item(itemNo, memberNo, itemName, itemMainCategory, itemSubCategoty, itemPrice, itemEnrollDate, itemState, readcount, itemContent, itemAmount, itemDeliveryNY, itemDealRegion, itemThumFilename, itemThumFilepath, itemDealState)
				chattingList.add(c);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
	        JDBCTemplate.close(rset);
	        JDBCTemplate.close(pstmt);
	    }
		
		return chattingList;
		
	}

}
