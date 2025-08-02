<?php

    include('../config.php');
    session_start();
    if(isset($_SESSION["admin"]))
        header("location: check-users.php");
    


    $id= mysqli_real_escape_string($conn,$_POST['uid']);
    $pwd= mysqli_real_escape_string($conn,$_POST['pwd']);

    $query="select * from admin where admin_id='$id' and password='$pwd'";
    $qry_result = mysqli_query($conn,$query) or die(mysqli_error($conn));
    if(mysqli_num_rows ( $qry_result )==0){
        echo "<script>alert('Invalid Login Details!'); window.location.replace('index.php');</script>";
    }
    else{
        while($row = mysqli_fetch_array($qry_result)) {
            $_SESSION["admin"] = $row['admin_id'];
            header('location: check-users.php');
        }
    }
    
?>
