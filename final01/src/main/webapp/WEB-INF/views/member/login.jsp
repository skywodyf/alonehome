<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../header.jsp" %>
<script>
$(function(){
	$("#btnLogin").click(function(){
		var userid=$("#user_email").val(); //태그의 value 속성값
		var passwd=$("#user_pwd").val();
		if(userid==""){
			alert("아이디를 입력하세요.");
			$("#user_email").focus(); //입력 포커스 이동
			return; //함수 종료
		}
		if(passwd==""){
			alert("비밀번호를 입력하세요.");
			$("#user_pwd").focus();
			return;
		}
		//폼 데이터를 서버로 제출
		document.form1.action="${path}/member/login_check.do";
		document.form1.submit();
	});
});
</script>
</head>
<body>
<%@ include file="../menu.jsp" %>
<div class="container">
<h2>로그인</h2>
<form name="form1" method="post">
	<div class="form-group">
	 아이디 <input name="user_email" id="user_email" class="form-control">
	</div>
	<div class="form-group">
	 아이디 <input name="user_pwd" id="user_pwd" class="form-control" type="password">
	</div>
	<div class="form-group">
			<input type="button" id="btnLogin" value="로그인" class="btn btn-lg btn-success btn-block">
			<c:if test="${param.message == 'nologin' }">
				<div style="color:red;">
					로그인 하신 후 사용하세요.
				</div>				
			</c:if>
			<c:if test="${message == 'error' }">
				<div style="color:red;">
					아이디 또는 비밀번호가 일치하지 않습니다.
				</div>
			</c:if>
			<c:if test="${message == 'logout' }">
				<div style="color:blue;">
					로그아웃 처리되었습니다.
				</div>
			</c:if>
		</div>
</form>
</div>
</body>
</html>
