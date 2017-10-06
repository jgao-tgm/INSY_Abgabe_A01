<?php
include 'connect.php';

$id = $_POST['id'];

try {

    $sql = "DELETE FROM passengers WHERE id=".$id;

    $conn->exec($sql);
    echo "<br/>Deleting successful";
    }
catch(PDOException $e)
    {
    echo $sql . "<br>" . $e->getMessage();
    }

?>
