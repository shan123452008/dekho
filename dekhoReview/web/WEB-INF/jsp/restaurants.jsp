<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
<title>RS-1 Clean | Style Demo</title>
<meta charset="iso-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="styles/layout.css" type="text/css" media="all">
<link rel="stylesheet" href="styles/mediaqueries.css" type="text/css" media="all">
<script src="scripts/jquery-1.7.2.min.js"></script>
<script src="scripts/jquery-defaultvalue.js"></script>
<script src="scripts/jquery-mobilemenu.min.js"></script>
<script>
$(document).ready(function () {
    $('.topnav').mobileMenu({
        combine: false,
        switchWidth: 600,
		indentString: '&nbsp;&nbsp;&nbsp;',
        prependTo: 'nav#topnav'
    });
});
</script>
<!--[if lt IE 9]>
<link rel="stylesheet" href="styles/ie.css" type="text/css" media="all">
<script src="scripts/css3-mediaqueries.min.js"></script>
<script src="scripts/html5shiv.min.js"></script>
<![endif]-->
</head>
<body>
<div class="wrapper row1">
  <header id="header">
    <hgroup>
      <h1><a href="index.html">DekhoReview.com</a></h1>
      <h1>Adding Hotel</h1>
    </hgroup>
    <!-- ################################################################################################ -->
    <nav id="topnav">
      <ul class="topnav clear">
        <li><a href="index.html">Homepage</a></li>
        <li class="active"><a href="style-demo.html">Style Demo</a></li>
        <li><a href="full-width.html">Full Width</a></li>
        <li><a href="gallery.html">Gallery</a></li>
        <li><a href="portfolio.html">Portfolio</a></li>
        <li class="last"><a href="#">Link Text</a></li>
      </ul>
    </nav>
    <div class="clear"></div>
  </header>
</div>
<!-- content -->
<div class="wrapper row3">
  <div id="container">
  
<form:form method="post" action="addRestro.do" modelAttribute="addRestro">
	<table>
		
		<tr>
			<td>Restaurants Name</td>
			<td><input type="text" id="hotelName" name="hotelName" value=""></td>
		</tr>
		<tr>
			<td>Phone Number</td>
			<td><input type="text" id="phone1" name="phone1" value="">
			    <input type="text" id="phone2" name="phone2" value=""></td>
		</tr>
		
		<tr>
			<td>Address</td>
			<td><input type="text" id="address" name="address" value=""></td>
		</tr>
		<tr>
			<td>Food Type</td>
			<td><input type="text" id="food" name="food" value=""></td>
		</tr>
		<tr>
			<td>Opening hours</td>
			<td><input type="text" id="openingHours" name="openingHours" value=""></td>
		</tr>
		<tr>
			<td>Cost</td>
			<td><input type="text" id="cost" name="cost" value=""></td>
		</tr>
		<tr>
			<td></td>
			<td colspan="2"><input type="submit" value="submit" /></td>
		</tr>
	</table>

</form:form>
</div></div>

      
   
</div>

</body>
</html>
