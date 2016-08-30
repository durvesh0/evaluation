<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Product Page</title>

</head>
<body>
	<%-- <h1 align="center">Add a Product</h1>

	<c:url var="addAction" value="/product/add"></c:url>

	<form:form action="${addAction}" commandName="product">
		<table align="center">
			<tr>

				<td><form:label path="id">
						<spring:message text="ID" />
					</form:label></td>
				<c:choose>
					<c:when test="${!empty product.id}">
						<td><form:input path="id" disabled="true" readonly="true" /></td>
					</c:when>

					<c:otherwise>
						<td><form:input path="id" pattern=".{4,12}" required="true"
								title="id should contains 4 to 12 characters" /></td>
					</c:otherwise>
				</c:choose>
			<tr>
				<form:input path="id" hidden="true" />
				<td><form:label path="name">
						<spring:message text="Name" />
					</form:label></td>
				<td><form:input path="name" required="true" /></td>
			</tr>


			<tr>
				<td><form:label path="price">
						<spring:message text="Price" />
					</form:label></td>
				<td><form:input path="price" required="true" /></td>
			</tr>

			<tr>
				<td><form:label path="category_id"><spring:message text="Category" /></form:label></td>
				<td><form:select path="category_id" items="${categoryList}" itemValue="id" itemLabel="id" /></td>
			</tr> 
			
			<tr>
				<td><form:label path="supplier_id"><spring:message text="Supplier" /></form:label></td>
				<td><form:select path="supplier_id" items="${supplierList}" itemValue="id" itemLabel="id" /></td>
			</tr> 
	
			<tr>
				<td colspan="2"><c:if test="${!empty product.name}">
						<input type="submit" value="<spring:message text="Edit Product"/>" />
					</c:if> <c:if test="${empty product.name}">
						<input type="submit" value="<spring:message text="Add Product"/>" />
					</c:if></td>
			</tr>
		</table>
	</form:form>
	<br>
		<form:form method="POST" action="uploadFile" enctype="multipart/form-data">
		<table align="center">
			<tr>
				<td>File to upload: <input type="file" name="file">
				</td>
			</tr>
			<tr>
				<td><input type="submit" value="Upload"></td>
			</tr>
	</table></form:form> --%>

	<h1 align="center">Add a Product</h1>

	<c:url var="addAction" value="/product/add"></c:url>

	<form:form action="${addAction}" commandName="product">
		<table align="center">
			<tr>

				<td><form:label path="id">
						<spring:message text="ID" />
					</form:label></td>
				<c:choose>
					<c:when test="${!empty product.id}">
						<td><form:input path="id" disabled="true" readonly="true" /></td>
					</c:when>

					<c:otherwise>
						<td><form:input path="id" pattern=".{4,12}" required="true"
								title="id should contains 4 to 12 characters" /></td>
					</c:otherwise>
				</c:choose>
			<tr>
				<form:input path="id" hidden="true" />
				<td><form:label path="name">
						<spring:message text="Name" />
					</form:label></td>
				<td><form:input path="name" required="true" /></td>
			</tr>


			<tr>
				<td><form:label path="price">
						<spring:message text="Price" />
					</form:label></td>
				<td><form:input path="price" required="true" /></td>
			</tr>

			<form:form method="POST" action="uploadFile"
				enctype="multipart/form-data" commandName="product">

				<tr>
					<td><form:label path="fpath">
							<spring:message text="File to Upload" />
						</form:label></td>
					<td><form:input path="fpath" type="file" name="file" /></td>
				</tr>
				<tr>
					<td><h4>
							<input type="submit" value="Add Product"> Press here to
							add the product
						</h4></td>
				</tr>
			</form:form>
		</table>
	</form:form>
	<br>

	<h3 align="center">Product List</h3>
	<c:if test="${!empty productList}">
		<table align="center" border="2">
			<tr>
				<th width="80">Product ID</th>
				<th width="120">Product Name</th>
				<th width="120">Product Price</th>
				<th width="120">Product Image</th>
				<th width="60">Edit</th>
				<th width="60">Delete</th>
			</tr>
			<c:forEach items="${productList}" var="product">
				<tr>
					<td>${product.id}</td>
					<td>${product.name}</td>
					<td>${product.price}</td>
					<td><img alt="image" src="${product.fpath}"></td>
					<td><a href="<c:url value='product/edit/${product.id}' />">Edit</a></td>
					<td><a href="<c:url value='product/remove/${product.id}' />">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>