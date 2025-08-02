<?php

include '../config.php';

$name = $_POST['name'];
$email = $_POST['email'];
$location = $_POST['location'];
$address = $_POST['address'];
$type = $_POST['type'];
$price = $_POST['price'];
$description = $_POST['description'];
$available = isset($_POST['available']) ? 1 : 0;
$image = $_POST['image'];

$sql = "INSERT INTO accommodations (name, email, location, address, type, price, description, available, image)
        VALUES ('$name', '$email', '$location', '$address', '$type', '$price', '$description', '$available', '$image')";
$result = mysqli_query($conn, $sql);

if ($result) {
    echo "<script>alert('New accommodation added successfully.'); window.location.href = 'check-accommodations.php';</script>";
} else {
    echo "<script>alert('Error: Something went wrong'); console.log('$error'); window.location.href = 'check-accommodations.php';</script>";
}