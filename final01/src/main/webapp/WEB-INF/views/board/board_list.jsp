<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<meta charset="UTF-8">
<title>게시판</title>
<%@ include file="../include/include_header.jsp" %>

<style>
body {
	padding-top: 70px;
	padding-bottom: 30px;
}
</style>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<script>
	$(function() {
		$("#btnWrite").click(function() {
			location.href = "${path}/board/board_write.do";
		});
	});
	function list(page) {
		var search_option = "";
		var keyword = "";
		var link = document.location.href;
		if (link.includes('?')) {
			var param = link.split("?");
			// param.includes('&')
			var params = param[1].split("&");
			console.log(params)
			search_option = params[0].split("=")[1];
			keyword = params[1].split("=")[1];
		}
		location.href = "${path}/board/board_list.do?search_option=" + search_option+"&keyword=" + keyword+"&curPage=" + page;
	}
</script>

</head>
<body>
<%@ include file="../menu.jsp" %>


	<!-- 리스트 -->
	<article>
		<div class="container">
			<div class="table-responsive">
				<!-- 검색폼 -->
				<div align="center">
					<form name="form1" method="get" action="${path}/board/board_list.do">
						<select class="form-select" name="search_option" style="width: 10%; flaot:left;display: inline-block;margin: 0 auto;">
							<option value="member_id" <c:if test="${map.search_option == 'member_id'}">selected</c:if>>이름</option>
							<option value="title" <c:if test="${map.search_option == 'title'}">selected</c:if>>제목</option>
							<option value="content" <c:if test="${map.search_option == 'content'}">selected</c:if>>내용</option>
							<option value="all" <c:if test="${map.search_option == 'all'}">selected</c:if>>이름+내용+제목</option>
						</select>
						<input name="keyword" value="${map.keyword}" class="form-control" style="width: 20%;display: inline-block;">
						<input type="submit" value="조회" class="btn btn-secondary">
					</form>
				</div>

				<div style="float:right;">
					<c:if test="${sessionScope.user_name != null}">
						<button type="button" id="btnWrite" class="btn btn-primary">글쓰기</button>
					</c:if>
				</div>
				<table class="table table-striped table-sm">
					<colgroup>
						<col style="width: 5%;" />
						<col style="width: auto;" />
						<col style="width: 15%;" />
						<col style="width: 10%;" />
						<col style="width: 10%;" />
					</colgroup>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>작성일자</th>
						<th>조회수</th>
					</tr>
					<!-- 리스트2 -->
					<c:choose>
						<c:when test="${empty list_view}">
							<tr><td colspan="5" align="center">데이터가 없습니다</td></tr>
						</c:when>
						<c:when test="${!empty list_view }">
							<c:forEach var="row" items="${list_view}">
								 <tr>
								  <td>${row.id}</td>
								  <td>
									  <a href="${path}/board/board_view.do/${row.id}">${row.title}</a>
									  <span style="color:red;">(${row.comment_cnt})</span>
								  </td>
								  <td>${row.member_id}</td>
								  <td><fmt:formatDate value="${row.reg_date}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate> </td>
								  <td>${row.view_cnt}</td>
								 </tr>
							</c:forEach> 
						</c:when>
					</c:choose>
					<tr>
						<td colspan="6" align="center"><c:if
								test="${map.pager.curBlock > 1}">
								<a href="#" onclick="list('1')">[처음]</a>
							</c:if> <c:if test="${map.pager.curBlock > 1}">
								<a href="#" onclick="list('${map.pager.prevPage}')">[이전]</a>
							</c:if> <c:forEach var="num" begin="${map.pager.blockBegin}"
								end="${map.pager.blockEnd}">
								<c:choose>
									<c:when test="${num == map.pager.curPage}">
										<!-- 현재 페이지인 경우 하이퍼링크 제거 -->
										<span style="color: red;">${num}</span>
									</c:when>
									<c:otherwise>
										<a href="#" onclick="list('${num}')">${num}</a>
									</c:otherwise>
								</c:choose>
							</c:forEach> <c:if test="${map.pager.curBlock < map.pager.totBlock}">
								<a href="#" onclick="list('${map.pager.nextPage}')">[다음]</a>
							</c:if> <c:if test="${map.pager.curPage < map.pager.totPage}">
								<a href="#" onclick="list('${map.pager.totPage}')">[끝]</a>
							</c:if></td>
					</tr>
				</table>
			</div>
		</div>
	</article>
</body>
</html>