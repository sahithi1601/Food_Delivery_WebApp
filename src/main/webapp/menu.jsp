<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.model.Menu" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Menu</title>
<style>
body { font-family: Arial; background: #f4f4f4; margin: 0; }
.grid-container { display: grid; grid-template-columns: repeat(auto-fill,minmax(280px,1fr)); gap: 20px; padding: 20px; }
.card { background:white; border-radius:12px; box-shadow:0 4px 10px rgba(0,0,0,0.1); overflow:hidden; transition:0.3s; }
.card:hover { transform: translateY(-5px); }
.card img { width:100%; height:180px; object-fit:cover; }
.card-content { padding: 15px; }
.title { font-weight:bold; font-size: 17px; }
.meta { display:flex; justify-content:space-between; margin:8px 0; font-size:14px; }
.add-cart { margin-top:12px; width:100%; padding:10px; background:#ff5722; color:white; border:none; border-radius:8px; cursor:pointer; }
.add-cart:hover { background:#e64a19; }
</style>
</head>
<body>

<h2 style="padding:20px;">Menu Items</h2>

<section class="grid-container">
<%
List<Menu> menuList = (List<Menu>) request.getAttribute("menuList");
if (menuList != null) {
    for (Menu m : menuList) {
%>
<div class="card">
    <img src="<%= request.getContextPath() + "/" + m.getImageUrl() %>" />
    <div class="card-content">
        <div class="title"><%= m.getName() %></div>
        <div class="meta">
            <span>⭐ <%= m.getRating() %></span>
            <span>₹<%= m.getPrice() %></span>
        </div>
        <div><%= m.getDescription() %></div>
        
        
        
        
        <form action="cart"> 
        <input type="Hidden" name="id" value="<%=m.getMenuId() %>">
         <input type="Hidden" name="restaurantId" value="<%=m.getRestaurantId() %>">
         <input type="Hidden" name="quantity" value="1">
         <input type="Hidden" name="action" value="add">
        <input type="submit" value="Add to cart">
        
        </form>
       
    </div>
</div>
<%
    }
}
%>
</section>

</body>
</html>
