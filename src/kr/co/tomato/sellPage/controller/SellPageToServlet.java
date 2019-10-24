package kr.co.tomato.sellPage.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.tomato.sellPage.model.service.SellPageService;
import kr.co.tomato.sellPage.model.vo.Member;

/**
 * Servlet implementation class SellPageToServlet
 */
@WebServlet(name = "SellPageTo", urlPatterns = { "/sellPageTo" })
public class SellPageToServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SellPageToServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SellPageService service = new SellPageService();
		
		/*결제*/
		String mechantUid = request.getParameter("merchantUid");
		int itemNo = Integer.parseInt(request.getParameter("itemNo"));
		int memberNo = Integer.parseInt(request.getParameter("memberNo"));
		String impUid = request.getParameter("impUid");
		int paymentPay = Integer.parseInt(request.getParameter("paid_amount	number"));
		String paymentState = request.getParameter("status");
		String paymentApplyNum = request.getParameter("payApplyNum");
		int commission = 3000;
		/*거래*/
		int buyer = Integer.parseInt(request.getParameter("itemNo"));
		int saler = Integer.parseInt(request.getParameter("memberNo"));
		String dealState = request.getParameter("status");
	}
	
	
	
	
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
