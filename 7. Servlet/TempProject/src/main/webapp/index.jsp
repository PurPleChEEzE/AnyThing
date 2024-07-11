<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>간단한 홈페이지</title>
  <style>
body {
    font-family: Arial, sans-serif;
    background-color: #f0f0f5;
    margin: 0;
    padding: 0;
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
}

section {
    background-color: #fff;
    box-shadow: 0 4px 8px rgba(0,0,0,0.1);
    border-radius: 8px;
    padding: 20px;
    max-width: 400px;
    width: 100%;
}

.signup-form {
    text-align: center;
}

.signup-form h2 {
    margin-bottom: 20px;
    color: #333;
}

.input-container {
    margin-bottom: 15px;
    text-align: left;
}

.input-container label {
    display: block;
    margin-bottom: 5px;
    color: #555;
}

.input-container input {
    width: 100%;
    padding: 10px;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
}

button {
    background-color: #5cb85c;
    color: white;
    border: none;
    padding: 10px 20px;
    border-radius: 4px;
    cursor: pointer;
    transition: background-color 0.3s;
}

button:hover {
    background-color: #4cae4c;
}

  </style>
</head>
<body>

  <section>
    <div class="signup-form">
        <h2>회원가입</h2>
        <form action = "/member/signup.do" method = "POST" >
          <div class="input-container">
          </div>
          <div class="input-container">
            <label for="new-username">이름:</label>
            <input type="text" id="new-username" name = "new-username" required>
          </div>

          <div class="input-container">
              <label for="new-userid">아이디:</label>
              <input type="text" id="new-userid" name = "new-userid" required>
          </div>
          <div class="input-container">
            <label for="new-password">비밀번호:</label>
            <input type="password" id="new-password" name = "new-password" required>
          </div>
  
          <div class="input-container">
            <label for="confirm-password">비밀번호 확인:</label>
            <input type="password" id="confirm-password" name = "confirm-password" required>
          </div>

          <div class="input-container">
            <label for="birthdate">생년월일(8자리) :</label>
            <input type="text" id="birthdate" name = "birthdate" required>
          </div>

          <div class="input-container">
            <label for="address">주소 :</label>
            <input type="text" id="address" name = "address" required>
          </div>
  
          <button type="submit">회원가입</button>
        </form>
      </div>
  </section>
</body>
</html>