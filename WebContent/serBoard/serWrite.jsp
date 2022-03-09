<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
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
<style>
#oti{font-family:ITC Grouch; text-align: center; }
  	 #modify{font-family: ITC Grouch; background-color: yellow; color:blak;
   align:right; border:0; outline:0; padding:10px 30px; font-size: 15px; }
   #delete{font-family: ITC Grouch; background-color: black; color:yellow; 
   align:right; border:0; outline:0; padding:10px 25px; font-size: 15px; }
</style>
<meta charset="UTF-8">
<title>Ori Auction</title>
<script type="text/javascript" src="../js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	

	function checkValid() {
		
		var f = window.document.writeForm;
		
		if (f.boardTitle.value == "") {
			alert("제목을 입력하세요.");		
			f.boardTitle.focus();
			return false;
		}
		if (f.boardContent.value == "") {
			alert("내용을 입력하세요.");
			f.boardContent.focus();
			return false;
		}
		if (f.boardCategory.value == "Category") {
			alert("카테고리를 입력하세요.");
			
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


	
	
	<section class="cat_product_area section_padding">
		<div class="section-top-border" align="center">
			<div class="col-lg-8 col-md-8">
				<h1 id="oti">1:1 Inquiry Form</h1>
				<form name="writeForm" method="post" action="${path}/front"
					onSubmit='return checkValid()' >
					<input type="hidden" name="key" value="sb">
					<input type="hidden" name="methodName" value="insert">
					<div class="mt-10">
						<input type="text" name="serviceBoardTitle" placeholder="Title"
							id ="boardTitle"
							onfocus="this.placeholder = ''"
							onblur="this.placeholder = 'Title'" required=""
							class="single-input" >
					</div>
					
					<hr>
					<h6>Category</h6>
					<div class="mt-10">
						<select  name="serviceBoardCategory"
							style="width: 100%; font-size: 15px" class="single-input" >
							<option value="Category">Category</option>
							<option value="1">회원정보</option>
							<option value="2">경매</option>
							<option value="3">위탁</option>
							<option value="4">배송</option>
							<option value="5">기부</option>
							<option value="6">기타</option>
							
						</select>
					</div>
					<hr>
					<div class="mt-10">
						<textarea name="serviceBoardContent" class="single-textarea"
							placeholder="CONTENT" onfocus="this.placeholder = ''"
							onblur="this.placeholder = 'CONTENT'" required=""
							style="height: 300px"> </textarea>
					</div>
					
					
					<div align="right">
						<button type="submit" id="modify">Submit</button>
					</div>
				</form>
			</div>
		</div>
	</section>

</body>

</html>