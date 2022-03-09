<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html lang="zxx">

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>OriAuction</title>
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
	width: 650px;
	height: 450px
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

#modify {
	font-family: ITC Grouch;
	background-color: yellow;
	border: 0;
	outline: 0;
	padding: 10px 30px;
	font-size: 15px;
}

#ser {
	font-family: ITC Grouch;
	background-color: yellow;
	border: 0;
	outline: 0;
	font-size: 15px;
	padding: 8px 20px;
}

#boy {
	width: 200px
}
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

	<!-- banner part start-->
	<section class="banner_part">
		<div class="container">
			
				
					<div class="banner_slider owl-carousel">
						
						
						<div class="single_banner_slider">
							<div class="row">
								<div class="col-lg-5 col-md-8">
									<div class="banner_text">
										<div class="banner_text_iner">
											<h2 id="banana">Understanding Artemisia</h2>
											<h6>
												18-29 June 2021 | 12:00PM EDT | PARIS<br>
												<br>Height: 47.62 inches / 121.0 cm
												Width: 38.75 inches / 98.4 cm<br>

												Literature<br>
												J. Coelemans, Receuil des plus beaux tableaux du Cabinet<br>
												de Messire J.B. Boyer, seigneur d'Aiguilles, Conseilleur <br>
												au Parlement d'Aix, Aix en Provence 1709, reproduced 2nd <br>
												ed., 1744, plate XXXIII;<br>
												C. Manzitti, Valerio Castello, Genoa 1972, p. 134, no. 56, <br>
												reproduced (engraving);<br>
												C. Manzitti, Valerio Castello, Turin 2004, p. 237, under <br>
												
											</h6>


											<a href="#" class="genric-btn warning">See Details</a>
										</div>
									</div>
								</div>
								<div class="banner_img d-none d-lg-block">
									<img src="${path}/img/tjs.jpg" alt="" id="mainSample1">
								</div>
							</div>
						</div>
						
						
					
					
					
					
						
						
						<div class="single_banner_slider">
							<div class="row">
								<div class="col-lg-5 col-md-8">
									<div class="banner_text">
										<div class="banner_text_iner"><p><p><p><br><p>
											<h2 id="banana">Keith Haring</h2>
											<h5>
												18-29 April 2021 | 12:00PM EDT | SEOUL<br>
												<br> Height: 27.00 inches / 68.6 cm<br> Width:
												33.00 inches / 83.8 cm<br> Signature<br>
												Provenance<br> Private Collection, Belgium (acquired
												directly from the artist)<br> Ori Auction, Seoul May
												11, 2011, lot 598 (consigned by the above)<br> Private
												Collection, New York (acquired from the above sale)<br>

												Opera Gallery, Paris<br> Acquired by the present owner
												from the above in 2017<br>

											</h5><p><br>
											<a href="#" class="genric-btn warning">See Details</a>
										</div>
									</div>
								</div>
								<div class="banner_img d-none d-lg-block">
									<img src="${path}/img/load.jpg" alt="" id="mainSample1">
								</div>
							</div>
						</div>
						
						
						
						
						<div class="single_banner_slider">
							<div class="row">
								<div class="col-lg-5 col-md-8">
									<div class="banner_text">
										<div class="banner_text_iner">
											<h2 id="banana">Archival pigment print</h2>
											<h6>
												18-29 April 2021 | 12:00PM EDT | SEOUL<br>
												<br> Height: 16.00 inches / 40.6 cm<br> 
												Width: 19.00 inches / 48.3 cm<br> 
												Recent museum exhibitions include Making Knowing: Craft <br> 
												in Art, 1950–2019, Whitney Museum of American Art, New York; <br> 
												Face à face, frac île‐de‐france, Villetaneuse, France; Anna Atkins <br> 
												Refracted: Contemporary Works, The New York Public Library, <br> 
												New York; The Swindle: Art Between Seeing and Believing, <br> 
												Albright‐Knox Art Gallery, <br> 
											</h6>
											<a href="#" class="genric-btn warning">See Details</a>
										</div>
									</div>
								</div>
								<div class="banner_img d-none d-lg-block">
									<img src="${path}/img/main22.jpeg" alt="" id="mainSample1">
								</div>
							</div>
						</div>
						<!-- <div class="single_banner_slider">
                            <div class="row">
                                <div class="col-lg-5 col-md-8">
                                    <div class="banner_text">
                                        <div class="banner_text_iner">
                                            <h1>Cloth $ Wood Sofa</h1>
                                            <p>Incididunt ut labore et dolore magna aliqua quis ipsum
                                                suspendisse ultrices gravida. Risus commodo viverra</p>
                                            <a href="#" class="btn_2">buy now</a>
                                        </div>
                                    </div>
                                </div>
                                <div class="banner_img d-none d-lg-block">
                                    <img src="img/banner_img.png" alt="">
                                </div>
                            </div>
                        </div> -->
					</div>

				</div>
		
	</section>
	<!-- banner part start-->

	<!-- feature_part start-->
	<section class="feature_part padding_top">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-lg-12">
					<div class="section_tittle text-center">
						<h2 id="title">Upcoming Our Auctions</h2>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-12">
					<div class="single_product_list_slider">
						<div class="row align-items-center justify-content-between">
							<div class="col-lg-3 col-sm-6">
								<div class="single_product_item">
									<img src="${path}/img/m1.png" alt="">
									<div class="single_product_text">
										<h4>I dreamed of... #1</h4>
										<h3>Grisha Bruskin</h3>
										<h3>150,000 USD</h3>
										<a href="#" class="add_cart">Make an Offer<i
											class="ti-heart"></i></a>
									</div>
								</div>
							</div>
							<div class="col-lg-3 col-sm-6">
								<div class="single_product_item">
									<img src="${path}/img/m2.png" alt="">
									<div class="single_product_text">
										<h4>Dean Fox The Prayer</h4>
										<h3>Dean Fox</h3>
										<h3>26,000 USD</h3>

										<a href="#" class="add_cart">Make an Offer<i
											class="ti-heart"></i></a>
									</div>
								</div>
							</div>
							<div class="col-lg-3 col-sm-6">
								<div class="single_product_item">
									<img src="${path}/img/m3.png" alt="">
									<div class="single_product_text">
										<h4>Vieille Femme de Pêcheur</h4>
										<h3>Léon Spilliaert</h3>
										<h3>PRIVATE SALE</h3>
										<a href="#" class="add_cart">Make an Offer<i
											class="ti-heart"></i></a>
									</div>
								</div>
							</div>
							<div class="col-lg-3 col-sm-6">
								<div class="single_product_item">
									<img src="${path}/img/m4.png" alt="">
									<div class="single_product_text">
										<h4>Jean Dubuffet</h4>
										<h3>Personnage D109, dédicacé</h3>
										<h3>Price upon request</h3>
										<a href="#" class="add_cart">Make an Offer<i
											class="ti-heart"></i></a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>



			<div class="container">
				<div class="row justify-content-center">
					<div class="col-lg-12"></div>
				</div>
				<div class="row">
					<div class="col-lg-12">
						<div class="single_product_list_slider">
							<div class="row align-items-center justify-content-between">
								<div class="col-lg-3 col-sm-6">
									<div class="single_product_item">
										<img src="${path}/img/werw.png" alt="">
										<div class="single_product_text">
											<h4>Matthew Collins</h4>
											<h3>Santa Margherita</h3>
											<h3>Price upon request</h3>
											<a href="#" class="add_cart">Make an Offer<i
												class="ti-heart"></i></a>
										</div>
									</div>
								</div>
								<div class="col-lg-3 col-sm-6">
									<div class="single_product_item">
										<img src="${path}/img/f1.png" alt="">
										<div class="single_product_text">
											<h4>Christopher Pulitzer Leidy</h4>
											<h3>Red Zap</h3>
											<h3>8,500 USD</h3>
											<a href="#" class="add_cart">Make an Offer<i
												class="ti-heart"></i></a>
										</div>
									</div>
								</div>
								<div class="col-lg-3 col-sm-6">
									<div class="single_product_item">
										<img src="${path}/img/m7.png" alt="">
										<div class="single_product_text">
											<h4>Christian Chaize</h4>
											<h3>Praia Piquinia 17/08/15</h3>
											<h3>6,245 USD</h3>
											<a href="#" class="add_cart">Make an Offer<i
												class="ti-heart"></i></a>
										</div>
									</div>
								</div>
								<div class="col-lg-3 col-sm-6">
									<div class="single_product_item">
										<img src="${path}/img/m8.png" alt="">
										<div class="single_product_text">
											<h4>Sam Francis</h4>
											<h3>To Hölderlin</h3>
											<h3>Price upon request</h3>
											<a href="#" class="add_cart">Make an Offer<i
												class="ti-heart"></i></a>
										</div>
									</div>
								</div>
								<div class="col-lg-3 col-sm-6">
									<div class="single_product_item">
										<img src="${path}/img/m13.png" alt="">
										<div class="single_product_text">
											<h4>Karel Appel</h4>
											<h3>Personnage</h3>
											<h3>1,495 USD</h3>
											<a href="#" class="add_cart">Make an Offer<i
												class="ti-heart"></i></a>
										</div>
									</div>
								</div>
								<div class="col-lg-3 col-sm-6">
									<div class="single_product_item">
										<img src="${path}/img/m10.png" alt="">
										<div class="single_product_text">
											<h4>Andrew Bush</h4>
											<h3>Woman wheeling down Sunset</h3>
											<h3>6,500 USD</h3>
											<a href="#" class="add_cart">Make an Offer<i
												class="ti-heart"></i></a>
										</div>
									</div>
								</div>
								<div class="col-lg-3 col-sm-6">
									<div class="single_product_item">
										<img src="${path}/img/m11.png" alt="">
										<div class="single_product_text">
											<h4>Roe Ethridge</h4>
											<h3>Picket Fence II</h3>
											<h3>22,000 USD</h3>
											<a href="#" class="add_cart">Make an Offer<i
												class="ti-heart"></i></a>
										</div>
									</div>
								</div>
								<div class="col-lg-3 col-sm-6">
									<div class="single_product_item">
										<img src="${path}/img/m12.png" alt="">
										<div class="single_product_text">
											<h4>English Seated Dog</h4>
											<h3>20th Century</h3>
											<h3>3,150 USD</h3>
											<a href="#" class="add_cart">Make an Offer<i
												class="ti-heart"></i></a>
										</div>
									</div>
								</div>
							</div>
						</div>




					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- product_list part start-->

	<!-- awesome_shop start-->
	<section class="our_offer section_padding">
		<div class="container">
			<div class="row align-items-center justify-content-between">
				<div class="col-lg-6 col-md-6">
					<div class="offer_img">
						<img src="img/smpl1.jpeg" alt="">
					</div>
				</div>
				<div class="col-lg-6 col-md-6">
					<div class="offer_text">
						<h2 id="title">Ori Auction's 39th Presentation</h2>
						<div class="date_countdown">
							<div id="timer">
								<div id="days" class="date"></div>
								<div id="hours" class="date"></div>
								<div id="minutes" class="date"></div>
								<div id="seconds" class="date"></div>
							</div>
						</div>
						<div class="input-group">
							<input type="text" class="form-control"
								placeholder="enter email address"
								aria-label="Recipient's username"
								aria-describedby="basic-addon2">
							<div class="input-group-append">
								<a href="#" class="input-group-text btn_2" id="basic-addon2">book
									now</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- awesome_shop part start-->

	<!-- product_list part start-->

	<!--::subscribe_area part end::-->

	<!-- subscribe_area part start-->

	<!--::subscribe_area part end::-->

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