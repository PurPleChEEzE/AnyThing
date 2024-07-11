<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <%@ include file="views/common/head.jsp" %>
</head>
<body>
    <header class="header">
        <%@ include file="views/common/header.jsp" %>
    </header>

    <main class="main">
        <div class="slider">
            <input type="radio" name="slide" id="slide1" checked>
            <input type="radio" name="slide" id="slide2">
            <input type="radio" name="slide" id="slide3">
            <input type="radio" name="slide" id="slide4">
            <ul id="imgholder" class="imgs">
                <li><a href="/views/content/content8.html"><img src="/resources/photos/텐키노.png" style="width: 850px; height: 480px; border-radius: 20px;"></a></li>
                <li><a href="/views/content/content6.html"><img src="/resources/photos/susuju.png" style="width: 850px; height: 480px; border-radius: 20px;"></a></li>
                <li><a href="/views/content/content7.html"><img src="/resources/photos/키미노나와.png" style="width: 850px; height: 480px; border-radius: 20px;"></a></li>
            </ul>
            <div class="bullets">
                <label for="slide1">&nbsp;</label>
                <label for="slide2">&nbsp;</label>
                <label for="slide3">&nbsp;</label>
            </div>
        </div>



        <br><br>
        <h2 class="white" style="color: rgb(243, 243, 243);">- 인기 장르 -</h2>
    
        <ul class="mainul">
            <li style="float: left;" class="mainli">
                <div class="contents">
                    <a href="/views/content/content3.html"><img src="/resources/photos/유희왕.png" alt="dd" class="img"></a>
                </div>
            </li>
            <li style="float: left;" class="mainli">
                <div class="contents">
                    <a href="/views/content/content2.html"><img src="/resources/photos/1.png" alt="dd" class="img"></a>
                </div>
            </li >
            <li style="float: left;" class="mainli">
                <div class="contents">
                    <a href="/views/content/content1.html"><img src="/resources/photos/2.png" alt="dd" class="img"></a>
                </div>
            </li>
            <li style="float: left;" class="mainli">
                <div class="contents">
                    <a href="/views/content/content5.html"><img src="/resources/photos/3.png" alt="dd" class="img"></a>
                </div>
            </li>
            <li style="float: left;" class="mainli">
                <div class="contents">
                    <a href="/views/content/content4.html"><img src="/resources/photos/4.png" alt="dd" class="img"></a>
                </div>
            </li>
        </ul>
    </main>

    <footer class="footer">
        <%@ include file="views/common/footer.jsp" %>

    </footer>
</body>
</html>