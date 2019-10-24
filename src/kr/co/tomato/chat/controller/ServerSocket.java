package kr.co.tomato.chat.controller;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import kr.co.tomato.member.model.vo.Member;


// 서버측

@ServerEndpoint(value="/server", configurator = GetHttpSessionForWebSocket.class)
public class ServerSocket
{
   
    // 연결된 웹소켓 세션과 해당 세션의 회원No도 같이 저장
    private static Map<Session, Integer> sessions = Collections.synchronizedMap(new HashMap<Session, Integer>());
    
    
    
    
    
    // 클라이언트가 웹소켓서버 접속시 (new WebSocket시) 동작
    @OnOpen
    public void onOpen(Session session, EndpointConfig config) {
        
        
        
        System.out.println("추가된 세션 = " + session);
        
        // EndpointConfig를 통해 같이 넘어온 httpSession
        HttpSession hss = (HttpSession)config.getUserProperties().get(HttpSession.class.getName());
        System.out.println("Http세션 ID = " + hss.getAttribute("member"));
        Member m = (Member)hss.getAttribute("member");
        System.out.println("Http세션 memberNo = " + m.getMemberNo());
        
        
      
        // 연결된 세션을 모아둔 Map에 세션과 http세션의 회원No 추가
        sessions.put(session, m.getMemberNo());
        
    }
    
    
    
    
    // 클라이언트가 webSocket.send()를 통해 메시지를 보낼시
    @OnMessage
    public void onMessage(String message, Session session) throws IOException {
        System.out.println("세션 = " + session);
        System.out.println("전송할 메시지 = " + message);
        System.out.println("전송자의 MemberNo = " + sessions.get(session)); 
        
        
        synchronized (sessions)
        {
            // Iterate over the connected sessions      연결된 세션들을 반복(순회)하며
            // and broadcast the recived messgae        받은 메시지를 공지한다.
            
            for(Session clientSession : sessions.keySet()) {
                // 내 세션(나)가 아닌 다른 사용자들에게 메시지 전송
                if(!clientSession.equals(session)) {
                    clientSession.getBasicRemote().sendText("http세션 memberNo : " + sessions.get(clientSession)+ ", 메시지 : " +  message);  // 여기서 예외처리로 인한 throws 추가
                }
            }
        }
    }
    
    
    
    
    
    // 클라이언트가 접속 종료시
    @OnClose
    public void onClose(Session session) {
        // 연결된 세션을 모아둔 map에서 입력받은 session을 제거
        System.out.println("삭제할 세션 = " + session);
        System.out.println("삭제할 회원의 MemberNo = " + sessions.get(session));
        
        sessions.remove(session);
    }
    
    
    
}
