package kr.co.tomato.sellPage.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.tomato.sellPage.model.service.SellPageService;
import kr.co.tomato.vo.Member;

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
		request.setCharacterEncoding("utf-8");
		SellPageService service = new SellPageService();
		
		/*결제*/
		String merchantUid = request.getParameter("merchantUid");
		int itemNo = Integer.parseInt(request.getParameter("itemNo"));
		int memberNo = Integer.parseInt(request.getParameter("memberNo"));
		String impUid = request.getParameter("impUid");
		int paymentPay = Integer.parseInt(request.getParameter("paidAmount"));
		int paymentDate = Integer.parseInt(request.getParameter("paidAtnumber"));
		String paymentState = request.getParameter("state");
		String paymentApplyNum = request.getParameter("payApplyNum");
		int commission = 500;
		
		int result1 = service.insertPayment(merchantUid,itemNo,memberNo,impUid,paymentPay,paymentDate,paymentApplyNum,commission,paymentState);
		
		/*거래*/
		
		int saler = Integer.parseInt(request.getParameter("memberNo"));
		int buyer = Integer.parseInt(request.getParameter("buyerNo"));
		String dealState = request.getParameter("status");
		
		
		int result2=service.insertDeal(buyer,saler,dealState,itemNo);
		
				if(result1==1&&result2==1) {
			
					response.setStatus(itemNo);
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
