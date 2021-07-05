<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
 서버에서 보낸 데이터 : ${name}
</h1>
<hr>
<a href="/spring/signin?id=abc123&pw=abc123">서버로 보낼 데이터 아이디 : abc123, 비밀번호 : abc123</a>
<hr>
<form action="/spring/signin">
id : <input type="text" name="id"> <br>
pw : <input type="password" name="pw"> <br>
취미: <input type="text" name="hobby"> <br>
취미: <input type="text" name="hobby"> <br>
<button>전송</button>
</form>
</body>
</html>
