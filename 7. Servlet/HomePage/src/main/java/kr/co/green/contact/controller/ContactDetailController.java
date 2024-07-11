package kr.co.green.contact.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.green.contact.model.dto.ContactDto;
import kr.co.green.contact.model.service.ContactServiceImpl;

@WebServlet("/contact/detail.do")
public class ContactDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ContactDetailController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ContactServiceImpl contactService = new ContactServiceImpl();
		
		// 쿼리스트링의 contactNo 가져오기
		int contactNo = Integer.parseInt(request.getParameter("contactNo"));
		
		// contactNo가지고 게시글 정보 가져오기
		ContactDto result = contactService.getDetail(contactNo);
		
		// view에 데이터 넘겨주고 페이지 이동
		request.setAttribute("result", result);
		RequestDispatcher view = request.getRequestDispatcher("/views/contact/contactDetail.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
