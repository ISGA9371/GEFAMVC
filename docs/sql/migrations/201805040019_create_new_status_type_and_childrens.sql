-- ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
-- Begin script. ****** APPLY ******
-- ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
-- DESCRIPTION: Create a new status type.
--              Create status related to created status type recently.
-- ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

-- Specify the schema to work on.
USE `GESTION_FACTORIA`;

-- Create new Status type 'EDO_PAGO' ( id = 18 )
INSERT INTO `GESTION_FACTORIA`.`thge008_tipo_edo` VALUES 
(18, 'EDO_PAGO');

-- Create the status belongs to 'EDO_PAGO'
INSERT INTO `GESTION_FACTORIA`.`thge005_estado` VALUES
(59, 'SIN PARTIDA', 18),
(60, 'POR ENVIAR A IMPLANT', 18),
(61, 'EN CAPTURA POR IMPLANT', 18),
(62, 'PENDIENTE DE AUTORIZACIÓN', 18),
(63, 'EN FINANZAS', 18),
(64, 'EN COMPRAS', 18),
(65, 'PENDIENTE DE HEA', 18),
(66, 'PENDIENTE DE ACEPTACIÓN', 18),
(67, 'PAGADO GPS', 18),
(68, 'FACTURA INGRESADA', 18),
(69, 'DEPÓSITO A PROVEEDOR', 18);

-- ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
-- End script. ****** APPLY ******
-- ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++