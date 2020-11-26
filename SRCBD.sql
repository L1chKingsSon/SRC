-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 19-Nov-2019 às 13:02
-- Versão do servidor: 10.4.8-MariaDB
-- versão do PHP: 7.3.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `srcbd`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `carro`
--

CREATE TABLE `carro` (
  `id` int(11) NOT NULL,
  `cor` varchar(45) DEFAULT NULL,
  `placa` varchar(45) DEFAULT NULL,
  `chassi` varchar(45) DEFAULT NULL,
  `ano` varchar(45) DEFAULT NULL,
  `IPVA` varchar(45) DEFAULT NULL,
  `seguro` varchar(45) DEFAULT NULL,
  `garantia` varchar(45) DEFAULT NULL,
  `valorComprado` double DEFAULT NULL,
  `id_Modelo` int(11) NOT NULL,
  `id_Estacionamento` int(11) NOT NULL,
  `valorVenda` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `carro`
--

INSERT INTO `carro` (`id`, `cor`, `placa`, `chassi`, `ano`, `IPVA`, `seguro`, `garantia`, `valorComprado`, `id_Modelo`, `id_Estacionamento`, `valorVenda`) VALUES
(1, 'verde', 'gfd-1325', '45esd23g', '2010', '1', '10/01/2000', '20/01/2000', 123, 1, 1, 432),
(2, 'ZOMPa', 'gfd-1325', '45esd23g', '2010', '2021', '10/01/2000', '20/01/2000', 123, 1, 1, 4325),
(3, 'arcoiris', 'ofw-3241', '3290jfao', '1897', '2017', '20/11/2015', '31/12/2019', 10000, 2, 2, 20000);

-- --------------------------------------------------------

--
-- Estrutura da tabela `cliente`
--

CREATE TABLE `cliente` (
  `id` int(11) NOT NULL,
  `nome` varchar(45) DEFAULT NULL,
  `cpf` varchar(45) DEFAULT NULL,
  `telefone` varchar(45) DEFAULT NULL,
  `id_Conta_Banco` int(11) NOT NULL,
  `id_Endereco` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `cliente`
--

INSERT INTO `cliente` (`id`, `nome`, `cpf`, `telefone`, `id_Conta_Banco`, `id_Endereco`) VALUES
(1, 'Raphaela', '01654138677', '32991665577', 1, 1),
(2, 'teste', '12323543', '23431', 2, 4),
(3, 'lavinia', '10718864603', '323451', 2, 2),
(4, 'Davi', '12432', 'asdasd', 1, 2);

-- --------------------------------------------------------

--
-- Estrutura da tabela `compra`
--

CREATE TABLE `compra` (
  `id` int(11) NOT NULL,
  `id_carro` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `compra`
--

INSERT INTO `compra` (`id`, `id_carro`) VALUES
(1, 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `contabanco`
--

CREATE TABLE `contabanco` (
  `id` int(11) NOT NULL,
  `agencia` varchar(45) DEFAULT NULL,
  `conta` varchar(45) DEFAULT NULL,
  `tipo` varchar(45) DEFAULT NULL,
  `nome` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `contabanco`
--

INSERT INTO `contabanco` (`id`, `agencia`, `conta`, `tipo`, `nome`) VALUES
(1, '1731', '00043657-0', 'poupança', 'josé fagundes'),
(2, '1453', '000532-4', 'corrente', 'manoel honório');

-- --------------------------------------------------------

--
-- Estrutura da tabela `endereco`
--

CREATE TABLE `endereco` (
  `id` int(11) NOT NULL,
  `cep` varchar(45) DEFAULT NULL,
  `uf` varchar(45) DEFAULT NULL,
  `cidade` varchar(45) DEFAULT NULL,
  `bairro` varchar(45) DEFAULT NULL,
  `logradouro` varchar(45) DEFAULT NULL,
  `numero` varchar(45) DEFAULT NULL,
  `complemento` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `endereco`
--

INSERT INTO `endereco` (`id`, `cep`, `uf`, `cidade`, `bairro`, `logradouro`, `numero`, `complemento`) VALUES
(1, '36010012', 'MG', 'Juiz de Fora', 'Centro', 'Av Barão do Rio Branco', '2827', 'apto 209'),
(2, '36070340', 'MG', 'Juiz de Fora', 'JK', 'Rua Doutor Murilo de Andrade Abreu', '208', '208'),
(3, '36085410', NULL, 'Juiz de Fora', 'cidade do sol', 'rua rosário fusco', '131', 'apto 101'),
(4, '36070340', NULL, 'Juiz de Fora', 'jk', 'Rua Doutor Murilo de Andrade Abreu', '208', '208');

-- --------------------------------------------------------

--
-- Estrutura da tabela `estacionamento`
--

CREATE TABLE `estacionamento` (
  `id` int(11) NOT NULL,
  `numeroVagas` int(11) DEFAULT NULL,
  `id_endereco` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `estacionamento`
--

INSERT INTO `estacionamento` (`id`, `numeroVagas`, `id_endereco`) VALUES
(1, 16, 1),
(2, 43, 2);

-- --------------------------------------------------------

--
-- Estrutura da tabela `funcionario`
--

CREATE TABLE `funcionario` (
  `id` int(11) NOT NULL,
  `salario` float DEFAULT NULL,
  `login` varchar(45) DEFAULT NULL,
  `senha` varchar(45) DEFAULT NULL,
  `nome` varchar(45) DEFAULT NULL,
  `CPF` varchar(45) DEFAULT NULL,
  `telefone` varchar(45) DEFAULT NULL,
  `id_Conta_Banco` int(11) NOT NULL,
  `id_Endereco` int(11) NOT NULL,
  `nivelAcesso` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `funcionario`
--

INSERT INTO `funcionario` (`id`, `salario`, `login`, `senha`, `nome`, `CPF`, `telefone`, `id_Conta_Banco`, `id_Endereco`, `nivelAcesso`) VALUES
(1, 1800, 'loginloginzin', 'asenhaeessa', 'Alisson', '5489274', '32348502', 1, 2, NULL),
(2, 366, 'Draklex', 'wowzin1', 'Davi', '3134', '345', 2, 2, 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `itens`
--

CREATE TABLE `itens` (
  `id` int(11) NOT NULL,
  `NotaFiscal_id` int(11) NOT NULL,
  `id_Carro` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `marca`
--

CREATE TABLE `marca` (
  `id` int(11) NOT NULL,
  `nome` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `marca`
--

INSERT INTO `marca` (`id`, `nome`) VALUES
(1, 'Chevrolet'),
(2, 'Fiat'),
(3, 'Hyundai'),
(4, 'Ferrari'),
(5, 'Pórsche'),
(6, 'cherry');

-- --------------------------------------------------------

--
-- Estrutura da tabela `modelo`
--

CREATE TABLE `modelo` (
  `id` int(11) NOT NULL,
  `nome` varchar(45) DEFAULT NULL,
  `id_Marca` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `modelo`
--

INSERT INTO `modelo` (`id`, `nome`, `id_Marca`) VALUES
(1, 'Onix', 1),
(2, 'Argo', 2),
(3, 'HB20', 3);

-- --------------------------------------------------------

--
-- Estrutura da tabela `notafiscal`
--

CREATE TABLE `notafiscal` (
  `id` int(11) NOT NULL,
  `data` varchar(45) DEFAULT NULL,
  `valor` varchar(45) DEFAULT NULL,
  `Transacao` enum('COMPRA','VENDA') DEFAULT NULL,
  `id_Funcionario` int(11) NOT NULL,
  `id_Cliente` int(11) NOT NULL,
  `id_Compra` int(11) DEFAULT NULL,
  `id_Venda` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `reserva`
--

CREATE TABLE `reserva` (
  `id` int(11) NOT NULL,
  `cor` varchar(45) DEFAULT NULL,
  `id_Cliente` int(11) NOT NULL,
  `id_Modelo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `reserva`
--

INSERT INTO `reserva` (`id`, `cor`, `id_Cliente`, `id_Modelo`) VALUES
(1, 'azul', 1, 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `venda`
--

CREATE TABLE `venda` (
  `id` int(11) NOT NULL,
  `id_carro` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `carro`
--
ALTER TABLE `carro`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_Carro_Modelo1` (`id_Modelo`),
  ADD KEY `fk_Carro_Estacionamento1` (`id_Estacionamento`);

--
-- Índices para tabela `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_Cliente_ContaBanco1` (`id_Conta_Banco`),
  ADD KEY `fk_Cliente_endereco2` (`id_Endereco`);

--
-- Índices para tabela `compra`
--
ALTER TABLE `compra`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `contabanco`
--
ALTER TABLE `contabanco`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `endereco`
--
ALTER TABLE `endereco`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `estacionamento`
--
ALTER TABLE `estacionamento`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_Estacionamento_endereco1` (`id_endereco`);

--
-- Índices para tabela `funcionario`
--
ALTER TABLE `funcionario`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_Funcionario_ContaBanco1` (`id_Conta_Banco`),
  ADD KEY `fk_Funcionario_endereco1` (`id_Endereco`);

--
-- Índices para tabela `itens`
--
ALTER TABLE `itens`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_Itens_NotaFiscal1` (`NotaFiscal_id`),
  ADD KEY `fk_Itens_Carro1` (`id_Carro`);

--
-- Índices para tabela `marca`
--
ALTER TABLE `marca`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `modelo`
--
ALTER TABLE `modelo`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_Modelo_Marca1` (`id_Marca`);

--
-- Índices para tabela `notafiscal`
--
ALTER TABLE `notafiscal`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_NotaFiscal_Funcionario1` (`id_Funcionario`),
  ADD KEY `fk_NotaFiscal_Cliente2` (`id_Cliente`);

--
-- Índices para tabela `reserva`
--
ALTER TABLE `reserva`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_interesse_Cliente1` (`id_Cliente`),
  ADD KEY `fk_interesse_Modelo1` (`id_Modelo`);

--
-- Índices para tabela `venda`
--
ALTER TABLE `venda`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `carro`
--
ALTER TABLE `carro`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de tabela `cliente`
--
ALTER TABLE `cliente`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de tabela `compra`
--
ALTER TABLE `compra`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de tabela `funcionario`
--
ALTER TABLE `funcionario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de tabela `venda`
--
ALTER TABLE `venda`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `carro`
--
ALTER TABLE `carro`
  ADD CONSTRAINT `fk_Carro_Estacionamento1` FOREIGN KEY (`id_Estacionamento`) REFERENCES `estacionamento` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Carro_Modelo1` FOREIGN KEY (`id_Modelo`) REFERENCES `modelo` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `cliente`
--
ALTER TABLE `cliente`
  ADD CONSTRAINT `fk_Cliente_ContaBanco1` FOREIGN KEY (`id_Conta_Banco`) REFERENCES `contabanco` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Cliente_endereco2` FOREIGN KEY (`id_Endereco`) REFERENCES `endereco` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `estacionamento`
--
ALTER TABLE `estacionamento`
  ADD CONSTRAINT `fk_Estacionamento_endereco1` FOREIGN KEY (`id_endereco`) REFERENCES `endereco` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `funcionario`
--
ALTER TABLE `funcionario`
  ADD CONSTRAINT `fk_Funcionario_ContaBanco1` FOREIGN KEY (`id_Conta_Banco`) REFERENCES `contabanco` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Funcionario_endereco1` FOREIGN KEY (`id_Endereco`) REFERENCES `endereco` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `itens`
--
ALTER TABLE `itens`
  ADD CONSTRAINT `fk_Itens_Carro1` FOREIGN KEY (`id_Carro`) REFERENCES `carro` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Itens_NotaFiscal1` FOREIGN KEY (`NotaFiscal_id`) REFERENCES `notafiscal` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `modelo`
--
ALTER TABLE `modelo`
  ADD CONSTRAINT `fk_Modelo_Marca1` FOREIGN KEY (`id_Marca`) REFERENCES `marca` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `notafiscal`
--
ALTER TABLE `notafiscal`
  ADD CONSTRAINT `fk_NotaFiscal_Cliente2` FOREIGN KEY (`id_Cliente`) REFERENCES `cliente` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_NotaFiscal_Funcionario1` FOREIGN KEY (`id_Funcionario`) REFERENCES `funcionario` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `reserva`
--
ALTER TABLE `reserva`
  ADD CONSTRAINT `fk_interesse_Cliente1` FOREIGN KEY (`id_Cliente`) REFERENCES `cliente` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_interesse_Modelo1` FOREIGN KEY (`id_Modelo`) REFERENCES `modelo` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
