<?php

include('../config.php');
session_start();
$admin_email = 'help@minipocket.com';

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

                <li class=""><a class="" href="check-vacancies.php" style="color: #fff; font-weight: bold">Back to Vacancies</a></li>

            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="admin-logout.php"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
            </ul>
        </div>
    </nav>
    <div class="container regs-con">

        <?php

        // Retrieve data from the database
        $sql = "SELECT id, user_id, vacancy_id, application_date FROM job_applications";
        $result = mysqli_query($conn, $sql);
        ?>

        <h1>Check Vacancy Applications</h1>
        <table class="table table-bordered" id="applications-table">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>User ID</th>
                    <th>Vacancy ID</th>
                    <th>Applied At</th>
                    <th>Reply</th>
                </tr>
            </thead>
            <tbody>
                <?php
                // Output data into the table
                while ($row = mysqli_fetch_assoc($result)) {
                    echo "<tr>";
                    echo "<td>" . $row['id'] . "</td>";
                    echo "<td><a href='check-users.php?id=" . $row['user_id'] . "'>" . $row['user_id'] . "</a></td>";
                    echo "<td><a href='check-vacancies.php?id=" . $row['vacancy_id'] . "'>" . $row['vacancy_id'] . "</a></td>";
                    echo "<td>" . $row['application_date'] . "</td>";
                    echo "<td><a href='#' onclick='showForm(\"" . $row['id'] . "\", \"" . $row['vacancy_id'] . "\", \"" . $row['user_id'] . "\", \"" . $row['vacancy_id'] . "\", \"" . $row['application_date'] . "\", \"" . $admin_email . "\");'>Reply</a></td>";
                    echo "</tr>";
                }
                ?>
            </tbody>
        </table>
        <br>
        <hr>
        <!-- Form to reply to enquiries -->
        <div id="reply-form" style="display:none;">
            <h2>Reply to Application</h2>
            <form method="post" action="send-reply.php">
                <div class="form-group">
                    <label for="to">To:</label>
                    <input type="text" class="form-control" name="to" id="to" readonly>
                </div>
                <div class="form-group">
                    <label for="subject">Subject:</label>
                    <input type="text" class="form-control" name="subject" id="subject">
                </div>
                <div class="form-group">
                    <label for="message">Message:</label>
                    <textarea class="form-control" name="message" id="message" rows="5"></textarea>
                </div>
                <button type="submit" class="btn btn-primary">Send</button>
            </form>
        </div>

        <script>
            function showForm(id, subject, userId, message, createdAt, adminEmail) {
                var to = userId + '@example.com';
                var subject = 'Re: Vacancy ID ' + subject;
                document.getElementById("to").value = to;
                document.getElementById("subject").value = subject;
                document.getElementById("message").value = '\n\n------------------------\nOriginal message from ' + userId + ' at ' + createdAt + ':\nVacancy ID:' + message;
                document.getElementById("reply-form").style.display = "block";
            }
        </script>



        <footer id="footer">
            <p>&copy; Mini Pocket App</p>
        </footer>

        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <!-- Latest compiled JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</body>

</html>