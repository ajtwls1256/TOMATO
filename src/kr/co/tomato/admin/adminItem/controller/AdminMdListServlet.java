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
 * Servlet implementation class AdminMdListServlet
 */
@WebServlet(name = "AdminMdList", urlPatterns = { "/adminMdList" })
public class AdminMdListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminMdListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 인코딩
		request.setCharacterEncoding("utf-8");
		int reqPage;
		try {
			reqPage = Integer.parseInt(request.getParameter("reqPage"));
		}catch(NumberFormatException e) {//숫자가 아닌 경우 자동으로 1 넣음
			reqPage = 1;
		}
		AdminMdService service = new AdminMdService();
		AdminMdListPageData amlpd = service.adminMdList(reqPage);
		
		request.setAttribute("amlpd", amlpd);
		RequestDispatcher rd = request.getRequestDispatcher("/admin/adminMdList.jsp");
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
