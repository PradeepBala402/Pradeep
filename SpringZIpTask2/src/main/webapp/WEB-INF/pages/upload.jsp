<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<body bgcolor='#AD9287'>
<h2 center style='color:cyan'>Spring Task</h2>
<form action="${pageContext.request.contextPath}/fileUpload"  method="GET">
	<span style='color:red'><b>Add Only Excel Files</b></span>: <input type="file" name="file" required multiple accept=".xls,.xlsx"><br>
	<input type="submit" value="submit" />
</form>
<br>
<span style='color:#ff0066'> ${message}</span>
 
<h3><center style='color:#9685B8'>Add any Files</center></h3>
 <form:form method="post" action="${pageContext.request.contextPath}/zipFile" modelAttribute="uploadForm" enctype="multipart/form-data">
<span style='color:yellow'><b>Add Any File</b></span>:<input type="file" name="file">
 <br>
 <input type="submit" value="upload">
 </form:form>
 
 <h3><center style='color:#9685B8'>Add Only Zip Files</center></h3>
 
 <form:form method="post" action="${pageContext.request.contextPath}/toZipToUnZip"  enctype="multipart/form-data">
 <span style='color:#B9DD1E'><b>Add only Zip Files</b></span>:<input type="file" name="file">
 <br>
 <input type="submit" value="upload">
 </form:form>
 <h3><center style='color:#9685B8'>Static Zip File is fixed path and filename</center></h3>
 <span style='color:#E55012'><a href ="unzip">unzip</a></span>
  <h3><center style='color:#9685B8'>Download the file</center></h3>
<spring:url value="/downloadExcel?type=excel" var="xlsURL"></spring:url>

 <a href="${pageContext.request.contextPath}/downloadExcel">view Page</a>
   </body>