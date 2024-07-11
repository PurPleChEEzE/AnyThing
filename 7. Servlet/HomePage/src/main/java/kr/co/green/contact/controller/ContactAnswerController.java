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

@WebServlet("/contact/answer.do")
public class ContactAnswerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ContactAnswerController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int no = Integer.parseInt(request.getParameter("no"));  // c_no
		String message = request.getParameter("message"); // ca_message
		
		// m_no
		HttpSession session = request.getSession();
		int memberNo = (int)session.getAttribute("userNo");
		
		ContactDto contactDto = new ContactDto();
		contactDto.setNo(no);
		contactDto.setAnswerContent(message);
		contactDto.setMemberNo(memberNo);
		
		ContactServiceImpl contactService = new ContactServiceImpl();
		int result = contactService.setAnswer(contactDto);
		
		if(result == 1) {
//			list로 이동(controller 들려야 함)
			response.sendRedirect("/contact/list.do?cpage=1");
		}
	
	}

}








