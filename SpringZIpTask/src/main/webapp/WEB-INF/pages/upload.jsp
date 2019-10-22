<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<form action="${pageContext.request.contextPath}/fileUpload"  method="GET">
	Add Files: <input type="file" name="file" required multiple accept=".xls,.xlsx">
	<input type="submit" value="submit" />
</form>
 