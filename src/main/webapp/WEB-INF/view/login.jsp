<%--
  Created by IntelliJ IDEA.
  User: JSMBABA
  Date: 8/26/2018
  Time: 4:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <title>Login</title>
</head>
<body>
<h1>Login Page</h1>
<c:url var="loginVal" value="/login"/>
<form method="post" action="${loginVal}">
    <table>
        <tr>
            <td>
                User Name
            </td>
            <td>
                <input type="text" name="username">
            </td>
        </tr>
        <tr>
            <td>
                Password
            </td>
            <td>
                <input type="password" name="password">
            </td>
        </tr>
        <tr>
            <td>
                <input type="hidden" value="${_csrf.token}" name="${_csrf.parameterName}">
                <input type="submit" value="Login">
            </td>
        </tr>

    </table>

</form>

</body>
</html>
