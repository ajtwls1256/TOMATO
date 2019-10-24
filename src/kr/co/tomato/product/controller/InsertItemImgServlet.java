package kr.co.tomato.product.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kr.co.tomato.product.model.service.ItemImgService;
import kr.co.tomato.vo.ItemImg;

/**
 * Servlet implementation class InsertItemImgServlet
 */
@WebServlet(name = "InsertItemImg", urlPatterns = { "/insertItemImg" })
public class InsertItemImgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertItemImgServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

	      if(!ServletFileUpload.isMultipartContent(request)) {
	         request.setAttribute("msg", "[enctype] �솗�씤�븯�꽭�슂");
	         request.setAttribute("loc", "/");
	         RequestDispatcher rd = request.getRequestDispatcher("/views/product/enroll.jsp");
	         rd.forward(request, response);
	         return;
	      }

	      String root = getServletContext().getRealPath("/");
	      String saveDirectory = root + "upload/product";
	      
	      int maxSize = 10*640*640;
	      
	      MultipartRequest mRequest = new MultipartRequest(request, saveDirectory, maxSize, "UTF-8", new DefaultFileRenamePolicy());
	      int thumNy = Integer.parseInt(mRequest.getParameter("thumNy"));
	      
	      String filename = mRequest.getOriginalFileName("filename");
	      String filepath = mRequest.getFilesystemName("filename");
	      
	      ItemImg i = new ItemImg(0, filename, filepath, thumNy);
	      ItemImgService service = new ItemImgService();
	      int result = service.insertPhoto(i);
	      
	      if(result > 0) {
	         request.setAttribute("msg", "성공");
	      } else {
	         request.setAttribute("msg", "실패");
	      }
	      request.setAttribute("loc", "/ItemImgList");
	      RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/common/msg.jsp");
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
