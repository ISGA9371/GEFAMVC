INSERT INTO `gestion_factoria`.`thge030_area`
VALUES
(1, 'FABRICA DE PRUEBAS'),
(2, 'FABRICA DE SOFTWARE');

INSERT INTO `thge004_tipo_nivel`
VALUES
(1,'DIRECCIÓN'),
(2,'SUBDIRECCIÓN'),
(3,'GERENCIA');

INSERT INTO `thge008_tipo_edo`
VALUES
(1,'EDO_USUARIO'),
(2,'EDO_MODIFICACION'),
(3,'EDO_TIPIFICACION'),
(4,'EDO_DUDA'),
(5,'EDO_INCIDENCIA'),
(6,'EDO_TIPOLOGIA'),
(7,'EDO_REQUERIMIENTO'),
(8,'EDO_COMPONENTE'),
(9,'EDO_EMPRESA'),
(10,'EDO_PEP'),
(11,'EDO_DYD'),
(12,'EDO_CONTRATO'),
(13,'EDO_PEP_FACT'),
(14,'EDO_FACT_HRS_PROY'),
(15,'EDO_SEG_REQ'),
(16,'EDO_TARIFA'),
(17,'EDO_RECURSO'),
(18, 'EDO_PAGO'),
(19, 'EDO_SOLIC_PEP'),
(20, 'EDO_RESP_PEP');

INSERT INTO `thge013_pi`
VALUES
(1,'PI1'),
(2,'PI2'),
(3,'PI3'),
(4,'PI4'),
(5,'PI5'),
(6,'PI6'),
(7,'PI7'),
(8,'PI8'),
(9,'PI9'),
(10,'PI10'),
(11,'PI11'),
(12,'PI12');

INSERT INTO `thge015_prioridad`
VALUES
(1,'BAJA'),
(2,'MEDIA'),
(3,'ALTA'),
(4,'BLOQUEANTE');

INSERT INTO `thge016_perf_usu`
VALUES
(1,'GESTORIA FSW'),
(2,'GESTORIA PBAS'),
(3,'PRESUPUESTO'),
(4,'ADMIN'),
(5,'INFILTRADO FSW'),
(6,'INFILTRADO PBAS'),
(7,'DYD'),
(8,'USUARIO FSW'),
(9,'USUARIO PBAS'),
(10,'OPERATIVO FABRICA'),
(11,'OPERATIVO PRESUPUESTO');

INSERT INTO `thge019_origen`
VALUES
(1,'ARQUITECTURA/ESTANDARES GENERALES'),
(2,'DYD PROYECTO PROPIO'),
(3,'DYD PROYECTO OTRA TECNOLOGIA/AREA'),
(4,'BP/NEGOCIO');

INSERT INTO `thge028_tipo_duda`
VALUES
(1,'CONFIRMACIÓN PROCESOS'),
(2,'ESPECIFICACIONES INCOMPLETAS'),
(3,'FALTAN CAMPOS EN OBJETOS'),
(4,'FALTAN CAMPOS ENTRADA - SALIDA'),
(5,'FORMATO DE CAMPOS INCOHERENTE'),
(7,'INCONSISTENCIA DE DATOS'),
(8,'NO ACCESO A BBDD POR CLAVE'),
(9,'NO ESPECIFICA FORMATO DE CAMPOS'),
(10,'NO FUNCIONA PROYECTO DETALLADO'),
(11,'OBJETO NO COMPILA'),
(12,'OBJETOS NO RECIBIDOS'),
(13,'OTROS'),
(14,'PROCESO POCO DETALLADO');

INSERT INTO `gestion_factoria`.`thge001_tipo_serv`
VALUES
(1,'PRUEBAS FUNCIONALES',1),
(2,'EJECUCIÓN DE CASOS DE PRUEBA',1),
(3,'PRUEBAS DE NO AFECTACIÓN',1),
(4,'PRUEBAS DE ACEPTACIÓN',1),
(5,'PRUEBAS DE USUARIO',1),
(6,'SERVICIO DE AMBIENTACIÓN',1),
(7,'PROCESOS BATCH',1),
(8,'PRUEBAS FUNCIONALES Y NO AFECTACIÓN',1),
(9,'CONSTRUCCION FACTORIA',2);

INSERT INTO `thge056_canal`
VALUES
(1,'MOVIL'),
(2,'ATM\'S'),
(3,'BCOM'),
(4,'EECC'),
(5,'NETCASH'),
(6,'TPV\'S'),
(7,'CONSTRUCCION FACTORIA');

INSERT INTO `thge034_banca`
VALUES
(1,'BANCA DE EMPRESAS'),
(2,'COMUNICACIÓN Y RELACIONES INSTITUCIONALE'),
(3,'CONSOLIDADO RECURSOS HUMANOS'),
(4,'CONSOLIDADO SERVICIOS JURÍDICOS'),
(5,'CONSOLIDADO SISTEMAS Y OPERACIÓN'),
(6,'CORPORATE & INVESTEMENT BANKING'),
(7,'DESARROLLO DE NEGOCIO Y MEDIOS DE PAGO'),
(8,'DIR. GENERAL DE MERCADOS'),
(9,'FINANZAS Y CONTRALORIA'),
(10,'RED + OTRAS ÁREAS BANCA COMERCIAL'),
(11,'RIESGOS'),
(12,'TRANSFORMACIÓN CALIDAD Y DES. CORP.'),
(13,'TRANSFORMACION DIGITAL');

INSERT INTO `gestion_factoria`.`thge002_tecnologia`  
VALUES 
(1, '.NET'),
(2, 'ADAEVOS'),
(3, 'BI'),
(4, 'ESSBASE'),
(5, 'HOST'),
(6, 'JAVA'),
(7, 'MICROSTRATEGY'),
(8, 'NACAR'),
(9, 'ORACLE'),
(10, 'POWER BUILDER'),
(11, 'POWER CENTER'),
(12, 'PRUEBAS'),
(13, 'SCRUM'),
(14, 'SPRING'),
(15, 'VISUAL BASIC');

-- METODOLOGIA
INSERT INTO `gestion_factoria`.`thge035_metodologia`
VALUES
(1, 'SCRUM'),
(2, 'WATERFALL');

INSERT INTO `thge037_entidad`
VALUES
(1,'BANCOMER'),
(2,'SEDAE');

