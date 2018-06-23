ALTER SCHEMA `coletor`  DEFAULT CHARACTER SET utf8  DEFAULT COLLATE utf8_general_ci ;

CREATE TABLE IF NOT EXISTS `coletor`.`Propriedade` (
  `idPropriedade` INT(11) NOT NULL AUTO_INCREMENT,
  `nomePropriedade` VARCHAR(45) NOT NULL,
  `endereço` VARCHAR(255) NOT NULL,
  `bairro` VARCHAR(45) NOT NULL,
  `numero` INT(11) NOT NULL,
  `complemento` VARCHAR(55) NULL DEFAULT NULL,
  `proprietario` VARCHAR(55) NOT NULL,
  `telefone` INT(11) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `numeroVacas` INT(11) NOT NULL,
  `periodicidade` INT(11) NOT NULL,
  `idColeta` INT(11) NOT NULL,
  `idcidade` INT(11) NOT NULL,
  PRIMARY KEY (`idPropriedade`),
  INDEX `fk_Propriedade_Coleta_idx` (`idColeta` ASC),
  INDEX `fk_Propriedade_cidade1_idx` (`idcidade` ASC),
  CONSTRAINT `fk_Propriedade_Coleta`
    FOREIGN KEY (`idColeta`)
    REFERENCES `coletor`.`Coleta` (`idColeta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Propriedade_cidade1`
    FOREIGN KEY (`idcidade`)
    REFERENCES `coletor`.`cidade` (`idcidade`)
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `coletor`.`Coleta` (
  `idColeta` INT(11) NOT NULL AUTO_INCREMENT,
  `qtde` INT(11) NOT NULL,
  `data` DATE NOT NULL,
  PRIMARY KEY (`idColeta`))
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `coletor`.`cidade` (
  `idcidade` INT(11) NOT NULL AUTO_INCREMENT,
  `nomeCidade` VARCHAR(45) NOT NULL,
  `idEstado` INT(11) NOT NULL,
  PRIMARY KEY (`idcidade`),
  INDEX `fk_cidade_Estado1_idx` (`idEstado` ASC),
  CONSTRAINT `fk_cidade_Estado1`
    FOREIGN KEY (`idEstado`)
    REFERENCES `coletor`.`Estado` (`idEstado`)
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `coletor`.`Estado` (
  `idEstado` INT(11) NOT NULL AUTO_INCREMENT,
  `Nome` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`idEstado`))
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `coletor`.`Usuario` (
  `idUsuario` INT(11) NOT NULL,
  `nomeUser` VARCHAR(45) NOT NULL,
  `loginUser` VARCHAR(45) NOT NULL,
  `senhaUser` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`idUsuario`))
DEFAULT CHARACTER SET = utf8;
