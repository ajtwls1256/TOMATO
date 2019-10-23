package kr.co.tomato.noticeCategory.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.tomato.noticeCategory.model.service.noticeCategoryService;
import kr.co.tomato.noticeCategory.model.vo.noticeCategory;

/**
 * Servlet implementation class AjaxCategoryServlet
 */
@WebServlet(name = "AjaxCategory", urlPatterns = { "/ajaxCategory" })
public class AjaxCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxCategoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String sub = request.getParameter("sub");
		
		noticeCategoryService service = new noticeCategoryService();
		noticeCategory nc = service.searchSub(sub);
		
		PrintWriter out = response.getWriter();
		out.print(nc.getContent());
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
