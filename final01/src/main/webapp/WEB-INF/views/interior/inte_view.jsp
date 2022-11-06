<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>인테리어 상세보기</title>
<%@ include file="../header.jsp"%>
<script src="${path}/include/js/common.js"></script>
<!-- ckeditor의 라이브러리 -->
<script src="${path}/ckeditor/ckeditor.js"></script>
<style type="text/css">
.like_btn {
	top: 300px;
	left: 95%;
	width: 50px;
	height: 50px;
	border-radius: 80%;
	background-color: #ffffff;
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
	background-color: #ffffff;
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
	background-color: #ffffff;
	border: rgba(255, 111, 97) solid;
	position: fixed;
	z-index: 2;
}
</style>
<script type="text/javascript">
$(function() {
	listReply();
	//댓글작성
	$("#btn_Reply").click(function() {
		var intreplytext = $("#intreplytext").val(); //댓글 내용
		var intbno = "${dto.intbno}"; //게시물 번호
		var param = {
				"intreplytext" : intreplytext,
				"intbno" : intbno
		};
		$.ajax({
			type : "post",
			url : "${path}/reply/insert.do",
			data : param,
			success : function() {
				alert("댓글이 등록되었습니다.");
				listReply();
			}
		});
	});
	//타임스탬프값(숫자형)을 문자열 형식으로 변환
	function changeDate(date) {
		date = new Date(parseInt(date));
		year = date.getFullYear();
		month = date.getMonth();
		day = date.getDate();
		hour = date.getHours();
		minute = date.getMinutes();
		second = date.getSeconds();
		strDate = year + "-" + month + "-" + day + " " + hour + ":" + minute
				+ ":" + second;
		return strDate;
	}
	//댓글 목록 출력
	function listReply() {
		$.ajax({
			type : "get",
			contentType : "application/json",
			url : "${path}/reply/list_json.do?intbno=${dto.intbno}",
			success : function(result) {
				//view를 만들지 않는 대신에 자바스크립트로 table등을 만들어야 한다.
				console.log(result);
				var output = "<table>";
				for ( var i in result) {
					var repl = result[i].intreplytext;
					// /정규식/(규칙) => 정규표현식
					// 규칙 g: global 전역검색, i: 대소문자 무시
					// ex) /java/gi => JAVA 또는 java를 모두 찾음
					repl = repl.replace(/  /gi, "&nbsp;&nbsp;");//공백처리
					repl = repl.replace(/</gi, "&lt;"); //태그문자 처리
					repl = repl.replace(/>/gi, "&gt;");
					repl = repl.replace(/\n/gi, "<br>"); //줄바꿈 처리

					output += "<tr><td>" + result[i].intreplyer;
					date = changeDate(result[i].intregdate);
					output += "(" + date + ")";
					output += "<br>" + repl + "</td></tr>";
				}
				output += "</table>";
				$("#listReply").html(output);
			}
		});
	}
});


//탑으로 가기
function top_btn() {
	var offset = $("#content_top").offset();
	$('html, body').animate({
		scrollTop : offset.top
	}, 400);
}
//댓글로 가기
function reply_btn() {
	var offset = $("#inte_reply").offset();
	$('html, body').animate({
		scrollTop : offset.top
	}, 400);
}

</script>
</head>
<body>
	<%@ include file="../menu.jsp"%>
	<div id="content_top"></div>
	<div align="center">
		<h2>인테리어 보기</h2>
		<table style="align-content: center; border: 1px solid;">
			<tr>
				<td>
					<div align="center">
						제목: ${dto.inttitle}<br> 
						작성자 : ${dto.intwriter} | 조회수 : ${dto.intviewcnt}
					</div>
				</td>
			</tr>
			</table>
			<br>
			<table id="content_mid"
				style="align-content: center; border: 1px solid;">
				<tr>
					<th align="center">${row.picture_url}</th>
				</tr>
				<tr>
					<td align="center">${dto.intcontent}</td>
				</tr>
			</table>
			<br>
    		<hr>
    		<br>
			<div>
			<c:if test="${sessionScope.user_name == dto.intwriter}">
					<a href="${path}/interior/delete.do"><button type="button" id="btn_Delete">삭제</button></a>
			</c:if>
				<a href="${path}/interior/inte_list.do"><button type="button" id="btn_List">목록</button></a>
			</div>
    		<br>
    		<hr>
    		<br>
    		<!-- 댓글부분 -->
			<div id="inte_reply" style="width: 700px; text-align: center;">
				<c:if test="${sessionScope.user_name != null }">
					<textarea rows="5" cols="80" id="intreplytext"
						placeholder="댓글을 작성하세요"></textarea>
					<br>
					<button type="button" id="btn_Reply">댓글쓰기</button>
				</c:if>
			</div>
			<!-- 댓글목록 -->
			<div id="listReply"></div>
		
		<!-- 사이드 컨텐츠 -->
			<div id="side_content">
				<input class="like_btn" type="button" value="♥" onclick="like_btn()">
				<input class="reply_btn" type="button" value="댓글"
					onclick="reply_btn()"> <input class="top_btn"
					type="button" value="Top" onclick="top_btn()">
			</div>
	</div>
</body>
</html>