package kr.co.tomato.myshop.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.tomato.member.model.dao.MemberDao;
import kr.co.tomato.member.model.service.MemberService;
import kr.co.tomato.member.model.vo.Member;
import kr.co.tomato.myshop.model.service.MyshopService;
import kr.co.tomato.myshop.model.vo.MyshopData;
import kr.co.tomato.sellPage.model.vo.Item;

/**
 * Servlet implementation class MyshopViewServlet
 */
@WebServlet(name = "MyshopView", urlPatterns = { "/myshopView" })
public class MyshopViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyshopViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("내상점 서블릿 시작");
		request.setCharacterEncoding("utf-8");
		String email = request.getParameter("email");
		int memberNo = Integer.parseInt(request.getParameter("memberNo"));
		MyshopService service = new MyshopService();
		MyshopData data = service.selectMyshop(email,memberNo);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/member/myShop.jsp");
		request.setAttribute("myshopData", data);
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
