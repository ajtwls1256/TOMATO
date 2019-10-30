package kr.co.tomato.product.controller;

import java.io.File;
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
import kr.co.tomato.vo.ItemViewData;

/**
 * Servlet implementation class UpdateItemServlet
 */
@WebServlet(name = "UpdateItem", urlPatterns = { "/updateItem" })
public class UpdateItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateItemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 변수에 저장
				// enctype 체크

				if (!ServletFileUpload.isMultipartContent(request)) {
					request.setAttribute("msg", "[enctype] 확인하세요");
					request.setAttribute("loc", "/");
					RequestDispatcher rd = request.getRequestDispatcher("/views/list.jsp");
					rd.forward(request, response);
					return;
				}
			
				// 파일 업로드 준비
				// 1) 파일 업로드 경로 지정
				String root = getServletContext().getRealPath("/");
				// 절대경로이기 때문에 이렇게 까지 해야, WebContent까지 접근한 것.
				String saveDirectory = root + "upload/product";
				// 2) 파일 최대 크기 지정
				// cos 라이브러리 무료 최대 사이즈는 10mb.
				int maxSize = 10 * 1024 * 1024; // 단위가 바이트.
				// 3) request -> MultipartRequest
				MultipartRequest mRequest = new MultipartRequest(request, saveDirectory, maxSize, "UTF-8", new DefaultFileRenamePolicy());
				// 업로드 된 파일명이 겹칠 시, 자동으로 숫자를 붙여서 업로드 해줌. ★실질적 파일 업로드
				
				int itemNo = Integer.parseInt(mRequest.getParameter("itemNo"));
				// 파일 이름 꺼내기
				String fileName = mRequest.getOriginalFileName("fileName");
				// 업로드 할 때 당시의 원본 파일의 이름
				String filePath = mRequest.getFilesystemName("fileName");
				// 실제 서버에 올라온 파일의 이름(넘버링(2), 넘버링(3), ...)
				String itemDealState = mRequest.getParameter("itemDealState");
				String itemName = mRequest.getParameter("itemName");
				
				// 기존 파일 삭제 여부 확인
				String status = mRequest.getParameter("status");
				String oldFileName = mRequest.getParameter("oldFileName");
				String oldFilePath = mRequest.getParameter("oldFilePath");
				
				if(fileName != null) {
					// 새 첨부파일이 있는 경우
					if(oldFileName != null) {
						// 기존 첨부파일이 있는 경우
						// 기존 첨부파일 삭제
						File delFile = new File(saveDirectory + "/" + oldFilePath);
						delFile.delete(); //결과값이 Boolean형으로 리턴됨.
					}
				} else {
					// 새 첨부파일이 없는 경우
					if(status.equals("stay")) {
						// Old 파일을 그대로 유지
						fileName = oldFileName;
						filePath = oldFilePath;
					} else if(status.equals("delete")) {
						// 기존 첨부파일 삭제
						File delFile = new File(saveDirectory + "/" + oldFilePath);
						delFile.delete(); //결과값이 Boolean형으로 리턴됨.
					}
				}
				
				ItemService service = new ItemService();
				ItemViewData ivd = service.selectOne(itemNo);
				Item i = new Item(0, itemNo, memberNo, itemName, itemMainCategory, itemSubCategory, itemPrice, itemEnrollDate, itemState, 0, itemContent, 0, 0, itemDealRegion, itemThumFilename, itemThumFilepath, itemDealState, 0);
				int result = service.itemModify(i);

				if (result > 0 && i != null) {
					request.setAttribute("msg", "공지사항 수정 성공");
				} else {
					request.setAttribute("msg", "공지사항 수정 실패");
				}

				request.setAttribute("loc", "/noticeView?noticeNo=" + i.getItemNo());
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
