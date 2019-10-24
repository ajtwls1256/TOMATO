package kr.co.tomato.notice.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.tomato.notice.model.service.NoticeService;

/**
 * Servlet implementation class AdminNoticeInsertServlet
 */
@WebServlet(name = "adminNoticeInsert", urlPatterns = { "/adminNoticeInsert" })
public class AdminNoticeInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminNoticeInsertServlet() {
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

		String title = request.getParameter("title");
		String content = request.getParameter("content");

		NoticeService service = new NoticeService();
		int result = service.adminNoticeInsert(title, content);

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");

		if (result > 0) {
			request.setAttribute("msg", "입력완료");
			request.setAttribute("loc", "/noticeAdmin");
		} else {
			request.setAttribute("msg", "입력실패 ");
			request.setAttribute("loc", "/noticeAdmin");
		}

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