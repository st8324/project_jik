<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
<div class="bg-dark">
	<nav class="navbar navbar-expand-sm  navbar-dark container">
	  <!-- Brand/logo -->
	  <a class="navbar-brand" href="<%=request.getContextPath()%>/">
	    <img src="<%=request.getContextPath()%>/resources/img/bird.jpg" alt="logo" style="width:40px;">
	  </a>
	  
	  <!-- Links -->
	  <ul class="navbar-nav">
	    <li class="nav-item">
	      <a class="nav-link" href="<%=request.getContextPath()%>/board/list">게시판</a>
	    </li>
	    <c:if test="${user == null }">
		    <li class="nav-item">
		      <a class="nav-link" href="<%=request.getContextPath()%>/signin">Sign In</a>
		    </li>
		    <li class="nav-item">
		      <a class="nav-link" href="<%=request.getContextPath()%>/signup">Sign Up</a>
		    </li>
	    </c:if>
	    <c:if test="${user != null }">
		    <li class="nav-item">
		      <a class="nav-link" href="<%=request.getContextPath()%>/member/mypage">My Page</a>
		    </li>
		    <li class="nav-item">
		      <a class="nav-link" href="<%=request.getContextPath()%>/member/signout">Sign Out</a>
		    </li>
	    </c:if>
	  </ul>
	</nav>
</div>
</body>
</html>