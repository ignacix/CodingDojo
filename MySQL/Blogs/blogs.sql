-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema blogs
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `blogs` ;

-- -----------------------------------------------------
-- Schema blogs
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `blogs` DEFAULT CHARACTER SET utf8 ;
USE `blogs` ;

-- -----------------------------------------------------
-- Table `blogs`.`users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `blogs`.`users` ;

CREATE TABLE IF NOT EXISTS `blogs`.`users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(255) NULL,
  `last_name` VARCHAR(255) NULL,
  `email` VARCHAR(255) NULL,
  `password` VARCHAR(255) NULL,
  `created_at` DATETIME NULL,
  `updated_at` DATETIME NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `blogs`.`blogs`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `blogs`.`blogs` ;

CREATE TABLE IF NOT EXISTS `blogs`.`blogs` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(60) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `blogs`.`admins`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `blogs`.`admins` ;

CREATE TABLE IF NOT EXISTS `blogs`.`admins` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `created_at` DATETIME NULL,
  `aupdated_at` DATETIME NULL,
  `blog_id` INT NOT NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_admins_users_idx` (`user_id` ASC) VISIBLE,
  INDEX `fk_admins_blogs1_idx` (`blog_id` ASC) VISIBLE,
  CONSTRAINT `fk_admins_users`
    FOREIGN KEY (`user_id`)
    REFERENCES `blogs`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_admins_blogs1`
    FOREIGN KEY (`blog_id`)
    REFERENCES `blogs`.`blogs` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `blogs`.`posts`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `blogs`.`posts` ;

CREATE TABLE IF NOT EXISTS `blogs`.`posts` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(60) NULL,
  `content` TEXT NULL,
  `created_at` DATETIME NULL,
  `updated_at` DATETIME NULL,
  `blog_id` INT NOT NULL,
  `admin_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_posts_blogs1_idx` (`blog_id` ASC) VISIBLE,
  INDEX `fk_posts_admins1_idx` (`admin_id` ASC) VISIBLE,
  CONSTRAINT `fk_posts_blogs1`
    FOREIGN KEY (`blog_id`)
    REFERENCES `blogs`.`blogs` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_posts_admins1`
    FOREIGN KEY (`admin_id`)
    REFERENCES `blogs`.`admins` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `blogs`.`comments`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `blogs`.`comments` ;

CREATE TABLE IF NOT EXISTS `blogs`.`comments` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `content` VARCHAR(255) NULL,
  `created_at` DATETIME NULL,
  `updated_at` DATETIME NULL,
  `post_id` INT NOT NULL,
  `user_id` INT NOT NULL,
  INDEX `fk_table1_posts1_idx` (`post_id` ASC) VISIBLE,
  PRIMARY KEY (`id`),
  INDEX `fk_comments_users1_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_table1_posts1`
    FOREIGN KEY (`post_id`)
    REFERENCES `blogs`.`posts` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_comments_users1`
    FOREIGN KEY (`user_id`)
    REFERENCES `blogs`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `blogs`.`files`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `blogs`.`files` ;

CREATE TABLE IF NOT EXISTS `blogs`.`files` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `path` VARCHAR(45) NULL,
  `created_at` DATETIME NULL,
  `updated_at` DATETIME NULL,
  `post_id` INT NOT NULL,
  `admin_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_files_posts1_idx` (`post_id` ASC) VISIBLE,
  INDEX `fk_files_admins1_idx` (`admin_id` ASC) VISIBLE,
  CONSTRAINT `fk_files_posts1`
    FOREIGN KEY (`post_id`)
    REFERENCES `blogs`.`posts` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_files_admins1`
    FOREIGN KEY (`admin_id`)
    REFERENCES `blogs`.`admins` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `blogs`.`views`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `blogs`.`views` ;

CREATE TABLE IF NOT EXISTS `blogs`.`views` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `ip_addres` VARCHAR(16) NULL,
  `time_view` DECIMAL NULL,
  `created_at` DATETIME NULL,
  `updated_at` DATETIME NULL,
  `user_id` INT NOT NULL,
  `blog_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_views_users1_idx` (`user_id` ASC) VISIBLE,
  INDEX `fk_views_blogs1_idx` (`blog_id` ASC) VISIBLE,
  CONSTRAINT `fk_views_users1`
    FOREIGN KEY (`user_id`)
    REFERENCES `blogs`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_views_blogs1`
    FOREIGN KEY (`blog_id`)
    REFERENCES `blogs`.`blogs` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
