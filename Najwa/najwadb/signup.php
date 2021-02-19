<?php
require "DataBase.php";
$db = new database();
if (isset($_POST['nama']) && isset($_POST['email']) && isset($_POST['alamat']) && isset($_POST['gender']) && isset($_POST['no_hp']) && isset($_POST['password']) ) {
    if ($db->dbConnect()) {
        if ($db->signUp("tabelpengguna", $_POST['nama'], $_POST['email'], $_POST['alamat'], $_POST['gender'], $_POST['no_hp'], $_POST['password'])) {
            echo "Pendaftaran Sukses";
        } else echo "Pendaftaran Gagal";
    } else echo "Error: Database connection";
} else echo "Field Tidak boleh kosong";
?>