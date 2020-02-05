<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<style>
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>List</title>
</head>
<body>
<h1>List</h1>
<table border="1px" cellpadding="0" cellspacing="0" >
<thead>
<tr>
<th width="15%">Marca</th><th width="10%">Modelo</th><th width="10%">Precio</th>
</tr>
</thead>
<tbody>
<c:forEach var="coche" items="${coches}">
<tr>
	<td>${coche.marca}</td>
	<td>${coche.modelo}</td>
	<td>${coche.precio}</td>
</tr>
</c:forEach>
</tbody>
</table>
<p><a href="${pageContext.request.contextPath}/index.html">Home page</a></p>

</body>
</html>