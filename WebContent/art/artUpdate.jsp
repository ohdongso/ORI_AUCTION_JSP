<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<link rel="stylesheet" href="${path}/css/style.css">

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

//세션에 따른 수정 권한 부여
$(function(){
	
	if("${sessionScope.loginUser}"!="admin"){
		$("input[type=text]").attr("readonly",true);
		$("textarea[name=artDetail]").attr("readonly",true);
	}
	
	$("[name=updateArt]").submit(function(){
		if(!confirm("작품 정보를 수정하시겠습니까?")){
			return false;			
		}else{
			alert("작품 정보가 수정되었습니다.");
		}
	});
	
	$("#back").click(function(){
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
							<img src="${path}/art/artImg/${artDTO.artImg}"/>
							</div><br>
				<div align="center">
					<div class="col-lg-8 col-md-8" style="width: 600px">
						<h3 class="mb-30">ART INFORMATION</h3>
						<form name="updateArt" method="post" action="${path}/front?key=art&methodName=updateArt" enctype="multipart/form-data">
							
							<c:if test="${sessionScope.loginState==0}">
							<div class="mt-10">
								<!-- <span style="float:left; color:#A9E2F3">ArtCode</span> -->
								<input type="hidden" name="artCode" required class="single-input" value="${artDTO.artCode}">
							</div>
							<div class="mt-10">
							<!-- <span style="float:left; color:#A9E2F3">UserID</span> -->
								<input type="hidden" name="id" required class="single-input" value="${artDTO.id}">
							</div>
							<div class="mt-10">
							<!-- <span style="float:left; color:#A9E2F3">ArtistCode</span> -->
								<input type="hidden" name="artistCode" required class="single-input" value="${artDTO.artistCode}">
							</div>
							</c:if>
							<div class="mt-10">
							<span style="float:left; color:#A9E2F3">Title</span>
								<input type="text" name="artName" required class="single-input" value="${artDTO.artName}">
							</div>
							<div class="mt-10">
							<span style="float:left; color:#A9E2F3">Artist</span>
								<input type="text" name="artistName" required class="single-input" value="${artDTO.artistName}">
							</div>
							<div class="mt-10">
							<c:if test="${sessionScope.loginState==1 || sessionScope.loginState==2}">
							<span style="float:left; color:#A9E2F3">Category</span>
							<c:choose>
								<c:when test="${artDTO.artCategory==1}">
									<input type="text" name="aCategory" required class="single-input" value="Photograph">
								</c:when>
								<c:when test="${artDTO.artCategory==2}">
									<input type="text" name="aCategory" required class="single-input" value="Fine-Art">
								</c:when>
								<c:when test="${artDTO.artCategory==3}">
									<input type="text" name="aCategory" required class="single-input" value="Craft">
								</c:when>
							</c:choose>
							</c:if>
							</div>
							<div class="mt-10">
							<c:if test="${sessionScope.loginState==0}">
							<span style="float:left; color:#A9E2F3">Category</span>
								<c:choose>
									<c:when test="${artDTO.artCategory==1}">
										<div class="form-select" id="category">
											<select name="artCategory">
												<option value="1" selected>Photograph</option>
												<option value="2">Fine-Art</option>
												<option value="3">Craft</option>
											</select>
										</div>
									</c:when>
									<c:when test="${artDTO.artCategory==2}">
										<div class="form-select" id="category">
											<select name="artCategory">
												<option value="1">Photograph</option>
												<option value="2" selected>Fine-Art</option>
												<option value="3">Craft</option>
											</select>
										</div>
									</c:when>
									<c:when test="${artDTO.artCategory==3}">
										<div class="form-select" id="category">
											<select name="artCategory">
												<option value="1">Photograph</option>
												<option value="2">Fine-Art</option>
												<option value="3" selected>Craft</option>
											</select>
										</div>
									</c:when>
								</c:choose><br>
							</c:if>
							</div>
							<div class="mt-10">
							<span style="float:left; color:#A9E2F3">Year(YYYY)</span>
								<input type="text" name="artPrdYear" onkeydown='return onlyNumber(event)' 
								onkeyup='removeChar(event)' maxlength="4" required class="single-input" value="${artDTO.prdYear}">
							</div>
							<div class="mt-10">
							<span style="float:left; color:#A9E2F3">Detail</span>
								<textarea class="single-textarea" name="artDetail" >${artDTO.artDetail}</textarea>
							</div>
							<div>
								<input type="text" name="artSizeHeight" onkeydown='return onlyNumber(event)' 
								onkeyup='removeChar(event)' maxlength="4" required class="single-input" 
								style="width:185px; float:left;" value="${artDTO.artSizeHeight}"/>
								<input type="text" name="artSizeWidth" onkeydown='return onlyNumber(event)' 
								onkeyup='removeChar(event)' maxlength="4" required class="single-input" 
								style="width:185px; float:left;" value="${artDTO.artSizeWidth}"/>
								<input type="text" name="artSizeVol" onkeydown='return onlyNumber(event)' 
								onkeyup='removeChar(event)' maxlength="4" required class="single-input" 
								style="width:200px" value="${artDTO.artSizeVol}"/>
							</div>
							<div class="mt-10">
							<span style="float:left; color:#A9E2F3">EstimateCost</span>
								<input type="text" name="artEstimateCost" onkeydown='return onlyNumber(event)' 
								onkeyup='removeChar(event)' maxlength="9" required class="single-input" value="${artDTO.estimateCost}"/>
							</div>
							<div class="mt-10">
							<c:if test="${sessionScope.loginState==1 || sessionScope.loginState==2}">
							<span style="float:left; color:#A9E2F3">ArtState</span>
							<c:choose>
								<c:when test="${artDTO.artState==1}">
									<input type="text" name="aState" required class="single-input" value="보관중">
								</c:when>
								<c:when test="${artDTO.artState==2}">
									<input type="text" name="aState" required class="single-input" value="경매진행중">
								</c:when>
								<c:when test="${artDTO.artState==3}">
									<input type="text" name="aState" required class="single-input" value="낙찰">
								</c:when>
							</c:choose>
							</c:if>
							</div>
							<div class="mt-10">
							<c:if test="${sessionScope.loginState==0}">
							<span style="float:left; color:#A9E2F3">ArtState</span>
								<c:choose>
									<c:when test="${artDTO.artState==1}">
										<div class="form-select" id="artState">
											<select name="artState">
												<option value="1" selected>보관중</option>
												<option value="2">경매진행중</option>
												<option value="3">낙찰</option>
											</select>
										</div>
									</c:when>
									<c:when test="${artDTO.artState==2}">
										<div class="form-select" id="artState">
											<select name="artState">
												<option value="1">보관중</option>
												<option value="2" selected>경매진행중</option>
												<option value="3">낙찰</option>
											</select>
										</div>
									</c:when>
									<c:when test="${artDTO.artState==3}">
										<div class="form-select" id="artState">
											<select name="artState">
												<option value="1">보관중</option>
												<option value="2">경매진행중</option>
												<option value="3" selected>낙찰</option>
											</select>
										</div>
									</c:when>
								</c:choose>
							</c:if>
							</div><br>
							<c:if test="${sessionScope.loginState==0}">
							<div class="mt-10">
							<span style="float:left; color:#A9E2F3">ImageFile</span>
							<!-- 다운로드&nbsp;&nbsp; -->
								<input type="hidden" name="beforeImg" value="${artDTO.artImg}"> 
								<input type="file" name="artImg" maxlength="60" size="40" class="single-input">
								<%-- <a href='${path}/downLoad?fileName=${art.artImg}'>${art.artImg}</a> --%>
							</div>
							</c:if>
	                        <div class="button-group-area mt-10">
	                       		<c:if test="${sessionScope.loginState==0}">
								<input type="reset" value="내용복구" class="genric-btn success-border circle"/>&nbsp;&nbsp;
								<input type="submit" value="수정완료" class="genric-btn primary-border circle"/>&nbsp;&nbsp;
								</c:if>
								<input type="button" value="뒤로가기" id="back" class="genric-btn success-border circle"/>
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