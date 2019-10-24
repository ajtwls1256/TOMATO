package kr.co.tomato.admin.adminMember.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.tomato.admin.adminMember.model.service.AdminMemberService;
import kr.co.tomato.vo.AdminMemberListPageData;

/**
 * Servlet implementation class AdminMemberListServlet
 */
@WebServlet(name = "AdminMemberList", urlPatterns = { "/adminMemberList" })
public class AdminMemberListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminMemberListServlet() {
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
		}catch(NumberFormatException e) {//숫자가 아닌 경우 자동으로 1 넣음
			reqPage = 1;
		}
		//3. 비지니스 로직
		AdminMemberService service = new AdminMemberService();
		AdminMemberListPageData amlpd = service.AdminMemberList(reqPage);
		//4. view 처리
		RequestDispatcher rd = request.getRequestDispatcher("/admin/adminMember.jsp");
		
		request.setAttribute("amlpd", amlpd);
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
