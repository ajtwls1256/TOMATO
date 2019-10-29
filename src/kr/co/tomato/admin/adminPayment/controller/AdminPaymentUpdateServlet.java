package kr.co.tomato.admin.adminPayment.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.co.tomato.admin.adminPayment.model.service.AdminPaymentService;

/**
 * Servlet implementation class AdminPaymentUpdateServlet
 */
@WebServlet(name = "AdminPaymentUpdate", urlPatterns = { "/adminPaymentUpdate" })
public class AdminPaymentUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminPaymentUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String paymentState = request.getParameter("select1");
		String paymentNy = request.getParameter("select2");
		String merchantUid = request.getParameter("merchantUid");
		int itemNo = Integer.parseInt(request.getParameter("itemNo"));
		System.out.println(itemNo);
		AdminPaymentService service = new AdminPaymentService();
		int result = service.adminPaymentUpdate(paymentState,paymentNy,merchantUid, itemNo);
		
		//ajax 데이터 처리
		response.setContentType("application/json; charset=utf-8"); 
		new Gson().toJson(result, response.getWriter());
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
