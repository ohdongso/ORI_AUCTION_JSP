<!doctype html>
<html lang="zxx">

<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>OriAuction</title>
    <link rel="icon" href="../img/favicon.png">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <!-- animate CSS -->
    <link rel="stylesheet" href="../css/animate.css">
    <!-- owl carousel CSS -->
    <link rel="stylesheet" href="../css/owl.carousel.min.css">
    <!-- font awesome CSS -->
    <link rel="stylesheet" href="../css/all.css">
    <!-- flaticon CSS -->
    <link rel="stylesheet" href="../css/flaticon.css">
    <link rel="stylesheet" href="../css/themify-icons.css">
    <!-- font awesome CSS -->
    <link rel="stylesheet" href="../css/magnific-popup.css">
    <!-- swiper CSS -->
    <link rel="stylesheet" href="../css/slick.css">
    <!-- style CSS -->
    <link rel="stylesheet" href="../css/style.css">
	   
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
		</style>
		
    	 <script type="text/javascript">
    	 	function goUrl(url) {
				location.href=url;
			}
    	 	//회원가입 폼 체크
    	 	function joinFormCheck() {
				var form = document.memberJoin;
			
    	 		if(form.id.value==''||form.id.value==null){
    	 			alert("아이디를 입력해주세요.")
    	 			form.id.focus();
    	 			return false
    	 		}
    	 		if(form.pw.value==''||form.pw.value==null){
    	 			alert("비밀번호를 입력해주세요.")
    	 			form.pw.focus();
    	 			return false
    	 		}
    	 		if(form.name.value==''||form.name.value==null){
    	 			alert("성함을 입력해주세요.")
    	 			form.name.focus();
    	 			return false
    	 		}
    	 		if(form.account.value==''||form.account.value==null){
    	 			alert("회원님의 계좌를 입력해주세요.")
    	 			form.account.focus();
    	 			return false
    	 		}
    	 		if(form.addr.value==''||form.addr.value==null){
    	 			alert("주소를 입력해주세요.")
    	 			form.addr.focus();
    	 			return false
    	 		}
    	 		if(form.contact.value==''||form.contact.value==null){
    	 			alert("연락처를 입력해주세요.")
    	 			form.contact.focus();
    	 			return false
    	 		}
    	 		if(form.email.value==''||form.contact.value==null){
    	 			alert("이메일 입력해주세요.")
    	 			form.contact.focus();
    	 			return false
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
                       <a class="navbar-brand" href="mainPage.jsp"> <img src="../img/mainLogo.png" alt="logo" id="mainLogo"> </a>
                        <button class="navbar-toggler" type="button" data-toggle="collapse"
                            data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                            aria-expanded="false" aria-label="Toggle navigation">
                            <span class="menu_icon"><i class="fas fa-bars"></i></span>
                        </button>

                        <div class="collapse navbar-collapse main-menu-item" id="navbarSupportedContent">
                            <ul class="navbar-nav">
                                <li class="nav-item">
                                    <a class="nav-link" href="mainPage.jsp">HOME</a>
                                </li>
                                <li class="nav-item dropdown">
                                    <a class="nav-link dropdown-toggle" href="../blog.html" id="navbarDropdown_1"
                                        role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                        Member Service
                                    </a>
                                    <div class="dropdown-menu" aria-labelledby="navbarDropdown_1">
                                        <a class="dropdown-item" href="login.jsp"> LogIn</a>
                                        <a class="dropdown-item" href="join.jsp">Join</a>
                                        <a class="dropdown-item" href="memberInform.jsp">My Page</a>
                                        
                                    </div>
                                </li>
                               <li class="nav-item dropdown">
                                    <a class="nav-link dropdown-toggle" href="../blog.html" id="navbarDropdown_1"
                                        role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                        Auctions
                                    </a>
                                    <div class="dropdown-menu" aria-labelledby="navbarDropdown_1">
                                        <a class="dropdown-item" href="../category.html"> Auction</a>
                                        <a class="dropdown-item" href="../single-product.html">Consignment</a>
                                        
                                    </div>
                                </li>
                               <li class="nav-item dropdown">
                                    <a class="nav-link dropdown-toggle" href="../blog.html" id="navbarDropdown_1"
                                        role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                        About
                                    </a>
                                    <div class="dropdown-menu" aria-labelledby="navbarDropdown_1">
                                        <a class="dropdown-item" href="../category.html"> Articles</a>
                                        <a class="dropdown-item" href="../single-product.html">Donation</a>
                                        
                                    </div>
                                </li>
                                
                                <li class="nav-item dropdown">
                                    <a class="nav-link dropdown-toggle" href="../blog.html" id="navbarDropdown_1"
                                        role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                        Board 
                                    </a>
                                    <div class="dropdown-menu" aria-labelledby="navbarDropdown_1">
                                        <a class="dropdown-item" href="../category.html"> Review</a>
                                        <a class="dropdown-item" href="../single-product.html">FAQ</a>
                                        <a class="dropdown-item" href="../single-product.html">Artist</a>
                                        
                                    </div>
                                </li>
                            </ul>
                        </div>
                        <div class="hearer_icon d-flex">
                            <a id="search_1" href="javascript:void(0)"><i class="ti-search"></i></a>
                            <a href=""><i class="ti-heart"></i></a>  
                            </div>
                        </div>
                   
                </div>
            </div>
       
        <div class="search_input" id="search_input_box">
            <div class="container ">
                <form class="d-flex justify-content-between search-inner">
                    <input type="text" class="form-control" id="search_input" placeholder="Search Here">
                    <button type="submit" class="btn"></button>
                    <span class="ti-close" id="close_search" title="Close Search"></span>
                </form>
             </div>
        </div>
    </header>
    
    <!-- Header part end-->


    <!--================join_part Area =================-->
    
    <section class="joing_part padding_top">
    	<h2 id="joinTitle">Create New Customer Account!</h2><hr>
    </section>
    <!--================join_part end =================-->
    <section class="join form">
        <div style="margin:auto;text-align:center;">
        	<form name=joinForm style="display:inline-block;" action="${path}/front?key=member&methodName=memberJoin" method=post onsubmit="joinFormCheck()">
				<input type="text" class="underline" type="text" placeholder="ID" id="id" name="id"> <br><br>
				<input type="text" class="underline" type="text" placeholder="PASSWORD" id="pw" name="pw"> <br><br>
				<input type="text" class="underline" type="text" placeholder="NAME" id="name" name="name"> <br><br>
				<input type="text" class="underline" type="text" placeholder="ACCOUNT" id="account" name="account"> <br><br>
				<input type="text" class="underline" type="text" placeholder="ADDRESS" id="addr" name="addr"> <br><br>
				<input type="text" class="underline" type="text" placeholder="CONTACT" id="contact" name="contact"> <br><br>
				<input type="text" class="underline" type="text" placeholder="E-MAIL" id="email" name="email"> <br><br>
				
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
                        <h4>Top Products</h4>
                        <ul class="list-unstyled">
                            <li><a href="">Managed Website</a></li>
                            <li><a href="">Manage Reputation</a></li>
                            <li><a href="">Power Tools</a></li>
                            <li><a href="">Marketing Service</a></li>
                        </ul>
                    </div>
                </div>
                <div class="col-sm-6 col-lg-2">
                    <div class="single_footer_part">
                        <h4>Quick Links</h4>
                        <ul class="list-unstyled">
                            <li><a href="">Jobs</a></li>
                            <li><a href="">Brand Assets</a></li>
                            <li><a href="">Investor Relations</a></li>
                            <li><a href="">Terms of Service</a></li>
                        </ul>
                    </div>
                </div>
                <div class="col-sm-6 col-lg-2">
                    <div class="single_footer_part">
                        <h4>Features</h4>
                        <ul class="list-unstyled">
                            <li><a href="">Jobs</a></li>
                            <li><a href="">Brand Assets</a></li>
                            <li><a href="">Investor Relations</a></li>
                            <li><a href="">Terms of Service</a></li>
                        </ul>
                    </div>
                </div>
                <div class="col-sm-6 col-lg-2">
                    <div class="single_footer_part">
                        <h4>Resources</h4>
                        <ul class="list-unstyled">
                            <li><a href="">Guides</a></li>
                            <li><a href="">Research</a></li>
                            <li><a href="">Experts</a></li>
                            <li><a href="">Agencies</a></li>
                        </ul>
                    </div>
                </div>
                <div class="col-sm-6 col-lg-4">
                    <div class="single_footer_part">
                        <h4>Newsletter</h4>
                        <p>Heaven fruitful doesn't over lesser in days. Appear creeping
                        </p>
                        <div id="mc_embed_signup">
                            <form target="_blank"
                                action="https://spondonit.us12.list-manage.com/subscribe/post?u=1462626880ade1ac87bd9c93a&amp;id=92a4423d01"
                                method="get" class="subscribe_form relative mail_part">
                                <input type="email" name="email" id="newsletter-form-email" placeholder="Email Address"
                                    class="placeholder hide-on-focus" onfocus="this.placeholder = ''"
                                    onblur="this.placeholder = ' Email Address '">
                                <button type="submit" name="submit" id="newsletter-submit"
                                    class="email_icon newsletter-submit button-contactForm">subscribe</button>
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
                            <P><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made by <a href="https://colorlib.com" target="_blank"> Team ORI AUCTION</a>
<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. --></P>
                        </div>
                    </div>
                    <div class="col-lg-4">
                        <div class="footer_icon social_icon">
                            <ul class="list-unstyled">
                                <li><a href="#" class="single_social_icon"><i class="fab fa-facebook-f"></i></a></li>
                                <li><a href="#" class="single_social_icon"><i class="fab fa-twitter"></i></a></li>
                                <li><a href="#" class="single_social_icon"><i class="fas fa-globe"></i></a></li>
                                <li><a href="#" class="single_social_icon"><i class="fab fa-behance"></i></a></li>
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
    <script src="../js/jquery-1.12.1.min.js"></script>
    <!-- popper js -->
    <script src="../js/popper.min.js"></script>
    <!-- bootstrap js -->
    <script src="../js/bootstrap.min.js"></script>
    <!-- easing js -->
    <script src="../js/jquery.magnific-popup.js"></script>
    <!-- swiper js -->
    <script src="../js/swiper.min.js"></script>
    <!-- swiper js -->
    <script src="../js/masonry.pkgd.js"></script>
    <!-- particles js -->
    <script src="../js/owl.carousel.min.js"></script>
    <script src="../js/jquery.nice-select.min.js"></script>
    <!-- slick js -->
    <script src="../js/slick.min.js"></script>
    <script src="../js/jquery.counterup.min.js"></script>
    <script src="../js/waypoints.min.js"></script>
    <script src="../js/contact.js"></script>
    <script src="../js/jquery.ajaxchimp.min.js"></script>
    <script src="../js/jquery.form.js"></script>
    <script src="../js/jquery.validate.min.js"></script>
    <script src="../js/mail-script.js"></script>
    <script src="../js/stellar.js"></script>
    <script src="../js/price_rangs.js"></script>
    <!-- custom js -->
    <script src="../js/custom.js"></script>
</body>

</html>