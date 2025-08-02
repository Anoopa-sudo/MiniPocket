<?php
include "config.php";
if ($_SERVER['REQUEST_METHOD'] == 'POST') {

    $stmt = $conn->prepare("SELECT * FROM cinemas");

    $stmt->execute();
    $stmt->bind_result($id, $name, $location, $address, $phone_number, $number_of_screens, $has_parking, $image);

    $cinemas = array();

    while ($stmt->fetch()) {

        $temp = array();

        $temp['id'] = $id;
        $temp['name'] = $name;
        $temp['location'] = $location;
        $temp['address'] = $address;
        $temp['phone_number'] = $phone_number;
        $temp['number_of_screens'] = $number_of_screens;
        $temp['has_parking'] = $has_parking;
        $temp['image'] = $image;

        array_push($cinemas, $temp);
    }
}

echo json_encode($cinemas);
?>