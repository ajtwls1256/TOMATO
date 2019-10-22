package kr.co.tomato.noitceMTM.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kr.co.tomato.noitceMTM.model.service.NoticeMTMService;
import kr.co.tomato.noitceMTM.model.vo.NoticeMTM;

/**
 * Servlet implementation class NoticeMTMInsertServlet
 */
@WebServlet(name = "NoticeMTMInsert", urlPatterns = { "/noticeMTMInsert" })
public class NoticeMTMInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NoticeMTMInsertServlet() {
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

		// 1. 파일 업로드 지정
		String root = getServletContext().getRealPath("/");
		String saveDirectory = root + "upload/noticeMTM";

		// 2. 파일 최대크기 지정
		// cos라이브러리 무료 최대 사이지는 10MB
		int maxSize = 10 * 1024 * 1024;

		// 3.request -> MultipartRequest 변환작업
		MultipartRequest mRequest = new MultipartRequest(request, saveDirectory, maxSize, "utf-8");
		new DefaultFileRenamePolicy();

		String main = mRequest.getParameter("main");
		String sub = mRequest.getParameter("sub");
		String content = mRequest.getParameter("content");
		String filename = mRequest.getOriginalFileName("filename");
		String filepath = mRequest.getFilesystemName("filename");

		NoticeMTM mtm = new NoticeMTM(0, 0, null, content, null, filename, filepath, main, sub, null, null, null);

		NoticeMTMService service = new NoticeMTMService();
		int result = service.insertNoticeMTM(mtm);

		if (result > 0) {
			request.setAttribute("msg", "등록성공");
		} else {
			request.setAttribute("msg", "등록실패");
		}
		request.setAttribute("loc", "/noticeMTM");
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		rd.forward(request, response);

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
