package kr.co.green;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterController
 */
@WebServlet("/getSubmit.do")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("GET요청 왔음");
		String userName = request.getParameter("username");
		String userEmail = request.getParameter("email");
		String userPassword = request.getParameter("password");
		
		System.out.println("이름 : " + userName);
		System.out.println("이메일 : " + userEmail);
		System.out.println("비밀번호 : " + userPassword);
		
		String[] genders = request.getParameterValues("gender");
		for(String item : genders) {
			System.out.println(item);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("POST 요청 왔음");
		
	}

}