INSERT INTO `thge038_naturaleza`
VALUES
(1,'GASTO'),
(2,'INVERSION');

INSERT INTO `thge057_aplicacion`
VALUES
(1,'BNC',1),
(2,'MEDIOS DE PAGO',2),
(3,'PRESTAMOS',3),
(4,'CUENTAS PERSONALES',4),
(5,'BMOVIL',5),
(6,'BCOM',6),
(7,'EECC',7);

INSERT INTO `thge005_estado`
VALUES
(1,'SIN TRAMITAR',17),
(2,'EN TRAMITE',17),
(3,'ALTA',17),
(4,'BAJA',17),
(5,'ABIERTA',2),
(6,'CERRADA',2),
(7,'RECHAZADA',2),
(8,'PDTE. CARGA',3),
(9,'PDTE. CGF',3),
(10,'CARGADO',3),
(11,'ENVIADA A DYD',4),
(12,'RESUELTA POR DYD',4),
(13,'CERRADA POR SWF',4),
(14,'RECHAZADA POR DYD',4),
(15,'RESOLUCIÓN INCORRECTA',4),
(16,'ABIERTA',5),
(17,'RESUELTA',5),
(18,'CERRADA',5),
(19,'RECHAZADA',5),
(20,'RESOLUCIÓN INCORRECTA',5),
(21,'RESUELTO PDTE. DE CAMBIOS',5),
(22,'RESUELTO POR DYD',5),
(23,'RESOL. POR DYD RECHAZADA',5),
(24,'PENDIENTE ARQ. / DATOS',5),
(25,'RECHAZADO - RESUELTO',5),
(26,'ACTIVO',6),
(27,'INNACTIVO',6),
(28,'ACTIVO',7),
(29,'FINALIZADO',7),
(30,'HISTÓRICO',7),
(31,'ENVIADO A FACTORÍA',8),
(32,'PDTE. (DUDAS O MOD.)',8),
(33,'RECHAZADO POR FACT.',8),
(34,'CANCELADO POR DYD',8),
(35,'RECIBIDO DE FACTORÍA',8),
(36,'EXTRAIDO DEL MODELO',8),
(37,'RECIBIDO (OTRO EVOL./FACT.)',8),
(38,'ACTIVA',9),
(39,'BAJA',9),
(40,'TOCADO PARCIALMENTE',10),
(41,'NO TOCADO',10),
(42,'CONSERVAR SALDO',11),
(43,'FINALIZADO',11),
(44,'VIGENTE',12),
(45,'VENCIDO',12),
(46,'OK',13),
(47,'SOLICITAR PPTO',13),
(48,'EN ESPERA',13),
(49,'ADEUDO',14),
(50,'PAGADO',14),
(51,'ALERTADO POR DYD',15),
(52,'ALERTADO POR FABRICA',15),
(53,'ALERTADO POR CGF',15),
(54,'CERRADO',15),
(55,'VIGENTE',16),
(56,'VENCIDA',16),
(57,'ACTIVO',1),
(58,'INACTIVO',1),
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
(69, 'DEPÓSITO A PROVEEDOR', 18),
(70, 'ACTIVO', 19),
(71, 'BAJA', 19),
(72, 'ACTIVO', 20),
(73, 'BAJA', 20);

-- PRODUCTO
INSERT INTO `gestion_factoria`.`thge018_producto`
VALUES
('J01',	'PANTALLA ESTÁTICA', 6),
('J02',	'PANTALLA DINÁMICA', 6),
('J03',	'PLANTILLA', 6),
('J04',	'FICHERO CONGIRUACIÓN', 6),
('J05',	'CLASE', 6),
('J06',	'MÉTODO', 6),
('J07',	'PROCEDIMIENTOS ALMACENADOS', 6),
('J08',	'SCRIPTS', 6),
('J09',	'JAVASCRIPTS REUTILIZABLES', 6),
('HA1',	'ESQUELETO CÓDIGO AUTOMÁTICO', 5),
('HB1',	'LISTADO', 5),
('HB2',	'CRUCE DE FICHEROS', 5),
('HB3',	'VALID. Y FORM. SALIDA/EXTRACTOR', 5),
('HB4',	'ACTUAL. DB2 BATCH', 5),
('HC1',	'COPY,FORMULARIO O FORMATO (E/S)', 5),
('HJ1',	'JCL/PROCLIB/CTC/PARMLIB', 5),
('HM1',	'MAPA 3270', 5),
('HO1',	'SERV. DIRECTOR', 5),
('HO2',	'SERV. CONSULTA', 5),
('HO3',	'SERV. LISTA', 5),
('HO4',	'SERV. MANTENIMIENTO', 5),
('HR1',	'RUTINA CONSULTA', 5),
('HR2',	'RUTINA MANTENIMIENTO', 5),
('HR3',	'RUTINA LISTA', 5),
('N01',	'FLUJO', 8),
('N02',	'VENTANA', 8),
('N03',	'RUTINAS DE NEGOCIO', 8),
('N04',	'JAVASCRIPTS REUTILIZABLES', 8),
('N05',	'PROCEDIMIENTOS ALMACENADOS', 8),
('N06',	'SERVICIOS DE DATOS', 8),
('N07',	'PLANTILLAS XSL - FO ESTÁTICAS', 8),
('N08',	'FLUJOS AUTOMATICOS', 8);

