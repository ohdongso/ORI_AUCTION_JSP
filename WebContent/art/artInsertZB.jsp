<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>ORI AUCTION</title>
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
<link rel="stylesheet" href="${path}/css/nice-select.css">
<!-- font awesome CSS -->
<link rel="stylesheet" href="${path}/css/magnific-popup.css">
<!-- swiper CSS -->
<link rel="stylesheet" href="${path}/css/slick.css">
<!-- style CSS -->
<link rel="stylesheet" href="style.css">
<style>

	 #modify{font-family: ITC Grouch; background-color: yellow; 
   align:right; border:0; outline:0; padding:10px 30px; font-size: 15px; }
   #delete{font-family: ITC Grouch; background-color: black; color:yellow;
   align:right; border:0; outline:0; padding:10px 30px; font-size: 15px; }
</style>
<script type="text/javascript" src="${path}/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">

	//년도, 크기, 추정가 입력란에 숫자만 들어가도록하는 메소드
	function onlyNumber(event) {
		event = event || window.event;
		var keyID = (event.which) ? event.which : event.keyCode;
		if ((keyID >= 48 && keyID <= 57) || (keyID >= 96 && keyID <= 105)
				|| keyID == 8 || keyID == 46 || keyID == 37 || keyID == 39)
			return;
		else
			return false;
	}
	function removeChar(event) {
		event = event || window.event;
		var keyID = (event.which) ? event.which : event.keyCode;
		if (keyID == 8 || keyID == 46 || keyID == 37 || keyID == 39)
			return;
		else
			event.target.value = event.target.value.replace(/[^0-9]/g, "");
	}

	$(function () {
		$("input[type=submit]").submit(function(){
			if(!confirm("작품을 위탁하시겠습니까?")){
				return false;
			}
		});
		
		$("[value=Back]").click(function() {
			history.back();
		});
    });
	
</script>

