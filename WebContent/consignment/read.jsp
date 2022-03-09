<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
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
</style>
<meta charset="UTF-8">
<title>Ori Auction</title>
<script type="text/javascript" src="${path}/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("button[id^=mbtn]").click(function() {
			$('form[id=mtext' + this.id + ']').toggle();
		})

		$("#toList").click(function() {
			location.href = "${path}/front?key=review&methodName=selectAll";
		})
		$("#delete")
				.click(
						function() {
							if (confirm("신청을 삭제하시겠습니까?")) {
								if ("${cons.userId}" == "${sessionScope.loginUser}") {
									location.href = "${path}/front?key=cons&methodName=delete&consignCode=${cons.consignCode}";
								} else {
									alert("작성자만 글을 삭제할 수 있습니다.");
								}
							}
						})
	})
</script>
<script type="text/javascript">
	
</script>
</head>

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
	<!--================Blog Area =================-->
	<section class="blog_area single-post-area padding_top">
		<div class="container">
			<div>
				<div align="center" class="col"></div>
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
									<p>Art Name :&nbsp;${cons.art.artName}</p>
								</li>
								<li>
									<p>Artist Name :&nbsp;${cons.art.artistName}</p>
								</li>
								<li><c:if test="${cons.art.artCategory==1}">
										<p>Art Type :&nbsp;Photo</p>
									</c:if> <c:if test="${cons.art.artCategory==2}">
										<p>Art Type :&nbsp;Fine Art</p>
									</c:if> <c:if test="${cons.art.artCategory==3}">
										<p>Art Type :&nbsp;Craft & Sculpture</p>
									</c:if></li>
								<li><c:if test="${cons.art.artSizeVol!=0}">
										<p>Art Size(width*height*vol)</p>
										<p>${cons.art.artSizeWidth}cm*${cons.art.artSizeHeight}cm
											* ${review.art.artSizeVol}cm</p>
									</c:if> <c:if test="${cons.art.artSizeVol==0}">
										<p>Art Size(width*height)</p>
										<p>${cons.art.artSizeWidth}cm*${cons.art.artSizeHeight}cm</p>
									</c:if></li>
								<li>
									<p>
										Estimate Cost :&nbsp;
										<fmt:formatNumber>${cons.art.estimateCost}</fmt:formatNumber>
										&nbsp;₩
									</p>
								</li>
								<li>
									<p>Production Year :&nbsp;${cons.art.prdYear}</p>
								</li>
								<li>
									<p>Art Details</p>
									<p>${cons.art.artDetail}</p>
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
									<h4>Applicant :&nbsp;${cons.userId}</h4>
									<h4>Regist Date :&nbsp;${cons.consignRdate}</h4>
									<c:choose>
										<c:when test="${cons.consignState==1}">
											<h4>
												Consignment State : <b style="color: red">In progress</b>
											</h4>
										</c:when>
										<c:when test="${cons.consignState==2}">
											<h4>
												Consignment State : <b style="color: blue">Completed</b>
											</h4>
										</c:when>
									</c:choose>
									<c:choose>
										<c:when test="${cons.consignCategory==1}">
											<h4>
												Auction Category : <b style="color: blue">Normal Auction</b>
											</h4>
										</c:when>
										<c:when test="${cons.consignCategory==2}">
											<h4>
												Auction Category : <b style="color: blue">Charity
													Auction</b>
											</h4>
										</c:when>
										<c:when test="${cons.consignCategory==3}">
											<h4>
												Auction Category : <b style="color: blue">Zero-Base
													Auction</b>
											</h4>
										</c:when>
									</c:choose>
								</div>
							</div>
						</div>
						<div class="feature-img" align="center"
							style="margin-top: 20px; margin-bottom: 20px; padding: 10px">
							<img class="img-fluid" src="${path}/art/artImg/${cons.art.artImg}" alt="">
						</div>
						<c:if
							test="${sessionScope.loginUser==cons.userId&&cons.consignState==1}">
							<div align="right" style="color: red">
								If you don't want this consignment click this button&nbsp;&nbsp;
								<button type="button"
									style="font-family: ITC Grouch; background-color: black; color: yellow; border: 0; outline: 0; padding: 10px 30px; font-size: 15px;"
									id="delete">Delete</button>
							</div>
						</c:if>
					</div>
				</div>
			</div>

			<div class="comment-form">
				<h3>Admin Answer</h3>
				<!-- 내일작업할부분 -->
				<c:choose>

					<c:when
						test="${sessionScope.loginState==1||sessionScope.loginState==2}">
						<!-- 사용자화면 -->

						<!-- 답변 없을 때 -->
						<c:if test="${empty cons.reply}">
							<div align="center">
								<h3 style="color: red;">Your request is currently being
									processed.</h3>
							</div>
						</c:if>

						<!-- 답변 있을 떄 -->
						<c:if test="${!empty cons.reply}">
							<div class="blog-author"
								style="margin-top: 10px; padding: 20px 15px">
								<div class="media align-items-center">
									<div class="media-body">
										<h5>${cons.reply.userId}</h5>
										<pre>${cons.reply.consignReplyContents}</pre>
									</div>
									<div align="right">
										<h6>${cons.reply.consignReplyRdate}</h6>
									</div>
								</div>
							</div>
						</c:if>

					</c:when>

					<c:when test="${sessionScope.loginState==0}">
						<!-- 관리자화면 -->

						<!-- 답변 없을 때 -->
						<c:if test="${empty cons.reply}">
							<form class="form-contact comment_form"
								action="${path}/front?key=cons&methodName=insertReply"
								method="post">
								<div class="row">
									<div class="col-12" style="margin-top: 10px">
										<div class="form-group">
											<textarea class="form-control w-100" name="replyContent"
												id="comment" cols="30" rows="9" placeholder="Write Comment"></textarea>
											<input type="hidden" name="consignCode"
												value="${cons.consignCode}" />
										</div>
									</div>
								</div>
								<div class="form-group mt-3" align="right">
									<button type="submit"
										style="font-family: ITC Grouch; background-color: yellow; border: 0; outline: 0; padding: 10px 30px; font-size: 15px;">Confirm</button>
								</div>
							</form>
						</c:if>

						<!-- 답변 있을 떄 -->
						<c:if test="${!empty cons.reply}">
							<div class="blog-author"
								style="margin-top: 10px; padding: 20px 15px">
								<div class="media align-items-center">
									<div class="media-body">
										<h5>${cons.reply.userId}</h5>
										<pre>${cons.reply.consignReplyContents}</pre>
									</div>
									<div align="right">
										<h6>${cons.reply.consignReplyRdate}</h6>
									</div>
								</div>
								<div align="right">
									<!-- 경매 등록으로 이동하는 버튼입니다!-->
									<!-- 감사합니다. 팀장님!! ^^ -->
									<c:if test="${flag==1}">
										<form
											action="${path}/front?key=auction&methodName=insertScheduledAuction"
											method="post">
											<input type="hidden" name="artCode" value="${cons.artCode}" />
											<input type="hidden" name="estimateCost"
												value="${cons.art.estimateCost}" /> <input type="hidden"
												name="auctionCategory" value="${cons.consignCategory}" />
											<button type="submit"
												style="font-family: ITC Grouch; background-color: yellow; border: 0; outline: 0; padding: 10px 30px; font-size: 15px;">Register</button>
										</form>
									</c:if>
								</div>
							</div>
						</c:if>

					</c:when>
				</c:choose>
			</div>
		</div>
	</section>
	<!--================Blog Area end =================-->

</body>
</html>