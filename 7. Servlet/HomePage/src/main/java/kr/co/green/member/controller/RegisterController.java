package kr.co.green.member.controller;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mindrot.jbcrypt.BCrypt;

import kr.co.green.member.model.dto.Member;
import kr.co.green.member.model.service.MemberServiceImpl;

@WebServlet("/member/register.do")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RegisterController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// request : 사용자가 요청(request)한 데이터
		// 사용자가 보낸 데이터를 UTF-8로 인코딩 하겠다.
//		request.setCharacterEncoding("UTF-8"); 
		
		// response : 사용자에게 응답(response)할 데이터
		// 사용자에게 응답할 데이터를 UTF-8로 인코딩 하겠다.
//		response.setContentType("text/html; charset=UTF-8");
		
		// 사용자가 요청한 데이터.파라메터가져오겠다("new-username인 값");
		String userName = request.getParameter("new-username"); // 홍길동
		String userId = request.getParameter("new-userid"); // id
		String userPwd = request.getParameter("new-password"); // qwer1234
		String confirmPwd = request.getParameter("confirm-password"); // qwer1234
		String duplicateCheck = request.getParameter("duplicateCheck");
		
		if(duplicateCheck.equals("unavailable")) { // 중복되는 아이디가 있을 때
			response.sendRedirect("/form/registerForm.do");
			return;
		}
		
		// 유효성 검사
		// 이름 : 한글만 가능
		// 패스워드 : 영어 대문자 최소 1개, 특수문자 최소 1개, 6자리 이상 20자리 이하
		
		// 이름 유효성 검사
		String namePattern = "^[가-힣]+$"; // 정규표현식 패턴 정의
		Pattern pattern = Pattern.compile(namePattern); // 패턴 객체 생성

		// 매처 객체 생성
		// 주어진 문자열(userName)이랑 정규표현식의 패턴이랑 일치하는지 비교하기위해 필요한 객체
		Matcher nameMatcher = pattern.matcher(userName); 
		
		// 패스워드 유효성 검사
		String passwordPattern = "^(?=.*[A-Z])(?=.*[!@])[a-zA-Z0-9!@]{6,20}$";
		Pattern pwdPattern = Pattern.compile(passwordPattern);
		Matcher pwdMatcher = pwdPattern.matcher(userPwd);
		
		// 패스워드 암호화
		// qwer1234!  =  r9h9321hr9#*(@#4
		String salt = BCrypt.gensalt(12);
		String hashPassword = BCrypt.hashpw(userPwd, salt);
		
		if(nameMatcher.matches() && pwdMatcher.matches()) { // 정규표현식에 맞다면 true, 맞지않으면 false
			Member member = new Member();
			member.setUserName(userName);
			member.setUserId(userId);
			member.setUserPwd(hashPassword);
			member.setConfirmPwd(confirmPwd);
			
			MemberServiceImpl memberService = new MemberServiceImpl();
			int result = memberService.register(member);
			
			if(result == 1) { // 성공
				RequestDispatcher view = request.getRequestDispatcher("/views/member/login.jsp");
				view.forward(request, response);
			} else { // 실패
				RequestDispatcher view = request.getRequestDispatcher("/views/member/register.jsp");
				view.forward(request, response);
			}
		} else if(!nameMatcher.matches()) { // 이름이 한글이 아닐 때
			returnAlert(response, "이름은 한글만 가능합니다.");
		} else if(!pwdMatcher.matches()) { // 패스워드 조건에 맞지 않을 때
			returnAlert(response, "패스워드 정책에 맞지 않습니다.");
		}
	}
	
	private void returnAlert(HttpServletResponse response, String msg) throws IOException {
		response.getWriter().write("<script>"
				+ "						alert('" + msg + "');"
				+ "					</script>");
	}

}






