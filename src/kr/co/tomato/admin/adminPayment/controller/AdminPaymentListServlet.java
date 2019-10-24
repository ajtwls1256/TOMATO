package kr.co.tomato.admin.adminPayment.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.tomato.admin.adminPayment.model.service.AdminPaymentService;
import kr.co.tomato.vo.AdminPaymentListPageData;

/**
 * Servlet implementation class AdminPaymentListServlet
 */
@WebServlet(name = "AdminPaymentList", urlPatterns = { "/adminPaymentList" })
public class AdminPaymentListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminPaymentListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int reqPage;
		try {
			reqPage = Integer.parseInt(request.getParameter("reqPage"));
		}catch(NumberFormatException e) {//숫자가 아닌 경우 자동으로 1 넣음
			reqPage = 1;
		}
		AdminPaymentService service = new AdminPaymentService();
		AdminPaymentListPageData aplpd = service.adminPaymentList(reqPage);
		
		request.setAttribute("aplpd", aplpd);
		RequestDispatcher rd = request.getRequestDispatcher("/admin/adminPayment.jsp");
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
