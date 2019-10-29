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
 * Servlet implementation class ItemBuyCompleteServlet
 */
@WebServlet(name = "ItemBuyComplete", urlPatterns = { "/itemBuyComplete" })
public class ItemBuyCompleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItemBuyCompleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int dealItemNo = Integer.parseInt(request.getParameter("dealItemNo"));
		String email = request.getParameter("memberEmail");
		int memberNo = Integer.parseInt(request.getParameter("memberNo"));
		MyshopService service = new MyshopService();
		int result = service.updateBuyState(dealItemNo);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		if(result>0) {
			request.setAttribute("msg", "상품 구매 확정 완료!!!");
		}else {
			request.setAttribute("msg", "상품 구매 확정 실패!!!");
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
