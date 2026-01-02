<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Admin Login</title>
    <style>
        /* General body styling */
        body {
            font-family: 'Arial', sans-serif;
            background: #f2f2f2;
            margin: 0;
            padding: 0;
        }

        /* Centered login container */
        .login-box {
            width: 350px;
            background: #fff;
            padding: 30px 40px;
            margin: 100px auto;
            border-radius: 10px;
            box-shadow: 0 4px 15px rgba(0,0,0,0.2);
            text-align: center;
        }

        /* Heading */
        .login-box h2 {
            margin-bottom: 30px;
            color: #333;
        }

        /* Input fields */
        .login-box input {
            width: 100%;
            padding: 12px 15px;
            margin: 10px 0;
            border: 1px solid #ccc;
            border-radius: 6px;
            font-size: 14px;
            transition: all 0.3s ease;
        }

        /* Input focus effect */
        .login-box input:focus {
            border-color: #007bff;
            box-shadow: 0 0 5px rgba(0,123,255,0.5);
            outline: none;
        }

        /* Button styling */
        .login-box button {
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
        .login-box button:hover {
            background: #0056b3;
        }

        /* Error message styling */
        .login-box p {
            color: red;
            margin-top: 15px;
        }

        /* Responsive */
        @media (max-width: 400px) {
            .login-box {
                width: 90%;
                padding: 20px;
            }
        }
    </style>
</head>
<body>

<div class="login-box">
    <h2>Admin Login</h2>

    <form action="<%= request.getContextPath() %>/adminLogin" method="post">
        <input type="text" name="username" placeholder="Username" required>
        <input type="password" name="password" placeholder="Password" required>
        <button type="submit">Login</button>
    </form>

    <p>
        <%= request.getAttribute("error") != null ? request.getAttribute("error") : "" %>
    </p>
</div>

</body>
</html>
