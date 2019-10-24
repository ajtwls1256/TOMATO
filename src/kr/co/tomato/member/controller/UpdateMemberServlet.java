package kr.co.tomato.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.tomato.member.model.service.MemberService;
import kr.co.tomato.member.model.vo.Member;

/**
 * Servlet implementation class UpdateMemberServlet
 */
@WebServlet(name = "UpdateMember", urlPatterns = { "/updateMember" })
public class UpdateMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateMemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		String phone = request.getParameter("phone");
		String zipCode = request.getParameter("zipCode");
		String addr = request.getParameter("addr");
		String detailAddr = request.getParameter("detailAddr");
		String address = addr+"/"+detailAddr;
		String memberName = request.getParameter("memberName");
		String memberBank = request.getParameter("memberBank");
		String memberAccount = request.getParameter("memberAccount");
		Member m = new Member(0, 0, email, pw, memberName, null, phone, address, zipCode, memberBank, memberAccount, null, null, 0, null, null);
		MemberService service = new MemberService();
		int result = service.updateMember(m);
		
		
		if(result>0) {
			Member mem = service.selectOne(email);
			HttpSession session = request.getSession(false);
			session.setAttribute("member", mem);
			response.sendRedirect("/mypage?email="+email);
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
			request.setAttribute("msg", "수정실패");
			request.setAttribute("loc", "/mypage?email="+email);
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
