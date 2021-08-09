<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<style>
.item-list{
	list-style: none;	margin: 20px 0;	padding: 0;
}
.item-list::after{
	clear: both; content: ''; display: block;
}
.item-list .item{
	width:calc(100% / 3); float: left; text-align: center;
	box-sizing: border-box; padding : 0 10px;
}
.item-list .item span{
	display: block; width: 100%; margin-top: 5px; line-height: 20px; 
	height: 20px; overflow: hidden; text-overflow: ellipsis; white-space: nowrap;
}
.container{
	position: relative;
}
.pw-box{
	position: absolute; left: 0; top: 0; bottom:0; right : 0; z-index: 10;
	display: none;
}
.pw-box .pw-input-box{
	width: 500px; height: 300px; border: 1px solid black; background: white;
	top:100px; left: calc(50% - 250px); z-index: 3;
	position: absolute;
}
.pw-box .pw-bg-box{
	position: absolute; left: 0; top: 0; bottom:0; right : 0;
	background: black; opacity: 0.3; 
}
</style>
</head>
<body>
<div class="container">
	<ul class="item-list">
		<c:forEach items="${list }" var="board">
			<li class="item" data="${board.num}">
				<a href="<%=request.getContextPath()%>/board/image/detail?num=${board.num}">
					<img alt="" src="<%=request.getContextPath()%>/img${board.thumbnail.name}" width="100%" height="300">
					<span class="title">${board.title}</span>
				</a>
			</li>
		</c:forEach>
	</ul>
	<ul class="pagination justify-content-center">
		<c:if test="${pm.prev}">
	    	<li class="page-item"><a class="page-link" href="<%=request.getContextPath()%>/board${type}/list?page=${pm.startPage-1}">이전</a></li>
	    </c:if>
	    <c:forEach begin="${pm.startPage }" end="${pm.endPage }" var="index">
	    	<c:choose>
	    		<c:when test="${pm.criteria.page == index }">
					<li class="page-item active"><a class="page-link" href="<%=request.getContextPath()%>/board${type}/list?page=${index}">${index}</a></li>	    		
	    		</c:when>
	    		<c:otherwise>
	    			<li class="page-item"><a class="page-link" href="<%=request.getContextPath()%>/board${type}/list?page=${index}">${index}</a></li>	
	    		</c:otherwise>
	    	</c:choose>
	    </c:forEach>
	    <c:if test="${pm.next}">
	    	<li class="page-item"><a class="page-link" href="<%=request.getContextPath()%>/board${type}/list?page=${pm.endPage+1}">다음</a></li>
	    </c:if>
	</ul>
<c:if test="${user != null}">
<!-- 타입이 공지이고 관리자이거나 타입이 공지사항이 아니면 글쓰기 버튼이 보여야함 -->
	<c:if test="${(type eq '/notice' && (user.authority eq 'ADMIN' || 
	user.authority eq 'SUPER ADMIN')) || (type ne '/notice')}">
		<a href="<%=request.getContextPath()%>/board${type}/register">
			<button class="btn btn-outline-success">글쓰기</button>
		</a>
	</c:if>
</c:if>
<form id="pwBox" class="pw-box" method="post" action="<%=request.getContextPath()%>/board/image/detail">
	<div class="pw-input-box form-group pl-2 pr-2">
		<label>비밀번호를 입력하세요.</label>
		<input type="password" name="pw" class="form-control">
		<input type="hidden" name="num">
		<button type="button" class="btn btn-outline-success col-12">확인</button>
	</div>
	<div class="pw-bg-box"></div>
</form>
</div>

<script type="text/javascript">
$(function(){
	$('.item-list .item a').click(function(e){
		e.preventDefault();
		$('.pw-box').show();
		var num = $(this).parent().attr('data');
		$('.pw-box [name=num]').val(num);
	})
	$('.pw-box button').click(function(){
		var num = $('.pw-box [name=num]').val();
		var pw = $('.pw-box [name=pw]').val();
		var data = {num : num, pw : pw};
		$.ajax({
			type:'post',
			url : '<%=request.getContextPath()%>/board/image/check',
			data: JSON.stringify(data),
			contentType : "application/json; charset:utf-8",
			success : function(res){
				if(res == 'true')
					$('#pwBox').submit();
				else
					alert('잘못된 비밀번호입니다.');
			}
		})
	})
})
</script>
</body>
</html>
