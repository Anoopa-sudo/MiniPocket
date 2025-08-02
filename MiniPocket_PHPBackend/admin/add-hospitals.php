<?php

include '../config.php';

$name = $_POST['name'];
$location = $_POST['location'];
$address = $_POST['address'];
$phone_number = $_POST['phone_number'];
$number_of_beds = $_POST['number_of_beds'];
$has_emergency = isset($_POST['has_emergency']) ? 1 : 0;
$image = $_POST['image'];

$sql = "INSERT INTO hospitals (name, location, address, phone_number, number_of_beds, has_emergency, image)
        VALUES ('$name', '$location', '$address', '$phone_number', '$number_of_beds', '$has_emergency', '$image')";
$result = mysqli_query($conn, $sql);

if ($result) {
    echo "<script>alert('New hospital added successfully.'); window.location.href = 'check-hospitals.php';</script>";
} else {
    echo "<script>alert('Error: Something went wrong'); console.log('$error'); window.location.href = 'check-hospitals.php';</script>";
}
