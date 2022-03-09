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
  #mainLogo{width:250px; height:45px}
    @import url(//db.onlinewebfonts.com/c/537c29c4b78689a51f1c48cd802a503f?family=ITC+Grouch);
    @import url(//db.onlinewebfonts.com/c/789f9065baf48309d73fd0ff02fe4aec?family=Big+Caslon+Black);
    @import url('https://fonts.googleapis.com/css2?family=Archivo:wght@100&display=swap');
    .dropdown-item{font-family: ITC Grouch;}
    #banana{font-family:ITC Grouch; text-align: center}
    h2, h3, h4, h5, h6, p{font-family: adobe-caslon-pro, serif; font-style: normal; font-weight: 700}
    #mainSample1{width:580px; height:400px}
    #artTypes{font-family: 'Archivo', sans-serif; color:#2E64FE;}
   #title{font-family:ITC Grouch;}
   p{text-align: center;}
   #modify{font-family: ITC Grouch; background-color: yellow; 
   border:0; outline:0; padding:10px 30px; font-size: 15px; }
   #delete{font-family: ITC Grouch; background-color: black; color:yellow;
   border:0; outline:0; padding:10px 30px; font-size: 15px; }
    .delete{font-family:ITC Grouch; color:black;}
    #oti{text-align: center; font-family:ITC Grouch; font-size: 100px; color:white;}
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
											href="${path}/front?key=auction&methodName=selectAuction&aucCategory=2">Zero-Base
											Auction</a> <a class="dropdown-item"
											href="${path}/front?key=auction&methodName=selectAuction&aucCategory=3">Charity
											Auction</a>
									</div></li>

								<li class="nav-item dropdown"><a
									class="nav-link dropdown-toggle" href="#" id="navbarDropdown_1"
									role="button" data-toggle="dropdown" aria-haspopup="true"
									aria-expanded="false"> Consignment </a>
									<div class="dropdown-menu" aria-labelledby="navbarDropdown_1">
										<a class="dropdown-item" href="#">Application</a> <a
											class="dropdown-item" href="#">Zero-Base Application</a> <a
											class="dropdown-item" href="#">My Consignment</a>
										<c:if test="${sessionScope.loginState==0}">
											<a class="dropdown-item" href="#">Consignment List</a>
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
											Board</a> <a class="dropdown-item" href="#">1:1 Inquiry</a> <a
											class="dropdown-item"
											href="${path}/front?key=faq&methodName=selectAll">FAQ</a>
									</div></li>

								<li class="nav-item dropdown"><a
									class="nav-link dropdown-toggle" href="#" id="navbarDropdown_1"
									role="button" data-toggle="dropdown" aria-haspopup="true"
									aria-expanded="false"> About </a>
									<div class="dropdown-menu" aria-labelledby="navbarDropdown_1">
										<a class="dropdown-item" href="#">Introduce</a> <a
											class="dropdown-item" href="#">Donation Activity</a> <a
											class="dropdown-item"
											href="${path}/front?key=article&methodName=selectAll">Article</a>
									</div></li>

								<li class="nav-item dropdown"><a
									class="nav-link dropdown-toggle" href="#" id="navbarDropdown_1"
									role="button" data-toggle="dropdown" aria-haspopup="true"
									aria-expanded="false"> My Page </a>
									<div class="dropdown-menu" aria-labelledby="navbarDropdown_1">
										<a class="dropdown-item" href="#">Liked Arts</a> <a
											class="dropdown-item"
											href="${path}/front?key=member&methodName=myInform">My
											Information</a> <a class="dropdown-item"
											href="${path}/artist/registArtist.jsp">Artist Service</a> <a
											class="dropdown-item" href="${path}/artist/artistList.jsp">Artist
											List</a> <a class="dropdown-item" href="#">My Bidding</a>
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
		
				<h1 style="font-family: ITC Grouch; text-align: center">Update board</h1>
				<form name="writeForm" method="post"
					action="${path}/front?key=board&methodName=update"
					onSubmit='return checkValid()'
					enctype="multipart/form-data"
					>
					<input type="hidden" name="boardCode" value="${param.boardCode}">
					<input type="hidden" name="id" value="${sessionScope.loginUser}">
					<div class="mt-10">
						<input type="text" name="boardTitle" placeholder="Title"
							onfocus="this.placeholder = ''"
							onblur="this.placeholder = 'Title'" required=""
							class="single-input" value="${param.boardTitle}">
					</div>
					
					<hr>
					<h4 style="font-family: ITC Grouch;">Category</h4>
					<input type="hidden" name="Category" value="${sessionScope.loginUser}">
					<div class="mt-10">
						<select id="selectRate" name="boardCategory"
							style="width: 100%; font-size: 15px" class="single-input" >
							<option value="${param.boardCategory}">등록된 카테고리 : ${param.boardCategory}</option>
							<option value="1">1.질문</option>
							<option value="2">2.일반</option>
							<option value="3">3.정보</option>
							
						</select>
					</div>
					<hr>
					<div class="mt-10">
						<textarea name="boardContent" class="single-textarea"
							placeholder="Write board here" onfocus="this.placeholder = ''"
							onblur="this.placeholder = 'Write board here'" required=""
							style="height: 300px">${param.boardContent} </textarea>
					</div>
					<div class="mt-10">
						등록되어있는 파일 : ${param.file}
						<input type="hidden" name="beforeFile" value="${param.file}">
						<input type="file" name="file"  class="single-input" value="${param.file}">
					</div>
					<div>
						<hr>
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