package kr.co.tomato.common;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


public class JDBCTemplate {
	
	
	public JDBCTemplate() {
	}

	// Connection 객체 생성 메소드
	
	//static 정적변수!

	public static Connection getConnection() {

		Connection conn = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "tomato_db", "1234");


			// 자동으로 commit을 지원해주는 기능을 해제
			conn.setAutoCommit(false);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return conn;
	}

	public static void close(Connection conn) {

		try {
			if (conn != null && !conn.isClosed()) {
				conn.close(); // 만약의 경우대비
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 커밋용 메소드
	public static void commit(Connection conn) {
		try {
			if (conn != null && !conn.isClosed()) {
				conn.commit();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void rollback(Connection conn) {

		try {
			if (conn != null && !conn.isClosed()) {
				conn.rollback();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	
	// stmt , pstmt, rset
	// 얘네도 객체화 해줘야됨!

	public static void close(Statement stmt) {
		try {
			if (stmt != null && !stmt.isClosed()) {
				stmt.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

//	public void close(PreparedStatement pstmt) {
//		try {
//			if (pstmt != null && !pstmt.isClosed()) {
//				pstmt.close();
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	} 
	
// 지우는 이유는 다형성 때문에 stmt 를 만들었기 때문에 지워도 된다!!!!!!!!!!!!

	public static void close(ResultSet rset) {
		try {
			if (rset != null && !rset.isClosed()) {
				rset.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
