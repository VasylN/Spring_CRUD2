<%--
  Created by IntelliJ IDEA.
  User: Pc
  Date: 13.09.2017
  Time: 21:57
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Manager</title>
</head>

<body>
<div>
    <h1>User Manager</h1>
    <c:if test="${!empty users}">
        <table border="1" cellpadding="8" cellspacing="0">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Age</th>
                <th>Admin</th>
                <th>Created Date</th>
                <th>&nbsp;</th>
                <th>&nbsp;</th>
            </tr>
            <c:forEach items="${users}" var="user">
                <tr>
                    <td>${user.id}</td>
                    <td>${user.name}</td>
                    <td>${user.age}</td>
                    <td><c:if test="${user.admin==true}">+</c:if></td>
                    <td>${user.createdDate}</td>
                    <td><a href="updateUser/${user.id}">Update</a> </td>
                    <td><a href="deleteUser/${user.id}">Delete</a> </td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</div>
<a href="addUser">Add user</a>
</body>
</html>

