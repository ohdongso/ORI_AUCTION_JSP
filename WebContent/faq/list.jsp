<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!doctype html>
<html lang="zxx">
<style>
#mainLogo {
	width: 250px;
	height: 45px
}

@import
	url(//db.onlinewebfonts.com/c/537c29c4b78689a51f1c48cd802a503f?family=ITC+Grouch)
	;

@import
	url(//db.onlinewebfonts.com/c/789f9065baf48309d73fd0ff02fe4aec?family=Big+Caslon+Black)
	;

@import
	url('https://fonts.googleapis.com/css2?family=Archivo:wght@100&display=swap')
	;

.dropdown-item {
	font-family: ITC Grouch;
}

#banana {
	font-family: ITC Grouch;
}

h2, h3, h4, h5, h6, p {
	font-family: adobe-caslon-pro, serif;
	font-style: normal;
	font-weight: 700
}

#mainSample1 {
	width: 580px;
	height: 400px
}

#artTypes {
	font-family: 'Archivo', sans-serif;
	color: #2E64FE;
}

#title {
	font-family: ITC Grouch;
}

.table {
	text-align: center;
}

#oti {
	font-family: ITC Grouch;
	font-size: 100px
}

#selectaa {
	font-family: ITC Grouch;
	background-color: yellow;
	border: 0;
	outline: 0;
	padding: 10px 30px;
	font-size: 15px;
	color: black;
}

#sdfs {
	font-family: adobe-caslon-pro, serif;
	font-weight: bold;
}
</style>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>OriAuction</title>
<link rel="icon" href="<%=request.getContextPath()%>/img/favicon.png">
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/bootstrap.min.css">
<!-- animate CSS -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/animate.css">
<!-- owl carousel CSS -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/owl.carousel.min.css">
<!-- nice select CSS -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/nice-select.css">
<!-- font awesome CSS -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/all.css">
<!-- flaticon CSS -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/flaticon.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/themify-icons.css">
<!-- font awesome CSS -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/magnific-popup.css">
<!-- swiper CSS -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/slick.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/price_rangs.css">
<!-- style CSS -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style.css">
</head>

