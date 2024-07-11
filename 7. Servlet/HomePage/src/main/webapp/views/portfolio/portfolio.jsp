<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <%@ include file="/views/common/head.jsp" %>
</head>
<body>
	<%@ include file="/views/common/header.jsp" %>
	<%@ include file="/views/common/nav.jsp" %>

	  <section>
	    <h2>포트폴리오</h2>
	
	    <div class="project">
	      <div class="input-area" id="input-area">
	        <input type="text" id="project-title" placeholder="프로젝트 제목 입력">
	        <textarea id="project-description" placeholder="프로젝트 설명 입력"></textarea>
	        <button id="add-project-button">새로운 프로젝트 추가하기</button>
	        <!-- 제목 : h3 -->
	        <!-- 내용 : p -->
	      </div>
	    </div>
	  </section>

	<%@ include file="/views/common/footer.jsp" %>
</body>
</html>