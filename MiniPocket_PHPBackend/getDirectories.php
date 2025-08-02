<?php
include "config.php";
if ($_SERVER['REQUEST_METHOD'] == 'POST') {

    $srchKey = mysqli_real_escape_string($conn, $_POST['search']);

    $check_query = "SELECT * FROM directory where service_type like '$srchKey%'";
    $check_result_query = mysqli_query($conn, $check_query);

    if (mysqli_num_rows($check_result_query) == 0) {

        $result["success"] = "0";
        $result["message"] = "No results found!";

        echo json_encode($result);
    } else {
        $stmt = $conn->prepare("SELECT * FROM directory WHERE service_type LIKE ?");
        $srchKey = $srchKey.'%';
        $stmt->bind_param("s", $srchKey);
        $stmt->execute();
        $stmt->bind_result($id, $name, $service_type, $location, $address, $phone_number);

        $directories = array();

        while ($stmt->fetch()) {

            $temp = array();

            $temp['id'] = $id;
            $temp['name'] = $name;
            $temp['service_type'] = $service_type;
            $temp['location'] = $location;
            $temp['address'] = $address;
            $temp['phone_number'] = $phone_number;
            

            array_push($directories, $temp);
        }

        echo json_encode($directories);
    }
}

?>
