-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 15 Bulan Mei 2020 pada 01.33
-- Versi server: 10.4.6-MariaDB
-- Versi PHP: 7.3.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `covid19`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `covid`
--

CREATE TABLE `covid` (
  `id` int(11) NOT NULL,
  `daerah` varchar(100) NOT NULL,
  `tanggal` varchar(100) NOT NULL,
  `positif` int(11) NOT NULL,
  `ODP` int(11) NOT NULL,
  `PDP` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `covid`
--

INSERT INTO `covid` (`id`, `daerah`, `tanggal`, `positif`, `ODP`, `PDP`) VALUES
(12, 'bantu', '5/14/2020', 0, 2, 3),
(33, 'jogja', '4/23/2020', 2, 2, 3),
(44, 'kulon progo', '5/21/2020', 0, 1, 1),
(45, 'sleman', '5/16/2020', 1, 2, 3),
(46, 'jakarta', '5/18/2020', 0, 22, 33),
(47, 'depok', '5/19/2020', 100, 199, 22);

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `covid`
--
ALTER TABLE `covid`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `covid`
--
ALTER TABLE `covid`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=48;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
