<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>댓글창</title>
<%@ include file="../header.jsp" %>
</head>
<body>
<%pageContext.setAttribute("newLineChar", "\n"); %>
<table style="width:700px">
<c:forEach var="row" items="${list}">
	<c:set var="str" value="${fn:replace(row.intreplytext, '<' , '&lt;') }"></c:set>
	<c:set var="str" value="${fn:replace(str, '>', '&gt;') }"></c:set>
	<c:set var="str" value="${fn:replace(str,'  ','&nbsp;&nbsp;') }"></c:set>
	<c:set var="str" value="${fn:replace(str,newLineChar,'<br>') }"></c:set>
	
	<tr>
		<td>
			${row.user_intwriter}
			(<fmt:formatDate value="${row.intregdate}" pattern="yyy-MM-dd a HH:mm:ss"/>)<br>
			${str}
		</td>
	</tr>
</c:forEach>
</table>
</body>
</html>