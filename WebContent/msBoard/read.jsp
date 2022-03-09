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
<script type="text/javascript" src="${path}/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
   $(function() {
            $("button[id^=mbtn]").click(function() {
               $('form[id=mtext'+this.id+']').toggle();
            })

            $("#toList")
                  .click(
                        function() {
                           location.href = "${path}/front?key=board&methodName=selectAll";
                        })
                        
            $("#delete")
                  .click(
                        function() {
                           if (confirm("글을 삭제하시겠습니까?")) {
                              if ("${board.id}" == "${sessionScope.loginUser}" ) {
                                 location.href = "${path}/front?key=board&methodName=delete&boardCode=${board.boardCode}&id=${sessionScope.loginUser}";
                                 
                              } else {
                                 alert("작성자만 글을 삭제할 수 있습니다.");
                              }
                           }
                        })            
            
         })
         
   $(document).on("submit", "#update", function() {
               if ("${board.id}" != "${sessionScope.loginUser}") {
                  alert("작성자만 글을 수정할 수 있습니다.");
                  return false;
               } else {
                  return true;
               }
            })      
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
   <!--================Blog Area =================-->
   <section class="blog_area single-post-area padding_top">
      <div class="container">
         <div>
            <div align="left" class="col">
               <h1>${board.boardTitle}</h1>
            </div>
            <div align="right" class="col">
               <h5>views :&nbsp;${board.views}</h5>
            </div>
         </div>
         <hr>
         <div class="row">            
            <div class="col-lg-8 posts-list">
               <div class="single-post">
                  <div class="blog-author"
                     style="margin-top: 0px; padding: 20px 20px; margin-bottom: 0px"
                     align="left">
                     <div class="media">
                        <div class="media-body">
                           <ul class="list cat-list">
                        <li>
                           <p>No :&nbsp;${board.boardCode}</p>
                        </li>
                        <li>
                           <p>Category :&nbsp;${board.boardCategory}</p>
                        </li>
                        <li>
                           <p>Id :&nbsp;${board.id}</p>
                        </li>
                        
                        <li>
                           <p>첨부파일 :&nbsp;<a href="${path}/downLoad?fileName=${board.file}">${board.file}</a> </p>
                        </li>                        
                     </ul>
                        </div>
                     </div>
                  </div>                  
                  
               </div>
            </div>
         </div>

         <hr>
         <h3 style="font-family:ITC Grouch">Content</h3>
         <div class="blog-author" style="margin-top: 0px; padding: 20px 15px">
            <div class="media align-items-center">
               <div class="media-body">
                  <textarea name="boardContent" class="single-textarea"
                     placeholder="Write board here" onfocus="this.placeholder = ''"
                     onblur="this.placeholder = 'Write board here'" required=""
                     style="height: 300px" readonly="readonly">${board.boardContent}</textarea>
                     <div align="right">
                     <form id="update" action="${path}/msBoard/update.jsp"
                        method="post">      
                        <input type="hidden" name="boardCode"
                           value="${board.boardCode}" />
                        <input type="hidden" name="file" value="${board.file}" /> 
                        <input type="hidden"name="boardTitle" value="${board.boardTitle}" />
                        <input type="hidden" name="boardCategory" value="${board.boardCategory}" />
                        <input type="hidden" name="boardContent" value="${board.boardContent}" />
                        <button type="submit" id="modify">Modify</button>
                        <button type="button"  id="delete">Delete</button>
                        
                     </form>
                     
                  </div>
               </div>
            </div>
         </div>
         <div align="right">
            <a href="${path}/front?key=board&methodName=selectAll"
               style="font-family: ITC Grouch; font-size: 18px">Back to list</a>
         </div>
         <div class="comment-form">
            <h3 style="font-family: ITC Grouch">Comments(${fn:length(requestScope.board.reply)})</h3>
            <c:forEach items="${requestScope.board.reply}" var="reply">
               <div class="blog-author"
                  style="margin-top: 10px; padding: 20px 15px">
                  <div class="media align-items-center">
                     <div class="media-body">
                        <h5>${reply.id}</h5>
                        <h6>${reply.boardReplyContent}</h6>
                     </div>
                     <div align="right">
                        <h6>${reply.boardReplyRdate}</h6>
                        <c:if test="${sessionScope.loginUser==reply.id}">
                           <div>
                              <form action="${path}/front?key=board&methodName=deleteReply" method="post">
                                 <input type="hidden" name="boardCode" value="${board.boardCode}">
                                 <input type="hidden" name="id" value="${sessionScope.loginUser}">
                                 <input type="hidden" name="boardReplyCode" value="${reply.boardReplyCode}">
                                 <button id="mbtn${reply.boardReplyCode}" type="button"
                                       class="genric-btn info-border circle">modify</button>
                                 <button type="submit" class="genric-btn primary-border circle">delete</button>
                              </form>
                           </div>
                        </c:if>
                     </div>
                  </div>
                  <c:if test="${sessionScope.loginUser==reply.id}">
                     <div>
                        <form id="mtextmbtn${reply.boardReplyCode}"
                           class="mform"
                           action="${path}/front?key=board&methodName=updateReply"
                           method="post" style="display: none">
                           <input type="hidden" name="boardReplyCode" value="${reply.boardReplyCode}"> 
                           <input type="hidden" name="boardCode" value="${board.boardCode}"> 
                           <input type="text" name="boardReplyContent" style="width: 900px">
                           <button type="submit" class="genric-btn default-border circle">OK</button>
                        </form>
                     </div>
                  </c:if>
               </div>
            </c:forEach>

            <form class="form-contact comment_form"
               action="${path}/front?key=board&methodName=insertReply"
               method="post">
               <div class="row">
                  <div class="col-12" style="margin-top: 10px">
                     <div class="form-group">
                        <textarea class="form-control w-100" name="replyContent"
                           id="comment" cols="30" rows="9" placeholder="Write Comment"></textarea>
                        <input type="hidden" name="id" value="${sessionScope.loginUser}">
                        <input type="hidden" name="boardCode"
                           value="${board.boardCode}" />
                           
                     </div>
                  </div>
               </div>
               <div class="form-group mt-3" align="right">
                  <button type="submit" id="modify">Reply
                     Submit</button>
               </div>
            </form>
         </div>
      </div>
   </section>
   <!--================Blog Area end =================-->
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