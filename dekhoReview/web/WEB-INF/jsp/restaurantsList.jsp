<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="includeCssJs.jsp" %> 
<!doctype html> 
<html>

    <head>
        
         <link rel="stylesheet" type="text/css" href="css/fornewjsp.css" />
        <link rel="stylesheet" type="text/css" href="css/newlook.css" />
        <meta charset="utf-8"/>
        <title>DekhoReview.com</title>

        

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
            function search()
            {
                var city=document.getElementById("company").value;
                var name=document.getElementById("model").value;
              //  alert(city  +'  '+name);
                jQuery.ajax({
                        
                    url:'restroSearch.do?city='+city +'&name='+name,
                    dataType:'text',
                    success: function(data)
                    {
                      //  alert('data'+data);
                       document.getElementById("restrosearch").innerHTML = data; 
                    }
                }).responseText;
            }
        </script>
       
    </head>


    <body>

        <!-- HEADER -->
         <jsp:include page="Header.jsp"/>
        <!-- ENDS HEADER -->

        <!-- MAIN -->
        <div id="main">
               <jsp:include page="Test.jsp"/>&nbsp;
            <div class="wrapper cf">
                
                <ul class="photo-box-list clearfix" data-component-bound="true" style="border:1px solid black;">
                    ${HighRatingRestro}
                </ul>
                <!--Related-projects ends here-->
            </div><!-- ENDS WRAPPER -->

        </div>
        <!-- ENDS MAIN -->


    <!-- FOOTER -->
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