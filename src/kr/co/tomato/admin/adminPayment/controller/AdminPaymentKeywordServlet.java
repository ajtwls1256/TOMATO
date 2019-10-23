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
 * Servlet implementation class AdminPaymentKeywordServlet
 */
@WebServlet(name = "adminPaymentKeyword", urlPatterns = { "/adminPaymentKeyword" })
public class AdminPaymentKeywordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminPaymentKeywordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 인코딩
		request.setCharacterEncoding("utf-8");
		//2. 변수저장
		int reqPage;
		try {
			reqPage = Integer.parseInt(request.getParameter("reqPage"));
		}catch(NumberFormatException e) {
			reqPage = 1;
		}
		String type = request.getParameter("type");
		String keyword = request.getParameter("keyword");
		//3. 비지니스 로직
		AdminPaymentService service = new AdminPaymentService();
		AdminPaymentListPageData aplpd = service.AdminPaymentListSearch(reqPage,type,keyword);
		
		RequestDispatcher rd = request.getRequestDispatcher("/admin/adminPayment.jsp");
		request.setAttribute("aplpd", aplpd);
		request.setAttribute("type", type);
		request.setAttribute("keyword", keyword);
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