-- TIPOLOGIA
INSERT INTO `gestion_factoria`.`thge006_tipologia`
(CD_TIPOLOGIA, CD_PRODUCTO, TP_COMPONENTE, NU_DIFICULTAD, NU_HM_DIFICULTAD, ST_ESTADO)
VALUES 
(1,'J01',0,0,0.00,3),
(2,'J02',0,0,0.00,3),
(3,'J03',0,0,0.00,3),
(4,'J04',0,0,0.00,3),
(5,'J05',0,0,0.00,3),
(6,'J06',0,0,1.80,3),
(7,'J07',0,0,0.00,3),
(8,'J08',0,0,0.00,3),
(9,'J09',0,0,0.00,3),
(10,'J01',0,1,5.50,3),
(11,'J02',0,1,9.50,3),
(12,'J03',0,1,3.50,3),
(13,'J04',0,1,3.00,3),
(14,'J05',0,1,0.25,3),
(15,'J06',0,1,4.50,3),
(16,'J07',0,1,4.50,3),
(17,'J08',0,1,2.00,3),
(18,'J09',0,1,3.50,3),
(19,'J01',0,2,8.50,3),
(20,'J02',0,2,15.00,3),
(21,'J03',0,2,7.50,3),
(22,'J04',0,2,4.50,3),
(23,'J05',0,2,0.25,3),
(24,'J06',0,2,8.50,3),
(25,'J07',0,2,7.50,3),
(26,'J08',0,2,4.00,3),
(27,'J09',0,2,7.50,3),
(28,'J01',0,3,11.00,3),
(29,'J02',0,3,22.00,3),
(30,'J03',0,3,11.00,3),
(31,'J04',0,3,8.00,3),
(32,'J05',0,3,0.25,3),
(33,'J06',0,3,13.00,3),
(34,'J07',0,3,10.00,3),
(35,'J08',0,3,6.00,3),
(36,'J09',0,3,11.00,3),
(37,'J01',0,4,17.00,3),
(38,'J02',0,4,33.50,3),
(39,'J03',0,4,14.00,3),
(40,'J04',0,4,11.00,3),
(41,'J05',0,4,0.25,3),
(42,'J06',0,4,21.00,3),
(43,'J07',0,4,14.00,3),
(44,'J08',0,4,7.00,3),
(45,'J09',0,4,15.00,3),
(46,'J01',1,0,1.00,3),
(47,'J02',1,0,1.00,3),
(48,'J03',1,0,1.00,3),
(49,'J04',1,0,1.00,3),
(50,'J05',1,0,0.15,3),
(51,'J06',1,0,1.00,3),
(52,'J07',1,0,1.00,3),
(53,'J08',1,0,0.15,3),
(54,'J09',1,0,1.00,3),
(55,'J01',1,1,3.00,3),
(56,'J02',1,1,5.00,3),
(57,'J03',1,1,2.00,3),
(58,'J04',1,1,2.00,3),
(59,'J05',1,1,0.15,3),
(60,'J06',1,1,3.00,3),
(61,'J07',1,1,3.00,3),
(62,'J08',1,1,1.00,3),
(63,'J09',1,1,2.00,3),
(64,'J01',1,2,4.50,3),
(65,'J02',1,2,8.50,3),
(66,'J03',1,2,4.00,3),
(67,'J04',1,2,3.00,3),
(68,'J05',1,2,0.15,3),
(69,'J06',1,2,5.00,3),
(70,'J07',1,2,4.00,3),
(71,'J08',1,2,2.00,3),
(72,'J09',1,2,5.00,3),
(73,'J01',1,3,7.50,3),
(74,'J02',1,3,12.00,3),
(75,'J03',1,3,6.00,3),
(76,'J04',1,3,5.00,3),
(77,'J05',1,3,0.15,3),
(78,'J06',1,3,8.50,3),
(79,'J07',1,3,6.50,3),
(80,'J08',1,3,3.00,3),
(81,'J09',1,3,7.50,3),
(82,'J01',1,4,12.00,3),
(83,'J02',1,4,15.50,3),
(84,'J03',1,4,7.50,3),
(85,'J04',1,4,7.00,3),
(86,'J05',1,4,0.15,3),
(87,'J06',1,4,13.00,3),
(88,'J07',1,4,9.50,3),
(89,'J08',1,4,5.00,3),
(90,'J09',1,4,11.00,3),
(91,'HA1',0,0,0.00,3),
(92,'HB1',0,0,0.00,3),
(93,'HB2',0,0,0.00,3),
(94,'HB3',0,0,0.00,3),
(95,'HB4',0,0,0.00,3),
(96,'HC1',0,0,0.00,3),
(97,'HJ1',0,0,0.00,3),
(98,'HM1',0,0,0.00,3),
(99,'HO1',0,0,0.00,3),
(100,'HO2',0,0,0.00,3),
(101,'HO3',0,0,0.00,3),
(102,'HO4',0,0,0.00,3),
(103,'HR1',0,0,0.00,3),
(104,'HR2',0,0,0.00,3),
(105,'HR3',0,0,0.00,3),
(106,'HA1',0,1,0.00,3),
(107,'HB1',0,1,11.00,3),
(108,'HB2',0,1,10.00,3),
(109,'HB3',0,1,11.00,3),
(110,'HB4',0,1,12.00,3),
(111,'HC1',0,1,0.50,3),
(112,'HJ1',0,1,2.00,3),
(113,'HM1',0,1,1.00,3),
(114,'HO1',0,1,11.00,3),
(115,'HO2',0,1,10.00,3),
(116,'HO3',0,1,12.00,3),
(117,'HO4',0,1,12.00,3),
(118,'HR1',0,1,10.00,3),
(119,'HR2',0,1,11.00,3),
(120,'HR3',0,1,13.00,3),
(121,'HA1',0,2,0.00,3),
(122,'HB1',0,2,20.00,3),
(123,'HB2',0,2,19.00,3),
(124,'HB3',0,2,19.00,3),
(125,'HB4',0,2,19.00,3),
(126,'HC1',0,2,1.00,3),
(127,'HJ1',0,2,5.00,3),
(128,'HM1',0,2,2.00,3),
(129,'HO1',0,2,18.00,3),
(130,'HO2',0,2,19.00,3),
(131,'HO3',0,2,20.00,3),
(132,'HO4',0,2,20.00,3),
(133,'HR1',0,2,18.00,3),
(134,'HR2',0,2,20.00,3),
(135,'HR3',0,2,20.00,3),
(136,'HA1',0,3,0.00,3),
(137,'HB1',0,3,28.00,3),
(138,'HB2',0,3,25.00,3),
(139,'HB3',0,3,28.00,3),
(140,'HB4',0,3,27.00,3),
(141,'HC1',0,3,1.50,3),
(142,'HJ1',0,3,8.00,3),
(143,'HM1',0,3,3.00,3),
(144,'HO1',0,3,23.00,3),
(145,'HO2',0,3,26.00,3),
(146,'HO3',0,3,28.00,3),
(147,'HO4',0,3,27.00,3),
(148,'HR1',0,3,25.00,3),
(149,'HR2',0,3,27.00,3),
(150,'HR3',0,3,29.00,3),
(151,'HA1',0,4,0.00,3),
(152,'HB1',0,4,37.00,3),
(153,'HB2',0,4,32.00,3),
(154,'HB3',0,4,34.00,3),
(155,'HB4',0,4,33.00,3),
(156,'HC1',0,4,2.00,3),
(157,'HJ1',0,4,11.00,3),
(158,'HM1',0,4,4.00,3),
(159,'HO1',0,4,31.00,3),
(160,'HO2',0,4,33.00,3),
(161,'HO3',0,4,35.00,3),
(162,'HO4',0,4,37.00,3),
(163,'HR1',0,4,33.00,3),
(164,'HR2',0,4,35.00,3),
(165,'HR3',0,4,36.00,3),
(166,'HA1',1,0,0.00,3),
(167,'HB1',1,0,1.00,3),
(168,'HB2',1,0,1.00,3),
(169,'HB3',1,0,1.00,3),
(170,'HB4',1,0,1.00,3),
(171,'HC1',1,0,0.00,3),
(172,'HJ1',1,0,0.00,3),
(173,'HM1',1,0,0.00,3),
(174,'HO1',1,0,1.00,3),
(175,'HO2',1,0,1.00,3),
(176,'HO3',1,0,1.00,3),
(177,'HO4',1,0,1.00,3),
(178,'HR1',1,0,1.00,3),
(179,'HR2',1,0,1.00,3),
(180,'HR3',1,0,1.00,3),
(181,'HA1',1,1,0.00,3),
(182,'HB1',1,1,4.50,3),
(183,'HB2',1,1,4.50,3),
(184,'HB3',1,1,5.50,3),
(185,'HB4',1,1,6.50,3),
(186,'HC1',1,1,0.00,3),
(187,'HJ1',1,1,2.00,3),
(188,'HM1',1,1,0.00,3),
(189,'HO1',1,1,5.50,3),
(190,'HO2',1,1,5.50,3),
(191,'HO3',1,1,7.00,3),
(192,'HO4',1,1,6.50,3),
(193,'HR1',1,1,5.50,3),
(194,'HR2',1,1,6.50,3),
(195,'HR3',1,1,6.50,3),
(196,'HA1',1,2,0.00,3),
(197,'HB1',1,2,9.00,3),
(198,'HB2',1,2,9.00,3),
(199,'HB3',1,2,9.00,3),
(200,'HB4',1,2,11.00,3),
(201,'HC1',1,2,0.00,3),
(202,'HJ1',1,2,4.00,3),
(203,'HM1',1,2,0.00,3),
(204,'HO1',1,2,10.00,3),
(205,'HO2',1,2,10.00,3),
(206,'HO3',1,2,11.00,3),
(207,'HO4',1,2,11.00,3),
(208,'HR1',1,2,10.00,3),
(209,'HR2',1,2,11.00,3),
(210,'HR3',1,2,11.00,3),
(211,'HA1',1,3,0.00,3),
(212,'HB1',1,3,14.00,3),
(213,'HB2',1,3,13.00,3),
(214,'HB3',1,3,14.00,3),
(215,'HB4',1,3,15.00,3),
(216,'HC1',1,3,0.00,3),
(217,'HJ1',1,3,6.00,3),
(218,'HM1',1,3,0.00,3),
(219,'HO1',1,3,14.00,3),
(220,'HO2',1,3,15.00,3),
(221,'HO3',1,3,18.00,3),
(222,'HO4',1,3,16.00,3),
(223,'HR1',1,3,15.00,3),
(224,'HR2',1,3,16.00,3),
(225,'HR3',1,3,17.00,3),
(226,'HA1',1,4,0.00,3),
(227,'HB1',1,4,20.00,3),
(228,'HB2',1,4,18.00,3),
(229,'HB3',1,4,19.00,3),
(230,'HB4',1,4,19.00,3),
(231,'HC1',1,4,0.00,3),
(232,'HJ1',1,4,7.00,3),
(233,'HM1',1,4,0.00,3),
(234,'HO1',1,4,19.00,3),
(235,'HO2',1,4,20.00,3),
(236,'HO3',1,4,23.00,3),
(237,'HO4',1,4,21.00,3),
(238,'HR1',1,4,20.00,3),
(239,'HR2',1,4,22.00,3),
(240,'HR3',1,4,23.00,3),
(241,'N01',0,0,0.00,3),
(242,'N02',0,0,0.00,3),
(243,'N03',0,0,0.00,3),
(244,'N04',0,0,0.00,3),
(245,'N05',0,0,0.00,3),
(246,'N06',0,0,0.00,3),
(247,'N07',0,0,0.00,3),
(248,'N08',0,0,0.00,3),
(249,'N01',0,1,6.50,3),
(250,'N02',0,1,11.50,3),
(251,'N03',0,1,5.00,3),
(252,'N04',0,1,4.00,3),
(253,'N05',0,1,5.00,3),
(254,'N06',0,1,0.00,3),
(255,'N07',0,1,9.00,3),
(256,'N08',0,1,2.00,3),
(257,'N01',0,2,13.00,3),
(258,'N02',0,2,18.50,3),
(259,'N03',0,2,8.00,3),
(260,'N04',0,2,7.50,3),
(261,'N05',0,2,7.50,3),
(262,'N06',0,2,0.00,3),
(263,'N07',0,2,15.00,3),
(264,'N08',0,2,4.00,3),
(265,'N01',0,3,18.50,3),
(266,'N02',0,3,27.00,3),
(267,'N03',0,3,13.00,3),
(268,'N04',0,3,11.00,3),
(269,'N05',0,3,10.50,3),
(270,'N06',0,3,0.00,3),
(271,'N07',0,3,21.00,3),
(272,'N08',0,3,6.00,3),
(273,'N01',0,4,29.00,3),
(274,'N02',0,4,36.00,3),
(275,'N03',0,4,20.00,3),
(276,'N04',0,4,15.00,3),
(277,'N05',0,4,14.00,3),
(278,'N06',0,4,0.00,3),
(279,'N07',0,4,29.00,3),
(280,'N08',0,4,9.00,3),
(281,'N01',1,0,1.00,3),
(282,'N02',1,0,1.00,3),
(283,'N03',1,0,1.00,3),
(284,'N04',1,0,1.00,3),
(285,'N05',1,0,1.00,3),
(286,'N06',1,0,0.00,3),
(287,'N07',1,0,1.00,3),
(288,'N08',1,0,1.00,3),
(289,'N01',1,1,4.00,3),
(290,'N02',1,1,7.00,3),
(291,'N03',1,1,3.00,3),
(292,'N04',1,1,2.00,3),
(293,'N05',1,1,3.00,3),
(294,'N06',1,1,0.00,3),
(295,'N07',1,1,6.00,3),
(296,'N08',1,1,2.00,3),
(297,'N01',1,2,8.50,3),
(298,'N02',1,2,11.50,3),
(299,'N03',1,2,4.50,3),
(300,'N04',1,2,4.50,3),
(301,'N05',1,2,4.00,3),
(302,'N06',1,2,0.00,3),
(303,'N07',1,2,9.00,3),
(304,'N08',1,2,4.00,3),
(305,'N01',1,3,13.00,3),
(306,'N02',1,3,16.00,3),
(307,'N03',1,3,8.00,3),
(308,'N04',1,3,7.50,3),
(309,'N05',1,3,6.00,3),
(310,'N06',1,3,0.00,3),
(311,'N07',1,3,13.00,3),
(312,'N08',1,3,6.00,3),
(313,'N01',1,4,19.50,3),
(314,'N02',1,4,24.50,3),
(315,'N03',1,4,13.00,3),
(316,'N04',1,4,11.00,3),
(317,'N05',1,4,10.00,3),
(318,'N06',1,4,0.00,3),
(319,'N07',1,4,19.00,3),
(320,'N08',1,4,9.00,3),
(321,'J01',0,'F',0.00,3),
(322,'J02',0,'F',0.00,3),
(323,'J03',0,'F',0.00,3),
(324,'J04',0,'F',0.00,3),
(325,'J05',0,'F',0.00,3),
(326,'J06',0,'F',0.00,3),
(327,'J07',0,'F',0.00,3),
(328,'J08',0,'F',0.00,3),
(329,'J09',0,'F',0.00,3),
(330,'HA1',0,'F',0.00,3),
(331,'HB1',0,'F',0.00,3),
(332,'HB2',0,'F',0.00,3),
(333,'HB3',0,'F',0.00,3),
(334,'HB4',0,'F',0.00,3),
(335,'HC1',0,'F',0.00,3),
(336,'HJ1',0,'F',0.00,3),
(337,'HM1',0,'F',0.00,3),
(338,'HO1',0,'F',0.00,3),
(339,'HO2',0,'F',0.00,3),
(340,'HO3',0,'F',0.00,3),
(341,'HO4',0,'F',0.00,3),
(342,'HR1',0,'F',0.00,3),
(343,'HR2',0,'F',0.00,3),
(344,'HR3',0,'F',0.00,3),
(345,'N01',0,'F',0.00,3),
(346,'N02',0,'F',0.00,3),
(347,'N03',0,'F',0.00,3),
(348,'N04',0,'F',0.00,3),
(349,'N05',0,'F',0.00,3),
(350,'N06',0,'F',0.00,3),
(351,'N07',0,'F',0.00,3),
(352,'N08',0,'F',0.00,3),
(353,'J01',1,'F',0.00,3),
(354,'J02',1,'F',0.00,3),
(355,'J03',1,'F',0.00,3),
(356,'J04',1,'F',0.00,3),
(357,'J05',1,'F',0.00,3),
(358,'J06',1,'F',0.00,3),
(359,'J07',1,'F',0.00,3),
(360,'J08',1,'F',0.00,3),
(361,'J09',1,'F',0.00,3),
(362,'HA1',1,'F',0.00,3),
(363,'HB1',1,'F',0.00,3),
(364,'HB2',1,'F',0.00,3),
(365,'HB3',1,'F',0.00,3),
(366,'HB4',1,'F',0.00,3),
(367,'HC1',1,'F',0.00,3),
(368,'HJ1',1,'F',0.00,3),
(369,'HM1',1,'F',0.00,3),
(370,'HO1',1,'F',0.00,3),
(371,'HO2',1,'F',0.00,3),
(372,'HO3',1,'F',0.00,3),
(373,'HO4',1,'F',0.00,3),
(374,'HR1',1,'F',0.00,3),
(375,'HR2',1,'F',0.00,3),
(376,'HR3',1,'F',0.00,3),
(377,'N01',1,'F',0.00,3),
(378,'N02',1,'F',0.00,3),
(379,'N03',1,'F',0.00,3),
(380,'N04',1,'F',0.00,3),
(381,'N05',1,'F',0.00,3),
(382,'N06',1,'F',0.00,3),
(383,'N07',1,'F',0.00,3),
(384,'N08',1,'F',0.00,3);

