package kr.co.tomato.admin.adminItem.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.co.tomato.admin.adminItem.model.service.AdminMdService;
import kr.co.tomato.noitceMTM.model.service.NoticeMTMService;
import kr.co.tomato.noitceMTM.model.vo.NoticeMTM;
import kr.co.tomato.vo.Review;

/**
 * Servlet implementation class AjaxAdminReviewServlet
 */
@WebServlet(name = "AjaxAdminReview", urlPatterns = { "/ajaxAdminReview" })
public class AjaxAdminReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxAdminReviewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int no = Integer.parseInt(request.getParameter("no"));
		
		AdminMdService service = new AdminMdService();
		Review r = service.AjaxReview(no);
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		new Gson().toJson(r,response.getWriter());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
