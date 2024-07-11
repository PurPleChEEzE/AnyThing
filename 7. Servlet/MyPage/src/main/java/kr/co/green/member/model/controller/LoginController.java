package kr.co.green.member.model.controller;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.green.member.model.dto.Member;
import kr.co.green.member.model.service.MemberServiceImpl;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/member/login.do")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");	
		
		
		String userId = request.getParameter("userid");
		String userPwd = request.getParameter("password");
		
		Member member = new Member();
		
		member.setUserId(userId); 
		member.setUserPwd(userPwd);
		
		
		
		MemberServiceImpl memberService = new MemberServiceImpl();
		Member result = memberService.login(member);
		
		if(Objects.isNull(result.getUserName())) {
			response.sendRedirect("/views/common/error.jsp");
		}else {
			HttpSession session = request.getSession();
			session.setAttribute("userNo", result.getUserNo());
			session.setAttribute("userName", result.getUserName());
			
			RequestDispatcher view = request.getRequestDispatcher("/");
			view.forward(request, response);
		}
	}
		
		
		
		

}
