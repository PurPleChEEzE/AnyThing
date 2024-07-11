package kr.co.green.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.green.board.model.dto.FreeDtoImpl;
import kr.co.green.board.model.service.FreeServiceImpl;

@WebServlet("/freeBoard/edit.do")
public class FreeEditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FreeEditController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		String boardTitle = request.getParameter("title");
		String boardContent = request.getParameter("content");
		
		FreeDtoImpl freeDto = new FreeDtoImpl();
		freeDto.setBoardNo(boardNo);
		freeDto.setBoardTitle(boardTitle);
		freeDto.setBoardContent(boardContent);
		
		FreeServiceImpl freeService = new FreeServiceImpl();
		int result = freeService.setEdit(freeDto);
		
//		Controller -> jsp   (RequestDispatcher)
//		Controller -> Controller (response.sendRedirect)
		if(result == 1) {
			response.sendRedirect("/freeBoard/detail.do?boardNo="+boardNo);
		}
	}
}











