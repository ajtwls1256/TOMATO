package kr.co.tomato.product.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.tomato.product.model.service.ItemImgService;

/**
 * Servlet implementation class ItemImgListServlet
 */
@WebServlet(name = "ItemImgList", urlPatterns = { "/itemImgList" })
public class ItemImgListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItemImgListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ItemImgService service = new ItemImgService();
		int totalCount = service.ItemImgTotalCount();
		request.setAttribute("totalCount", totalCount);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/product/enroll.jsp");
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
