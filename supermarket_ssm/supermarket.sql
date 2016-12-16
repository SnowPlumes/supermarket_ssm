-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema supermarket
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema supermarket
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `supermarket` DEFAULT CHARACTER SET utf8 ;
USE `supermarket` ;

-- -----------------------------------------------------
-- Table `supermarket`.`customer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `supermarket`.`customer` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(20) NOT NULL,
  `nickname` VARCHAR(20) NULL DEFAULT NULL,
  `sex` VARCHAR(2) NOT NULL DEFAULT 'ÄÐ',
  `email` VARCHAR(20) NULL DEFAULT NULL,
  `phone` VARCHAR(11) NULL DEFAULT NULL,
  `isdelete` VARCHAR(1) NOT NULL DEFAULT 'N',
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `supermarket`.`customer_login`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `supermarket`.`customer_login` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `password` VARCHAR(45) NOT NULL,
  `customer_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`, `customer_id`),
  INDEX `fk_customer_login_customer1_idx` (`customer_id` ASC),
  CONSTRAINT `fk_customer_login_customer1`
    FOREIGN KEY (`customer_id`)
    REFERENCES `supermarket`.`customer` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `supermarket`.`employee_limit`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `supermarket`.`employee_limit` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `level` VARCHAR(1) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `supermarket`.`employee`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `supermarket`.`employee` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `eID` VARCHAR(45) NOT NULL,
  `name` VARCHAR(20) NOT NULL,
  `phone` VARCHAR(11) NOT NULL,
  `email` VARCHAR(20) CHARACTER SET 'big5' NOT NULL,
  `employee_limit_id` INT(11) NOT NULL,
  `password` VARCHAR(45) NOT NULL DEFAULT '123456',
  `isdelete` VARCHAR(1) NOT NULL DEFAULT 'N',
  PRIMARY KEY (`id`),
  INDEX `fk_employee_employee_limit1_idx` (`employee_limit_id` ASC),
  UNIQUE INDEX `eID_UNIQUE` (`eID` ASC),
  CONSTRAINT `fk_employee_employee_limit1`
    FOREIGN KEY (`employee_limit_id`)
    REFERENCES `supermarket`.`employee_limit` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `supermarket`.`getadress`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `supermarket`.`getadress` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `adress` VARCHAR(45) NOT NULL,
  `customer_id` INT(11) NOT NULL,
  `getname` VARCHAR(45) NOT NULL,
  `getphone` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_adress_customer1_idx` (`customer_id` ASC),
  CONSTRAINT `fk_adress_customer1`
    FOREIGN KEY (`customer_id`)
    REFERENCES `supermarket`.`customer` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `supermarket`.`sub_type`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `supermarket`.`sub_type` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `supermarket`.`goods_type`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `supermarket`.`goods_type` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(20) NOT NULL,
  `sub_type_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_goods_type_sub_type1_idx` (`sub_type_id` ASC),
  CONSTRAINT `fk_goods_type_sub_type1`
    FOREIGN KEY (`sub_type_id`)
    REFERENCES `supermarket`.`sub_type` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `supermarket`.`goods`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `supermarket`.`goods` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(20) NOT NULL,
  `url` VARCHAR(45) NOT NULL,
  `price` DOUBLE NOT NULL,
  `discount` DOUBLE NULL DEFAULT NULL,
  `create_date` DATE NOT NULL,
  `expiry_date` INT(11) NULL DEFAULT NULL,
  `size` VARCHAR(45) NOT NULL,
  `producer` VARCHAR(20) NULL DEFAULT NULL,
  `goods_type_id` INT(11) NOT NULL,
  `desc` VARCHAR(45) NOT NULL,
  `isdelete` VARCHAR(1) NOT NULL DEFAULT 'N',
  PRIMARY KEY (`id`),
  INDEX `fk_goods_goods_type1_idx` (`goods_type_id` ASC),
  CONSTRAINT `fk_goods_goods_type1`
    FOREIGN KEY (`goods_type_id`)
    REFERENCES `supermarket`.`goods_type` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `supermarket`.`goods_sum`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `supermarket`.`goods_sum` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `sum` INT(11) NOT NULL,
  `goods_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_goods_sum_goods1_idx` (`goods_id` ASC),
  CONSTRAINT `fk_goods_sum_goods1`
    FOREIGN KEY (`goods_id`)
    REFERENCES `supermarket`.`goods` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `supermarket`.`order_status`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `supermarket`.`order_status` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `status` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `supermarket`.`order`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `supermarket`.`order` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `order_num` VARCHAR(20) NOT NULL,
  `order_status_id` INT(11) NOT NULL,
  `customer_id` INT(11) NOT NULL,
  `isdelete` VARCHAR(45) NOT NULL DEFAULT 'N',
  PRIMARY KEY (`id`),
  INDEX `fk_order_order_status1_idx` (`order_status_id` ASC),
  INDEX `fk_order_customer1_idx` (`customer_id` ASC),
  CONSTRAINT `fk_order_customer1`
    FOREIGN KEY (`customer_id`)
    REFERENCES `supermarket`.`customer` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_order_order_status1`
    FOREIGN KEY (`order_status_id`)
    REFERENCES `supermarket`.`order_status` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `supermarket`.`order_items`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `supermarket`.`order_items` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `sum` VARCHAR(45) NULL DEFAULT NULL,
  `goods_id` INT(11) NOT NULL,
  `order_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_order_items_goods1_idx` (`goods_id` ASC),
  INDEX `fk_order_items_order1_idx` (`order_id` ASC),
  CONSTRAINT `fk_order_items_goods1`
    FOREIGN KEY (`goods_id`)
    REFERENCES `supermarket`.`goods` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_order_items_order1`
    FOREIGN KEY (`order_id`)
    REFERENCES `supermarket`.`order` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
