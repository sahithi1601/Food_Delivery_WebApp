<!DOCTYPE html>
<html>
<head>
    <title>Sign Up</title>
</head>
<body>

<h2>Create Account</h2>

<form action="SignupServlet" method="post">
    Name: <input type="text" name="name" required><br><br>
    Email: <input type="email" name="email" required><br><br>
    Password: <input type="password" name="password" required><br><br>

    <input type="submit" value="Sign Up">
</form>

<p>Already have an account? <a href="login.jsp">Login</a></p>

</body>
</html>
