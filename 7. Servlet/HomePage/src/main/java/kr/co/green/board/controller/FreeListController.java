package kr.co.green.board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.green.board.model.dto.FreeDtoImpl;
import kr.co.green.board.model.service.FreeServiceImpl;
import kr.co.green.common.PageInfo;
import kr.co.green.common.Pagination;

@WebServlet("/freeBoard/list.do")
public class FreeListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FreeListController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FreeServiceImpl freeService = new FreeServiceImpl();
		int cpage = Integer.parseInt(request.getParameter("cpage"));
		String category = request.getParameter("category");
		String searchText = request.getParameter("search-text");
		
		// 전체 게시글 수
		int listCount = freeService.getListCount(category, searchText);

		// 보여질 페이지 수
		int pageLimit = 5;
		
		// 한 페이지에 보여질 게시글 수
		int boardLimit = 5;
		
		PageInfo pi = Pagination.getPageInfo(listCount, cpage, pageLimit, boardLimit);
		
		// 게시글 목록 불러오기
		ArrayList<FreeDtoImpl> list = freeService.getList(pi, category, searchText);
		
		// 게시글 번호 구하기
		int row = listCount - (cpage-1) * boardLimit;
		
		// 게시글 목록을 jsp에게 전달해주기(데이터 바인딩)
		request.setAttribute("list", list);
		request.setAttribute("row", row);
		request.setAttribute("pi", pi);
		
		RequestDispatcher view = request.getRequestDispatcher("/views/board/free/freeList.jsp");
		view.forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
	}

}
