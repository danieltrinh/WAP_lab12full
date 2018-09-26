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
    <script type="text/javascript"
            src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="/resources/script.js"></script>
</head>
<body>
    The Products
    <div style="color: red">${message}</div>
    <div id="product_list">
        <c:forEach items="${products}" var="product">
            <div id="product_${product.id}" class="product_container"
                 data-productid="${product.id}" data-price="${product.price}">
                    ${product.name} - ${product.price}
                <button class="add_to_cart">Add To Cart</button>
            </div>
        </c:forEach>
    </div>
<hr>
    <div id="shopping_cart">

    </div>

    <form action="/checkout" method="post">
        <button id="checkout_btn" disabled>Checkout</button>
    </form>

</body>
</html>
