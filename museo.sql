-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 21-05-2023 a las 04:37:01
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `museo`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `museo`
--

CREATE TABLE `museo` (
  `codigo` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `municipio` varchar(50) NOT NULL,
  `departamento` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- Volcado de datos para la tabla `museo`
--

INSERT INTO `museo` (`codigo`, `nombre`, `municipio`, `departamento`) VALUES
(1, 'Museo Rafael Núñez', 'Cartagena', 'Bolivar'),
(2, 'Museo La Gran Convención		', 'Ocaña', ' Norte de Santander'),
(3, 'Museo Antón García de Bonilla', 'Ocaña', 'Norte de Santander'),
(4, 'Museo casa natal Gral Santander', 'V. Rosario', 'Norte de Santander'),
(5, 'Museo Juan del Corral', 'Santa Fe de Antioquia', 'Antioquia'),
(6, 'Museo Antonio Nariño', 'Villa de Leyva', 'Tunja'),
(7, 'Casa Museo Alfonso López Pumarejo', 'Honda', 'Tolima'),
(8, 'Museo Guillermo León Valencia', 'Popayán', 'Cauca'),
(9, 'Museo Guillermo Valencia', 'Popayán', 'Cauca');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `visitante`
--

CREATE TABLE `visitante` (
  `cedula` varchar(50) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellidos` varchar(70) NOT NULL,
  `genero` varchar(50) NOT NULL,
  `profesion` varchar(50) NOT NULL,
  `ciudadorigen` varchar(50) NOT NULL,
  `codigomuseo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- Volcado de datos para la tabla `visitante`
--

INSERT INTO `visitante` (`cedula`, `nombre`, `apellidos`, `genero`, `profesion`, `ciudadorigen`, `codigomuseo`) VALUES
('123', 'Diego', 'Espinoza', 'Masculino', 'ingeniero', 'Cucuta', 1),
('124', 'Juan', 'Arguello', 'Masculino', 'ingeniero', 'Cucuta', 1),
('125', 'Tatiana', 'Peñaloza', 'Femenino', 'Secretaria', 'Cucuta', 2),
('126', 'Lian', 'Peñaloza', 'Masculino', 'Estudiante', 'Cucuta', 1),
('127', 'Nicol', 'Peñaloza', 'Femenino', 'Estudiante', 'Cucuta', 1),
('128', 'Julian', 'Gomez', 'Masculino', 'ingeniero', 'Cucuta', 2);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `museo`
--
ALTER TABLE `museo`
  ADD PRIMARY KEY (`codigo`);

--
-- Indices de la tabla `visitante`
--
ALTER TABLE `visitante`
  ADD PRIMARY KEY (`cedula`),
  ADD KEY `codigomuseo` (`codigomuseo`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `museo`
--
ALTER TABLE `museo`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `visitante`
--
ALTER TABLE `visitante`
  ADD CONSTRAINT `visitante_ibfk_1` FOREIGN KEY (`codigomuseo`) REFERENCES `museo` (`codigo`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
