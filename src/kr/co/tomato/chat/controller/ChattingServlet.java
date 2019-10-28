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
 * Servlet implementation class ChattingServlet
 */
@WebServlet(name = "Chatting", urlPatterns = { "/chatting" })
public class ChattingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChattingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		
		int senderNo = Integer.parseInt(request.getParameter("senderNo"));
		System.out.println("list로부터 넘겨받은 senderNo값 = " + senderNo);
		int receiverNo = Integer.parseInt(request.getParameter("receiverNo"));
		System.out.println("list로부터 넘겨받은 receiverNo값 = " + receiverNo);
		
		
		ChatService service = new ChatService();
		ArrayList<Chat> chattingList = service.getChattingList(senderNo, receiverNo);
		
		request.setAttribute("chattingList", chattingList);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/chat/chatting.jsp");
		
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
