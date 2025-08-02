<?php

    include "config.php";

    if ($_SERVER['REQUEST_METHOD'] == 'POST') {
        $stmt = $conn->prepare("SELECT * FROM movies ORDER BY release_date desc");
        $stmt->execute();
        $stmt->bind_result($id, $title, $poster, $release_date);

        $movies = array();

        while ($stmt->fetch()) {
            $temp = array();

            $temp['id'] = $id;
            $temp['title'] = $title;
            $temp['poster'] = $poster;
            $temp['release_date'] = $release_date;

            array_push($movies, $temp);
        }

        echo json_encode($movies);
    }
