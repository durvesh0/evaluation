<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>USER page</title>
</head>
<body>
<div>
				<c:if test="${!empty selectedProduct.name}">
					<table>
						<tr>
							<th align="left" width="80">Product ID</th>
							<th align="left" width="120">Product Name</th>
							<th align="left" width="80">Price</th>
						</tr>
						<tr>
							<td align="left">${selectedProduct.id}</td>
							<td align="left">${selectedProduct.name}</td>
							<td align="left">${selectedProduct.price}</td>
						</tr>
					</table>
				</c:if>
			</div>


	<div class="container">
		<table align="center" border="2">
			<tr>
				<th width="80">Product ID</th>
				<th width="120">Product Name</th>
				<th width="120">Product Price</th>
				<th width="120">Product image</th>
				<th width="120">Add to Cart</th>
			</tr>
			<c:forEach items="${productList}" var="product">
				<tr>
					<td>${product.id}</td>
					<td>${product.name}</td>
					<td>${product.price}</td>
					<td>${product.fpath}</td>
					<td align="left"><a
									href="<c:url value='/cart/add/${product.id}' />">Add to Cart</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>


	 <c:forEach items="${categoryList}" var="category">
						<li><a href=${category.id}>${category.id}</a>
							<ul>
								<c:forEach items="${Product.category_id}" var="product">

									<li><a href="<c:url value='product/get/${product.id}' />">${product.name}</a></li>

								</c:forEach>

							</ul></li>
					</c:forEach>  
</body>
</html>