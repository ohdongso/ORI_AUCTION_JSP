<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <title>ORI AUCTION</title>
  <link rel="icon" href="${path}/img/favicon.png">
  <!-- Bootstrap CSS -->
  <link rel="stylesheet" href="${path}/css/bootstrap.min.css">
  <!-- animate CSS -->
  <link rel="stylesheet" href="${path}/css/animate.css">
  <!-- owl carousel CSS -->
  <link rel="stylesheet" href="${path}/css/owl.carousel.min.css">
  <link rel="stylesheet" href="${path}/css/lightslider.min.css">
  <!-- font awesome CSS -->
  <link rel="stylesheet" href="${path}/css/all.css">
  <!-- flaticon CSS -->
  <link rel="stylesheet" href="${path}/css/flaticon.css">
  <link rel="stylesheet" href="${path}/css/themify-icons.css">
  <!-- font awesome CSS -->
  <link rel="stylesheet" href="${path}/css/magnific-popup.css">
  <!-- style CSS -->
  <link rel="stylesheet" href="${path}/css/style.css">

<script type="text/javascript" src="${path}/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">

	$(function() {
		var menu_flag = true;
		$("#infobtn").click(function() {
			if(menu_flag) {
				$("#img").animate({"top" : "-=80px"}, "slow");
				$("#detail").animate({"top" : "-=80px"}, "slow");
				$("#info").slideDown();
				menu_flag = false;
	
			} else {
				$("#img").animate({"top" : "+=80px"}, "slow");
				$("#detail").animate({"top" : "+=80px"}, "slow");
				$("#info").slideUp();
				menu_flag = true;
			}
		});
		
		$("#back").click(function() {
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
                                        <a class="dropdown-item" href="${path}/front?key=donation&methodName=selectAll">Donation Activity</a>
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

<!--================Single Product Area =================-->
  <div style="margin-top:180px">
    <div class="container">
      <div class="row s_product_inner justify-content-between">
        <div id="img" class="col-lg-7 col-xl-7">
          <div class="product_slider_img">
            <div id="vertical">
              <img src="${path}/art/artImg/${art.artImg}"/>
            </div>
          </div>
        </div>
        <div id="detail" class="col-lg-5 col-xl-5">
        
          <div class="s_product_text">
            <!-- <h5>previous <span>|</span> next</h5> -->
            <p>
            <h3>${art.artName}</h3>
            <span>e.cost</span>
            <h2><fmt:formatNumber value="${art.estimateCost}"/></h2>
            <ul class="list">
              <li>
                  <span>Category</span> :&nbsp;&nbsp; 
                  <c:choose>
					<c:when test="${art.artCategory==1}">Photograph</c:when>
					<c:when test="${art.artCategory==2}">FineArt</c:when>
					<c:when test="${art.artCategory==3}">Craft & Sculpture</c:when>
				</c:choose>
              </li>
              <li>
                <span>Artist</span> :&nbsp;&nbsp;&nbsp;${art.artistName}
              </li>
            </ul>
            <p>
            	${art.artSizeHeight}&nbsp;cm&nbsp;&nbsp;×&nbsp;&nbsp;
            	${art.artSizeWidth}&nbsp;cm&nbsp;&nbsp;×&nbsp;&nbsp;
            	${art.artSizeVol}&nbsp;cm<br>
            	${art.artDetail}
            </p>
            <div class="card_area d-flex align-items-center">
            
	           <input type="button" id="infobtn" value="INFO" class="genric-btn success-border circle"
	            style="width:133px; height:47px; font-size:16px"/>&nbsp;&nbsp;&nbsp;&nbsp;
	            <c:if test="${sessionScope.loginState==0}">
	            <a href="${path}/front?key=art&methodName=updateForm&artCode=${art.artCode}" class="genric-btn primary circle"
	            style="width:133px; height:47px; font-size:16px">UPDATE</a>&nbsp;&nbsp;&nbsp;&nbsp;
	            </c:if>
	            <input type="button" id="back" value="LIST" class="genric-btn success-border circle"
	            style="width:133px; height:47px; font-size:16px"/>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
	<div style="margin-bottom:50px">
		<div class="container">
			<div id="info" style="display: none">
				<div class="row" >
					<div class="col-md-4" >
						<div class="single-defination">
							<h4 class="mb-20" style="font-weight: bold;">추정가 (Estimate Cost)</h4>
							<p>위탁 등록된 작품에 대한 대략적인 감정가격으로 추정가의 60%를 응찰 시작가로 책정합니다.</p>
						</div>
					</div>
					<div class="col-md-4">
						<div class="single-defination">
							<h4 class="mb-20" style="font-weight: bold;">작품 규격 (SIZE)</h4>
							<p>사진, 회화 등 평면 작품의 경우 '너비 X 높이 X 프레임두께'로 표현하고,
							입체 작품의 경우 '너비 X 높이 X 작품두께(Vol)'로 표현합니다.</p>
						</div>
					</div>
					<div class="col-md-4">
						<div class="single-defination">
							<h4 class="mb-20" style="font-weight: bold;">작품의 감정과 보관</h4>
							<p>감정 전문 스페셜리스트들을 통하여 작품의 컨디션과 위작 여부가 엄격하게 분석되며 
							감정에 통과한 작품들은 당사 수장고에 안전하게 보관됩니다.</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div style="margin: 50px">
	</div>
	<!--================End Single Product Area =================-->

</body>
</html>