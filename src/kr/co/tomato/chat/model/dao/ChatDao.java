package kr.co.tomato.chat.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.co.tomato.common.JDBCTemplate;
import kr.co.tomato.vo.Chat;

public class ChatDao {

	public int insertChat(Connection conn, Chat c) {
		PreparedStatement pstmt = null;
	    int result = 0;
	    String sql = "insert into chat values (chat_no_seq.nextval,?,?,?,?,?,?)";
	    
	    try
	    {
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setInt(1, c.getSenderNo());
	        pstmt.setString(2, c.getSenderShopName());
	        pstmt.setString(3, c.getSenderFilePath());
	        pstmt.setInt(4, c.getReceiverNo());
	        pstmt.setString(5, c.getChatContent());
	        pstmt.setString(6, c.getChatTime());
	        
	        result = pstmt.executeUpdate();
	    }
	    catch (SQLException e)
	    {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }finally {
	        JDBCTemplate.close(pstmt);
	    }
	    
	    return result;
	}

	
	public ArrayList<Integer> getMyChatNoList(Connection conn, int memberNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = "select sender_no, max(chat_no)as chat_no from chat where receiver_no=? group by sender_no order by chat_no desc";
		ArrayList<Integer> chatNoList = new ArrayList<Integer>();
		
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memberNo);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				int mychatNo = rset.getInt("chat_no");
				chatNoList.add(mychatNo);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
	        JDBCTemplate.close(rset);
	        JDBCTemplate.close(pstmt);
	    }

		
		return chatNoList;
	}
	
	
	public Chat getChat(Connection conn, int chat_No) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = "select * from chat where chat_no=?";
		Chat c = null;
		
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, chat_No);

			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				int chatNo = rset.getInt("chat_no");
				int senderNo = rset.getInt("sender_no");
				String senderShopName = rset.getString("sender_shop_name");
				String senderFilePath = rset.getString("sender_file_path");
				int receiverNo = rset.getInt("receiver_no");
				String chatContent = rset.getString("chat_content");
				String chatTime = rset.getString("chat_time");
			
				c = new Chat(chatNo, senderNo, senderShopName, senderFilePath, receiverNo, chatContent, chatTime);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
	        JDBCTemplate.close(rset);
	        JDBCTemplate.close(pstmt);
	    }
		
		return c;
	}


	public ArrayList<Chat> getChattingList(Connection conn, int sender_No, int receiver_No) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = "select * from chat where sender_no in (?,?) and receiver_no in (?,?) order by chat_no";
		ArrayList<Chat> chattingList = new ArrayList<Chat>();
		
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, sender_No);
			pstmt.setInt(2, receiver_No);
			pstmt.setInt(3, sender_No);
			pstmt.setInt(4, receiver_No);

			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				int chatNo = rset.getInt("chat_no");
				int senderNo = rset.getInt("sender_no");
				String senderShopName = rset.getString("sender_shop_name");
				String senderFilePath = rset.getString("sender_file_path");
				int receiverNo = rset.getInt("receiver_no");
				String chatContent = rset.getString("chat_content");
				String chatTime = rset.getString("chat_time");
			
				Chat c = new Chat(chatNo, senderNo, senderShopName, senderFilePath, receiverNo, chatContent, chatTime);
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