<body>
	<!--::header part start::-->
	<header class="main_menu home_menu">
		<div class="container">
			<div class="row align-items-center">
				<div class="col-lg-12">
					<nav class="navbar navbar-expand-lg navbar-light">
						<a class="navbar-brand" href="${path}/index.jsp"> <img
							src="${path}/img/mainLogo.png" alt="logo" id="mainLogo">
						</a>
						<button class="navbar-toggler" type="button"
							data-toggle="collapse" data-target="#navbarSupportedContent"
							aria-controls="navbarSupportedContent" aria-expanded="false"
							aria-label="Toggle navigation">
							<span class="menu_icon"><i class="fas fa-bars"></i></span>
						</button>

						<div class="collapse navbar-collapse main-menu-item"
							id="navbarSupportedContent">
							<ul class="navbar-nav">
								<li class="nav-item dropdown"><a
									class="nav-link dropdown-toggle" href="#" id="navbarDropdown_1"
									role="button" data-toggle="dropdown" aria-haspopup="true"
									aria-expanded="false"> Online-Auction </a>
									<div class="dropdown-menu" aria-labelledby="navbarDropdown_1">
										<a class="dropdown-item"
											href="${path}/front?key=auction&methodName=selectAll">All
											Auction</a> <a class="dropdown-item"
											href="${path}/front?key=auction&methodName=selectAuction&aucCategory=1">Normal
											Auction</a> <a class="dropdown-item"
											href="${path}/front?key=auction&methodName=selectAuction&aucCategory=2">Charity
											Auction</a> <a class="dropdown-item"
											href="${path}/front?key=auction&methodName=selectAuction&aucCategory=3">Zero-Base
											Auction</a>
										<c:if test="${sessionScope.loginState==0}">
											<a class="dropdown-item"
												href="${path}/front?key=auction&methodName=searchByState&state=1">Manage
												Auctions</a>
										</c:if>
									</div></li>

								<li class="nav-item dropdown"><a
									class="nav-link dropdown-toggle" href="#" id="navbarDropdown_1"
									role="button" data-toggle="dropdown" aria-haspopup="true"
									aria-expanded="false"> Consignment </a>
									<div class="dropdown-menu" aria-labelledby="navbarDropdown_1">
										<a class="dropdown-item" href="${path}/art/artInsert.jsp">Art
											Application</a>
										<c:if test="${sessionScope.loginState==2}">
											<a class="dropdown-item" href="${path}/art/artInsertZB.jsp">ZB
												Application</a>
										</c:if>
										<c:if
											test="${sessionScope.loginState==1||sessionScope.loginState==2}">
											<a class="dropdown-item"
												href="${path}/front?key=cons&methodName=selectById">My
												Consignment</a>
										</c:if>
										<a class="dropdown-item"
											href="${path}/front?key=art&methodName=searchByKeyWord&keyField=id&keyWord=${sessionScope.loginUser}">My
											Arts</a>
										<c:if test="${sessionScope.loginState==0}">
											<a class="dropdown-item"
												href="${path}/front?key=cons&methodName=selectAll">Consignment
												List</a>
										</c:if>

									</div></li>

								<li class="nav-item dropdown"><a
									class="nav-link dropdown-toggle" href="#" id="navbarDropdown_1"
									role="button" data-toggle="dropdown" aria-haspopup="true"
									aria-expanded="false"> Board </a>
									<div class="dropdown-menu" aria-labelledby="navbarDropdown_1">
										<a class="dropdown-item"
											href="${path}/front?key=board&methodName=selectAll">Free
											Board</a> <a class="dropdown-item"
											href="${path}/front?key=review&methodName=selectAll">Review
											Board</a> <a class="dropdown-item"
											href="${path}/front?key=sb&methodName=selectAll">1:1
											Inquiry</a> <a class="dropdown-item"
											href="${path}/front?key=faq&methodName=selectAll">FAQ</a> <a
											class="dropdown-item"
											href="${path}/front?key=artist&methodName=selectAllArtist">Artist
											List</a>
									</div></li>

								<li class="nav-item dropdown"><a
									class="nav-link dropdown-toggle" href="#" id="navbarDropdown_1"
									role="button" data-toggle="dropdown" aria-haspopup="true"
									aria-expanded="false"> About </a>
									<div class="dropdown-menu" aria-labelledby="navbarDropdown_1">
										<a class="dropdown-item" href="${path}/about/introduce.jsp">Introduce</a>
										<a class="dropdown-item" href="${path}/serBoard/donIndex.jsp">Donation
											Activity</a> <a class="dropdown-item"
											href="${path}/front?key=article&methodName=selectAll">Article</a>
									</div></li>

								<li class="nav-item dropdown"><a
									class="nav-link dropdown-toggle" href="#" id="navbarDropdown_1"
									role="button" data-toggle="dropdown" aria-haspopup="true"
									aria-expanded="false"> My Page </a>
									<div class="dropdown-menu" aria-labelledby="navbarDropdown_1">
										<a class="dropdown-item"
											href="${path}/front?key=like&methodName=selectAll">Liked
											Arts</a> <a class="dropdown-item"
											href="${path}/front?key=member&methodName=myInform">My
											Information</a> <a class="dropdown-item"
											href="${path}/artist/registArtist.jsp">Artist Service</a> <a
											class="dropdown-item"
											href="${path}/front?key=bid&methodName=searchBidArtState&userId=${sessionScope.loginUser}">My
											Bidding</a> <a class="dropdown-item"
											href="${path}/front?key=sucBid&methodName=searchByUserId&userId=${sessionScope.loginUser}">My
											Successful Bid</a>
										<c:if test="${sessionScope.loginState==0}">
											<a class="dropdown-item"
												href="${path}/front?key=member&methodName=selectAllMember">Our
												Members</a>
										</c:if>

									</div></li>
							</ul>
						</div>
						<div class="hearer_icon d-flex">
							<c:if test="${sessionScope.loginUser==null}">
                               &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a
									id="search_1" href="${path}/member/login.jsp">login</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                               <a id="search_1"
									href="${path}/member/join.jsp">signin</a>
							</c:if>
							<c:if test="${sessionScope.loginUser!=null}">
                               &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a
									id="search_1" href="${path}/front?key=member&methodName=logout">logout</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                               <a id="search_1" href="#">${loginUser}</a>
							</c:if>
						</div>
					</nav>
				</div>
			</div>
		</div>

	</header>
	<!-- Header part end-->

	<section>
		<div style="position: relative; z-index: 1; margin-bottom: 80px">
			<img src="${path}/faq/img/bg3.jpg" width="100%" alt=""
				class="img-fluid" style="margin-top: 80px" id="mainI">
		</div>
		<div
			style="position: absolute; left: 50%; top: 50%; transform: translate(-50%, -50%); z-index: 2;">
			<p id="oti" style="color: white">FAQ</p>
		</div>
		<h1 id="forma" style="font-family: ITC Grouch; text-align: center;">
		</h1>
	</section>
	<!--================Category Product Area =================-->
	<div class="col-lg-12">
		<div
			class="product_top_bar d-flex justify-content-between align-items-center">
			<form action="${path}/front?key=faq&methodName=searchByKeyfield"
				method="post">
				<div class="single_product_menu d-flex">
					<a href="${path}/front?key=faq&methodName=selectAll" id="selectaa">All</a>&nbsp;&nbsp;
					<a
						href="${path}/front?key=faq&methodName=searchByCategory&category=1"
						id="selectaa">회원정보</a>&nbsp;&nbsp; <a
						href="${path}/front?key=faq&methodName=searchByCategory&category=2"
						id="selectaa">경매</a>&nbsp;&nbsp; <a
						href="${path}/front?key=faq&methodName=searchByCategory&category=3"
						id="selectaa">위탁</a>&nbsp;&nbsp; <a
						href="${path}/front?key=faq&methodName=searchByCategory&category=4"
						id="selectaa">배송</a>&nbsp;&nbsp; <a
						href="${path}/front?key=faq&methodName=searchByCategory&category=5"
						id="selectaa">기부</a>&nbsp;&nbsp; <a
						href="${path}/front?key=faq&methodName=searchByCategory&category=6"
						id="selectaa">기타</a>
				</div>
			</form>
		</div>
	</div>

	<div class="col-lg-12">
		<c:choose>
			<c:when test="${empty requestScope.faqList}">
				<p align="center">
					<b><span id="sdfs">등록된 게시물이 없습니다.</span></b>
				</p>
			</c:when>
			<c:otherwise>
				<c:forEach items="${requestScope.faqList}" var="faq">
					<blockquote class="generic-blockquote">
						<c:if test="${faq.faqCategory==1}">
							<h4>[회원정보] : ${faq.faqTitle}</h4>
						</c:if>
						<c:if test="${faq.faqCategory==2}">
							<h4>[ 경 매 ] : ${faq.faqTitle}</h4>
						</c:if>
						<c:if test="${faq.faqCategory==3}">
							<h4>[ 위 탁 ] : ${faq.faqTitle}</h4>
						</c:if>
						<c:if test="${faq.faqCategory==4}">
							<h4>[ 배 송 ] : ${faq.faqTitle}</h4>
						</c:if>
						<c:if test="${faq.faqCategory==5}">
							<h4>[ 기 부 ] : ${faq.faqTitle}</h4>
						</c:if>
						<c:if test="${faq.faqCategory==6}">
							<h4>[ 기 타 ] : ${faq.faqTitle}</h4>
						</c:if>

						<br> <br> ▶ ${faq.faqContents}
						<c:if test="${sessionScope.loginState==0}">
							<div style="margin-top: 20px" align="right">
								<form action="${path}/front?key=faq&methodName=delete"
									method="post">
									<input type="hidden" name="faqCode" value="${faq.faqCode}">
									<button type="submit"
										style="font-family: ITC Grouch; background-color: black; color: yellow; border: 0; outline: 0; padding: 10px 30px; font-size: 15px;">delete</button>
								</form>
							</div>
						</c:if>
					</blockquote>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</div>
	<div class="col-lg-12">
		<c:if test="${sessionScope.loginState==0}">
			<div align="right">
				<a href="${path}/faq/write.jsp"
					style="font-family: ITC Grouch; background-color: yellow; border: 0; outline: 0; padding: 10px 30px; font-size: 15px; color: balck;">Write</a>
			</div>
		</c:if>
	</div>
	<!--================End Category Product Area =================-->

	<!-- jquery plugins here-->
	<script src="js/jquery-1.12.1.min.js"></script>
	<!-- popper js -->
	<script src="js/popper.min.js"></script>
	<!-- bootstrap js -->
	<script src="js/bootstrap.min.js"></script>
	<!-- easing js -->
	<script src="js/jquery.magnific-popup.js"></script>
	<!-- swiper js -->
	<script src="js/swiper.min.js"></script>
	<!-- swiper js -->
	<script src="js/masonry.pkgd.js"></script>
	<!-- particles js -->
	<script src="js/owl.carousel.min.js"></script>
	<script src="js/jquery.nice-select.min.js"></script>
	<!-- slick js -->
	<script src="js/slick.min.js"></script>
	<script src="js/jquery.counterup.min.js"></script>
	<script src="js/waypoints.min.js"></script>
	<script src="js/contact.js"></script>
	<script src="js/jquery.ajaxchimp.min.js"></script>
	<script src="js/jquery.form.js"></script>
	<script src="js/jquery.validate.min.js"></script>
	<script src="js/mail-script.js"></script>
	<script src="js/stellar.js"></script>
	<script src="js/price_rangs.js"></script>
	<!-- custom js -->
	<script src="js/custom.js"></script>
</body>

</html>