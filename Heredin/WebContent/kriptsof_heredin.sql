-- phpMyAdmin SQL Dump
-- version 3.5.5
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 12-02-2014 a las 06:17:59
-- Versión del servidor: 5.5.33-31.1
-- Versión de PHP: 5.3.17

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `kriptsof_heredin`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cartera`
--

CREATE TABLE IF NOT EXISTS `cartera` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adrPub` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `adrPri` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `saldo` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=2 ;

--
-- Volcado de datos para la tabla `cartera`
--

INSERT INTO `cartera` (`id`, `adrPub`, `adrPri`, `saldo`) VALUES
(1, '1admin1admin1admin', '1adminp1adminp1admin', 200);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cartera_persona`
--

CREATE TABLE IF NOT EXISTS `cartera_persona` (
  `id_persona` int(11) NOT NULL,
  `id_cartera` int(11) NOT NULL,
  PRIMARY KEY (`id_persona`,`id_cartera`),
  KEY `id_cartera` (`id_cartera`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `cartera_persona`
--

INSERT INTO `cartera_persona` (`id_persona`, `id_cartera`) VALUES
(1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `persona`
--

CREATE TABLE IF NOT EXISTS `persona` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nomUser` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `nomComplert` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `adresa` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `numTelf` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `nomUser` (`nomUser`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=3 ;

--
-- Volcado de datos para la tabla `persona`
--

INSERT INTO `persona` (`id`, `nomUser`, `nomComplert`, `adresa`, `numTelf`) VALUES
(1, 'admin', 'Administrador', 'C/Falsa 123', 938887766);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `nomUser` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`nomUser`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `user`
--

INSERT INTO `user` (`nomUser`, `password`) VALUES
('admin', 'admin');

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `cartera_persona`
--
ALTER TABLE `cartera_persona`
  ADD CONSTRAINT `cartera_persona_ibfk_2` FOREIGN KEY (`id_cartera`) REFERENCES `cartera` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `cartera_persona_ibfk_1` FOREIGN KEY (`id_persona`) REFERENCES `persona` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `persona`
--
ALTER TABLE `persona`
  ADD CONSTRAINT `persona_ibfk_1` FOREIGN KEY (`nomUser`) REFERENCES `user` (`nomUser`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
