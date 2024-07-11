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

	<section style="height: 70vh">
		<h1>자유 게시판</h1>
		<hr>
		<div class="input-group mb-3" style="width: 100%; margin-top: 40px">
			<select class="form-select" id="inputGroupSelect02" name="category"
				style="width: 100px; height: 46px; flex: 0 0 auto;">
				<option value="category-title" selected>제목</option>
				<option value="category-content">내용</option>
				<option value="category-writer">작성자</option>
			</select> <input type="text" style="width: 500px; flex: 0 0 auto;"
				class="form-control" name="serach-text" placeholder="검색어를 입력해주세요."
				aria-label="Recipient's username" aria-describedby="button-addon2">
			<button class="btn btn-outline-secondary" type="button"
				id="button-addon2" style="height: 46px;">검색</button>

					<button onclick="window.location.href = '/form/enrollForm.do'"
						style="position: absolute; right: 4%;">등록</button>

		</div>
		<div class="table-container">
			<table class="table table-hover" style="margin-top: 10px;">
				<thead>
					<tr>
						<th scope="col">번호</th>
						<th scope="col">제목</th>
						<th scope="col">작성자</th>
						<th scope="col">작성일</th>
						<th scope="col">조회수</th>
					</tr>
				</thead>
            <tbody>
              <tr>
                <th scope="row">2</th>
                <td>제목1</td>
                <td>홍길동</td>
                <td>2024-05-10</td>
                <td>10</td>
              </tr>
              <tr>
                <th scope="row">1</th>
                <td>제목2</td>
                <td>이순신</td>
                <td>2024-05-10</td>
                <td>15</td>
              </tr>
            </tbody>
			</table>
		</div>

        <nav aria-label="Page navigation example" style="background-color: white; ">
          <ul class="pagination" style="justify-content: center;">
            <li class="page-item" style="margin-right: 0px">
              <a class="page-link" href="#" aria-label="Previous">
                <span aria-hidden="true">&laquo;</span>
              </a>
            </li>
            <li class="page-item" style="margin-right: 0px"><a class="page-link" href="#">1</a></li>
            <li class="page-item" style="margin-right: 0px"><a class="page-link" href="#">2</a></li>
            <li class="page-item" style="margin-right: 0px"><a class="page-link" href="#">3</a></li>
            <li class="page-item" style="margin-right: 0px">
              <a class="page-link" href="#" aria-label="Next">
                <span aria-hidden="true">&raquo;</span>
              </a>
            </li>
          </ul>
        </nav>
	</section>


	<%@ include file="/views/common/footer.jsp"%>
</body>
</html>