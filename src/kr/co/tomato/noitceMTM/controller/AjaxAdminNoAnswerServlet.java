package kr.co.tomato.noitceMTM.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.google.gson.Gson;

import kr.co.tomato.noitceMTM.model.service.NoticeMTMService;
import kr.co.tomato.noitceMTM.model.vo.NoticeMTM;

/**
 * Servlet implementation class AjaxAdminNoAnswerServlet
 */
@WebServlet(name = "AjaxAdminNoAnswer", urlPatterns = { "/ajaxAdminNoAnswer" })
public class AjaxAdminNoAnswerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AjaxAdminNoAnswerServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		int no = Integer.parseInt(request.getParameter("MTM"));

		NoticeMTMService service = new NoticeMTMService();
		NoticeMTM mtm = service.AdminAnswerSearch(no);
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		new Gson().toJson(mtm,response.getWriter());
		//gson 사용 방법
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
