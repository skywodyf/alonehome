<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>인테리어</title>
<%@ include file="../header.jsp"%>


<style>
body {
	padding-top: 70px;
	padding-bottom: 30px;
}
</style>
<script>
	$(function() {
		$("#btnWrite").click(function() {
			location.href = "${path}/interior/inte_write.do";
		});
	});
	function list(page) {
		location.href = "${path}/interior/inte_list.do?curPage=" + page;
	}
</script>

</head>
<body>
	<%@ include file="../menu.jsp"%>
	<!-- 검색폼 -->
	<div align="center">
		<form name="form1" method="post"
			action="${path}/interior/inte_list.do">
			<select name="search_option">
				<option value="intwriter"
					<c:if test="${map.search_option == 'intwriter'}">selected</c:if>>이름</option>
				<option value="inttitle"
					<c:if test="${map.search_option == 'inttitle'}">selected</c:if>>제목</option>
				<option value="intcontent"
					<c:if test="${map.search_option == 'intcontent'}">selected</c:if>>내용</option>
				<option value="all"
					<c:if test="${map.search_option == 'all'}">selected</c:if>>내용+제목</option>
			</select> <input name="keyword" value="${map.keyword}"> <input
				type="submit" value="조회">
		</form>
		<div>
			<c:if test="${sessionScope.user_name != null}">
				<button type="button" id="btnWrite">글쓰기</button>
			</c:if>
		</div>
	</div>
	<!-- 리스트 -->
	<article>
		<div class="container">
			<div class="table-responsive">
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
						<c:forEach var="row" items="${map.list}">
							<c:choose>
								<c:when test="${row.show == 'y'}">
									<tr>
										<td>${row.intbno}</td>
										<td><a
											href="${path}/interior/inte_view.do?intbno=${row.intbno}">${row.inttitle}</a>
											<c:if test="${row.cnt > 0}">
												<span style="color: red;">(${row.cnt})</span>
											</c:if></td>
										<td>${row.intwriter}</td>
										<td><fmt:formatDate value="${row.intregdate}"
												pattern="yyyy-MM-dd HH:mm:ss" /></td>
										<td>${row.intviewcnt}</td>
									</tr>
								</c:when>
							</c:choose>
						</c:forEach>
						<!-- 페이지 네비게이션 출력 -->
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