<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script src="/controller/resources/js/jquery.form.min.js"></script>
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
											href="${path}/front?key=auction&methodName=selectAuction&aucCategory=2">Zero-Base
											Auction</a> <a class="dropdown-item"
											href="${path}/front?key=auction&methodName=selectAuction&aucCategory=3">Charity
											Auction</a>
									</div></li>

								<li class="nav-item dropdown"><a
									class="nav-link dropdown-toggle" href="#" id="navbarDropdown_1"
									role="button" data-toggle="dropdown" aria-haspopup="true"
									aria-expanded="false"> Consignment </a>
									<div class="dropdown-menu" aria-labelledby="navbarDropdown_1">
										<a class="dropdown-item" href="#">Application</a> <a
											class="dropdown-item" href="#">Zero-Base Application</a> <a
											class="dropdown-item" href="#">My Consignment</a>
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
											Board</a> <a class="dropdown-item" href="#">1:1 Inquiry</a> <a
											class="dropdown-item" href="#">FAQ</a>
									</div></li>

								<li class="nav-item dropdown"><a
									class="nav-link dropdown-toggle" href="#" id="navbarDropdown_1"
									role="button" data-toggle="dropdown" aria-haspopup="true"
									aria-expanded="false"> About </a>
									<div class="dropdown-menu" aria-labelledby="navbarDropdown_1">
										<a class="dropdown-item" href="#">Introduce</a> <a
											class="dropdown-item" href="#">Donation Activity</a> <a
											class="dropdown-item" href="#">Article</a>
									</div></li>

								<li class="nav-item dropdown"><a
									class="nav-link dropdown-toggle" href="#" id="navbarDropdown_1"
									role="button" data-toggle="dropdown" aria-haspopup="true"
									aria-expanded="false"> My Page </a>
									<div class="dropdown-menu" aria-labelledby="navbarDropdown_1">
										<a class="dropdown-item" href="#">Liked Arts</a> <a
											class="dropdown-item" href="${path}/member/memberInform.jsp">My
											Information</a> <a class="dropdown-item" href="#">Withdrawal</a>
										<a class="dropdown-item" href="#">My Bidding</a>
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

	<section class="cat_product_area section_padding">
		<div class="container" align="center" >
			<div class="row" align="center">
				<h1>Error!</h1>
			</div>
			<div class="row">
				<h1>${errorMsg}</h1>
			</div>
			<br />
			<c:choose>
				<c:when test="${empty loginUser}">
					<div class="col-lg-6  col-lg-offset-3">
						<div class="btn-group btn-group-justified">
							<a href="${path}/member/login.jsp"
								class="genric-btn success-border radius">Login</a>
							<a href="${path}/index.jsp" class="genric-btn success-border radius">Return Website</a>
							<a href="javascript:history.back()" class="genric-btn success-border radius">Back</a>
						</div>

					</div>
				</c:when>
				<c:otherwise>
					<div class="col-lg-6  col-lg-offset-3">
						<div class="btn-group btn-group-justified">
							<a href="javascript:history.back()" class="btn btn-primary">Back</a>
							<a href="${pageContext.request.contextPath}"
								class="btn btn-success">Return Website</a> <a
								href="javascript:history.back()" class="btn btn-success">뒤로가기</a>
						</div>

					</div>
				</c:otherwise>
			</c:choose>
		</div>
	</section>
</body>

