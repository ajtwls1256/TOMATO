package kr.co.tomato.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.tomato.member.model.service.MemberService;
import kr.co.tomato.member.model.vo.Member;

/**
 * Servlet implementation class JoinMemberServlet
 */
@WebServlet(name = "AjaxJoin", urlPatterns = { "/ajaxJoin" })
public class AjaxJoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxJoinServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		String addr = request.getParameter("address");
		String zipCode = request.getParameter("zipCode");
		
		Member m = new Member(0, 0, email, pw, null, null, phone, addr, zipCode, null, null, null, null, 0, null, null);
		
		MemberService service = new MemberService();
		int result = service.joinMember(m);
		
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
