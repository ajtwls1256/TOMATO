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
 * Servlet implementation class InsertItemInquiryReplyServlet
 */
@WebServlet(name = "InsertItemInquiryReply", urlPatterns = { "/insertItemInquiryReply" })
public class InsertItemInquiryReplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertItemInquiryReplyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int itemInquiryNo = Integer.parseInt(request.getParameter("itemInquiryNo"));
		int itemRef = Integer.parseInt(request.getParameter("itemRef"));
		int itemInquiryRef = 1;
		int itemInquiryLevel = 2;
		String itemInquiryWriter = request.getParameter("itemInquiryWriter");
		String content  =  request.getParameter("itemFormTextareaReplyContent");
		SellPageService service = new SellPageService();
		int result = service.insertItemInquiryReply(itemInquiryNo,itemRef,itemInquiryRef,itemInquiryLevel,itemInquiryWriter,content);
		
		
		if(result ==1  ) {
			 
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/sellPage/gosellPage.jsp");
			request.setAttribute("itemNo", itemRef);
			
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
