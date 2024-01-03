-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 15-Set-2023 às 20:10
-- Versão do servidor: 10.4.17-MariaDB
-- versão do PHP: 8.0.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `mybdatenea`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `curso`
--

CREATE TABLE `curso` (
  `id_curso` int(11) NOT NULL,
  `nombre` varchar(20) NOT NULL,
  `f_inicio` date NOT NULL,
  `hora_inicio` time NOT NULL,
  `instructor_id` int(11) DEFAULT NULL,
  `monitor_id` int(11) DEFAULT NULL,
  `limite_estudiantes` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `curso`
--

INSERT INTO `curso` (`id_curso`, `nombre`, `f_inicio`, `hora_inicio`, `instructor_id`, `monitor_id`, `limite_estudiantes`) VALUES
(21, '1', '2001-05-05', '12:15:15', 1, 2, 30);

-- --------------------------------------------------------

--
-- Estrutura da tabela `persona`
--

CREATE TABLE `persona` (
  `id_persona` int(11) NOT NULL,
  `nombre` varchar(40) NOT NULL,
  `telefono` varchar(12) NOT NULL,
  `direccion` varchar(40) NOT NULL,
  `f_nacimiento` date NOT NULL,
  `email` varchar(40) NOT NULL,
  `tipo` varchar(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `persona`
--

INSERT INTO `persona` (`id_persona`, `nombre`, `telefono`, `direccion`, `f_nacimiento`, `email`, `tipo`) VALUES
(1, 'Juan Pérez', '123456789', 'Calle Principal 123', '1990-05-15', 'juan@example.com', 'Monitor'),
(2, 'María González', '987654321', 'Avenida Secundaria 456', '1985-08-20', 'maria@example.com', 'Instructor'),
(3, 'Carlos Rodríguez', '555555555', 'Calle Secundaria 789', '1992-12-10', 'carlos@example.com', 'Monitor'),
(4, 'Ana López', '111222333', 'Calle Terciaria 567', '1994-03-25', 'ana@example.com', 'Instructor'),
(5, 'Luis Ramírez', '999888777', 'Avenida Principal 999', '1988-07-12', 'luis@example.com', 'Monitor'),
(6, 'Elena Torres', '777666555', 'Calle Cuarta 123', '1987-11-05', 'elena@example.com', 'Instructor'),
(7, 'Pedro Sánchez', '444333222', 'Avenida Quinta 789', '1996-02-18', 'pedro@example.com', 'Monitor'),
(8, 'Sofía Martínez', '666777888', 'Calle Sexta 567', '1991-09-30', 'sofia@example.com', 'Instructor'),
(9, 'Javier Gómez', '222333444', 'Avenida Séptima 123', '1993-06-15', 'javier@example.com', 'Monitor'),
(10, 'Laura Fernández', '888999000', 'Calle Octava 789', '1990-01-08', 'laura@example.com', 'Instructor');

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `curso`
--
ALTER TABLE `curso`
  ADD PRIMARY KEY (`id_curso`),
  ADD KEY `instructor_id` (`instructor_id`),
  ADD KEY `monitor_id` (`monitor_id`);

--
-- Índices para tabela `persona`
--
ALTER TABLE `persona`
  ADD PRIMARY KEY (`id_persona`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `curso`
--
ALTER TABLE `curso`
  MODIFY `id_curso` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT de tabela `persona`
--
ALTER TABLE `persona`
  MODIFY `id_persona` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `curso`
--
ALTER TABLE `curso`
  ADD CONSTRAINT `curso_ibfk_1` FOREIGN KEY (`instructor_id`) REFERENCES `persona` (`id_persona`),
  ADD CONSTRAINT `curso_ibfk_2` FOREIGN KEY (`monitor_id`) REFERENCES `persona` (`id_persona`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
