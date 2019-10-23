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
 * Servlet implementation class SearchMemberKeywordServlet
 */
@WebServlet(name = "SearchMemberKeyword", urlPatterns = { "/searchMemberKeyword" })
public class SearchMemberKeywordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchMemberKeywordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 인코딩
		request.setCharacterEncoding("utf-8");
		//2. 변수 저장
		int reqPage;
		try {
			reqPage = Integer.parseInt(request.getParameter("reqPage"));
		}catch(NumberFormatException e) {//숫자가 아닌 경우 자동으로 1 넣음
			reqPage = 1;
		}
		String type = request.getParameter("type");
		String keyword = request.getParameter("keyword");
		//3. 비지니스 로직
		AdminMemberService service = new AdminMemberService();
		AdminMemberListPageData amlpd = service.AdminMemberSearchList(reqPage,type,keyword);
		//4. view 처리
		RequestDispatcher rd = request.getRequestDispatcher("/admin/adminMember.jsp");
		request.setAttribute("amlpd", amlpd);
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
