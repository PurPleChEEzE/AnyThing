package kr.co.test.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.test.member.model.dto.MemberDTO;
import kr.co.test.member.model.service.MemberServiceImpl;

@WebServlet("/member/signup.do")
public class SignUpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SignUpController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String userName = request.getParameter("new-username");
		String userId = request.getParameter("new-userid");
		String userPwd = request.getParameter("new-password");
		String confirmPwd = request.getParameter("confirm-password");
		String userBirthDate = request.getParameter("birthdate");
		String userAddress = request.getParameter("address");
		
		MemberDTO mdto = new MemberDTO();
		mdto.setName(userName);
		mdto.setPassword(userPwd);
		mdto.setConfirmPassword(confirmPwd);
		mdto.setBirthdate(userBirthDate);
		mdto.setAddress(userAddress);
		mdto.setId(userId);
		
		MemberServiceImpl memberService = new MemberServiceImpl();
		int result = memberService.register(mdto);
		
		if (result == 1) {
			RequestDispatcher view = request.getRequestDispatcher("/views/common/login.jsp");
			view.forward(request, response);
		} else {
			RequestDispatcher view = request.getRequestDispatcher("/views/member/error.jsp");
			view.forward(request, response);
		}
		
	}
	
//	birthdate address

}
;