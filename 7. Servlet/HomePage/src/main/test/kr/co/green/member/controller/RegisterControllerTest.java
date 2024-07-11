package kr.co.green.member.controller;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import kr.co.green.member.controller.RegisterController;

public class RegisterControllerTest {																							
	@InjectMocks
	private RegisterController rc;
	
	@Mock
	private HttpServletRequest request;
	
	@Mock
	private HttpServletResponse response;
	
	@Mock
	private HttpSession session;
	
	@Mock
	private RequestDispatcher dispatcher;
	
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
		
		when(request.getSession()).thenReturn(session);
		when(request.getRequestDispatcher("/views/member/login.jsp")).thenReturn(dispatcher);
	}
	
	@ParameterizedTest
	@CsvSource({"한글입니다, id43, Password123!, Password123!, /views/member/login.jsp"})
	public void testDoPost(String username, String userid, String password, 
						   String confirmPassword, String resultPath) throws ServletException, IOException {
		when(request.getParameter("new-username")).thenReturn(username);
		when(request.getParameter("new-userid")).thenReturn(userid);
		when(request.getParameter("new-password")).thenReturn(password);
		when(request.getParameter("confirm-password")).thenReturn(confirmPassword);
		when(request.getParameter("duplicateCheck")).thenReturn("available");
		
		rc.doPost(request, response);
		verify(request).getRequestDispatcher(resultPath);
		verify(dispatcher).forward(request, response);
	}
	
}






























