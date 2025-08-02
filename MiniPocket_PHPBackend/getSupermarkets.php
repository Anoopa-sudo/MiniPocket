<?php
include "config.php";
if ($_SERVER['REQUEST_METHOD'] == 'POST') {

    $stmt = $conn->prepare("SELECT * FROM supermarkets");

    $stmt->execute();
    $stmt->bind_result($id, $name, $location, $address, $phone_number, $open_time, $close_time, $offers, $image);

    $supermarkets = array();

    while ($stmt->fetch()) {

        $temp = array();

        $temp['id'] = $id;
        $temp['name'] = $name;
        $temp['location'] = $location;
        $temp['address'] = $address;
        $temp['phone_number'] = $phone_number;
        $temp['open_time'] = $open_time;
        $temp['close_time'] = $close_time;
        $temp['offers'] = $offers;
        $temp['image'] = $image;

        array_push($supermarkets, $temp);
    }
}

echo json_encode($supermarkets);
?>
