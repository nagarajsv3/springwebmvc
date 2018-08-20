<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: JSMBABA
  Date: 8/17/2018
  Time: 6:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Edit Team</title>
</head>
<body>
<h1>ICC Ranking - Edit Team</h1>
<form:form commandName="team" method="post" action="${pageContext.request.contextPath}/team/update/${team.id}">

    <table>
        <tr>
            <td><form:label path="name">Team Name</form:label></td>
            <td><form:input path="name" /></td>
        </tr>
        <tr>
            <td><form:label path="rating">Rating</form:label></td>
            <td><form:input path="rating" /></td>
        </tr>
    </table>

    <input type="submit" value="EditTeam">
</form:form>

<a href="${pageContext.request.contextPath}/">Go to Home</a>

</body>
</html>
