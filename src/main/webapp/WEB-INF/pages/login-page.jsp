<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<style>
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Login</title>
</head>
<body>
<form:form method="POST" commandName="vendedor" action="${pageContext.request.contextPath}/vendedor/login.html">
	<h1>Signup</h1>
	<p>Username <form:input path="usuario" /></p>
	<p>Password <form:input path="pass" /></p>
	<p>Nombre <form:input path="nombre" /></p>
	<p>Apellido <form:input path="apellido" /></p>
	<input type="submit" value="login" />
</form:form>
</body>
</html>