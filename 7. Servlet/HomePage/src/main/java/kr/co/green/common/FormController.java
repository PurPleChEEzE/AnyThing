package kr.co.green.common;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.green.board.model.dto.FreeDtoImpl;
import kr.co.green.board.model.service.FreeServiceImpl;
import kr.co.green.contact.model.dto.ContactDto;
import kr.co.green.contact.model.service.ContactServiceImpl;

@WebServlet("/form/*")
public class FormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FormController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		
		String action = request.getPathInfo();
		String nextPage = "";
		
		if(action.equals("/registerForm.do")) {
			nextPage = "/views/member/register.jsp";
		} else if(action.equals("/loginForm.do")) {
			nextPage = "/views/member/login.jsp";
		} else if(action.equals("/enrollForm.do")) {
			nextPage = "/views/board/free/freeEnroll.jsp";
		} else if(action.equals("/editForm.do")) {
			int boardNo = Integer.parseInt(request.getParameter("boardNo"));
			
			FreeServiceImpl freeService = new FreeServiceImpl();
			FreeDtoImpl result = freeService.getEditForm(boardNo);
			
			request.setAttribute("result", result);
			nextPage = "/views/board/free/freeEdit.jsp";
		} else if(action.equals("/contactEnroll.do")) {
			nextPage = "/views/contact/contact.jsp";
		} else if(action.equals("/answerForm.do")) {
//			String name = request.getParameter("name");
//			String email = request.getParameter("email");
//			String indate = request.getParameter("indate");
//			String message = request.getParameter("message");
//			int no = Integer.parseInt(request.getParameter("no"));
//			
//			ContactDto contactDto = new ContactDto();
//			contactDto.setName(name);
//			contactDto.setEmail(email);
//			contactDto.setIndate(indate);
//			contactDto.setMessage(message);
//			contactDto.setNo(no);
			
			int no = Integer.parseInt(request.getParameter("no"));
			ContactServiceImpl contactService = new ContactServiceImpl();
			ContactDto result = contactService.getDetail(no);
			request.setAttribute("result", result);
			RequestDispatcher view = request.getRequestDispatcher("/views/contact/contactAnswer.jsp");
			view.forward(request, response);
		}
 		
		if(nextPage != null && !nextPage.isEmpty()) {
			RequestDispatcher view = request.getRequestDispatcher(nextPage);
			view.forward(request, response);
		} else {
			response.sendRedirect("/views/error.jsp");
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
