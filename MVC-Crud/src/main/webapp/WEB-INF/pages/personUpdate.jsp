<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <body bgcolor='#3CE893'>
    <h1>Update Person</h1>
     <form:form  modelAttribute="person" method="post"
        servletRelativeAction="/mvc/updatePerson">
        <table>
            <tr>
                <td>ID</td>
                <td><form:input path="id" readonly="true" /></td>
            </tr>
            <tr>
                <td>First Name</td>
                <td><form:input path="firstName" /> <form:errors
                        path="firstName" /></td>
            </tr>
            <tr>
                <td>Last Name</td>
                <td><form:input path="lastName" /> <form:errors path="lastName" />
                </td>
            </tr>
        </table>
        <form:errors>
        </form:errors>
        <form:button name="Update">Update</form:button>
    </form:form>
    <font color="red"> ${message} </font>
    </body>
 