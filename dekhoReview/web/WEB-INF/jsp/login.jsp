<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.5.2/jquery.min.js"></script>
<script type="text/javascript">
	function getUser() {
		var value = $('#searchValue').text();
		alert(value);
		$.ajax( {

			type :"GET",
			url :"getUser.do",
			data :"value=" + value,
			success : function(result) {
				$('#result').html(
						'<table ><tr><th>UserName : </th><td>'
								+ result.userName
								+ '</td></tr><tr><th>Roll :</th> <td>'
								+ result.roll
								+ '</td></tr><tr><th> PassWord : </th><td>'
								+ result.passWord + '</td></tr></table>');
				$('#result').slideDown("slow");

			},

			error : function(x, e) {
				alert(x.status);
				alert('Error: ' + x);

			}
		})
	}

	function getUserName() {

		var value = $('#searchText').val();

		$
				.ajax( {

					type :"GET",
					url :"getUserName.do",
					data :"value=" + value,
					success : function(result) {
						if (result == "User Not Found"
								|| result == "Please Enter A value") {
							$('#search').html('<p>' + result + '</p>');

						} else {

							$('#search')
									.html(
											'<p id="searchValue" >' + result + '</p><input type="button"  value="Search" onclick="getUser()"/>');
						}
					},

					error : function(x, e) {
						alert(x.status);
						alert('Error: ' + x);

					}
				})
	}
</script>
<title>Insert title here</title>
</head>
<body
	style="background-image: url('http://www.evatools.com/images/3d14.jpg');">
<div><form:form method="post" action="loginUser.do" modelAttribute="user">
	<table>
		<tr>
			<td></td>
			<td><form:errors path="*" cssStyle="color : red;"
				cssClass="error" /></td>
		</tr>
		<tr>
			<td><form:label path="userName">
				<spring:message code="label.userName" />
			</form:label></td>
			<td><form:input path="userName" /></td>
		</tr>
		<tr>
			<td><form:label path="passWord">
				<spring:message code="label.passWord" />
			</form:label></td>
			<td><form:input path="passWord" /></td>
		</tr>
		<tr>
			<td></td>
			<td colspan="2"><input type="submit" value="signUp" /></td>
		</tr>
	</table>

</form:form> <a href="signInUser.do">SignIn</a> <input type="text" id="searchText"
	onkeyup="getUserName()" /></div>
<div id="search"></div>
<div id="result"></div>
<!--<c:if test="${ !empty userlist}">
	<table>
		<tr>
			<th>UserName</th>
			<th>Roll</th>
			<th>PassWord</th>
		</tr>
		<c:forEach items="${userlist}" var="user">
			<tr>
				<td>${user.userName}</td>
				<td>${user.roll }</td>
				<td>${user.passWord }</td>
				<td><a href="delete/${user.userName}.do">delete<img
					src="C:\index.jpg" style="size: 30px; height: 20px;"></a></td>
				<td><a href="editUser/${user.userName}.do">edit<img
					src="C:\images1.jpg" style="size: 30px; height: 20px;"> </a></td>
				<td><a href="deleteAll.do">Delete All</a></td>
			</tr>
		</c:forEach>
	</table>
</c:if>-->
</body>
</html>