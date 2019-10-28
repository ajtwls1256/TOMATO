package kr.co.tomato.chat.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.tomato.chat.model.service.ChatService;
import kr.co.tomato.vo.Chat;

/**
 * Servlet implementation class ChatListServlet
 */
@WebServlet(name = "ChatList", urlPatterns = { "/chatList" })
public class ChatListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChatListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
	    
	    	// 1. 인코딩
            request.setCharacterEncoding("utf-8");
            
            // 2. 변수저장 
            // 로그인을 반드시 하기때문에 null은 안들어올거야..아마..
            int memberNo = Integer.parseInt(request.getParameter("memberNo"));
            System.out.println("chatListServlet에서 전달받은 memberNo = " + memberNo);
            
      
            
            // 3. 비지니스 로직
            ChatService service = new ChatService();
            ArrayList<Chat> myChatList = service.getMyChatList(memberNo);
            
            
            if(myChatList.isEmpty()) {
            	request.setAttribute("chatList", null);
            }else {
            	request.setAttribute("chatList", myChatList);
            }
            
            // 4. view 처리
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/chat/chatList.jsp");
            rd.forward(request, response);
	    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
