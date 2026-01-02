<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.List,com.model.Restaurant" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Foodie Hub | Restaurants</title>

<style>
body {
    margin: 0;
    font-family: Arial, sans-serif;
    background: #f5f5f5;
}

/* ---------- NAVBAR ---------- */
.navbar {
    background: #ff5722;
    padding: 15px 40px;
    display: flex;
    justify-content: space-between;
    align-items: center;
    color: white;
}

.navbar h2 {
    margin: 0;
}

.navbar ul {
    list-style: none;
    display: flex;
    gap: 25px;
    margin: 0;
    padding: 0;
}

.navbar a {
    color: white;
    text-decoration: none;
    font-weight: bold;
}

.navbar a:hover {
    text-decoration: underline;
}

/* ---------- GRID ---------- */
.grid-container {
    display: grid;
    grid-template-columns: repeat(auto-fill, minmax(260px, 1fr));
    gap: 25px;
    padding: 30px;
}

/* ---------- CARD ---------- */
.card {
    background: white;
    border-radius: 12px;
    box-shadow: 0 4px 12px rgba(0,0,0,0.1);
    overflow: hidden;
    transition: transform 0.3s, box-shadow 0.3s;
}

.card:hover {
    transform: translateY(-6px);
    box-shadow: 0 6px 16px rgba(0,0,0,0.2);
}

.card img {
    width: 100%;
    height: 180px;
    object-fit: cover;
}

.card-content {
    padding: 15px;
}

.title {
    font-size: 18px;
    font-weight: bold;
}

/* ---------- META ---------- */
.meta {
    display: flex;
    justify-content: space-between;
    margin: 8px 0;
    font-size: 14px;
}

.rating {
    background: #2ecc71;
    color: white;
    padding: 3px 8px;
    border-radius: 6px;
}

.location, .cuisine {
    font-size: 14px;
    color: #555;
}

/* ---------- BUTTON ---------- */
.view-menu {
    margin-top: 12px;
    width: 100%;
    padding: 10px;
    background: #ff5722;
    color: white;
    border: none;
    border-radius: 8px;
    cursor: pointer;
    font-size: 15px;
}

.view-menu:hover {
    background: #e64a19;
}
</style>
</head>

<body>

<!-- NAVBAR -->
<div class="navbar">
    <h2>🍽 Foodie Hub</h2>
    <ul>
        <li><a href="restaurants">Home</a></li>
        <li><a href="restaurants">Restaurants</a></li>
        <li><a href="Cart.jsp">Cart</a></li>
        <li><a href="login.jsp">Login</a></li>
        <li> <a href="admin/adminLogin.jsp" class="admin-link">Admin</a></li>
    </ul>
</div>

<!-- RESTAURANT GRID -->
<section class="grid-container">

<%
List<Restaurant> restaurants =
        (List<Restaurant>) request.getAttribute("restaurants");

if (restaurants != null && !restaurants.isEmpty()) {
    for (Restaurant r : restaurants) {
%>

<div class="card">
    <img src="<%= r.getImage() %>" alt="Restaurant Image">
    <div class="card-content">
        <div class="title"><%= r.getName() %></div>

        <div class="meta">
            <span class="rating">⭐ <%= r.getRating() %></span>
            <span><%= r.getEta() %> mins</span>
        </div>

        <div class="cuisine">🍴 <%= r.getCuisine() %></div>
        <div class="location">📍 <%= r.getLocation() %></div>

        <a href="menu?restaurantId=<%= r.getId() %>">
            <button class="view-menu">View Menu</button>
        </a>
    </div>
</div>

<%
    }
} else {
%>
    <h2>No restaurants available</h2>
<%
}
%>

</section>

</body>
</html>

    