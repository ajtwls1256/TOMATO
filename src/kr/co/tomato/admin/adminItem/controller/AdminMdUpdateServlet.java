package kr.co.tomato.admin.adminItem.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.co.tomato.admin.adminItem.model.service.AdminMdService;

/**
 * Servlet implementation class AdminMdUpdateServlet
 */
@WebServlet(name = "AdminMdUpdate", urlPatterns = { "/adminMdUpdate" })
public class AdminMdUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminMdUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int itemNo = Integer.parseInt(request.getParameter("itemNo"));
		String itemState = request.getParameter("select1");
		String itemDealState = request.getParameter("select2");
		
		AdminMdService service = new AdminMdService();
		int result = service.adminMdUpdate(itemNo,itemState,itemDealState);
		
		//ajax 데이터 처리
		response.setContentType("application/json; charset=utf-8"); 
		new Gson().toJson(result, response.getWriter());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
