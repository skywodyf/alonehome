<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../include/include_header.jsp" %>
</head>
<body>
	<!-- Top bar Start -->
	<div class="top-bar">
		<div class="container-fluid">
			<div class="row">
				<div class="col-sm-6">
					<i class="fa fa-envelope"></i> admin1234@email.com
				</div>
				<div class="col-sm-6">
					<i class="fa fa-phone-alt"></i> +012-345-6789
				</div>
			</div>
		</div>
	</div>
	<!-- Top bar End -->

	<!-- Nav Bar Start -->
	<div class="nav">
		<div class="container-fluid">
			<nav class="navbar navbar-expand-md bg-dark navbar-dark">


				<div class="collapse navbar-collapse justify-content-between"
					id="navbarCollapse">
					<div class="navbar-nav mr-auto">
						<a href="${path}/" class="nav-item nav-link active">Home</a> 
						<a href="${path}/board/board_list.do" class="nav-item nav-link">Board</a>
						<a href="${path}/interior/inte_list.do" class="nav-item nav-link">Interior</a>
					</div>
					<div class="navbar-nav ml-auto">
						<div class="navbar-nav mr-auto" style="text-align: right;">


							<c:choose>
	   <c:when test="${sessionScope.admin_user_email == null }">
	     <!-- 로그인하지 않은 상태 -->
		<a href="${path}/member/login.do" class="nav-item nav-link">Login</a> 	    
		<a href="${path}/member/write.do" class="nav-item nav-link">Join</a>  
	     <a href="${path}/admin/login.do" class="nav-item nav-link">Admin Login</a> 
	   </c:when>
	   <c:otherwise>
	     <!-- 로그인한 상태 -->
	     <a href="#" class="nav-item nav-link"> 관리자</a>
	     <a href="${path}/member/list.do" class="nav-item nav-link">User Account</a> 
	     <a href="${path}/member/logout.do" class="nav-item nav-link">Logout</a> 
	   </c:otherwise>
	 </c:choose>

						</div>
					</div>
				</div>
			</nav>
		</div>
	</div>
	<!-- Nav Bar End -->

	<!-- Bottom Bar Start -->
	<div class="bottom-bar">
		<div class="container-fluid">
			<div class="row align-items-center">
				<div class="col-md-3">
					<div class="logo">
						<a href="${path}/"> <img src="${path}/img/alone.png" width="150" alt="Logo">
						</a>
					</div>
				</div>
				<div class="col-md-6">
					<div class="logginCheckMain">
		
					</div>
				</div>
				<div class="col-md-3">
					<div class="user">
						<a href="wishlist.html" class="btn wishlist"> <i
							class="fa fa-heart"></i> <span>(0)</span>
						</a> <a href="cart.html" class="btn cart"> <i
							class="fa fa-shopping-cart"></i> <span>(0)</span>
						</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Bottom Bar End -->

<h2 style= "text-align: center">관리자 모드 입니다</h2>

</body>
</html>