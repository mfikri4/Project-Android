<?php
require "databaseConfig.php";

class database
{
    public $connect;
    public $data;
    private $sql;
    protected $servername;
    protected $username;
    protected $password;
    protected $databasename;

    public function __construct()
    {
        $this->connect = null;
        $this->data = null;
        $this->sql = null;
        $dbc = new databaseConfig();
        $this->servername = $dbc->servername;
        $this->username = $dbc->username;
        $this->password = $dbc->password;
        $this->databasename = $dbc->databasename;
    }

    function dbConnect()
    {
        $this->connect = mysqli_connect($this->servername, $this->username, $this->password, $this->databasename);
        return $this->connect;
    }

    function prepareData($data)
    {
        return mysqli_real_escape_string($this->connect, stripslashes(htmlspecialchars($data)));
    }


    function tambah($table, $nama_produk, $harga_produk, $jumlah_produk, $total_harga)
    {
        $nama_produk = $this->prepareData($nama_produk);
        $harga_produk = $this->prepareData($harga_produk);
        $jumlah_produk = $this->prepareData($jumlah_produk);
        $total_harga = $this->prepareData($total_harga);
        $this->sql =
            "INSERT INTO " . $table . " (nama_produk, harga_produk, jumlah_produk, total_harga) VALUES ('" . $nama_produk . "','" . $harga_produk . "','" . $jumlah_produk . "','" . $total_harga . "')";
        if (mysqli_query($this->connect, $this->sql)) {
            return true;
        } else return false;
    }
    function logIn($table, $email, $password)
    {
        $email = $this->prepareData($email);
        $password = $this->prepareData($password);
        $this->sql = "select * from " . $table . " where email = '" . $email . "'";
        $result = mysqli_query($this->connect, $this->sql);
        $row = mysqli_fetch_assoc($result);
        if (mysqli_num_rows($result) != 0) {
            $dbemail = $row['email'];
            $dbpassword = $row['password'];
            if ($dbemail == $email && password_verify($password, $dbpassword)) {
                $login = true;
            } else $login = false;
        } else $login = false;

        return $login;
    }

    function signUp($table ,$nama ,$email, $alamat, $gender,$no_hp ,$password)
    {
        $nama = $this->prepareData($nama);
        $email = $this->prepareData($email);
        $alamat = $this->prepareData($alamat);
        $gender = $this->prepareData($gender);
        $no_hp = $this->prepareData($no_hp);
        $password = $this->prepareData($password);
        $password = password_hash($password, PASSWORD_DEFAULT);
        $this->sql =
            "INSERT INTO " . $table . " (nama, email, alamat, gender, no_hp, password) VALUES ('" . $nama . "','" . $email . "','" . $alamat . "','" . $gender . "','" . $no_hp . "','" . $password . "')";
        if (mysqli_query($this->connect, $this->sql)) {
            return true;
        } else return false;
    }


    
}

?>