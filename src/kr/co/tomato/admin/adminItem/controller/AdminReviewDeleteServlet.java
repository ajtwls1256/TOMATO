package kr.co.tomato.admin.adminItem.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.tomato.admin.adminItem.model.service.AdminMdService;

/**
 * Servlet implementation class AdminReviewDeleteServlet
 */
@WebServlet(name = "AdminReviewDelete", urlPatterns = { "/adminReviewDelete" })
public class AdminReviewDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminReviewDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int no = Integer.parseInt(request.getParameter("reviewNo"));
		
		AdminMdService service = new AdminMdService();
		int result = service.reviewDelete(no);
		
		if(result>0) {
			request.setAttribute("msg", "삭제성공");
		}else {
			request.setAttribute("msg", "삭제실패");
		}
		request.setAttribute("loc", "/adminReview");
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
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
