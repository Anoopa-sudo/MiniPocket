<?php

include('../config.php');
session_start();
if (!isset($_SESSION["admin"]))
    header("location: index.php");
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
    <title>Mini Pocket App - Admin</title>
</head>

<body>

    <nav class="navbar navbar-inverse">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" href="#">Mini Pocket ADMIN</a>
            </div>
            <ul class="nav navbar-nav">
                <li class=""><a class="" href="check-users.php" style="color: #fff; font-weight: bold">Manage Users</a></li>
                <li class=""><a class="" href="check-movies.php" style="color: #fff; font-weight: bold">Manage Theatres &amp; Movies</a></li>
                <li class="active"><a class="" href="check-supermarkets.php" style="color: #fff; font-weight: bold">Manage Supermarkets</a></li>
                <li class=""><a class="" href="check-services.php" style="color: #fff; font-weight: bold">Manage Services</a></li>
                <li class=""><a class="" href="check-hospitals.php" style="color: #fff; font-weight: bold">Manage Hospitals</a></li>
                <li class=""><a class="" href="check-vacancies.php" style="color: #fff; font-weight: bold">Manage Vacancies</a></li>
                <li class=""><a class="" href="check-directory.php" style="color: #fff; font-weight: bold">Manage Directory</a></li>
                <li class=""><a class="" href="check-accomodation.php" style="color: #fff; font-weight: bold">Manage Accomodation</a></li>
                <li class=""><a class="" href="check-enquiries.php" style="color: #fff; font-weight: bold">Check Enquires</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="admin-logout.php"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
            </ul>
        </div>
    </nav>
    <div class="container regs-con">

        <h1>Registered Supermarkets</h1>
        <table class="table table-bordered" id="supermarkets-table">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Location</th>
                <th>Address</th>
                <th>Phone Number</th>
                <th>Open Time</th>
                <th>Close Time</th>
                <th>Offers</th>
                <th>Image</th>
            </tr>

            <?php
            // Retrieve data from the database
            $sql = "SELECT id, name, location, address, phone_number, open_time, close_time, offers, image FROM supermarkets";
            $result = mysqli_query($conn, $sql);

            // Output data into the table
            while ($row = mysqli_fetch_assoc($result)) {
                echo "<tr>";
                echo "<td>" . $row['id'] . "</td>";
                echo "<td>" . $row['name'] . "</td>";
                echo "<td>" . $row['location'] . "</td>";
                echo "<td>" . $row['address'] . "</td>";
                echo "<td>" . $row['phone_number'] . "</td>";
                echo "<td>" . $row['open_time'] . "</td>";
                echo "<td>" . $row['close_time'] . "</td>";
                echo "<td>" . $row['offers'] . "</td>";
                echo "<td><a href='" . $row['image'] . "' target='_blank'><img src='" . $row['image'] . "'></a></td>";
                echo "</tr>";
            }
            ?>

        </table>

        <hr>

        <div class="container regs-con">
            <h1>Add New Supermarket</h1>
            <form method="POST" action="add-supermarkets.php">
                <div class="form-group">
                    <label for="name">Name:</label>
                    <input type="text" class="form-control" name="name" id="name" required>
                </div>

                <div class="form-group">
                    <label for="location">Location:</label>
                    <input type="text" class="form-control" name="location" id="location" required>
                </div>

                <div class="form-group">
                    <label for="address">Address:</label>
                    <input type="text" class="form-control" name="address" id="address" required>
                </div>

                <div class="form-group">
                    <label for="phone_number">Phone Number:</label>
                    <input type="text" class="form-control" name="phone_number" id="phone_number" required>
                </div>

                <div class="form-group">
                    <label for="open_time">Open Time:</label>
                    <input type="time" class="form-control" name="open_time" id="open_time" required>
                </div>

                <div class="form-group">
                    <label for="close_time">Close Time:</label>
                    <input type="time" class="form-control" name="close_time" id="close_time" required>
                </div>

                <div class="form-group">
                    <label for="offers">Offers:</label>
                    <textarea class="form-control" name="offers" id="offers" rows="3" required></textarea>
                </div>

                <div class="form-group">
                    <label for="image">Image URL:</label>
                    <input type="text" class="form-control" name="image" id="image" required>
                </div>
                <br>
                <button type="submit" class="btn btn-primary">Add Supermarket</button>
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
    <script src="scripts/script.js"></script>
</body>

</html>