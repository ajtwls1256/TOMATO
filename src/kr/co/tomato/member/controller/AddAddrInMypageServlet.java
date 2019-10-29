package kr.co.tomato.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.tomato.member.model.service.MemberService;
import kr.co.tomato.member.model.vo.MemberAddress;

/**
 * Servlet implementation class AddAddrInMypageServlet
 */
@WebServlet(name = "AddAddrInMypage", urlPatterns = { "/addAddrInMypage" })
public class AddAddrInMypageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAddrInMypageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String city = request.getParameter("addCity");
		String gungu = request.getParameter("addGungu");
		String email = request.getParameter("addrEmail");
		MemberAddress mAddr = new MemberAddress(email, city, gungu);
		MemberService service = new MemberService();
		int result = service.addAddress(mAddr);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		if(result>0) {
			request.setAttribute("msg", "관심지역 추가 완료!");
		}else {
			request.setAttribute("msg", "관심지역 추가 실패!");
		}
		request.setAttribute("loc", "/mypage?email="+email+"");
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
