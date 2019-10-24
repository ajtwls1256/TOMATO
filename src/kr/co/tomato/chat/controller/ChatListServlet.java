package kr.co.tomato.chat.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	    
	    /* 리스트가 나와야하지만 테스트를위해 채팅으로 바로 구현 */
	    
	    
	    // 1. 인코딩
            request.setCharacterEncoding("utf-8");
            
            // 2. 변수저장
 
            
            // 예외처리를 이용해서 넘겨준 값이 없을때를 처리 

            
            
            // 3. 비지니스 로직

            
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
