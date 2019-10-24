package kr.co.tomato.sellPage.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.tomato.sellPage.model.service.SellPageService;

/**
 * Servlet implementation class SellPageFavoriteServlet
 */
@WebServlet(name = "SellPageFavorite", urlPatterns = { "/sellPageFavorite" })
public class SellPageFavoriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SellPageFavoriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int itemNo = Integer.parseInt(request.getParameter("itemNo"));
		int shopNo =  Integer.parseInt(request.getParameter("shopNo"));
		int favoriteCount = Integer.parseInt(request.getParameter("favoriteCount"))+1;
		
		SellPageService service = new SellPageService();
		service.sellPageFavorite(itemNo,shopNo,favoriteCount);
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
