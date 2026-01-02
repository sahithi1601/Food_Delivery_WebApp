<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <style>
        /* General body styling */
        body {
            font-family: 'Arial', sans-serif;
            background: #f2f2f2;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        /* Centered login container */
        .login-box {
            width: 400px;
            background: #fff;
            padding: 40px 30px;
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
        .login-box input[type="email"],
        .login-box input[type="password"] {
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
        .login-box input[type="submit"] {
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

        .login-box input[type="submit"]:hover {
            background: #0056b3;
        }

        /* Signup link */
        .login-box p {
            margin-top: 20px;
        }

        .login-box p a {
            color: #007bff;
            text-decoration: none;
        }

        .login-box p a:hover {
            text-decoration: underline;
        }

        /* Responsive */
        @media (max-width: 450px) {
            .login-box {
                width: 90%;
                padding: 30px 20px;
            }
        }
    </style>
</head>
<body>

<div class="login-box">
    <h2>Welcome Back</h2>

    <form action="LoginServlet" method="post">
        <input type="email" name="email" placeholder="Email" required>
        <input type="password" name="password" placeholder="Password" required>

        <input type="submit" value="Login">
    </form>

    <p>New user? <a href="signup.jsp">Create Account</a></p>
</div>

</body>
</html>

