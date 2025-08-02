<?php
include "config.php";

if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    $search = mysqli_real_escape_string($conn, $_POST['search']);

    $query = "SELECT * FROM accommodations WHERE available='1' AND name LIKE '$search%' OR location LIKE '$search%' OR type LIKE '$search%'";

    $result = mysqli_query($conn, $query);

    if (mysqli_num_rows($result) > 0) {
        $accommodations = array();

        while ($row = mysqli_fetch_assoc($result)) {
            $accommodation = array(
                'id' => $row['id'],
                'name' => $row['name'],
                'email' => $row['email'],
                'location' => $row['location'],
                'address' => $row['address'],
                'type' => $row['type'],
                'price' => $row['price'],
                'description' => $row['description'],
                'availability' => $row['available'],
                'image' => $row['image']
            );

            array_push($accommodations, $accommodation);
        }

        echo json_encode($accommodations);
    } else {
        echo "No results found!";
    }
}
?>
