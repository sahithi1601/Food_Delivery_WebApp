<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Food Ordering App</title>
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

        /* Container for welcome message */
        .welcome-box {
            text-align: center;
            background: #fff;
            padding: 50px 40px;
            border-radius: 10px;
            box-shadow: 0 4px 15px rgba(0,0,0,0.2);
        }

        /* Heading */
        .welcome-box h1 {
            margin-bottom: 40px;
            color: #333;
        }

        /* Buttons/links */
        .welcome-box a {
            display: inline-block;
            width: 150px;
            padding: 12px;
            margin: 10px;
            background: #007bff;
            color: #fff;
            text-decoration: none;
            font-size: 16px;
            border-radius: 6px;
            transition: background 0.3s ease;
        }

        /* Hover effect */
        .welcome-box a:hover {
            background: #0056b3;
        }

        /* Responsive */
        @media (max-width: 400px) {
            .welcome-box {
                width: 90%;
                padding: 30px 20px;
            }

            .welcome-box a {
                width: 100%;
                margin: 10px 0;
            }
        }
    </style>
</head>
<body>

<div class="welcome-box">
    <h1>Welcome to Food Ordering App</h1>

    <a href="signup.jsp">Sign Up</a>
    <a href="login.jsp">Login</a>
</div>

</body>
</html>
