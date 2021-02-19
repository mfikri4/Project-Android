<?php
require "database.php";
$db = new database();
if (isset($_POST['fullname']) && isset($_POST['username']) && isset($_POST['email']) && isset($_POST['password'])  ) {
    if ($db->dbConnect()) {
        if ($db->signUp("users", $_POST['fullname'], $_POST['username'], $_POST['email'], $_POST['password'])) {
            echo "Pendaftaran Sukses";
        } else echo "Pendaftaran Gagal";
    } else echo "Error: Database connection";
} else echo "Field Tidak boleh kosong";
?>