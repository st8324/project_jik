<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
</head>
<body>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	<!-- Brand/logo -->
	<a class="navbar-brand" href="#">
		<img src="bird.jpg" alt="logo" style="width:40px;">
	</a>
	
	<!-- Links -->
	<ul class="navbar-nav">
		<c:if test="${user == null }">
		<li class="nav-item">
			<a class="nav-link" href="<%=request.getContextPath()%>/member/signup">회원가입</a>
		</li>
		<li class="nav-item">
			<a class="nav-link" href="<%=request.getContextPath()%>/member/signin">로그인</a>
		</li>
		<li class="nav-item">
			<a class="nav-link" href="#">Link 3</a>
		</li>
		</c:if>
	</ul>
</nav>

</body>
</html>
