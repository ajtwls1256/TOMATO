package kr.co.tomato.mypage.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.tomato.mypage.model.service.MypageService;
import kr.co.tomato.vo.Member;

/**
 * Servlet implementation class MypageServlet
 */
@WebServlet(name = "Mypage", urlPatterns = { "/mypage" })
public class MypageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MypageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int mypageNo = Integer.parseInt(request.getParameter("mypageNO"));
		MypageService service = new MypageService();
		Member m = service.mypage(mypageNo);
		
		if(m.getMemberNo() == mypageNo) {
			 
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/mypage/mypage.jsp");
			request.setAttribute("Member", m);
			rd.forward(request, response);
		}else {
		 
		 RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
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
