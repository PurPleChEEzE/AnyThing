<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- 지시자 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 스크립틀릿 -->
<% 
	String userName = (String)request.getAttribute("userName");
	
int sum = 0;
for(int i=0; i<10; i++){
	sum +=i;
}
%>
<!-- 선언문 -->
<%!
	int num1 = 5;	
	int num2 = 10;
	
	public int method(int num1, int num2){
		return num1 + num2;
	}
	int result = num1+num2;
	
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p><%= result %></p>
<!-- 표현식 -->
<p><%= sum %></p>
<p> 주문자 이름 : <%=userName%></p>

<!-- num1 = 1 -->
<c:set var="num1" value="1" />

<c:if test="${num1 ==1}">
	<p> num1은 1입니다 </p>
</c:if>


</body>
</html>