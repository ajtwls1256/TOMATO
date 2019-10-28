package kr.co.tomato.sellPage.controller;

import java.io.IOException;
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
		
		int itemInquiryNo = Integer.parseInt(request.getParameter("itemInquiryNo"));
		int itemRef = Integer.parseInt(request.getParameter("itemRef"))+1;
		int itemInquiryRef = Integer.parseInt(request.getParameter("itemInquiryRef"));
		int itemNo = Integer.parseInt(request.getParameter("itemNo"));
		String content  =  request.getParameter("itemTextareaReply");
		SellPageService service = new SellPageService();
		int result = service.insertItemInquiryReply(itemInquiryNo,itemRef,itemInquiryRef,content );
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
