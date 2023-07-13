-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema libros
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `libros` ;

-- -----------------------------------------------------
-- Schema libros
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `libros` DEFAULT CHARACTER SET utf8 ;
USE `libros` ;

-- -----------------------------------------------------
-- Table `libros`.`usuarios`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `libros`.`usuarios` ;

CREATE TABLE IF NOT EXISTS `libros`.`usuarios` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `created_at` DATETIME NULL DEFAULT NOW(),
  `update_at` DATETIME NULL DEFAULT NOW(),
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `libros`.`autores`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `libros`.`autores` ;

CREATE TABLE IF NOT EXISTS `libros`.`autores` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NULL,
  `last_name` VARCHAR(45) NULL,
  `created_at` DATETIME NULL DEFAULT NOW(),
  `update_at` DATETIME NULL DEFAULT NOW(),
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `libros`.`libros`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `libros`.`libros` ;

CREATE TABLE IF NOT EXISTS `libros`.`libros` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `titulo` VARCHAR(45) NULL,
  `created_at` DATETIME NULL DEFAULT NOW(),
  `update_at` DATETIME NULL DEFAULT NOW(),
  `autor_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_libros_autores1_idx` (`autor_id` ASC) VISIBLE,
  CONSTRAINT `fk_libros_autores1`
    FOREIGN KEY (`autor_id`)
    REFERENCES `libros`.`autores` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `libros`.`libros_favoritos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `libros`.`libros_favoritos` ;

CREATE TABLE IF NOT EXISTS `libros`.`libros_favoritos` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `usuario_id` INT NOT NULL,
  `libro_id` INT NOT NULL,
  `created_at` DATETIME NULL,
  `update_at` DATETIME NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_libros_favoritos_usuarios_idx` (`usuario_id` ASC) VISIBLE,
  INDEX `fk_libros_favoritos_libros1_idx` (`libro_id` ASC) VISIBLE,
  CONSTRAINT `fk_libros_favoritos_usuarios`
    FOREIGN KEY (`usuario_id`)
    REFERENCES `libros`.`usuarios` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_libros_favoritos_libros1`
    FOREIGN KEY (`libro_id`)
    REFERENCES `libros`.`libros` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