</head>
<body>

   <!--::header part start::-->
    <header class="main_menu home_menu">
        <div class="container">
            <div class="row align-items-center">
                <div class="col-lg-12">
                    <nav class="navbar navbar-expand-lg navbar-light">
                          <a class="navbar-brand" href="${path}/index.jsp"> <img src="${path}/img/mainLogo.png" alt="logo" id="mainLogo"> </a>
                        <button class="navbar-toggler" type="button" data-toggle="collapse"
                            data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                            aria-expanded="false" aria-label="Toggle navigation">
                            <span class="menu_icon"><i class="fas fa-bars"></i></span>
                        </button>

                        <div class="collapse navbar-collapse main-menu-item" id="navbarSupportedContent">
                            <ul class="navbar-nav">
                                <li class="nav-item dropdown">
                                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown_1"
                                        role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                        Online-Auction
                                    </a>
                                    <div class="dropdown-menu" aria-labelledby="navbarDropdown_1">
                                        <a class="dropdown-item" href="${path}/front?key=auction&methodName=selectAll">All Auction</a>
                                        <a class="dropdown-item" href="${path}/front?key=auction&methodName=selectAuction&aucCategory=1">Normal Auction</a>
                                        <a class="dropdown-item" href="${path}/front?key=auction&methodName=selectAuction&aucCategory=2">Charity Auction</a>
                                        <a class="dropdown-item" href="${path}/front?key=auction&methodName=selectAuction&aucCategory=3">Zero-Base Auction</a>
                                    	<c:if test="${sessionScope.loginState==0}">
                                    		<a class="dropdown-item" href="${path}/front?key=auction&methodName=searchByState&state=1">Manage Auctions</a>
                                    	</c:if> 
                                    </div>
                                </li>
                                
                                <li class="nav-item dropdown">
                                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown_1"
                                        role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                        Consignment
                                    </a>
                                    <div class="dropdown-menu" aria-labelledby="navbarDropdown_1">
                                    	<a class="dropdown-item" href="${path}/art/artInsert.jsp">Art Application</a>
                                    	<c:if test="${sessionScope.loginState==2}">
											<a class="dropdown-item" href="${path}/art/artInsertZB.jsp">ZB Application</a>
                                    	</c:if>
                                        <c:if test="${sessionScope.loginState==1||sessionScope.loginState==2}">
                                        	<a class="dropdown-item" href="${path}/front?key=cons&methodName=selectById">My Consignment</a>
                                        </c:if>
                                        <a class="dropdown-item" href="${path}/front?key=art&methodName=searchByKeyWord&keyField=id&keyWord=${sessionScope.loginUser}">My Arts</a>
                                       <c:if test="${sessionScope.loginState==0}">
                                           <a class="dropdown-item" href="${path}/front?key=cons&methodName=selectAll">Consignment List</a>
                                       </c:if>
                                        
                                    </div>
                                </li>
                                
                                <li class="nav-item dropdown">
                                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown_1"
                                        role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                        Board
                                    </a>
                                    <div class="dropdown-menu" aria-labelledby="navbarDropdown_1">
                                        <a class="dropdown-item" href="${path}/front?key=board&methodName=selectAll">Free Board</a>
                                        <a class="dropdown-item" href="${path}/front?key=review&methodName=selectAll">Review Board</a>
                                        <a class="dropdown-item" href="${path}/front?key=sb&methodName=selectAll">1:1 Inquiry</a>
                                        <a class="dropdown-item" href="${path}/front?key=faq&methodName=selectAll">FAQ</a>
                                        <a class="dropdown-item" href="${path}/front?key=artist&methodName=selectAllArtist">Artist List</a>
                                    </div>
                                </li>
                                
                                <li class="nav-item dropdown">
                                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown_1"
                                        role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                        About
                                    </a>
                                    <div class="dropdown-menu" aria-labelledby="navbarDropdown_1">
                                        <a class="dropdown-item" href="${path}/about/introduce.jsp">Introduce</a>
                                        <a class="dropdown-item" href="${path}/serBoard/donIndex.jsp">Donation Activity</a>
                                        <a class="dropdown-item" href="${path}/front?key=article&methodName=selectAll">Article</a>
                                    </div>
                                </li>
                                
                                <li class="nav-item dropdown">
                                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown_1"
                                        role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                        My Page
                                    </a>
                                    <div class="dropdown-menu" aria-labelledby="navbarDropdown_1">
                                        <a class="dropdown-item" href="${path}/front?key=like&methodName=selectAll">Liked Arts</a>
                                        <a class="dropdown-item" href="${path}/front?key=member&methodName=myInform">My Information</a>
                                        <a class="dropdown-item" href="${path}/artist/registArtist.jsp">Artist Service</a>
                                        <a class="dropdown-item" href="${path}/front?key=bid&methodName=searchBidArtState&userId=${sessionScope.loginUser}">My Bidding</a>
                                        <a class="dropdown-item" href="${path}/front?key=sucBid&methodName=searchByUserId&userId=${sessionScope.loginUser}">My Successful Bid</a>
                                        <c:if test="${sessionScope.loginState==0}">
                                        <a class="dropdown-item" href="${path}/front?key=member&methodName=selectAllMember">Our Members</a></c:if>
                                 
                                    </div>
                                </li>
                            </ul>
                        </div>
                        <div class="hearer_icon d-flex">
                           <c:if test="${sessionScope.loginUser==null}">
                               &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a id="search_1" href="${path}/member/login.jsp">login</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                               <a id="search_1" href="${path}/member/join.jsp">signin</a>
                           </c:if>
                           <c:if test="${sessionScope.loginUser!=null}">
                               &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a id="search_1" href="${path}/front?key=member&methodName=logout">logout</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                               <a id="search_1" href="#">${loginUser}</a>
                           </c:if>
                        </div>
                    </nav>
                </div>
            </div>
        </div>
   
    </header>
    <!-- Header part end-->

	<div class="whole-wrap" style="margin-top:100px">
		<div class="container box_1170">
			<div class="section-top-border">
				<div align="center">
					<div class="col-lg-8 col-md-8" style="width: 600px">
						<h2 style="font-family: ITC Grouch">CONSIGNMENT</h2>
						<h4 class="mb-30" style="color:blue">ZERO-BASE ART STORAGE</h4>
						<form name="writeForm" method="post" action="${path}/front?key=art&methodName=insertArt" enctype="multipart/form-data">
							<div class="mt-10">
								<input type="hidden" name="id" value="${sessionScope.loginUser}">
							</div>
							<div class="mt-10">
								<input type="hidden" name="artistCode" value="${sessionScope.loginCode}">
							</div>
							<div class="mt-10">
								<input type="text" name="artName" placeholder="Title"
									onfocus="this.placeholder = ''"
									onblur="this.placeholder = 'Title'" required
									class="single-input">
							</div>
							<div class="mt-10">
								<input type="hidden" name="artistName" value="${sessionScope.loginUser}">
							</div>
							<div class="mt-10">
								<div class="form-select" id="category"> <!-- style.css 6853 행 padding삭제 -->
									<select name="artCategory">
										<option value="0">Category</option>
										<option value="1">Photograph</option>
										<option value="2">Fine-Art</option>
										<option value="3">Craft & Sculpture</option>
									</select>
								</div>
							</div>
							<div class="mt-10">
								<input type="text" name="prdYear" onkeydown='return onlyNumber(event)' 
								onkeyup='removeChar(event)' maxlength="4" placeholder="Year(YYYY)"
									onfocus="this.placeholder = ''"
									onblur="this.placeholder = 'Year(YYYY)'" required
									class="single-input">
							</div>
							<div class="mt-10">
								<textarea class="single-textarea" name="artDetail" placeholder="Detail"
									onfocus="this.placeholder = ''"
									onblur="this.placeholder = 'Detail'" required></textarea>
							</div>
							<div class="mt-10">
								<input type="text" name="artSizeHeight" onkeydown='return onlyNumber(event)' 
								onkeyup='removeChar(event)' maxlength="4" placeholder="Height (cm)"
									onfocus="this.placeholder = ''"
									onblur="this.placeholder = 'Height (cm)'" required
									class="single-input" style="width:185px; float:left;">
								<input type="text" name="artSizeWidth" onkeydown='return onlyNumber(event)' 
								onkeyup='removeChar(event)' maxlength="4" placeholder="Width (cm)"
									onfocus="this.placeholder = ''"
									onblur="this.placeholder = 'Width (cm)'" required
									class="single-input" style="width:185px; float:left;">
								<input type="text" name="artSizeVol" onkeydown='return onlyNumber(event)' 
								onkeyup='removeChar(event)' maxlength="4" placeholder="Vol (cm)"
									onfocus="this.placeholder = ''"
									onblur="this.placeholder = 'Vol (cm)'" required
									class="single-input" style="width:200px">
							</div>
							<div class="mt-10"></div>
							<div class="mt-10">
								<input type="text" name="estimateCost" onkeydown='return onlyNumber(event)' 
								onkeyup='removeChar(event)' maxlength="9" placeholder="Estimate Cost"
									onfocus="this.placeholder = ''"
									onblur="this.placeholder = 'Estimate Cost'" required
									class="single-input">
							</div>
							<div class="mt-10">
								<input type="hidden" name="artState" value="1">
							</div>
							<div class="mt-10">
								<input type="file" name="artImg" maxlength="60" size="40" required class="single-input" >
							</div>
							<div class="button-group-area mt-10">
								<input type="reset" value="Reset" id="delete"/>&nbsp;&nbsp;
								<input type="submit" value="Submit" id="modify"/>&nbsp;&nbsp;
								<input type="button" value="Back" id="delete"/>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

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
	<!-- custom js -->
	<script src="${path}/js/custom.js"></script>

</body>
</html>