package kr.co.tomato.product.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.tomato.product.model.service.ItemService;

/**
 * Servlet implementation class DeleteItemServlet
 */
@WebServlet(name = "DeleteItem", urlPatterns = { "/deleteItem" })
public class DeleteItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteItemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	    int itemNo = Integer.parseInt(request.getParameter("itemNo"));
	    int memberNo = Integer.parseInt(request.getParameter("memberNo"));
	    
	    ItemService service = new ItemService();
	    int result = service.deleteItem(itemNo);
	    if(result > 0) {
	    	RequestDispatcher rd = request.getRequestDispatcher("/itemList?memberNo="+memberNo+"");
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
