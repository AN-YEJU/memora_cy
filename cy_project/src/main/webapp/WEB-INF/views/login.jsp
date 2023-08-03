<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<style>
  body {
    font-family: Arial, sans-serif;
    background-color: #f5f5f5;
  }
  .container {
    max-width: 400px;
    margin: 100px auto;
    padding: 20px;
    border: 1px solid #ccc;
    border-radius: 8px;
    background-color: #fff;
    box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
  }
  .container h2 {
    text-align: center;
    margin-bottom: 20px;
  }
  .form-group {
    margin-bottom: 20px;
  }
  .form-group label {
    display: block;
    font-size: 14px;
    font-weight: bold;
    margin-bottom: 5px;
  }
  .form-group input[type="text"],
  .form-group input[type="password"] {
    width: 100%;
    padding: 8px;
    font-size: 14px;
    border: 1px solid #ccc;
    border-radius: 4px;
  }
  .form-group input[type="submit"] {
    width: 100%;
    padding: 10px;
    font-size: 16px;
    color: #fff;
    background-color: #8a949e;
    border: none;
    border-radius: 4px;
    cursor: pointer;
  }
  .form-group input[type="submit"]:hover {
    background-color: #4e5862;
  }
  .register-link {
    text-align: center;
  }
  .register-link a {
    color: #42464a;
    text-decoration: none;
  }
</style>
</head>
<body>
  <div class="container">
    <h2>로그인</h2>
    <form method="post" action="login_yn">
      <div class="form-group">
        <label for="id">아이디</label>
        <input type="text" name="id" id="id" required>
      </div>
      <div class="form-group">
        <label for="pwd">비밀번호</label>
        <input type="password" name="pwd" id="pwd" required>
      </div>
      <div class="form-group">
        <input type="submit" value="로그인">
      </div>
    </form>
    <div class="register-link">
      <a href="register">회원가입</a>
    </div>
  </div>
</body>
</html>