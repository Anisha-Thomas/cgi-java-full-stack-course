<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Name </title>
</head>
<body>
First Name:- <% out.println(request.getAttribute("fname")); %> <br>
Last Name:- <% out.println(request.getAttribute("lname")); %><br>
Email:- <% out.println(request.getAttribute("email")); %><br>
</body>
</html>