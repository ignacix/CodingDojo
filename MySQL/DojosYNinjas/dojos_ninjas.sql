-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema dojos_ninjas
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `dojos_ninjas` ;

-- -----------------------------------------------------
-- Schema dojos_ninjas
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `dojos_ninjas` DEFAULT CHARACTER SET utf8 ;
USE `dojos_ninjas` ;

-- -----------------------------------------------------
-- Table `dojos_ninjas`.`dojos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dojos_ninjas`.`dojos` ;

CREATE TABLE IF NOT EXISTS `dojos_ninjas`.`dojos` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `location` VARCHAR(60) NULL,
  `created_at` DATETIME NULL DEFAULT NOW(),
  `updated_at` DATETIME NULL DEFAULT NOW(),
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dojos_ninjas`.`ninjas`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dojos_ninjas`.`ninjas` ;

CREATE TABLE IF NOT EXISTS `dojos_ninjas`.`ninjas` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `skill` VARCHAR(60) NULL,
  `created_at` DATETIME NULL DEFAULT NOW(),
  `updated_at` DATETIME NULL DEFAULT NOW(),
  `dojo_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_ninjas_dojos_idx` (`dojo_id` ASC) VISIBLE,
  CONSTRAINT `fk_ninjas_dojos`
    FOREIGN KEY (`dojo_id`)
    REFERENCES `dojos_ninjas`.`dojos` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
