<?php

include "config.php";

if ($_SERVER['REQUEST_METHOD'] == 'POST') {

    $email = $_POST['email'];
    $password = $_POST['password'];

    $que = mysqli_query($conn, "select * from user where email ='$email' and password='$password'");
    $row = mysqli_num_rows($que);

    if ($row) {

        $result["success"] = "1";
        $result["message"] = "Login Successful !!";

        echo json_encode($result);
    } else {

        $result["success"] = "0";
        $result["message"] = "Login Failed !! Incorrect email or password";

        echo json_encode($result);
    }
}
