SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema hotelaltosdaflora
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `hotelaltosdaflora`;
CREATE SCHEMA IF NOT EXISTS `hotelaltosdaflora` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `hotelaltosdaflora` ;

-- -----------------------------------------------------
-- Table `hotelaltosdaflora`.`Contato`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hotelaltosdaflora`.`contato` (
  `idContato` INT NOT NULL AUTO_INCREMENT,
  `telResidencial` VARCHAR(13) NOT NULL,
  `celular` VARCHAR(13) NOT NULL,
  `telComercial` VARCHAR(13) NOT NULL,
  `email` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`idContato`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hotelaltosdaflora`.`Endereco`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hotelaltosdaflora`.`endereco` (
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
-- Table `hotelaltosdaflora`.`Hospede`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hotelaltosdaflora`.`hospede` (
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
    REFERENCES `hotelaltosdaflora`.`contato` (`idContato`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Hospede_Endereco1`
    FOREIGN KEY (`idEndereco`)
    REFERENCES `hotelaltosdaflora`.`endereco` (`idEndereco`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hotelaltosdaflora`.`Categoria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hotelaltosdaflora`.`categoria` (
  `idCategoria` INT NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(45) NOT NULL,
  `ativo` SMALLINT NOT NULL DEFAULT 1,
  PRIMARY KEY (`idCategoria`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hotelaltosdaflora`.`TipoAcomodacao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hotelaltosdaflora`.`tipoAcomodacao` (
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
-- Table `hotelaltosdaflora`.`Acomodacao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hotelaltosdaflora`.`acomodacao` (
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
    REFERENCES `hotelaltosdaflora`.`tipoAcomodacao` (`idtipoAcomodacao`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hotelaltosdaflora`.`Funcionario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hotelaltosdaflora`.`funcionario` (
  `idFuncionario` INT NOT NULL AUTO_INCREMENT,
  `nomeAcesso` VARCHAR(45) NOT NULL,
  `senhaAcesso` VARCHAR(70) NOT NULL,
  `nivelAcesso` SMALLINT NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `ativo` SMALLINT NOT NULL DEFAULT 1,
  PRIMARY KEY (`idFuncionario`),
  UNIQUE INDEX `nomeAcesso_UNIQUE` (`nomeAcesso` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hotelaltosdaflora`.`Entrada`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hotelaltosdaflora`.`entrada` (
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
    REFERENCES `hotelaltosdaflora`.`acomodacao` (`idacomodacao`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Entrada_Hospede1`
    FOREIGN KEY (`idHospede`)
    REFERENCES `hotelaltosdaflora`.`hospede` (`idHospede`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Entrada_Funcionario1`
    FOREIGN KEY (`idFuncionario`)
    REFERENCES `hotelaltosdaflora`.`funcionario` (`idFuncionario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hotelaltosdaflora`.`consumo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hotelaltosdaflora`.`consumo` (
  `idconsumo` INT NOT NULL AUTO_INCREMENT,
  `data` DATE NOT NULL,
  `valor` DECIMAL(10,2) NOT NULL,
  `idEntrada` INT NOT NULL,
  `ativo` SMALLINT NOT NULL DEFAULT 1,
  PRIMARY KEY (`idconsumo`),
  INDEX `fk_consumo_Entrada1_idx` (`idEntrada` ASC),
  CONSTRAINT `fk_consumo_Entrada1`
    FOREIGN KEY (`idEntrada`)
    REFERENCES `hotelaltosdaflora`.`entrada` (`idEntrada`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hotelaltosdaflora`.`Itemconsumo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hotelaltosdaflora`.`itemconsumo` (
  `iditemconsumo` INT NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(50) NOT NULL,
  `quantidade` INT NOT NULL,
  `valorUnitario` DECIMAL(10,2) NOT NULL,
  `idCategoria` INT NOT NULL,
  `idconsumo` INT NOT NULL,
  PRIMARY KEY (`iditemconsumo`),
  INDEX `fk_itemconsumo_Categoria1_idx` (`idCategoria` ASC),
  INDEX `fk_Itemconsumo_consumo1_idx` (`idconsumo` ASC),
  CONSTRAINT `fk_itemconsumo_Categoria1`
    FOREIGN KEY (`idCategoria`)
    REFERENCES `hotelaltosdaflora`.`categoria` (`idCategoria`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Itemconsumo_consumo1`
    FOREIGN KEY (`idconsumo`)
    REFERENCES `hotelaltosdaflora`.`consumo` (`idconsumo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hotelaltosdaflora`.`Reserva`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hotelaltosdaflora`.`reserva` (
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
    REFERENCES `hotelaltosdaflora`.`tipoAcomodacao` (`idtipoAcomodacao`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Reserva_Hospede1`
    FOREIGN KEY (`idHospede`)
    REFERENCES `hotelaltosdaflora`.`hospede` (`idHospede`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Reserva_Funcionario1`
    FOREIGN KEY (`idFuncionario`)
    REFERENCES `hotelaltosdaflora`.`funcionario` (`idFuncionario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hotelaltosdaflora`.`Acompanhante`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hotelaltosdaflora`.`acompanhante` (
  `idAcompanhante` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `idade` INT NOT NULL,
  PRIMARY KEY (`idAcompanhante`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hotelaltosdaflora`.`Reserva_Acompanhante`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hotelaltosdaflora`.`reserva_acompanhante` (
  `idReserva` INT NOT NULL,
  `idAcompanhante` INT NOT NULL,
  PRIMARY KEY (`idReserva`, `idAcompanhante`),
  INDEX `fk_Reserva_has_Acompanhante_Acompanhante1_idx` (`idAcompanhante` ASC),
  INDEX `fk_Reserva_has_Acompanhante_Reserva1_idx` (`idReserva` ASC),
  CONSTRAINT `fk_Reserva_has_Acompanhante_Reserva1`
    FOREIGN KEY (`idReserva`)
    REFERENCES `hotelaltosdaflora`.`reserva` (`idReserva`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Reserva_has_Acompanhante_Acompanhante1`
    FOREIGN KEY (`idAcompanhante`)
    REFERENCES `hotelaltosdaflora`.`acompanhante` (`idAcompanhante`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hotelaltosdaflora`.`Entrada_Acompanhante`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hotelaltosdaflora`.`entrada_acompanhante` (
  `idAcompanhante` INT NOT NULL,
  `idEntrada` INT NOT NULL,
  PRIMARY KEY (`idAcompanhante`, `idEntrada`),
  INDEX `fk_Acompanhante_has_Entrada_Entrada1_idx` (`idEntrada` ASC),
  INDEX `fk_Acompanhante_has_Entrada_Acompanhante1_idx` (`idAcompanhante` ASC),
  CONSTRAINT `fk_Acompanhante_has_Entrada_Acompanhante1`
    FOREIGN KEY (`idAcompanhante`)
    REFERENCES `hotelaltosdaflora`.`Acompanhante` (`idAcompanhante`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Acompanhante_has_Entrada_Entrada1`
    FOREIGN KEY (`idEntrada`)
    REFERENCES `hotelaltosdaflora`.`entrada` (`idEntrada`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hotelaltosdaflora`.`Saida`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hotelaltosdaflora`.`saida` (
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
    REFERENCES `hotelaltosdaflora`.`entrada` (`idEntrada`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

INSERT INTO `hotelaltosdaflora`.`funcionario`
(`nomeAcesso`,
`senhaAcesso`,
`nivelAcesso`,
`nome`,
`ativo`)
VALUES
('root', '03AC674216F3E15C761EE1A5E255F067953623C8B388B4459E13F978D7C846F4', 0, 'Administrador', 1);
