package kr.co.green.contact.controller;

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

public class ContactEnrollControllerTest {
	@InjectMocks
	private ContactEnrollController cec;
	
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
	}
	
	@ParameterizedTest
	@CsvSource({
				"name2, email2, messag3, 42, /",
				"'', email3, message3, 42, /error.jsp",
				"name4, email4, '', 42, /error.jsp"
			   })
	public void testDoPost(String username, String userEmail, String message, 
						   int userNo, String resultPath) throws ServletException, IOException {
		when(request.getParameter("name")).thenReturn(username);
		when(request.getParameter("email")).thenReturn(userEmail);
		when(request.getParameter("message")).thenReturn(message);
		when(session.getAttribute("userNo")).thenReturn(userNo);
		
		cec.doPost(request, response);
		verify(response).sendRedirect(resultPath);
	}
}



