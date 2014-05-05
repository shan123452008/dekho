<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include  file="includeCssJs.jsp" %>
<!doctype html>
<html class="no-js">

    <head>
        <meta charset="utf-8"/>
        <title>DekhoReview.com</title>

    </head>
    <body class="home">

        <!-- HEADER -->
        <header>
            <div class="wrapper cf">

                <div id="logo">
                    <a href="index.html"><img  src="img/logo.png" alt="Simpler"></a>
                </div>

                <!-- nav -->
                <ul id="nav" class="sf-menu">
                    <li><a href="blog.html">Photos</a></li>
                    <li><a href="about.do">ABOUT</a>

                    </li>
                    <li class="current-menu-item"><a href="signInUser.do">SIGN IN</a></li>
                    <li class="current-menu-item"><a href="signInUser.do">Blogs</a>
                        <ul>
                            <li><a href="blog.do">Read Blog</a></li>

                        </ul>
                    </li>
                    <li class="current-menu-item"><a href="signInUser.do">Reviews</a>
                        <ul>
                            <li><a href="details.do">Movie</a></li>
                            <li><a href="homePage.do?help=index1">Restro</a></li>
                            <li><a href="carReviews.do">Car</a></li>
                        </ul>
                    </li>

                    <li><a href="#">MODE</a>
                        <ul>
                            <li><a href="details.do">Tour for Reel Site</a></li>
                        </ul></li>
                    <li><a href="contactUs.do">CONTACT</a></li>
                </ul>
                <div id="combo-holder"></div>
                <!-- ends nav -->


                <!-- SLIDER -->				
                <div id="home-slider" class="lof-slidecontent">

                    <div class="preload"><div></div></div>

                    <!-- slider content --> 
                    <div class="main-slider-content" >
                        <ul class="sliders-wrap-inner">
                            <!-- 					    <li><img src='imagesPic/pictures/images.jpg' title='' alt='alt' /><div class='slider-description'><h4>Lorem ipsum dolor</h4><p>Eyes with saying alot -shantanu<a class='link' href='#'>Read more </a></p></div></li>
                            -->					    
                            <li>
                                <img src="img/dummies/slides/02.jpg" title="" alt="alt" />           
                                <div class="slider-description">
                                    <h4>Lorem ipsum dolor</h4>
                                    <p>Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Vestibulum tortor quam, feugiat vitae, ultricies eget, tempor sit amet, ante. Donec eu libero sit amet quam egestas semper. Aenean ultricies mi vitae est...
                                        <a class="link" href="#">Read more </a>
                                    </p>
                                </div>
                            </li>

                            <li>
                                <img src="img/dummies/slides/03.jpg" title="" alt="alt" />           
                                <div class="slider-description">
                                    <h4>Lorem ipsum dolor</h4>
                                    <p>Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Vestibulum tortor quam, feugiat vitae, ultricies eget, tempor sit amet, ante. Donec eu libero sit amet quam egestas semper. Aenean ultricies mi vitae est...
                                        <a class="link" href="#">Read more </a>
                                    </p>
                                </div>
                            </li>

                            <li>
                                <img src="img/dummies/slides/04.jpg" title="" alt="alt" />           
                                <div class="slider-description">
                                    <h4>Lorem ipsum dolor</h4>
                                    <p>Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Vestibulum tortor quam, feugiat vitae, ultricies eget, tempor sit amet, ante. Donec eu libero sit amet quam egestas semper. Aenean ultricies mi vitae est...
                                        <a class="link" href="#">Read more </a>
                                    </p>
                                </div>
                            </li>

                            <li>
                                <img src="img/dummies/slides/05.jpg" title="" alt="alt" />           
                                <div class="slider-description">
                                    <h4>Lorem ipsum dolor</h4>
                                    <p>Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Vestibulum tortor quam, feugiat vitae, ultricies eget, tempor sit amet, ante. Donec eu libero sit amet quam egestas semper. Aenean ultricies mi vitae est...
                                        <a class="link" href="#">Read more </a>
                                    </p>
                                </div>
                            </li>

                            <li>
                                <img src="img/dummies/slides/06.jpg" title="" alt="alt" />           
                                <div class="slider-description">
                                    <h4>Lorem ipsum dolor</h4>
                                    <p>Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Vestibulum tortor quam, feugiat vitae, ultricies eget, tempor sit amet, ante. Donec eu libero sit amet quam egestas semper. Aenean ultricies mi vitae est...
                                        <a class="link" href="#">Read more </a>
                                    </p>
                                </div>
                            </li>

                            <li>
                                <img src="img/dummies/slides/07.jpg" title="" alt="alt" />           
                                <div class="slider-description">
                                    <h4>Lorem ipsum dolor</h4>
                                    <p>Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Vestibulum tortor quam, feugiat vitae, ultricies eget, tempor sit amet, ante. Donec eu libero sit amet quam egestas semper. Aenean ultricies mi vitae est...
                                        <a class="link" href="#">Read more </a>
                                    </p>
                                </div>
                            </li>
                        </ul>  	
                    </div>
                    <!-- ENDS slider content --> 

                    <!-- slider nav -->
                    <div class="navigator-content">
                        <div class="navigator-wrapper">
                            <ul class="navigator-wrap-inner">
                                <li><img src="img/dummies/slides/01_thumb.jpg" alt="alt" /></li>
                                <li><img src="img/dummies/slides/02_thumb.jpg" alt="alt" /></li>
                                <li><img src="img/dummies/slides/03_thumb.jpg" alt="alt" /></li>
                                <li><img src="img/dummies/slides/04_thumb.jpg" alt="alt" /></li>
                                <li><img src="img/dummies/slides/05_thumb.jpg" alt="alt" /></li>
                                <li><img src="img/dummies/slides/06_thumb.jpg" alt="alt" /></li>
                                <li><img src="img/dummies/slides/07_thumb.jpg" alt="alt" /></li> 

                            </ul>
                        </div>
                        <div class="button-next">Next</div>
                        <div  class="button-previous">Previous</div>
                        <!-- REMOVED TILL FIXED <div class="button-control"><span>STOP</span></div> -->
                    </div> 
                    <!-- slider nav -->
                </div> 
                <!-- ENDS SLIDER -->

            </div>
        </header>
        <!-- ENDS HEADER -->

        <!-- MAIN -->
        <div id="main" style="background-color:#FFFFFF;padding-top: 74px;">

            <div id="tfheader" style="width: 941px;
                 height:60px;                        
                 margin-right:10px;margin-left: 204px;
                 float:left;
                 background-color:#c3dfef;" align="center" >
                <span>&nbsp;</span>
                <form action="http://www.google.com" method="get" id="tfnewsearch">
                    <input style="margin: 0;
                           padding: 4px 16px;
                           font-family: Arial, Helvetica, sans-serif;
                           font-size:14px;
                           border:1px solid #0076a3; border-right:0px;
                           border-top-left-radius: 5px 5px;
                           border-bottom-left-radius: 5px 5px;" maxlength="120" size="29" name="q" class="tftextinput" type="text"/><input class="" value="search" style="margin: 0;
                           padding: 3px 15px;
                           font-family: Arial, Helvetica, sans-serif;
                           font-size:14px;
                           outline: none;
                           cursor: pointer;
                           text-align: center;
                           text-decoration: none;
                           color: #ffffff;
                           border: solid 1px #0076a3; border-right:0px;
                           background: #0095cd;
                           background: -webkit-gradient(linear, left top, left bottom, from(#00adee),         to(#0078a5));
                           background: -moz-linear-gradient(top,#00adee,  #0078a5);
                           border-radius: 30px;
                           border-top-left-radius: 5px 5px;
                           border-bottom-left-radius: 5px 5px;" type="submit"/>
                </form>
                <div class="tfclear" style="clear:both;"></div>

            </div>


            <div style="overflow:auto; height: 880px;width: 100%;background: white;margin: 2em auto;margin-left:0cm;">


                <style>      #parent_div_1, #parent_div_2{
                        width:940px;
                        height:500px;

                        margin-right:10px;margin-left: 200px;
                        float:left;
                    }
                    .child_div_1{
                        float:left;
                        margin-right:5px;
                    }     </style>

                <div id='parent_div_1' style="height: 440px;">
                    <div style="float: left; width: 549px; clear: both; margin: 18px 18px 18px 0px; padding: 1em; background: none repeat scroll 0% 0% white; height: 312px;">
                        <ul class="tabs">
                            <li><a class="current" href="#"><span>Restro</span></a></li>
                            <li><a href="#"><span>Cars</span></a></li>
                            <li><a href="#"><span>Bikes</span></a></li>
                        </ul>
                        <div class="panes">
                            <div style="display: block; height: 262px; width: 525px;">

                                <div id="filter-container" class="cf isotope" style="width: 683px; overflow: hidden; position: relative; height: 289px;">

<!--                                    <figure class="web isotope-item" style="width: 188px; height: 259px; position: absolute; left: 5px; top: 5px;"><a href="restroRating.do?restroId=1" class="thumb"><img src="http://localhost:8084/dekhoReview/imagesPic/picture/Desert.jpg" title=""></a><figcaption><a href="#"><h2 class="heading">shantanu</h2></a>Eyes with saying alot</figcaption></figure>

                                    <figure class="web isotope-item" style="width: 188px; height: 259px; position: absolute; left: 5px; top: 5px;"><a href="restroRating.do?restroId=2" class="thumb"><img src="http://localhost:8084/dekhoReview/imagesPic/picture/Koala.jpg" title=""></a><figcaption><a href="#"><h2 class="heading">Shantanu pandey</h2></a>My cat </figcaption></figure>-->
                                    ${restroDetails}
                                </div>

                            </div>
                            <div style="display: none; height: 262px;">
                                <div id="filter-container" class="cf isotope" style="width: 534px; overflow: hidden; position: relative; height: 289px;">

                                    <figure class="web isotope-item" style="width: 188px; height: 259px; position: absolute; left: 5px; top: 5px;"><a href="restroRating.do?restroId=1" class="thumb"><img src="http://localhost:8084/dekhoReview/imagesPic/picture/Desert.jpg" title=""></a><figcaption><a href="#"><h2 class="heading">shantanu</h2></a>Eyes with saying alot</figcaption></figure>

                                    <figure class="web isotope-item" style="width: 188px; height: 259px; position: absolute; left: 5px; top: 5px;"><a href="restroRating.do?restroId=2" class="thumb"><img src="http://localhost:8084/dekhoReview/imagesPic/picture/Koala.jpg" title=""></a><figcaption><a href="#"><h2 class="heading">Shantanu pandey</h2></a>My cat </figcaption></figure>

                                </div></div>

                            <div style="display: none; height: 262px;">
                                <div id="filter-container" class="cf isotope" style="width: 534px; overflow: hidden; position: relative; height: 242px;">

                                    <figure class="web isotope-item" style="width: 188px; height: 259px; position: absolute; left: 5px; top: 5px;"><a href="restroRating.do?restroId=1" class="thumb"><img src="http://localhost:8084/dekhoReview/imagesPic/picture/Desert.jpg" title=""></a><figcaption><a href="#"><h2 class="heading">shantanu</h2></a>Eyes with saying alot</figcaption></figure>

                                    <figure class="web isotope-item" style="width: 188px; height: 259px; position: absolute; left: 5px; top: 5px;"><a href="restroRating.do?restroId=2" class="thumb"><img src="http://localhost:8084/dekhoReview/imagesPic/picture/Koala.jpg" title=""></a><figcaption><a href="#"><h2 class="heading">Shantanu pandey</h2></a>My cat </figcaption></figure>

                                </div></div>

                        </div></div>
                    <!-- Prasahant                   -->
                    <div style="float:right;width: 274px; margin: 66px -150cm 5px 5px; padding: 35px 0px 1em 1em; margin-right:0cm; height: 245px;">
                        <h2 style="background: none repeat scroll 0% 0% rgb(255, 255, 0);">Most Read</h2>
                        <h2>&nbsp;</h2>

                        <ul style="background-position: 0 0.5em;
                            background-repeat: no-repeat;
                            border-bottom: 1px solid #CCCCCC;
                            font-weight: bold;
                            line-height: 130%;
                            list-style-image: none;
                            list-style-type: none;
                            margin: 10px 0 5px 10px;
                            padding: 0 0 5px 10px;"><li type="disc"><a style="color:#0083CC" href="#" id="MostReadLink">Datsun Go vs Hyundai Eon vs Maruti Wagon R comparison</a></li><hr style="border: 0;height: 0;border-top: 1px solid rgba(0, 0, 0, 0.1);border-bottom: 1px solid rgba(255, 255, 255, 0.3);"><li type="disc"><a id="MostReadLink" href="#" style="color:#0083CC">Datsun Go vs Hyuon R comparison</a></li><hr style="border: 0;height: 0;border-top: 1px solid rgba(0, 0, 0, 0.1);border-bottom: 1px solid rgba(255, 255, 255, 0.3);"><li type="disc"><a id="MostReadLink" href="#" style="color:#0083CC">Datsun Go vs Hyundai Eon vs Maruti Wagon R comparison</a></li><hr style="border: 0;height: 0;border-top: 1px solid rgba(0, 0, 0, 0.1);border-bottom: 1px solid rgba(255, 255, 255, 0.3);"><li></li><li><a id="MostReadLink" href="#" style="color:#0083CC">Datsun Go vs Hyucomparison</a></li><hr style="border: 0;height: 0;border-top: 1px solid rgba(0, 0, 0, 0.1);border-bottom: 1px solid rgba(255, 255, 255, 0.3);"><li></li><li><a id="MostReadLink" href="#" style="color:#0083CC">Datsun Go vs Hyucomparison</a></li><hr style="border: 0;height: 0;border-top: 1px solid rgba(0, 0, 0, 0.1);border-bottom: 1px solid rgba(255, 255, 255, 0.3);"><li></li><li><a id="MostReadLink" href="#" style="color:#0083CC">Datsun Go vs Hyucomparison</a></li><li></li><li></li><li></li></ul>




                    </div>
                    <!--                   Ends here -->
                </div>

                <div id='parent_div_2'style="height: 335px;">
                    <div style="float: left; width: 60%; height: 300px; margin: 5px 5px 5px 0px; padding: 1em; background: none repeat scroll 0% 0% white; border: 1px solid rgb(204, 204, 204);">
                        <h2> Latest Blog </h2>
                        <h2>&nbsp;</h2>


                        release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever
                    </div>
                    <div style="float:right;width: 232px; height: 300px; margin:5px;padding: 1em;background: white;border: 1px solid #ccc;">
                        <h3>Blogger of the week</h3>
                        <h3>&nbsp;</h3>
                        <img src="images/small/" alt="Post" width="250" height="200"/><br>
                        <h4>Name:</h4> Shan pandey<br>
                        <h4>Blog Title: </h4> We Dont have to accuse yuvraj for loosing match<br>
                        <h4>Toal Comments: </h4> 250<br>
                        <h4>Date of bloging</h4> 10-april-2014<br>




                    </div>

                </div>

            </div>
            <!-- Elastislide Carousel -->
            <ul id="carousel" class="elastislide-list">
                bckchkgvhgchgccvj  kghf ghjg gjhjh hjklhj ghjghg jljh hjl 
                <li><a href="#"><img src="images/small/1.jpg" alt="image01" /></a></li>
                <li><a href="#"><img src="images/small/2.jpg" alt="image02" /></a></li>
                <li><a href="#"><img src="images/small/3.jpg" alt="image03" /></a></li>
                <li><a href="#"><img src="images/small/4.jpg" alt="image04" /></a></li>
                <li><a href="#"><img src="images/small/5.jpg" alt="image05" /></a></li>
                <li><a href="#"><img src="images/small/6.jpg" alt="image06" /></a></li>
                <li><a href="#"><img src="images/small/7.jpg" alt="image07" /></a></li>
                <li><a href="#"><img src="images/small/8.jpg" alt="image08" /></a></li>
                <li><a href="#"><img src="images/small/9.jpg" alt="image09" /></a></li>
                <li><a href="#"><img src="images/small/10.jpg" alt="image10" /></a></li>
                <li><a href="#"><img src="images/small/11.jpg" alt="image11" /></a></li>
                <li><a href="#"><img src="images/small/12.jpg" alt="image12" /></a></li>
                <li><a href="#"><img src="images/small/13.jpg" alt="image13" /></a></li>
                <li><a href="#"><img src="images/small/14.jpg" alt="image14" /></a></li>
                <li><a href="#"><img src="images/small/15.jpg" alt="image15" /></a></li>
                <li><a href="#"><img src="images/small/16.jpg" alt="image16" /></a></li>
                <li><a href="#"><img src="images/small/17.jpg" alt="image17" /></a></li>
                <li><a href="#"><img src="images/small/18.jpg" alt="image18" /></a></li>
                <li><a href="#"><img src="images/small/19.jpg" alt="image19" /></a></li>
                <li><a href="#"><img src="images/small/20.jpg" alt="image20" /></a></li>
            </ul>
            <!-- End Elastislide Carousel -->   
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


        <script type="text/javascript" src="js/jquery.elastislide.js"></script>
        <script type="text/javascript">
			
            $( '#carousel' ).elastislide();
			
        </script>


    </body>



</html>