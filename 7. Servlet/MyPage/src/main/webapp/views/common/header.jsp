<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div>
	<ul>
		<c:choose>
			<c:when test="${sessionScope.userName != null }">
			<li class = "table"><p>${sessionScope.userName}님 </li>
			<li class="table"><a href="/member/logout.do" class="headerA">로그아웃</a></li>
			</c:when>
			<c:otherwise>
			<li class="table"><a href="/form/loginForm.do" class="headerA">로그인</a></li>
			<li class="table"><a href="/form/registerForm.do" class="headerA">회원가입</a></li>
			</c:otherwise>
		</c:choose>
<!-- 		<li class="table"><a href="/views/member/login.jsp" class="headerA">로그인</a></li>
		<li class="table"><a href="/views/member/register.jsp" class="headerA">회원가입</a></li> -->
	</ul>
</div>
<div style="float: left;">
	<h1>
		<a href="/index.jsp" style="color: slategray;">Wave</a>
	</h1>
	<!-- 이미지 따로 생성 후 클릭시 홈페이지로 가는 a 태그 생성 -->

	<nav class="nav">
		<ul>
			<li><a href="/index.jsp" class="headerA">홈</a></li>

			<div class="dropdown">
				<a href="/views/category/categories.jsp" class="dropbtn"
					style="font-size: 16px; color: #d2d2d2; margin-left: 15px;">카테고리</a>
				<div class="dropdown-content">
					<a href="#" class="headerA fontSmallSize">- 드라마</a> <a href="#"
						class="headerA fontSmallSize">- 영화</a> <a href="#"
						class="headerA fontSmallSize">- 예능</a> <a href="#"
						class="headerA fontSmallSize">- 교양</a> <a href="#"
						class="headerA fontSmallSize">- 애니메이션</a>
				</div>
			</div>
			<li><a href="/views/announcement/announce_main.jsp" class="headerA">공지사항</a></li>

		</ul>

	</nav>
</div>
<div class="search-form">

	<!-- <img src="X.png" alt="ssd" class="close"> -->
	<img
		src="https://s3.ap-northeast-2.amazonaws.com/cdn.wecode.co.kr/icon/search.png"
		alt="ddd" class="lens"> <input id="s" type="text"
		placeholder="검색어를 입력해주세요." /> <span class="sclose"><i
		class="fa fa-times"></i></span>

</div>