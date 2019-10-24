package kr.co.tomato.admin.adminPayment.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.tomato.admin.adminPayment.model.service.AdminPaymentService;

/**
 * Servlet implementation class AdminPaymentDeleteServlet
 */
@WebServlet(name = "AdminPaymentDelete", urlPatterns = { "/adminPaymentDelete" })
public class AdminPaymentDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminPaymentDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 인코딩
		request.setCharacterEncoding("UTF-8");
		//2. 변수 저장
		String merchantUid = request.getParameter("merchantUid");
		//3. 비지니스 로직
		AdminPaymentService service = new AdminPaymentService();
		int result = service.adminPaymentListDelete(merchantUid);
		//4. view
		if(result>0) {
			request.setAttribute("msg", "삭제 성공");
			request.setAttribute("loc", "/adminPaymentList"); 
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
			rd.forward(request, response);
		}else {
			request.setAttribute("msg", "삭제 실패"); 
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
			request.setAttribute("loc", "/adminPaymentList"); 
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
