-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema cupcake
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema cupcake
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `cupcake` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `cupcake` ;

-- -----------------------------------------------------
-- Table `cupcake`.`bruger`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cupcake`.`bruger` (
  `brugernavn` VARCHAR(45) NOT NULL,
  `kodeord` INT NOT NULL,
  `rolle` VARCHAR(45) NOT NULL,
  `saldo` INT NOT NULL DEFAULT '0',
  PRIMARY KEY (`brugernavn`),
  UNIQUE INDEX `brugernavn_UNIQUE` (`brugernavn` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `cupcake`.`bund`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cupcake`.`bund` (
  `navn` VARCHAR(45) NOT NULL,
  `pris` INT NOT NULL,
  PRIMARY KEY (`navn`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `cupcake`.`ordre`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cupcake`.`ordre` (
  `idordre` INT NOT NULL AUTO_INCREMENT,
  `bruger` VARCHAR(45) NOT NULL,
  `dato` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`idordre`),
  UNIQUE INDEX `idordre_UNIQUE` (`idordre` ASC) VISIBLE,
  INDEX `fk_ordre_bruger1_idx` (`bruger` ASC) VISIBLE,
  CONSTRAINT `fk_ordre_bruger1`
    FOREIGN KEY (`bruger`)
    REFERENCES `cupcake`.`bruger` (`brugernavn`))
ENGINE = InnoDB
AUTO_INCREMENT = 122
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `cupcake`.`top`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cupcake`.`top` (
  `navn` VARCHAR(45) NOT NULL,
  `pris` INT NOT NULL,
  PRIMARY KEY (`navn`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `cupcake`.`produkt`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cupcake`.`produkt` (
  `produktid` INT NOT NULL AUTO_INCREMENT,
  `top` VARCHAR(45) NOT NULL,
  `bund` VARCHAR(45) NOT NULL,
  `pris` INT NOT NULL,
  `ordreid` INT NOT NULL,
  `antal` INT NOT NULL,
  PRIMARY KEY (`produktid`),
  UNIQUE INDEX `produktid_UNIQUE` (`produktid` ASC) VISIBLE,
  INDEX `fk_produkt_top_idx` (`top` ASC) VISIBLE,
  INDEX `fk_produkt_bund1_idx` (`bund` ASC) VISIBLE,
  INDEX `fk_produkt_ordre1_idx` (`ordreid` ASC) VISIBLE,
  CONSTRAINT `fk_produkt_bund1`
    FOREIGN KEY (`bund`)
    REFERENCES `cupcake`.`bund` (`navn`),
  CONSTRAINT `fk_produkt_ordre1`
    FOREIGN KEY (`ordreid`)
    REFERENCES `cupcake`.`ordre` (`idordre`),
  CONSTRAINT `fk_produkt_top`
    FOREIGN KEY (`top`)
    REFERENCES `cupcake`.`top` (`navn`))
ENGINE = InnoDB
AUTO_INCREMENT = 69
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

