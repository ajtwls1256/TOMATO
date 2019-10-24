package kr.co.tomato.sellPage.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.tomato.sellPage.model.service.SellPageService;
import kr.co.tomato.vo.Item;

/**
 * Servlet implementation class SellPagePopUpServlet
 */
@WebServlet(name = "SellPagePopUp", urlPatterns = { "/sellPagePopUp" })
public class SellPagePopUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SellPagePopUpServlet() {
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
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/sellPage/sellPagePopUp.jsp");
		request.setAttribute("item", item);
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
