<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
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
   #title{font-family:ITC Grouch;}
    .table{text-align: center;}
    #oti{font-family:ITC Grouch; font-size: 100px}
     #form{font-family:ITC Grouch;}
     #aa{font-family:ITC Grouch;}
     #btn{font-family: ITC Grouch; background-color: yellow; 
   border:0; outline:0; padding:10px 30px; font-size: 15px; }
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
<script type="text/javascript" src="../js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#selectRate")
				.on(
						"change",
						function() {
							var temp = $("#selectRate").val()
							if (temp != "rate") {
								$("#rateview")
										.html(
												"<img src='${path}/img/rate_icon/rate"+temp+".png'>")
							} else {
								$("#rateview").html("");
							}
						});
	});

	function checkValid() {
		var f = window.document.writeForm;

		if (f.reviewTitle.value == "") {
			alert("제목을 입력하세요.");
			f.reviewTitle.focus();
			return false;
		}
		if (f.reviewContent.value == "") {
			alert("내용을 입력하세요.");
			f.reviewContent.focus();
			return false;
		}
		if (f.reviewRate.value == "rate") {
			alert("평가를 입력하세요.");
			return false;
		}
		if(f.artCode.value=="none"||f.artCode.value=="default"){
			alert("리뷰할 작품을 선택하세요.");
			return false;
		}
		
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
	
	
	
	
	<section class="cat_product_area section_padding">
		<div class="section-top-border" align="center">
			<div class="col-lg-8 col-md-8">
				<h2 id="form">Review Form</h2>
				<form name="writeForm" method="post"
					action="${path}/front?key=review&methodName=insert"
					onSubmit='return checkValid()'>
					<div class="mt-10">
						<input type="text" name="reviewTitle" placeholder="Title"
							onfocus="this.placeholder = ''"
							onblur="this.placeholder = 'Title'" required=""
							class="single-input">
					</div>
					<hr>
					<h6 id="aa">Select Art For Review</h6>
					<div class="mt-10">
						<select name="artCode" style="width: 100%; font-size: 15px"
							class="single-input">
							<option value="default" id="sdf">리뷰할 작품 선택</option>
							<c:choose>
								<c:when test="${empty artList}">
									<option value="none" id="sdf">낙찰된 작품이 없습니다.</option>
								</c:when>
								<c:otherwise>
									<c:forEach items="${artList}" var="art">
										<option value="${art.artCode}">${art.artName}</option>
									</c:forEach>
								</c:otherwise>
							</c:choose>
						</select>
					</div>
					<hr>
					<h6 id="aa">Rate Your Art</h6>
					<input type="hidden" name="id" value="${sessionScope.loginUser}">
					<div class="mt-10">
						<select id="selectRate" name="reviewRate"
							style="width: 100%; font-size: 15px" class="single-input">
							<option value="rate">Rate</option>
							<option value="0">0 point</option>
							<option value="1">1 point</option>
							<option value="2">2 point</option>
							<option value="3">3 point</option>
							<option value="4">4 point</option>
							<option value="5">5 point</option>
							<option value="6">6 point</option>
							<option value="7">7 point</option>
							<option value="8">8 point</option>
							<option value="9">9 point</option>
							<option value="10">10 point</option>
						</select>
					</div>
					<div id="rateview"></div>
					<div class="mt-10">
						<textarea name="reviewContent" class="single-textarea"
							placeholder="Write review here" onfocus="this.placeholder = ''"
							onblur="this.placeholder = 'Write review here'" required=""
							style="height: 300px"></textarea>
					</div>
					<div>
						<hr>
					</div>
					<div align="right">
						<button type="submit"id="btn">Submit</button>
					</div>
				</form>
			</div>
		</div>
	</section>
</body>
</html>