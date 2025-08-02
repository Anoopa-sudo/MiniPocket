<?php

include "config.php";

if ($_SERVER['REQUEST_METHOD'] == 'POST') {

    $email = mysqli_real_escape_string($conn, $_POST['email']);
    $vacancy_id = mysqli_real_escape_string($conn, $_POST['vacancy_id']);
    

    
    $sql = mysqli_query($conn, 'INSERT INTO job_applications(user_id, vacancy_id) VALUES("' . $email . '","' . $vacancy_id . '")');
    if (!$sql) {
        die(mysqli_error($conn));
    } else {

        $result["success"] = "1";
        $result["message"] = "Application Successfully sent!";

        echo json_encode($result);
        echo $result;
    }
    
} else {

    $result["success"] = "0";
    $result["message"] = "Application sending failed, an error occurred";

    echo json_encode($result);
    echo $result;
}
