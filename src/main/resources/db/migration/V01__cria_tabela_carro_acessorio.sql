-- -----------------------------------------------------
-- Table `locadora`.`acessorio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `locadora`.`acessorio` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `locadora`.`carro`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `locadora`.`carro` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `cor` VARCHAR(255) NOT NULL,
  `marca` VARCHAR(255) NOT NULL,
  `modelo` VARCHAR(255) NOT NULL,
  `placa` VARCHAR(255) NOT NULL,
  `valorDiaria` DOUBLE NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `locadora`.`carro_acessorio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `locadora`.`carro_acessorio` (
  `carro_id` BIGINT(20) NOT NULL,
  `acessorio_id` BIGINT(20) NOT NULL,
  INDEX `FK_acessorio_id` (`acessorio_id` ASC),
  INDEX `FK_carro_id` (`carro_id` ASC),
  CONSTRAINT `FK_carro_id`
    FOREIGN KEY (`carro_id`)
    REFERENCES `locadora`.`carro` (`id`),
  CONSTRAINT `FK_acessorio_id`
    FOREIGN KEY (`acessorio_id`)
    REFERENCES `locadora`.`acessorio` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;
