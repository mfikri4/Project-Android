<?php
require "database.php";
$db = new database();
if (isset($_POST['jenis_ruqyah']) && isset($_POST['nomor_hp']) && isset($_POST['alamat']) ) {
    if ($db->dbConnect()) {
        if ($db->tambahpesan("pesan_ruqyah", $_POST['jenis_ruqyah'], $_POST['nomor_hp'], $_POST['alamat'])) {
            echo "Tambah Data Sukses";
        } else echo "Pendaftaran Gagal";
    } else echo "Error: Database connection";
} else echo "Field Tidak boleh kosong";
?>