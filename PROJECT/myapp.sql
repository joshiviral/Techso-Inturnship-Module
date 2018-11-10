-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Apr 26, 2016 at 02:41 PM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `myapp`
--

-- --------------------------------------------------------

--
-- Table structure for table `assigncourse`
--

CREATE TABLE IF NOT EXISTS `assigncourse` (
  `coursename` varchar(100) NOT NULL,
  `facultyname` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `course`
--

CREATE TABLE IF NOT EXISTS `course` (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `cname` varchar(100) NOT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Dumping data for table `course`
--

INSERT INTO `course` (`cid`, `cname`) VALUES
(1, 'Android'),
(2, 'Php'),
(3, ''),
(4, 'Java'),
(5, 'Asp.net');

-- --------------------------------------------------------

--
-- Table structure for table `faculty`
--

CREATE TABLE IF NOT EXISTS `faculty` (
  `fid` int(11) NOT NULL AUTO_INCREMENT,
  `fname` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `contact` int(11) NOT NULL,
  `coursespecial` varchar(100) NOT NULL,
  PRIMARY KEY (`fid`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `faculty`
--

INSERT INTO `faculty` (`fid`, `fname`, `email`, `contact`, `coursespecial`) VALUES
(1, 'kmkm', 'mkm', 122435, 'Php');

-- --------------------------------------------------------

--
-- Table structure for table `leave`
--

CREATE TABLE IF NOT EXISTS `leave` (
  `lid` int(11) NOT NULL AUTO_INCREMENT,
  `sname` varchar(100) NOT NULL,
  `fname` varchar(100) NOT NULL,
  `course` varchar(100) NOT NULL,
  `fromdate` date NOT NULL,
  `todate` date NOT NULL,
  `reasone` varchar(500) NOT NULL,
  PRIMARY KEY (`lid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `myappdata`
--

CREATE TABLE IF NOT EXISTS `myappdata` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fname` varchar(100) NOT NULL,
  `address` varchar(500) NOT NULL,
  `contact` int(11) NOT NULL,
  `email` varchar(100) NOT NULL,
  `faculty` varchar(100) NOT NULL,
  `course` varchar(100) NOT NULL,
  `fromdate` date NOT NULL,
  `todate` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=10 ;

--
-- Dumping data for table `myappdata`
--

INSERT INTO `myappdata` (`id`, `fname`, `address`, `contact`, `email`, `faculty`, `course`, `fromdate`, `todate`) VALUES
(1, 'ASD', 'sdfg', 24235, 'tyt', 'tgfj', 'Php', '0000-00-00', '0000-00-00'),
(2, 'awewr', 'fht', 0, '2323', 'kmkm', 'Php', '0000-00-00', '0000-00-00'),
(3, 'ewrdf', 'dsf', 0, '21', 'kmkm', 'Php', '0000-00-00', '0000-00-00'),
(4, 'ewrdf', 'dsf', 0, '21', 'kmkm', 'Php', '0000-00-00', '0000-00-00'),
(5, 'ewrdf', 'dsf', 0, '21', 'kmkm', 'Php', '0000-00-00', '0000-00-00'),
(6, 'ewrdf', 'dsf', 0, '21', 'kmkm', 'Php', '0000-00-00', '0000-00-00'),
(7, 'ewrdf', 'dsf', 0, '21', 'kmkm', 'Php', '0000-00-00', '0000-00-00'),
(8, 'sdg', 'fcbg', 0, 'cb', 'kmkm', 'Android', '2016-03-26', '0000-00-00'),
(9, '', '', 0, '', 'kmkm', 'Android', '2016-03-26', '2016-03-27');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
