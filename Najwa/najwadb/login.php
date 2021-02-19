<?php
require "database.php";
$db = new database();
if (isset($_POST['email']) && isset($_POST['password'])) {
    if ($db->dbConnect()) {
        if ($db->logIn("tabelpengguna", $_POST['email'], $_POST['password'])) {
            echo "Berhasil Masuk";
        } else echo "Email or Password wrong";
    } else echo "Error: Database connection";
} else echo "All fields are required";
?>