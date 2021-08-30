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
	<form class="container" enctype="multipart/form-data" method="post">
		<h1>게시판</h1>
		<div class="form-group">
			<label>제목</label>
			<input type="text" class="form-control" name="title" value="${board.title}">
		</div>
		<div class="form-group">
			<label>작성자</label>
			<input type="text" class="form-control" name="writer" readonly value="${board.writer}">
		</div>
		<div class="form-group">
			<label>내용</label>
			<textarea id="summernote" class="form-control" name="contents" rows="10">${board.contents }</textarea>
		</div>
		<div class="form-group thumbnail-box">
			<label>대표 이미지</label>
			<div class="form-control">
				<span>${fList.get(0).ori_name }</span>
				<i class="fas fa-times"></i>
				<input type="hidden" name="thumbnailNo" value="${fList.get(0).num}">
			</div>
		</div>
		<div class="form-group file-box">
			<label>첨부파일</label>
			<c:forEach items="${fList}" var="file">
				<c:if test="${file.thumbnail == 'N'}">
					<div class="form-control">
						<span>${file.ori_name }</span>
						<i class="fas fa-times"></i>
						<input type="hidden"name="fileNumList" value="${file.num}">
					</div>
				</c:if>
			</c:forEach>
			<c:forEach begin="1" end="${3 - fList.size() + 1}">
				<input type="file" class="form-control" name="fileList">
			</c:forEach>
		</div>
		<input type="hidden" name="num" value="${board.num}">
		<button class="btn btn-outline-success">등록</button>
		<a href="<%=request.getContextPath()%>/board${type}/list"><button type="button" class="btn btn-outline-danger">목록</button></a>
	</form>
	<script type="text/javascript">
		$(function(){
			$('.file-box .fa-times').click(function(){
				$(this).parent().remove();
				$('.file-box').append('<input type="file" class="form-control" name="fileList">');
			})
			$('.thumbnail-box .fa-times').click(function(){
				$(this).parent().remove();
				$('.thumbnail-box').append('<input type="file" class="form-control" name="mainImage">');
			})
			$('form').submit(function(){
				//제목 입력했는지 체크, 내용이 입력됐는지 체크해야 하는데 생략
				//대표 이미지가 선택 됐는지 체크
				if(	typeof $('[name=thumbnailNo]').val() == 'undefined' 
						&& $('[name=mainImage]').val() == ''){
					alert('대표 이미지를 선택하세요.')
					return false;
				}
				return true;
			})
			$('#summernote').summernote({
				height: 600,
				fontNames : [ '맑은고딕', 'Arial', 'Arial Black', 'Comic Sans MS', 'Courier New', ],
				fontNamesIgnoreCheck : [ '맑은고딕' ],
				focus: true,
				callbacks: {
					onImageUpload: function(files, editor, welEditable) {
			            for (var i = files.length - 1; i >= 0; i--) {
			            	sendFile(files[i], this);
			            }
			        },
					onMediaDelete : function(target) {
		                // alert(target[0].src) 
		                console.log(target)
		                deleteFile(target[0].src);
		            }
			        
				}
			});
		})
		function deleteFile(src) {

		    $.ajax({
		        data: {src : src},
		        type: "POST",
		        url: '<%=request.getContextPath()%>/board/img/delete',
		        cache: false,
		        success: function(resp) {
		            console.log(resp);
		        }
		    });
		}
		function sendFile(file, el) {
			var form_data = new FormData();
	      	form_data.append('file', file);
	      	$.ajax({
	        	data: form_data,
	        	type: "POST",
	        	url: '<%=request.getContextPath()%>/board/img/upload',
	        	cache: false,
	        	contentType: false,
	        	enctype: 'multipart/form-data',
	        	processData: false,
	        	success: function(img_name) {
	        		console.log(img_name)
	          		$(el).summernote('editor.insertImage', '<%=request.getContextPath()%>/img'+ img_name);
	        	}
	      	});
	    }
	</script>
</body>
</html>
