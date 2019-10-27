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
import kr.co.tomato.vo.PageData;
import kr.co.tomato.vo.PageData2;

/**
 * Servlet implementation class NoticeMTMSelectServlet
 */
@WebServlet(name = "NoticeMTMSelect", urlPatterns = { "/noticeMTMSelect" })
public class NoticeMTMSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeMTMSelectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		NoticeMTMService service = new NoticeMTMService();
		
		ArrayList<NoticeMTM> list = service.noticeMTMAdmin();
		
		request.setAttribute("list", list);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/notice/noticeMTM.jsp");
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
