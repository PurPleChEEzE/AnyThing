<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <%@ include file="/views/common/head.jsp" %>
    <style>
    main{
    padding-top : 50px;
    }
    </style>
</head>
<body>
    <header class="header">
        <%@ include file="/views/common/header.jsp" %>
    </header>

    <main class="main">
        <div class="login-page">
            <h2>wave 로그인</h2>
            <form action="/member/login.do" method="POST">
                <label for="userid"></label>
                <input class="input-box" type="text" id="userid" name = "userid" placeholder="아이디" title="아이디" required>
                <br>
                <label for="password"></label>
                <input class="input-box" type="password" id="password" name = "password" placeholder="비밀번호" title="비밀번호" required>
                <br>
                <label for="remember-check">
                    <input type="checkbox" class="remember-check">아이디 저장하기
                </label>
                <label for="remember-check">
                        <input type="checkbox" class="remember-check">자동로그인
                </label>
                <br>
                <button class="button-box" type="submit">wave 로그인</button>
<!--                 <button class="button-box" type="submit" onclick="loginAction()">wave 로그인</button> -->
            </form>

            <!-- <script>
                const id = "user";
                const pwd = "qwer1234";

                function loginAction(){
                    const inputId = document.getElementById("id").value;
                    const inputPass = document.getElementById("password").value;
                    if(inputId =="" || inputPass == ""){
                        alert("아이디 또는 비밀번호를 입력해주세요");
                    }else if(inputId != id || inputPass != pwd){
                        alert("아이디 또는 비밀번호가 틀렸습니다.");
                    }else if(inputId ==id && inputPass == pwd){
                        alert("로그인되었습니다.");
                    }
                }

            </script> -->
        </div>

    </main>

    <footer class="footer">
        <%@ include file="/views/common/footer.jsp" %>

    </footer>
</body>
</html>