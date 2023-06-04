<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Form</title>
<form:form action="processForm" modelAttribute="student">
First Name <form:input path="firstName" />
	<br>
Last Name <form:input path="lastName" />
	<br>
	<form:button type="submit">Submit</form:button>
</form:form>
</head>
<body>

</body>
</html>