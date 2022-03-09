<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
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

h2, h3, h4, h5, h6 {
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

.widget_title {
	font-family: ITC Grouch;
}

#artTypes {
	font-family: 'Archivo', sans-serif;
}

p {
	font-family: 'Archivo', sans-serif;
}

#button {
	font-family: ITC Grouch;
	background-color: yellow;
	border: 0;
	outline: 0;
	padding: 10px 30px;
	font-size: 15px;
}

#delete {
	font-family: ITC Grouch;
	background-color: black;
	color: yellow;
	border: 0;
	outline: 0;
	padding: 10px 30px;
	font-size: 15px;
}

#rTitle {
	font-family: ITC Grouch;
}
#modify{
font-family: ITC Grouch;
	background-color: yellow;
	border: 0;
	outline: 0;
	padding: 10px 30px;
	font-size: 15px;
}
}
</style>
<head>
<!-- Required meta tags -->
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="icon" href="${path}/img/favicon.png">
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="${path}/css/bootstrap.min.css">
<!-- animate CSS -->
<link rel="stylesheet" href="${path}/css/animate.css">
<!-- owl carousel CSS -->
<link rel="stylesheet" href="${path}/css/owl.carousel.min.css">
<!-- font awesome CSS -->
<link rel="stylesheet" href="${path}/css/all.css">
<!-- flaticon CSS -->
<link rel="stylesheet" href="${path}/css/flaticon.css">
<link rel="stylesheet" href="${path}/css/themify-icons.css">
<!-- font awesome CSS -->
<link rel="stylesheet" href="${path}/css/magnific-popup.css">
<!-- swiper CSS -->
<link rel="stylesheet" href="${path}/css/slick.css">
<!-- style CSS -->
<link rel="stylesheet" href="${path}/css/style.css">
<meta charset="UTF-8">
<title>Ori Auction</title>
<script type="text/javascript" src="${path}/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	$(
			function() {
				$("button[id^=mbtn]").click(function() {
					$('form[id=mtext' + this.id + ']').toggle();
				})

				$("#toList")
						.click(
								function() {
									location.href = "${path}/front?key=review&methodName=selectAll";
								})
				$("#delete")
						.click(
								function() {
									if (confirm("글을 삭제하시겠습니까?")) {
										if ("${review.id}" == "${sessionScope.loginUser}") {
											location.href = "${path}/front?key=review&methodName=delete&reviewCode=${review.reviewCode}&id=${sessionScope.loginUser}";
										} else {
											alert("작성자만 글을 삭제할 수 있습니다.");
										}
									}
								})
				$(document).on("submit", "#update", function() {
					if ("${review.id}" != "${sessionScope.loginUser}") {
						alert("작성자만 글을 수정할 수 있습니다.");
						return false;
					} else {
						return true;
					}
				})
			})
</script>
<script type="text/javascript">
	
