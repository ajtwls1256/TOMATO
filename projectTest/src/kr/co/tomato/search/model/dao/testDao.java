package kr.co.tomato.search.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.co.tomato.common.JDBCTemplate;



public class testDao
{

    public ArrayList<String> allTest(Connection conn)
    {
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        String sql = "select t_test_name from t_test";
        ArrayList<String> list = new ArrayList<>();
        
        
        try
        {
            pstmt = conn.prepareStatement(sql);
            rset = pstmt.executeQuery();
            
            while(rset.next()) {
                list.add(rset.getString("t_test_name"));
            }
            
        }
        catch (SQLException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            JDBCTemplate.close(rset);
            JDBCTemplate.close(pstmt);
        }
        
        return list;
    }
    
}
