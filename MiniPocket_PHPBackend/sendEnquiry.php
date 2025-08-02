<?php

include "config.php";

if ($_SERVER['REQUEST_METHOD'] == 'POST') {

    $subject = mysqli_real_escape_string($conn, $_POST['subject']);
    $message = mysqli_real_escape_string($conn, $_POST['message']);
    $email = mysqli_real_escape_string($conn, $_POST['email']);
    

    
    $sql = mysqli_query($conn, 'INSERT INTO enquiries(user_id, subject, message) VALUES("' . $email . '","' . $subject . '","' . $message . '")');
    if (!$sql) {
        die(mysqli_error($conn));
    } else {

        $result["success"] = "1";
        $result["message"] = "Enquiry Successfully sent!";

        echo json_encode($result);
        echo $result;
    }
    
} else {

    $result["success"] = "0";
    $result["message"] = "Enquiry sending failed, an error occurred";

    echo json_encode($result);
    echo $result;
}
