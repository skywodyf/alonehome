<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
   <script src="https://cdn.tailwindcss.com"></script>
   <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
   <style type="text/css">
.like_btn {
   top: 300px;
   left: 95%;
   width: 50px;
   height: 50px;
   border-radius: 80%;
   background-color: #FFFFFF;
   border: rgba(255, 111, 97) solid;
   position: fixed;
   z-index: 2;
   color: red;
}
.top_btn {
   top: 380px;
   left: 95%;
   width: 50px;
   height: 50px;
   border-radius: 80%;
   background-color: #FFFFFF;
   border: rgba(255, 111, 97) solid;
   position: fixed;
   z-index: 2;
}
.reply_btn {
   top: 460px;
   left: 95%;
   width: 50px;
   height: 50px;
   border-radius: 80%;
   background-color: #FFFFFF;
   border: rgba(255, 111, 97) solid;
   position: fixed;
   z-index: 2;
}
#e_reply {
   width: 100px;
   height: 100px;
   text-align: center;
   height: 100px;
}
.fileDrop {
   width: 600px;
   height: 100px;
   border: 1px dotted gray;
   background-color: gray;
}
</style>
   <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<script type="text/javascript">
   //탑으로 가기
   function top_btn() {
      var offset = $("#content_top").offset();
      $('html, body').animate({
         scrollTop : offset.top
      }, 400);
   }
</script>
<meta charset="UTF-8">
<title>상세 게시판 페이지</title>
<%@ include file="../include/include_header.jsp" %>
<script src="${path}/include/js/common.js"></script>
</head>
<body>
<%@ include file="../menu.jsp" %>
<div class="card w-9/12" style="margin:0 auto;">
   <div class="card-header">
      <h5 class="card-title font-bold">
         제목 : ${dto.title}
      </h5>
   </div>
   <div class="card-header" style="float:right">
      <p class="font-bold inline">등록자</p> <p class="inline mr-3">${dto.member_id}</p>
      <p class="font-bold inline">등록일</p> <p class="inline mr-3"><fmt:formatDate value="${dto.reg_date}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate></p>
      <p class="font-bold inline">조회수</p> <p class="inline mr-3">${dto.view_cnt}</p>
   </div>
   <div class="card-body">
      <p class="card-text">${dto.content}</p>
   </div>
</div>
<div class="w-9/12" style="margin:0 auto;">
   <button type="button" class="btn btn-primary w-36 float-left" id="btnList" onclick="location.href = '${path}/board/board_list.do'">목록</button>
   <!-- 본인만 수정,삭제 버튼 표시 -->
   <c:if test="${sessionScope.user_email == dto.member_id}">
      <button type="button" class="btn btn-danger w-36 float-right" id="btnDelete" onclick="location.href = '${path}/board/delete.do/${dto.id}'">삭제</button>
      <button type="button" class="btn btn-primary w-36 float-right" id="btnUpdate" onclick="location.href = '${path}/board/board_update.do/${dto.id}'">수정</button>
   </c:if>
</div>
<br><br><br><br>
<div class="w-9/12" style="margin:0 auto;">
   <h5 class="font-bold">Comments</h5>
   <!-- 댓글 작성 -->
   <c:if test="${sessionScope.user_name != null }">
      <div class="mb-3">
         <form id="form2" name="form2" method="post" action="${path}/comment/insert.do?board_id=${dto.id}">
            <div class="form-floating">
               <textarea class="form-control" name="content" placeholder="댓글을 작성하세요" id="floatingTextarea2" style="height: 100px"></textarea>
               <label for="floatingTextarea2">Comments</label>
            </div>
            <button type="submit" class="btn btn-primary float-right">댓글쓰기</button>
         </form>
      </div>
      <br><br>
   </c:if>
   <!-- 댓글 목록 -->
   <div class="table-responsive mt-1">
      <table class="table table-striped table-sm">
         <colgroup>
            <col style="width: 15%;" />
            <col style="width: 50%;" />
         </colgroup>
         <!-- 리스트2 -->
         <c:choose>
            <c:when test="${empty comment_list}">
               <tr><td colspan="5" align="center">댓글이 없습니다</td></tr>
            </c:when>
            <c:when test="${!empty comment_list }">
               <c:forEach var="row" items="${comment_list}">
                  <tr>
                     <td>
                        <p class="font-bold">${row.member_id}</p>
                        <p>(<fmt:formatDate value="${row.reg_date}" pattern="yyyy-MM-dd"></fmt:formatDate>)</p>
                     </td>
                     <td>
                        ${row.content}
                        <c:if test="${sessionScope.user_email == row.member_id}">
<%--                        <td><button type="button" id="btnCommmentUpdate" onclick="location.href = '${path}/comment/update.do/${dto.id}'">수정</button></td>--%>
                           <td><button type="button" class="btn btn-danger float-right" id="btnCommentDelete" onclick="location.href = '${path}/comment/delete.do/${row.id}?board_id=${dto.id}'">삭제</button></td>
                        </c:if>
                     </td>
                  </tr>
               </c:forEach>
            </c:when>
         </c:choose>
      </table>
   </div>
</div>
<div id="side_content">
   <input class="like_btn" type="button" value="♥" onclick="like_btn()">
   <input class="reply_btn" type="button" value="댓글"
      onclick="reply_btn()"> <input class="top_btn" type="button"
      value="Top" onclick="top_btn()">
</div>
</body>
</html>