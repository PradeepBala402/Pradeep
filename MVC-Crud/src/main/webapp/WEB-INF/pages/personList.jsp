<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <body bgcolor='#D724E2'>
<h1>Person List</h1>
<a href = "<%=request.getContextPath()%>/mvc/createPerson">Create</a><br><br>
    <br/>
    <br/>
    <table border="1">
        <thead>
            <tr>
                <td align="center">ID</td>
                <td align="center">First Name</td>
                <td align="center">Last Name</td>
                <td align="center" colspan="2">Action</td>
            </tr>
        </thead>
         <c:forEach items="${persons}" var="person">
            <tr>
                <td>${person.id}</td>
                <td>${person.firstName}</td>
                <td>${person.lastName}</td>
                <td>
                    <form action="<%=request.getContextPath()%>/mvc/updatePerson/${person.id}" method="get">
                        <input type="submit" value="Update">
                    </form>
                </td>
                <td>
                    <form action="<%=request.getContextPath()%>/mvc/deletePerson/${person.id}" method="get">
                        <input type="submit" value="Delete">
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
    <br />
    <font color="blue"> ${message} </font>
    </body>