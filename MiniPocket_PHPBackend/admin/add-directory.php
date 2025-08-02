<?php

include '../config.php';

$name = $_POST['name'];
$service_type = $_POST['service_type'];
$phone_number = $_POST['phone_number'];
$location = $_POST['location'];
$address = $_POST['address'];

$sql = "INSERT INTO directory (name, service_type, phone_number, location, address)
        VALUES ('$name', '$service_type', '$phone_number', '$location', '$address')";
$result = mysqli_query($conn, $sql);

if ($result) {
    echo "<script>alert('New entry added successfully.'); window.location.href = 'check-directory.php';</script>";
} else {
    $error = mysqli_error($conn);
    echo "<script>alert('Error: Something went wrong'); console.log('$error'); window.location.href = 'check-directory.php';</script>";
}