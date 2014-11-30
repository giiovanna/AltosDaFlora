SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema HotelAltosDaFlora
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `HotelAltosDaFlora` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `HotelAltosDaFlora` ;

-- -----------------------------------------------------
-- Table `HotelAltosDaFlora`.`Contato`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `HotelAltosDaFlora`.`Contato` (
  `idContato` INT NOT NULL AUTO_INCREMENT,
  `telResidencial` VARCHAR(13) NOT NULL,
  `celular` VARCHAR(13) NOT NULL,
  `telComercial` VARCHAR(13) NOT NULL,
  `email` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`idContato`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `HotelAltosDaFlora`.`Endereco`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `HotelAltosDaFlora`.`Endereco` (
  `idEndereco` INT NOT NULL AUTO_INCREMENT,
  `logradouro` VARCHAR(45) NOT NULL,
  `bairro` VARCHAR(45) NOT NULL,
  `numero` INT NOT NULL,
  `cidade` VARCHAR(45) NOT NULL,
  `uf` CHAR(2) NOT NULL,
  `cep` VARCHAR(13) NOT NULL,
  PRIMARY KEY (`idEndereco`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `HotelAltosDaFlora`.`Hospede`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `HotelAltosDaFlora`.`Hospede` (
  `idHospede` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `rg` VARCHAR(12) NOT NULL,
  `dataNascimento` DATE NOT NULL,
  `idContato` INT NOT NULL,
  `idEndereco` INT NOT NULL,
  `ativo` SMALLINT NOT NULL DEFAULT 1,
  PRIMARY KEY (`idHospede`),
  INDEX `fk_Hospede_Contato_idx` (`idContato` ASC),
  INDEX `fk_Hospede_Endereco1_idx` (`idEndereco` ASC),
  CONSTRAINT `fk_Hospede_Contato`
    FOREIGN KEY (`idContato`)
    REFERENCES `HotelAltosDaFlora`.`Contato` (`idContato`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Hospede_Endereco1`
    FOREIGN KEY (`idEndereco`)
    REFERENCES `HotelAltosDaFlora`.`Endereco` (`idEndereco`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `HotelAltosDaFlora`.`Categoria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `HotelAltosDaFlora`.`Categoria` (
  `idCategoria` INT NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(45) NOT NULL,
  `ativo` SMALLINT NOT NULL DEFAULT 1,
  PRIMARY KEY (`idCategoria`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `HotelAltosDaFlora`.`TipoAcomodacao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `HotelAltosDaFlora`.`TipoAcomodacao` (
  `idtipoAcomodacao` INT NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(30) NOT NULL,
  `qtdeAcomodacoes` INT NOT NULL,
  `precoDiaria` DECIMAL(10,2) NOT NULL,
  `nroDeAdulto` INT NOT NULL,
  `nroDeCrianca` INT NOT NULL,
  `ativo` SMALLINT NOT NULL DEFAULT 1,
  PRIMARY KEY (`idtipoAcomodacao`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `HotelAltosDaFlora`.`Acomodacao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `HotelAltosDaFlora`.`Acomodacao` (
  `idacomodacao` INT NOT NULL AUTO_INCREMENT,
  `nroAcomodacao` INT NOT NULL,
  `andar` INT NOT NULL,
  `idTipoAcomodacao` INT NOT NULL,
  `disponivel` SMALLINT NOT NULL DEFAULT 1,
  `ativo` SMALLINT NOT NULL DEFAULT 1,
  PRIMARY KEY (`idacomodacao`),
  INDEX `fk_acomodacao_tipoAcomodacao1_idx` (`idTipoAcomodacao` ASC),
  CONSTRAINT `fk_acomodacao_tipoAcomodacao1`
    FOREIGN KEY (`idTipoAcomodacao`)
    REFERENCES `HotelAltosDaFlora`.`TipoAcomodacao` (`idtipoAcomodacao`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `HotelAltosDaFlora`.`Funcionario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `HotelAltosDaFlora`.`Funcionario` (
  `idFuncionario` INT NOT NULL AUTO_INCREMENT,
  `nomeAcesso` VARCHAR(45) NOT NULL,
  `senhaAcesso` VARCHAR(45) NOT NULL,
  `nivelAcesso` SMALLINT NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `ativo` SMALLINT NOT NULL DEFAULT 1,
  PRIMARY KEY (`idFuncionario`),
  UNIQUE INDEX `nomeAcesso_UNIQUE` (`nomeAcesso` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `HotelAltosDaFlora`.`Entrada`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `HotelAltosDaFlora`.`Entrada` (
  `idEntrada` INT NOT NULL AUTO_INCREMENT,
  `dataChegada` DATETIME NOT NULL,
  `dataSaida` DATETIME NOT NULL,
  `idAcomodacao` INT NOT NULL,
  `idHospede` INT NOT NULL,
  `idFuncionario` INT NOT NULL,
  `ativo` SMALLINT NOT NULL DEFAULT 1,
  PRIMARY KEY (`idEntrada`),
  INDEX `fk_Entrada_acomodacao1_idx` (`idAcomodacao` ASC),
  INDEX `fk_Entrada_Hospede1_idx` (`idHospede` ASC),
  INDEX `fk_Entrada_Funcionario1_idx` (`idFuncionario` ASC),
  CONSTRAINT `fk_Entrada_acomodacao1`
    FOREIGN KEY (`idAcomodacao`)
    REFERENCES `HotelAltosDaFlora`.`Acomodacao` (`idacomodacao`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Entrada_Hospede1`
    FOREIGN KEY (`idHospede`)
    REFERENCES `HotelAltosDaFlora`.`Hospede` (`idHospede`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Entrada_Funcionario1`
    FOREIGN KEY (`idFuncionario`)
    REFERENCES `HotelAltosDaFlora`.`Funcionario` (`idFuncionario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `HotelAltosDaFlora`.`Consumo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `HotelAltosDaFlora`.`Consumo` (
  `idconsumo` INT NOT NULL AUTO_INCREMENT,
  `data` DATE NOT NULL,
  `valor` DECIMAL(10,2) NOT NULL,
  `idEntrada` INT NOT NULL,
  `ativo` SMALLINT NOT NULL DEFAULT 1,
  PRIMARY KEY (`idconsumo`),
  INDEX `fk_Consumo_Entrada1_idx` (`idEntrada` ASC),
  CONSTRAINT `fk_Consumo_Entrada1`
    FOREIGN KEY (`idEntrada`)
    REFERENCES `HotelAltosDaFlora`.`Entrada` (`idEntrada`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `HotelAltosDaFlora`.`ItemConsumo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `HotelAltosDaFlora`.`ItemConsumo` (
  `iditemConsumo` INT NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(50) NOT NULL,
  `quantidade` INT NOT NULL,
  `valorUnitario` DECIMAL(10,2) NOT NULL,
  `idCategoria` INT NOT NULL,
  `idconsumo` INT NOT NULL,
  PRIMARY KEY (`iditemConsumo`),
  INDEX `fk_itemConsumo_Categoria1_idx` (`idCategoria` ASC),
  INDEX `fk_ItemConsumo_Consumo1_idx` (`idconsumo` ASC),
  CONSTRAINT `fk_itemConsumo_Categoria1`
    FOREIGN KEY (`idCategoria`)
    REFERENCES `HotelAltosDaFlora`.`Categoria` (`idCategoria`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ItemConsumo_Consumo1`
    FOREIGN KEY (`idconsumo`)
    REFERENCES `HotelAltosDaFlora`.`Consumo` (`idconsumo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `HotelAltosDaFlora`.`Reserva`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `HotelAltosDaFlora`.`Reserva` (
  `idReserva` INT NOT NULL AUTO_INCREMENT,
  `dataChegada` DATETIME NOT NULL,
  `dataSaida` DATETIME NOT NULL,
  `taxaMulta` DECIMAL(10,2) NOT NULL,
  `idTipoAcomodacao` INT NOT NULL,
  `idHospede` INT NOT NULL,
  `idFuncionario` INT NOT NULL,
  `ativo` SMALLINT NOT NULL DEFAULT 1,
  PRIMARY KEY (`idReserva`),
  INDEX `fk_Reserva_tipoAcomodacao1_idx` (`idTipoAcomodacao` ASC),
  INDEX `fk_Reserva_Hospede1_idx` (`idHospede` ASC),
  INDEX `fk_Reserva_Funcionario1_idx` (`idFuncionario` ASC),
  CONSTRAINT `fk_Reserva_tipoAcomodacao1`
    FOREIGN KEY (`idTipoAcomodacao`)
    REFERENCES `HotelAltosDaFlora`.`TipoAcomodacao` (`idtipoAcomodacao`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Reserva_Hospede1`
    FOREIGN KEY (`idHospede`)
    REFERENCES `HotelAltosDaFlora`.`Hospede` (`idHospede`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Reserva_Funcionario1`
    FOREIGN KEY (`idFuncionario`)
    REFERENCES `HotelAltosDaFlora`.`Funcionario` (`idFuncionario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `HotelAltosDaFlora`.`Acompanhante`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `HotelAltosDaFlora`.`Acompanhante` (
  `idAcompanhante` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `idade` INT NOT NULL,
  PRIMARY KEY (`idAcompanhante`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `HotelAltosDaFlora`.`Reserva_Acompanhante`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `HotelAltosDaFlora`.`Reserva_Acompanhante` (
  `idReserva` INT NOT NULL,
  `idAcompanhante` INT NOT NULL,
  PRIMARY KEY (`idReserva`, `idAcompanhante`),
  INDEX `fk_Reserva_has_Acompanhante_Acompanhante1_idx` (`idAcompanhante` ASC),
  INDEX `fk_Reserva_has_Acompanhante_Reserva1_idx` (`idReserva` ASC),
  CONSTRAINT `fk_Reserva_has_Acompanhante_Reserva1`
    FOREIGN KEY (`idReserva`)
    REFERENCES `HotelAltosDaFlora`.`Reserva` (`idReserva`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Reserva_has_Acompanhante_Acompanhante1`
    FOREIGN KEY (`idAcompanhante`)
    REFERENCES `HotelAltosDaFlora`.`Acompanhante` (`idAcompanhante`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `HotelAltosDaFlora`.`Entrada_Acompanhante`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `HotelAltosDaFlora`.`Entrada_Acompanhante` (
  `idAcompanhante` INT NOT NULL,
  `idEntrada` INT NOT NULL,
  PRIMARY KEY (`idAcompanhante`, `idEntrada`),
  INDEX `fk_Acompanhante_has_Entrada_Entrada1_idx` (`idEntrada` ASC),
  INDEX `fk_Acompanhante_has_Entrada_Acompanhante1_idx` (`idAcompanhante` ASC),
  CONSTRAINT `fk_Acompanhante_has_Entrada_Acompanhante1`
    FOREIGN KEY (`idAcompanhante`)
    REFERENCES `HotelAltosDaFlora`.`Acompanhante` (`idAcompanhante`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Acompanhante_has_Entrada_Entrada1`
    FOREIGN KEY (`idEntrada`)
    REFERENCES `HotelAltosDaFlora`.`Entrada` (`idEntrada`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `HotelAltosDaFlora`.`Saida`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `HotelAltosDaFlora`.`Saida` (
  `idSaida` INT NOT NULL AUTO_INCREMENT,
  `data` DATETIME NOT NULL,
  `numeroDiarias` INT NOT NULL,
  `totalDiarias` DECIMAL(10,2) NOT NULL,
  `totalConsumo` DECIMAL(10,2) NOT NULL,
  `idEntrada` INT NOT NULL,
  `tipoPagamento` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`idSaida`),
  INDEX `fk_Saida_Entrada1_idx` (`idEntrada` ASC),
  CONSTRAINT `fk_Saida_Entrada1`
    FOREIGN KEY (`idEntrada`)
    REFERENCES `HotelAltosDaFlora`.`Entrada` (`idEntrada`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
