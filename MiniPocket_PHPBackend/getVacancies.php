<?php
include "config.php";

if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    $search = mysqli_real_escape_string($conn, $_POST['search']);

    $query = "SELECT * FROM vacancies WHERE job_post LIKE '$search%' OR company_name LIKE '$search%' OR location LIKE '$search%'";

    $result = mysqli_query($conn, $query);

    if (mysqli_num_rows($result) > 0) {
        $vacancies = array();

        while ($row = mysqli_fetch_assoc($result)) {
            $vacancy = array(
                'id' => $row['id'],
                'job_post' => $row['job_post'],
                'company_name' => $row['company_name'],
                'location' => $row['location'],
                'salary' => $row['salary'],
                'description' => $row['description'],
                'company_email' => $row['company_email']
            );

            array_push($vacancies, $vacancy);
        }

        echo json_encode($vacancies);
    } else {
        echo "No results found!";
    }
}
?>
