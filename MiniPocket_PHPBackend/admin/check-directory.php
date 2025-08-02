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
                <li class=""><a class="" href="check-supermarkets.php" style="color: #fff; font-weight: bold">Manage Supermarkets</a></li>
                <li class=""><a class="" href="check-services.php" style="color: #fff; font-weight: bold">Manage Services</a></li>
                <li class=""><a class="" href="check-hospitals.php" style="color: #fff; font-weight: bold">Manage Hospitals</a></li>
                <li class=""><a class="" href="check-vacancies.php" style="color: #fff; font-weight: bold">Manage Vacancies</a></li>
                <li class="active"><a class="" href="check-directory.php" style="color: #fff; font-weight: bold">Manage Directory</a></li>
                <li class=""><a class="" href="check-accomodation.php" style="color: #fff; font-weight: bold">Manage Accomodation</a></li>
                <li class=""><a class="" href="check-enquiries.php" style="color: #fff; font-weight: bold">Check Enquires</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="admin-logout.php"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
            </ul>
        </div>
    </nav>
    <div class="container regs-con">

        <h1>Registered Directory Records</h1>
        <table class="table table-bordered" id="directory-table">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Service Type</th>
                <th>Phone Number</th>
                <th>Location</th>
                <th>Address</th>
            </tr>
            <?php
            // Retrieve data from the database
            $sql = "SELECT id, name, service_type, phone_number, location, address FROM directory";
            $result = mysqli_query($conn, $sql);

            // Output data into the table
            while ($row = mysqli_fetch_assoc($result)) {
                echo "<tr>";
                echo "<td>" . $row['id'] . "</td>";
                echo "<td>" . $row['name'] . "</td>";
                echo "<td>" . $row['service_type'] . "</td>";
                echo "<td>" . $row['phone_number'] . "</td>";
                echo "<td>" . $row['location'] . "</td>";
                echo "<td>" . $row['address'] . "</td>";
                echo "</tr>";
            }
            ?>

        </table>

        <hr>

        <div class="container regs-con">
            <h1>Add New Directory Record</h1>
            <form method="POST" action="add-directory.php">
                <div class="form-group">
                    <label for="name">Name:</label>
                    <input type="text" class="form-control" name="name" id="name" required>
                </div>
                <div class="form-group">
                    <label for="service_type">Service Type:</label>
                    <input type="text" class="form-control" name="service_type" id="service_type" required>
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
                    <label for="location">Location:</label>
                    <input type="text" class="form-control" name="location" id="location" required>
                </div>

                <br>
                <button type="submit" class="btn btn-primary">Add Directory</button>
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