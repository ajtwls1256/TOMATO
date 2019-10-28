package kr.co.tomato.search.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.co.tomato.common.JDBCTemplate;
import kr.co.tomato.vo.Item;

public class SearchDao
{
    
    public int itemTotalCount(Connection conn, String itemName)
    {
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        String query = "select count(*) as total from item where item_name like (?)";
        int result = 0;
        
        try
        {
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, "%" + itemName + "%");
            rset = pstmt.executeQuery();
            if (rset.next())
            {
                result = rset.getInt("total");
            }
        }
        catch (SQLException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally
        {
            JDBCTemplate.close(rset);
            JDBCTemplate.close(pstmt);
        }
        return result;
    }
    
    public ArrayList<Item> getSearchList(Connection conn, String item_Name,
            int start, int end)
    {
        
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        String sql = "select * from (select ROWNUM as rnum, n.* from (select * from item where item_name like (?) order by item_no desc)n) where rnum between ? and ?";
        ArrayList<Item> chattingList = new ArrayList<Item>();
        
        try
        {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "%" + item_Name + "%");
            pstmt.setInt(2, start);
            pstmt.setInt(3, end);
            
            rset = pstmt.executeQuery();
            
            while (rset.next())
            {
                int rnum = rset.getInt("rnum");
                int itemNo = rset.getInt("item_no");
                int memberNo = rset.getInt("member_no");
                String itemName = rset.getString("item_name");
                String itemMainCategory = rset.getString("item_main_category");
                String itemSubCategoty = rset.getString("item_sub_category");
                int itemPrice = rset.getInt("item_price");
                Date itemEnrollDate = rset.getDate("item_enroll_date");
                String itemState = rset.getString("item_state");
                int readcount = rset.getInt("readcount");
                String itemContent = rset.getString("item_content");
                int itemAmount = rset.getInt("item_amount");
                int itemDeliveryNY = rset.getInt("item_delivery_ny");
                String itemDealRegion = rset.getString("item_deal_region");
                String itemThumFilename = rset.getString("item_thum_filename");
                String itemThumFilepath = rset.getString("item_thum_filepath");
                String itemDealState = rset.getString("item_deal_state");
                int favoriteCount = rset.getInt("favorite_count");
                Item i = new Item(rnum, itemNo, memberNo, itemName,
                        itemMainCategory, itemSubCategoty, itemPrice,
                        itemEnrollDate, itemState, readcount, itemContent,
                        itemAmount, itemDeliveryNY, itemDealRegion,
                        itemThumFilename, itemThumFilepath, itemDealState,
                        favoriteCount);
                
                
                
                
                chattingList.add(i);
            }
            
        }
        catch (SQLException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally
        {
            JDBCTemplate.close(rset);
            JDBCTemplate.close(pstmt);
        }
        
        return chattingList;
        
    }
    
}
