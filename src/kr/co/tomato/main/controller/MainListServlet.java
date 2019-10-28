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
@WebServlet(name = "MainList", urlPatterns = { "/mainList" })
public class MainListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
				
		String email = request.getParameter("email");
				
		MainService service = new MainService();
		ArrayList<ArrayList<Item>> result = service.mainItemListData(email);		
		
		//4. view 처리		
        // 값 전달을 해야하는 경우 RequestDispatcher
        request.setAttribute("iList", result.get(0));
        request.setAttribute("list1", result.get(1));
        request.setAttribute("list2", result.get(2));
        request.setAttribute("list3", result.get(3));
        request.setAttribute("list4", result.get(4));
        request.setAttribute("list5", result.get(5));
        request.setAttribute("list6", result.get(6));
        request.setAttribute("list7", result.get(7));
        
        request.setAttribute("size", result.get(0).size());//0이면 선호하는 지역 없음
        
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
