<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
  .container h1 {
    text-align: center;
    margin-bottom: 20px;
  }
  .button-container {
    text-align: center;
    margin-top: 20px;
  }
  .button-container input[type="button"] {
    padding: 10px 20px;
    font-size: 16px;
    color: #fff;
    background-color: #007bff;
    border: none;
    border-radius: 4px;
    cursor: pointer;
    margin-right: 10px;
  }
  .button-container input[type="button"]:last-child {
    margin-right: 0;
  }
  .button-container input[type="button"]:hover {
    background-color: #0056b3;
  }
</style>
</head>
<body>
  <div class="container">
    <div align="center"><h3>${memDto.name}님 반갑습니다.</h3></div>
    <div class="button-container">
      <input type="button" onclick="location.href='login'" value="로그아웃">
      <input type="button" onclick="location.href='home'" value="MEMORA">
    </div>
  </div>
</body>
</html>