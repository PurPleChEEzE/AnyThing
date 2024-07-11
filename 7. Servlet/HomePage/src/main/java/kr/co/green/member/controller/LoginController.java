package kr.co.green.member.controller;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;

import kr.co.green.member.model.dto.Member;
import kr.co.green.member.model.service.MemberServiceImpl;

@WebServlet("/member/login.do")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberServiceImpl memberService = new MemberServiceImpl();
		String userId = request.getParameter("userid");
		String userPwd = request.getParameter("password");
		
		Member member = new Member();
		member.setUserId(userId);
		member.setUserPwd(userPwd);
		
		// 암호화된 패스워드 조회
		Member hashPassword = memberService.getHashPassword(userId);
		
		// BCrypt.checkpw("사용자가 입력한 패스워드", "암호화된 패스워드")
		if(BCrypt.checkpw(userPwd, hashPassword.getUserPwd())) {
			HttpSession session = request.getSession();
			session.setAttribute("userNo", hashPassword.getUserNo());
			session.setAttribute("userName", hashPassword.getUserName());
			session.setAttribute("userType", hashPassword.getUserType());
			
			RequestDispatcher view = request.getRequestDispatcher("/");
			view.forward(request, response);
		} else {
			
		}
		
//		Member result = memberService.login(member);
		
//		if(Objects.isNull(result.getUserName())) { // 로그인 실패
//			response.sendRedirect("/views/common/error.jsp");
//		} else { // 로그인 성공
//			HttpSession session = request.getSession();
//			session.setAttribute("userNo", result.getUserNo());
//			session.setAttribute("userName", result.getUserName());
//			session.setAttribute("userType", result.getUserType());
//			
//			RequestDispatcher view = request.getRequestDispatcher("/");
//			view.forward(request, response);
//		}
	}
}