-- USUARIOS

INSERT INTO `thge011_usuario`
VALUES
('XMY3010','123',1,1),
('XMY3020','123',2,1),
('XMY3030','123',3,1),
('XMY3040','123',4,1),
('XMY3050','123',5,1),
('XMY3060','123',6,1),
('XMY3070','123',7,1),
('XMY3080','123',8,1),
('XMY3090','123',9,1),
('XMY3100','123',10,1),
('XMY3110','123',11,1);

-- TABLA 010 NIVELES
INSERT INTO gestion_factoria.thge010_nivel 
(CD_NIVEL,NB_NIVEL,CD_TIPO_NIVEL,CD_USUARIO_RESP) 
VALUES
(1,'ADQUIRIENTE Y BANCA ELECTRÓNICA',1,'XMY3070'),
(2,'ANS Y FACTORIAS',1,'XMY3070'),
(3,'ARCHITECTURE ENGINEERING',1,'XMY3070'),
(4,'AUTOSERVICIO',1,'XMY3070'),
(5,'BANCA MÓVIL',1,'XMY3070'),
(6,'BCA FÁCIL Y REL AUTORIDADES',1,'XMY3070'),
(7,'BPM',1,'XMY3070'),
(8,'C&IB',1,'XMY3070'),
(9,'CANALES ATENDIDOS',1,'XMY3070'),
(10,'CANALES DIGITALES',1,'XMY3070'),
(11,'CONTACT CENTER',1,'XMY3070'),
(12,'CORE BANKING ACTIVO Y PASIVO',1,'XMY3070'),
(13,'DESARROLLO COMERCIAL',1,'XMY3070'),
(14,'PBAS CUENTAS PERSONALES',1,'XMY3070'),
(15,'PLATAFORMA COMERCIAL',1,'XMY3070'),
(16,'SECURITY ARCHITECTURE',1,'XMY3070'),
(17,'SEGUROS',1,'XMY3070'),
(18,'SISTEMAS BEYG',1,'XMY3070'),
(19,'SISTEMAS HOLDING',1,'XMY3070'),
(20,'TRANSFORMATION SOLUTIONS',1,'XMY3070');

