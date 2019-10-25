package kr.co.tomato.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

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
@WebServlet(name = "AjaxUpdateMember", urlPatterns = { "/ajaxUpdateMember" })
public class AjaxUpdateMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxUpdateMemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		System.out.println("member update 서블릿 시작");
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		String phone = request.getParameter("phone");
		String zipCode = request.getParameter("zipCode");
		String addr = request.getParameter("address");
		String memberName = request.getParameter("name");
		String memberBank = request.getParameter("memberBank");
		String memberAccount = request.getParameter("memberAccount");
		Member m = new Member(0, 0, email, pw, memberName, null, phone, addr, zipCode, memberBank, memberAccount, null, null, 0, null, null);
		MemberService service = new MemberService();
		int result = service.updateMember(m);
		if(result>0) {
			Member mem = service.selectOne(email);
			HttpSession session = request.getSession(false);
			session.setAttribute("member", mem);
		}
		PrintWriter out = response.getWriter();
		out.print(result);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
