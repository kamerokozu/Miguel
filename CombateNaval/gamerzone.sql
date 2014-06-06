-- phpMyAdmin SQL Dump
-- version 4.1.12
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 06-06-2014 a las 19:48:31
-- Versión del servidor: 5.5.36
-- Versión de PHP: 5.4.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `gamerzone`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rankings`
--

CREATE TABLE IF NOT EXISTS `rankings` (
  `idRanking` int(11) NOT NULL AUTO_INCREMENT,
  `idusuario` int(11) NOT NULL,
  `gamertag` varchar(30) NOT NULL,
  `idjuego` int(11) NOT NULL,
  `victorias` int(11) NOT NULL,
  `derrotas` int(11) NOT NULL,
  `fecha` date NOT NULL,
  PRIMARY KEY (`idRanking`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=59 ;

--
-- Volcado de datos para la tabla `rankings`
--

INSERT INTO `rankings` (`idRanking`, `idusuario`, `gamertag`, `idjuego`, `victorias`, `derrotas`, `fecha`) VALUES
(38, 1, 'kamerokozu', 1, 0, 0, '2014-06-06'),
(39, 1, 'kamerokozu', 1, 0, 0, '2014-06-06'),
(40, 1, 'kamerokozu', 1, 0, 0, '2014-06-06'),
(41, 1, 'kamerokozu', 1, 0, 0, '2014-06-06'),
(42, 1, 'kamerokozu', 1, 0, 0, '2014-06-06'),
(43, 1, 'kamerokozu', 1, 0, 1, '2014-06-06'),
(44, 1, 'kamerokozu', 1, 1, 0, '2014-06-06'),
(45, 1, 'kamerokozu', 1, 0, 1, '2014-06-06'),
(46, 1, 'kamerokozu', 1, 1, 0, '2014-06-06'),
(47, 1, 'kamerokozu', 1, 0, 1, '2014-06-06'),
(48, 1, 'kamerokozu', 1, 1, 0, '2014-06-06'),
(49, 1, 'kamerokozu', 1, 0, 1, '2014-06-06'),
(50, 1, 'kamerokozu', 1, 1, 0, '2014-06-06'),
(51, 1, 'kamerokozu', 1, 0, 1, '2014-06-06'),
(52, 1, 'kamerokozu', 1, 1, 0, '2014-06-06'),
(53, 1, 'kamerokozu', 1, 0, 1, '2014-06-06'),
(54, 1, 'kamerokozu', 1, 1, 0, '2014-06-06'),
(55, 1, 'kamerokozu', 1, 0, 1, '2014-06-06'),
(56, 1, 'kamerokozu', 1, 1, 0, '2014-06-06'),
(57, 1, 'kamerokozu', 1, 0, 1, '2014-06-06'),
(58, 1, 'kamerokozu', 1, 1, 0, '2014-06-06');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE IF NOT EXISTS `usuarios` (
  `idusuario` int(11) NOT NULL AUTO_INCREMENT,
  `gamertag` varchar(30) NOT NULL,
  `contrasena` varchar(30) NOT NULL,
  `nombre` varchar(25) NOT NULL,
  `apellidop` varchar(25) NOT NULL,
  `apellidom` varchar(25) NOT NULL,
  `email` varchar(40) NOT NULL,
  PRIMARY KEY (`idusuario`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`idusuario`, `gamertag`, `contrasena`, `nombre`, `apellidop`, `apellidom`, `email`) VALUES
(1, 'kamerokozu', 'miguel23', 'miguel', 'martinez', 'becerra', 'kamerokozu@hotmail.com'),
(2, 'taquito master', '123', 'abel', 'lizarraga', 'patron', 'darkfire@hotmail.com');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
