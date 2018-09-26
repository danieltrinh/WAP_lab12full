<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Daniel
  Date: 9/26/2018
  Time: 4:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Products</title>
    <script src="/resources/script.js"></script>
</head>
<body>
    The Products
    <c:forEach items="${products}" var="product">
        <div id="product_${product.id}" class="product_container"
             data-id="${product.id}">
                ${product.name} - ${product.price}
            <button class="add_to_cart">Add To Cart</button>
        </div>
    </c:forEach>
</body>
</html>
