package kr.co.green.contact.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.green.contact.model.dto.ContactDto;
import kr.co.green.contact.model.service.ContactServiceImpl;

@WebServlet("/contact/enroll.do")
public class ContactEnrollController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ContactEnrollController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		// 이름, 이메일, 메시지
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String message = request.getParameter("message");
		
		HttpSession session = request.getSession();
		int memberNo = (int)session.getAttribute("userNo");
		
		ContactDto contactDto = new ContactDto(name, email, message, memberNo);
		
		ContactServiceImpl contactService = new ContactServiceImpl();
		int result = contactService.enroll(contactDto);
		
		if(result == 1) {
			response.sendRedirect("/");
		} else {
			response.sendRedirect("/error.jsp");
		}
		
	
	}

}





