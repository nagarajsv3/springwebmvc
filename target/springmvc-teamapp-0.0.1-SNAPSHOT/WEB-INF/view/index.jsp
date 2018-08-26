<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: JSMBABA
  Date: 8/17/2018
  Time: 6:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Team Home</title>
</head>
<body>
<c:url value="/logout" var="logout"/>
<h1>Teams Home Page</h1><br/> <a href="${logout}">Logout</a>

<h6> Welcome <security:authentication property="principal"/>
    <security:authentication property="principal.username"/></h6>
    <p>
        Context Path : <c:out value="${pageContext.request.contextPath}"/><br/>
        <security:authorize access="hasRole('ROLE_ADMIN')">
            <a href="${pageContext.request.contextPath}/team/add">Add New Team</a><br/>
        </security:authorize>
        <a href="${pageContext.request.contextPath}/team/list">List Teams</a><br/>
    </p>

    Add Team Message : ${message}
</body>
</html>