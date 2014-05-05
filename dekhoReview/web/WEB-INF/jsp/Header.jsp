<%-- 
    Document   : Header
    Created on : Apr 10, 2014, 11:57:37 AM
    Author     : Prashant
--%>


<!DOCTYPE html>

<!-- HEADER -->
<header>
    <div class="wrapper cf">

        <div id="logo">
            <a href="homePage.jsp"><img  src="img/logo.png" alt="Simpler"></a>
        </div>
        <form method="get" action="http://www.google.com/search" target="_blank" style="width: 321px; padding-left: 50px; margin-left: 236px; margin-top: 31px; padding-top: 0px; padding-bottom: 0px; margin-bottom: -45px;" >
            <input type="text" name="q" class="tftextinput" name="q" size="29" maxlength="120" maxlength="255" placeholder="Search on dekhoreview" title="Search on Javatpoint" style="margin: 0;
                   padding: 4px 16px;
                   font-family: Arial, Helvetica, sans-serif;
                   font-size:14px;
                   border:1px solid #0076a3; border-right:0px;
                   border-top-left-radius: 5px 5px;
                   border-bottom-left-radius: 5px 5px;">
                    
<!--                   <input type="submit" style="margin: 0;
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
                   border-bottom-left-radius: 5px 5px;" value="search" class="">
                   -->
            
            <input type="hidden" name="sitesearch" value="www.dekhoreview.com">
        </form>
     
        <!-- nav -->
        <ul id="nav" class="sf-menu" style="margin-top: -16px;">
            <li><a href="homePage.do?help=index"><span>HOME</span></a></li>
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