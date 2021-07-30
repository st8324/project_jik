<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
	<form class="container" method="post" action="<%=request.getContextPath()%>/board/reply/register">
		<h1>게시판</h1>
		<div class="form-group">
			<label>내용</label>
			<textarea id="summernote" class="form-control" name="contents" rows="10">${board.contents }</textarea>
		</div>
		<input type="hidden" name="oriNo" value="${oriNo}">
		<button class="btn btn-outline-success">등록</button>
		<a href="<%=request.getContextPath()%>/board/list"><button type="button" class="btn btn-outline-danger">목록</button></a>
	</form>
	<script type="text/javascript">
	$(function(){
		$('form').submit(function(){
			return true;
		})
	})
	</script>
</body>
</html>
