CREATE DATABASE  IF NOT EXISTS `hotelaltosdaflora` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `hotelaltosdaflora`;
-- MySQL dump 10.13  Distrib 5.6.17, for Win32 (x86)
--
-- Host: localhost    Database: hotelaltosdaflora
-- ------------------------------------------------------
-- Server version	5.6.19

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `acomodacao`
--

DROP TABLE IF EXISTS `acomodacao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `acomodacao` (
  `idacomodacao` int(11) NOT NULL AUTO_INCREMENT,
  `nroAcomodacao` int(11) NOT NULL,
  `andar` int(11) NOT NULL,
  `idTipoAcomodacao` int(11) NOT NULL,
  `disponivel` smallint(6) NOT NULL DEFAULT '1',
  PRIMARY KEY (`idacomodacao`),
  KEY `fk_acomodacao_tipoAcomodacao1_idx` (`idTipoAcomodacao`),
  CONSTRAINT `fk_acomodacao_tipoAcomodacao1` FOREIGN KEY (`idTipoAcomodacao`) REFERENCES `tipoacomodacao` (`idtipoAcomodacao`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `acomodacao`
--

LOCK TABLES `acomodacao` WRITE;
/*!40000 ALTER TABLE `acomodacao` DISABLE KEYS */;
INSERT INTO `acomodacao` VALUES (6,2,1,3,1);
/*!40000 ALTER TABLE `acomodacao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `acompanhante`
--

DROP TABLE IF EXISTS `acompanhante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `acompanhante` (
  `idAcompanhante` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `idade` int(11) NOT NULL,
  PRIMARY KEY (`idAcompanhante`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `acompanhante`
--

LOCK TABLES `acompanhante` WRITE;
/*!40000 ALTER TABLE `acompanhante` DISABLE KEYS */;
INSERT INTO `acompanhante` VALUES (1,'maria',12),(2,'jose',9),(3,'maria',10),(4,'maria',7),(5,'maria',10),(6,'ana',2),(7,'ana',2),(8,'maria ',9),(9,'iii',1),(10,'julia',13),(11,'julia',13),(12,'ga',7),(13,'ga',7),(14,'kk',1),(15,'ii',8),(16,'tt',7),(17,'uhuh',7),(18,'uhuhuh',9),(19,'uhuh',7),(20,'uhuhuh',9);
/*!40000 ALTER TABLE `acompanhante` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categoria`
--

