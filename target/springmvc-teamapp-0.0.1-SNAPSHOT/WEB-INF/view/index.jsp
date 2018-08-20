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
    <title>Team Home</title>
  </head>
  <body>
    <h1>Teams Home Page</h1><br />
  <p>
    Context Path : <c:out value="${pageContext.request.contextPath}" /><br />
    <a href="${pageContext.request.contextPath}/team/add">Add New Team</a><br />
    <a href="${pageContext.request.contextPath}/team/list">List Teams</a><br />
  </p>

  Add Team Message : ${message}
  </body>
</html>