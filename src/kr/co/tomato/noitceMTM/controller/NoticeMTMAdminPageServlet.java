package kr.co.tomato.noitceMTM.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.tomato.noitceMTM.model.service.NoticeMTMService;
import kr.co.tomato.noitceMTM.model.vo.NoticeMTM;
import kr.co.tomato.noitceMTM.model.vo.NoticeMTMPageData;

/**
 * Servlet implementation class NoticeMTMAdminPageServlet
 */
@WebServlet(name = "NoticeMTMAdminPage", urlPatterns = { "/noticeMTMAdminPage" })
public class NoticeMTMAdminPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeMTMAdminPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int reqPage;
		try {
			reqPage = Integer.parseInt(request.getParameter("reqPage"));
		} catch (NumberFormatException e) {
			reqPage = 1;
		}
		
		NoticeMTMService service = new NoticeMTMService();
		NoticeMTMPageData pd = service.noticeMTMAdmin(reqPage);
		request.setAttribute("pd", pd);
		RequestDispatcher rd = request.getRequestDispatcher("/admin/adminNoticeMTM.jsp");
		
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
