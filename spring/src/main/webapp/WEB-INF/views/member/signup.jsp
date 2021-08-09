<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery.validate.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/additional-methods.min.js"></script>
<style>
	.error{
		color:red;
	}
</style>
</head>
<body>

<form class="container" method="post" action="<%=request.getContextPath()%>/signup" id="signup">
	<h1>회원가입</h1>
	<div class="form-group">
		<label>아이디</label>
		<input type="text" class="form-control" name="id">
	</div>
	<button id="dupCheck" type="button" class="col-12 btn btn-outline-success">아이디 중복 확인</button>
	<div class="form-group">
		<label>비밀번호</label>
		<input type="password" class="form-control" name="pw" id="pw">
	</div>
	<div class="form-group">
		<label>비밀번호 확인</label>
		<input type="password" class="form-control" name="pw2">
	</div>
	<div class="form-group">
		<label>이름</label>
		<input type="text" class="form-control" name="name">
	</div>
	<div class="form-group">
		<label>이메일</label>
		<input type="text" class="form-control" name="email">
	</div>
	<div class="form-group">
		<label>성별</label>
		<select class="form-control" name="gender">
			<option value="M">남성</option>
			<option value="F">여성</option>
		</select>
	</div>
	<button class="btn btn-outline-success col-12">회원가입</button>
</form>
<script type="text/javascript">
$(function(){
	$('#dupCheck').click(function(){
		var id = $('[name=id]').val();
		$.ajax({
			type: 'get',
			url : '<%=request.getContextPath()%>/member/idcheck/' + id,
			success : function(result, status, xhr){
				if(result == 'POSSIBLE')
					alert('사용 가능한 아이디입니다.')
				else
					alert('사용 불가능한 아이디입니다.')
			},
			error : function(xhr, status, e){
				
			}
		})
	})
	
    $("#signup").validate({
        rules: {
            id: {
                required : true,
                regex: /^[0-9a-z_-]{5,20}$/
            }
        },
        //규칙체크 실패시 출력될 메시지
        messages : {
            id: {
                required : "필수정보입니다.",
                regex : "5~20자의 영문 소문자, 숫자와 특수기호(_),(-)만 사용 가능합니다."
            }
        },
        submitHandler: function(form) {
            //주소를 하나로 합치는 코드
            //생년월일을 하나로 합치는 코드
            $(form).submit();
        }
    });
	
})
$.validator.addMethod(
    "regex",
    function(value, element, regexp) {
        var re = new RegExp(regexp);
        return this.optional(element) || re.test(value);
    },
    "Please check your input."
);
</script>
</body>
</html>
