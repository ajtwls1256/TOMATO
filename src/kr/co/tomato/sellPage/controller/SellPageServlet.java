package kr.co.tomato.sellPage.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.tomato.sellPage.model.service.SellPageService;
import kr.co.tomato.sellPage.model.vo.Item;
import kr.co.tomato.sellPage.model.vo.ItemInquiry;
import kr.co.tomato.sellPage.model.vo.Member;

/**
 * Servlet implementation class SellPageServlet
 */
@WebServlet(name = "SellPage", urlPatterns = { "/sellPage" })
public class SellPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SellPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		int itemNo = Integer.parseInt(request.getParameter("itemNo"));
		SellPageService service = new SellPageService();
		Item item = service.sellpage(itemNo);
		ArrayList<ItemInquiry> inquiry = service.itemInquiry(itemNo);
		int result = service.readcount(itemNo);
		
		
		
		if(item.getItemNo() == itemNo &&result ==1  ) {
			 
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/sellPage/sellpage.jsp");
				request.setAttribute("item", item);
				request.setAttribute("item_inquiy", inquiry);
				
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
