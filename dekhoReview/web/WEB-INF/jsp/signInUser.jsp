
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


  <%
            /*disable page caching of pages by browser */
            response.setHeader("Cache-Control", "no-cache"); //HTTP 1.1
            response.setHeader("Pragma", "no-cache"); //HTTP 1.0
            response.setDateHeader("Expires", 0); //prevents caching at the proxy server
            response.setContentType("text");
            response.setCharacterEncoding("UTF-8");
     %>
 <!DOCTYPE html>
 
<html>
	<head>
		<title>PicMaza.com</title>
		<meta charset="utf-8">
		<meta name="viewport" content="width=1120,user-scalable=no" />
		<meta name="description" content="" />
		<meta name="keywords" content="" />
		<link href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400" rel="stylesheet" type="text/css" />
		<script src="js/html5shiv.js"></script>
		<script src="js/jquery.min.js"></script>
		<script src="js/jquery.poptrox.min.js"></script>
		<script src="js/config.js"></script>
		<script src="js/skel.min.js"></script>
		<style>
	.myButton {
    box-shadow: 1px 0px 0px -7px #E67A73 inset;
    background: linear-gradient(to bottom, #EDDCDA 5%, #E02020 100%) repeat scroll 0% 0% #EDDCDA;
    border-radius: 38px;
    border: 1px solid #9C8861;
    display: inline-block;
    cursor: pointer;
    font-family: arial;
    font-size: 15px;
    font-weight: bold;
    padding: 0px 22px;
    text-decoration: none;
    text-shadow: 0px -12px 27px #B23E35;
}
.myButton:hover {
	background:-webkit-gradient(linear, left top, left bottom, color-stop(0.05, #e02020), color-stop(1, #eddcda));
	background:-moz-linear-gradient(top, #e02020 5%, #eddcda 100%);
	background:-webkit-linear-gradient(top, #e02020 5%, #eddcda 100%);
	background:-o-linear-gradient(top, #e02020 5%, #eddcda 100%);
	background:-ms-linear-gradient(top, #e02020 5%, #eddcda 100%);
	background:linear-gradient(to bottom, #e02020 5%, #eddcda 100%);
	filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#e02020', endColorstr='#eddcda',GradientType=0);
	background-color:#e02020;
}
.myButton:active {
	position:relative;
	top:1px;
}

       
		</style>
		
		<noscript>
			<link rel="stylesheet" href="css/skel-noscript.css" />
			<link rel="stylesheet" href="css/style.css" />
			<link rel="stylesheet" href="css/style-desktop.css" />
			<link rel="stylesheet" href="css/style-noscript.css" />
		</noscript>
		<!--[if lte IE 8]><link rel="stylesheet" href="css/ie8.css" /><![endif]-->
	</head>
	<body>
	
<!-- <div id="header1">
				<div class="left">
					<p>					<p><a href="signInUpload.do">SignIn</a></p>	
</p>
				</div>
				<div class="right">
					<ul class="contact">
						<li><a href="#" class="fa fa-twitter solo"><span>Twitter</span></a></li>
						<li><a href="#" class="fa fa-facebook solo"><span>Facebook</span></a></li>
						<li><a href="#" class="fa fa-google-plus solo"><span>Google+</span></a></li>
						<li><a href="#" class="fa fa-dribbble solo"><span>Dribbble</span></a></li>
						<li><a href="#" class="fa fa-pinterest solo"><span>Pinterest</span></a></li>
						<li><a href="#" class="fa fa-envelope solo"><span>Email</span></a></li>
					</ul>
					<div id="copyright">
						&copy; Untitled. Design: <a href="http://html5up.net/">HTML5 UP</a>
					</div>
				</div>
			</div> -->

		<div id="wrapper">
		
							
					

			<div id="main">
		
				<div id="reel">
				<!-- ******************************************************************************************** -->
				<!-- ******************************************************************************************** -->
				

					<!-- Header Item -->
						<div id="header" class="item" data-width="400">
							<h1>PicMaza.com</h1>
							<p>A tour with awesome pictures.<br />
							Shantanu Pandey</p>
						</div> 
					<!-- Thumb Items -->

					 	<!-- <article class="item thumb" data-width="282">
							<h2>You really got me</h2>
							<a href="images/fulls/01.jpg"><img src="images/thumbs/01.jpg" alt=""></a>
						</article> -->
						
						<!--<article class="item thumb" data-width="384">
							<h2>Ad Infinitum</h2>
							<a href="images/fulls/02.jpg"><img src="images/thumbs/02.jpg" alt=""></a>
						</article>
						
						<article class="item thumb" data-width="274">
							<h2>Different.</h2>
							<a href="images/fulls/03.jpg"><img src="images/thumbs/03.jpg" alt=""></a>
						</article>
						
						<article class="item thumb" data-width="282">
							<h2>Elysium</h2>
							<a href="images/fulls/04.jpg"><img src="images/thumbs/04.jpg" alt=""></a>
						</article>
						
						<article class="item thumb" data-width="476">
							<h2>Kingdom of the Wind</h2>
							<a href="images/fulls/05.jpg"><img src="images/thumbs/05.jpg" alt=""></a>
						</article>
						
						<article class="item thumb" data-width="232">
							<h2>The Pursuit</h2>
							<a href="images/fulls/06.jpg"><img src="images/thumbs/06.jpg" alt=""></a>
						</article>
						
						<article class="item thumb" data-width="352">
							<h2>Boundless</h2>
							<a href="images/fulls/07.jpg"><img src="images/thumbs/07.jpg" alt=""></a>
						</article>
						
						<article class="item thumb" data-width="348">
							<h2>The Spectators</h2>
							<a href="images/fulls/08.jpg"><img src="images/thumbs/08.jpg" alt=""></a>
						</article> -->
							<%= session.getAttribute("citationDiv") %>

					<!-- Filler Thumb Items (just for demonstration purposes) -->
						<!-- <article class="item thumb" data-width="476"><h2>Kingdom of the Wind</h2><a href="images/fulls/05.jpg"><img src="images/thumbs/05.jpg" alt=""></a></article>
						<article class="item thumb" data-width="232"><h2>The Pursuit</h2><a href="images/fulls/06.jpg"><img src="images/thumbs/06.jpg" alt=""></a></article>
						<article class="item thumb" data-width="352"><h2>Boundless</h2><a href="images/fulls/07.jpg"><img src="images/thumbs/07.jpg" alt=""></a></article>
						<article class="item thumb" data-width="348"><h2>The Spectators</h2><a href="images/fulls/08.jpg"><img src="images/thumbs/08.jpg" alt=""></a></article>
						<article class="item thumb" data-width="282"><h2>You really got me</h2><a href="images/fulls/01.jpg"><img src="images/thumbs/01.jpg" alt=""></a></article>
						<article class="item thumb" data-width="384"><h2>Ad Infinitum</h2><a href="images/fulls/02.jpg"><img src="images/thumbs/02.jpg" alt=""></a></article>
						<article class="item thumb" data-width="274"><h2>Different.</h2><a href="images/fulls/03.jpg"><img src="images/thumbs/03.jpg" alt=""></a></article>
						<article class="item thumb" data-width="282"><h2>Elysium</h2><a href="images/fulls/04.jpg"><img src="images/thumbs/04.jpg" alt=""></a></article>

 -->
				<!-- ******************************************************************************************** -->
				<!-- ******************************************************************************************** -->
				</div> 
				
				<!-- test -->
				<div id="reel">
				<!-- ******************************************************************************************** -->
				<!-- ******************************************************************************************** -->
				

					<!-- Header Item -->
						<div id="header" class="item" data-width="400">
							<h1>PicMaza.com</h1>
							<p>A tour with awesome pictures.<br />
							Shantanu Pandey</p>
						</div> 
					<!-- Thumb Items -->

					 	<article class="item thumb" data-width="282">
							<h2>You really got me</h2>
							<a href="images/fulls/01.jpg"><img src="images/thumbs/01.jpg" alt=""></a>
						</article>
						
						<article class="item thumb" data-width="384">
							<h2>Ad Infinitum</h2>
							<a href="images/fulls/02.jpg"><img src="images/thumbs/02.jpg" alt=""></a>
						</article>
						
						<article class="item thumb" data-width="274">
							<h2>Different.</h2>
							<a href="images/fulls/03.jpg"><img src="images/thumbs/03.jpg" alt=""></a>
						</article>
						
						<article class="item thumb" data-width="282">
							<h2>Elysium</h2>
							<a href="images/fulls/04.jpg"><img src="images/thumbs/04.jpg" alt=""></a>
						</article>
						
						<article class="item thumb" data-width="476">
							<h2>Kingdom of the Wind</h2>
							<a href="images/fulls/05.jpg"><img src="images/thumbs/05.jpg" alt=""></a>
						</article>
						
						<article class="item thumb" data-width="232">
							<h2>The Pursuit</h2>
							<a href="images/fulls/06.jpg"><img src="images/thumbs/06.jpg" alt=""></a>
						</article>
						
						<article class="item thumb" data-width="352">
							<h2>Boundless</h2>
							<a href="images/fulls/07.jpg"><img src="images/thumbs/07.jpg" alt=""></a>
						</article>
						
						<article class="item thumb" data-width="348">
							<h2>The Spectators</h2>
							<a href="images/fulls/08.jpg"><img src="images/thumbs/08.jpg" alt=""></a>
						</article> 

				
				<!-- ******************************************************************************************** -->
				<!-- ******************************************************************************************** -->
				</div> 
				<!--end test  -->
				
			
			</div>
			  
		
			<div id="header2">
				<div class="left">
</p>
				</div>
				<div align="center"><h1>PicMaza.com</h1></div>
				<div class="right">
										
										<a href="signInUpload.do" class="myButton">Post Pic</a>
										<a href="signInUser.do" class="myButton">Sign In</a>
										<a href="homePage.do" class="myButton">Home</a>
						
					
					
				</div>
			</div>
			
			<div id="footer">
				<div class="left">
					<p><b>PicMaza.com</b></p>
				</div>
				<div class="right">
					<ul class="contact">
						<li><a href="#" class="fa fa-twitter solo"><span>Twitter</span></a></li>
						<li><a href="#" class="fa fa-facebook solo"><span>Facebook</span></a></li>
						<li><a href="#" class="fa fa-google-plus solo"><span>Google+</span></a></li>
						<li><a href="#" class="fa fa-dribbble solo"><span>Dribbble</span></a></li>
						<li><a href="#" class="fa fa-pinterest solo"><span>Pinterest</span></a></li>
						<li><a href="#" class="fa fa-envelope solo"><span>Email</span></a></li>
					</ul>
					
				</div>
			</div>


		</div>

	</body>
</html>