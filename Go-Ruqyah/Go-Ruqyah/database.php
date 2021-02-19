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

    function logIn($table, $username, $password)
    {
        $username = $this->prepareData($username);
        $password = $this->prepareData($password);
        $this->sql = "select * from " . $table . " where username = '" . $username . "'";
        $result = mysqli_query($this->connect, $this->sql);
        $row = mysqli_fetch_assoc($result);
        if (mysqli_num_rows($result) != 0) {
            $dbusername = $row['username'];
            $dbpassword = $row['password'];
            if ($dbusername == $username && password_verify($password, $dbpassword)) {
                $login = true;
            } else $login = false;
        } else $login = false;

        return $login;
    }

    function signUp($table, $fullname, $username, $email, $password)
    {
        $fullname = $this->prepareData($fullname);
        $username = $this->prepareData($username);
        $email = $this->prepareData($email);
        $password = $this->prepareData($password);
        $password = password_hash($password, PASSWORD_DEFAULT);
        $this->sql =
            "INSERT INTO " . $table . " (fullname, username, email, password) VALUES ('" . $fullname . "','" . $username . "','" . $email . "','" . $password . "')";
        if (mysqli_query($this->connect, $this->sql)) {
            return true;
        } else return false;
    }


    
    function tambahpesan($table, $jenis_ruqyah, $nomor_hp, $alamat)
    {
        $jenis_ruqyah = $this->prepareData($jenis_ruqyah);
        $nomor_hp = $this->prepareData($nomor_hp);
        $alamat = $this->prepareData($alamat);
        
        $this->sql =
            "INSERT INTO " . $table . " (jenis_ruqyah, nomor_hp, alamat) VALUES ('" . $jenis_ruqyah . "','" . $nomor_hp . "','" . $alamat . "')";
        if (mysqli_query($this->connect, $this->sql)) {
            return true;
        } else return false;
    }


    
}

?>