</script>
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

	
	<!-- Header part end-->
	<!--================Blog Area =================-->
	<section class="blog_area single-post-area padding_top">
		<div class="container">
			<div>
				<div align="left" class="col">
					<h1>${review.reviewTitle}</h1>
				</div>
				<div align="right" class="col">
					<h5>views :&nbsp;${review.reviewView}</h5>
				</div>
			</div>
			<hr>
			<div class="row">
				<div class="col-lg-4">
					<div class="blog_right_sidebar">
						<aside class="single_sidebar_widget post_category_widget">
							<!-- 						<h3>작품정보</h3> -->
							<%-- 	<h3>작품 이미지파일:${review.art.artImg}</h3> --%>
							<h4 class="widget_title">Art Information</h4>
							<ul class="list cat-list">
								<li>
									<p>Art Name :&nbsp;${review.art.artName}</p>
								</li>
								<li>
									<p>Artist Name :&nbsp;${review.art.artistName}</p>
								</li>
								<li><c:if test="${review.art.artCategory==1}">
										<p>Art Type :&nbsp;Photo</p>
									</c:if> <c:if test="${review.art.artCategory==2}">
										<p>Art Type :&nbsp;Fine Art</p>
									</c:if> <c:if test="${review.art.artCategory==3}">
										<p>Art Type :&nbsp;Craft & Sculpture</p>
									</c:if></li>
								<li><c:if test="${review.art.artSizeVol!=0}">
										<p>Art Size(width*height*vol)</p>
										<p>${review.art.artSizeWidth}cm*
											${review.art.artSizeHeight}cm * ${review.art.artSizeVol}cm</p>
									</c:if> <c:if test="${review.art.artSizeVol==0}">
										<p>Art Size(width*height)</p>
										<p>${review.art.artSizeWidth}cm*
											${review.art.artSizeHeight}cm</p>
									</c:if></li>
								<li>
									<p>
										Estimate Cost :&nbsp;
										<fmt:formatNumber>${review.art.estimateCost}</fmt:formatNumber>
										&nbsp;₩
									</p>
								</li>
								<li>
									<p>Production Year :&nbsp;${review.art.prdYear}</p>
								</li>
								<li>
									<p>Art Details</p>
									<p>${review.art.artDetail}</p>
								</li>
							</ul>
						</aside>
					</div>
				</div>
				<div class="col-lg-8 posts-list">
					<div class="single-post">
						<div class="blog-author"
							style="margin-top: 0px; padding: 20px 15px; margin-bottom: 10px"
							align="left">
							<div class="media">
								<div class="media-body">
									<h4>Wrtier :&nbsp;${review.id}</h4>
									<h4>
										Rate :&nbsp;<img style="border-radius: 0px; height: auto"
											alt=""
											src="${path}/img/rate_icon/rate${review.reviewRate}.png" />
									</h4>
									<h4>Regist Date :&nbsp;${review.reviewDate}</h4>
								</div>
							</div>
						</div>
						<div class="feature-img" align="center"
							style="margin-top: 20px; margin-bottom: 20px; padding: 10px">
							<img class="img-fluid"
								src="${path}/art/artImg/${review.art.artImg}" alt="">
						</div>
						<div align="right">
							<form id="update" action="${path}/review/update.jsp"
								method="post">
								<input type="hidden" name="reviewCode"
									value="${review.reviewCode}" /> <input type="hidden"
									name="reviewTitle" value="${review.reviewTitle}" /> <input
									type="hidden" name="reviewRate" value="${review.reviewRate}" />
								<input type="hidden" name="reviewContents"
									value="${review.reviewContents}" />
								<button type="submit" id="button">Modify</button>
								<button type="button" id="delete">Delete</button>
							</form>
						</div>
					</div>
				</div>
			</div>

			<hr>
			<h3 id="rTitle">Review</h3>
			<div class="blog-author" style="margin-top: 0px; padding: 20px 15px">
				<div class="media align-items-center">
					<div class="media-body">
						<textarea name="reviewContent" class="single-textarea"
							placeholder="Write review here" onfocus="this.placeholder = ''"
							onblur="this.placeholder = 'Write review here'" required=""
							style="height: 300px" readonly="readonly">${review.reviewContents}</textarea>
					</div>
				</div>
			</div>
			<div align="right" style="margin-top: 10px">
				<a href="${path}/front?key=review&methodName=selectAll"
					style="font-family: ITC Grouch; background-color: yellow; border: 0; outline: 0; padding: 10px 30px; font-size: 15px;">Back
					to list</a>
			</div>
			<div class="comment-form">
				<h3 style="font-family: ITC Grouch">Comments(${fn:length(review.reply)})</h3>
				<c:forEach items="${review.reply}" var="reply">
					<div class="blog-author"
						style="margin-top: 10px; padding: 20px 15px">
						<div class="media align-items-center">
							<div class="media-body">
								<h5>${reply.id}</h5>
								<h6>${reply.reviewReplyContents}</h6>
							</div>
							<div align="right">
								<h6>${reply.reviewReplyDate}</h6>
								<c:if test="${sessionScope.loginUser==reply.id}">
									<div>
										<form action="${path}/front?key=review&methodName=deleteReply"
											method="post">
											<input type="hidden" name="reviewCode"
												value="${review.reviewCode}"> <input type="hidden"
												name="id" value="${sessionScope.loginUser}"> <input
												type="hidden" name="reviewReplyCode"
												value="${reply.reviewReplyCode}">
											<button id="mbtn${reply.reviewReplyCode}" type="button"
												style="font-family: ITC Grouch; background-color: yellow; border: 0; outline: 0; padding: 10px 30px; font-size: 10px;">modify</button>
											<button type="submit"
												style="font-family: ITC Grouch; background-color: black; color: yellow; border: 0; outline: 0; padding: 10px 30px; font-size: 10px;">delete</button>
										</form>
									</div>
								</c:if>
							</div>
						</div>
						<c:if test="${sessionScope.loginUser==reply.id}">
							<div>
								<form id="mtextmbtn${reply.reviewReplyCode}" class="mform"
									action="${path}/front?key=review&methodName=updateReply"
									method="post" style="display: none">
									<input type="hidden" name="reviewReplyCode"
										value="${reply.reviewReplyCode}"> <input type="hidden"
										name="reviewCode" value="${review.reviewCode}"> <input
										type="text" name="reviewReplyContents" style="width: 900px">
									<button type="submit" style="font-family: ITC Grouch; background-color: yellow; 
									   border:0; outline:0; padding:10px 30px; font-size: 10px;">OK</button>
								</form>
							</div>
						</c:if>
					</div>
				</c:forEach>

				<form class="form-contact comment_form"
					action="${path}/front?key=review&methodName=insertReply"
					method="post">
					<div class="row">
						<div class="col-12" style="margin-top: 10px">
							<div class="form-group">
								<textarea class="form-control w-100" name="replyContent"
									id="comment" cols="30" rows="9" placeholder="Write Comment"></textarea>
								<input type="hidden" name="id" value="${sessionScope.loginUser}">
								<input type="hidden" name="reviewCode"
									value="${review.reviewCode}" />
							</div>
						</div>
					</div>
					<div class="form-group mt-3" align="right">

						<button type="submit"
							style="font-family: ITC Grouch; background-color: yellow; border: 0; outline: 0; padding: 10px 30px; font-size: 15px;">Reply
							Submit</button>
					</div>
				</form>
			</div>
		</div>
	</section>
	<!--================Blog Area end =================-->

