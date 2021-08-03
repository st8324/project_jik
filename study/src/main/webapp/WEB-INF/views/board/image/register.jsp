<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.js"></script>
</head>
<body>
	<form class="container" method="post" enctype="multipart/form-data">
		<h1>게시판</h1>
		<div class="form-group">
			<label>제목</label>
			<input type="text" class="form-control" name="title">
		</div>
		<div class="form-group">
			<label>내용</label>
			<textarea id="summernote" class="form-control" name="contents" rows="10">${board.contents }</textarea>
		</div>
		<div class="form-group">
			<label>대표이미지</label>
			<input type="file" name="mainImage" class="form-control">
		</div>
		<div class="form-group">
			<label>첨부파일</label>
			<input type="file" name="fileList" class="form-control">
			<input type="file" name="fileList" class="form-control">
			<input type="file" name="fileList" class="form-control">
		</div>
		<div class="form-group">
			<label>비밀번호</label>
			<input type="password" class="form-control" name="pw">
		</div>
		<button class="btn btn-outline-success">등록</button>
		<a href="<%=request.getContextPath()%>/board${type}/list"><button type="button" class="btn btn-outline-danger">목록</button></a>
	</form>
	<script type="text/javascript">
	$(function(){
		$('form').submit(function(){
			//제목 입력했는지 체크, 내용이 입력됐는지 체크해야 하는데 생략
			//대표 이미지가 선택 됐는지 체크
			if($('[name=mainImage]').val() == ''){
				alert('대표 이미지를 선택하세요.')
				return false;
			}
			//비밀번호가 입력됐는지 체크
			if($('[name=pw]').val() == ''){
				alert('비밀번호를 입력해주세요.');
				return false;
			}
			return true;
		})
		$('#summernote').summernote({
			placeholder: 'Hello Bootstrap 4',
			tabsize: 2,
			height: 400
		});
	})
	</script>
</body>
</html>
