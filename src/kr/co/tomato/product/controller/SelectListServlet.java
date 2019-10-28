package kr.co.tomato.product.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.tomato.product.model.service.ItemService;
import kr.co.tomato.vo.PageData;

/**
 * Servlet implementation class SelectListServlet
 */
@WebServlet(name = "SelectList", urlPatterns = { "/selectList" })
public class SelectListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int reqPage;
		try {
			reqPage = Integer.parseInt(request.getParameter("reqPage"));
		} catch(NumberFormatException e) {
			reqPage = 1;
		}
		
		ItemService service = new ItemService();
		PageData pd = service.selectList(reqPage);
		
		request.setAttribute("list",  pd.getList());
		request.setAttribute("pageNavi", pd.getPageNavi());
		RequestDispatcher rd = request.getRequestDispatcher("/views/list.jsp");
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
