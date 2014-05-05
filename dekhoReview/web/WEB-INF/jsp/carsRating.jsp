<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta charset="utf-8"/>
		<title>DekhoReview.com</title>
		 
		<!--[if lt IE 9]>
			<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
		<![endif]-->
		<link rel="stylesheet" media="all" href="cssHomePage/style.css"/>
		<meta name="viewport" content="width=device-width, initial-scale=1"/>
		<!-- Adding "maximum-scale=1" fixes the Mobile Safari auto-zoom bug: http://filamentgroup.com/examples/iosScaleBug/ -->		
				
		<!-- JS -->
		<script src="js_home/jquery-1.7.1.min.js"></script>
		<script src="js_home/custom.js"></script>
		<script src="js_home/tabs.js"></script>
		<script src="js_home/css3-mediaqueries.js"></script>
		<script src="js_home/jquery.columnizer.min.js"></script>
		
		<!-- Isotope -->
		<script src="js_home/jquery.isotope.min.js"></script>
		
		<!-- Lof slider -->
		<script src="js_home/jquery.easing.js"></script>
		<script src="js_home/lof-slider.js"></script>
		<link rel="stylesheet" href="cssHomePage/lof-slider.css" media="all"  /> 
		<!-- ENDS slider -->
		
		<!-- Tweet -->
		<link rel="stylesheet" href="cssHomePage/jquery.tweet.css" media="all"  /> 
		<script src="js_home/tweet/jquery.tweet.js" ></script> 
		<!-- ENDS Tweet -->
		
		<!-- superfish -->
		<link rel="stylesheet" media="screen" href="cssHomePage/superfish.css" /> 
		<script  src="js_home/superfish-1.4.8/js/hoverIntent.js"></script>
		<script  src="js_home/superfish-1.4.8/js/superfish.js"></script>
		<script  src="js_home/superfish-1.4.8/js/supersubs.js"></script>
		<!-- ENDS superfish -->
		
		<!-- prettyPhoto -->
		<script  src="js_home/prettyPhoto/js/jquery.prettyPhoto.js"></script>
		<link rel="stylesheet" href="js_home/prettyPhoto/css/prettyPhoto.css"  media="screen" />
		<!-- ENDS prettyPhoto -->
		
		<!-- poshytip -->
		<link rel="stylesheet" href="js_home/poshytip-1.1/src/tip-twitter/tip-twitter.css"  />
		<link rel="stylesheet" href="js_home/poshytip-1.1/src/tip-yellowsimple/tip-yellowsimple.css"  />
		<script  src="js_home/poshytip-1.1/src/jquery.poshytip.min.js"></script>
		<!-- ENDS poshytip -->
		
		<!-- JCarousel -->
		<script type="text/javascript" src="js_home/jquery.jcarousel.min.js"></script>
		<link rel="stylesheet" media="screen" href="cssHomePage/carousel.css" /> 
		<!-- ENDS JCarousel -->
		
		<!-- GOOGLE FONTS -->
		<link href='http://fonts.googleapis.com/css?family=Voltaire' rel='stylesheet' type='text/css'>

		<!-- modernizr -->
		<script src="js_home/modernizr.js"></script>
		
		<!-- SKIN -->
		<link rel="stylesheet" media="all" href="cssHomePage/skin.css"/>
		
		<!-- Less framework -->
		<link rel="stylesheet" media="all" href="cssHomePage/lessframework.css"/>
		
		<!-- flexslider -->
		<link rel="stylesheet" href="cssHomePage/flexslider.css" >
		<script src="js_home/jquery.flexslider.js"></script>
		
		<script type="text/javascript">
		function image1(img){
			alert("image >>>"+img);
		}
		</script>

	</head>
	
	
	<body>
	
		<!-- HEADER -->
		<header>
			<div class="wrapper cf">
				
				<div id="logo">
					<a href="index.html"><img  src="img/logo.png" alt="Simpler"></a>
				</div>
				
				<!-- nav -->
				<ul id="nav" class="sf-menu">
					<li><a href="homePage.do"><span>HOME</span></a></li>
					<li><a href="blog.html">BLOG</a></li>
					<li><a href="page.html">ABOUT</a>
						<ul>
							<li><a href="page-elements.html">Elements</a></li>
							<li><a href="page-icons.html">Icons</a></li>
							<li><a href="page-typography.html">Typography</a></li>
						</ul>
					</li>
					<li class="current-menu-item"><a href="portfolio.html">WORK</a></li>
					<li><a href="contact.html">CONTACT</a></li>
				</ul>
				<div id="combo-holder"></div>
				<!-- ends nav -->

			</div>
		</header>
		<!-- ENDS HEADER -->
		
		<!-- MAIN -->
		<div id="main">
			<div class="wrapper cf">
			
			
				
			<!-- portfolio content-->
        	<div id="portfolio-content" class="cf">        	
				
				
				
				
				<!-- project pager -->
				<div class="project-pager cf">
					<a class="previous-project" href="#">&#8592; Previous project</a>
					<a class="next-project" href="#">Next project &#8594;</a>
				</div>
				<!-- ENDS project pager -->
					
					
					<!-- project box -->
				<div id="project-box" class="cf">
				
				
					
				
				
					<!-- slider -->
					<div class="project-slider">
				        <div class="flexslider">
						  <ul class="slides">
						   	<%= session.getAttribute("carsRating") %>
						   
						  </ul>
						</div>
					</div>
		        	<!-- ENDS slider -->


					<div class="info">
	        				<%= session.getAttribute("detailsCars") %>

	        		</div>
	        		
	        		<!-- entry-content -->
	        		<div class="entry-content">
	        		
	        			<h2 class="heading"><%= session.getAttribute("heading") %></h2>
	        			
	        			<div>
	        			<%= session.getAttribute("detailCar") %>
	        			</div>
	        		</div>
	        		<!-- ENDS entry content -->
	        		
	        	</div>
		    	<!-- ENDS project box -->
					
					
