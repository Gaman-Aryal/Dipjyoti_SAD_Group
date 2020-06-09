-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 08, 2020 at 03:37 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `coursework`
--

-- --------------------------------------------------------

--
-- Table structure for table `adminverificationcode`
--

CREATE TABLE `adminverificationcode` (
  `serial` int(5) NOT NULL,
  `code` varchar(15) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `emailreceiveradminemail` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `adminverificationcode`
--

INSERT INTO `adminverificationcode` (`serial`, `code`, `email`, `emailreceiveradminemail`) VALUES
(1, '5S94a12', 'gauravraut305@gmail.com', 'gamanaryal@gmail.com'),
(1, '', 'gamanaryal@gmail.com', 'gamanaryal@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `history`
--

CREATE TABLE `history` (
  `Username` varchar(30) NOT NULL,
  `Time` varchar(30) NOT NULL,
  `Action` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `history`
--

INSERT INTO `history` (`Username`, `Time`, `Action`) VALUES
('Shova123', '2020-06-08T15:42:29.630607300', 'Logged out from the system'),
('Shova123', '2020-06-08T15:42:33.882231500', 'Logged in to the system'),
('Gauravraut305', '2020-06-08T16:15:44.461275', 'Logged in to the system'),
('Gauravraut305', '2020-06-08T16:16:27.557671', 'Logged out from the system'),
('Shova123', '2020-06-08T16:16:38.541177400', 'Logged in to the system'),
('Shova123', '2020-06-08T16:18:02.529302300', 'User added'),
('Shova123', '2020-06-08T16:31:17.989927700', 'Logged out from the system'),
('Radha123', '2020-06-08T16:32:49.229617100', 'Signed in as new user'),
('Radha123', '2020-06-08T16:32:55.631921200', 'Logged in to the system'),
('Radha123', '2020-06-08T16:38:19.827211400', 'Logged out from the system'),
('Shova123', '2020-06-08T16:38:29.584816400', 'Logged in to the system'),
('Shova123', '2020-06-08T18:25:07.663921500', 'Logged in to the system'),
('Shova123', '2020-06-08T18:40:18.332920700', 'Logged in to the system'),
('Shova123', '2020-06-08T19:05:24.759873400', 'Logged in to the system'),
('Shova123', '2020-06-08T19:05:26.709892600', 'Logged out from the system'),
('Shova123', '2020-06-08T19:12:12.903784800', 'Logged in to the system'),
('Hanuman', '2020-06-08T19:20:15.898420900', 'Signed in as new user'),
('Hanuman', '2020-06-08T19:20:20.665755700', 'Logged in to the system'),
('Hanuman', '2020-06-08T19:20:36.120133700', 'Updated profile');

-- --------------------------------------------------------

--
-- Table structure for table `resetpasswordrecord`
--

CREATE TABLE `resetpasswordrecord` (
  `serial` int(5) NOT NULL,
  `code` varchar(15) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `resetpasswordrecord`
--

INSERT INTO `resetpasswordrecord` (`serial`, `code`, `email`) VALUES
(1, '36I538', 'gauravraut305@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `Admin` varchar(3) NOT NULL,
  `Firstname` varchar(20) NOT NULL,
  `Lastname` varchar(20) NOT NULL,
  `Gender` varchar(6) NOT NULL,
  `Phonenumber` varchar(10) DEFAULT NULL,
  `Username` varchar(40) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `Password` varchar(16) NOT NULL,
  `Created_date` varchar(10) NOT NULL DEFAULT current_timestamp(),
  `Blocked_Status` varchar(3) NOT NULL DEFAULT 'N'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`Admin`, `Firstname`, `Lastname`, `Gender`, `Phonenumber`, `Username`, `Email`, `Password`, `Created_date`, `Blocked_Status`) VALUES
('No', 'Gaurav', 'Raut', 'Male', '9867816939', 'Gauravraut305', 'gauravraut305@gmail.com', 'Asdf123@.', '2020-06-08', 'No'),
('No', 'Shree', 'Krishna', 'Male', '9804239197', 'Radha123', 'Ganesh@gmail.com', 'Ganesh@123', '2020-06-08', 'No'),
('Y', 'Shova', 'Raut', 'Female', '9845066850', 'Shova123', 'shova@gmail.com', 'Shova123@.', '2020-06-07', 'No'),
('N', 'Ram', 'Bahadur', 'M', '9867816939', 'Sita123', 'laxman@gmail.com', 'Hanuman123@.', '2020-12-12', 'No');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `history`
--
ALTER TABLE `history`
  ADD PRIMARY KEY (`Time`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`Username`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
