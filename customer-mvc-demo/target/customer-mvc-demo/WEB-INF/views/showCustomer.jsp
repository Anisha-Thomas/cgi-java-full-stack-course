<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Form</title>
</head>
<body>
	<h1>Customer Form</h1>
	<form:form action="processCustomer" modelAttribute="customer">
		First Name <form:input path="firstName" />
		<br>
		Last Name <form:input path="lastName" />
		<br>
		Email <form:input path="email" />
		<br>
		<form:button type="submit">Submit</form:button>
	</form:form>
</body>
</html>