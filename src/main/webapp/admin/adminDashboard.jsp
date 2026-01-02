<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Admin Dashboard</title>
    <style>
        /* General body styling */
        body {
            font-family: 'Arial', sans-serif;
            background: #f2f2f2;
            margin: 0;
            padding: 0;
        }

        /* Container for dashboard */
        .dashboard-container {
            max-width: 600px;
            margin: 80px auto;
            background: #fff;
            padding: 40px 30px;
            border-radius: 10px;
            box-shadow: 0 4px 15px rgba(0,0,0,0.2);
            text-align: center;
        }

        /* Heading */
        .dashboard-container h1 {
            margin-bottom: 30px;
            color: #333;
        }

        /* Links styling as buttons */
        .dashboard-container a {
            display: inline-block;
            width: 200px;
            padding: 12px;
            margin: 10px 0;
            text-decoration: none;
            color: #fff;
            background: #007bff;
            border-radius: 6px;
            font-size: 16px;
            transition: background 0.3s ease;
        }

        /* Hover effect for links */
        .dashboard-container a:hover {
            background: #0056b3;
        }

        /* Responsive adjustments */
        @media (max-width: 500px) {
            .dashboard-container a {
                width: 90%;
            }
        }
    </style>
</head>
<body>

<div class="dashboard-container">
    <h1>Welcome Admin</h1>

    <a href="addRestaurant.jsp">Add Restaurant</a><br>
    <a href="../admin/loadAddMenu">Add Menu</a><br>
    <a href="../restaurants">View User Side</a>
</div>

</body>
</html>
