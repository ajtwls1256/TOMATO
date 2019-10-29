package kr.co.tomato.myshop.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.tomato.myshop.model.service.MyshopService;
import kr.co.tomato.myshop.model.vo.MyshopData;

/**
 * Servlet implementation class VisiteShopServlet
 */
@WebServlet(name = "VisiteShop", urlPatterns = { "/visiteShop" })
public class VisiteShopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VisiteShopServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String email = request.getParameter("visitEmail");
		int memberNo = Integer.parseInt(request.getParameter("visitMemberNo"));
		int shopReadcount = Integer.parseInt(request.getParameter("visitShopReadcount"));
		MyshopService service = new MyshopService();
		int result = service.updateMyshopReadcount(memberNo, shopReadcount);
		if(result>0) {
			System.out.println("상점방문카운트+1");
			RequestDispatcher rd = request.getRequestDispatcher("/myshopView?email="+email+"&memberNo="+memberNo+"");
			rd.forward(request, response);	
		}else {

			System.out.println("상점방문카운트+0");
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
