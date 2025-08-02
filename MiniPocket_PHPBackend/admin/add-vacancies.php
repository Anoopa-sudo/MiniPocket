<?php

include '../config.php';

$job_post = $_POST['job_post'];
$company_name = $_POST['company_name'];
$location = $_POST['location'];
$salary = $_POST['salary'];
$description = $_POST['description'];
$company_email = $_POST['company_email'];

$sql = "INSERT INTO vacancies (job_post, company_name, location, salary, description, company_email)
        VALUES ('$job_post', '$company_name', '$location', '$salary', '$description', '$company_email')";
$result = mysqli_query($conn, $sql);

if ($result) {
    echo "<script>alert('New vacancy added successfully.'); window.location.href = 'check-vacancies.php';</script>";
} else {
    $error = mysqli_error($conn);
    echo "<script>alert('Error: Something went wrong'); console.log('$error'); window.location.href = 'check-vacancies.php';</script>";
}



