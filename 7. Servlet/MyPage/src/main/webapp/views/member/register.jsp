<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%@ include file="/views/common/head.jsp"%>
<style>
main {
	padding-top: 50px;
}
</style>
</head>
<body>
	<header class="header">
		<%@ include file="/views/common/header.jsp"%>
	</header>

	<main class="main">
		<div class="container">
			<h2>wave 회원가입</h2>

			<form action="/member/register.do" method="POST">

				<label for="id"></label> <br> <input class="input-box"
					type="text" id="id" placeholder="아이디" name="new-userid"
					onkeyup="isValidId()" required>
				<div id="id-msg"></div>
				<label for="password"></label> <br> <input class="input-box"
					type="password" id="password"
					placeholder="비밀번호(특수문자 !@#$%^*_+- 사용가능)" name="new-password"
					onkeyup="isValidPassword()" required>
				<div id="password-msg"></div>
				<label for="confirm_password"></label> <br> <input
					class="input-box" type="password" id="password-check"
					placeholder="비밀번호 확인" name="confirm_password"
					onkeyup="samePassword()" required>
				<div id="pscheck-msg"></div>
				<label for="email"></label> <br> <input class="input-box"
					type="email" id="email" placeholder="이메일" name="email"
					onkeyup="isValidEmail()" required>
				<div id="email-msg"></div>
				<label for="username"></label> <br> <input class="input-box"
					type="text" id="name" placeholder="이름" name="new-username"
					onkeyup="isValidName()" required>
				<div id="name-msg"></div>
				<label for="id_number"></label> <br> <input class="input-box"
					type="text" id="id-number" placeholder="주민번호(- 입력)"
					name="idnum" onkeyup="isValidIdNum()" required>
				<div id="idnum-msg"></div>
				<label for="phone_number"></label> <br> <input
					class="input-box" type="number" id="phone-number"
					placeholder="전화번호(-없이 입력)" name="phonenum"
					onkeyup="isValidPhone()" required>
				<div id="phone-msg"></div>
				<button type="submit" class="button-box">wave 회원가입</button>
				<br>
			</form>

			<script>
                function isValidId() {
                    const inputId = document.getElementById("id").value;
                    const msg = document.getElementById("id-msg");
                    const idPattern = /^[a-z0-9_-]{5,20}$/;
                    if (idPattern.test(inputId)) {
                        msg.innerHTML = "사용가능한 아이디입니다";
                        msg.style.color = "green";
                    } else if (inputId == "") {
                        msg.innerHTML = "";
                    } else {
                        msg.innerHTML = "사용 불가능한 아이디입니다."
                        msg.style.color = "red";
                    }
                }

                function isValidPassword() {
                    const inputPass = document.getElementById("password").value;
                    const msg = document.getElementById("password-msg");
                    // [a-zA-Z~!@#$%^&*-_=+]   
                    //?= : 전방탐색 
                    //.* : 아무문자가 1개가 있거나 없음
                    const passPattern = /^[a-zA-Z\d!@#$%^*_+-]{8,16}$/;
                    if (passPattern.test(inputPass)) {
                        msg.innerHTML = "사용가능한 비밀번호입니다";
                        msg.style.color = "green";
                    } else if (inputPass == "") {
                        msg.innerHTML = "";
                    } else {
                        msg.innerHTML = "사용 불가능한 비밀번호입니다."
                        msg.style.color = "red";
                    }
                    return new Promise(function (resolve, reject) {
                        resolve(inputPass);
                    })
                }

                async function samePassword(){
                    const inputPass = document.getElementById("password-check").value;
                    const msg = document.getElementById("pscheck-msg");
                    const passCheckPattern = /^[a-zA-Z\d!@#$%^*_+-]{8,16}$/;
                    if(passCheckPattern.test(inputPass)){
                
                        const result = await isValidPassword();
                        if(result == inputPass){
                            msg.innerHTML = "비밀번호가 일치합니다.";
                            msg.style.color = "green";
                        }else{
                            msg.innerHTML = "비밀번호가 일치하지 않습니다."
                            msg.style.color = "red";
                        }
                    }else if (inputPass == "") {
                            msg.innerHTML = "";
                    }else{
                        msg.innerHTML = "비밀번호가 일치하지 않습니다."
                        msg.style.color = "red";
                    }
                }       

                function isValidEmail(){
                    const inputEmail = document.getElementById("email").value;
                    const msg = document.getElementById("email-msg");
                    const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

                    if(emailPattern.test(inputEmail)){
                        msg.innerHTML = "사용가능한 이메일입니다";
                        msg.style.color = "green";
                    }else if (inputEmail == "") {
                        msg.innerHTML = "";
                    }else{
                        msg.innerHTML = "사용 불가능한 이메일입니다."
                        msg.style.color = "red";
                    }
                }

                function isValidName() {
                    const inputName = document.getElementById("name").value;
                    const msg = document.getElementById("name-msg");
                    const namePattern = /^[가-힣]*$/;
                    if (inputName == "") {
                        msg.innerHTML = "";
                    }else if (namePattern.test(inputName)) {
                        msg.innerHTML = "사용가능한 이름입니다";
                        msg.style.color = "green";
                    } else {
                        msg.innerHTML = "사용 불가능한 이름입니다."
                        msg.style.color = "red";
                    }
                }

                function isValidIdNum(){
                    const inputIdNum = document.getElementById("id-number").value;
                    const msg = document.getElementById("idnum-msg");

                    const idNumPattern = /^[0-9-]{14}$/;
                    if (idNumPattern.test(inputIdNum)) {
                        msg.innerHTML = "사용가능한 주민번호입니다";
                        msg.style.color = "green";
                    } else if (inputIdNum == "") {
                        msg.innerHTML = "";
                    } else {
                        msg.innerHTML = "사용 불가능한 주민번호입니다."
                        msg.style.color = "red";
                    }
                }

                function isValidPhone(){
                    const inputPhone = document.getElementById("phone-number").value;
                    const msg = document.getElementById("phone-msg");

                    const phonePattern = /^[0-9]{11}$/;
                    if (phonePattern.test(inputPhone)) {
                        msg.innerHTML = "사용가능한 번호입니다";
                        msg.style.color = "green";
                    } else if (inputPhone == "") {
                        msg.innerHTML = "";
                    } else {
                        msg.innerHTML = "사용 불가능한 번호입니다."
                        msg.style.color = "red";
                    }
                }

            </script>
		</div>
	</main>

	<footer class="footer">
		<%@ include file="/views/common/footer.jsp"%>

	</footer>
</body>
</html>