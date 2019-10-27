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
import kr.co.tomato.vo.PageData2;
import oracle.net.aso.p;

/**
 * Servlet implementation class NoticeMTMAdminServlet
 */
@WebServlet(name = "NoticeMTMAdmin", urlPatterns = { "/noticeMTMAdmin" })
public class NoticeMTMAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeMTMAdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		

		//페이징 처리 
				int reqPage;
				try {
					reqPage = Integer.parseInt(request.getParameter("reqPage"));
							
				} catch (NumberFormatException e) {
					// TODO: handle exception
					reqPage = 1;
				}
				
				
		NoticeMTMService service = new NoticeMTMService();
		PageData2 pd = service.noticeMTMAdmin2(reqPage);
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