INSERT INTO gestion_factoria.thge010_nivel
(CD_NIVEL,NB_NIVEL,CD_TIPO_NIVEL,CD_USUARIO_RESP, CD_NIVEL_SUPERIOR)
VALUES
(21,'INVENTARIOS E INST. TPVS Y BE',2,'XMY3080',1),
(22,'COA',2,'XMY3080',2),
(23,'ANS FRONTS',2,'XMY3080',2),
(24,'ANS INFORMACIONAL',2,'XMY3080',2),
(25,'ANS MEDIOS DE PAGO',2,'XMY3080',2),
(26,'ANS PRÉSTAMOS',2,'XMY3080',2),
(27,'MANTENIMIENTO Y FACTORIAS',2,'XMY3080',2),
(28,'BÓVEDA ELECT. ACLARACIONES',2,'XMY3080',3),
(29,'ARCHITECTURE ENGINEERING',2,'XMY3080',3),
(30,'BPM',2,'XMY3080',3),
(31,'SERVICIOS',2,'XMY3080',3),
(32,'TECNOLOGÍA AUTOSERVICIO',2,'XMY3080',4),
(33,'CAJEROS Y PRACTICAJAS',2,'XMY3080',4),
(34,'SEGURIDAD ATMS Y DISTRIBUCIÓN',2,'XMY3080',4),
(35,'AUTOSERVICIO SOLUCIONES DIGITALES',2,'XMY3080',4),
(36,'BANCA MÓVIL',2,'XMY3080',5),
(37,'BANCOMER SMS Y ALERTAS',2,'XMY3080',5),
(38,'APPS VERTICALES',2,'XMY3080',5),
(39,'APPS INFORMATIVOS',2,'XMY3080',5),
(40,'BCA FÁCIL Y REL AUTORIDADES',2,'XMY3080',6),
(41,'PBAS BPM',2,'XMY3080',7),
(42,'OPERACIONES Y RIESGOS',2,'XMY3080',8),
(43,'PLATAFORMA C&IB',2,'XMY3080',8),
(44,'EE CC',2,'XMY3080',9),
(45,'PROCESOS Y CONTRATACIÓN',2,'XMY3080',9),
(46,'AA CC / QA',2,'XMY3080',9),
(47,'TF FRONTS E INTRANET',2,'XMY3080',9),
(48,'NUEVAS SOLUCIONES QA',2,'XMY3080',9),
(49,'EXTRANET Y BANCA CORRESPONSAL',2,'XMY3080',10),
(50,'INTERNET PERSONAS FÍSICAS Y PORTALES',2,'XMY3080',10),
(51,'CANALES ELECTRÓNICOS DE EMPRESAS',2,'XMY3080',10),
(52,'CG, DOSIFICADORES',2,'XMY3080',10),
(53,'ACLARACIONES',2,'XMY3080',11),
(54,'PORTAL DE VOZ',2,'XMY3080',11),
(55,'PASIVO',2,'XMY3080',12),
(56,'ACTIVO PRÉSTAMOS',2,'XMY3080',12),
(57,'SERVICIOS BANCA EMPRESAS',2,'XMY3080',12),
(58,'COBRANZA Y DISOLUCIÓN',2,'XMY3080',12),
(59,'CONSUMER FINANCE',2,'XMY3080',12),
(60,'NÓMINA, PASIVO Y SERVICIOS',2,'XMY3080',12),
(61,'CENTRAL DE AUTORIZACIONES',2,'XMY3080',13),
(62,'TARJETA DE CRÉDITO',2,'XMY3080',13),
(63,'CAMPAÑAS Y LEALTAD DYD',2,'XMY3080',13),
(64,'COMERCIOS Y CORRESPONSALES',2,'XMY3080',13),
(65,'CONTABILIDAD E INFORMACIONAL',2,'XMY3080',13),
(66,'ADMISIÓN SERVICIOS OPERATIVOS',2,'XMY3080',13),
(67,'BANCA PATRIMONIAL Y PRIVADA',2,'XMY3080',13),
(68,'PRODUCTOS DE PASIVO Y PYME',2,'XMY3080',13),
(69,'DISPOSITIVOS',2,'XMY3080',13),
(70,'FONDOS Y TRANSFERENCIAS',2,'XMY3080',14),
(71,'PI - PERSONAS',2,'XMY3080',15),
(72,'CRM / QA',2,'XMY3080',15),
(73,'CAMPAÑAS',2,'XMY3080',15),
(74,'EVALUATION OF PROJECTS',2,'XMY3080',16),
(75,'SEGUROS',2,'XMY3080',17),
(76,'FIDUCIARIO',2,'XMY3080',18),
(77,'INFORMACIONAL Y FINANZAS',2,'XMY3080',19),
(78,'AUTORIDADES Y CUMPLIMIENTO',2,'XMY3080',19),
(79,'SISTEMAS PLD Y CUMPLIMIENTO NORMATIVO',2,'XMY3080',19),
(80,'RIESGOS',2,'XMY3080',19),
(81,'GESTIÓN DE EMPRESAS',2,'XMY3080',19),
(82,'DATA MANAGER Y GESTION',2,'XMY3080',19),
(83,'TRANSFORMATION SOLUTIONS',2,'XMY3080',20),
(84,'TRANSFORMACIÓN CANALES',2,'XMY3080',20);

