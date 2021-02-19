-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 20, 2021 at 12:44 PM
-- Server version: 10.4.17-MariaDB
-- PHP Version: 7.4.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `najwadb`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `id` int(3) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id`, `username`, `password`) VALUES
(1, 'mfikri4', 'udahlogin');

-- --------------------------------------------------------

--
-- Table structure for table `tabelbarang`
--

CREATE TABLE `tabelbarang` (
  `id` int(3) NOT NULL,
  `nama_barang` varchar(50) NOT NULL,
  `deskripsi` text NOT NULL,
  `harga_barang` int(15) NOT NULL,
  `gambar` varchar(300) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tabelbarang`
--

INSERT INTO `tabelbarang` (`id`, `nama_barang`, `deskripsi`, `harga_barang`, `gambar`) VALUES
(1, 'Ventela Low Black', 'Sepatu Ventela dengan warna hitam dan upper yang Rendah merupakan sepatu zaman now', 300000, 'https://momobil.id/news/wp-content/uploads/2017/01/modifikasi-mobil-polisi-indonesia-ditujukan-untuk-gambar-mobil-polisi-indonesia-terkeren-foto-mobil-sport-gambar-modifikasi-mobil-polisi-indonesia-terbaru-1024x768.jpg'),
(2, 'Ventela High Black', 'Sepatu Ventela dengan warna hitam dan upper yang tinggi merupakan sepatu zaman now.', 350000, 'https://drive.google.com/file/d/1tKJ1q0fnK-Bgzc2fcj4jKTX7gmFII6Nb/view?usp=sharing'),
(3, 'Ventela Low Oreo', 'Sepatu Ventela dengan warna oreo dan upper yang tinggi merupakan sepatu zaman now', 300000, 'https://drive.google.com/file/d/1mF-mtSr6gP3qiJKxUGe77OKinu2d3USz/view?usp=sharing'),
(4, 'Ventela High Oreo', 'Sepatu Ventela dengan warna oreo dan upper yang tinggi merupakan sepatu zaman now.', 350000, 'https://drive.google.com/file/d/1vCF1n-gv7AhBxFHWqRq2lHupH4Kdj8sw/view?usp=sharing'),
(5, 'Ventela Low Yellow', 'Sepatu Ventela dengan warna kuning dan upper yang rendahmerupakan sepatu zaman now', 300000, 'https://drive.google.com/file/d/1mv5jrtDlAN4WefQpIulqeKbXuv2WceJ3/view?usp=sharing'),
(6, 'Ventela High Yellow', 'Sepatu Ventela dengan warna kuning dan upper yang tinggi merupakan sepatu zaman now.', 350000, 'https://drive.google.com/file/d/1oCzOY06neIdaqaLNaek2jfNsXItVcxjB/view?usp=sharing');

-- --------------------------------------------------------

--
-- Table structure for table `tabelpengguna`
--

CREATE TABLE `tabelpengguna` (
  `id` int(3) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `alamat` text NOT NULL,
  `gender` varchar(100) NOT NULL,
  `no_hp` varchar(100) NOT NULL,
  `password` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tabelpengguna`
--

INSERT INTO `tabelpengguna` (`id`, `nama`, `email`, `alamat`, `gender`, `no_hp`, `password`) VALUES
(1, 'nama', 'email', 'alamat', 'gender', 'no_hp', '$2y$10$yp.pcaCg5/jmrrCXy4zNZeqRQvW07P45hONQhyKz3.o93is22avQe'),
(10, 'Fikri A', 'fikri@gmail.com', 'Fikri', 'Laki', '082136841556', '$2y$10$.vqtdPeFmFt2VuPuLLieNOqG9GbSlOkax8hHq/JHT4pu7S.8sc6ue'),
(11, 'Muhammad Fikri Almajid', 'fikrihuft@gmail.com', 'Jaken Pati', 'Laki', '082136841556', '$2y$10$LKoc.DGgPSV30mH/vqRYo.GRFLY2eFO6qBbW5Ps6ifculItnXkNJq');

-- --------------------------------------------------------

--
-- Table structure for table `tabelpesanan`
--

CREATE TABLE `tabelpesanan` (
  `id` int(3) NOT NULL,
  `nama_produk` varchar(50) NOT NULL,
  `harga_produk` int(15) NOT NULL,
  `jumlah_produk` int(15) NOT NULL,
  `total_harga` int(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tabelbarang`
--
ALTER TABLE `tabelbarang`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tabelpengguna`
--
ALTER TABLE `tabelpengguna`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`);

--
-- Indexes for table `tabelpesanan`
--
ALTER TABLE `tabelpesanan`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `id` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `tabelbarang`
--
ALTER TABLE `tabelbarang`
  MODIFY `id` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `tabelpengguna`
--
ALTER TABLE `tabelpengguna`
  MODIFY `id` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `tabelpesanan`
--
ALTER TABLE `tabelpesanan`
  MODIFY `id` int(3) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
