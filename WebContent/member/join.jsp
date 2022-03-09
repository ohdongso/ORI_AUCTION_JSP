<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

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
       <style>
		    #mainLogo{width:250px; height:45px}
		    @import url(//db.onlinewebfonts.com/c/537c29c4b78689a51f1c48cd802a503f?family=ITC+Grouch);
		    @import url(//db.onlinewebfonts.com/c/789f9065baf48309d73fd0ff02fe4aec?family=Big+Caslon+Black);
		    @import url('https://fonts.googleapis.com/css2?family=Archivo:wght@100&display=swap');
		    .dropdown-item{font-family: ITC Grouch;}
		    #loginTitle{font-family: ITC Grouch; font-size:35px; text-align:center; color:yellow;}
		    #loginStart{font-family: ITC Grouch;}
		    #password{font-family: 'Archivo', sans-serif; }
		    #idPlace{font-family: 'Archivo', sans-serif; }
		    #remember{font-family: adobe-caslon-pro, serif;}
		    h2, h3, h4, h5, h6, p{font-family: adobe-caslon-pro, serif; font-style: normal; font-weight: 700}
		    #joinTitle{text-align: center; font-family: ITC Grouch;}
		    input.underline { border-left-width:0; border-right-width:0; border-top-width:0; border-bottom-width:1; width:450px; } 
			#joinForm{display: inline-block; text-align: center;}
			#joinbutton{font-family: ITC Grouch; background-color: yellow; align:right; border:0; outline:0; padding:10px 30px; font-size: 15px}
			#sbox{all:none;}
			#checkbutton{font-family: ITC Grouch; background-color: yellow; border:0; outline:0; padding:8px 20px; font-size: 12px}
			#id{width:405px}
			#pw{width:485px}
			#pwc{width:450x}
			#name{width:485px}
			.nice-select{width:190px; height:30px; text-align-last: center; text-align: center;-ms-text-align-last: center; -moz-text-align-last: center;}
			#accountNum{width:285px}
			#con1{width:155px}
			#con2{width:155px}
			#con3{width:155px}
			#email1{width:235px; height:30px;}
			#email2{width:240px}
			#addr1{width:395px}
			#bb{font-family: ITC Grouch; background-color: black; border:0; outline:0; padding:6px 17px; font-size: 15px; color:yellow;}
			#oti{font-family:ITC Grouch; font-size: 100px; text-align: center; color:white;}
	
		</style>
		
		<script type="text/javascript" src="../js/jquery-3.6.0.min.js">
			
		</script>
		
    	 <script type="text/javascript">
    		//id 중복체크
    	 	$(function(){
    	 		$("#id").keyup(function() {
					if($(this).val()==""){
						$("#idCheck").html("");
						return;
					}
					$.ajax({
						url:"../idCheck",
						datatype:"text",
						type:"post",
						data:{id:$(this).val()},
						success:function(result){$("#idCheck").text(result)},
						error:function(err){
							alert(err+"아이디 조회 에러.")
						}
					}	
					)
				})
				//비밀번호 일치 체크
				$("#pwc").keyup(function() {
					if($(this).val()==""){
						$("#pwCheck").html("");
						return;
					}
					$.ajax({
						url:"../pwCheck",
						datatype:"text",
						type:"post",
						data:{pwc:$(this).val(),pw:$("#pw").val()},
						success:function(result){$("#pwCheck").text(result)},
						error:function(err){
							alert(err+"비밀번 조회 에러.")
						}
					}	
					)
				})
    	 	})
    	 
    	 	function goUrl(url) {
				location.href=url;
			}
    	 	
    	 	function goPopup(){
    	 		// 주소검색을 수행할 팝업 페이지를 호출합니다.
    	 		// 호출된 페이지(jusopopup.jsp)에서 실제 주소검색URL(http://www.juso.go.kr/addrlink/addrLinkUrl.do)를 호출하게 됩니다.
    	 		var pop = window.open("<%=request.getContextPath()%>/popup/jusoPopup.jsp", "pop",
    	 					"width=570,height=420, scrollbars=yes, resizable=yes");
    	 			// 	pageContext.getServletContext().getRealPath("/");
    	 			// 모바일 웹인 경우, 호출된 페이지(jusopopup.jsp)에서 실제 주소검색URL(http://www.juso.go.kr/addrlink/addrMobileLinkUrl.do)를 호출하게 됩니다.
    	 			//var pop = window.open("/popup/jusoPopup.jsp","pop","scrollbars=yes, resizable=yes"); 
    	 		}

    	 		function jusoCallBack(roadFullAddr) {
    	 			// 팝업페이지에서 주소입력한 정보를 받아서, 현 페이지에 정보를 등록합니다.	
    	 			document.joinForm.addr1.value = roadFullAddr;
    	 		}
    	 </script> 
    	 
    	 <script>
	    	 function validate() {
	    	       var id = document.getElementById("id");
	    	       var pw = document.getElementById("pw");
	    	       var pwc = document.getElementById("pwc");
	    	       var name = document.getElementById("name");
	    	       var accounNum = document.getElementById("accounNum");
	    	       var addr1 = document.getElementById("addr1");
	    	       var contact=document.getElementById("contact");
	    	       var email1 = document.getElementById("email1");
	    	       var email2 = document.getElementById("email2");
	    	       
	    	       if(id.value=="") {
	    	           alert("아이디를 입력해주세요");
	    	           id.focus();
	    	           return false;
	    	       }else if(pw.value=="") {
	    	           alert("비밀번호를 입력해주세요");
	    	           pw.focus();
	    	           return false;
	    	       }else if(pwc.value=="") {
	    	           alert("비밀번호를 확인해주세요 입력해주세요");
	    	           pwc.focus();
	    	           return false;
	    	       }else if(name.value=="") {
	    	           alert("이름을 입력해주세요");
	    	           name.focus();
	    	           return false;
	    	       }else if(addr1.value=="") {
	    	           alert("주소를 입력해주세요");
	    	           addr1.focus();
	    	           return false;
	    	       }else if(accountNum.value=="") {
	    	           alert("계좌 정보를 입력해주세요");
	    	           accountNum.focus();
	    	           return false;
	    	       }else if(con1.value=="") {
	    	           alert("올바른 연락처 형식이 아닙니다.");
	    	           con1.focus();
	    	           return false;
	    	       }else if(con2.value=="") {
	    	           alert("계좌 정보를 입력해주세요");
	    	           con2.focus();
	    	           return false;
	    	       }else if(con3.value=="") {
	    	           alert("계좌 정보를 입력해주세요");
	    	           con3.focus();
	    	           return false;
	    	       }else if(email1.value=="") {
	    	           alert("이메일을 입력해주세요");
	    	           email1.focus();
	    	           return false;
	    	       }else if(email2.value=="") {
	    	           alert("도메인 주소를 입력해주세요");
	    	           email2.focus();
	    	           return false;
	    	       } 
	    	       alert("회원가입 완료.");
	    	    return true;
	    			
	    	    }
	    	 
    	 
    	 
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
    
    
    
    <section>
		
			<div style="position: relative; z-index: 1; margin-bottom: 80px;">
				<img src="${path}/img/mem.png" width="110%" alt=""
					class="img-fluid" style="margin-top: 80px" id="mainI">
			</div>
			<div style="position:absolute; left: 50%; top: 50%; transform: translate( -50%, -50% ); z-index: 2;">
				<p id="oti">Join Us
				<p>
			</div>
			<h1 id="forma" style="font-family:ITC Grouch; text-align:center;"> Join Us and Enjoy Ori Auction! </h1>
		
	</section>


    <!--================join_part Area =================-->
    
    
    <!--================join_part end =================-->
   
   
   
   
   
   
   
   
   
   
   
   
   
   
    <section >
        <div style="margin:auto;text-align:center;">
        	<form name="joinForm" style="display:inline-block;" action="${path}/front?key=member&methodName=memberJoin" method=post onsubmit="return validate();">
				<input type="text" class="underline"  placeholder="ID" id="id" name="id"><span id="idCheck"></span><br><br>
				<input type="password" class="underline" placeholder="PASSWORD" id="pw" name="pw"> <br><br>
				<input type="password" class="underline" placeholder="PASSWORD CHECK" type="text" placeholder="CONFIRM PASSWORD" id="pwc" name="pwc"><span id="pwCheck"></span> <br><br>
				<input type="text" class="underline"  placeholder="NAME" id="name" name="name"> <br><br>
				<select name="bank" id="bank" >
					<option value="국민">국민</option>
					<option value="농협">농협</option>
					<option value="우리">우리</option>
					<option value="카카오">카카오</option>
					<option value="하나">하나</option>
					<option value="sc제일">sc제일</option>
				</select>&nbsp;&nbsp;
				
				<!--<input type="text" class="underline" placeholder="BANK" id="bank" name="bank">-->
				<input type="text" class="underline" placeholder="ACCOUNT NUMBER" id="accountNum" name="accountNum"> <br><br>
				<input type="text" class="underline" placeholder="ADDRESS" id="addr1" name="addr1" required="required" readonly="readonly"> &nbsp <button type="button" onclick="goPopup()" id="bb">Search</button> <br><br>
				<input type="text" class="underline"  id="con1" name="con1">-
				<input type="text" class="underline" id="con2" name="con2">-
				<input type="text" class="underline" id="con3" name="con3"> <br><br>
				
				<input type="text" class="underline" placeholder="E-MAIL" id="email1" name="email1">@
				<input type="text" class="underline" placeholder="DOMAIN" id="email2" name="email2"> <br><br><br><br><br><br>
				
				<input type="submit" title="Create as Account" id="joinbutton" value="Create an Account">
    		</form>	
    
    
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