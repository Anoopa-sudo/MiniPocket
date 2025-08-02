<?php

include '../config.php';

$name = $_POST['name'];
$location = $_POST['location'];
$address = $_POST['address'];
$phone_number = $_POST['phone_number'];
$open_time = $_POST['open_time'];
$close_time = $_POST['close_time'];
$offers = $_POST['offers'];
$image = $_POST['image'];

$sql = "INSERT INTO supermarkets (name, location, address, phone_number, open_time, close_time, offers, image)
        VALUES ('$name', '$location', '$address', '$phone_number', '$open_time', '$close_time', '$offers', '$image')";
$result = mysqli_query($conn, $sql);

if ($result) {
    echo "<script>alert('New supermarket added successfully.'); window.location.href = 'check-supermarkets.php';</script>";
} else {
    $error = mysqli_error($conn);
    echo "<script>alert('Error: Something went wrong'); console.log('$error'); window.location.href = 'check-supermarkets.php';</script>";
}