<!-- comments list -->
				<div id="comments-wrap">
					<h4 class="heading">5 Comments</h4>
					
					<ol class="commentlist">
					  
					           
						<!-- <li class="comment even thread-even depth-1" 

id="li-comment-1">
							
							<div id="comment-1" class="comment-body 

cf">
						     	<img alt='' 

src='http://0.gravatar.com/avatar/4f64c9f81bb0d4ee969aaf7b4a5a6f40?s=35&amp;d=&amp;r=G' 

class='avatar avatar-35 photo' height='35' width='35' />      
						     	<div class="comment-author 

vcard">Jhon</div>
						        <div class="comment-meta commentmetadata">
							  		<span class="comment-

date">3 days ago  </span>
									<span class="comment-

reply-link-wrap"><a class='comment-reply-link' href='replytocom=23#respond' onclick='return 

addComment.moveForm("comment-1", "1", "respond", "432")'>Reply</a></span>
									
								</div>
						  		<div class="comment-inner">
							   		<p>Donec sed odio dui. 

Nulla vitae elit libero, a pharetra augue. Nullam id dolor id nibh ultricies vehicula ut id elit. 

Integer posuere erat a ante venenatis dapibus posuere velit aliquet.</p>
						 		</div>
					     	</div>
					
							child
							<ul class='children'>
					  			<li class="comment even alt 

depth-2" id="li-comment-2-1">
									<div id="comment-2" 

class="comment-body cf">
										<img alt='' 

src='http://0.gravatar.com/avatar/4f64c9f81bb0d4ee969aaf7b4a5a6f40?s=35&amp;d=&amp;r=G' 

class='avatar avatar-35 photo' height='35' width='35' />      
					      				<div class="comment-author 

vcard">Jhon</div>
										<div 

class="comment-meta commentmetadata">
					  						<span 

class="comment-date">1 hour ago  </span>
											<span 

class="comment-reply-link-wrap"><a class='comment-reply-link' href='replytocom=24#respond' 

onclick='return addComment.moveForm("comment-2", "2", "respond", "432")'>Reply</a></span>
										</div>
					  					<div 

class="comment-inner">
								   			

<p>Pellentesque ornare sem lacinia quam venenatis vestibulum. Vestibulum id ligula porta felis 

euismod semper. Sed posuere consectetur est at lobortis.</p>
					     			 	</div>
					 				</div>
								</li>
								
								<li class="comment odd alt depth-

2" id="li-comment-2-2">
									<div id="comment-3" 

class="comment-body cf">
										<img alt='' 

src='http://0.gravatar.com/avatar/4f64c9f81bb0d4ee969aaf7b4a5a6f40?s=35&amp;d=&amp;r=G' 

class='avatar avatar-35 photo' height='35' width='35' />      
					      				<div class="comment-author 

vcard">Jhon</div>
										<div 

class="comment-meta commentmetadata">
					  						<span 

class="comment-date">1 hour ago  </span>
											<span 

