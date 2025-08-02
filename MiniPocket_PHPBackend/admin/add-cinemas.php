<?php

include '../config.php';

$name = $_POST['name'];
$location = $_POST['location'];
$address = $_POST['address'];
$phone_number = $_POST['phone_number'];
$number_of_screens = $_POST['number_of_screens'];
$has_parking = isset($_POST['has_parking']) ? 1 : 0;
$image = $_POST['image'];

$sql = "INSERT INTO cinemas (name, location, address, phone_number, number_of_screens, has_parking, image)
        VALUES ('$name', '$location', '$address', '$phone_number', '$number_of_screens', '$has_parking', '$image')";
$result = mysqli_query($conn, $sql);

if ($result) {
    echo "<script>alert('New movie theatre added successfully.'); window.location.href = 'check-movies.php';</script>";
} else {
    echo "<script>alert('Error: Something went wrong'); console.log('$error'); window.location.href = 'check-movies.php';</script>";
}