-- TABLA thge022_proyecto
INSERT INTO gestion_factoria.thge022_proyecto(CD_SDA,CD_PI,CD_METODOLOGIA,NB_PROYECTO) 
VALUES 
('SDATOOL-13350',8,1,'GESTION, CIERRE Y CONCILIACIÓN DE EFECTIVO'),
('SDATOOL-13351',8,1,'GESTION, CIERRE Y CONCILIACIÓN DE VALORES'),
('SDATOOL-13273',8,2,'COBRO DE INTERESES USANDO DÍAS EFECTIVAMENTE TRANSCURRIDOS'),
('SDATOOL-13381',8,1,'CONTROL OPERATIVA EFECTIVO SUCURSAL'),
('SDATOOL-13304',8,1,'REDUCCIÓN ACTIVO IMPRODUCTIVO (ONGOING EN PI7: REDUCIR ERRORES O FRAUDES POR OPERATIVA DE EFECTIVO EN BÓVEDAS.)'),
('SDATOOL-13343',8,1,'PAGOS EN LÍNEA, ALERTAS Y SERVICIOS DE COBRANZA - MULTICANALIDAD'),
('SDATOOL-13255',8,1,'VERSIÓN FULL MULTIVENDOR (UNIFICACIÓN DE PLATAFORMA MULTIVENDOR)'),
('SDATOOL-13356',8,1,'REINGENIERÍA DE LA OPERATIVA CHEQUES'),
('SDATOOL-13286',8,2,'SOLUCIÓN ATM CLOUD'),
('SDATOOL-13357',8,1,'REINGENIERÍA OPERATIVA TDD, TDC Y SERVICIOS'),
('SDATOOL-13253',8,1,'MIGRACIÓN DE ARQUITECTURA NACAR EECC'),
('SDATOOL-13340',8,1,'INTEGRACIÓN VISIÓN CLIENTE EN OPERACIÓN CC (CCD)'),
('SDATOOL-11840',8,1,'FATCA + CRS'),
('SDATOOL-13338',8,1,'ESTRATEGIA INTEGRAL VISIÓN CLIENTE'),
('SDATOOL-13385',8,1,'ALERTAMIENTOS PREDICTIVOS'),
('SDATOOL-13256',8,1,'VALIDACIÓN DE FORMA BIDIRECCIONAL TPV S, ENTRE E-GLOBAL Y BBVA BANCOMER'),
('SDATOOL-13401',8,1,'SIMPLIFICACIÓN DE PROCESOS DE ADMISIÓN'),
('SDATOOL-13281',8,1,'ANTITALLADORES'),
('SDATOOL-13344',8,1,'PRODUCTOS DE SOLUCIÓN PARTICULARES'),
('SDATOOL-13362',8,1,'AUTOMATIZACIÓN SERVICING TRÁMITES');

