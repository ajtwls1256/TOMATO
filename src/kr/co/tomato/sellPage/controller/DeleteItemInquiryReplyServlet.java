package kr.co.tomato.sellPage.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.tomato.sellPage.model.service.SellPageService;

/**
 * Servlet implementation class DeleteItemInquiryReplyServlet
 */
@WebServlet(name = "DeleteItemInquiryReply", urlPatterns = { "/deleteItemInquiryReply" })
public class DeleteItemInquiryReplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteItemInquiryReplyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int itemReplyNo = Integer.parseInt(request.getParameter("itemReplyNo"));
		int	itemReplyRef = Integer.parseInt(request.getParameter("itemReplyRef"));
		int itemReplyLevel =Integer.parseInt(request.getParameter("itemReplyLevel"));
		int itemReplyInquiryRef =Integer.parseInt(request.getParameter("itemReplyInquiryRef"));
		
		SellPageService service = new SellPageService();
		int result = service.deleteItemInquiryReply(itemReplyNo,itemReplyRef, itemReplyLevel,itemReplyInquiryRef);
		
		

		if(result ==1 ) {
			 
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/sellPage/gosellPage.jsp");
			request.setAttribute("itemNo", itemReplyRef);
			rd.forward(request, response);
	 }else {
		 
		 RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
			rd.forward(request, response);
	 }
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
