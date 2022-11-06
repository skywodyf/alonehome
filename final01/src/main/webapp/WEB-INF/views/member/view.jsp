<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../header.jsp" %>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
$(function(){
	$("#btnUpdate").click(function(){
		document.form1.action="${path}/member/update.do";
		document.form1.submit();
	});
	$("#btnDelete").click(function(){
		if(confirm("삭제하시겠습니까?")){
			document.form1.action="${path}/member/delete.do";
			document.form1.submit();
		}
	});
});    
</script>
</head>
<body>
<%@ include file="../menu.jsp" %>
<div class="container">
<h2>회원정보 수정</h2>
<form name="form1" method="post">
 <div class="form-group">
   이메일 <input name="user_email" value="${dto.user_email}">
 </div>
 <div class="form-group">
   이름<input name="user_name" value="${dto.user_name}" readonly>
 </div>
 <div class="form-group">
   비밀번호<input type="password" name="user_pwd">
 </div>
 <div class="form-group">
   닉네임<input name="user_sname" value="${dto.user_sname}">
 </div>
 <div class="form-group">
   핸드폰<input name="user_phone" value="${dto.user_phone}">
 </div>
 <div class="form-group">
   회원가입일자
   <c:if test="${join_date != null }">
    <fmt:formatDate value="${join_date}" 
    pattern="yyyy-MM-dd HH:mm:ss"/>
   </c:if>
 </div>
 <div class="form-group">
   <input type="button" value="수정" id="btnUpdate">
   <input type="button" value="삭제" id="btnDelete">
   <div style="color: red;">${message}</div>
 </div>
</form>
</div>

</body>
</html>
                    