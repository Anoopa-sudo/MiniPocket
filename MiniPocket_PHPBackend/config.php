<?php

    $servername="127.0.0.1";
    $username="root";
    $password="";
    $dbname="minipocket_db";
    $conn = mysqli_connect($servername,$username,$password,$dbname) or die('Unable to connect');

    if(mysqli_connect_error())
    {
        echo "Failed to Connect to Database ".mysqli_connect_error();
    }
?>