DROP TABLE IF EXISTS `categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categoria` (
  `idCategoria` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(45) NOT NULL,
  PRIMARY KEY (`idCategoria`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoria`
--

LOCK TABLES `categoria` WRITE;
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
INSERT INTO `categoria` VALUES (1,'Frigobar'),(5,'restaurante');
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `consumo`
--

DROP TABLE IF EXISTS `consumo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `consumo` (
  `idconsumo` int(11) NOT NULL AUTO_INCREMENT,
  `data` date NOT NULL,
  `valor` decimal(10,2) NOT NULL,
  `idEntrada` int(11) NOT NULL,
  PRIMARY KEY (`idconsumo`),
  KEY `fk_Consumo_Entrada1_idx` (`idEntrada`),
  CONSTRAINT `fk_Consumo_Entrada1` FOREIGN KEY (`idEntrada`) REFERENCES `entrada` (`idEntrada`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `consumo`
--

LOCK TABLES `consumo` WRITE;
/*!40000 ALTER TABLE `consumo` DISABLE KEYS */;
/*!40000 ALTER TABLE `consumo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contato`
--

DROP TABLE IF EXISTS `contato`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `contato` (
  `idContato` int(11) NOT NULL AUTO_INCREMENT,
  `telResidencial` varchar(13) NOT NULL,
  `celular` varchar(13) NOT NULL,
  `telComercial` varchar(13) NOT NULL,
  `email` varchar(50) NOT NULL,
  PRIMARY KEY (`idContato`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contato`
--

LOCK TABLES `contato` WRITE;
/*!40000 ALTER TABLE `contato` DISABLE KEYS */;
INSERT INTO `contato` VALUES (1,'33364298','997142202','','giiovanna_franco@hotmail.com'),(2,'33364298','997142202','','giiovanna_franco@hotmail.com'),(3,'1111','1111','1111','wwwww'),(4,'312','90909','9090','uhuh'),(5,'9999','999','999','gyj'),(6,'9999','999','999','gyj'),(7,'uuu','uuu','uuu','uu'),(8,'uuu','uu','uu','uu'),(9,'uuu','uu','uu','uu'),(10,'yyy','yy','yy','yy'),(11,'uuu','uu','37647843','u');
/*!40000 ALTER TABLE `contato` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `endereco`
--

DROP TABLE IF EXISTS `endereco`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `endereco` (
  `idEndereco` int(11) NOT NULL AUTO_INCREMENT,
  `logradouro` varchar(45) NOT NULL,
  `bairro` varchar(45) NOT NULL,
  `numero` int(11) NOT NULL,
  `cidade` varchar(45) NOT NULL,
  `uf` char(2) NOT NULL,
  `cep` varchar(13) NOT NULL,
  PRIMARY KEY (`idEndereco`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `endereco`
--

LOCK TABLES `endereco` WRITE;
/*!40000 ALTER TABLE `endereco` DISABLE KEYS */;
INSERT INTO `endereco` VALUES (1,'Rua Adão Aroni','Chácara Flora',18,'Araraquara','SP','14805362'),(2,'Rua Adão Aroni','Chácara Flora',18,'Araraquara','SP','14805362'),(3,'uuuuu','uuhuh',0,'uhuhuhh','MG','1111'),(4,'uuu','uuu',0,'uuu','RJ','111'),(5,'uhuhuh','uhuh',8,'uhuh','SP','999'),(6,'uhuhuh','uhuh',8,'uhuh','SC','999'),(7,'uuu','uuu',99,'uuu','SP','uuuu'),(8,'uuu','uuu',88,'uuu','SP','uuu'),(9,'uuu','uuu',88,'uuu','SC','uuu'),(10,'ttt','yyy',90,'yyy','SP','yyy'),(11,'uuu','uuu',8,'uuu','MG','uu');
/*!40000 ALTER TABLE `endereco` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `entrada`
--

DROP TABLE IF EXISTS `entrada`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `entrada` (
  `idEntrada` int(11) NOT NULL AUTO_INCREMENT,
  `dataChegada` datetime NOT NULL,
  `dataSaida` datetime NOT NULL,
  `idAcomodacao` int(11) NOT NULL,
  `idHospede` int(11) NOT NULL,
  `idFuncionario` int(11) NOT NULL,
  `ativa` smallint(6) NOT NULL DEFAULT '1',
  PRIMARY KEY (`idEntrada`),
  KEY `fk_Entrada_acomodacao1_idx` (`idAcomodacao`),
  KEY `fk_Entrada_Hospede1_idx` (`idHospede`),
  KEY `fk_Entrada_Funcionario1_idx` (`idFuncionario`),
  CONSTRAINT `fk_Entrada_acomodacao1` FOREIGN KEY (`idAcomodacao`) REFERENCES `acomodacao` (`idacomodacao`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Entrada_Funcionario1` FOREIGN KEY (`idFuncionario`) REFERENCES `funcionario` (`idFuncionario`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Entrada_Hospede1` FOREIGN KEY (`idHospede`) REFERENCES `hospede` (`idHospede`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `entrada`
--

LOCK TABLES `entrada` WRITE;
/*!40000 ALTER TABLE `entrada` DISABLE KEYS */;
INSERT INTO `entrada` VALUES (1,'2014-11-27 00:00:00','2014-11-29 00:00:00',6,1,1,1),(2,'2014-11-28 00:00:00','2014-11-27 00:00:00',6,1,1,1),(3,'2014-11-27 00:00:00','2014-11-29 00:00:00',6,1,1,1),(4,'2014-11-27 00:00:00','2014-11-29 00:00:00',6,1,1,1),(5,'2014-11-27 00:00:00','2014-11-29 00:00:00',6,1,1,1);
/*!40000 ALTER TABLE `entrada` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `entrada_acompanhante`
--

DROP TABLE IF EXISTS `entrada_acompanhante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `entrada_acompanhante` (
  `idAcompanhante` int(11) NOT NULL,
  `idEntrada` int(11) NOT NULL,
  PRIMARY KEY (`idAcompanhante`,`idEntrada`),
  KEY `fk_Acompanhante_has_Entrada_Entrada1_idx` (`idEntrada`),
  KEY `fk_Acompanhante_has_Entrada_Acompanhante1_idx` (`idAcompanhante`),
  CONSTRAINT `fk_Acompanhante_has_Entrada_Acompanhante1` FOREIGN KEY (`idAcompanhante`) REFERENCES `acompanhante` (`idAcompanhante`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Acompanhante_has_Entrada_Entrada1` FOREIGN KEY (`idEntrada`) REFERENCES `entrada` (`idEntrada`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `entrada_acompanhante`
--

LOCK TABLES `entrada_acompanhante` WRITE;
/*!40000 ALTER TABLE `entrada_acompanhante` DISABLE KEYS */;
INSERT INTO `entrada_acompanhante` VALUES (13,2);
/*!40000 ALTER TABLE `entrada_acompanhante` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `funcionario`
--

DROP TABLE IF EXISTS `funcionario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `funcionario` (
  `idFuncionario` int(11) NOT NULL AUTO_INCREMENT,
  `nomeAcesso` varchar(45) NOT NULL,
  `senhaAcesso` varchar(45) NOT NULL,
  `nivelAcesso` smallint(6) NOT NULL,
  `nome` varchar(45) NOT NULL,
  PRIMARY KEY (`idFuncionario`),
  UNIQUE KEY `nomeAcesso_UNIQUE` (`nomeAcesso`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funcionario`
--

LOCK TABLES `funcionario` WRITE;
/*!40000 ALTER TABLE `funcionario` DISABLE KEYS */;
INSERT INTO `funcionario` VALUES (1,'anac','1234',1,'Ana');
/*!40000 ALTER TABLE `funcionario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hospede`
--

DROP TABLE IF EXISTS `hospede`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hospede` (
  `idHospede` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `rg` varchar(12) NOT NULL,
  `dataNascimento` date NOT NULL,
  `idContato` int(11) NOT NULL,
  `idEndereco` int(11) NOT NULL,
  `ativo` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`idHospede`),
  KEY `fk_Hospede_Contato_idx` (`idContato`),
  KEY `fk_Hospede_Endereco1_idx` (`idEndereco`),
  CONSTRAINT `fk_Hospede_Contato` FOREIGN KEY (`idContato`) REFERENCES `contato` (`idContato`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Hospede_Endereco1` FOREIGN KEY (`idEndereco`) REFERENCES `endereco` (`idEndereco`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hospede`
--

LOCK TABLES `hospede` WRITE;
/*!40000 ALTER TABLE `hospede` DISABLE KEYS */;
INSERT INTO `hospede` VALUES (1,'Giovanna Franco','407776199','1995-03-21',1,1,0),(2,'jjj','888','2014-11-01',3,3,0),(3,'teste','77','2014-11-14',4,4,0),(4,'teste2','99','2014-11-13',5,5,0),(5,'teste2','99','2014-11-13',6,6,0),(6,'tes','44','2014-11-07',7,7,1),(7,'uhuuh','888','2014-11-21',8,8,1),(8,'gIOVANNNA','888','2014-11-21',9,9,0),(9,'tttt','666','2014-11-01',10,10,1),(10,'anadfdfdfdsfdsds','99','2014-11-20',11,11,1);
/*!40000 ALTER TABLE `hospede` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `itemconsumo`
--

DROP TABLE IF EXISTS `itemconsumo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `itemconsumo` (
  `iditemConsumo` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(50) NOT NULL,
  `quantidade` int(11) NOT NULL,
  `valorUnitario` decimal(10,2) NOT NULL,
  `idCategoria` int(11) NOT NULL,
  `idconsumo` int(11) NOT NULL,
  PRIMARY KEY (`iditemConsumo`),
  KEY `fk_itemConsumo_Categoria1_idx` (`idCategoria`),
  KEY `fk_ItemConsumo_Consumo1_idx` (`idconsumo`),
  CONSTRAINT `fk_itemConsumo_Categoria1` FOREIGN KEY (`idCategoria`) REFERENCES `categoria` (`idCategoria`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_ItemConsumo_Consumo1` FOREIGN KEY (`idconsumo`) REFERENCES `consumo` (`idconsumo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `itemconsumo`
--

LOCK TABLES `itemconsumo` WRITE;
/*!40000 ALTER TABLE `itemconsumo` DISABLE KEYS */;
/*!40000 ALTER TABLE `itemconsumo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reserva`
--

DROP TABLE IF EXISTS `reserva`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reserva` (
  `idReserva` int(11) NOT NULL AUTO_INCREMENT,
  `dataChegada` datetime NOT NULL,
  `dataSaida` datetime NOT NULL,
  `taxaMulta` decimal(10,2) NOT NULL,
  `idTipoAcomodacao` int(11) NOT NULL,
  `idHospede` int(11) NOT NULL,
  `idFuncionario` int(11) NOT NULL,
  `ativa` smallint(6) NOT NULL DEFAULT '1',
  PRIMARY KEY (`idReserva`),
  KEY `fk_Reserva_tipoAcomodacao1_idx` (`idTipoAcomodacao`),
  KEY `fk_Reserva_Hospede1_idx` (`idHospede`),
  KEY `fk_Reserva_Funcionario1_idx` (`idFuncionario`),
  CONSTRAINT `fk_Reserva_Funcionario1` FOREIGN KEY (`idFuncionario`) REFERENCES `funcionario` (`idFuncionario`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Reserva_Hospede1` FOREIGN KEY (`idHospede`) REFERENCES `hospede` (`idHospede`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Reserva_tipoAcomodacao1` FOREIGN KEY (`idTipoAcomodacao`) REFERENCES `tipoacomodacao` (`idtipoAcomodacao`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reserva`
--

LOCK TABLES `reserva` WRITE;
/*!40000 ALTER TABLE `reserva` DISABLE KEYS */;
INSERT INTO `reserva` VALUES (1,'2014-11-27 00:00:00','2014-11-29 00:00:00',40.00,3,1,1,0),(2,'2014-11-07 00:00:00','2014-11-08 00:00:00',0.00,3,1,1,1);
/*!40000 ALTER TABLE `reserva` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reserva_acompanhante`
--

DROP TABLE IF EXISTS `reserva_acompanhante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reserva_acompanhante` (
  `idReserva` int(11) NOT NULL,
  `idAcompanhante` int(11) NOT NULL,
  PRIMARY KEY (`idReserva`,`idAcompanhante`),
  KEY `fk_Reserva_has_Acompanhante_Acompanhante1_idx` (`idAcompanhante`),
  KEY `fk_Reserva_has_Acompanhante_Reserva1_idx` (`idReserva`),
  CONSTRAINT `fk_Reserva_has_Acompanhante_Acompanhante1` FOREIGN KEY (`idAcompanhante`) REFERENCES `acompanhante` (`idAcompanhante`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Reserva_has_Acompanhante_Reserva1` FOREIGN KEY (`idReserva`) REFERENCES `reserva` (`idReserva`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reserva_acompanhante`
--

LOCK TABLES `reserva_acompanhante` WRITE;
/*!40000 ALTER TABLE `reserva_acompanhante` DISABLE KEYS */;
INSERT INTO `reserva_acompanhante` VALUES (1,19),(1,20);
/*!40000 ALTER TABLE `reserva_acompanhante` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `saida`
--

DROP TABLE IF EXISTS `saida`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `saida` (
  `idSaida` int(11) NOT NULL AUTO_INCREMENT,
  `data` datetime NOT NULL,
  `numeroDiarias` int(11) NOT NULL,
  `totalDiarias` decimal(10,2) NOT NULL,
  `totalConsumo` decimal(10,2) NOT NULL,
  `idEntrada` int(11) NOT NULL,
  `tipoPagamento` varchar(20) NOT NULL,
  PRIMARY KEY (`idSaida`),
  KEY `fk_Saida_Entrada1_idx` (`idEntrada`),
  CONSTRAINT `fk_Saida_Entrada1` FOREIGN KEY (`idEntrada`) REFERENCES `entrada` (`idEntrada`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `saida`
--

LOCK TABLES `saida` WRITE;
/*!40000 ALTER TABLE `saida` DISABLE KEYS */;
/*!40000 ALTER TABLE `saida` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipoacomodacao`
--

DROP TABLE IF EXISTS `tipoacomodacao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipoacomodacao` (
  `idtipoAcomodacao` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(30) NOT NULL,
  `qtdeAcomodacoes` int(11) NOT NULL,
  `precoDiaria` decimal(10,2) NOT NULL,
  `nroDeAdulto` int(11) NOT NULL,
  `nroDeCrianca` int(11) NOT NULL,
  PRIMARY KEY (`idtipoAcomodacao`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipoacomodacao`
--

LOCK TABLES `tipoacomodacao` WRITE;
/*!40000 ALTER TABLE `tipoacomodacao` DISABLE KEYS */;
INSERT INTO `tipoacomodacao` VALUES (3,'luxo',10,90.00,1,2),(4,'simples',10,12.00,1,0);
/*!40000 ALTER TABLE `tipoacomodacao` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-11-29 16:04:51
