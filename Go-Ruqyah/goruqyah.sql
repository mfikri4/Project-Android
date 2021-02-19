-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 20, 2021 at 12:42 AM
-- Server version: 10.4.17-MariaDB
-- PHP Version: 8.0.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `goruqyah`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `id` int(3) NOT NULL,
  `username` varchar(30) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id`, `username`, `password`) VALUES
(0, 'linukn', 'udahlogin');

-- --------------------------------------------------------

--
-- Table structure for table `peruqyah`
--

CREATE TABLE `peruqyah` (
  `id` int(3) NOT NULL,
  `nama_peruqyah` varchar(30) NOT NULL,
  `alamat` varchar(50) NOT NULL,
  `rating` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `peruqyah`
--

INSERT INTO `peruqyah` (`id`, `nama_peruqyah`, `alamat`, `rating`) VALUES
(1, 'Adam Amrullah', 'Gunungpati, Semarang', '4,8'),
(2, 'Abdul Somad', 'Jaken, Pati', '4.7');

-- --------------------------------------------------------

--
-- Table structure for table `pesan_ruqyah`
--

CREATE TABLE `pesan_ruqyah` (
  `id` int(3) NOT NULL,
  `jenis_ruqyah` varchar(255) NOT NULL,
  `nomor_hp` varchar(255) NOT NULL,
  `alamat` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `pesan_ruqyah`
--

INSERT INTO `pesan_ruqyah` (`id`, `jenis_ruqyah`, `nomor_hp`, `alamat`) VALUES
(5, 'Bekam', '0822233332', 'Tembalang');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `fullname` text NOT NULL,
  `username` varchar(100) NOT NULL,
  `email` varchar(300) NOT NULL,
  `password` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `fullname`, `username`, `email`, `password`) VALUES
(1, 'Lisdi Inu', 'linukn', 'linukn@gmail.com', '$2y$10$a.AElBl4d47dLLDrAzo3rea8Sv8bkoA9w3zp1dDjlaUvRKLfLu0lS');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `peruqyah`
--
ALTER TABLE `peruqyah`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `pesan_ruqyah`
--
ALTER TABLE `pesan_ruqyah`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `username` (`username`),
  ADD UNIQUE KEY `email` (`email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `peruqyah`
--
ALTER TABLE `peruqyah`
  MODIFY `id` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `pesan_ruqyah`
--
ALTER TABLE `pesan_ruqyah`
  MODIFY `id` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
