<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<html>  
<head>  
<style>  
.error{color:green}
.error1{color:blue}  
</style>  
</head>  
<body>  
<form:form action="helloagain" modelAttribute="emp"> 
Email:<form:input path="email"/>
<form:errors path="email" cssClass="error"/><br><br>
UserName: <form:input path="name"/>
 <form:errors path="name" cssClass="error"/><br><br>
Password: <form:password path="pass"/>    
<form:errors path="pass" cssClass="error1"/><br><br> 
Address:<form:input path="addrs"/> 
<form:errors path="addrs" cssClass="error"/><br>
<input type="submit" value="submit">  
</form:form>  
</body>  
</html>  