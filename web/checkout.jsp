<%@ page import="model.Product" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Daniel
  Date: 9/26/2018
  Time: 6:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Checkout</title>
</head>
<body>
    <%! double total = 0; %>
    <% List<Product> products = (ArrayList<Product>)  request.getAttribute("products"); %>
    <% for(Product pr : products){ %>
        <%= pr.getName() +"-"+pr.getPrice() %>
        <% total += pr.getPrice(); %><br>
    <% } ; %>

    Total: <%= total %>
</body>
</html>
