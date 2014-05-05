<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@include file="includeCssJs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

    <head>
         <link rel="stylesheet" type="text/css" href="css/fornewjsp.css" />
        <link rel="stylesheet" type="text/css" href="css/newlook.css" />
        <meta charset="utf-8"/>
        <title>DekhoReview.com</title>
        <!--        <script type="text/javascript">
                    function image1(img){
                        alert("image >>>"+img);
                    }
                </script>-->

        <script type="text/javascript">
            function image1(img){
                alert("image >>>"+img);
            }
            function divhide(){
              
                document.getElementById("test").style.visibility='hidden';
                
            }
            function getModelList(restroId)
            {
                 
                jQuery.ajax({
                        
                    url:'getRestroName.do?restroId='+restroId,
                    dataType:'text',
                    success: function(data)
                    {
                        document.getElementById("model").innerHTML = data; 
                    }
                }).responseText;
            }
            function search1()
            {//document.getElementById("project-box").style.display = ""; 
                 var city=document.getElementById("company").value;
                var name=document.getElementById("model").value;
              //  alert(city  +'  '+name);              
              window.location.href = 'restroSearch.do?city='+city +'&name='+name+'&searchfrom=restroList';
            }
        </script>

    </head>


    <body>

        <!-- HEADER -->
     <jsp:include page="Header.jsp"/>
    <!-- ENDS HEADER -->

    <!-- MAIN -->
    <div id="main">
        <div class="wrapper cf">
           
            
             <section id="content">
                                   
                        <div class="search">
                            <label>Company: </label>

                            <select id="company" onchange="getModelList(this.value);" name="city">
                                <option value="select">--select company---</option>
                                <option value="Delhi">Delhi</option>
                                <option value="Noida">Noida</option>
                            </select>

                            <label>Model: </label>
                            <select id="model" name="name" onchange="search1();">
                                <option value="select">--select model---</option>
                            </select>

<!--                            <input type="submit" value="search"/>-->
                        </div>
                </section>
            
            <!-- portfolio content-->
            <div id="filter-container" class="cf" style="height: 100px;" >

                           
                        </div>
            <div id="portfolio-content" class="cf">        	

                <!-- project pager -->
<!--                <div class="project-pager cf">
                    <a class="previous-project" href="#">&#8592; Previous project</a>
                    <a class="next-project" href="#">Next project &#8594;</a>
                </div>-->
                <!-- ENDS project pager -->

                <!-- project box -->
                <div id="project-box" class="cf">

                    <!-- slider -->
                    <div class="project-slider">
                        <div class="flexslider">
                            <ul class="slides">
                                ${restroRating}
                              

                            </ul>
                        </div>
                    </div>
                    <!-- ENDS slider -->


                    <div class="info">
                        ${detailsRestro}

                    </div>

                    <!-- entry-content -->
                    <div class="entry-content">

                        <h2 class="heading">
                            ${headingRestro}

                        <div class="multicolumn">
                          ${detailRestro}
                        </div>
                    </div>
                    <!-- ENDS entry content -->

                </div>
                <!-- ENDS project box -->


                <!-- comments list -->
                <div id="comments-wrap">
                    <h4 class="heading">5 Comments</h4>

                    <ol class="commentlist">

                        
                        ${restroComment}



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


                    <form:form method="post" action="restroCommentAdd.do"	modelAttribute="commntRestroAdd">
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
                                   value="${restrouserId}"
                                   id="comment_post_ID"> 
                        </p>

                    </form:form>
                </div>
                <!-- ENDS Respond -->



                <!--Related-projects start here-->
               <ul class="photo-box-list clearfix" data-component-bound="true">
                    ${HighRatingRestro1}
                   
                </ul>
                <!--Related-projects ends here-->									

            </div>
            <!-- ENDS portfolio content-->



        </div><!-- ENDS WRAPPER -->
    </div>
    <!-- ENDS MAIN -->


    <footer>
        <div class="wrapper cf">

            <!-- widgets -->
            <ul  class="widget-cols cf">
                <li class="first-col">

                </li>

            </ul>


        </div>
    </footer>
    <!-- ENDS FOOTER -->
</body>



</html>