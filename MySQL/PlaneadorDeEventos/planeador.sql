-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema planeador
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema planeador
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `planeador` DEFAULT CHARACTER SET utf8 ;
USE `planeador` ;

-- -----------------------------------------------------
-- Table `planeador`.`usuarios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `planeador`.`usuarios` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL,
  `direccion` VARCHAR(60) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `planeador`.`eventos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `planeador`.`eventos` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `titulo` VARCHAR(45) NULL,
  `descripcion` TEXT NULL,
  `ubicacion` VARCHAR(60) NULL,
  `hora_inicio` DATETIME NULL,
  `hora_final` DATETIME NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `planeador`.`usuario_eventos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `planeador`.`usuario_eventos` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `usuario_id` INT NOT NULL,
  `evento_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_usuario_eventos_usuarios_idx` (`usuario_id` ASC) VISIBLE,
  INDEX `fk_usuario_eventos_eventos1_idx` (`evento_id` ASC) VISIBLE,
  CONSTRAINT `fk_usuario_eventos_usuarios`
    FOREIGN KEY (`usuario_id`)
    REFERENCES `planeador`.`usuarios` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_usuario_eventos_eventos1`
    FOREIGN KEY (`evento_id`)
    REFERENCES `planeador`.`eventos` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
