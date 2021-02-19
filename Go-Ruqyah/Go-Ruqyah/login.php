<?php
require "database.php";
$db = new database();
if (isset($_POST['username']) && isset($_POST['password'])) {
    if ($db->dbConnect()) {
        if ($db->logIn("users", $_POST['username'], $_POST['password'])) {
            echo "Berhasil Masuk";
        } else echo "Email or Password wrong";
    } else echo "Error: Database connection";
} else echo "All fields are required";
?>