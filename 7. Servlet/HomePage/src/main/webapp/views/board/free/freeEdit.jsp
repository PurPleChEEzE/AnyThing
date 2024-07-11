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
			<form action="/freeBoard/edit.do" method="post">
			
				<input type="hidden" name="boardNo" value="${result.boardNo }" />
				
				<div class="card-header">
					<input type="text" name="title" value="${result.boardTitle }" />
				</div>
				<div class="card-body">
					<div class="d-flex justify-content-center mb-3">
						<div class="mx-3">
							작성자: <span id="fb-writer">${result.memberName}</span>
						</div>
						<div class="mx-3">
							작성일: <span id="fb-date">${result.boardIndate}</span>
						</div>
						<div class="mx-3">
							조회수: <span id="fb-views">${result.boardViews}</span>
						</div>
					</div>
					<hr>
					<textarea name="content" style="height: 300px">${result.boardContent }</textarea>							

				</div>
				<div class="card-footer d-flex justify-content-center">
					<button class="btn btn-secondary mx-2"
						onclick="window.history.back()">뒤로가기</button>
					<c:if test="${sessionScope.userNo == result.memberNo}">
						<button type="submit" class="btn btn-primary mx-2">수정</button>
					</c:if>
				</div>
			</form>
		</div>
	</section>

	<%@ include file="/views/common/footer.jsp"%>
</body>
</html>