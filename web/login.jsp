<%--
  Created by IntelliJ IDEA.
  User: Daniel
  Date: 9/25/2018
  Time: 10:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <form method="post" action="/login">
        Username: <input type="text" name="username" value="${cookie.username.value}">
        <br>
        Password: <input type="password" name="password">
        <br>
        <label for="remember">
            <input type="checkbox" name="remember" id="remember">
            Remember me
        </label>
        <br>
        <input type="submit" value="Login">
    </form>
    <div style="color: red;">${message}</div>
</body>
</html>