class="comment-reply-link-wrap"><a class='comment-reply-link' href='replytocom=24#respond' 

onclick='return addComment.moveForm("comment-3", "2", "respond", "432")'>Reply</a></span>
										</div>
					  					<div 

class="comment-inner">
								   			

<p>Pellentesque ornare sem lacinia quam venenatis vestibulum. Vestibulum id ligula porta felis 

euismod semper. Sed posuere consectetur est at lobortis.</p>
					     			 	</div>
					 				</div>
								</li>
								
								
							</ul>
							ENDS child
						</li>
						
						
						<li class="comment odd thread-even depth-1" 

id="li-comment-3">
							
							<div id="comment-4" class="comment-body 

cf">
						     	<img alt='' 

src='http://0.gravatar.com/avatar/4f64c9f81bb0d4ee969aaf7b4a5a6f40?s=35&amp;d=&amp;r=G' 

class='avatar avatar-35 photo' height='35' width='35' />      
						     	<div class="comment-author 

vcard">Jhon</div>
						        <div class="comment-meta commentmetadata">
							  		<span class="comment-

date">3 days ago  </span>
									<span class="comment-

reply-link-wrap"><a class='comment-reply-link' href='replytocom=23#respond' onclick='return 

addComment.moveForm("comment-4", "1", "respond", "432")'>Reply</a></span>
									
								</div>
						  		<div class="comment-inner">
							   		<p>Donec sed odio dui. 

Nulla vitae elit libero, a pharetra augue. Nullam id dolor id nibh ultricies vehicula ut id elit. 

Integer posuere erat a ante venenatis dapibus posuere velit aliquet.</p>
						 		</div>
					     	</div>
					    </li>
					    
					    
					    
					    
					    
					    <li class="comment even thread-even depth-1" id="li-

comment-4">
							
							<div id="comment-5" class="comment-body 

cf">
						     	<img alt='' 

src='http://0.gravatar.com/avatar/4f64c9f81bb0d4ee969aaf7b4a5a6f40?s=35&amp;d=&amp;r=G' 

class='avatar avatar-35 photo' height='35' width='35' />      
						     	<div class="comment-author 

vcard">Jhon</div>
						        <div class="comment-meta commentmetadata">
							  		<span class="comment-

date">3 days ago  </span>
									<span class="comment-

reply-link-wrap"><a class='comment-reply-link' href='replytocom=23#respond' onclick='return 

addComment.moveForm("comment-5", "1", "respond", "432")'>Reply</a></span>
									
								</div>
						  		<div class="comment-inner">
							   		<p>Donec sed odio dui. 

Nulla vitae elit libero, a pharetra augue. Nullam id dolor id nibh ultricies vehicula ut id elit. 

