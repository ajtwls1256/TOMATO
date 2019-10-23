package kr.co.tomato.admin.adminItem.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.tomato.admin.adminItem.model.service.AdminMdService;
import kr.co.tomato.vo.AdminMdListPageData;

/**
 * Servlet implementation class AdminMdsecrchKeywordServlet
 */
@WebServlet(name = "AdminMdsearchKeyword", urlPatterns = { "/adminMdsearchKeyword" })
public class AdminMdsearchKeywordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminMdsearchKeywordServlet() {
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
		AdminMdService service = new AdminMdService();
		AdminMdListPageData amlpd = service.AdminMdListSearch(reqPage,type,keyword);
		
		RequestDispatcher rd = request.getRequestDispatcher("/admin/adminMdList.jsp");
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
