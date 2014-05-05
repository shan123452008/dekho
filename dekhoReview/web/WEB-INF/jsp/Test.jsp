<%-- 
    Document   : Test
    Created on : Apr 19, 2014, 12:55:46 AM
    Author     : Prashant
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script>
            $(document).ready(function () {
                size_li = $("#myList li").size();
                x=5;
                $('#myList li:lt('+x+')').show();
                $('#loadMore').click(function () {
                    x= (x+5 <= size_li) ? x+5 : size_li;
                    $('#myList li:lt('+x+')').show();
                });
                $('#showLess').click(function () {
                    x=(x-5<0) ? 3 : x-5;
                    $('#myList li').not(':lt('+x+')').hide();
                });
            });
        </script>
        <style>
            #myList li{ display:none;
            }
            #loadMore {
                color:green;
                cursor:pointer;
            }
            #loadMore:hover {
                color:black;
            }
            #showLess {
                color:red;
                cursor:pointer;
            }
            #showLess:hover {
                color:black;
            }
        </style>
    </head>
    <body>
        <div class="shell">

            <div id="container" style="height: 630px;">
                <div class="container-cnt">
                    <div id="content">
                        <div class="cases" id="restrosearch" style="overflow-x: hidden; overflow-y:scroll;height: 600px;">
                            <!--<div id="restrosearch"class="js-search-results js-place-results js-lock-on-load " style="opacity: 1; overflow-x: hidden; overflow-y:scroll;height: 600px;">-->
                            <ul id="myList">
                                ${newRestroDetails}</ul>
                            <div id="loadMore">Load more</div>
                            <div id="showLess">Show less</div>
                            <!--</div>-->

                        </div></div>
                    <!--side div start here-->

                    <div class="js-facetedsearch js-lock-on-load widgets-narrow" id="sidebar" style="opacity: 1;">

                        <input type="hidden" value="" class="js-query">
                        <input type="hidden" value="322" class="js-default-vertical">


                        <!-- Widget -->
                        <div class="widget widget-f widget-narrow">
                            <div class="refine-box" >

                                <h5 style="font-family: times new roman;">Refine Your Search</h5>


                                <div data-originalvert="Restaurants" data-originalvertid="322" class="vertical-select " style="opacity: 1;">


                                    <section id="content" style="width: 139px;">

                                        <div class="search">
                                            <!--                                            <label>Location: </label>-->

                                            <select id="company" onchange="getModelList(this.value);" name="city" style="width: 139px;">
                                                <option value="select">Set Location</option>
                                                <option value="Delhi">Delhi</option>
                                                <option value="Noida">Noida</option>
                                            </select>
                                            <br>
                                            <!--                                            <label>Name: </label>-->
                                            <select id="model" name="name" onchange="search();" style="width: 139px;">
                                                <option value="select">Set Name</option>
                                            </select>

                                        </div>
                                    </section>
                                </div>
                                <!--
                                                                <div class="topics">
                                                                    <ul class="js-pills"></ul>
                                                                    <div class="cl">&nbsp;</div>
                                                                </div>-->
                                <!-- Checks -->
                                <!-- End R Case -->
                            </div>
                        </div>
                    </div>
                    <!-- End Widget -->
                    <div class="ad-box" id="div-gpt-ad-665430869832007653-1">
                        <script type="text/javascript">
                            googletag.cmd.push(function() { googletag.display('div-gpt-ad-665430869832007653-1'); });
                        </script>
                    </div>

                </div>
                <!--ends here--> 
            </div></div>

    </body>
</html>
