<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<body bgcolor='BFA0D2'>
<html>
<head>
 <meta charset="ISO-8859-1">
<title>User Report </title>
</head>
<body>
<table border="1"> 
<thead><tr>
<td><b>id<b></td>
<td><b>name</b></td>
<td><b>gender</b></td>
<td><b>addrs</b></td>
<td><b>imgLoc</b></td>
</tr></thead>
<tbody>
<c:forEach items="${personList}" var="person">
<tr>
<td>${person.id}</td>
<td>${person.name}</td>
<td>${person.gender}</td>
<td>${person.addrs}</td>
<td>${person.imgLoc}</td>
</tr>
</c:forEach> 
</tbody>

</table>
<spring:url value="/downloadExcel?type=excel" var="xlsURL"></spring:url>
<a href="${xlsURL}">Download Excel Report</a>
 <a href="${pageContext.request.contextPath}/downloadExcel">view Page</a>
 <spring:url value="/downloadPdf/?type=pdf" var="pdfURL" />
 <a href="${pdfURL}">Download Pdf Report</a>
  <a href="${pageContext.request.contextPath}/downloadPdf">view Pdf Page</a>
  ${message}

</body><br>
<a href="welcome">Home</a> 
</html>
</body>