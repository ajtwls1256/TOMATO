package kr.co.tomato.chat.model.service;



import java.sql.Connection;
import java.util.ArrayList;

import kr.co.tomato.chat.model.dao.ChatDao;
import kr.co.tomato.common.JDBCTemplate;
import kr.co.tomato.vo.Chat;

public class ChatService {

	public int insertChat(Chat c) {
		
        Connection conn = JDBCTemplate.getConnection();
        ChatDao dao = new ChatDao();
        
        int result = dao.insertChat(conn, c);
        
        if(result > 0) {
            JDBCTemplate.commit(conn);
        }else {
            JDBCTemplate.rollback(conn);
        }
        
        JDBCTemplate.close(conn);
        return result;
	}
	
	
	
	public ArrayList<Chat> getMyChatList(int memberNo) {
		
		Connection conn = JDBCTemplate.getConnection();
        ChatDao dao = new ChatDao();
        
        ArrayList<Chat> result = new ArrayList<Chat>();
        
        
        // 나랑 채팅한 회원들의 마지막 채팅 번호들을 가져온다
        ArrayList<Integer> chatNoList = dao.getMyChatNoList(conn, memberNo);
        if(chatNoList.isEmpty()) {
        	return result;
        }

        // 확인용
        System.out.print(memberNo + "회원의 마지막 채팅 번호들 : ");
        for(int cNo : chatNoList) {
        	System.out.print(cNo + ",");
        }
        System.out.println();
        
        
        
        
        // 그 번호로 그 채팅들을 가져온다.
        for(int cNo : chatNoList) {
        	Chat c = dao.getChat(conn, cNo);
        	result.add(c);
        	
        	// 확인도 같이하자
        	System.out.println(memberNo + " 회원의 "+ c.getSenderNo() + "회원으로부터 넘어온 chatNo = " + c.getChatNo());
        }
        
        	
        
        JDBCTemplate.close(conn);
        
        return result;
	}



	public ArrayList<Chat> getChattingList(int senderNo, int receiverNo) {
		// 내 번호와 상대방 번호로 채팅목록을 가져옴 
		
		Connection conn = JDBCTemplate.getConnection();
        ChatDao dao = new ChatDao();
        
        ArrayList<Chat> chattingList = dao.getChattingList(conn, senderNo, receiverNo);
        System.out.println("가져온 채팅 크기 = " + chattingList.size());
        
//        for(Chat chat : chattingList) {
//        	System.out.println(receiverNo + " 회원의 "+ senderNo + "회원으로부터 넘어온 chatNo = " + c.getChatNo());
//        }
        
        	
        
        JDBCTemplate.close(conn);
        
        return chattingList;
	}
	

	
}
