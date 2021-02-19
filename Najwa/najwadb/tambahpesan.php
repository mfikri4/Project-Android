<?php
require "database.php";
$db = new database();
if (isset($_POST['nama_produk']) && isset($_POST['harga_produk']) && isset($_POST['jumlah_produk']) && issetc($_POST)['total_harga'] ) {
    if ($db->dbConnect()) {
        if ($db->tambah("tabelpesanan", $_POST['nama_produk'], $_POST['harga_produk'], $_POST['jumlah_produk'],$_POST['total_harga']) {
            echo "Tambah Data Sukses";
        } else echo "Tambah Data Gagal";
    } else echo "Error: Database connection";
} else echo "Field Tidak boleh kosong";
?>