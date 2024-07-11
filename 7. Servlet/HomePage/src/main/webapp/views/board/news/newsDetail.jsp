<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">

<%@ include file="/views/common/head.jsp"%>
</head>
<body>
	<%@ include file="/views/common/header.jsp"%>
	<%@ include file="/views/common/nav.jsp"%>
  <section class="container mt-4" style="height: 70vh">
    <div class="card text-center" style="height: 100%">
        <div class="card-header">
            <h2 id="fb-title">제목</h2>
        </div>
        <div class="card-body">
            <div class="d-flex justify-content-center mb-3">
                <div class="mx-3">작성자: <span id="fb-writer">작성자</span></div>						
                <div class="mx-3">작성일: <span id="fb-date">2024-05-14</span></div>
                <div class="mx-3">조회수: <span id="fb-views">0</span></div>
            </div>
            <hr> 
            <div style="margin-top:20px; margin-bottom: 20px;">
                <p class="card-text">
                    내용
                </p>
            </div>
        </div>
        <div class="card-footer d-flex justify-content-center">
            <button class="btn btn-secondary mx-2" onclick="window.history.back()">뒤로가기</button>						
            <c:if test="${sessionScope.userNo == result.memberNo}">
	            <button class="btn btn-primary mx-2" onclick="location.href='#'">수정</button>
	            <button class="btn btn-danger mx-2" onclick="deletePost()">삭제</button>
            </c:if>
        </div>
    </div>
</section>

	<%@ include file="/views/common/footer.jsp"%>
</body>
</html>