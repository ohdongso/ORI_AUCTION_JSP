<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!doctype html>
<html>
<head>
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
                                        <a class="dropdown-item" href="${path}/front?key=auction&methodName=selectAuction&aucCategory=2">Zero-Base Auction</a>
                                        <a class="dropdown-item" href="${path}/front?key=auction&methodName=selectAuction&aucCategory=3">Charity Auction</a>
                                    </div>
                                </li>
                                
                                <li class="nav-item dropdown">
                                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown_1"
                                        role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                        Consignment
                                    </a>
                                    <div class="dropdown-menu" aria-labelledby="navbarDropdown_1">
                                        <a class="dropdown-item" href="#">Application</a>
                                        <a class="dropdown-item" href="#">Zero-Base Application</a>
                                        <a class="dropdown-item" href="#">My Consignment</a>
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
                                        <a class="dropdown-item" href="#">1:1 Inquiry</a>
                                        <a class="dropdown-item" href="${path}/front?key=faq&methodName=selectAll">FAQ</a>
                                    </div>
                                </li>
                                
                                <li class="nav-item dropdown">
                                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown_1"
                                        role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                        About
                                    </a>
                                    <div class="dropdown-menu" aria-labelledby="navbarDropdown_1">
                                        <a class="dropdown-item" href="#">Introduce</a>
                                        <a class="dropdown-item" href="#">Donation Activity</a>
                                        <a class="dropdown-item" href="#">Article</a>
                                    </div>
                                </li>
                                
                                <li class="nav-item dropdown">
                                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown_1"
                                        role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                        My Page
                                    </a>
                                    <div class="dropdown-menu" aria-labelledby="navbarDropdown_1">
                                        <a class="dropdown-item" href="#">Liked Arts</a>
                                        <a class="dropdown-item" href="${path}/member/memberInform.jsp">My Information</a>
                                        <a class="dropdown-item" href="#">Withdrawal</a>
                                        <a class="dropdown-item" href="${path}/front?key=bid&methodName=selectAll">My Bidding</a>
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

	<!-- BiddingList Part Start -->
	<div class="whole-wrap">
		<div class="container box_1170">
			<div class="section-top-border" style="padding:150px 0">
				<h3 class="mb-30">TOP BID</h3>
				<div class="progress-table-wrap">
					<div class="progress-table">
						<table class="table table-borderless">
							<thead>
								<tr>
									<th scope="col">응찰코드</th>
									<th scope="col">경매코드</th>
									<th scope="col">응찰자</th>
									<th scope="col">작품코드</th>
									<th scope="col">응찰가</th>
									<th scope="col">응찰일시</th>
									<th scope="col">경매상황</th>
								</tr>
							</thead>
							<tbody>
								<c:choose>
									<c:when test="${empty requestScope.topBid}">
										<tr>
											<td colspan="12">
												<p align="center">
													<b><span style="font-size: 9pt;">등록된 응찰이 없습니다.</span></b>
												</p>
											</td>
										</tr>
									</c:when>
									<c:otherwise>
										<%-- <c:forEach items="${requestScope.bidList}" var="biddingDto"> --%>
											<tr onmouseover="this.style.background='white'"
												onmouseout="this.style.background=''">
												<td bgcolor="">
													<p>
														<span style="font-size: 9pt;">${topBid.bidCode}</span>
													</p>
												</td>
												<td bgcolor="">
													<p>
													
														<span style="font-size: 9pt;">
														<a href="${path}/front?key=bid&methodName=selectTopBid&aucCode=${topBid.aucCode}">
														${topBid.aucCode}</a></span>
													</p>
												</td>
												<td bgcolor="">
													<p>
														<span style="font-size: 9pt;">${topBid.id}</span>
													</p>
												</td>
												<td bgcolor="">
													<p>
														<span style="font-size: 9pt;">
														<a href="${path}/front?key=art&methodName=searchByArtCode&artCode=${topBid.artCode}">
														${topBid.artCode}</a></span>
													</p>
													
													<%-- <p>
														<span style="font-size: 9pt;">${biddingDto.artCode}</span>
													</p> --%>
												</td>
												<td bgcolor="">
													<p>
														<span style="font-size: 9pt;">
														<fmt:formatNumber value="${topBid.bidCost}" />
														</span>
													</p>
												</td>
												<td bgcolor="">
													<p>
														<span style="font-size: 9pt;">${topBid.bidRegDate}</span>
													</p>
												</td>
												<td bgcolor="">
													<!-- <p>
														<span style="font-size: 9pt;">진행중</span>
													</p> -->
												
													<%-- <c:choose>
													<c:when test="${artDto.artState==1}">
														<td bgcolor="">
															<p>
																<span style="font-size: 9pt;">보관중</span>
															</p>
														</td>
													</c:when>
													<c:when test="${artDto.artState==2}">
														<td bgcolor="">
															<p>
																<span style="font-size: 9pt;">경매진행중</span>
															</p>
														</td>
													</c:when>
													<c:when test="${artDto.artState==3}">
														<td bgcolor="">
															<p>
																<span style="font-size: 9pt;">경매종료</span>
															</p>
														</td>
													</c:when>
												</c:choose> --%>
												</td>
											</tr>
										<%-- </c:forEach> --%>
									</c:otherwise>
								</c:choose>
							</tbody>
							<tfoot>
							<c:if test="${sessionScope.loginState==0}">
								<tr><td><a href="${path}/front?key=bid&methodName=selectAll">AllBidList</a></td></tr>
								</c:if>
							</tfoot>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- BiddingList Part End -->

</body>

</html>