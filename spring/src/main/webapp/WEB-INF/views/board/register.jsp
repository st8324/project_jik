<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
</head>
<body>
<form class="container" method="post" action="<%=request.getContextPath()%>/board/register" enctype="multipart/form-data">
	<h2>게시글 등록</h2>
	<div class="form-group">
		<label>제목</label>
		<input type="text" class="form-control" name="title">
	</div>
	<div class="form-group">
		<label>내용</label>
		<textarea class="form-control" rows="10" name="contents"></textarea>
	</div>
	<div class="form-group">
        <label>파일</label>
        <input type="file" class="form-control" name="file"/>
    </div>
	<button type="submit" class="btn btn-outline-success">등록</button>
</form>
</body>
</html>
