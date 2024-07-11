<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/views/common/head.jsp"%>

<script type="text/javascript" src="/resources/smarteditor2/js/HuskyEZCreator.js" charset="utf-8"></script>
<script type="text/javascript" src="/resources/js/common/smarteditor.js" charset="utf-8"></script>

</head>
<body>
	<%@ include file="/views/common/header.jsp"%>
	<%@ include file="/views/common/nav.jsp"%>
	
  <section id="post-form">
    <h2>새 글 작성</h2>
	    <form action="/freeBoard/enroll.do" method="POST" enctype="multipart/form-data">
	    	<%-- <input type="hidden" name="memberNo" value="${sessionScope.userNo}"> --%>
	    
	        <label for="title">제목:</label>
	        <input type="text" id="title" name="title" required>
	        
	        <label for="author">글쓴이:</label>
	        <input type="text" id="author" value="${sessionScope.userName}" disabled>
	        
	        <label for="content">내용:</label>
	        
	        <div id="smarteditor">
	        	<textarea id="editorTxt" name="content" rows="4" required></textarea>
	        </div>
	        
	        <!-- <input type="file" name="file"> -->
	        
	        <button type="submit" onclick="save()">작성</button>
	    </form>
	</section>

	<%@ include file="/views/common/footer.jsp"%>
</body>
</html>