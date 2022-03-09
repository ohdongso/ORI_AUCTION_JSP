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
              <%-- <div data-thumb="${path}/art/artImg/dhimg (24).png">
               <img src="${path}/art/artImg/dhimg (24).png"/> --%>
                <div data-thumb="${path}/art/artImg/${art.artImg}">
                <img src="${path}/art/artImg/${art.artImg}"/>
              </div>
            </div>
          </div>
        </div>
        <div id="detail" class="col-lg-5 col-xl-5">
        
          <div class="s_product_text">
            <!-- <h5>previous <span>|</span> next</h5> -->
            <p>
            <h3>${art.artName}</h3>
            <h2><fmt:formatNumber value="${sucBidCost}"/></h2>
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
            <div class="card_area d-flex justify-content-between align-items-center">
            	<form name="pay" method="post" action="${path}/payment/kakaoPay.jsp">
            		<input type="hidden" name="artName" value="${art.artName}"/>
            		<input type="hidden" name="artistName" value="${art.artistName}"/>
            		<input type="hidden" name="sucBidCost" value="${sucBidCost}"/>
            		<input type="hidden" name="sucBidId" value="${sucBidId}"/>
            		<input type="hidden" name="sucBidCode" value="${sucBidCode}"/>
		            <input type="button" id="infobtn" value="결제안내" class="genric-btn success-border circle"
		            style="width:133px; height:47px; font-size: 16px"/>&nbsp;&nbsp;
		            <input type="submit" value="결제하기" class="genric-btn primary circle"
		            style="width:133px; height:47px; font-size: 16px"/>&nbsp;&nbsp;
		            <input type="button" id="back" value="뒤로가기" class="genric-btn success-border circle"
		            style="width:133px; height:47px; font-size: 16px"/>
           		</form>
            </div>
          </div>
          
        </div>
      </div>
    </div>
  </div>
	<div style="margin-bottom: 50px">
		<div class="container">
			<div id="info" style="display: none">
				<div class="row" >
					<div class="col-md-4" >
						<div class="single-defination">
							<h4 class="mb-20" style="font-weight: bold;">낙찰 및 우선 순위</h4>
							<p>추정가 이상으로 최고가를 제시한 응찰자에게 경매작품이 낙찰되며, 동일 금액의 경우 서버에 기록된 시간을
								기준으로 응찰 시점이 앞선 응찰자가 낙찰 우선순위가됩니다.</p>
						</div>
					</div>
					<div class="col-md-4">
						<div class="single-defination">
							<h4 class="mb-20" style="font-weight: bold;">낙찰 확인</h4>
							<p>낙찰자는 낙찰을 철회할 수 없습니다. 부득이 철회를 하는 경우에는 
							낙찰일로부터 7일 이내에 서면으로 철회의사를 통보하고, 낙찰가의
								30%에 해당하는 금액을 낙찰일로부터 7일 이내에 납부하여야 합니다.</p>
						</div>
					</div>
					<div class="col-md-4">
						<div class="single-defination">
							<h4 class="mb-20" style="font-weight: bold;">결제 안내</h4>
							<p>낙찰자는 경매후 7일 이내에 구매수수료를 포함한 금액을 입금하신 후 
							작품을 인수하시기 바랍니다. 낙찰자는 총 구매대금을 당사 지정의
								은행계정송금, 자기앞수표, 현금 등으로 지불할 수 있습니다.</p>
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