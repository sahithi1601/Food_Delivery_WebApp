<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.model.Cart, com.model.CartItem" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Cart</title>

<style>
body {
    background: #2c2c2c;
    font-family: Arial, sans-serif;
    color: #fff;
    display: flex;
    justify-content: center;
    padding: 40px;
}

.cart {
    width: 380px;
    border: 2px solid #f5e38a;
    padding: 20px;
    border-radius: 8px;
    background: #1e1e1e;
}

.cart h2 {
    text-align: center;
    color: #f5e38a;
}

.item {
    border: 1px solid #f5e38a;
    padding: 12px;
    margin-bottom: 15px;
    border-radius: 6px;
}

.item-name {
    font-weight: bold;
}

.quantity-controls {
    display: flex;
    align-items: center;
    gap: 10px;
    margin-top: 10px;
}

.qty-btn {
    width: 30px;
    height: 30px;
    border: 1px solid #f5e38a;
    background: transparent;
    color: #fff;
    cursor: pointer;
}

.qty-value {
    min-width: 20px;
    text-align: center;
}

.remove-btn, .main-btn {
    width: 100%;
    margin-top: 10px;
    padding: 8px;
    border: 1px solid #f5e38a;
    background: transparent;
    color: #f5e38a;
    cursor: pointer;
}

.remove-btn {
    border-color: #ff6b6b;
    color: #ff6b6b;
}
</style>
</head>

<body>

<div class="cart">
<h2>Cart</h2>

<%
Cart cart = (Cart) session.getAttribute("cart");

if (cart != null && !cart.getItems().isEmpty()) {
    for (CartItem item : cart.getItems().values()) {
%>

<div class="item">
    <div class="item-name"><%= item.getName() %></div>
    <div>Price: ₹<%= item.getPrice() %></div>
    <div>Total: ₹<%= item.getPrice() * item.getQuantity() %></div>

    <div class="quantity-controls">

        <!-- + -->
        <form action="cart" method="post">
            <input type="hidden" name="action" value="update">
            <input type="hidden" name="id" value="<%= item.getId() %>">
            <input type="hidden" name="quantity" value="<%= item.getQuantity() + 1 %>">
            <button class="qty-btn">+</button>
        </form>

        <div class="qty-value"><%= item.getQuantity() %></div>

        <!-- - -->
        <form action="cart" method="post">
            <input type="hidden" name="action" value="update">
            <input type="hidden" name="id" value="<%= item.getId() %>">
            <input type="hidden" name="quantity" value="<%= item.getQuantity() - 1 %>">
            <button class="qty-btn" <%= item.getQuantity() == 1 ? "disabled" : "" %>>−</button>
        </form>
    </div>

    <!-- Remove -->
    <form action="cart" method="post">
        <input type="hidden" name="action" value="delete">
        <input type="hidden" name="id" value="<%= item.getId() %>">
        <button class="remove-btn">Remove</button>
    </form>
</div>

<%
    }
} else {
%>

<p style="text-align:center;color:red;">Your cart is empty</p>

<a href="restaurants">
    <button class="main-btn">Add Items</button>
</a>

<%
}
%>

<% if (cart != null && !cart.getItems().isEmpty()) { %>
<form action="Checkout.jsp" method="post">
    <button class="main-btn">Proceed to Checkout</button>
</form>
<% } %>

</div>
</body>
</html>
