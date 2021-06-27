-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema gelinfo1
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema gelinfo1
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `gelinfo1` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_mysql500_ci ;
USE `gelinfo1` ;

-- -----------------------------------------------------
-- Table `gelinfo1`.`tb_usuarios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gelinfo1`.`tb_usuarios` (
  `u_codigo` INT NOT NULL AUTO_INCREMENT,
  `u_login` VARCHAR(20) NOT NULL,
  `u_nome` VARCHAR(50) NOT NULL,
  `u_senha` VARCHAR(8) NOT NULL,
  `u_telefone` INT UNSIGNED NULL DEFAULT NULL,
  `tb_perfil_pf_codigo` INT NOT NULL,
  PRIMARY KEY (`u_codigo`),
  UNIQUE INDEX `u_login_UNIQUE` (`u_login` ASC) VISIBLE,
  INDEX `FK_3ukx39mfah2r8jxoc18stix46` (`tb_perfil_pf_codigo` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_mysql500_ci;


-- -----------------------------------------------------
-- Table `gelinfo1`.`tb_secretarias`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gelinfo1`.`tb_secretarias` (
  `sec_codigo` INT NOT NULL AUTO_INCREMENT,
  `sec_nome` VARCHAR(90) NOT NULL,
  `sec_sigla` VARCHAR(7) NOT NULL,
  PRIMARY KEY (`sec_codigo`))
ENGINE = InnoDB
AUTO_INCREMENT = 32
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_mysql500_ci;


-- -----------------------------------------------------
-- Table `gelinfo1`.`tb_bairros`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gelinfo1`.`tb_bairros` (
  `b_codigo` INT NOT NULL AUTO_INCREMENT,
  `b_endereco` VARCHAR(50) NOT NULL,
  `b_nome` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`b_codigo`))
ENGINE = InnoDB
AUTO_INCREMENT = 20
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_mysql500_ci;


-- -----------------------------------------------------
-- Table `gelinfo1`.`tb_setores`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gelinfo1`.`tb_setores` (
  `st_codigo` INT NOT NULL AUTO_INCREMENT,
  `st_andar` VARCHAR(8) NOT NULL,
  `st_nome` VARCHAR(50) NOT NULL,
  `st_sigla` VARCHAR(10) NOT NULL,
  `tb_bairros_b_codigo` INT NOT NULL,
  `tb_secretarias_sec_codigo` INT NOT NULL,
  PRIMARY KEY (`st_codigo`),
  INDEX `FK_bpd9uo5f4nxj8jldg85qmtiau` (`tb_bairros_b_codigo` ASC) VISIBLE,
  INDEX `FK_27fpij5608arheke0knljqpfd` (`tb_secretarias_sec_codigo` ASC) VISIBLE,
  CONSTRAINT `FK_27fpij5608arheke0knljqpfd`
    FOREIGN KEY (`tb_secretarias_sec_codigo`)
    REFERENCES `gelinfo1`.`tb_secretarias` (`sec_codigo`),
  CONSTRAINT `FK_bpd9uo5f4nxj8jldg85qmtiau`
    FOREIGN KEY (`tb_bairros_b_codigo`)
    REFERENCES `gelinfo1`.`tb_bairros` (`b_codigo`))
ENGINE = InnoDB
AUTO_INCREMENT = 166
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_mysql500_ci;


-- -----------------------------------------------------
-- Table `gelinfo1`.`tb_inventario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gelinfo1`.`tb_inventario` (
  `inv_codigo` INT NOT NULL AUTO_INCREMENT,
  `inv_data` DATETIME NOT NULL,
  `inv_status` VARCHAR(255) NOT NULL,
  `tb_setores_st_codigo` INT NOT NULL,
  `tb_usuarios_u_codigo` INT NOT NULL,
  PRIMARY KEY (`inv_codigo`),
  INDEX `FK_h7qd73tw7hlu5tpbfg4rlaef4` (`tb_setores_st_codigo` ASC) VISIBLE,
  INDEX `FK_co623wpt5my5p0i2urm0pj227` (`tb_usuarios_u_codigo` ASC) VISIBLE,
  CONSTRAINT `FK_co623wpt5my5p0i2urm0pj227`
    FOREIGN KEY (`tb_usuarios_u_codigo`)
    REFERENCES `gelinfo1`.`tb_usuarios` (`u_codigo`),
  CONSTRAINT `FK_h7qd73tw7hlu5tpbfg4rlaef4`
    FOREIGN KEY (`tb_setores_st_codigo`)
    REFERENCES `gelinfo1`.`tb_setores` (`st_codigo`))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_mysql500_ci;


-- -----------------------------------------------------
-- Table `gelinfo1`.`tb_marcas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gelinfo1`.`tb_marcas` (
  `m_codigo` INT NOT NULL AUTO_INCREMENT,
  `m_nome` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`m_codigo`),
  UNIQUE INDEX `m_nome_UNIQUE` (`m_nome` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 10
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_mysql500_ci;


-- -----------------------------------------------------
-- Table `gelinfo1`.`tb_modelos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gelinfo1`.`tb_modelos` (
  `md_codigo` INT NOT NULL AUTO_INCREMENT,
  `md_nome` VARCHAR(50) NOT NULL,
  `tb_marcas_m_codigo` INT NOT NULL,
  PRIMARY KEY (`md_codigo`),
  UNIQUE INDEX `md_nome_UNIQUE` (`md_nome` ASC) VISIBLE,
  INDEX `FK_93hk1i5twekwfbu5j733qujsf` (`tb_marcas_m_codigo` ASC) VISIBLE,
  CONSTRAINT `FK_93hk1i5twekwfbu5j733qujsf`
    FOREIGN KEY (`tb_marcas_m_codigo`)
    REFERENCES `gelinfo1`.`tb_marcas` (`m_codigo`))
ENGINE = InnoDB
AUTO_INCREMENT = 15
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_mysql500_ci;


-- -----------------------------------------------------
-- Table `gelinfo1`.`tb_tipo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gelinfo1`.`tb_tipo` (
  `tp_codigo` INT NOT NULL AUTO_INCREMENT,
  `tp_nome` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`tp_codigo`),
  UNIQUE INDEX `tp_nome_UNIQUE` (`tp_nome` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_mysql500_ci;


-- -----------------------------------------------------
-- Table `gelinfo1`.`tb_equipamentos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gelinfo1`.`tb_equipamentos` (
  `eq_codigo` INT NOT NULL AUTO_INCREMENT,
  `eq_npatrimonio` VARCHAR(25) NOT NULL,
  `eq_nserie` VARCHAR(25) NOT NULL,
  `eq_patrimonio` VARCHAR(25) NOT NULL,
  `tb_modelos_md_codigo` INT NOT NULL,
  `tb_setores_st_codigo` INT NOT NULL,
  `tb_tipo_tp_codigo` INT NOT NULL,
  PRIMARY KEY (`eq_codigo`),
  INDEX `FK_a9qog3magkf0olj3yyo0xtflc` (`tb_modelos_md_codigo` ASC) VISIBLE,
  INDEX `FK_fa5xd0a93yvxd7687y0wlif2u` (`tb_setores_st_codigo` ASC) VISIBLE,
  INDEX `FK_r7qljbqrcc1hgr7q5h6uahkam` (`tb_tipo_tp_codigo` ASC) VISIBLE,
  CONSTRAINT `FK_a9qog3magkf0olj3yyo0xtflc`
    FOREIGN KEY (`tb_modelos_md_codigo`)
    REFERENCES `gelinfo1`.`tb_modelos` (`md_codigo`),
  CONSTRAINT `FK_fa5xd0a93yvxd7687y0wlif2u`
    FOREIGN KEY (`tb_setores_st_codigo`)
    REFERENCES `gelinfo1`.`tb_setores` (`st_codigo`),
  CONSTRAINT `FK_r7qljbqrcc1hgr7q5h6uahkam`
    FOREIGN KEY (`tb_tipo_tp_codigo`)
    REFERENCES `gelinfo1`.`tb_tipo` (`tp_codigo`))
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_mysql500_ci;


-- -----------------------------------------------------
-- Table `gelinfo1`.`equipamento_invetario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gelinfo1`.`equipamento_invetario` (
  `tb_inventario_inv_codigo` INT NOT NULL,
  `tb_equipamentos_eq_codigo` INT NOT NULL,
  PRIMARY KEY (`tb_equipamentos_eq_codigo`, `tb_inventario_inv_codigo`),
  INDEX `FK_cn9as8702y5mj70tsvtwm9mk3` (`tb_inventario_inv_codigo` ASC) VISIBLE,
  CONSTRAINT `FK_cn9as8702y5mj70tsvtwm9mk3`
    FOREIGN KEY (`tb_inventario_inv_codigo`)
    REFERENCES `gelinfo1`.`tb_inventario` (`inv_codigo`),
  CONSTRAINT `FK_oi6clwarpkcbp9swcrkicb7va`
    FOREIGN KEY (`tb_equipamentos_eq_codigo`)
    REFERENCES `gelinfo1`.`tb_equipamentos` (`eq_codigo`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_mysql500_ci;


-- -----------------------------------------------------
-- Table `gelinfo1`.`tb_cpu`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gelinfo1`.`tb_cpu` (
  `cpu_codigo` INT NOT NULL AUTO_INCREMENT,
  `cpu_ip` INT NULL DEFAULT NULL,
  `tb_equipamentos_eq_codigo` INT NOT NULL,
  PRIMARY KEY (`cpu_codigo`),
  INDEX `FK_tohiu91d2oelg022b57iou0p4` (`tb_equipamentos_eq_codigo` ASC) VISIBLE,
  CONSTRAINT `FK_tohiu91d2oelg022b57iou0p4`
    FOREIGN KEY (`tb_equipamentos_eq_codigo`)
    REFERENCES `gelinfo1`.`tb_equipamentos` (`eq_codigo`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_mysql500_ci;


-- -----------------------------------------------------
-- Table `gelinfo1`.`tb_impressoras`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gelinfo1`.`tb_impressoras` (
  `imp_codigo` INT NOT NULL AUTO_INCREMENT,
  `imp_contador` BIGINT NULL DEFAULT NULL,
  `imp_ip` INT NULL DEFAULT NULL,
  `tb_equipamentos_eq_codigo` INT NOT NULL,
  PRIMARY KEY (`imp_codigo`),
  INDEX `FK_s2fg4pn19899we0h2njrwb1im` (`tb_equipamentos_eq_codigo` ASC) VISIBLE,
  CONSTRAINT `FK_s2fg4pn19899we0h2njrwb1im`
    FOREIGN KEY (`tb_equipamentos_eq_codigo`)
    REFERENCES `gelinfo1`.`tb_equipamentos` (`eq_codigo`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_mysql500_ci;


-- -----------------------------------------------------
-- Table `gelinfo1`.`tb_perfil`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gelinfo1`.`tb_perfil` (
  `pf_codigo` INT NOT NULL AUTO_INCREMENT,
  `pf_funcao` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`pf_codigo`))
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_mysql500_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
