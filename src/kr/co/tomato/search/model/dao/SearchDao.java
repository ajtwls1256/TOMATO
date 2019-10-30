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
import kr.co.tomato.vo.Search;

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
                pstmt.setString(4+i, memAddress.get(i));
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
    	  PreparedStatement pstmt = null;
          ResultSet rset = null;
          String query = "select count(*) as total from item where item_name like (?) and item_main_category like (?)";
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
              
              for(int i=0; i<memAddress.size(); i++) {
                  pstmt.setString(3+i, memAddress.get(i));
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
            ArrayList<String> memAddress)
    {
    	 PreparedStatement pstmt = null;
         ResultSet rset = null;
         String query = "select count(*) as total from item where item_name like (?)";
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
             
             for(int i=0; i<memAddress.size(); i++) {
                 pstmt.setString(2+i, memAddress.get(i));
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

    
    
    
	public ArrayList<Item> getSearchList(Connection conn, String keyword, String mainCategory, String subCategory,
			ArrayList<String> memAddress, int start, int end) {
		PreparedStatement pstmt = null;
        ResultSet rset = null;
        String sql = null;
        
        ArrayList<Item> chattingList = new ArrayList<Item>();
        
        try
        {
        	if(memAddress.size()==1) {
        		sql = "select * from (select ROWNUM as rnum, n.* from (select * from item where item_name like (?) and item_main_category like (?) and item_sub_category like (?) and item_deal_region in (?) order by item_no desc)n) where rnum between ? and ?";
        		pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, "%" + keyword + "%");
                pstmt.setString(2, "%" + mainCategory + "%");
                pstmt.setString(3, "%" + subCategory + "%");
                pstmt.setString(4, memAddress.get(0));
                pstmt.setInt(5, start);
                pstmt.setInt(6, end);
        	
        	}else if(memAddress.size()==2) {
        		sql = "select * from (select ROWNUM as rnum, n.* from (select * from item where item_name like (?) and item_main_category like (?) and item_sub_category like (?) and item_deal_region in (?,?) order by item_no desc)n) where rnum between ? and ?";
        		pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, "%" + keyword + "%");
                pstmt.setString(2, "%" + mainCategory + "%");
                pstmt.setString(3, "%" + subCategory + "%");
                pstmt.setString(4, memAddress.get(0));
                pstmt.setString(5, memAddress.get(1));
                pstmt.setInt(6, start);
                pstmt.setInt(7, end);
        		
        	}else if(memAddress.size()==3) {
        		sql = "select * from (select ROWNUM as rnum, n.* from (select * from item where item_name like (?) and item_main_category like (?) and item_sub_category like (?) and item_deal_region in (?,?,?) order by item_no desc)n) where rnum between ? and ?";
        		pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, "%" + keyword + "%");
                pstmt.setString(2, "%" + mainCategory + "%");
                pstmt.setString(3, "%" + subCategory + "%");
                pstmt.setString(4, memAddress.get(0));
                pstmt.setString(5, memAddress.get(1));
                pstmt.setString(6, memAddress.get(2));
                pstmt.setInt(7, start);
                pstmt.setInt(8, end);
        	}
        	
        	
            
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
			ArrayList<String> memAddress, int start, int end) {
		PreparedStatement pstmt = null;
        ResultSet rset = null;
        String sql = null;
        
        ArrayList<Item> chattingList = new ArrayList<Item>();
        
        try
        {
        	if(memAddress.size()==1) {
        		sql = "select * from (select ROWNUM as rnum, n.* from (select * from item where item_name like (?) and item_main_category like (?) and item_deal_region in (?) order by item_no desc)n) where rnum between ? and ?";
        		pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, "%" + keyword + "%");
                pstmt.setString(2, "%" + mainCategory + "%");
                pstmt.setString(3, memAddress.get(0));
                pstmt.setInt(4, start);
                pstmt.setInt(5, end);
        	
        	}else if(memAddress.size()==2) {
        		sql = "select * from (select ROWNUM as rnum, n.* from (select * from item where item_name like (?) and item_main_category like (?) and item_deal_region in (?,?) order by item_no desc)n) where rnum between ? and ?";
        		pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, "%" + keyword + "%");
                pstmt.setString(2, "%" + mainCategory + "%");
                pstmt.setString(3, memAddress.get(0));
                pstmt.setString(4, memAddress.get(1));
                pstmt.setInt(5, start);
                pstmt.setInt(6, end);
        		
        	}else if(memAddress.size()==3) {
        		sql = "select * from (select ROWNUM as rnum, n.* from (select * from item where item_name like (?) and item_main_category like (?) and item_deal_region in (?,?,?) order by item_no desc)n) where rnum between ? and ?";
        		pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, "%" + keyword + "%");
                pstmt.setString(2, "%" + mainCategory + "%");
                pstmt.setString(3, memAddress.get(0));
                pstmt.setString(4, memAddress.get(1));
                pstmt.setString(5, memAddress.get(2));
                pstmt.setInt(6, start);
                pstmt.setInt(7, end);
        	}
        	
        	
            
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

	public ArrayList<Item> getSearchList(Connection conn, String keyword, ArrayList<String> memAddress, int start,
			int end) {
		PreparedStatement pstmt = null;
        ResultSet rset = null;
        String sql = null;
        
        ArrayList<Item> chattingList = new ArrayList<Item>();
        
        try
        {
        	if(memAddress.size()==1) {
        		sql = "select * from (select ROWNUM as rnum, n.* from (select * from item where item_name like (?) and item_deal_region in (?) order by item_no desc)n) where rnum between ? and ?";
        		pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, "%" + keyword + "%");
                pstmt.setString(2, memAddress.get(0));
                pstmt.setInt(3, start);
                pstmt.setInt(4, end);
        	
        	}else if(memAddress.size()==2) {
        		sql = "select * from (select ROWNUM as rnum, n.* from (select * from item where item_name like (?) and item_deal_region in (?,?) order by item_no desc)n) where rnum between ? and ?";
        		pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, "%" + keyword + "%");
                pstmt.setString(2, memAddress.get(0));
                pstmt.setString(3, memAddress.get(1));
                pstmt.setInt(4, start);
                pstmt.setInt(5, end);
        		
        	}else if(memAddress.size()==3) {
        		sql = "select * from (select ROWNUM as rnum, n.* from (select * from item where item_name like (?) and item_deal_region in (?,?,?) order by item_no desc)n) where rnum between ? and ?";
        		pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, "%" + keyword + "%");
                pstmt.setString(2, memAddress.get(0));
                pstmt.setString(3, memAddress.get(1));
                pstmt.setString(4, memAddress.get(2));
                pstmt.setInt(5, start);
                pstmt.setInt(6, end);
        	}
        	
        	
            
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
	
	
	
	
	
	
	
	

	public ArrayList<CategoryResult> getCategorySubResult(Connection conn, String keyword, String mainCategory,
			String subCategory, ArrayList<String> memAddress) {
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        String query = null;
        ArrayList<CategoryResult> result = new ArrayList<>();

        
        try
        {
        	if(memAddress.size()==1) {
        		query = "select item_sub_category,item_main_category,count(item_no) as total from(select * from item where item_name like (?) and item_main_category like (?) and item_sub_category like (?) and item_deal_region in (?)) group by item_sub_category, item_main_category order by total desc";
        		pstmt = conn.prepareStatement(query);
                pstmt.setString(1, "%" + keyword + "%");
                pstmt.setString(2, "%" + mainCategory + "%");
                pstmt.setString(3, "%" + subCategory + "%");
                pstmt.setString(4, memAddress.get(0));
        	}else if(memAddress.size()==2) {
        		query = "select item_sub_category,item_main_category,count(item_no) as total from(select * from item where item_name like (?) and item_main_category like (?) and item_sub_category like (?) and item_deal_region in (?,?)) group by item_sub_category, item_main_category order by total desc";
        		pstmt = conn.prepareStatement(query);
                pstmt.setString(1, "%" + keyword + "%");
                pstmt.setString(2, "%" + mainCategory + "%");
                pstmt.setString(3, "%" + subCategory + "%");
                pstmt.setString(4, memAddress.get(0));
                pstmt.setString(5, memAddress.get(1));
        	}else if(memAddress.size()==3) {
        		query = "select item_sub_category,item_main_category,count(item_no) as total from(select * from item where item_name like (?) and item_main_category like (?) and item_sub_category like (?) and item_deal_region in (?,?,?)) group by item_sub_category, item_main_category order by total desc";
        		pstmt = conn.prepareStatement(query);
                pstmt.setString(1, "%" + keyword + "%");
                pstmt.setString(2, "%" + mainCategory + "%");
                pstmt.setString(3, "%" + subCategory + "%");
                pstmt.setString(4, memAddress.get(0));
                pstmt.setString(5, memAddress.get(1));
                pstmt.setString(6, memAddress.get(2));
        	}
        	
        	
     
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

	public ArrayList<CategoryResult> getCategorySubResult(Connection conn, String keyword, String mainCategory,
			ArrayList<String> memAddress) {
			PreparedStatement pstmt = null;
	        ResultSet rset = null;
	        String query = null;
	        ArrayList<CategoryResult> result = new ArrayList<>();

	        
	        try
	        {
	        	if(memAddress.size()==1) {
	        		query = "select item_sub_category,item_main_category,count(item_no) as total from(select * from item where item_name like (?) and item_main_category like (?) and item_deal_region in (?)) group by item_sub_category, item_main_category order by total desc";
	        		pstmt = conn.prepareStatement(query);
	                pstmt.setString(1, "%" + keyword + "%");
	                pstmt.setString(2, "%" + mainCategory + "%");
	                pstmt.setString(3, memAddress.get(0));
	        	}else if(memAddress.size()==2) {
	        		query = "select item_sub_category,item_main_category,count(item_no) as total from(select * from item where item_name like (?) and item_main_category like (?) and item_deal_region in (?,?)) group by item_sub_category, item_main_category order by total desc";
	        		pstmt = conn.prepareStatement(query);
	                pstmt.setString(1, "%" + keyword + "%");
	                pstmt.setString(2, "%" + mainCategory + "%");
	                pstmt.setString(3, memAddress.get(0));
	                pstmt.setString(4, memAddress.get(1));
	        	}else if(memAddress.size()==3) {
	        		query = "select item_sub_category,item_main_category,count(item_no) as total from(select * from item where item_name like (?) and item_main_category like (?) and item_deal_region in (?,?,?)) group by item_sub_category, item_main_category order by total desc";
	        		pstmt = conn.prepareStatement(query);
	                pstmt.setString(1, "%" + keyword + "%");
	                pstmt.setString(2, "%" + mainCategory + "%");
	                pstmt.setString(3, memAddress.get(0));
	                pstmt.setString(4, memAddress.get(1));
	                pstmt.setString(5, memAddress.get(2));
	        	}
	        	
	        	
	     
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

	public ArrayList<CategoryResult> getCategorySubResult(Connection conn, String keyword,
			ArrayList<String> memAddress) {
		PreparedStatement pstmt = null;
        ResultSet rset = null;
        String query = null;
        ArrayList<CategoryResult> result = new ArrayList<>();

        
        try
        {
        	if(memAddress.size()==1) {
        		query = "select item_sub_category,item_main_category,count(item_no) as total from(select * from item where item_name like (?) and item_deal_region in (?)) group by item_sub_category, item_main_category order by total desc";
        		pstmt = conn.prepareStatement(query);
                pstmt.setString(1, "%" + keyword + "%");
                pstmt.setString(2, memAddress.get(0));
        	}else if(memAddress.size()==2) {
        		query = "select item_sub_category,item_main_category,count(item_no) as total from(select * from item where item_name like (?) and item_deal_region in (?,?)) group by item_sub_category, item_main_category order by total desc";
        		pstmt = conn.prepareStatement(query);
                pstmt.setString(1, "%" + keyword + "%");
                pstmt.setString(2, memAddress.get(0));
                pstmt.setString(3, memAddress.get(1));
        	}else if(memAddress.size()==3) {
        		query = "select item_sub_category,item_main_category,count(item_no) as total from(select * from item where item_name like (?) and item_deal_region in (?,?,?)) group by item_sub_category, item_main_category order by total desc";
        		pstmt = conn.prepareStatement(query);
                pstmt.setString(1, "%" + keyword + "%");
                pstmt.setString(2, memAddress.get(0));
                pstmt.setString(3, memAddress.get(1));
                pstmt.setString(4, memAddress.get(2));
        	}
        	
        	
     
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
	
	
	
	
	
	
	
	
	
	
	

	public ArrayList<CategoryResult> getCategoryMainResult(Connection conn, String keyword, String mainCategory,
			String subCategory, ArrayList<String> memAddress) {
		  	PreparedStatement pstmt = null;
	        ResultSet rset = null;
	        String query = null;
	        ArrayList<CategoryResult> result = new ArrayList<>();
	        
	        try
	        {
	        	if(memAddress.size()==1) {
	        		query = "select item_main_category, count(item_no) as total from(select * from item where item_name like (?) and item_main_category like (?) and item_sub_category like (?) and item_deal_region in (?)) group by item_main_category order by total desc";
		            pstmt = conn.prepareStatement(query);
		            pstmt.setString(1, "%" + keyword + "%");
		            pstmt.setString(2, "%" + mainCategory + "%");
		            pstmt.setString(3, "%" + subCategory + "%");
		            pstmt.setString(4, memAddress.get(0));
	        	}else if(memAddress.size()==2) {
	        		query = "select item_main_category, count(item_no) as total from(select * from item where item_name like (?) and item_main_category like (?) and item_sub_category like (?) and item_deal_region in (?,?)) group by item_main_category order by total desc";
		            pstmt = conn.prepareStatement(query);
		            pstmt.setString(1, "%" + keyword + "%");
		            pstmt.setString(2, "%" + mainCategory + "%");
		            pstmt.setString(3, "%" + subCategory + "%");
		            pstmt.setString(4, memAddress.get(0));
		            pstmt.setString(5, memAddress.get(1));
	        	}else if(memAddress.size()==3) {
	        		query = "select item_main_category, count(item_no) as total from(select * from item where item_name like (?) and item_main_category like (?) and item_sub_category like (?) and item_deal_region in (?,?,?)) group by item_main_category order by total desc";
		            pstmt = conn.prepareStatement(query);
		            pstmt.setString(1, "%" + keyword + "%");
		            pstmt.setString(2, "%" + mainCategory + "%");
		            pstmt.setString(3, "%" + subCategory + "%");
		            pstmt.setString(4, memAddress.get(0));
		            pstmt.setString(5, memAddress.get(1));
		            pstmt.setString(6, memAddress.get(2));
	        	}
	        	
	        	

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

	public ArrayList<CategoryResult> getCategoryMainResult(Connection conn, String keyword, String mainCategory,
			ArrayList<String> memAddress) {
		PreparedStatement pstmt = null;
        ResultSet rset = null;
        String query = null;
        ArrayList<CategoryResult> result = new ArrayList<>();
        
        try
        {
        	if(memAddress.size()==1) {
        		query = "select item_main_category, count(item_no) as total from(select * from item where item_name like (?) and item_main_category like (?) and item_deal_region in (?)) group by item_main_category order by total desc";
	            pstmt = conn.prepareStatement(query);
	            pstmt.setString(1, "%" + keyword + "%");
	            pstmt.setString(2, "%" + mainCategory + "%");
	            pstmt.setString(3, memAddress.get(0));
        	}else if(memAddress.size()==2) {
        		query = "select item_main_category, count(item_no) as total from(select * from item where item_name like (?) and item_main_category like (?) and item_deal_region in (?,?)) group by item_main_category order by total desc";
	            pstmt = conn.prepareStatement(query);
	            pstmt.setString(1, "%" + keyword + "%");
	            pstmt.setString(2, "%" + mainCategory + "%");
	            pstmt.setString(3, memAddress.get(0));
	            pstmt.setString(4, memAddress.get(1));
        	}else if(memAddress.size()==3) {
        		query = "select item_main_category, count(item_no) as total from(select * from item where item_name like (?) and item_main_category like (?) and item_deal_region in (?,?,?)) group by item_main_category order by total desc";
	            pstmt = conn.prepareStatement(query);
	            pstmt.setString(1, "%" + keyword + "%");
	            pstmt.setString(2, "%" + mainCategory + "%");
	            pstmt.setString(3, memAddress.get(0));
	            pstmt.setString(4, memAddress.get(1));
	            pstmt.setString(5, memAddress.get(2));
        	}
        	
        	

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

	public ArrayList<CategoryResult> getCategoryMainResult(Connection conn, String keyword,
			ArrayList<String> memAddress) {
		PreparedStatement pstmt = null;
        ResultSet rset = null;
        String query = null;
        ArrayList<CategoryResult> result = new ArrayList<>();
        
        try
        {
        	if(memAddress.size()==1) {
        		query = "select item_main_category, count(item_no) as total from(select * from item where item_name like (?) and item_deal_region in (?)) group by item_main_category order by total desc";
	            pstmt = conn.prepareStatement(query);
	            pstmt.setString(1, "%" + keyword + "%");
	            pstmt.setString(2, memAddress.get(0));
        	}else if(memAddress.size()==2) {
        		query = "select item_main_category, count(item_no) as total from(select * from item where item_name like (?) and item_deal_region in (?,?)) group by item_main_category order by total desc";
	            pstmt = conn.prepareStatement(query);
	            pstmt.setString(1, "%" + keyword + "%");
	            pstmt.setString(2, memAddress.get(0));
	            pstmt.setString(3, memAddress.get(1));
        	}else if(memAddress.size()==3) {
        		query = "select item_main_category, count(item_no) as total from(select * from item where item_name like (?) and item_deal_region in (?,?,?)) group by item_main_category order by total desc";
	            pstmt = conn.prepareStatement(query);
	            pstmt.setString(1, "%" + keyword + "%");
	            pstmt.setString(2, memAddress.get(0));
	            pstmt.setString(3, memAddress.get(1));
	            pstmt.setString(4, memAddress.get(2));
        	}
        	
        	

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

	
	
	
	
	
	
	
	
	
	
	
	
	
	/* 카테고리 검색  */
	
	
	
	
	public int itemCategoryTotalCount(Connection conn, String mainCategory, String subCategory) {
		PreparedStatement pstmt = null;
        ResultSet rset = null;
        String query = "select count(*) as total from item where item_main_category like (?) and item_sub_category like (?)";
        int result = 0;
        
        try
        {
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, "%" + mainCategory + "%");
            pstmt.setString(2, "%" + subCategory + "%");
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

	public int itemCategoryTotalCount(Connection conn, String mainCategory) {
		PreparedStatement pstmt = null;
        ResultSet rset = null;
        String query = "select count(*) as total from item where item_main_category like (?)";
        int result = 0;
        
        try
        {
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, "%" + mainCategory + "%");
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

	
	
	
	public ArrayList<Item> getCategorySearchList(Connection conn, String mainCategory, String subCategory, int start,
			int end) {
		 	PreparedStatement pstmt = null;
	        ResultSet rset = null;
	        String sql = "select * from (select ROWNUM as rnum, n.* from (select * from item where item_main_category like (?) and item_sub_category like (?) order by item_no desc)n) where rnum between ? and ?";
	        ArrayList<Item> itemList = new ArrayList<Item>();
	        
	        try
	        {
	            pstmt = conn.prepareStatement(sql);
	            pstmt.setString(1, "%" + mainCategory + "%");
	            pstmt.setString(2, "%" + subCategory + "%");
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
	                
	                
	                
	                
	                itemList.add(i);
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
	        
	        return itemList;
	}

	public ArrayList<Item> getCategorySearchList(Connection conn, String mainCategory, int start, int end) {
		PreparedStatement pstmt = null;
        ResultSet rset = null;
        String sql = "select * from (select ROWNUM as rnum, n.* from (select * from item where item_main_category like (?) order by item_no desc)n) where rnum between ? and ?";
        ArrayList<Item> itemList = new ArrayList<Item>();
        
        try
        {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "%" + mainCategory + "%");
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
                
                
                
                
                itemList.add(i);
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
        
        return itemList;
	}

	public int itemCategoryTotalCount(Connection conn, String mainCategory, String subCategory,
			ArrayList<String> memAddress) {
		PreparedStatement pstmt = null;
        ResultSet rset = null;
        String query = null;

        int result = 0;
        
        try
        {
        	if(memAddress.size() == 1) {
        		query = "select count(*) as total from item where item_main_category like (?) and item_sub_category like (?) and item_deal_region in (?)";
        		pstmt = conn.prepareStatement(query);
        		pstmt.setString(1, "%" + mainCategory + "%");
        		pstmt.setString(2, "%" + subCategory + "%");
        		pstmt.setString(3, memAddress.get(0));
        	}else if(memAddress.size() == 2) {
        		query = "select count(*) as total from item where item_main_category like (?) and item_sub_category like (?) and item_deal_region in (?,?)";
        		pstmt = conn.prepareStatement(query);
        		pstmt.setString(1, "%" + mainCategory + "%");
        		pstmt.setString(2, "%" + subCategory + "%");
        		pstmt.setString(3, memAddress.get(0));
        		pstmt.setString(4, memAddress.get(1));
        	}else if(memAddress.size() == 3) {
        		query = "select count(*) as total from item where item_main_category like (?) and item_sub_category like (?) and item_deal_region in (?,?,?)";
        		pstmt = conn.prepareStatement(query);
        		pstmt.setString(1, "%" + mainCategory + "%");
        		pstmt.setString(2, "%" + subCategory + "%");
        		pstmt.setString(3, memAddress.get(0));
        		pstmt.setString(4, memAddress.get(1));
         		pstmt.setString(5, memAddress.get(2));
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

	public int itemCategoryTotalCount(Connection conn, String mainCategory, ArrayList<String> memAddress) {
		PreparedStatement pstmt = null;
        ResultSet rset = null;
        String query = null;

        int result = 0;
        
        try
        {
        	if(memAddress.size() == 1) {
        		query = "select count(*) as total from item where item_main_category like (?) and item_deal_region in (?)";
        		pstmt = conn.prepareStatement(query);
        		pstmt.setString(1, "%" + mainCategory + "%");
        		pstmt.setString(2, memAddress.get(0));
        	}else if(memAddress.size() == 2) {
        		query = "select count(*) as total from item where item_main_category like (?) and item_deal_region in (?,?)";
        		pstmt = conn.prepareStatement(query);
        		pstmt.setString(1, "%" + mainCategory + "%");
        		pstmt.setString(2, memAddress.get(0));
        		pstmt.setString(3, memAddress.get(1));
        	}else if(memAddress.size() == 3) {
        		query = "select count(*) as total from item where item_main_category like (?) and item_deal_region in (?,?,?)";
        		pstmt = conn.prepareStatement(query);
        		pstmt.setString(1, "%" + mainCategory + "%");
        		pstmt.setString(2, memAddress.get(0));
        		pstmt.setString(3, memAddress.get(1));
         		pstmt.setString(4, memAddress.get(2));
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
	
	
	
	

	public ArrayList<Item> getCategorySearchList(Connection conn, String mainCategory, String subCategory,
			ArrayList<String> memAddress, int start, int end) {
		PreparedStatement pstmt = null;
        ResultSet rset = null;
        String sql = null;
        ArrayList<Item> itemList = new ArrayList<Item>();
        
        try
        {
        	if(memAddress.size() == 1) {
        		  sql = "select * from (select ROWNUM as rnum, n.* from (select * from item where item_main_category like (?) and item_sub_category like (?) and item_deal_region in (?) order by item_no desc)n) where rnum between ? and ?";
        		  pstmt = conn.prepareStatement(sql);
                  pstmt.setString(1, "%" + mainCategory + "%");
                  pstmt.setString(2, "%" + subCategory + "%");
                  pstmt.setString(3, memAddress.get(0));
                  pstmt.setInt(4, start);
                  pstmt.setInt(5, end);
        	}else if(memAddress.size() == 2) {
      		  sql = "select * from (select ROWNUM as rnum, n.* from (select * from item where item_main_category like (?) and item_sub_category like (?) and item_deal_region in (?,?) order by item_no desc)n) where rnum between ? and ?";
      		  pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, "%" + mainCategory + "%");
                pstmt.setString(2, "%" + subCategory + "%");
                pstmt.setString(3, memAddress.get(0));
                pstmt.setString(4, memAddress.get(1));
                pstmt.setInt(5, start);
                pstmt.setInt(6, end);
        	}else if(memAddress.size() == 3) {
        		  sql = "select * from (select ROWNUM as rnum, n.* from (select * from item where item_main_category like (?) and item_sub_category like (?) and item_deal_region in (?,?,?) order by item_no desc)n) where rnum between ? and ?";
          		  pstmt = conn.prepareStatement(sql);
                    pstmt.setString(1, "%" + mainCategory + "%");
                    pstmt.setString(2, "%" + subCategory + "%");
                    pstmt.setString(3, memAddress.get(0));
                    pstmt.setString(4, memAddress.get(1));
                    pstmt.setString(5, memAddress.get(2));
                    pstmt.setInt(6, start);
                    pstmt.setInt(7, end);
        	}
        	
        	
            
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
                
                
                
                
                itemList.add(i);
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
        
        return itemList;
	}

	public ArrayList<Item> getCategorySearchList(Connection conn, String mainCategory, ArrayList<String> memAddress,
			int start, int end) {
		PreparedStatement pstmt = null;
        ResultSet rset = null;
        String sql = null;
        ArrayList<Item> itemList = new ArrayList<Item>();
        
        try
        {
        	if(memAddress.size() == 1) {
        		  sql = "select * from (select ROWNUM as rnum, n.* from (select * from item where item_main_category like (?) and item_deal_region in (?) order by item_no desc)n) where rnum between ? and ?";
        		  pstmt = conn.prepareStatement(sql);
                  pstmt.setString(1, "%" + mainCategory + "%");
                  pstmt.setString(2, memAddress.get(0));
                  pstmt.setInt(3, start);
                  pstmt.setInt(4, end);
        	}else if(memAddress.size() == 2) {
      		  sql = "select * from (select ROWNUM as rnum, n.* from (select * from item where item_main_category like (?) and item_deal_region in (?,?) order by item_no desc)n) where rnum between ? and ?";
      		  pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, "%" + mainCategory + "%");
                pstmt.setString(2, memAddress.get(0));
                pstmt.setString(3, memAddress.get(1));
                pstmt.setInt(4, start);
                pstmt.setInt(5, end);
        	}else if(memAddress.size() == 3) {
        		  sql = "select * from (select ROWNUM as rnum, n.* from (select * from item where item_main_category like (?) and item_deal_region in (?,?,?) order by item_no desc)n) where rnum between ? and ?";
          		  pstmt = conn.prepareStatement(sql);
                    pstmt.setString(1, "%" + mainCategory + "%");
                    pstmt.setString(2, memAddress.get(0));
                    pstmt.setString(3, memAddress.get(1));
                    pstmt.setString(4, memAddress.get(2));
                    pstmt.setInt(5, start);
                    pstmt.setInt(6, end);
        	}
        	
        	
            
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
                
                
                
                
                itemList.add(i);
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
        
        return itemList;
	}

	
	
	
	/* 검색 테이블 관련*/
	
	public Search selectByKeyword(Connection conn, String keyword) {
		PreparedStatement pstmt = null;
        ResultSet rset = null;
        String sql = "select * from search where search_content=?";
        Search result = null;
        
        
        try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, keyword);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				result = new Search();
				result.setSearchNo(rset.getInt("search_no"));
				result.setSearchContent(rset.getString("search_content"));
				result.setSearchDate(rset.getDate("search_date"));
				result.setSearchCount(rset.getInt("search_count"));
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
        
        return result;
	}

	public int insertSearch(Connection conn, String keyword) {
		PreparedStatement pstmt = null;
        String sql = "insert into search values(search_no_seq.nextval, ?, sysdate, 1)";
        int result = 0;
        
        try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, keyword);
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
        
        return result;
	}

	public int updateSearch(Connection conn, String keyword, int count) {
		PreparedStatement pstmt = null;
        String sql = "update search set search_count=? where search_content=?";
        int result = 0;
        
        try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, count+1);
			pstmt.setString(2, keyword);
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
        
        return result;
	}

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
