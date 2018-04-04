ALTER TABLE `gestion_factoria`.`thge017_requerim`
ADD COLUMN `CD_METODOLOGIA` INT(4) NULL AFTER `ST_REQUERIMIENTO`;

ALTER TABLE `gestion_factoria`.`thge017_requerim`
ADD COLUMN `CD_SDA` VARCHAR(45) NULL AFTER `CD_METODOLOGIA`;

ALTER TABLE `gestion_factoria`.`thge026_modif`
ADD COLUMN `CT_HORAS_EMP` DOUBLE NULL AFTER `CD_RESP_RESOL`;

ALTER TABLE `gestion_factoria`.`thge026_modif`
ADD COLUMN `CT_HORAS_INIC` DOUBLE NULL AFTER `CT_HORAS_EMP`;

ALTER TABLE `gestion_factoria`.`thge026_modif`
ADD COLUMN `TX_MES_FACT` DOUBLE NULL AFTER `CT_HORAS_INIC`;

ALTER TABLE `gestion_factoria`.`thge026_modif`
ADD COLUMN `NU_ANO_FACT` INT NULL AFTER `TX_MES_FACT`;