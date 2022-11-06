<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>회원가입</title>
<%@ include file="../header.jsp" %>
<script>
function check(){
	//이름체크
	var user_name = $("#user_name").val();
	if (user_name==""){
		alert("이름는 필수 입력입니다.");
		$("#user_name").focus();
		return;
	}
	//이메일 체크
	var user_email=$("#user_email").val();
	if (user_email==""){
		alert("이메일은 필수 입력입니다.");
		$("#user_email").focus();
		return;
	}
	
	//닉네임 체크
	var user_sname = $("#user_sname").val();
	if (user_sname==""){
		alert("닉네임을 입력하세요.");
		$("#user_sname").focus();
		return;
	}
	
	//비밀번호 체크
	var user_pwd = $("#user_pwd").val();
	if (user_pwd==""){
		alert("비밀번호를 입력하세요.");
		$("#user_pwd").focus();
		return;
	}
	
	//전화번호 체크
	var user_phone = $("#user_phone").val();
	if (user_phone==""){
		alert("전화번호를 입력하세요.");
		$("#user_phone").focus();
		return;
	}
	document.form1.submit();
}
</script>
</head>
<body>
<%@ include file="../menu.jsp" %>
<div class="container">
<h2>회원등록</h2>
<form name="form1" method="post" action="${path}/member/insert.do">
<div class="form-group">
 이름 <input class="form-control" placeholder="이름" 
 name="user_name" id="user_name" type="text">
</div>
<div class="form-group">
 이메일 <input class="form-control" placeholder="이메일" 
 name="user_email" id="user_email" type="text">
</div>
<div class="form-group">
 닉네임 <input class="form-control" placeholder="닉네임" 
 name="user_sname" id="user_sname" type="text">
</div>
<div class="form-group">
 비밀번호 <input class="form-control" placeholder="비빌번호" 
 name="user_pwd" id="user_pwd" type="password">
</div>
<div class="form-group">
 전화번호 <input class="form-control" placeholder="전화번호" 
 name="user_phone" id="user_phone" type="text">
</div>

<input type="button" class="btn btn-lg btn-success btn-block" 
onclick="check()" value="확인">
</form>
</div>

</body>
</html>
                