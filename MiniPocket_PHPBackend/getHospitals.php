<?php

include "config.php";
if ($_SERVER['REQUEST_METHOD'] == 'POST') {

    $stmt = $conn->prepare("SELECT * FROM hospitals");

    $stmt->execute();
    $stmt->bind_result($id, $name, $location, $address, $phone_number, $number_of_beds, $has_emergency, $image);

    $hospitals = array();

    while ($stmt->fetch()) {

        $temp = array();

        $temp['id'] = $id;
        $temp['name'] = $name;
        $temp['location'] = $location;
        $temp['address'] = $address;
        $temp['phone_number'] = $phone_number;
        $temp['number_of_beds'] = $number_of_beds;
        $temp['has_emergency'] = $has_emergency;
        $temp['image'] = $image;

        array_push($hospitals, $temp);
    }
}

echo json_encode($hospitals);

