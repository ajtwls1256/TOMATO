package kr.co.tomato.admin.adminItem.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.beans.editors.IntegerEditor;

import kr.co.tomato.admin.adminItem.model.service.AdminMdService;

/**
 * Servlet implementation class AdminMdListDeleteServlet
 */
@WebServlet(name = "AdminMdListDelete", urlPatterns = { "/adminMdListDelete" })
public class AdminMdListDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminMdListDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 인코딩
		request.setCharacterEncoding("UTF-8");
		//2. 변수 저장
		int itemNo = Integer.parseInt(request.getParameter("itemNo"));
		//3. 비지니스 로직
		AdminMdService service = new AdminMdService();
		int result = service.adminMdListDelete(itemNo);
		//4. view
		if(result>0) {
			request.setAttribute("msg", "삭제 성공");
			request.setAttribute("loc", "/adminMdList"); 
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
			rd.forward(request, response);
		}else {
			request.setAttribute("msg", "삭제 실패"); 
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
			request.setAttribute("loc", "/adminMdList"); 
			rd.forward(request, response);
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
