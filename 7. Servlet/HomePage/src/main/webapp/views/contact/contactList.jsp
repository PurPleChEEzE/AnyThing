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


	    <section style="height: 70vh">
	      <h1>연락 내역</h1>
	      <hr>
	      <div class="input-group mb-3" style="width: 100%; margin-top:40px">
	        <select class="form-select" id="inputGroupSelect02" name="category" style="width:100px; height:46px; flex: 0 0 auto;">
	          <option value="category-title" selected>제목</option>
	          <option value="category-content">내용</option>
	          <option value="category-writer">작성자</option>
	        </select>
	        <input type="text" style="width:500px; flex: 0 0 auto;" class="form-control" name="serach-text" placeholder="검색어를 입력해주세요." aria-label="Recipient's username" aria-describedby="button-addon2">
	        <button class="btn btn-outline-secondary" type="button" id="button-addon2" style="height:46px;">검색</button>
	        
	      </div>
	        <div class="table-container">
	          <table class="table table-hover" style="margin-top: 10px;">
	            <thead>
	              <tr>
	                <th scope="col">번호</th>
	                <th scope="col">이름</th>
	                <th scope="col">이메일</th>
	                <th scope="col">작성일</th>
	                <th scope="col">답변</th>
	              </tr>
	            </thead>
	            <tbody>
	            
	            
					<c:choose>
						<c:when test="${empty list}">
							<tr>
								<td colspan="5">등록된 글이 없습니다.</td>
							</tr>
						</c:when>
						<c:otherwise>
							<c:forEach var="item" items="${list}">
								<tr onclick="location.href='/contact/detail.do?contactNo=${item.no}'">				
									<td scope="row">${row}</td>
									<td>${item.name}</td>
									<td>${item.email}</td>
									<td>${item.indate}</td>
									<td>${item.answerStatus}</td>
								</tr>
								<c:set var="row" value="${row-1}" />
							</c:forEach>
						</c:otherwise>
					</c:choose>
	              
	              
	              
	            </tbody>
	          </table>
	        </div>
	
		<nav aria-label="Page navigation example"
			style="background-color: white;">

			<ul class="pagination" style="justify-content: center;">
				<!-- 왼쪽 버튼 -->
				<c:choose>
					<c:when test="${pi.cpage == 1}">
						<li class="page-item" style="margin-right: 0px"><a
							class="page-link" href="#" aria-label="Previous"> <span
								aria-hidden="true">&laquo;</span>
						</a></li>
					</c:when>

					<c:otherwise>
						<li class="page-item" style="margin-right: 0px"><a
							class="page-link" href="/contact/list.do?cpage=${pi.cpage-1}"
							aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
						</a></li>
					</c:otherwise>
				</c:choose>

				<!-- 
					페이지 버튼 
					for(int i=0; i<10; i++) {  } 
				-->
				<c:forEach var="page" begin="${pi.startPage}" end="${pi.endPage}">
					<li class="page-item" style="margin-right: 0px"><a
						class="page-link" href="/contact/list.do?cpage=${page}">${page}</a></li>
				</c:forEach>

				<!-- 오른쪽 버튼 -->
				<c:choose>
					<c:when test="${pi.cpage == pi.maxPage}">
						<li class="page-item" style="margin-right: 0px"><a
							class="page-link" href="#" aria-label="Next"> <span
								aria-hidden="true">&raquo;</span>
						</a></li>
					</c:when>

					<c:otherwise>
						<li class="page-item" style="margin-right: 0px"><a
							class="page-link" href="/contact/list.do?cpage=${pi.cpage+1}"
							aria-label="Next"> <span aria-hidden="true">&raquo;</span>
						</a></li>
					</c:otherwise>
				</c:choose>

			</ul>
		</nav>
	  </section>
	<%@ include file="/views/common/footer.jsp"%>
</body>
</html>