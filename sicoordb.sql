-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 23-Fev-2023 às 21:52
-- Versão do servidor: 10.4.27-MariaDB
-- versão do PHP: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `sicoordb`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuario`
--

CREATE TABLE `usuario` (
  `Id` int(11) NOT NULL,
  `Login` varchar(50) DEFAULT NULL,
  `Senha` varchar(50) DEFAULT NULL,
  `Email` varchar(50) DEFAULT NULL,
  `Nome` varchar(250) DEFAULT NULL,
  `CEP` varchar(50) DEFAULT NULL,
  `Endereco` varchar(250) DEFAULT NULL,
  `Bairro` varchar(250) DEFAULT NULL,
  `Cidade` varchar(250) DEFAULT NULL,
  `Estado` varchar(2) DEFAULT NULL,
  `Telefone` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Extraindo dados da tabela `usuario`
--

INSERT INTO `usuario` (`Id`, `Login`, `Senha`, `Email`, `Nome`, `CEP`, `Endereco`, `Bairro`, `Cidade`, `Estado`, `Telefone`) VALUES
(1, 'admin', '1234', 'mfsouzaa@gmail.com', 'Marcos Figueiredo de Souza', '', '', '', '', '', NULL),
(4, '02347410580', '1234', 'laiza.abreu@gmail.com', 'Maria Laiza Abreu', '41810011', 'Av. Magalhães Neto', 'Pituba', 'Salvador', 'BA', '(71) 9977-7477'),
(8, '923.474.105-80', '1234', 'ricardovbhage@gmail.com', 'Ricardo Hage', '4032030', 'Rua Leonor Calmon', 'Candeal', 'Salvador', 'BA', '(71) 9999-9999'),
(11, '023.235.478-95', '0505', 'ricardovbhage@gmail.com', 'Ricardo Hage', '40296210', 'Rua Leonor Calmon', 'Cidade Jardim', 'Salvador', 'BA', '(71) 9733-8312'),
(12, '802.318.615-91', '0505', 'ricardovbhage@gmail.com', 'RICARDO HAGE', '40296210', 'RUA LEONOR CALMON', 'CIDADE JARDIM', 'SALVADOR', 'BA', '(71) 9733-8312'),
(13, '', '', 'ricardovbhage@gmail.com', 'RICARDO HAGE', '400000000', 'RUA LEONOR CALMON', 'CIDADE JARDIM', 'SALVADOR', 'BA', '');

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`Id`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `usuario`
--
ALTER TABLE `usuario`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
