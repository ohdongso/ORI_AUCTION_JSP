<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!doctype html>
<html lang="zxx">

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
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
//////////////////////////////////////////////////////////////////////////	

	$(function() {

		// 검색 항목, 검색어 입력 확인
		$("[name=search]").submit(function() {
			if ($("[name=keyField]").val() == "0") {
				alert("검색 필드를 선택해주세요.");
				return false;//전송기능을 막는다.
			}

			if ($("[name=keyWord]").val() == "") {
				alert("검색 키워드를 입력해주세요.");
				$("[name=keyWord]").focus();
				return false;
			}

		});

		$("input[value='DELETE']").click(function() {
			if (confirm("선택하신 아티스트를 삭제 처리하시겠습니까?")) {
				var acode = $(this).parent().siblings().eq(0).text();
				$("#id").val(acode);
				$("#artistForm").attr("action","${path}/front?");
			    $("#artistForm").submit();
			}
		});
	});
///////////////////////////////////////////////////////////////////////
</script>





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

#artistTitle {
	font-family: ITC Grouch;
}

a, h2, h3, h4, h5, h6, p {
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

#Aname {
	font-family: ITC Grouch;
}

#oti {
	font-family: ITC Grouch; font-size: 100px;
}

#searchButton {
	font-family: ITC Grouch;
	background-color: yellow;
	align: right;
	border: 0;
	outline: 0;
	padding: 5px 18px;
	font-size: 15px;
	width: 300px;
	height: 50px
}

.underline {
	width: 300px;
	height: 50px
}

.nice-select {
	width: 300px;
	height: 50px
}

#update {
	font-family: ITC Grouch;
	background-color: yellow;
	border: 0;
	outline: 0;
	padding: 10px 30px;
	font-size: 15px;
}

#deleteArtist {
	font-family: ITC Grouch; background-color: black; border:0; outline:0; padding:10px 30px; font-size: 15px; color:yellow;
}
#cute{
	width:748px;
	height:500px;
}
#oti{text-align: center; font-family:ITC Grouch; font-size: 100px; color:yellow;}
 #modify{font-family: ITC Grouch; background-color: yellow; color:blak;
   align:right; border:0; outline:0; padding:10px 30px; font-size: 15px; }