INSERT INTO `gestion_factoria`.`thge003_empresa` 
VALUES 
(1, 'ACCENTURE', 'ACCENTURE SC', '001', 38),
(2, 'CAPGEMINI', 'CAPGEMINI MEXICO, S. DE R.L. DE C.V.', '002', 38),
(3, 'CDA INFORMATICA', 'CDA INFORMATICA S.A. DE C.V.', '003', 38),
(4, 'CGI TECHNOLOGIES AND SOLUTIONS', 'CGI TECHNOLOGIES AND SOLUTIONS MEXICO, S.A. DE C.V.', '004', 38),
(5, 'DGCM', 'DGCM, S.A. DE C.V.', '005', 38),
(6, 'EVERIS', 'EVERIS MEXICO, S. DE R.L. DE C.V.', '006', 38),
(7, 'GESFOR', 'GESFOR MEXICO S.A. DE C.V.', '007', 38),
(8, 'GETRONICS', 'GETRONICS (MEXICO) S.A. DE C.V.', '008', 38),
(9, 'GONET', 'GONET MEXICO SA DE CV', '009', 38),
(10, 'IDS', 'IDS COMERCIAL S.A DE C.V.', '010', 38),
(11, 'INDRA', 'INDRA SISTEMAS MEXICO SA DE CV', '011', 38),
(12, 'INFOMEDIA', 'INFOMEDIA SA DE CV', '012', 38),
(13, 'INTERNACIONAL DE SISTEMAS', 'INTERNACIONAL DE SISTEMAS, S.A. DE C.V.', '013', 38),
(14, 'ITWORKERS', 'ITWORKERS SC', '014', 38),
(15, 'NEORIS', 'NEORIS DE MEXICO S.A. DE C.V.', '015', 38),
(16, 'SIGMATAO FACTORY', 'SIGMATAO FACTORY SA DE CV', '016', 38),
(17, 'SOFTTEK', 'SOFTTEK SERVICIOS Y TECNOLOGIA S.A DE C.V', '017', 38),
(18, 'SYSVIEWSOFT', 'SYSVIEWSOFT SA DE CV', '018', 38),
(19, 'TESTING EVOLUTION', 'TESTING EVOLUTION, S.A. DE C.V.', '019', 38),
(20, 'VISION SOFTWARE FACTORY', 'VISION SOFTWARE FACTORY, S.A. DE C.V.', '020', 38);

INSERT INTO `gestion_factoria`.`thge014_pais` 
VALUES 
(1, 'MEXICO', 'MX');

INSERT INTO `gestion_factoria`.`thge031_tarifa` 
(`CD_EMPRESA`,`CD_TECNOLOGIA`,`CD_AREA`,`IM_TARIFA`,`NU_ANO_TARIFA`,`ST_TARIFA`) 
VALUES
(1,12,1,10,'2018',28),
(2,5,2,20,'2018',28),
(2,6,2,30,'2018',28),
(2,2,2,40,'2018',28),
(2,13,2,50,'2018',28),
(3,12,1,60,'2018',28),
(3,5,2,70,'2018',28),
(4,6,2,80,'2018',28),
(4,14,2,90,'2018',28),
(4,11,2,100,'2018',28),
(4,7,2,110,'2018',28),
(4,12,1,120,'2018',28),
(4,2,2,130,'2018',28),
(4,13,2,140,'2018',28),
(5,5,2,150,'2018',28),
(5,8,2,160,'2018',28),
(5,2,2,170,'2018',28),
(5,13,2,180,'2018',28),
(6,5,2,190,'2018',28),
(6,2,2,200,'2018',28),
(6,13,2,210,'2018',28),
(7,6,2,220,'2018',28),
(7,2,2,230,'2018',28),
(7,13,2,240,'2018',28),
(8,5,2,250,'2018',28),
(8,6,2,260,'2018',28),
(8,2,2,270,'2018',28),
(8,13,2,280,'2018',28),
(9,5,2,290,'2018',28),
(9,2,2,300,'2018',28),
(10,12,2,310,'2018',28),
(10,6,2,320,'2018',28),
(10,11,2,330,'2018',28),
(10,7,2,340,'2018',28),
(10,12,1,350,'2018',28),
(10,2,2,360,'2018',28),
(10,13,2,370,'2018',28),
(11,12,1,380,'2018',28),
(12,12,1,390,'2018',28),
(13,12,1,400,'2018',28),
(14,5,2,410,'2018',28),
(14,6,2,420,'2018',28),
(14,8,2,430,'2018',28),
(15,12,1,440,'2018',28),
(16,12,1,450,'2018',28);

