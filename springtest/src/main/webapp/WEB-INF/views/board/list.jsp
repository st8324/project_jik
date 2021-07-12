<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>게시판</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<h2>게시판</h2>
		<form method="get" action="<%=request.getContextPath()%>/board/list">
			<div class="input-group mb-3">
				<select class="form-control" name="type">
					
					<option value="0" <c:if test="${pm.criteria.type == 0 }">selected</c:if>>전체</option>
					<option value="1" <c:if test="${pm.criteria.type == 1 }">selected</c:if>>제목+내용</option>
					<option value="2" <c:if test="${pm.criteria.type == 2 }">selected</c:if>>작성자</option>
				</select>
				<input type="text" class="form-control" name="search" value="<c:out value="${pm.criteria.search}"/>" >
				<button class="btn btn-outline-dark">검색</button>
			</div>
		</form>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>작성일</th>
					<th>조회수</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="board">
					<tr>
						<td>${board.num}</td>
						<td><a href="<%=request.getContextPath()%>/board/detail?num=${board.num}">${board.title}</a></td>
						<td>${board.writer}</td>
						<td>${board.dateTime}</td>
						<td>${board.views}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<ul class="pagination justify-content-center">
			<c:if test="${pm.prev}">
		    	<li class="page-item"><a class="page-link" href="<%=request.getContextPath()%>/board/list?page=${pm.startPage-1}&search=<c:out value="${pm.criteria.search}"/>&type=${pm.criteria.type}">이전</a></li>
	    	</c:if>
	    	<c:forEach begin="${pm.startPage}" end="${pm.endPage}" var="index">
	    		<li class="page-item <c:if test="${pm.criteria.page == index }">active</c:if>">
	    			<a class="page-link" href="<%=request.getContextPath()%>/board/list?page=${index}&search=<c:out value="${pm.criteria.search}"/>&type=${pm.criteria.type}">${index}</a>
	    		</li>
		    </c:forEach>
		    <c:if test="${pm.next}">
		    	<li class="page-item"><a class="page-link" href="<%=request.getContextPath()%>/board/list?page=${pm.endPage+1}&search=<c:out value="${pm.criteria.search}"/>&type=${pm.criteria.type}">다음</a></li>
		    </c:if>
		</ul>
		<a href="<%=request.getContextPath()%>/board/register"><button class="btn btn-outline-danger">글쓰기</button></a>
	</div>
	<!-- 
	<img src="<%=request.getContextPath()%>/resources/img/dog.jfif">
	 -->
	<script type="text/javascript">
	$(function(){
		var msg = '${msg}';
		printMsg(msg);
		history.replaceState({},null,null);
	})
	function printMsg(msg){
		if(msg == '' || history.state){
			return ;
		}
		alert(msg);
	}
	</script>	
</body>
</html>
