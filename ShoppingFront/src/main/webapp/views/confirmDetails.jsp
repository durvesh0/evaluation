<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring Mvc WebFlow Demo</title>
</head>

<body>
	<div class="content">
		<fieldset>
			<legend>Confirm Details</legend>
			<!-- for triggering webflow events using links,
					 the eventId to be triggered is given in "href" attribute as:
				 -->
			<a href="${flowExecutionUrl}&_eventId_home">Home</a><br /> <br />
			<form:form action="user/register" method="post" modelAttribute="user" commandName="user" id="form">
				<form:label path="id">User ID :</form:label>${user.id}
					<br />
				<br />
				<form:label path="name"> User Name:</form:label>${user.name}
					<br />
				<br />
				<form:label path="password">Password :</form:label>${user.password}
					<br />


				<form:label path="email">Email:</form:label>${user.email}
					<br />
				<br />
				<form:label path="mob">Mobile #:</form:label>${user.mob}
					<br />
				<br />
				<form:label path="add">Address :</form:label>${user.add}
					<br />
				<br />
				<input name="_eventId_edit" type="submit" value="Edit" />
				<input name="_eventId_submit" type="submit" value="Confirm Details" />
				<br />
			</form:form>
		</fieldset>
	</div>
</body>
</html>