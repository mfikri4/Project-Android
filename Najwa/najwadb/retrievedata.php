<?php

require ("koneksi.php");

$perintah = " SELECT * from tabelbarang";
$eksekusi = mysqli_query($konek,$perintah);
$cek = mysqli_affected_rows($konek);

if ($cek > 0){
    $response["kode"] = 1;
    $response["pesan"] = "Data Tersedia";
    $response["data"] = array();

    while ($ambil = mysqli_fetch_object($eksekusi)){
        $F["id"] =  $ambil -> id;
        $F["nama_barang"] = $ambil -> nama_barang;
        $F["deskripsi"] = $ambil -> deskripsi;
        $F["harga_barang"] = $ambil -> harga_barang;
        $F["gambar"] = $ambil -> gambar;
        array_push($response["data"], $F);
    }
}else {
    $response["kode"] = 0;
    $response["pesan"] = "Data Tidak Tersedia";
}

echo json_encode($response);
mysqli_close($konek);

?>