<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
	<title>로그인</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
	<div class="form-group">
		<input type="text" class="form-control" name="id" placeholder="아이디를 입력하세요.">
	</div>
	<button class="find-pw-btn btn btn-outline-success col-12">비밀번호 찾기</button>
	<div class="wait-box"></div>
</div>
<script type="text/javascript">
	$(function(){
		$('.find-pw-btn').click(function(){
			var id = $('[name=id]').val();
			$('.wait-box').text('전송중입니다. 알림창이 나타날때까지 기다려주세요.')
			$.ajax({
				type : 'get',
				url : '<%=request.getContextPath()%>/find/pw/' + id,
				success : function(res){
					$('.wait-box').text('');
					if(res == 'SUCCESS'){
						alert('새 비밀번호가 메일로 전송됐습니다.')
					}else{
						alert('가입되지 않은 아이디입니다.')
					}
				}
			})
		})
	})
</script>
</body>
</html>