Integer posuere erat a ante venenatis dapibus posuere velit aliquet.</p>
						 		</div>
					     	</div>
					    </li>
					     -->
					    
					    
					    <%= session.getAttribute("comment") %>
					    
					   
						
					</ol>
				</div>
				<!-- ENDS comments list -->

				
				<!-- Respond -->
				<div id="respond">

					<h3 id="reply-title">
						Leave a Reply <small><a rel="nofollow"
							id="cancel-comment-reply-link"
							href="/themes/wp-simpler/archives/34#respond"
							style="display: none;">Cancel reply</a></small>
					</h3>


					<form:form method="post" action="carsCommentAdd.do"	modelAttribute="commntCarAdd">
						<p class="comment-notes">
							Your email address will not be published. Required fields are
							marked <span class="required">*</span>
						</p>

						<p class="comment-form-author">
							<label for="author">Name<span class="required">*</span></label> <input
								id="author" name="author" type="text" value="" size="30"
								aria-required="true">
						</p>
						
						<p class="comment-form-email">
							<label for="email">Email<span class="required">*</span></label> <input
								id="email" name="email" type="text" value="" size="30"
								aria-required="true">
						</p>
					
						
						<p class="comment-form-url">
							<label for="ratings">Ratings</label><select id="ratings"
								name="ratings">
								<option value="5">5</option>
								<option value="4">4</option>
								<option value="3">3</option>
								<option value="2">2</option>
								<option value="1">1</option>
							</select>
						</p>

						<p class="comment-form-comment">
							<label for="comment">Comment</label>
							<textarea id="comment" name="comment" cols="45" rows="8"></textarea>
						</p>
					
													
					
						<p class="form-submit">
							<input name="submit" type="submit" id="submit"
								value="Post Comment"> <input type="hidden"
								name="comment_post_ID"
								value="<%=session.getAttribute("userId")%>"
								id="comment_post_ID"> 
						</p>

					</form:form>
				</div>
				<!-- ENDS Respond -->



				<!-- related -->
				<div class="related-projects">
					<h4 class="related-heading">Related projects</h4>
					<div class="related-list cf">
						<figure>
							<a href="#" class="thumb"><img src="img/dummies/slides/01.jpg" alt="Alt text" /></a>
							<a href="single.html" class="heading">Pellentesque habitant morbi</a>
						</figure>
						
						<figure>
							<a href="#" class="thumb"><img src="img/dummies/slides/02.jpg" alt="Alt text" /></a>
							<a href="single.html" class="heading">Pellentesque habitant morbi</a>
						</figure>
						
						<figure> 
							<a href="#" class="thumb"><img src="img/dummies/slides/03.jpg" alt="Alt text" /></a>
							<a href="single.html" class="heading">Pellentesque habitant morbi</a>
						</figure>
						
						<figure>
							<a href="#" class="thumb"><img src="img/dummies/slides/04.jpg" alt="Alt text" /></a>
							<a href="single.html" class="heading">Pellentesque habitant morbi</a>
						</figure>
						
					</div>
				</div>
				<!-- ENDS related -->
									
				
    		</div>
    		<!-- ENDS portfolio content-->
			
			
			
			</div><!-- ENDS WRAPPER -->
		</div>
		<!-- ENDS MAIN -->
		
		
		<!-- FOOTER -->
		<footer>
			<div class="wrapper cf">
			
				<!-- widgets -->
				<ul  class="widget-cols cf">
					<li class="first-col">
						
						<div class="widget-block">
							<h4>RECENT POSTS</h4>
							<div class="recent-post cf">
								<a href="#" class="thumb"><img src="img/dummies/54x54.gif" alt="Post" /></a>
								<div class="post-head">
									<a href="#">Pellentesque habitant morbi senectus</a><span> March 12, 2011</span>
								</div>
							</div>
							<div class="recent-post cf">
								<a href="#" class="thumb"><img src="img/dummies/54x54.gif" alt="Post" /></a>
								<div class="post-head">
									<a href="#">Pellentesque habitant morbi senectus</a><span> March 12, 2011</span>
								</div>
							</div>
							<div class="recent-post cf">
								<a href="#" class="thumb"><img src="img/dummies/54x54.gif" alt="Post" /></a>
								<div class="post-head">
									<a href="#">Pellentesque habitant morbi senectus</a><span> March 12, 2011</span>
								</div>
							</div>
						</div>
					</li>
					
					<li class="second-col">
						
						<div class="widget-block">
							<h4>ABOUT</h4>
							<p>Folder it's completely free this means you don't have to pay anything <a href="http://luiszuno.com/blog/license" tar >read license</a>.</p> 
							<p>Visit <a href="http://templatecreme.com/" >Template Creme</a> and find the most beautiful free templates up to date.</p>
						</div>
						
					</li>
					
					<li class="third-col">
						
						<div class="widget-block">
							<div id="tweets" class="footer-col tweet">
		         				<h4>TWITTER WIDGET</h4>
		         			</div>
		         		</div>
		         		
					</li>
					
					<li class="fourth-col">
						
						<div class="widget-block">
							<h4>CATEGORIES</h4>
							<ul>
								<li class="cat-item"><a href="#" >Design</a></li>
								<li class="cat-item"><a href="#" >Photo</a></li>
								<li class="cat-item"><a href="#" >Art</a></li>
								<li class="cat-item"><a href="#" >Game</a></li>
								<li class="cat-item"><a href="#" >Film</a></li>
								<li class="cat-item"><a href="#" >TV</a></li>
							</ul>
						</div>
		         		
					</li>	
				</ul>
				<!-- ENDS widgets -->	
				
				
				<!-- bottom -->
				<div class="footer-bottom">
					<div class="left">by <a href="http://luiszuno.com" >luiszuno.com</a></div>
						<ul id="social-bar" class="cf sb">
							<li><a href="http://www.facebook.com"  title="Become a fan" class="facebook">Facebbok</a></li>
							<li><a href="http://www.twitter.com" title="Follow my tweets" class="twitter"></a></li>
							<li><a href="http://plus.google.com" title="Enter my circles" class="plus"></a></li>
						</ul>
				</div>	
				<!-- ENDS bottom -->
			
			</div>
		</footer>
		<!-- ENDS FOOTER -->
		
	</body>
	
	
	
</html>