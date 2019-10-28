package kr.co.tomato.admin.adminPayment.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.co.tomato.common.JDBCTemplate;
import kr.co.tomato.vo.Payment;

public class AdminPaymentDao {

	public ArrayList<Payment> adminPaymentList(Connection conn, int start, int end) {
		ArrayList<Payment> list = new ArrayList<Payment>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from "
				+ "(select ROWNUM as rnum, n.* from"
				+ "(select * from payment order by merchant_uid desc) n) "
				+ "where rnum between ? and ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				int rnum = rset.getInt("rnum");
				String merchantUid = rset.getString("merchant_uid");
				int itemNo = rset.getInt("item_no");
				int memberNo = rset.getInt("member_no");
				String impUid = rset.getString("imp_uid");
				int paymentPay = rset.getInt("payment_pay");
				String paymentState = rset.getString("payment_state");
				Date paymentDate = rset.getDate("payment_date");
				String paymentApplyNum = rset.getString("payment_apply_num");
				int paymentCommission = rset.getInt("payment_commission");
				String paymentNy = rset.getString("payment_ny");
				Payment p = new Payment(rnum, merchantUid, itemNo, memberNo, impUid, paymentPay, paymentState, paymentDate, paymentApplyNum, paymentCommission, paymentNy);	
				list.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	public int totalCount(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select count(*) as total from payment";
		int result = 0;
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				result = rset.getInt("total");
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

	public int adminPaymentUpdate(Connection conn, String paymentState, String paymentNy, String merchantUid) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "update payment set payment_state = ?, payment_ny = ? where merchant_uid = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, paymentState);
			pstmt.setString(2, paymentNy);
			pstmt.setString(3, merchantUid);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int adminPaymentListDelete(Connection conn, String merchantUid) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "delete from payment where merchant_uid = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, merchantUid);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int itemNoTotalCount(Connection conn, String keyword) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select count(*) as total from payment where item_no like (?)";
		int result = 0;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+keyword+"%");
			rset = pstmt.executeQuery();
			if(rset.next()) {
				result = rset.getInt("total");
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

	public int memberNoTotalCount(Connection conn, String keyword) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select count(*) as total from payment where member_no like (?)";
		int result = 0;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+keyword+"%");
			rset = pstmt.executeQuery();
			if(rset.next()) {
				result = rset.getInt("total");
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

	public int merchantUidTotalCount(Connection conn, String keyword) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select count(*) as total from payment where merchant_uid like (?)";
		int result = 0;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+keyword+"%");
			rset = pstmt.executeQuery();
			if(rset.next()) {
				result = rset.getInt("total");
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

	public int paymentStateTotalCount(Connection conn, String keyword) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select count(*) as total from payment where payment_state like (?)";
		int result = 0;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+keyword+"%");
			rset = pstmt.executeQuery();
			if(rset.next()) {
				result = rset.getInt("total");
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

	
	
	
	public ArrayList<Payment> searchKeywordItemNo(Connection conn, String keyword, int start, int end) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from (select ROWNUM as rnum, n.* from" 
				+ "(select * from payment where item_no like (?) order by merchant_uid desc)n)"  
				+ "where rnum between ? and ?" ;
		ArrayList<Payment> list = new ArrayList<Payment>();
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+keyword+"%");
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Payment p = new Payment();
				p.setRnum(rset.getInt("rnum"));
				p.setMerchantUid(rset.getString("merchant_uid"));
				p.setItemNo(rset.getInt("item_no"));
				p.setMemberNo(rset.getInt("member_no"));
				p.setImpUid(rset.getString("imp_uid"));
				p.setPaymentPay(rset.getInt("payment_pay"));
				p.setPaymentState(rset.getString("payment_state"));
				p.setPaymentDate(rset.getDate("payment_date"));
				p.setPaymentApplyNum(rset.getString("payment_apply_num"));
				p.setPaymentCommission(rset.getInt("payment_commission"));
				p.setPaymentNy(rset.getString("payment_ny"));
				list.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	public ArrayList<Payment> searchKeywordMemberNo(Connection conn, String keyword, int start, int end) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from (select ROWNUM as rnum, n.* from" 
				+ "(select * from payment where member_no like (?) order by merchant_uid desc)n)"  
				+ "where rnum between ? and ?" ;
		ArrayList<Payment> list = new ArrayList<Payment>();
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+keyword+"%");
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Payment p = new Payment();
				p.setRnum(rset.getInt("rnum"));
				p.setMerchantUid(rset.getString("merchant_uid"));
				p.setItemNo(rset.getInt("item_no"));
				p.setMemberNo(rset.getInt("member_no"));
				p.setImpUid(rset.getString("imp_uid"));
				p.setPaymentPay(rset.getInt("payment_pay"));
				p.setPaymentState(rset.getString("payment_state"));
				p.setPaymentDate(rset.getDate("payment_date"));
				p.setPaymentApplyNum(rset.getString("payment_apply_num"));
				p.setPaymentCommission(rset.getInt("payment_commission"));
				p.setPaymentNy(rset.getString("payment_ny"));
				list.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	public ArrayList<Payment> searchKeywordMerchantUid(Connection conn, String keyword, int start, int end) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from (select ROWNUM as rnum, n.* from" 
				+ "(select * from payment where merchant_uid like (?) order by merchant_uid desc)n)"  
				+ "where rnum between ? and ?" ;
		ArrayList<Payment> list = new ArrayList<Payment>();
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+keyword+"%");
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Payment p = new Payment();
				p.setRnum(rset.getInt("rnum"));
				p.setMerchantUid(rset.getString("merchant_uid"));
				p.setItemNo(rset.getInt("item_no"));
				p.setMemberNo(rset.getInt("member_no"));
				p.setImpUid(rset.getString("imp_uid"));
				p.setPaymentPay(rset.getInt("payment_pay"));
				p.setPaymentState(rset.getString("payment_state"));
				p.setPaymentDate(rset.getDate("payment_date"));
				p.setPaymentApplyNum(rset.getString("payment_apply_num"));
				p.setPaymentCommission(rset.getInt("payment_commission"));
				p.setPaymentNy(rset.getString("payment_ny"));
				list.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	public ArrayList<Payment> searchKeywordPaymentState(Connection conn, String keyword, int start, int end) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from (select ROWNUM as rnum, n.* from" 
				+ "(select * from payment where payment_state like (?) order by merchant_uid desc)n)"  
				+ "where rnum between ? and ?" ;
		ArrayList<Payment> list = new ArrayList<Payment>();
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+keyword+"%");
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Payment p = new Payment();
				p.setRnum(rset.getInt("rnum"));
				p.setMerchantUid(rset.getString("merchant_uid"));
				p.setItemNo(rset.getInt("item_no"));
				p.setMemberNo(rset.getInt("member_no"));
				p.setImpUid(rset.getString("imp_uid"));
				p.setPaymentPay(rset.getInt("payment_pay"));
				p.setPaymentState(rset.getString("payment_state"));
				p.setPaymentDate(rset.getDate("payment_date"));
				p.setPaymentApplyNum(rset.getString("payment_apply_num"));
				p.setPaymentCommission(rset.getInt("payment_commission"));
				p.setPaymentNy(rset.getString("payment_ny"));
				list.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}
}
