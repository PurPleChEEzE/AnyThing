package kr.co.training;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RedGetController
 */
@WebServlet("/redGet.do")
public class RedGetController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RedGetController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String[] product = request.getParameterValues("product");
		String gift = request.getParameter("gift");
		String userName = request.getParameter("username");
		String userAddr = request.getParameter("useraddr");
		String userEmail = request.getParameter("useremail");
		String userPhone = request.getParameter("userphone");
		System.out.print(userName + "님이 주문하신 상품은 : ");
		String result = "";
		String choose = "";
		for(String item : product) {
			
			if(item.equals("gift_3")) {
				result += "선물용 3kg ,";
			}
			if(item.equals("gift_5")) {
				result += "선물용 5kg ,";
			}
			if(item.equals("family_3")) {
				result += "가정용 3kg ,";
			}
			if(item.equals("family_5")) {
				result += "가정용 5kg ,";
			}
//			if(!item.isEmpty()) {
//				System.out.print("");
//			}
			
		}
		if(!result.isEmpty()) {
			result = result.substring(0, result.length() - 2);
		}
		
		if (gift.equals("yes")) {
			choose = "합니다";
		} else if (gift.equals("no"))
			choose = "안합니다";
		System.out.println(result + "이며 선물 포장 선택은 " + choose);
		
		System.out.println("이름 : " + userName);
		System.out.println("주소 : " + userAddr);
		System.out.println("이메일 : " + userEmail);
		System.out.println("번호 : " + userPhone);
		
		request.setAttribute("userName", userName);
		
		RequestDispatcher view = request.getRequestDispatcher("result.jsp");
		
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
