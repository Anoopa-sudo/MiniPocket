<?php
if(isset($_POST['to']) && isset($_POST['subject']) && isset($_POST['message'])) {
    $to = $_POST['to'];
    $subject = $_POST['subject'];
    $message = $_POST['message'];
    $headers = 'From: help@minipocket.com' . "\r\n" .
               'Reply-To: '. $to . "\r\n" .
               'X-Mailer: PHP/' . phpversion();

    if(mail($to, $subject, $message, $headers)) {
        echo "<script>alert('Reply Sent successfully.'); window.location.href = 'check-enquiries.php';</script>";
    } else {
        echo "<script>alert('Error: Reply could not be sent'); console.log('$error'); window.location.href = 'check-enquiries.php';</script>";
    }
}
?>