INSERT INTO `gestion_factoria`.`thge055_cta_oper`
VALUES
(1, '00001'),
(2, '00002');

INSERT INTO `gestion_factoria`.`thge020_clasif_rec`
VALUES
(1, 'Rec Clasif 1'),
(2, 'Rec Clasif 2');

INSERT INTO `gestion_factoria`.`thge021_sbclas_rec`
VALUES
(1, 'Sub Rec Clasif 1', 1),
(2, 'Sub Rec Clasif 2', 2);

INSERT INTO `gestion_factoria`.`thge046_cat_caso`
VALUES
(1, 'Categoria Caso 1'),
(2, 'Categoria Caso 2'),
(3, 'Categoria Caso 3');

INSERT INTO `gestion_factoria`.`thge047_result_obt` 
VALUES 
(1, 'Resultado Obtenido 1'),
(2, 'Resultado Obtenido 2'),
(3, 'Resultado Obtenido 3');

INSERT INTO `gestion_factoria`.`thge049_entorno` 
VALUES 
(1, 'Entorno 1'),
(2, 'Entorno 2'),
(3, 'Entorno 3');

INSERT INTO `gestion_factoria`.`thge025_sede` 
VALUES 
(1, 'Sede 1'),
(2, 'Sede 2'),
(3, 'Sede 3');

INSERT INTO `gestion_factoria`.`thge032_tipo_cont`  
VALUES 
(1, 'Tipo Contrato 1'),
(2, 'Tipo Contrato 2'),
(3, 'Tipo Contrato 3');

INSERT INTO `gestion_factoria`.`thge033_tipo_asig`  
VALUES 
(1, 'Tipo Asignacion 1'),
(2, 'Tipo Asignacion 2'),
(3, 'Tipo Asignacion 3');

INSERT INTO `gestion_factoria`.`thge043_criticidad` 
VALUES 
(1, 'C01'),
(2, 'C02'),
(3, 'C03');

INSERT INTO `gestion_factoria`.`thge045_prioridad_cp` 
VALUES 
(1, 'Prioridad Caso Prueba 1'),
(2, 'Prioridad Caso Prueba 2'),
(3, 'Prioridad Caso Prueba 3');

INSERT INTO `gestion_factoria`.`thge050_severidad` 
VALUES 
(1, 'Severidad 1'),
(2, 'Severidad 2'),
(3, 'Severidad 3');

INSERT INTO `gestion_factoria`.`thge051_ac_res_cor` 
VALUES 
(1, 'Area Resp 1'),
(2, 'Area Resp 2'),
(3, 'Area Resp 3');

INSERT INTO `gestion_factoria`.`thge052_causa_rech` 
VALUES 
(1, 'Causa Rechazo 1'),
(2, 'Causa Rechazo 2'),
(3, 'Causa Rechazo 3');

INSERT INTO `gestion_factoria`.`thge053_causa_cier` 
VALUES 
(1, 'Causa Cierre 1'),
(2, 'Causa Cierre 2'),
(3, 'Causa Cierre 3');

INSERT INTO `gestion_factoria`.`thge054_res_verif` 
VALUES 
(1, 'Resultado 1'),
(2, 'Resultado 2'),
(3, 'Resultado 3');

INSERT INTO `gestion_factoria`.`thge023_solic_pep`
VALUES
(1, 'DANIEL ALFONSO MORENO VAZ', 70),
(2, 'JUAN LEON VAZQUEZ', 70);

INSERT INTO `gestion_factoria`.`thge069_resp_pep`
VALUES
(1, 'ADRIANA ERIKA SALINAS VAL', 72),
(2, 'BENJAMIN REAL CALDERON', 72),
(3, 'CECILIA MARTINEZ DAVILA', 72),
(4, 'CESAR JAVIER JUAREZ GUTIE', 72),
(5, 'CLAUDIO GUERRERO GUERRERO', 72),
(6, 'DORA BERENICE CRUZ HERNAN', 72),
(7, 'EDUARDO GARCIA MARTINEZ', 72),
(8, 'ENRIQUE GRANADOS LUNA', 72),
(9, 'FRANCISCO EDUARDO HERNAND', 72),
(10, 'JOSE ALFREDO GONZALEZ SAL', 72),
(11, 'JOSE MARIA SUZUKI GONZALE', 72),
(12, 'JOSE MIGUEL OSORIO MORENO', 72),
(13, 'JOSE RAMON HERNANDEZ HERN', 72),
(14, 'JULIO CESAR ROSAS ARELLAN', 72),
(15, 'LAURA LETICIA ROBLES ARRI', 72),
(16, 'LUCIA ACOSTA MONROY', 72),
(17, 'LUIS ENRIQUE ROCHA GUIZAR', 72),
(18, 'MARCO JASSO MAYEN', 72),
(19, 'MARIA DOLORES CASTRO LARA', 72),
(20, 'MARIA NORMA MENDEZ LOPEZ', 72),
(21, 'MAURICIO BAEZA VAZQUEZ', 72),
(22, 'PAOLA MEDINA SANCHEZ', 72),
(23, 'PASTOR RENIER DIAZ ARCINI', 72),
(24, 'PATRICIA JUAREZ GALAN', 72),
(25, 'PEDRO FABIAN GARCIA SAAVE', 72),
(26, 'RAUL ALEJANDRO GALICIA DU', 72),
(27, 'REBECA BERENICE SANCHEZ', 72),
(28, 'ROGELIO ACO GONZALEZ', 72),
(29, 'VENANCIO HERNANDEZ BAEZ', 72),
(30, 'YAZMIN SALAS GUZMAN', 72),
(31, 'YUDITH GOMEZ RUBIO', 72);