<footer class="footer_part">
		<div class="container">
			<div class="row justify-content-around">
				<div class="col-sm-6 col-lg-2">
					<div class="single_footer_part">
						<h4>Auctions</h4>
						<ul class="list-unstyled">
							<li><a href="">See All Auctions</a></li>
							<li><a href="">Find My ArtWorks</a></li>
							<li><a href="">Zero-Base?</a></li>
							<li><a href="">Charity Auction</a></li>
						</ul>
					</div>
				</div>
				<div class="col-sm-6 col-lg-2">
					<div class="single_footer_part">
						<h4>Main Services</h4>
						<ul class="list-unstyled">
							<li><a href="">Consignment </a></li>
							<li><a href="">Member Service</a></li>
							<li><a href="">Auction Service</a></li>
							<li><a href="">Our Artists</a></li>
						</ul>
					</div>
				</div>
				<div class="col-sm-6 col-lg-2">
					<div class="single_footer_part">
						<h4>Our Future</h4>
						<ul class="list-unstyled">
							<li><a href="">For Society</a></li>
							<li><a href="">Kids Art Service</a></li>
							<li><a href="">Our Donations</a></li>
							<li><a href="">Ori Museum</a></li>
						</ul>
					</div>
				</div>
				<div class="col-sm-6 col-lg-2">
					<div class="single_footer_part">
						<h4>Ori Auction</h4>
						<ul class="list-unstyled">
							<li><a href="">DongHyun</a></li>
							<li><a href="">MinSub</a></li>
							<li><a href="">SungHee</a></li>
							<li><a href="">Soyoung</a></li>
							<li><a href="">KiHyun</a></li>
							<li><a href="">DongSo</a></li>
						</ul>
					</div>
				</div>
				<div class="col-sm-6 col-lg-4">
					<div class="single_footer_part">
						<h4>Newsletter</h4>
						<p>Undoubtedly, these are all developments that would have
							appealed to the pioneering character of Ori Auction.</p>
						<div id="mc_embed_signup">
							<form target="_blank"
								action="https://spondonit.us12.list-manage.com/subscribe/post?u=1462626880ade1ac87bd9c93a&amp;id=92a4423d01"
								method="get" class="subscribe_form relative mail_part">
								<input type="email" name="email" id="newsletter-form-email"
									placeholder="Email Address" class="placeholder hide-on-focus"
									onfocus="this.placeholder = ''"
									onblur="this.placeholder = ' Email Address '">
								<button type="submit" name="submit" id="modify">subscribe</button>
								<div class="mt-10 info"></div>
							</form>
						</div>
					</div>
				</div>
			</div>

		</div>
		<div class="copyright_part">
			<div class="container">
				<div class="row">
					<div class="col-lg-8">
						<div class="copyright_text">
							<P>
								<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
								Copyright &copy;
								<script>
									document.write(new Date().getFullYear());
								</script>
								All rights reserved | This template is made with by OriAuction
								Team</a>
								<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
							</P>
						</div>
					</div>
					<div class="col-lg-4">
						<div class="footer_icon social_icon">
							<ul class="list-unstyled">
								<li><a href="#" class="single_social_icon"><i
										class="fab fa-facebook-f"></i></a></li>
								<li><a href="#" class="single_social_icon"><i
										class="fab fa-twitter"></i></a></li>
								<li><a href="#" class="single_social_icon"><i
										class="fas fa-globe"></i></a></li>
								<li><a href="#" class="single_social_icon"><i
										class="fab fa-behance"></i></a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</footer>
	<!--::footer_part end::-->

	<!-- jquery plugins here-->
	<!-- jquery -->
	<script src="${path}/js/jquery-1.12.1.min.js"></script>
	<!-- popper js -->
	<script src="${path}/js/popper.min.js"></script>
	<!-- bootstrap js -->
	<script src="${path}/js/bootstrap.min.js"></script>
	<!-- easing js -->
	<script src="${path}/js/jquery.magnific-popup.js"></script>
	<!-- swiper js -->
	<script src="${path}/js/swiper.min.js"></script>
	<!-- swiper js -->
	<script src="${path}/js/masonry.pkgd.js"></script>
	<!-- particles js -->
	<script src="${path}/js/owl.carousel.min.js"></script>
	<script src="${path}/js/jquery.nice-select.min.js"></script>
	<!-- slick js -->
	<script src="${path}/js/slick.min.js"></script>
	<script src="${path}/js/jquery.counterup.min.js"></script>
	<script src="${path}/js/waypoints.min.js"></script>
	<script src="${path}/js/contact.js"></script>
	<script src="${path}/js/jquery.ajaxchimp.min.js"></script>
	<script src="${path}/js/jquery.form.js"></script>
	<script src="${path}/js/jquery.validate.min.js"></script>
	<script src="${path}/js/mail-script.js"></script>
	<script src="${path}/js/stellar.js"></script>
	<script src="${path}/js/price_rangs.js"></script>
	<!-- custom js -->
	<script src="${path}/js/custom.js"></script>
</body>

</html>