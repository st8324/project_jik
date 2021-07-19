<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.js"></script>
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
		<textarea id="summernote" name="contents"></textarea>
	</div>
	<div class="form-group  files">
        <label>파일</label>
        <input type="file" class="form-control" name="file" data=""/>
    </div>
	<button type="submit" class="btn btn-outline-success">등록</button>
</form>
<script type="text/javascript">
$(function(){
	$(document).on('change','input[name=file]',function(){
		var val = $(this).val();
		var str = '<input type="file" class="form-control" name="file" data=""/>';
		var length = $('input[name=file]').length;
		var data = $(this).attr('data');
		//
		if(val == ''){
			$(this).remove();
			if(length == 3 && $('input[name=file]').last().val() != '' ){
				$('.files').append(str);
			}
		}
		//input 태그를 추가해야하는 경우
		else{
			if( length < 3 && data == '' ){
				$('.files').append(str);
			}
			$(this).attr('data',val);
		}
	})
	$('#summernote').summernote({
        placeholder: '내용을 작성하세요.',
        tabsize: 2,
        height: 400
	});
})
</script>
</body>
</html>
