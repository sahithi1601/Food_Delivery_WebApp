<%@ page import="java.util.List,com.model.Restaurant" %>
<%@ page session="true" %>

<%
if (session.getAttribute("admin") == null) {
    response.sendRedirect(request.getContextPath() + "/admin/adminLogin.jsp");
    return;
}
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add Menu Item</title>
    <style>
        /* General body styling */
        body {
            font-family: 'Arial', sans-serif;
            background: #f2f2f2;
            margin: 0;
            padding: 0;
        }

        /* Centered form container */
        .form-box {
            width: 450px;
            background: #fff;
            padding: 30px 40px;
            margin: 50px auto;
            border-radius: 10px;
            box-shadow: 0 4px 15px rgba(0, 0, 0, 0.2);
        }

        /* Form title */
        .form-box h2 {
            text-align: center;
            margin-bottom: 25px;
            color: #333;
        }

        /* Labels */
        .form-box label {
            display: block;
            margin-top: 15px;
            margin-bottom: 5px;
            font-weight: bold;
        }

        /* Input fields styling */
        .form-box input, .form-box select {
            width: 100%;
            padding: 12px 15px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 6px;
            font-size: 14px;
            transition: all 0.3s ease;
        }

        /* Input focus effect */
        .form-box input:focus, .form-box select:focus {
            border-color: #007bff;
            box-shadow: 0 0 5px rgba(0, 123, 255, 0.5);
            outline: none;
        }

        /* Button styling */
        .form-box button {
            width: 100%;
            padding: 12px;
            margin-top: 20px;
            background: #007bff;
            color: #fff;
            font-size: 16px;
            border: none;
            border-radius: 6px;
            cursor: pointer;
            transition: background 0.3s ease;
        }

        /* Button hover effect */
        .form-box button:hover {
            background: #0056b3;
        }

        /* Error message styling */
        .form-box p {
            color: red;
            text-align: center;
            margin-top: 10px;
        }

        /* Responsive */
        @media (max-width: 500px) {
            .form-box {
                width: 90%;
                padding: 20px;
            }
        }
    </style>
</head>
<body>

<div class="form-box">
    <h2>Add Menu Item</h2>

    <form action="<%= request.getContextPath() %>/addMenu" method="post">
        <label>Select Restaurant</label>
        <select name="restaurantId" required>
            <option value="">-- Select Restaurant --</option>
            <%
            List<Restaurant> restaurants = (List<Restaurant>) request.getAttribute("restaurants");
            if (restaurants != null) {
                for (Restaurant r : restaurants) {
            %>
                <option value="<%= r.getId() %>"><%= r.getName() %> - <%= r.getLocation() %></option>
            <%
                }
            }
            %>
        </select>

        <label>Item Name</label>
        <input type="text" name="itemName" required>

        <label>Description</label>
        <input type="text" name="description">

        <label>Price</label>
        <input type="number" step="0.01" name="price" required>

        <label>Rating</label>
        <input type="number" step="0.1" name="rating">

        <label>Image URL</label>
        <input type="text" name="image" required>

        <button type="submit">Add Menu</button>
    </form>

    <%
    String error = request.getParameter("error");
    if (error != null) {
        String msg = "";
        switch(error) {
            case "missing": msg = "Please fill in all required fields."; break;
            case "invalidNumber": msg = "Price or Rating must be a valid number."; break;
            case "1": msg = "Failed to add menu item."; break;
        }
    %>
        <p><%= msg %></p>
    <% } %>
</div>

</body>
</html>

