<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html>
<head>
	<%@ include file="../../common/head.jsp" %>
</head>
<body>
<%@ include file="../../common/header.jsp" %>
<%@ include file="../../common/nav.jsp" %>

   <section class="container mt-4" style="height: 70vh">
      <div class="card text-center" style="height: 100%">
         <form>
            <div class="card-header">
               <input type="text" name="title" value="제목" />
            </div>
            <div class="card-body">
               <div class="d-flex justify-content-center mb-3">
                  <div class="mx-3">
                     작성자: <span id="fb-writer">0</span>
                  </div>
                  <div class="mx-3">
                     작성일: <span id="fb-date">0</span>
                  </div>
                  <div class="mx-3">
                     조회수: <span id="fb-views">0</span>
                  </div>
               </div>
               <hr>
               <textarea name="content" style="height: 300px">내용</textarea>                     

            </div>
            <div class="card-footer d-flex justify-content-center">
               <button class="btn btn-secondary mx-2"
                  onclick="window.history.back()">뒤로가기</button>
                  <button type="submit" class="btn btn-primary mx-2">수정</button>
            </div>
         </form>
      </div>
   </section>
  
  
  <%@ include file="../../common/footer.jsp" %>
</body>
</html>
