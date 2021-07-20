<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
</head>
<body>
<c:if test="${board != null}">
<div class="container">
	<h2>게시판</h2>
	<div class="form-group">
		<label>제목</label>
		<input type="text" class="form-control" value="${board.title}" readonly>
	</div>
	<div class="form-group">
		<label>작성자</label>
		<input type="text" class="form-control" value="${board.writer}" readonly>
	</div>
	<div class="form-group">
		<label>작성일</label>
		<input type="text" class="form-control" value="${board.registeredDate}" readonly>
		<!-- ${board.getRegisteredDate()} -->
	</div>
	<div class="form-group">
		<label>조회수</label>
		<input type="text" class="form-control" value="${board.views}" readonly>
	</div>
	<div class="form-group">
		<button type="button" class="re-btn up btn btn<c:if test="${rvo.state != 1 }">-outline</c:if>-success">추천</button>
		<button type="button" class="re-btn down btn btn<c:if test="${rvo.state != -1 }">-outline</c:if>-success">비추</button>
	</div>
	<div class="form-group">
		<label>내용</label>
		<div class="form-control" style="height:auto;">${board.contents}</div>
	</div>
	<c:if test="${fileList.size() != 0 }">
		<div class="form-group">
			<label>첨부파일</label>
			<c:forEach items="${fileList}" var="file">
				<a href="<%=request.getContextPath()%>/board/download?fileName=${file.name}" class="form-control mb-2">${file.ori_name}</a>
			</c:forEach>
		</div>
	</c:if>
	<c:if test="${user != null && user.id == board.writer}">
		<a href="<%=request.getContextPath()%>/board/modify?num=${board.num}"><button class="btn btn-outline-success">수정</button></a>
		<a href="<%=request.getContextPath()%>/board/delete?num=${board.num}"><button class="btn btn-outline-success">삭제</button></a>
	</c:if>
	<a href="<%=request.getContextPath()%>/board/list"><button class="btn btn-outline-success">목록</button></a>
</div>
</c:if>
<c:if test="${board ==null}">
<div class="container">
	<h1>삭제되거나 존재하지 않은 게시글입니다.</h1>
	<a href="<%=request.getContextPath()%>/board/list"><button class="btn btn-outline-success">목록</button></a>
</div>
</c:if>
<script type="text/javascript">
$(function(){
	$('.re-btn').click(function(){
		//추천 버튼이면 state를 1로, 비추 버튼이면 state를 -1로
		var state = $(this).hasClass('up') ? 1 : -1;
		var num = '<c:out value="${board.num}"/>'
		var obj = $(this);
		$.ajax({
			type: 'get',
			url : '<%=request.getContextPath()%>/board/recommend/' + state + '/' + num,
			dataType : "json",
			success : function(res, status, xhr){
				var str = '';
				var str2 = '';
				if(state == 1)
					str2 = '추천';
				else
					str2 = '비추천';
				
				if(res.result == 0)
					str = '이 취소되었습니다.';
				else if(res.result == 1)
					str = '을 했습니다.'
				else
					str = '추천/비추천은 회원만 가능합니다..'
				
				if(res.result != -1){
					alert(str2+str);
				}else{
					alert(str);
				}
					
				if(res.result == 1){
					$('.re-btn').removeClass('btn-success').addClass('btn-outline-success');
					obj.removeClass('btn-outline-success').addClass('btn-success');
				}else if(res.result == 0){
					obj.removeClass('btn-success').addClass('btn-outline-success');
				}
				
				
				
			},
			error : function(xhr, status, e){
				
			}
		})
		
	})
})
</script>
</body>
</html>





