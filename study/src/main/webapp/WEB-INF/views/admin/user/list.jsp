<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
<div class="container">
	<h1>회원관리</h1>
	<table class="table table-striped table-hover">
    <thead>
	<tr>
		<th>아이디</th>
		<th>등급</th>
		<th>설정</th>
	</tr>
    </thead>
    <tbody>
		<c:forEach items="${list}" var="member">    
			<tr>
				<td>${member.id}</td>
				<td>${member.authorityStr}</td>
				<td>
					
					<select class="form-control">
						<option value="USER" <c:if test="${member.authority == 'USER' }">selected</c:if>>회원</option>
						<c:if test="${user.authority == 'SUPER ADMIN' }">
							<option value="ADMIN" <c:if test="${member.authority == 'ADMIN' }">selected</c:if>>관리자</option>
						</c:if>
					</select>
				</td>
			</tr>
		</c:forEach>
    </tbody>
  </table>
</div>
</body>
</html>