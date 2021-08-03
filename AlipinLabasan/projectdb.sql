-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 18, 2020 at 12:46 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `projectdb`
--

-- --------------------------------------------------------

--
-- Table structure for table `account`
--

CREATE TABLE `account` (
  `accountID` int(11) NOT NULL,
  `FirstName` varchar(30) NOT NULL,
  `LastName` varchar(30) NOT NULL,
  `ContactNumber` varchar(30) NOT NULL,
  `Email` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `account`
--

INSERT INTO `account` (`accountID`, `FirstName`, `LastName`, `ContactNumber`, `Email`) VALUES
(1, 'Mary Anne', 'Labasan', '09173327183', 'anne23@gmail.com'),
(2, 'aljon', 'alipin', '09787872999', 'aljon@yahoo.com'),
(3, 'erwin', 'villarojo', '09567736212', 'erwinvillarojo@gmail.com'),
(4, 'julieta', 'palma', '09788879954', 'julietapalma@gmail.com'),
(5, 'Jane', 'Deguma', '09667421221', 'janechristy_deguma30@yahoo.com'),
(6, 'Mary', 'Anne', '09564565454', 'maryanne@gmail.com'),
(7, 'Jane', 'Doe', '09564373543', 'janedoe@gmail.com'),
(8, 'Christiane', 'Repunte', '09898898432', 'christianerepunte@yahoo.com'),
(9, 'Zarina', 'Zaragoza', '097833829132', 'zarzaragoza@gmail.com'),
(10, 'Gel', 'Sullano', '0933838299', 'gelsullano@gmail.com'),
(11, 'Princess', 'Arenas', '09338293902', 'princess03@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `reservation`
--

CREATE TABLE `reservation` (
  `accountID` int(11) DEFAULT NULL,
  `reservationID` int(11) NOT NULL,
  `Date` varchar(30) NOT NULL,
  `RoomNo` int(11) NOT NULL,
  `Time` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `reservation`
--

INSERT INTO `reservation` (`accountID`, `reservationID`, `Date`, `RoomNo`, `Time`) VALUES
(1, 44, '17-03-2020', 2, '11:30AM - 2:00PM'),
(1, 45, '17-03-2020', 9, '4:30PM - 7:00PM'),
(1, 46, '17-03-2020', 6, '2:00PM - 4:30PM'),
(6, 49, '18-03-2020', 1, '4:30PM - 7:00PM'),
(7, 50, '18-03-2020', 4, '4:30PM - 7:00PM'),
(7, 51, '18-03-2020', 5, '2:00PM - 4:30PM'),
(7, 54, '18-03-2020', 9, '7:00PM - 9:30PM'),
(11, 55, '18-03-2020', 9, '4:30PM - 7:00PM'),
(11, 56, '18-03-2020', 8, '2:00PM - 4:30PM'),
(11, 57, '18-03-2020', 3, '11:30AM - 2:00PM');

-- --------------------------------------------------------

--
-- Table structure for table `useraccount`
--

CREATE TABLE `useraccount` (
  `accountID` int(11) NOT NULL,
  `Username` varchar(30) NOT NULL,
  `Password` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `useraccount`
--

INSERT INTO `useraccount` (`accountID`, `Username`, `Password`) VALUES
(2, 'aljonz23', 'NOTHANDSOME'),
(1, 'anneRupok', 'MOVEONALAGE'),
(11, 'cess03', 'eramie'),
(8, 'channix', 'chanchan'),
(3, 'erwin.villarojo', 'ningning'),
(10, 'gelgwapo', 'jesuschrist'),
(7, 'jane.doe', 'janedoe123'),
(5, 'janedeguma30', 'jane07'),
(4, 'julie.ram', 'elram'),
(6, 'maryanne.rl', 'maryanne'),
(9, 'zrzrgz', 'zaragoza1');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`accountID`,`ContactNumber`);

--
-- Indexes for table `reservation`
--
ALTER TABLE `reservation`
  ADD PRIMARY KEY (`reservationID`),
  ADD KEY `accountID` (`accountID`);

--
-- Indexes for table `useraccount`
--
ALTER TABLE `useraccount`
  ADD PRIMARY KEY (`Username`),
  ADD KEY `accountID` (`accountID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `account`
--
ALTER TABLE `account`
  MODIFY `accountID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `reservation`
--
ALTER TABLE `reservation`
  MODIFY `reservationID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=58;

--
-- AUTO_INCREMENT for table `useraccount`
--
ALTER TABLE `useraccount`
  MODIFY `accountID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `reservation`
--
ALTER TABLE `reservation`
  ADD CONSTRAINT `reservation_ibfk_1` FOREIGN KEY (`accountID`) REFERENCES `account` (`accountID`);

--
-- Constraints for table `useraccount`
--
ALTER TABLE `useraccount`
  ADD CONSTRAINT `useraccount_ibfk_1` FOREIGN KEY (`accountID`) REFERENCES `account` (`accountID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
