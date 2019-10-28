package kr.co.tomato.header.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.co.tomato.header.model.service.HeaderService;
import kr.co.tomato.vo.Search;

/**
 * Servlet implementation class HeaderSearchBoxServlet
 */
@WebServlet(name = "HeaderSearchBox", urlPatterns = { "/headerSearchBox" })
public class HeaderSearchBoxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HeaderSearchBoxServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 인코딩
		request.setCharacterEncoding("utf-8");
		//2. 변수 저장
		
		//3. 비지니스 로직
		HeaderService service = new HeaderService();
		ArrayList<Search> list = service.searchBox();
		
		//4. 뷰처리
		//ajax 데이터 처리
		response.setContentType("application/json; charset=utf-8"); 
		response.setCharacterEncoding("UTF-8");
		new Gson().toJson(list, response.getWriter());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
