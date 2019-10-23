package kr.co.tomato.noitceMTM.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.tomato.noitceMTM.model.service.NoticeMTMService;

/**
 * Servlet implementation class NoticeMTMAdminInsertServlet
 */
@WebServlet(name = "NoticeMTMAdminInsert", urlPatterns = { "/noticeMTMAdminInsert" })
public class NoticeMTMAdminInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeMTMAdminInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String content = request.getParameter("content");
		int no = Integer.parseInt(request.getParameter("no"));
		NoticeMTMService service = new NoticeMTMService();
		int result = service.NoticeMTMAdminInsert(content, no);
		
		if(result>0) {
			request.setAttribute("msg", "업데이트 성공");
		}else {
			request.setAttribute("msg", "업데이트 실패");
		}
		request.setAttribute("loc", "/noticeMTMAdmin");
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		
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