</style>
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

	<!--================Home Banner Area =================-->
	
	 
	
	
	
	 <section>
		
			<div style="position: relative; z-index: 1;margin-bottom: 80px;"">
				<img src="${path}/img/qeew.png" width="110%" height="400px" alt=""
					class="img-fluid" style="margin-top: 80px" id="mainI">
			</div>
			<div style="position:absolute; left: 180px; top: 250px; z-index: 2;">
				<p id="oti">Ori Auction's Artists
				<p>
			</div>
			<h1 id="forma" style="font-family:ITC Grouch; text-align:center;">Our All Artists are here!</h1>
		
	</section>



	<!--================End Category Product Area =================-->


		<div class="container">
			<div class="row">
				<div class="col-lg-8 mb-5 mb-lg-0">
					<div class="blog_left_sidebar">
							
						<c:choose>

							<c:when test="${empty requestScope.artistList }"><br>
								<b><span style="font-size: 12pt; font-family: adobe-caslon-pro, serif;text-align: center;" >입력하신 키워드에 맞는 아티스트가
										없습니다.</span></b>
							</c:when>
							<c:otherwise>
								<c:forEach items="${requestScope.artistList}" var="artistList">
									<article class="blog_item">
										<div class="blog_item_img">
											<img class="card-img rounded-0" id="cute"
												src="${path}/artist/img/${artistList.artistImg}" alt="artImg"> 
												<a class="blog_item_date">
												<h3 id="Aname">${artistList.member.name}</h3>

											</a>
										</div>

										<div class="blog_details">
											<a class="d-inline-block" href="single-blog.html"> <pre>${artistList.career}</pre>
												<h3>${artistList.profileLink}</h3>
											</a>

											<pre>${artistList.artistDetail}</pre>
											<form action="${path}/artist/updateArtist.jsp" method="post"
												id="artistForm">
												<input type="hidden" name="career"
													value="${artistList.career}"> <input type="hidden"
													name="artistImg" value="${artistList.artistImg}"> <input
													type="hidden" name=profileLink
													value="${artistList.profileLink}"> <input
													type="hidden" name="artistDetail"
													value="${artistList.artistDetail}">

												<c:if test="${sessionScope.loginUser==artistList.id}">
													<button type="submit" id="update">Update
														Information</button>
													<p>
														<br>
													<hr>
												</c:if>

												<c:if test="${sessionScope.loginState==0}">
													<input type="hidden" name="key" value="artist">
													<input type="hidden" name="methodName" value="deleteArtist">
													<input type="hidden" name="id" value="${artistList.id}"
														id="id">
													<input type="button" id="deleteArtist" name="deleteArtist"
														value="DELETE">
												</c:if>
											</form>

										</div>

									</article>
								</c:forEach>
							</c:otherwise>
						</c:choose>
					</div>
				</div>
				<div class="col-lg-4">
					<div class="blog_right_sidebar">
						<aside class="single_sidebar_widget search_widget">
							<form name="searchArtist"
								action="${path}/front?key=artist&methodName=selectByState"
								method="post">
								<div class="form-group">
									<div class="input-group mb-3">

										<select name="keyField" id="category">
											<option value="0">Category</option>
											<option value="id">ID</option>
											<option value="name">NAME</option>
											<option value="career">CAREER</option>
											<option value="artistDetail">DETAIL</option>
											<option value="profileLink">PROFILE LINK</option>
										</select> <input type="text" name="keyWord" class="underline"
											placeholder="input keyword" id="searchBox">

									</div>
								</div>
								<input type="submit" value="SEARCH" id="searchButton"
									name="selectByState">
							</form>
						</aside>

						<aside class="single_sidebar_widget post_category_widget">
							<h4 class="widget_title">Category</h4>
							<ul class="list cat-list">
								<li><a href="#" class="d-flex">
										<p>Fine Art</p>
										<p>(17)</p>
								</a></li>
								<li><a href="#" class="d-flex">
										<p>Contemporary Art</p>
										<p>(23)</p>
								</a></li>
								<li><a href="#" class="d-flex">
										<p>Paintings</p>
										<p>(103)</p>
								</a></li>
								<li><a href="#" class="d-flex">
										<p>Sculptures</p>
										<p>(43)</p>
								</a></li>
								<li><a href="#" class="d-flex">
										<p>Paintings</p>
										<p>(99)</p>
								</a></li>
								<li><a href="#" class="d-flex">
										<p>Photographs</p>
										<p>(57)</p>
								</a></li>
							</ul>
						</aside>

						<aside class="single_sidebar_widget popular_post_widget">
							<h3 class="widget_title">Recent Post</h3>
							<div class="media post_item">
								<img src="${path}/img/post/post_1.png" alt="post">
								<div class="media-body">
									<a href="single-blog.html">
										<h3>Big Offers to our old members</h3>
									</a>
									<p>January 12, 2021</p>
								</div>
							</div>
							<div class="media post_item">
								<img src="${path}/img/post/post_2.png" alt="post">
								<div class="media-body">
									<a href="single-blog.html">
										<h3>Ori Auction's Charity</h3>
									</a>
									<p>02 Hours ago</p>
								</div>
							</div>
							<div class="media post_item">
								<img src="${path}/img/post/post_3.png" alt="post">
								<div class="media-body">
									<a href="single-blog.html">
										<h3>About Ori Auction's new Service</h3>
									</a>
									<p>8 days ago</p>
								</div>
							</div>
							<div class="media post_item">
								<img src="${path}/img/post/post_4.png" alt="post">
								<div class="media-body">
									<a href="single-blog.html">
										<h3>Ori Auction's Museum Project</h3>
									</a>
									<p>March 24, 2021</p>
								</div>
							</div>
						</aside>
						<aside class="single_sidebar_widget tag_cloud_widget">
							<h4 class="widget_title">Tag Clouds</h4>
							<ul class="list">
								<li><a href="#">famous</a></li>
								<li><a href="#">old stuff</a></li>
								<li><a href="#">new artist</a></li>
								<li><a href="#">artworks</a></li>
								<li><a href="#">american</a></li>
								<li><a href="#">latin style</a></li>
								<li><a href="#">korean</a></li>
							</ul>
						</aside>



					</div>
				</div>
			</div>
		</div>
	</section>

	<!--::footer_part start::-->
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