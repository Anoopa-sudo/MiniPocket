<?php
    include('../config.php');
    session_start();
    if(!isset($_SESSION["admin"]))
        header('location: index.php');
    else{
        
        unset($_SESSION["admin"]);
        header('location: index.php');
        
    }
?>
