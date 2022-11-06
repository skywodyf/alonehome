<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원목록</title>
<%@ include file="../include/include_header.jsp" %>
</head>
<body>
<%@ include file="../menu.jsp" %>
<h2>회원목록</h2>
<input type="button" value="회원등록(일반)" 
onclick="location.href='${path}/member/write.do'">
<table border="1" style="width: 100%">
 <tr>
  <th>이름</th>
  <th>이메일</th>
  <th>닉네임</th>
  <th>핸드폰</th>
  <th>가입일자</th>
 </tr>
<c:forEach var="row" items="${list}">
 <tr>
  <td>${row.user_name}</td>
  <td><a href="${path}/member/view.do?user_email=${row.user_email}">
  ${row.user_email}</a></td>
  <td>${row.user_sname}</td>
  <td>${row.user_phone}</td>
  <td><fmt:formatDate value="${row.join_date}" 
  pattern="yyyy-MM-dd HH:mm:ss"/> </td>
 </tr>
</c:forEach> 
</table>
</body>
</html>
