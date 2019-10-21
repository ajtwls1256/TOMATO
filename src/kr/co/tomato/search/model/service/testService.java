package kr.co.tomato.search.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import kr.co.tomato.common.JDBCTemplate;
import kr.co.tomato.search.model.dao.testDao;


public class testService
{
    
    public ArrayList<String> allTest() {
        Connection conn = JDBCTemplate.getConnection();
        testDao dao = new testDao();
        
        ArrayList<String> list = dao.allTest(conn);
        
        JDBCTemplate.close(conn);
        return list;
    }
}
