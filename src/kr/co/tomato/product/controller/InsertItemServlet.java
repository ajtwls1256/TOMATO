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

import kr.co.tomato.product.model.service.ItemService;
import kr.co.tomato.vo.Item;
import kr.co.tomato.vo.ItemImg;

/**
 * Servlet implementation class InsertItemImgServlet
 */
@WebServlet(name = "InsertItem", urlPatterns = { "/insertItem" })
public class InsertItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertItemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

			// 입력받은 form의 타입이 multipart 타입이 아니면 종료
	      if(!ServletFileUpload.isMultipartContent(request)) {
	    	 System.out.println("form의 type이 잘못되었습니다.");
	         return;
	      }

	      // 실제 경로 찾기
	      String root = getServletContext().getRealPath("/");
	      String saveDirectory = root + "/upload/product";
	      
	      int maxSize = 10*640*640;
	      
	      MultipartRequest mRequest = new MultipartRequest(request, saveDirectory, maxSize, "UTF-8", new DefaultFileRenamePolicy());
	      
	      /* 변수 저장 */
	      
	      // 파일이름을 통해 파일이름과, 파일경로 저장
	      String filename = mRequest.getOriginalFileName("filename");
	      String filepath = mRequest.getFilesystemName("filename");
	      
	      // 회원번호, 거래지역 찾아서 넣기!!!!!!!
	      String itemName = mRequest.getParameter("itemName");
	      String itemMainCategory = mRequest.getParameter("itemMainCategory");
	      String itemSubCategoty = mRequest.getParameter("itemSubCategory");
	      int itemPrice = Integer.parseInt(mRequest.getParameter("itemPrice"));
	      String itemState = mRequest.getParameter("itemState");
	      String itemContent = mRequest.getParameter("itemContent");
	      int itemDeliveryNY=1;
	      try {
	    	  itemDeliveryNY = Integer.parseInt(mRequest.getParameter("itemDeliveryNY"));
	      }catch(Exception e) {
	    	  itemDeliveryNY=0;
	      }
	      int itemAmount = Integer.parseInt(mRequest.getParameter("itemAmount"));
	      
	      System.out.println(itemContent);
	      Item item = new Item(-1, -1, itemName, itemMainCategory, itemSubCategoty, itemPrice, null, itemState, 0, itemContent, itemAmount, itemDeliveryNY, null, filename, filepath, "판매중");
	      
	      
	      
	      ItemService service = new ItemService();
	      int result = service.insertItem(item);
	      
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
