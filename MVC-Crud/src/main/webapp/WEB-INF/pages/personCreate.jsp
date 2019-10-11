<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<%@ taglib uri="http://www.springframework.org/tags" prefix="tags" %>
<html>
<head>
<style type="text/css">
.error {
	color: red;
}
</style>
</head>
<body bgcolor='#C2CA34'>
<h1>Create Person</h1>
<form:form modelAttribute="person" method="post"
	servletRelativeAction="/mvc/createPerson">
	
	<table>
	 
		<tr>
			<td>Id::</td>
			<td><form:input path="id" placeholder="sno" required="id must be integer" /></td>
			<td><form:errors path="id" cssClass="error"></form:errors></td>
		</tr>
		<tr>
			<td>First Name</td>
			<td><form:input path="firstName" placeholder="firstname" required="name characters"/></td>
			<td><form:errors path="firstName" cssClass="error"></form:errors></td>
		</tr>
		<tr>
			<td>Last Name</td>
			<td><form:input path="lastName" placeholder="lastname" required="name character" /></td>
			<td><form:errors path="lastName" cssClass="error"></form:errors></td>
		</tr>
	</table>
	<form:button name="Create">Create</form:button>&nbsp;&nbsp;
        <a href="listPersons">Show details</a>
</form:form>
<br />
<font color="red"> ${message} </font>
</body>
</html>
<!-- required="id must be integer" --> 
<!-- c  -->
<!-- required="name character" -->