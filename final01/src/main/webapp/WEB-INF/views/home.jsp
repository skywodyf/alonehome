<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- 세션 사용 옵션 -->
<%@ page session="true"%>
<!DOCTYPE html>
<head>
<%@ include file="header.jsp"%>
<script>
	$(document).ready(function() {
		$(".header-slider").slick({
			autoplay : true,
			dots : true,
			infinite : true,
			slidesToShow : 1,
			slidesToScroll : 1
		});
	});

	$(document).ready(function() {
		$('.sidebar-slider').slick({
			autoplay : true,
			dots : false,
			infinite : true,
			slidesToShow : 1,
			slidesToScroll : 1
		});
	});

	$(document).ready(function() {
		// Dropdown on mouse hover
		$(document).ready(function() {
			function toggleNavbarMethod() {
				if ($(window).width() > 768) {
					$('.navbar .dropdown').on('mouseover', function() {
						$('.dropdown-toggle', this).trigger('click');
					}).on('mouseout', function() {
						$('.dropdown-toggle', this).trigger('click').blur();
					});
				} else {
					$('.navbar .dropdown').off('mouseover').off('mouseout');
				}
			}
			toggleNavbarMethod();
			$(window).resize(toggleNavbarMethod);
		});
	});

	$(document).ready(function() {
		// Back to top button
		$(window).scroll(function() {
			if ($(this).scrollTop() > 100) {
				$('.back-to-top').fadeIn('slow');
			} else {
				$('.back-to-top').fadeOut('slow');
			}
		});
		$('.back-to-top').click(function() {
			$('html, body').animate({
				scrollTop : 0
			}, 1500, 'easeInOutExpo');
			return false;
		});
	});
</script>


</head>
<body>
	<%@ include file="menu.jsp"%>
	<!-- Main Slider Start -->
	<div class="header">
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-3">
					<nav class="navbar bg-light">
						<ul class="navbar-nav">
							<li class="nav-item"><a class="nav-link" href="${path}/"><i
									class="fa fa-home"></i>Home</a></li>
							<li class="nav-item"><a class="nav-link" href="#"><i
									class="fa fa-bars"></i>Board</a></li>
							<li class="nav-item"><a class="nav-link"
								href="${path}/interior/inte_list.do"><i
									class="fa fa-archive"></i>Interior</a></li>
						</ul>
					</nav>
				</div>
				<div class="col-md-6">
					<div class="header-slider normal-slider">
						<div class="header-slider-item">
							<img src="${path}/img/alone-1.jpg" width="700"  height="400"  alt="Slider Image" />
							
						</div>
						<div class="header-slider-item">
							<img src="${path}/img/alone-2.jpg" width="700" height="400" alt="Slider Image" />
							
						</div>
						<div class="header-slider-item">
							<img src="${path}/img/alone-3.jpg" width="700" height="400" alt="Slider Image" />
							
						</div>
					</div>
				</div>
				<div class="col-md-3">
					<div class="header-img">
						<div class="img-item">
							<img src="${path}/img/alone-3.jpg" /> 
						</div>
						<div class="img-item">
							<img src="${path}/img/alone-2.jpg" /> 
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Main Slider End -->

	<!-- Category Start-->
	<div class="category">
		<div class="container-fluid">
			<div class="section-header"
				style="margin-bottom: 30px; padding: 20px 30px 15px 30px; color: #FF6F61; background: #ffffff">
				<h1>best interior</h1>
			</div>
			<div class="row">
				<div class="col-md-3">
					<div class="category-item ch-400">
						<img src="${path}/img/category-3.jpg" /> <a class="category-name"
							href="">
							<p>best interior들어갈 자리</p>
						</a>
					</div>
				</div>
				<div class="col-md-3">
					<div class="category-item ch-250">
						<img src="${path}/img/category-4.jpg" /> <a class="category-name"
							href="">
							<p>best interior들어갈 자리</p>
						</a>
					</div>
					<div class="category-item ch-150">
						<img src="${path}/img/category-5.jpg" /> <a class="category-name"
							href="">
							<p>best interior들어갈 자리</p>
						</a>
					</div>
				</div>
				<div class="col-md-3">
					<div class="category-item ch-150">
						<img src="${path}/img/category-6.jpg" /> <a class="category-name"
							href="">
							<p>best interior들어갈 자리</p>
						</a>
					</div>
					<div class="category-item ch-250">
						<img src="${path}/img/category-7.jpg" /> <a class="category-name"
							href="">
							<p>best interior들어갈 자리</p>
						</a>
					</div>
				</div>
				<div class="col-md-3">
					<div class="category-item ch-400">
						<img src="${path}/img/category-8.jpg" /> <a class="category-name"
							href="">
							<p>best interior들어갈 자리</p>
						</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Category End-->






	<!-- best board Start -->
	<div class="recent-product product">
		<div class="container-fluid">
			<div class="section-header">
				<h1>best board</h1>
				<table border="1" width="800px" align="top">
					<center>
						<tr>

							<th>조회수 순위</th>							
							<th>제목</th>
							<th>작성자</th>							
							<th>날짜</th> 
							<th>조회수</th> 							

							<!-- forEach var = "개별데이터" items = "집합데이터" -->
							<c:forEach var="row" items="${map.list}">
								<!-- 컨트롤러에서 map안에 list를 넣었기 때문에 이렇게 받는다. -->
								<tr>
									<!-- 게시글 순위 -->
									<td>${row.rk}</td>
									<!-- 글번호 -->
									<td>${row.member_bno}</td>    
									<!-- 클릭하면 컨트롤러의 view.do로 이동하고, 게시물번호, 페이지 번호, 검색옵션, 키워드를 같이 넘긴다 -->
									<td><a
										href="best_board_view.do?member_bno=${row.member_bno}">${row.title}</a>
										<c:if test="${row.rcnt > 0}">
											<span style="color: red;">( ${row.rcnt} )</span>
										</c:if></td>

									<td>${row.user_id}</td>
									<!-- 작성자의 이름 -->
									
									<td>${row.reg_date}</td>
									<!-- 날짜의 출력형식을 변경함 -->
									<td>${row.viewcnt}</td>
									<!-- 조회수 -->
									



								</tr>
							</c:forEach>
				</table>

			</div>
		</div>

	</div>
	
	<!-- best board End -->

	<%@ include file="footer.jsp"%>
</html>
