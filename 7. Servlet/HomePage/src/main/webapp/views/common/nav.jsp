<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <nav>
    <ul>
      <li><a href="/">홈</a></li>
      <li><a href="introduce.html">소개</a></li>
      <li><a href="portfolio.html">포트폴리오</a></li>
      <li class="menu-item">
        <a href="#">게시판</a>
        <div class="submenu">
          <a href="news.html">뉴스 게시판</a>
          <a href="/freeBoard/list.do?cpage=1&category=fb_title&search-text=">자유 게시판</a>											
        </div>
      </li>
      <li><a href="/form/contactEnroll.do">연락하기</a></li>
      
      <c:if test="${sessionScope.userType == 'admin'}">
	      <li class="menu-item">
	        <a href="#">관리자 메뉴</a>
	        <div class="submenu">
	          <a href="/contact/list.do?cpage=1">연락 내역</a>
	        </div>
	      </li>
      </c:if>
      
    </ul>
  </nav>