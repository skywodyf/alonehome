 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="../header.jsp" %>
<script src="${path}/include/js/common.js"></script>
<!-- ckeditor의 라이브러리 -->
<script src="${path}/ckeditor/ckeditor.js"></script>
<style>
.fileDrop {
	width: 600px;
	height: 100px;
	border: 1px dotted gray;
	background-color: gray;
}
</style>

</head>
<body>
<div align="center">
<%@ include file="../menu.jsp" %>
<h2>글쓰기</h2>
<form id="form1" name="form1" method="post" action="${path}/interior/insert.do">
	<div>제목 <input name="inttitle" id="inttitle" size="80"
					placeholder="제목을 입력하세요">
	</div>

	<div style="width:800px;">
		내용 <textarea id="intcontent" name="intcontent"
rows="3" cols="80" placeholder="내용을 입력하세요"></textarea>
   <script>
   // ckeditor 적용
   CKEDITOR.replace("intcontent",{
	  filebrowserUploadUrl: "${path}/imageUpload.do"
   });// ImageUploadController.java 에서 처리
   </script>
	</div>
	<div style="width:700px; text-align:center;">
		<input type="submit" value="작성">
	</div>
</form>
</div>
</body>
</html>


		