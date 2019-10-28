package kr.co.tomato.sellPage.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.tomato.sellPage.model.service.SellPageService;

/**
 * Servlet implementation class InsertItemInquiryServlet
 */
@WebServlet(name = "InsertItemInquiry", urlPatterns = { "/insertItemInquiry" })
public class InsertItemInquiryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertItemInquiryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String textarea = request.getParameter("textarea");
		int itemNo = Integer.parseInt(request.getParameter("itemNo"));
		int inquiryLevel = Integer.parseInt(request.getParameter("inquiryLevel"));
		
		String memberName  = request.getParameter("memberName");
		SellPageService service = new SellPageService();
		int result = service.insertItemInquiry(textarea,itemNo,memberName,inquiryLevel);
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
