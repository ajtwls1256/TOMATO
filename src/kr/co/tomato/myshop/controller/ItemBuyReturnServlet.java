package kr.co.tomato.myshop.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.tomato.myshop.model.service.MyshopService;

/**
 * Servlet implementation class ItemBuyReturnServlet
 */
@WebServlet(name = "ItemBuyReturn", urlPatterns = { "/itemBuyReturn" })
public class ItemBuyReturnServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItemBuyReturnServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String dealItemNo = request.getParameter("dealItemNo");
		String email = request.getParameter("memberEmail");
		int memberNo = Integer.parseInt(request.getParameter("memberNo"));
		MyshopService service = new MyshopService();
		int result = service.updateBuyReturnState(dealItemNo);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		if(result>2) {
			request.setAttribute("msg", "상품 반품 신청 완료!!!");
		}else {
			request.setAttribute("msg", "상품 반품 신청 실패!!!");
		}
		request.setAttribute("loc", "/myshopView?email="+email+"&memberNo="+memberNo+"");
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
