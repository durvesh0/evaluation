<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Wel-Come</title>
<style>
body
{
	//background-image:url("resources/images/images.jpg");
}

#a
{
	text-color:red;
	font-family:Arial;
}
</style>
</head>
<body>
<c:url var="action" value="/login"></c:url>

		<form:form action="${action}" method="post">
		<form name='f' action='j_spring_security_check' method="POST">
		
		<table align="center" >
			<tr>
				<td id="a">User Name:</td>
				<td><input type="text" name="name"></td>
			</tr>

			<tr>
				<td id="a">Password:</td>
				<td><input type="password" name="password" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Login"></td>
				<td><input type="reset" value="Cancle"></td>
			</tr>

		</table>



	</form:form>





</body>
</html>