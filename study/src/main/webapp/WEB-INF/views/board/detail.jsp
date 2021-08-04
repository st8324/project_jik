<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/reply.js"></script>
<style>
.recommend-btn{
	font-size: 30px;
}
.fa-thumbs-down{
	transform : rotateY(180deg);
}
</style>
</head>
<body>
	<div class="container">
		<h1>게시판</h1>
		<div class="form-group">
			<label>제목</label>
			<input type="text" class="form-control" name="title" value="<c:out value="${board.title}"/>" readonly>
		</div>
		<div class="form-group">
			<label>작성자</label>
			<input type="text" class="form-control" name="writer" value="${board.writer}" readonly>
		</div>
		<div class="form-group">
			<label>작성일</label>
			<input type="text" class="form-control" name="registered" value="${board.dateTime}" readonly>
		</div>
		<div class="form-group">
			<label>조회수</label>
			<input type="text" class="form-control" name="views" value="${board.views}" readonly>
		</div>
		
		<div class="form-group">
			<label>내용</label>
			<div class="form-control" style="min-height:400px;">${board.contents }</div>
		</div>
		<div class="form-group">
			<label>첨부파일</label>
			<c:forEach items="${fList}" var="file">
				<a class="form-control" href="<%=request.getContextPath()%>/board/download?fileName=${file.name}">${file.ori_name}</a>
			</c:forEach>
		</div>
		<hr>
		<div class="reply form-group">
			<label>댓글</label>
			<div class="contents">
				<div class="reply-list form-group"></div>
				<ul class="pagination justify-content-center"></ul>
				<div class="reply-box form-group">
					<textarea class="reply-input form-control mb-2" ></textarea>
					<button type="button" class="reply-btn btn btn-outline-success">등록</button>
				</div>
			</div>
		</div>
		<c:if test="${board.groupOrd == 0 && board.type != 'NOTICE' && (user != null && user.authority != 'USER')}">
			<a href="<%=request.getContextPath()%>/board/reply/register?oriNo=${board.num}">
				<button class="btn btn-outline-success">답변</button>
			</a>
		</c:if>
		<c:if test="${user != null && user.id == board.writer }">
			<a href="<%=request.getContextPath()%>/board${type}/modify?num=${board.num}" style="text-decoration: none">
				<button class="btn btn-outline-danger">수정</button>
			</a>
			<a href="<%=request.getContextPath()%>/board${type}/delete?num=${board.num}" style="text-decoration: none">
				<button class="btn btn-outline-danger">삭제</button>
			</a>
		</c:if>
	</div>
<script type="text/javascript">
var rp_bd_num = '${board.num}';
var rp_me_id = '${user.id}';
var contextPath = '<%=request.getContextPath()%>';
$(function(){
	//댓글 등록 버튼 클릭
	$('.reply-btn').click(function(){
		if(rp_me_id == ''){
			alert('로그인을 하세요.');
			return;
		}
		var rp_content = $('.reply-input').val();
		var data = {
				rp_bd_num:rp_bd_num, rp_content:rp_content
		}
		replyService.add(contextPath, data, responseOk, listOk);
		$('.reply-input').val('');
	})
	//페이지네이션에서 페이지 클릭
	$(document).on('click','.reply .pagination li', function(){
		var page = $(this).attr('data-page');
		replyService.list(contextPath, {page : page, rp_bd_num: rp_bd_num}, listOk);
	})
	//댓글 수정버튼 클릭
	$(document).on('click','.reply-mod-btn', function(){
		//클릭한 수정 버튼이 있는 댓글의 내용, this : 수정 버튼
		var rp_content = $(this).parent().siblings('.reply-content').text();
		
		$('.reply .reply-content').each(function(){
			//this : .reply-content 요소 하나하나
			var rp_content = $(this).text();
			var str = '<div class="form-control reply-content">'+rp_content+'</div>';
			$(this).before(str);
			$(this).remove();
			//수정 버튼 보여주고 등록 버튼 감춤
			$('.reply .reply-ok-btn').remove();
			$('.reply .reply-mod-btn').show();
		})
		
		//$(this).parent() : 버튼 그룹(수정, 삭제 버튼을 가진 그룹)
		$(this).parent().siblings('.reply-content').remove();
		var str = '<textarea class="form-control reply-content">'+rp_content+'</textarea>'
		$(this).parent().before(str);
		//수정 버튼 감추고
		$(this).hide();
		//등록 버튼 추가
		str = '<button class="btn btn-outline-success reply-ok-btn">등록</button>';
		$(this).before(str);		
	})
	//수정 버튼 눌렀을 때 나타나는 등록 버튼 클릭
	$(document).on('click','.reply-ok-btn', function(){
		//댓글 번호
		var rp_num = $(this).siblings('.rp_num').val();
		//수정된 댓글 내용
		var rp_content = $(this).parent().siblings('.reply-content').val();
		//수정된 댓글이 있는 페이지
		var page = $('.reply .pagination .active a').html();
		var data = {
				rp_num     : rp_num, 
				rp_content : rp_content,
				rp_bd_num  : rp_bd_num,
				page       : page
		}
		replyService.mod(contextPath, data, responseOk ,listOk );
		
	});
	//삭제 버튼을 클릭
	$(document).on('click','.reply-del-btn', function(){
		var rp_num = $(this).siblings('.rp_num').val();
		var data = {rp_num : rp_num, rp_bd_num : rp_bd_num};
		replyService.del(contextPath, data, responseOk, listOk);
		
	});
	//시작시 댓글 1페지 내용 가져옴
	replyService.list(contextPath, {page : 1, rp_bd_num: rp_bd_num}, listOk);
})

function responseOk(res, str){
	if(res == 'OK')
		alert('댓글이 '+str+'되었습니다.');
	else
		alert('댓글 '+str+'에 실패했습니다.');
}

function listOk(res){
	var list = res.list;
	var str = '';
	for(i = 0; i<list.length; i++){
		str +=
		'<div class="input-group">'+
			'<div class="input-group-prepend">'+
	        	'<span class="input-group-text">'+list[i].rp_me_id+'</span>'+
		    '</div>'+
			'<div class="form-control reply-content">'+list[i].rp_content+'</div>'+
			'<div class="input-group-append">';
				if(list[i].rp_me_id == rp_me_id){
					str += 
					'<button class="btn btn-outline-danger reply-mod-btn">수정</button>'+
				    '<button class="btn btn-outline-danger reply-del-btn">삭제</button>'+
				    '<input type="hidden" class="rp_num" value="'+list[i].rp_num+'">'
				}
			str +=
			'</div>'+
		'</div>'
	}
	$('.reply-list').html(str);
	str ='';
	var pm = res.pm;
	if(pm.prev)
		str += '<li class="page-item" data-page="'+(pm.startPage-1)+'"><a class="page-link" href="javascript:void(0);">이전</a></li>'
	for(i=pm.startPage; i<=pm.endPage; i++){
		if(pm.criteria.page != i)
			str += '<li class="page-item" data-page="'+i+'"><a class="page-link" href="javascript:void(0);">'+i+'</a></li>'
		else
			str += '<li class="page-item active" data-page="'+i+'"><a class="page-link" href="javascript:void(0);">'+i+'</a></li>'
	}
	if(pm.next)
		str += '<li class="page-item" data-page="'+(pm.endPage+1)+'"><a class="page-link" href="javascript:void(0);">다음</a></li>'
	$('.pagination').html(str);
}

</script>
</body>
</html>
