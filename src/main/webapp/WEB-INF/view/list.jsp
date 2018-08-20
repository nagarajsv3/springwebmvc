<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: JSMBABA
  Date: 8/17/2018
  Time: 6:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Teams</title>
</head>
<body>
<h1>List Teams Page</h1>
<table>
    <thead>
        <tr>
            <td>Id</td>
            <td>Team Name</td>
            <td>Rating</td>
            <td>Action</td>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${teams}" var="team">
            <tr>
                <td>${team.id}</td>
                <td>${team.name}</td>
                <td>${team.rating}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/team/edit/${team.id}" >Edit</a>
                    <a href="${pageContext.request.contextPath}/team/delete?teamid=${team.id}" >Delete</a>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>
<a href="${pageContext.request.contextPath}/">Go to Home</a>
</body>
</html>
