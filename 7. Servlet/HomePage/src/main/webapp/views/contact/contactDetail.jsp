<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

<%@ include file="/views/common/head.jsp"%>
</head>
<body>
	<%@ include file="/views/common/header.jsp"%>
	<%@ include file="/views/common/nav.jsp"%>
	
	  <section class="container mt-4" style="height: 70vh">
	    <div class="card text-center" style="height: 100%">
	    
	    	<form action="/form/answerForm.do" method="POST">
	    		<%-- <input type="hidden" name="name" value="${result.name }">
	    		<input type="hidden" name="email" value="${result.email }">
	    		<input type="hidden" name="indate" value="${result.indate }">
	    		<input type="hidden" name="message" value="${result.message }"> --%>
	    		<input type="hidden" name="no" value="${result.no }">
		        <div class="card-header">
		            <h2 id="fb-title">연락 답변하기</h2>
		        </div>
		        <div class="card-body">
		            <div class="d-flex justify-content-center mb-3">
		                <div class="mx-3">작성자: <span id="fb-writer">${result.name }</span></div>
		                <div class="mx-3">이메일: <span id="fb-views">${result.email }</span></div>
		                <div class="mx-3">작성일: <span id="fb-date">${result.indate }</span></div>
		            </div>
		            <hr> 
		            <div style="margin-top:20px; margin-bottom: 20px;">
		                <p class="card-text">
		                    ${result.message }
		                </p>
		            </div>
		        </div>
		        <div class="card-footer d-flex justify-content-center">
		            <button type="button" class="btn btn-secondary mx-2" onclick="window.history.back()">뒤로가기</button>
		            <button type="submit" class="btn btn-primary mx-2">답변</button>
		            <button type="button" class="btn btn-danger mx-2" onclick="location.href='/contact/delete.do?no=${result.no}&answerStatus=${result.answerStatus }'">삭제</button>
		        </div>
	        </form>
	    </div>
	</section>

	<%@ include file="/views/common/footer.jsp"%>
</body>
</html>