package kr.co.tomato.search.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.co.tomato.common.JDBCTemplate;
import kr.co.tomato.vo.CategoryResult;
import kr.co.tomato.vo.Item;

public class SearchDao
{
    
    /* itemTotalCount */
    
    public int itemTotalCount(Connection conn, String keyword)
    {
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        String query = "select count(*) as total from item where item_name like (?)";
        int result = 0;
        
        try
        {
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, "%" + keyword + "%");
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
    
    public int itemTotalCount(Connection conn, String keyword,
            String mainCategory)
    {
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        String query = "select count(*) as total from item where item_name like (?) and item_main_category like (?)";
        int result = 0;
        
        try
        {
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, "%" + keyword + "%");
            pstmt.setString(2, "%" + mainCategory + "%");
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
    
    
    
    public int itemTotalCount(Connection conn, String keyword,
            String mainCategory, String subCategory)
    {
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        String query = "select count(*) as total from item where item_name like (?) and item_main_category like (?) and item_sub_category like (?)";
        int result = 0;
        
        try
        {
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, "%" + keyword + "%");
            pstmt.setString(2, "%" + mainCategory + "%");
            pstmt.setString(3, "%" + subCategory + "%");
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
    
    /* itemTotalCount */
    
    
    
    
    
    
    /* getSearchList */
    public ArrayList<Item> getSearchList(Connection conn, String keyword,
            int start, int end)
    {
        
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        String sql = "select * from (select ROWNUM as rnum, n.* from (select * from item where item_name like (?) order by item_no desc)n) where rnum between ? and ?";
        ArrayList<Item> chattingList = new ArrayList<Item>();
        
        try
        {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "%" + keyword + "%");
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
    
    public ArrayList<Item> getSearchList(Connection conn, String keyword, String mainCategory,
            int start, int end)
    {
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        String sql = "select * from (select ROWNUM as rnum, n.* from (select * from item where item_name like (?) and item_main_category like (?) order by item_no desc)n) where rnum between ? and ?";
        ArrayList<Item> chattingList = new ArrayList<Item>();
        
        try
        {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "%" + keyword + "%");
            pstmt.setString(2, "%" + mainCategory + "%");
            pstmt.setInt(3, start);
            pstmt.setInt(4, end);
            
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

    public ArrayList<Item> getSearchList(Connection conn, String keyword, String mainCategory, String subCategory,
            int start, int end)
    {
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        String sql = "select * from (select ROWNUM as rnum, n.* from (select * from item where item_name like (?) and item_main_category like (?) and item_sub_category like (?) order by item_no desc)n) where rnum between ? and ?";
        ArrayList<Item> chattingList = new ArrayList<Item>();
        
        try
        {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "%" + keyword + "%");
            pstmt.setString(2, "%" + mainCategory + "%");
            pstmt.setString(3, "%" + subCategory + "%");
            pstmt.setInt(4, start);
            pstmt.setInt(5, end);
            
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
    
    
    /* getSearchList */
    
    
    
    
    
    
    
    
    
    
    
    
    /* getCategorySubResult */

    public ArrayList<CategoryResult> getCategorySubResult(Connection conn, String keyword)
    {
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        String query = "select item_sub_category,item_main_category,count(item_no) as total from(select * from item where item_name like (?)) group by item_sub_category, item_main_category order by total desc";
        ArrayList<CategoryResult> result = new ArrayList<>();

        
        try
        {
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, "%" + keyword + "%");
            rset = pstmt.executeQuery();
            while (rset.next())
            {
                CategoryResult c = new CategoryResult();
                
                c.setItemSubCategory(rset.getString("item_sub_category"));
                c.setItemMainCategory(rset.getString("item_main_category"));
                c.setTotal(rset.getInt("total"));
            
                result.add(c);
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
    
    
    
    public ArrayList<CategoryResult> getCategorySubResult(Connection conn,
            String keyword, String mainCategory)
    {
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        String query = "select item_sub_category,item_main_category,count(item_no) as total from(select * from item where item_name like (?) and item_main_category like (?)) group by item_sub_category, item_main_category order by total desc";
        ArrayList<CategoryResult> result = new ArrayList<>();

        
        try
        {
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, "%" + keyword + "%");
            pstmt.setString(2, "%" + mainCategory + "%");
            rset = pstmt.executeQuery();
            while (rset.next())
            {
                CategoryResult c = new CategoryResult();
                
                c.setItemSubCategory(rset.getString("item_sub_category"));
                c.setItemMainCategory(rset.getString("item_main_category"));
                c.setTotal(rset.getInt("total"));
            
                result.add(c);
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

    public ArrayList<CategoryResult> getCategorySubResult(Connection conn,
            String keyword, String mainCategory, String subCategory)
    {
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        String query = "select item_sub_category,item_main_category,count(item_no) as total from(select * from item where item_name like (?) and item_main_category like (?) and item_sub_category like (?)) group by item_sub_category, item_main_category order by total desc";
        ArrayList<CategoryResult> result = new ArrayList<>();

        
        try
        {
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, "%" + keyword + "%");
            pstmt.setString(2, "%" + mainCategory + "%");
            pstmt.setString(3, "%" + subCategory + "%");
            rset = pstmt.executeQuery();
            while (rset.next())
            {
                CategoryResult c = new CategoryResult();
                
                c.setItemSubCategory(rset.getString("item_sub_category"));
                c.setItemMainCategory(rset.getString("item_main_category"));
                c.setTotal(rset.getInt("total"));
            
                result.add(c);
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
    
    /* getCategorySubResult */
    
    
    

    
    
    /* getCategoryMainResult */
    public ArrayList<CategoryResult> getCategoryMainResult(Connection conn, String keyword)
    {
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        String query = "select item_main_category, count(item_no) as total from(select * from item where item_name like (?)) group by item_main_category order by total desc";
        ArrayList<CategoryResult> result = new ArrayList<>();
        
        try
        {
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, "%" + keyword + "%");
            rset = pstmt.executeQuery();
            while (rset.next())
            {
                CategoryResult c = new CategoryResult();
                
                c.setItemMainCategory(rset.getString("item_main_category"));
                c.setTotal(rset.getInt("total"));
                
                result.add(c);
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

    public ArrayList<CategoryResult> getCategoryMainResult(Connection conn,
            String keyword, String mainCategory)
    {
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        String query = "select item_main_category, count(item_no) as total from(select * from item where item_name like (?) and item_main_category like (?)) group by item_main_category order by total desc";
        ArrayList<CategoryResult> result = new ArrayList<>();
        
        try
        {
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, "%" + keyword + "%");
            pstmt.setString(2, "%" + mainCategory + "%");
            rset = pstmt.executeQuery();
            while (rset.next())
            {
                CategoryResult c = new CategoryResult();
                
                c.setItemMainCategory(rset.getString("item_main_category"));
                c.setTotal(rset.getInt("total"));
                
                result.add(c);
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

    public ArrayList<CategoryResult> getCategoryMainResult(Connection conn,
            String keyword, String mainCategory, String subCategory)
    {
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        String query = "select item_main_category, count(item_no) as total from(select * from item where item_name like (?) and item_main_category like (?) and item_sub_category like (?)) group by item_main_category order by total desc";
        ArrayList<CategoryResult> result = new ArrayList<>();
        
        try
        {
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, "%" + keyword + "%");
            pstmt.setString(2, "%" + mainCategory + "%");
            pstmt.setString(3, "%" + subCategory + "%");
            rset = pstmt.executeQuery();
            while (rset.next())
            {
                CategoryResult c = new CategoryResult();
                
                c.setItemMainCategory(rset.getString("item_main_category"));
                c.setTotal(rset.getInt("total"));
                
                result.add(c);
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


    /* getCategoryMainResult */

    
    
    
    
    
    


    
    
    
    
    
    
    /* 지역 */
    
    
    public ArrayList<String> getMemberAddress(Connection conn, String email)
    {
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        String query = "select addr_choice_gungu from member_address where email=?";
        ArrayList<String> result = new ArrayList<>();
        
        try
        {
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, email);

            rset = pstmt.executeQuery();
            
            while (rset.next())
            {
                String addr = rset.getString("addr_choice_gungu");
               
                
                result.add(addr);
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
    
    
    
    

    
    public int itemTotalCount(Connection conn, String keyword,
            String mainCategory, String subCategory,
            ArrayList<String> memAddress)
    {
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        String query = "select count(*) as total from item where item_name like (?) and item_main_category like (?) and item_sub_category like (?)";
        int result = 0;
        
        try
        {
            query += " and item_deal_region in (";
            for(int i=0; i<memAddress.size(); i++) {
                query += "?,";
            }
            query = query.substring(0, query.length()-1);
            query += ")";

            
            
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, "%" + keyword + "%");
            pstmt.setString(2, "%" + mainCategory + "%");
            pstmt.setString(3, "%" + subCategory + "%");
            
            for(int i=0; i<memAddress.size(); i++) {
//                pstmt.setString(4+i, memAddress.get(index));
            }
            
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

    public int itemTotalCount(Connection conn, String keyword,
            String mainCategory, ArrayList<String> memAddress)
    {
        // TODO Auto-generated method stub
        return 0;
    }

    public int itemTotalCount(Connection conn, String keyword,
            ArrayList<String> memAddress)
    {
        // TODO Auto-generated method stub
        return 0;
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
