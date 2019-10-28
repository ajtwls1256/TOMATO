package kr.co.tomato.admin.adminItem.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.tomato.sellPage.model.service.SellPageService;
import kr.co.tomato.vo.ItemInquiry;
import kr.co.tomato.vo.Review;

/**
 * Servlet implementation class AdminReviewServlet
 */
@WebServlet(name = "AdminReview", urlPatterns = { "/adminReview" })
public class AdminReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminReviewServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		SellPageService service = new SellPageService();
		ArrayList<Review> list = service.Review();
		request.setAttribute("list", list);

		RequestDispatcher rd = request.getRequestDispatcher("/admin/adminReview.jsp");

		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
