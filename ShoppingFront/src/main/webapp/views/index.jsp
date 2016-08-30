<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01Transitional //EN""http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Wel-Come</title>

</head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<style>
/* Remove the navbar's default margin-bottom and rounded borders */
h1, h2, h3 {
	font-family: algerian;
	font-style: bold;
	font-style: italic;
}

body {
	background-image: url("resources/images/20.jpg"); //
	background-color: #666666;
}

.navbar {
	margin-bottom: 0;
	border-radius: 0;
}

#a {
	text-color:;
}
</style>

<body class="a">

<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="home">Wel-Come</a>
		</div>
		<ul class="nav navbar-nav">
			<li class="active"><a href="home" data-toggle="tooltip"
				title="Click to Home page!">Home</a></li>
			<li><a href="contact" data-toggle="tooltip"
				title="Contact with us!">Contact Us</a></li>
		</ul>
	</div>
	</nav>

	 <div class="container">
		<div class="page-header">
			<h1 align="center">HAPPY HOUR</h1>
		</div>
		<!-- <h2 align="center">
			<p>Choose Your HappyTime</p>
		</h2> -->
	</div>
	</div>
	
	<div id="contact">
		<c:if test="${isUserClickedContact==true}">

			<%@ include file="contact.jsp"%>

		</c:if>
	</div>

	<div>
		<table width="100%">
			<tr>
				<c:choose>
					<c:when test="${empty loggedInUser}">
						<td align="left"><a href="loginHere" data-toggle="tooltip"
							title="Click to Login!"><h3>Login here</a>
						</h3></td>
						<td align="bottom"><a href="registerFlow"
							data-toggle="tooltip" title="Click to Register!"><h3>Register
									here</h3></a></td>
					</c:when>
					<c:when test="${not empty loggedInUser}">
						<td><h3>Welcome ${loggedInUser},</td>
						</h3>
						<td align="center"><h3>
								<a href="logout"> logout</a></td>
						</h3>
					</c:when>

				</c:choose>
			</tr>
			<tr>
				<c:if test="${loggedOut==true}">
					<td>${logoutMessage}</td>
				</c:if>
			</tr>
			
				<tr>
					<c:if test="${isAdmin==false}">
						<td align="right"><a href="myCart"> My Cart </a>( ${cartSize})</td>
					</c:if>
				</tr>
			
		</table>
	</div>

	<div id="registerHere">
		<c:if test="${isUserClickedRegisterHere==true}">
			<td>${successMessage}</td>
			<%@ include file="register.jsp"%>
			
		</c:if>
	</div>

	<div id="loginHere">
		<c:if
			test="${isUserClickedLoginHere==true || invalidCredentials==true}">
			<div id="error" align="center">${errorMessage}</div>
			<%@ include file="login.jsp"%>
		</c:if>
	</div>
	<div id="admin">

		<c:if test="${isAdmin==true}">

			<%@ include file="admin.jsp"%>


		</c:if>
		<c:if test="${isAdmin==false}">
		
			<%@ include file="user.jsp"%>
			
		</c:if>
		<div id="categories">
			<c:if test="${isAdminClickedCategories==true}">
				<%@ include file="admin.jsp"%>
				<%@ include file="category.jsp"%>
			</c:if>
		</div>

		<div id="products">
			<c:if test="${isAdminClickedProducts==true}">
				<%@ include file="admin.jsp"%>
				<%@ include file="product.jsp"%>
			</c:if>
		</div>

		<div id="suppliers">
			<c:if test="${isAdminClickedSuppliers==true}">
				<%@ include file="admin.jsp"%>
				<%@ include file="supplier.jsp"%>
			</c:if>
		</div>
	</div>
	<div id="displayCart">
		<c:if test="${displayCart==true}">

			<table align="center" border="2">
				<tr>
					<th align="left" width="80">Cart ID</th>
					<th align="left" width="120">Product Name</th>
					<th align="left" width="200">Quantity</th>
					<th align="left" width="80">Price</th>
					<th align="left" width="60">Delete from Cart</th>

				</tr>
				<c:forEach items="${cartList}" var="cart">
					<tr>
						<td align="left">${cart.id}</td>
						<td align="left">${cart.productName}</td>
						<td align="left">${cart.quantity}</td>
						<td align="left">${cart.price}</td>
						<td align="left"><a
							href="<c:url value='/cart/remove/${cart.id}'  />">Delete</a></td>
						<td align="left"><a href="<c:url value='pay/${cart.id}' />">
								Proceed</a></td>
					</tr>
				</c:forEach>

			</table>

			<h2>Total cost : ${totalAmount}</h2>
			<%-- <a href="<c:url value='/pay/${cart.userID}'/>">Proceed</a>  --%>
			<a href="<c:url value='/pay/${cart.id}'/>">Proceed</a>
		</c:if>

	</div>
	</div>

	<%@include file="a.jsp"%>
</body>
</html>