<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    // Redirect if admin not logged in
    if (session.getAttribute("admin") == null) {
        response.sendRedirect("adminLogin.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add Restaurant</title>
    <style>
        /* General body styling */
        body {
            font-family: 'Arial', sans-serif;
            background: #f2f2f2;
            margin: 0;
            padding: 0;
        }

        /* Centering the form container */
        .form-box {
            width: 400px;
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

        /* Input fields styling */
        .form-box input {
            width: 100%;
            padding: 12px 15px;
            margin: 10px 0;
            border: 1px solid #ccc;
            border-radius: 6px;
            font-size: 14px;
            transition: all 0.3s ease;
        }

        /* Input focus effect */
        .form-box input:focus {
            border-color: #007bff;
            box-shadow: 0 0 5px rgba(0, 123, 255, 0.5);
            outline: none;
        }

        /* Button styling */
        .form-box button {
            width: 100%;
            padding: 12px;
            margin-top: 15px;
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

        /* Responsive */
        @media (max-width: 450px) {
            .form-box {
                width: 90%;
                padding: 20px;
            }
        }
    </style>
</head>
<body>

<div class="form-box">
    <h2>Add Restaurant</h2>

    <form action="../addRestaurant" method="post">
        <input name="name" placeholder="Restaurant Name" required>
        <input name="cuisine" placeholder="Cuisine" required>
        <input name="location" placeholder="Location" required>
        <input name="rating" step="0.1" type="number" placeholder="Rating" required>
        <input name="eta" type="number" placeholder="ETA (mins)" required>
        <input name="image" placeholder="Image URL" required>
        <button type="submit">Add Restaurant</button>
    </form>
</div>

</body>
</html>
