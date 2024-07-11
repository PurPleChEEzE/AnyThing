package kr.co.green.member.model.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.green.member.model.dto.Member;
import kr.co.green.member.model.service.MemberServiceImpl;

@WebServlet("/member/register.do")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegisterController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		String userName = request.getParameter("new-username");
		String userId = request.getParameter("new-userid");
		String userPwd = request.getParameter("new-password");
		String confirmPwd = request.getParameter("confirm-password");
		String idNum = request.getParameter("idnum");
		String phoneNum = request.getParameter("phonenum");
		String userEmail = request.getParameter("email");

		Member member = new Member();
		member.setUserName(userName);
		member.setUserId(userId);
		member.setUserPwd(userPwd);
		member.setConfirmPwd(confirmPwd);
		member.setIdNum(idNum);
		member.setPhoneNum(phoneNum);
		member.setUserEmail(userEmail);

		MemberServiceImpl memberService = new MemberServiceImpl();
		int result = memberService.register(member);

		if (result == 1) {
			RequestDispatcher view = request.getRequestDispatcher("/form/loginForm.do");
			view.forward(request, response);
		} else {
			RequestDispatcher view = request.getRequestDispatcher("/form/registerForm.do");
			view.forward(request, response);
		}
	}

}
