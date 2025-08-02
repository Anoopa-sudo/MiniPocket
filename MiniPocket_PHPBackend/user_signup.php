<?php

include "config.php";

if ($_SERVER['REQUEST_METHOD'] == 'POST') {

    $name = mysqli_real_escape_string($conn, $_POST['name']);
    $password = mysqli_real_escape_string($conn, $_POST['password']);
    $email = mysqli_real_escape_string($conn, $_POST['email']);
    $phone = mysqli_real_escape_string($conn, $_POST['phone']);
    $location = mysqli_real_escape_string($conn, $_POST['location']);

    $check_query = "SELECT * FROM user WHERE email='$email'";
    $check_result_query = mysqli_fetch_array(mysqli_query($conn, $check_query));

    if (isset($check_result_query)) {

        $result["success"] = "0";
        $result["message"] = "Email ID is already Linked to another account!";

        echo json_encode($result);
        echo $result["message"];
    } else {

        $sql = mysqli_query($conn, 'INSERT INTO user(email, fullname, phone, location, password) VALUES("' . $email . '","' . $name . '","' . $phone . '","' . $location . '","'.$password.'")');
        if (!$sql) {
            die(mysqli_error($conn));
        } else {

            $result["success"] = "1";
            $result["message"] = "User Account created successfully!";

            echo json_encode($result);
            echo $result;
        }
    }
} else {

    $result["success"] = "0";
    $result["message"] = "Registration failed, an error occurred";

    echo json_encode($result);
    echo $result;
}
