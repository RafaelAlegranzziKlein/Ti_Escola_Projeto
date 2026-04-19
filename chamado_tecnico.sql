-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 15/04/2026 às 22:52
-- Versão do servidor: 10.4.32-MariaDB
-- Versão do PHP: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `ti_escola`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `chamado_tecnico`
--

CREATE TABLE `chamado_tecnico` (
  `id` int(11) NOT NULL,
  `solicitante` varchar(100) NOT NULL,
  `sala` varchar(50) NOT NULL,
  `equipamento_tag` varchar(50) NOT NULL,
  `problema_relatado` text NOT NULL,
  `diagnostico_tecnico` text NOT NULL,
  `prioridade` varchar(20) NOT NULL DEFAULT 'media',
  `status` varchar(20) NOT NULL DEFAULT 'pendente',
  `data_abertura` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--

-- Criar tabela de Usuários com campos para login [cite: 214, 218]
CREATE TABLE IF NOT EXISTS `usuarios` (
`id_usuario` INT NOT NULL AUTO_INCREMENT,
`nome` VARCHAR(100) NOT NULL,
`email` VARCHAR(100) NOT NULL UNIQUE,
`senha` VARCHAR(255) NOT NULL,
PRIMARY KEY (`id_usuario`)
) ENGINE=InnoDB;
-- Criar tabela de Equipamentos [cite: 232, 244]
CREATE TABLE IF NOT EXISTS `equipamentos` (
`id_equipamento` INT NOT NULL AUTO_INCREMENT,
`tag_patrimonio` VARCHAR(50) NOT NULL UNIQUE,
`sala` VARCHAR(50),
PRIMARY KEY (`id_equipamento`)
) ENGINE=InnoDB;


-- Índices para tabelas despejadas
--

--
-- Índices de tabela `chamado_tecnico`
--
ALTER TABLE `chamado_tecnico`
  ADD PRIMARY KEY (`id`);

--
-- 1. Converter o motor da tabela para InnoDB (obrigatório para FKs) [cite: 13, 188]
ALTER TABLE `chamado_tecnico` ENGINE=InnoDB;

-- 2. Adicionar as colunas de ID para os relacionamentos [cite: 261, 294]
ALTER TABLE `chamado_tecnico`
ADD COLUMN `id_usuario` INT NULL AFTER `id`,
ADD COLUMN `id_equipamento` INT NULL AFTER `id_usuario`;

-- 3. REMOÇÃO DOS CAMPOS REDUNDANTES (A peça que faltava!)
-- Removemos solicitante e equipamento_tag porque agora usamos IDs[cite: 10, 202].
-- Removemos sala porque ela agora pertence à entidade Equipamento.

ALTER TABLE `chamado_tecnico`
DROP COLUMN `solicitante`,
DROP COLUMN `equipamento_tag`,
DROP COLUMN `sala`;

-- 4. Aplicar as Chaves Estrangeiras (Foreign Keys) [cite: 241, 253, 295]
ALTER TABLE `chamado_tecnico`
ADD CONSTRAINT `fk_usuario_chamado`
FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id_usuario`),
ADD CONSTRAINT `fk_equipamento_chamado`
FOREIGN KEY (`id_equipamento`) REFERENCES `equipamentos`
(`id_equipamento`);
-- AUTO_INCREMENT para tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `chamado_tecnico`
--
ALTER TABLE `chamado_tecnico`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
