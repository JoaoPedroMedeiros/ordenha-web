DEFAULT CHARACTER SET utf8  DEFAULT COLLATE utf8_general_ci ;

CREATE TABLE IF NOT EXISTS `produtor`.`Vaca` (
  `idVaca` INT(11) NOT NULL AUTO_INCREMENT,
  `nomeVaca` VARCHAR(45) NOT NULL,
  `pesoVaca` FLOAT(11) NOT NULL,
  `obsVaca` VARCHAR(200) NULL DEFAULT NULL,
  `idRaca` INT(11) NOT NULL,
  PRIMARY KEY (`idVaca`),
  INDEX `fk_Vaca_Raca_idx` (`idRaca` ASC),
  CONSTRAINT `fk_Vaca_Raca`
    FOREIGN KEY (`idRaca`)
    REFERENCES `produtor`.`Raca` (`idRaca`)
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `produtor`.`Raca` (
  `idRaca` INT(11) NOT NULL AUTO_INCREMENT,
  `descRaca` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idRaca`))
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `produtor`.`Ordenha` (
  `idOrdenha` INT(11) NOT NULL AUTO_INCREMENT,
  `vacasOrdenhadas` INT(11) NOT NULL,
  `data` DATETIME NOT NULL,
  PRIMARY KEY (`idOrdenha`))
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `produtor`.`Usuario` (
  `idUsuario` INT(11) NOT NULL AUTO_INCREMENT,
  `loginUser` VARCHAR(45) NOT NULL,
  `nomeUser` VARCHAR(45) NOT NULL,
  `senhaUser` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`idUsuario`))
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `produtor`.`VacaOrdenhada` (
  `idVaca` INT(11) NOT NULL,
  `idOrdenha` INT(11) NOT NULL,
  PRIMARY KEY (`idVaca`, `idOrdenha`),
  INDEX `fk_Vaca_has_Ordenha_Ordenha1_idx` (`idOrdenha` ASC),
  INDEX `fk_Vaca_has_Ordenha_Vaca1_idx` (`idVaca` ASC),
  CONSTRAINT `fk_Vaca_has_Ordenha_Vaca1`
    FOREIGN KEY (`idVaca`)
    REFERENCES `produtor`.`Vaca` (`idVaca`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Vaca_has_Ordenha_Ordenha1`
    FOREIGN KEY (`idOrdenha`)
    REFERENCES `produtor`.`Ordenha` (`idOrdenha`)
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `produtor`.`MovimentoOrdenha` (
  `idMovimentoOrdenha` INT(11) NOT NULL AUTO_INCREMENT,
  `idOrdenha` INT(11) NOT NULL,
  PRIMARY KEY (`idMovimentoOrdenha`),
  INDEX `fk_MovimentoOrdenha_Ordenha1_idx` (`idOrdenha` ASC),
  CONSTRAINT `fk_MovimentoOrdenha_Ordenha1`
    FOREIGN KEY (`idOrdenha`)
    REFERENCES `produtor`.`Ordenha` (`idOrdenha`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `produtor`.`MovimentoColeta` (
  `idMovimentoColeta` INT(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`idMovimentoColeta`))
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `produtor`.`MovimentoTanque` (
  `data` DATE NOT NULL,
  `litragemAnterior` DOUBLE NOT NULL,
  `litragemAtual` DOUBLE NOT NULL,
  `qtde` DOUBLE NOT NULL,
  `idOrdenha` INT(11) NOT NULL,
  `idMovimentoColeta` INT(11) NOT NULL,
  INDEX `fk_MovimentoTanque_Ordenha1_idx` (`idOrdenha` ASC),
  INDEX `fk_MovimentoTanque_MovimentoColeta1_idx` (`idMovimentoColeta` ASC),
  CONSTRAINT `fk_MovimentoTanque_Ordenha1`
    FOREIGN KEY (`idOrdenha`)
    REFERENCES `produtor`.`Ordenha` (`idOrdenha`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_MovimentoTanque_MovimentoColeta1`
    FOREIGN KEY (`idMovimentoColeta`)
    REFERENCES `produtor`.`MovimentoColeta` (`idMovimentoColeta`)
DEFAULT CHARACTER SET = utf8;