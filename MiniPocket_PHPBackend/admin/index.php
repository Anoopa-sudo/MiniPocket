<?php

include('../config.php');
session_start();
if (isset($_SESSION["admin"]))
    header("location: check-users.php");
?>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <link rel="stylesheet" href="styles/style.css">
    <title>Mini Pocket - Admin</title>
</head>

<body>

    <nav class="navbar navbar-inverse">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" href="index.php" style="color: #fff; font-weight: bold">Mini Pocket App</a>
            </div>
        </div>
    </nav>
    <div class="container login-con">
        <div class="login-form">
            <form action="admin-login-func.php" method="post">
                <h2 class="text-center">Admin Log in</h2>
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="Username" required name="uid">
                </div>
                <div class="form-group">
                    <input type="password" class="form-control" placeholder="Password" required name="pwd">
                </div>
                <div class="form-group">
                    <button type="submit" class="btn btn-primary btn-block">Log in</button>
                </div>
                <div class="clearfix">
                    <label class="float-left form-check-label"><input type="checkbox"> Remember me</label>
                </div>
            </form>
        </div>
    </div>


    <footer id="footer">
        <p>&copy; Mini Pocket App</p>
    </footer>

    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    <script src="jquery-3.3.1.min.js"></script>
</body>

</html>