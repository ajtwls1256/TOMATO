package kr.co.tomato.main.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.tomato.main.model.service.MainService;
import kr.co.tomato.vo.Item;

/**
 * Servlet implementation class MainListOneServlet
 */
@WebServlet(name = "MainListOne", urlPatterns = { "/mainListOne" })
public class MainListOneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainListOneServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
				
		String email = request.getParameter("email");
		
		System.out.println("Servlet email :" + email);
		
		MainService service = new MainService();
		ArrayList<Item> iList = service.mainItemListData(email);

		//4. view 처리		
        // 값 전달을 해야하는 경우 RequestDispatcher
        request.setAttribute("iList", iList);
        request.setAttribute("size", iList.size());//0이면 선호하는 지역 없음
        System.out.println(iList.size());
        
        RequestDispatcher rd =  request.getRequestDispatcher("/");
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
