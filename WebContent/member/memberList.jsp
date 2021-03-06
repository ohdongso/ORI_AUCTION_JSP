<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!doctype html>
<html lang="zxx">

<head>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
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
    
    <script src="${pageContext.request.contextPath}/js/jquery-3.6.0.min.js"></script>
	<script>

	$(function() {

		$("input[value='EXILE']").click(function() {
			if (confirm("선택하신 회원을 강제 탈퇴 처리하시겠습니까?")) {
				var acode = $(this).parent().siblings().eq(0).text();
				location.href = "${path}/front?key=member&methodName=exile&id="+ acode;
			}
		});
	});
	
</script>
    
    <style>
    #mainLogo{width:250px; height:45px}
    @import url(//db.onlinewebfonts.com/c/537c29c4b78689a51f1c48cd802a503f?family=ITC+Grouch);
    @import url(//db.onlinewebfonts.com/c/789f9065baf48309d73fd0ff02fe4aec?family=Big+Caslon+Black);
    @import url('https://fonts.googleapis.com/css2?family=Archivo:wght@100&display=swap');
    .dropdown-item{font-family: ITC Grouch;}
    #banana{font-family:ITC Grouch;}
    h2, h3, h4, h5, h6, p{font-family: adobe-caslon-pro, serif; font-style: normal; font-weight: 700}
    #mainSample1{width:580px; height:400px}
    #artTypes{font-family: 'Archivo', sans-serif; color:#2E64FE;}
    #artistTitle{font-family:ITC Grouch; font-size: 100px}
    #modify{font-family: ITC Grouch; background-color: yellow; 
   align:right; border:0; outline:0; padding:10px 30px; font-size: 15px; }
   #goBack{font-family: ITC Grouch; background-color: black; border:0; outline:0; padding:10px 30px; font-size: 15px; color:yellow;}
    #searchButton{font-family: ITC Grouch; background-color: yellow; align:right; border:0; outline:0; padding:5px 18px; font-size: 15px}
    input.underline {border-left-width:0;border-right-width:0;border-top-width:0;border-bottom-width:1;}
	#exile{font-family: ITC Grouch; background-color: black; align:right; border:0; outline:0; padding:5px 18px; font-size: 15px; color:yellow}
	.table{width: 1400px; font-size: 12px; align:center;}
	 #oti{text-align: center; font-family:ITC Grouch; font-size: 100px; color:white; }
	
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
  <!-- breadcrumb start-->
  
  
   <section>
		
			<div style="position: relative; z-index: 1; margin-bottom: 80px;">
				<img src="${path}/img/pps.png" width="100%" alt=""
					class="img-fluid" style="margin-top: 80px" id="mainI">
			</div>
			<div style="position:absolute; left: 120px; top: 300px; z-index: 2;">
				<p id="oti">Ori Auction's All Members
				<p>
			</div>
			<h1 id="forma" style="font-family:ITC Grouch; text-align:center;"></h1>
		
	</section>

  <!-- breadcrumb start-->

	

  <!--================Cart Area =================-->
  
    
      <div class="cart_inner" align="center">
      <div style="margin:auto;text-align:center;">
       <form name="searchMember" action="${path}/front?key=member&methodName=selectByState" method="post">
    	
    	<select name="keyField" >
				<option value="0">Category</option>
				<option value="id">ID</option>
				<option value="name">이름</option>
				<option value="account">계좌 정보</option>
				<option value="addr">주소</option>
				<option value="contact">연락처</option>
				<option value="memState">등급</option>
		</select>&nbsp;&nbsp;
		
        	<input type="text" name="keyWord" class="underline" placeholder="input keyword" id="searchBox" > &nbsp 
        	<input type="submit" value="SEARCH" id="searchButton"> <br><br>
		</form>	
    
    	</div>
          <table class="table">
            <thead>
              <tr>
                <th scope="col">ID</th>
                <th scope="col">이름</th>
                <th scope="col">계좌 정보</th>
                <th scope="col">주소</th>
                <th scope="col">연락처</th>
                <th scope="col">Email</th>
                <th scope="col">구분</th>
                <th scope="col">가입일</th>
                
              </tr>
            </thead>
            
            <tbody>
            
            
             <c:forEach items="${requestScope.memberList}" var="member">
              <tr>
	                <td>${member.id}</td>
	                <td>${member.name}</td>
	                <td>${member.account}</td>
	                <td>${member.addr}</td>
	                <td>${member.contact}</td>
	                <td>${member.email}</td>
	                
	           
	             <c:choose>
	                <c:when test="${member.memState==1}">
	                <td>일반회원</td>
	                </c:when>
	                <c:when test="${member.memState==2}">
	                <td>작가</td>
	                </c:when>
	                <c:when test="${member.memState==0}">
	                <td>관리자</td>
	                </c:when> </c:choose>  
	                
	                <td>${member.registDate}</td>
	                
	                <td>
	                	<input name="exile" type="submit" value="EXILE" id="exile"> <br><br>
	                	
	                </td>
	                </tr>
	                </c:forEach>
              	
              		
              
             
              
              
              <tr class="bottom_button">
                <td>
                   <button type="submit" id="modify" >Confirm</button>
                </td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                 <td></td>
                <td>
                  <div class="cupon_text float-right">
                    <button type="button" id="goBack" onClick="history.back(-1);" >Go Back</button>
                  </div>
                </td>
              </tr>
              <tr>
              
                
            </tbody>
          </table>
        </div>
      </div>
      
  </section>
  <!--================End Cart Area =================-->

  <!--::footer_part start::-->
  <footer class="footer_part">
    <div class="container">
      <div class="row justify-content-around">
        <div class="col-sm-6 col-lg-2">
          <div class="single_footer_part">
            <h4>Top Products</h4>
            <ul class="list-unstyled">
              <li><a href="">Managed Website</a></li>
              <li><a href="">Manage Reputation</a></li>
              <li><a href="">Power Tools</a></li>
              <li><a href="">Marketing Service</a></li>
            </ul>
          </div>
        </div>
        <div class="col-sm-6 col-lg-2">
          <div class="single_footer_part">
            <h4>Quick Links</h4>
            <ul class="list-unstyled">
              <li><a href="">Jobs</a></li>
              <li><a href="">Brand Assets</a></li>
              <li><a href="">Investor Relations</a></li>
              <li><a href="">Terms of Service</a></li>
            </ul>
          </div>
        </div>
        <div class="col-sm-6 col-lg-2">
          <div class="single_footer_part">
            <h4>Features</h4>
            <ul class="list-unstyled">
              <li><a href="">Jobs</a></li>
              <li><a href="">Brand Assets</a></li>
              <li><a href="">Investor Relations</a></li>
              <li><a href="">Terms of Service</a></li>
            </ul>
          </div>
        </div>
        <div class="col-sm-6 col-lg-2">
          <div class="single_footer_part">
            <h4>Resources</h4>
            <ul class="list-unstyled">
              <li><a href="">Guides</a></li>
              <li><a href="">Research</a></li>
              <li><a href="">Experts</a></li>
              <li><a href="">Agencies</a></li>
            </ul>
          </div>
        </div>
        <div class="col-sm-6 col-lg-4">
          <div class="single_footer_part">
            <h4>Newsletter</h4>
            <p>Heaven fruitful doesn't over lesser in days. Appear creeping
            </p>
            <div id="mc_embed_signup">
              <form target="_blank"
                action="https://spondonit.us12.list-manage.com/subscribe/post?u=1462626880ade1ac87bd9c93a&amp;id=92a4423d01"
                method="get" class="subscribe_form relative mail_part">
                <input type="email" name="email" id="newsletter-form-email" placeholder="Email Address"
                  class="placeholder hide-on-focus" onfocus="this.placeholder = ''"
                  onblur="this.placeholder = ' Email Address '">
                <button type="submit" name="submit" id="newsletter-submit"
                  class="email_icon newsletter-submit button-contactForm">subscribe</button>
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
              <P><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="ti-heart" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. --></P>
            </div>
          </div>
          <div class="col-lg-4">
            <div class="footer_icon social_icon">
              <ul class="list-unstyled">
                <li><a href="#" class="single_social_icon"><i class="fab fa-facebook-f"></i></a></li>
                <li><a href="#" class="single_social_icon"><i class="fab fa-twitter"></i></a></li>
                <li><a href="#" class="single_social_icon"><i class="fas fa-globe"></i></a></li>
                <li><a href="#" class="single_social_icon"><i class="fab fa-behance"></i></a></li>
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
</body>

</html>