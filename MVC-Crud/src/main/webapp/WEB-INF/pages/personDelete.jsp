<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <body bgcolor='#34C4CA'>
    <h1>Person Delete</h1>
    <form:form modelAttribute="person" method="post"
        servletRelativeAction="/mvc/deletePerson">
        <table>
            <tr>
                <td>ID</td>
                <td><form:input path="id" readonly="true" /></td>
            </tr>
            <tr>
                <td>First Name</td>
                <td><form:input path="firstName" readonly="true" /></td>
            </tr>
            <tr>
                <td>Last Name</td>
                <td><form:input path="lastName" readonly="true" /></td>
            </tr>
        </table>
        <form:button name="Delete">Delete</form:button>
    </form:form>
    <font color="red"> ${message} </font>
    </body>
 