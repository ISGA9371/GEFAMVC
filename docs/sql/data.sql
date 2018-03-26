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
(15,'EDO_SEG_REQ');

INSERT INTO `thge013_tipo_pi`
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
(1,'PRUEBAS FUNCIONALES',1,1),
(2,'EJECUCIÓN DE CASOS DE PRUEBA',1,1),
(3,'PRUEBAS DE NO AFECTACIÓN',1,1),
(4,'PRUEBAS DE ACEPTACIÓN',1,1),
(5,'PRUEBAS DE USUARIO',1,1),
(6,'SERVICIO DE AMBIENTACIÓN',1,1),
(7,'PROCESOS BATCH',1,1),
(8,'PRUEBAS FUNCIONALES Y NO AFECTACIÓN',1,1);

INSERT INTO `thge056_canal`
VALUES
(1,1,'MOVIL'),
(2,2,'ATM\'S'),
(3,3,'BCOM'),
(4,4,'EECC'),
(5,5,'NETCASH'),
(6,6,'TPV\'S');

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
(1,1,'BNC',1),
(2,2,'MEDIOS DE PAGO',2),
(3,3,'PRESTAMOS',3),
(4,4,'CUENTAS PERSONALES',4),
(5,5,'BMOVIL',5),
(6,6,'BCOM',6),
(7,7,'EECC',7);

INSERT INTO `thge005_estado`
VALUES
(1,'SIN TRAMITAR',1),
(2,'EN TRAMITE',1),
(3,'ALTA',1),
(4,'BAJA',1),
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
(54,'CERRADO',15);

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
(CD_TIPOLOGIA, CD_PRODUCTO, TP_COMPONENTE, NU_DIFICULTAD, NU_HRS_DIFICULTAD, NU_ANO, ST_ESTADO)
VALUES 
(1,'J01',0,0,0.00,2018,3),
(2,'J02',0,0,0.00,2018,3),
(3,'J03',0,0,0.00,2018,3),
(4,'J04',0,0,0.00,2018,3),
(5,'J05',0,0,0.00,2018,3),
(6,'J06',0,0,1.80,2018,3),
(7,'J07',0,0,0.00,2018,3),
(8,'J08',0,0,0.00,2018,3),
(9,'J09',0,0,0.00,2018,3),
(10,'J01',0,1,5.50,2018,3),
(11,'J02',0,1,9.50,2018,3),
(12,'J03',0,1,3.50,2018,3),
(13,'J04',0,1,3.00,2018,3),
(14,'J05',0,1,0.25,2018,3),
(15,'J06',0,1,4.50,2018,3),
(16,'J07',0,1,4.50,2018,3),
(17,'J08',0,1,2.00,2018,3),
(18,'J09',0,1,3.50,2018,3),
(19,'J01',0,2,8.50,2018,3),
(20,'J02',0,2,15.00,2018,3),
(21,'J03',0,2,7.50,2018,3),
(22,'J04',0,2,4.50,2018,3),
(23,'J05',0,2,0.25,2018,3),
(24,'J06',0,2,8.50,2018,3),
(25,'J07',0,2,7.50,2018,3),
(26,'J08',0,2,4.00,2018,3),
(27,'J09',0,2,7.50,2018,3),
(28,'J01',0,3,11.00,2018,3),
(29,'J02',0,3,22.00,2018,3),
(30,'J03',0,3,11.00,2018,3),
(31,'J04',0,3,8.00,2018,3),
(32,'J05',0,3,0.25,2018,3),
(33,'J06',0,3,13.00,2018,3),
(34,'J07',0,3,10.00,2018,3),
(35,'J08',0,3,6.00,2018,3),
(36,'J09',0,3,11.00,2018,3),
(37,'J01',0,4,17.00,2018,3),
(38,'J02',0,4,33.50,2018,3),
(39,'J03',0,4,14.00,2018,3),
(40,'J04',0,4,11.00,2018,3),
(41,'J05',0,4,0.25,2018,3),
(42,'J06',0,4,21.00,2018,3),
(43,'J07',0,4,14.00,2018,3),
(44,'J08',0,4,7.00,2018,3),
(45,'J09',0,4,15.00,2018,3),
(46,'J01',1,0,1.00,2018,3),
(47,'J02',1,0,1.00,2018,3),
(48,'J03',1,0,1.00,2018,3),
(49,'J04',1,0,1.00,2018,3),
(50,'J05',1,0,0.15,2018,3),
(51,'J06',1,0,1.00,2018,3),
(52,'J07',1,0,1.00,2018,3),
(53,'J08',1,0,0.15,2018,3),
(54,'J09',1,0,1.00,2018,3),
(55,'J01',1,1,3.00,2018,3),
(56,'J02',1,1,5.00,2018,3),
(57,'J03',1,1,2.00,2018,3),
(58,'J04',1,1,2.00,2018,3),
(59,'J05',1,1,0.15,2018,3),
(60,'J06',1,1,3.00,2018,3),
(61,'J07',1,1,3.00,2018,3),
(62,'J08',1,1,1.00,2018,3),
(63,'J09',1,1,2.00,2018,3),
(64,'J01',1,2,4.50,2018,3),
(65,'J02',1,2,8.50,2018,3),
(66,'J03',1,2,4.00,2018,3),
(67,'J04',1,2,3.00,2018,3),
(68,'J05',1,2,0.15,2018,3),
(69,'J06',1,2,5.00,2018,3),
(70,'J07',1,2,4.00,2018,3),
(71,'J08',1,2,2.00,2018,3),
(72,'J09',1,2,5.00,2018,3),
(73,'J01',1,3,7.50,2018,3),
(74,'J02',1,3,12.00,2018,3),
(75,'J03',1,3,6.00,2018,3),
(76,'J04',1,3,5.00,2018,3),
(77,'J05',1,3,0.15,2018,3),
(78,'J06',1,3,8.50,2018,3),
(79,'J07',1,3,6.50,2018,3),
(80,'J08',1,3,3.00,2018,3),
(81,'J09',1,3,7.50,2018,3),
(82,'J01',1,4,12.00,2018,3),
(83,'J02',1,4,15.50,2018,3),
(84,'J03',1,4,7.50,2018,3),
(85,'J04',1,4,7.00,2018,3),
(86,'J05',1,4,0.15,2018,3),
(87,'J06',1,4,13.00,2018,3),
(88,'J07',1,4,9.50,2018,3),
(89,'J08',1,4,5.00,2018,3),
(90,'J09',1,4,11.00,2018,3),
(91,'HA1',0,0,0.00,2018,3),
(92,'HB1',0,0,0.00,2018,3),
(93,'HB2',0,0,0.00,2018,3),
(94,'HB3',0,0,0.00,2018,3),
(95,'HB4',0,0,0.00,2018,3),
(96,'HC1',0,0,0.00,2018,3),
(97,'HJ1',0,0,0.00,2018,3),
(98,'HM1',0,0,0.00,2018,3),
(99,'HO1',0,0,0.00,2018,3),
(100,'HO2',0,0,0.00,2018,3),
(101,'HO3',0,0,0.00,2018,3),
(102,'HO4',0,0,0.00,2018,3),
(103,'HR1',0,0,0.00,2018,3),
(104,'HR2',0,0,0.00,2018,3),
(105,'HR3',0,0,0.00,2018,3),
(106,'HA1',0,1,0.00,2018,3),
(107,'HB1',0,1,11.00,2018,3),
(108,'HB2',0,1,10.00,2018,3),
(109,'HB3',0,1,11.00,2018,3),
(110,'HB4',0,1,12.00,2018,3),
(111,'HC1',0,1,0.50,2018,3),
(112,'HJ1',0,1,2.00,2018,3),
(113,'HM1',0,1,1.00,2018,3),
(114,'HO1',0,1,11.00,2018,3),
(115,'HO2',0,1,10.00,2018,3),
(116,'HO3',0,1,12.00,2018,3),
(117,'HO4',0,1,12.00,2018,3),
(118,'HR1',0,1,10.00,2018,3),
(119,'HR2',0,1,11.00,2018,3),
(120,'HR3',0,1,13.00,2018,3),
(121,'HA1',0,2,0.00,2018,3),
(122,'HB1',0,2,20.00,2018,3),
(123,'HB2',0,2,19.00,2018,3),
(124,'HB3',0,2,19.00,2018,3),
(125,'HB4',0,2,19.00,2018,3),
(126,'HC1',0,2,1.00,2018,3),
(127,'HJ1',0,2,5.00,2018,3),
(128,'HM1',0,2,2.00,2018,3),
(129,'HO1',0,2,18.00,2018,3),
(130,'HO2',0,2,19.00,2018,3),
(131,'HO3',0,2,20.00,2018,3),
(132,'HO4',0,2,20.00,2018,3),
(133,'HR1',0,2,18.00,2018,3),
(134,'HR2',0,2,20.00,2018,3),
(135,'HR3',0,2,20.00,2018,3),
(136,'HA1',0,3,0.00,2018,3),
(137,'HB1',0,3,28.00,2018,3),
(138,'HB2',0,3,25.00,2018,3),
(139,'HB3',0,3,28.00,2018,3),
(140,'HB4',0,3,27.00,2018,3),
(141,'HC1',0,3,1.50,2018,3),
(142,'HJ1',0,3,8.00,2018,3),
(143,'HM1',0,3,3.00,2018,3),
(144,'HO1',0,3,23.00,2018,3),
(145,'HO2',0,3,26.00,2018,3),
(146,'HO3',0,3,28.00,2018,3),
(147,'HO4',0,3,27.00,2018,3),
(148,'HR1',0,3,25.00,2018,3),
(149,'HR2',0,3,27.00,2018,3),
(150,'HR3',0,3,29.00,2018,3),
(151,'HA1',0,4,0.00,2018,3),
(152,'HB1',0,4,37.00,2018,3),
(153,'HB2',0,4,32.00,2018,3),
(154,'HB3',0,4,34.00,2018,3),
(155,'HB4',0,4,33.00,2018,3),
(156,'HC1',0,4,2.00,2018,3),
(157,'HJ1',0,4,11.00,2018,3),
(158,'HM1',0,4,4.00,2018,3),
(159,'HO1',0,4,31.00,2018,3),
(160,'HO2',0,4,33.00,2018,3),
(161,'HO3',0,4,35.00,2018,3),
(162,'HO4',0,4,37.00,2018,3),
(163,'HR1',0,4,33.00,2018,3),
(164,'HR2',0,4,35.00,2018,3),
(165,'HR3',0,4,36.00,2018,3),
(166,'HA1',1,0,0.00,2018,3),
(167,'HB1',1,0,1.00,2018,3),
(168,'HB2',1,0,1.00,2018,3),
(169,'HB3',1,0,1.00,2018,3),
(170,'HB4',1,0,1.00,2018,3),
(171,'HC1',1,0,0.00,2018,3),
(172,'HJ1',1,0,0.00,2018,3),
(173,'HM1',1,0,0.00,2018,3),
(174,'HO1',1,0,1.00,2018,3),
(175,'HO2',1,0,1.00,2018,3),
(176,'HO3',1,0,1.00,2018,3),
(177,'HO4',1,0,1.00,2018,3),
(178,'HR1',1,0,1.00,2018,3),
(179,'HR2',1,0,1.00,2018,3),
(180,'HR3',1,0,1.00,2018,3),
(181,'HA1',1,1,0.00,2018,3),
(182,'HB1',1,1,4.50,2018,3),
(183,'HB2',1,1,4.50,2018,3),
(184,'HB3',1,1,5.50,2018,3),
(185,'HB4',1,1,6.50,2018,3),
(186,'HC1',1,1,0.00,2018,3),
(187,'HJ1',1,1,2.00,2018,3),
(188,'HM1',1,1,0.00,2018,3),
(189,'HO1',1,1,5.50,2018,3),
(190,'HO2',1,1,5.50,2018,3),
(191,'HO3',1,1,7.00,2018,3),
(192,'HO4',1,1,6.50,2018,3),
(193,'HR1',1,1,5.50,2018,3),
(194,'HR2',1,1,6.50,2018,3),
(195,'HR3',1,1,6.50,2018,3),
(196,'HA1',1,2,0.00,2018,3),
(197,'HB1',1,2,9.00,2018,3),
(198,'HB2',1,2,9.00,2018,3),
(199,'HB3',1,2,9.00,2018,3),
(200,'HB4',1,2,11.00,2018,3),
(201,'HC1',1,2,0.00,2018,3),
(202,'HJ1',1,2,4.00,2018,3),
(203,'HM1',1,2,0.00,2018,3),
(204,'HO1',1,2,10.00,2018,3),
(205,'HO2',1,2,10.00,2018,3),
(206,'HO3',1,2,11.00,2018,3),
(207,'HO4',1,2,11.00,2018,3),
(208,'HR1',1,2,10.00,2018,3),
(209,'HR2',1,2,11.00,2018,3),
(210,'HR3',1,2,11.00,2018,3),
(211,'HA1',1,3,0.00,2018,3),
(212,'HB1',1,3,14.00,2018,3),
(213,'HB2',1,3,13.00,2018,3),
(214,'HB3',1,3,14.00,2018,3),
(215,'HB4',1,3,15.00,2018,3),
(216,'HC1',1,3,0.00,2018,3),
(217,'HJ1',1,3,6.00,2018,3),
(218,'HM1',1,3,0.00,2018,3),
(219,'HO1',1,3,14.00,2018,3),
(220,'HO2',1,3,15.00,2018,3),
(221,'HO3',1,3,18.00,2018,3),
(222,'HO4',1,3,16.00,2018,3),
(223,'HR1',1,3,15.00,2018,3),
(224,'HR2',1,3,16.00,2018,3),
(225,'HR3',1,3,17.00,2018,3),
(226,'HA1',1,4,0.00,2018,3),
(227,'HB1',1,4,20.00,2018,3),
(228,'HB2',1,4,18.00,2018,3),
(229,'HB3',1,4,19.00,2018,3),
(230,'HB4',1,4,19.00,2018,3),
(231,'HC1',1,4,0.00,2018,3),
(232,'HJ1',1,4,7.00,2018,3),
(233,'HM1',1,4,0.00,2018,3),
(234,'HO1',1,4,19.00,2018,3),
(235,'HO2',1,4,20.00,2018,3),
(236,'HO3',1,4,23.00,2018,3),
(237,'HO4',1,4,21.00,2018,3),
(238,'HR1',1,4,20.00,2018,3),
(239,'HR2',1,4,22.00,2018,3),
(240,'HR3',1,4,23.00,2018,3),
(241,'N01',0,0,0.00,2018,3),
(242,'N02',0,0,0.00,2018,3),
(243,'N03',0,0,0.00,2018,3),
(244,'N04',0,0,0.00,2018,3),
(245,'N05',0,0,0.00,2018,3),
(246,'N06',0,0,0.00,2018,3),
(247,'N07',0,0,0.00,2018,3),
(248,'N08',0,0,0.00,2018,3),
(249,'N01',0,1,6.50,2018,3),
(250,'N02',0,1,11.50,2018,3),
(251,'N03',0,1,5.00,2018,3),
(252,'N04',0,1,4.00,2018,3),
(253,'N05',0,1,5.00,2018,3),
(254,'N06',0,1,0.00,2018,3),
(255,'N07',0,1,9.00,2018,3),
(256,'N08',0,1,2.00,2018,3),
(257,'N01',0,2,13.00,2018,3),
(258,'N02',0,2,18.50,2018,3),
(259,'N03',0,2,8.00,2018,3),
(260,'N04',0,2,7.50,2018,3),
(261,'N05',0,2,7.50,2018,3),
(262,'N06',0,2,0.00,2018,3),
(263,'N07',0,2,15.00,2018,3),
(264,'N08',0,2,4.00,2018,3),
(265,'N01',0,3,18.50,2018,3),
(266,'N02',0,3,27.00,2018,3),
(267,'N03',0,3,13.00,2018,3),
(268,'N04',0,3,11.00,2018,3),
(269,'N05',0,3,10.50,2018,3),
(270,'N06',0,3,0.00,2018,3),
(271,'N07',0,3,21.00,2018,3),
(272,'N08',0,3,6.00,2018,3),
(273,'N01',0,4,29.00,2018,3),
(274,'N02',0,4,36.00,2018,3),
(275,'N03',0,4,20.00,2018,3),
(276,'N04',0,4,15.00,2018,3),
(277,'N05',0,4,14.00,2018,3),
(278,'N06',0,4,0.00,2018,3),
(279,'N07',0,4,29.00,2018,3),
(280,'N08',0,4,9.00,2018,3),
(281,'N01',1,0,1.00,2018,3),
(282,'N02',1,0,1.00,2018,3),
(283,'N03',1,0,1.00,2018,3),
(284,'N04',1,0,1.00,2018,3),
(285,'N05',1,0,1.00,2018,3),
(286,'N06',1,0,0.00,2018,3),
(287,'N07',1,0,1.00,2018,3),
(288,'N08',1,0,1.00,2018,3),
(289,'N01',1,1,4.00,2018,3),
(290,'N02',1,1,7.00,2018,3),
(291,'N03',1,1,3.00,2018,3),
(292,'N04',1,1,2.00,2018,3),
(293,'N05',1,1,3.00,2018,3),
(294,'N06',1,1,0.00,2018,3),
(295,'N07',1,1,6.00,2018,3),
(296,'N08',1,1,2.00,2018,3),
(297,'N01',1,2,8.50,2018,3),
(298,'N02',1,2,11.50,2018,3),
(299,'N03',1,2,4.50,2018,3),
(300,'N04',1,2,4.50,2018,3),
(301,'N05',1,2,4.00,2018,3),
(302,'N06',1,2,0.00,2018,3),
(303,'N07',1,2,9.00,2018,3),
(304,'N08',1,2,4.00,2018,3),
(305,'N01',1,3,13.00,2018,3),
(306,'N02',1,3,16.00,2018,3),
(307,'N03',1,3,8.00,2018,3),
(308,'N04',1,3,7.50,2018,3),
(309,'N05',1,3,6.00,2018,3),
(310,'N06',1,3,0.00,2018,3),
(311,'N07',1,3,13.00,2018,3),
(312,'N08',1,3,6.00,2018,3),
(313,'N01',1,4,19.50,2018,3),
(314,'N02',1,4,24.50,2018,3),
(315,'N03',1,4,13.00,2018,3),
(316,'N04',1,4,11.00,2018,3),
(317,'N05',1,4,10.00,2018,3),
(318,'N06',1,4,0.00,2018,3),
(319,'N07',1,4,19.00,2018,3),
(320,'N08',1,4,9.00,2018,3);

//TABLA 010 NIVELES
INSERT INTO gestion_factoria.thge010_nivel (gestion_factoria.thge010_nivel.CD_NIVEL,gestion_factoria.thge010_nivel.NB_NIVEL,gestion_factoria.thge010_nivel.CD_TIPO_NIVEL,gestion_factoria.thge010_nivel.CD_USUARIO_RESP) VALUES(1,"ADQUIRIENTE Y BANCA ELECTRÓNICA","1","XM58349");
INSERT INTO gestion_factoria.thge010_nivel (gestion_factoria.thge010_nivel.CD_NIVEL,gestion_factoria.thge010_nivel.NB_NIVEL,gestion_factoria.thge010_nivel.CD_TIPO_NIVEL,gestion_factoria.thge010_nivel.CD_USUARIO_RESP) VALUES(2,"ANS Y FACTORIAS","1","XM58350");
INSERT INTO gestion_factoria.thge010_nivel (gestion_factoria.thge010_nivel.CD_NIVEL,gestion_factoria.thge010_nivel.NB_NIVEL,gestion_factoria.thge010_nivel.CD_TIPO_NIVEL,gestion_factoria.thge010_nivel.CD_USUARIO_RESP) VALUES(3,"ARCHITECTURE ENGINEERING","1","XM58351");
INSERT INTO gestion_factoria.thge010_nivel (gestion_factoria.thge010_nivel.CD_NIVEL,gestion_factoria.thge010_nivel.NB_NIVEL,gestion_factoria.thge010_nivel.CD_TIPO_NIVEL,gestion_factoria.thge010_nivel.CD_USUARIO_RESP) VALUES(4,"AUTOSERVICIO","1","XM58352");
INSERT INTO gestion_factoria.thge010_nivel (gestion_factoria.thge010_nivel.CD_NIVEL,gestion_factoria.thge010_nivel.NB_NIVEL,gestion_factoria.thge010_nivel.CD_TIPO_NIVEL,gestion_factoria.thge010_nivel.CD_USUARIO_RESP) VALUES(5,"BANCA MÓVIL","1","XM58353");
INSERT INTO gestion_factoria.thge010_nivel (gestion_factoria.thge010_nivel.CD_NIVEL,gestion_factoria.thge010_nivel.NB_NIVEL,gestion_factoria.thge010_nivel.CD_TIPO_NIVEL,gestion_factoria.thge010_nivel.CD_USUARIO_RESP) VALUES(6,"BCA FÁCIL Y REL AUTORIDADES","1","XM58354");
INSERT INTO gestion_factoria.thge010_nivel (gestion_factoria.thge010_nivel.CD_NIVEL,gestion_factoria.thge010_nivel.NB_NIVEL,gestion_factoria.thge010_nivel.CD_TIPO_NIVEL,gestion_factoria.thge010_nivel.CD_USUARIO_RESP) VALUES(7,"BPM","1","XM58355");
INSERT INTO gestion_factoria.thge010_nivel (gestion_factoria.thge010_nivel.CD_NIVEL,gestion_factoria.thge010_nivel.NB_NIVEL,gestion_factoria.thge010_nivel.CD_TIPO_NIVEL,gestion_factoria.thge010_nivel.CD_USUARIO_RESP) VALUES(8,"C&IB","1","XM58356");
INSERT INTO gestion_factoria.thge010_nivel (gestion_factoria.thge010_nivel.CD_NIVEL,gestion_factoria.thge010_nivel.NB_NIVEL,gestion_factoria.thge010_nivel.CD_TIPO_NIVEL,gestion_factoria.thge010_nivel.CD_USUARIO_RESP) VALUES(9,"CANALES ATENDIDOS","1","XM58357");
INSERT INTO gestion_factoria.thge010_nivel (gestion_factoria.thge010_nivel.CD_NIVEL,gestion_factoria.thge010_nivel.NB_NIVEL,gestion_factoria.thge010_nivel.CD_TIPO_NIVEL,gestion_factoria.thge010_nivel.CD_USUARIO_RESP) VALUES(10,"CANALES DIGITALES","1","XM58358");
INSERT INTO gestion_factoria.thge010_nivel (gestion_factoria.thge010_nivel.CD_NIVEL,gestion_factoria.thge010_nivel.NB_NIVEL,gestion_factoria.thge010_nivel.CD_TIPO_NIVEL,gestion_factoria.thge010_nivel.CD_USUARIO_RESP) VALUES(11,"CONTACT CENTER","1","XM58359");
INSERT INTO gestion_factoria.thge010_nivel (gestion_factoria.thge010_nivel.CD_NIVEL,gestion_factoria.thge010_nivel.NB_NIVEL,gestion_factoria.thge010_nivel.CD_TIPO_NIVEL,gestion_factoria.thge010_nivel.CD_USUARIO_RESP) VALUES(12,"CORE BANKING ACTIVO Y PASIVO","1","XM58360");
INSERT INTO gestion_factoria.thge010_nivel (gestion_factoria.thge010_nivel.CD_NIVEL,gestion_factoria.thge010_nivel.NB_NIVEL,gestion_factoria.thge010_nivel.CD_TIPO_NIVEL,gestion_factoria.thge010_nivel.CD_USUARIO_RESP) VALUES(13,"DESARROLLO COMERCIAL","1","XM58361");
INSERT INTO gestion_factoria.thge010_nivel (gestion_factoria.thge010_nivel.CD_NIVEL,gestion_factoria.thge010_nivel.NB_NIVEL,gestion_factoria.thge010_nivel.CD_TIPO_NIVEL,gestion_factoria.thge010_nivel.CD_USUARIO_RESP) VALUES(14,"PBAS CUENTAS PERSONALES","1","XM58362");
INSERT INTO gestion_factoria.thge010_nivel (gestion_factoria.thge010_nivel.CD_NIVEL,gestion_factoria.thge010_nivel.NB_NIVEL,gestion_factoria.thge010_nivel.CD_TIPO_NIVEL,gestion_factoria.thge010_nivel.CD_USUARIO_RESP) VALUES(15,"PLATAFORMA COMERCIAL","1","XM58363");
INSERT INTO gestion_factoria.thge010_nivel (gestion_factoria.thge010_nivel.CD_NIVEL,gestion_factoria.thge010_nivel.NB_NIVEL,gestion_factoria.thge010_nivel.CD_TIPO_NIVEL,gestion_factoria.thge010_nivel.CD_USUARIO_RESP) VALUES(16,"SECURITY ARCHITECTURE","1","XM58364");
INSERT INTO gestion_factoria.thge010_nivel (gestion_factoria.thge010_nivel.CD_NIVEL,gestion_factoria.thge010_nivel.NB_NIVEL,gestion_factoria.thge010_nivel.CD_TIPO_NIVEL,gestion_factoria.thge010_nivel.CD_USUARIO_RESP) VALUES(17,"SEGUROS","1","XM58365");
INSERT INTO gestion_factoria.thge010_nivel (gestion_factoria.thge010_nivel.CD_NIVEL,gestion_factoria.thge010_nivel.NB_NIVEL,gestion_factoria.thge010_nivel.CD_TIPO_NIVEL,gestion_factoria.thge010_nivel.CD_USUARIO_RESP) VALUES(18,"SISTEMAS BEYG","1","XM58366");
INSERT INTO gestion_factoria.thge010_nivel (gestion_factoria.thge010_nivel.CD_NIVEL,gestion_factoria.thge010_nivel.NB_NIVEL,gestion_factoria.thge010_nivel.CD_TIPO_NIVEL,gestion_factoria.thge010_nivel.CD_USUARIO_RESP) VALUES(19,"SISTEMAS HOLDING","1","XM58367");
INSERT INTO gestion_factoria.thge010_nivel (gestion_factoria.thge010_nivel.CD_NIVEL,gestion_factoria.thge010_nivel.NB_NIVEL,gestion_factoria.thge010_nivel.CD_TIPO_NIVEL,gestion_factoria.thge010_nivel.CD_USUARIO_RESP) VALUES(20,"TRANSFORMATION SOLUTIONS","1","XM58368");
INSERT INTO gestion_factoria.thge010_nivel (gestion_factoria.thge010_nivel.CD_NIVEL,gestion_factoria.thge010_nivel.NB_NIVEL,gestion_factoria.thge010_nivel.CD_TIPO_NIVEL,gestion_factoria.thge010_nivel.CD_USUARIO_RESP, gestion_factoria.thge010_nivel.CD_NIVEL_SUPERIOR) VALUES(21,"INVENTARIOS E INST. TPVS Y BE","2","XM58369",1);
INSERT INTO gestion_factoria.thge010_nivel (gestion_factoria.thge010_nivel.CD_NIVEL,gestion_factoria.thge010_nivel.NB_NIVEL,gestion_factoria.thge010_nivel.CD_TIPO_NIVEL,gestion_factoria.thge010_nivel.CD_USUARIO_RESP, gestion_factoria.thge010_nivel.CD_NIVEL_SUPERIOR) VALUES(22,"COA","2","XM58370",2);
INSERT INTO gestion_factoria.thge010_nivel (gestion_factoria.thge010_nivel.CD_NIVEL,gestion_factoria.thge010_nivel.NB_NIVEL,gestion_factoria.thge010_nivel.CD_TIPO_NIVEL,gestion_factoria.thge010_nivel.CD_USUARIO_RESP, gestion_factoria.thge010_nivel.CD_NIVEL_SUPERIOR) VALUES(23,"ANS FRONTS","2","XM58371",2);
INSERT INTO gestion_factoria.thge010_nivel (gestion_factoria.thge010_nivel.CD_NIVEL,gestion_factoria.thge010_nivel.NB_NIVEL,gestion_factoria.thge010_nivel.CD_TIPO_NIVEL,gestion_factoria.thge010_nivel.CD_USUARIO_RESP, gestion_factoria.thge010_nivel.CD_NIVEL_SUPERIOR) VALUES(24,"ANS INFORMACIONAL","2","XM58372",2);
INSERT INTO gestion_factoria.thge010_nivel (gestion_factoria.thge010_nivel.CD_NIVEL,gestion_factoria.thge010_nivel.NB_NIVEL,gestion_factoria.thge010_nivel.CD_TIPO_NIVEL,gestion_factoria.thge010_nivel.CD_USUARIO_RESP, gestion_factoria.thge010_nivel.CD_NIVEL_SUPERIOR) VALUES(25,"ANS MEDIOS DE PAGO","2","XM58373",2);
INSERT INTO gestion_factoria.thge010_nivel (gestion_factoria.thge010_nivel.CD_NIVEL,gestion_factoria.thge010_nivel.NB_NIVEL,gestion_factoria.thge010_nivel.CD_TIPO_NIVEL,gestion_factoria.thge010_nivel.CD_USUARIO_RESP, gestion_factoria.thge010_nivel.CD_NIVEL_SUPERIOR) VALUES(26,"ANS PRÉSTAMOS","2","XM58374",2);
INSERT INTO gestion_factoria.thge010_nivel (gestion_factoria.thge010_nivel.CD_NIVEL,gestion_factoria.thge010_nivel.NB_NIVEL,gestion_factoria.thge010_nivel.CD_TIPO_NIVEL,gestion_factoria.thge010_nivel.CD_USUARIO_RESP, gestion_factoria.thge010_nivel.CD_NIVEL_SUPERIOR) VALUES(27,"MANTENIMIENTO Y FACTORIAS","2","XM58375",2);
INSERT INTO gestion_factoria.thge010_nivel (gestion_factoria.thge010_nivel.CD_NIVEL,gestion_factoria.thge010_nivel.NB_NIVEL,gestion_factoria.thge010_nivel.CD_TIPO_NIVEL,gestion_factoria.thge010_nivel.CD_USUARIO_RESP, gestion_factoria.thge010_nivel.CD_NIVEL_SUPERIOR) VALUES(28,"BÓVEDA ELECT. ACLARACIONES","2","XM58376",3);
INSERT INTO gestion_factoria.thge010_nivel (gestion_factoria.thge010_nivel.CD_NIVEL,gestion_factoria.thge010_nivel.NB_NIVEL,gestion_factoria.thge010_nivel.CD_TIPO_NIVEL,gestion_factoria.thge010_nivel.CD_USUARIO_RESP, gestion_factoria.thge010_nivel.CD_NIVEL_SUPERIOR) VALUES(29,"ARCHITECTURE ENGINEERING","2","XM58377",3);
INSERT INTO gestion_factoria.thge010_nivel (gestion_factoria.thge010_nivel.CD_NIVEL,gestion_factoria.thge010_nivel.NB_NIVEL,gestion_factoria.thge010_nivel.CD_TIPO_NIVEL,gestion_factoria.thge010_nivel.CD_USUARIO_RESP, gestion_factoria.thge010_nivel.CD_NIVEL_SUPERIOR) VALUES(30,"BPM","2","XM58378",3);
INSERT INTO gestion_factoria.thge010_nivel (gestion_factoria.thge010_nivel.CD_NIVEL,gestion_factoria.thge010_nivel.NB_NIVEL,gestion_factoria.thge010_nivel.CD_TIPO_NIVEL,gestion_factoria.thge010_nivel.CD_USUARIO_RESP, gestion_factoria.thge010_nivel.CD_NIVEL_SUPERIOR) VALUES(31,"SERVICIOS","2","XM58379",3);
INSERT INTO gestion_factoria.thge010_nivel (gestion_factoria.thge010_nivel.CD_NIVEL,gestion_factoria.thge010_nivel.NB_NIVEL,gestion_factoria.thge010_nivel.CD_TIPO_NIVEL,gestion_factoria.thge010_nivel.CD_USUARIO_RESP, gestion_factoria.thge010_nivel.CD_NIVEL_SUPERIOR) VALUES(32,"TECNOLOGÍA AUTOSERVICIO","2","XM58380",4);
INSERT INTO gestion_factoria.thge010_nivel (gestion_factoria.thge010_nivel.CD_NIVEL,gestion_factoria.thge010_nivel.NB_NIVEL,gestion_factoria.thge010_nivel.CD_TIPO_NIVEL,gestion_factoria.thge010_nivel.CD_USUARIO_RESP, gestion_factoria.thge010_nivel.CD_NIVEL_SUPERIOR) VALUES(33,"CAJEROS Y PRACTICAJAS","2","XM58381",4);
INSERT INTO gestion_factoria.thge010_nivel (gestion_factoria.thge010_nivel.CD_NIVEL,gestion_factoria.thge010_nivel.NB_NIVEL,gestion_factoria.thge010_nivel.CD_TIPO_NIVEL,gestion_factoria.thge010_nivel.CD_USUARIO_RESP, gestion_factoria.thge010_nivel.CD_NIVEL_SUPERIOR) VALUES(34,"SEGURIDAD ATMS Y DISTRIBUCIÓN","2","XM58382",4);
INSERT INTO gestion_factoria.thge010_nivel (gestion_factoria.thge010_nivel.CD_NIVEL,gestion_factoria.thge010_nivel.NB_NIVEL,gestion_factoria.thge010_nivel.CD_TIPO_NIVEL,gestion_factoria.thge010_nivel.CD_USUARIO_RESP, gestion_factoria.thge010_nivel.CD_NIVEL_SUPERIOR) VALUES(35,"AUTOSERVICIO SOLUCIONES DIGITALES","2","XM58383",4);
INSERT INTO gestion_factoria.thge010_nivel (gestion_factoria.thge010_nivel.CD_NIVEL,gestion_factoria.thge010_nivel.NB_NIVEL,gestion_factoria.thge010_nivel.CD_TIPO_NIVEL,gestion_factoria.thge010_nivel.CD_USUARIO_RESP, gestion_factoria.thge010_nivel.CD_NIVEL_SUPERIOR) VALUES(36,"BANCA MÓVIL","2","XM58384",5);
INSERT INTO gestion_factoria.thge010_nivel (gestion_factoria.thge010_nivel.CD_NIVEL,gestion_factoria.thge010_nivel.NB_NIVEL,gestion_factoria.thge010_nivel.CD_TIPO_NIVEL,gestion_factoria.thge010_nivel.CD_USUARIO_RESP, gestion_factoria.thge010_nivel.CD_NIVEL_SUPERIOR) VALUES(37,"BANCOMER SMS Y ALERTAS","2","XM58385",5);
INSERT INTO gestion_factoria.thge010_nivel (gestion_factoria.thge010_nivel.CD_NIVEL,gestion_factoria.thge010_nivel.NB_NIVEL,gestion_factoria.thge010_nivel.CD_TIPO_NIVEL,gestion_factoria.thge010_nivel.CD_USUARIO_RESP, gestion_factoria.thge010_nivel.CD_NIVEL_SUPERIOR) VALUES(38,"APPS VERTICALES","2","XM58386",5);
INSERT INTO gestion_factoria.thge010_nivel (gestion_factoria.thge010_nivel.CD_NIVEL,gestion_factoria.thge010_nivel.NB_NIVEL,gestion_factoria.thge010_nivel.CD_TIPO_NIVEL,gestion_factoria.thge010_nivel.CD_USUARIO_RESP, gestion_factoria.thge010_nivel.CD_NIVEL_SUPERIOR) VALUES(39,"APPS INFORMATIVOS","2","XM58387",5);
INSERT INTO gestion_factoria.thge010_nivel (gestion_factoria.thge010_nivel.CD_NIVEL,gestion_factoria.thge010_nivel.NB_NIVEL,gestion_factoria.thge010_nivel.CD_TIPO_NIVEL,gestion_factoria.thge010_nivel.CD_USUARIO_RESP, gestion_factoria.thge010_nivel.CD_NIVEL_SUPERIOR) VALUES(40,"BCA FÁCIL Y REL AUTORIDADES","2","XM58388",6);
INSERT INTO gestion_factoria.thge010_nivel (gestion_factoria.thge010_nivel.CD_NIVEL,gestion_factoria.thge010_nivel.NB_NIVEL,gestion_factoria.thge010_nivel.CD_TIPO_NIVEL,gestion_factoria.thge010_nivel.CD_USUARIO_RESP, gestion_factoria.thge010_nivel.CD_NIVEL_SUPERIOR) VALUES(41,"PBAS BPM","2","XM58389",7);
INSERT INTO gestion_factoria.thge010_nivel (gestion_factoria.thge010_nivel.CD_NIVEL,gestion_factoria.thge010_nivel.NB_NIVEL,gestion_factoria.thge010_nivel.CD_TIPO_NIVEL,gestion_factoria.thge010_nivel.CD_USUARIO_RESP, gestion_factoria.thge010_nivel.CD_NIVEL_SUPERIOR) VALUES(42,"OPERACIONES Y RIESGOS","2","XM58390",8);
INSERT INTO gestion_factoria.thge010_nivel (gestion_factoria.thge010_nivel.CD_NIVEL,gestion_factoria.thge010_nivel.NB_NIVEL,gestion_factoria.thge010_nivel.CD_TIPO_NIVEL,gestion_factoria.thge010_nivel.CD_USUARIO_RESP, gestion_factoria.thge010_nivel.CD_NIVEL_SUPERIOR) VALUES(43,"PLATAFORMA C&IB","2","XM58391",8);
INSERT INTO gestion_factoria.thge010_nivel (gestion_factoria.thge010_nivel.CD_NIVEL,gestion_factoria.thge010_nivel.NB_NIVEL,gestion_factoria.thge010_nivel.CD_TIPO_NIVEL,gestion_factoria.thge010_nivel.CD_USUARIO_RESP, gestion_factoria.thge010_nivel.CD_NIVEL_SUPERIOR) VALUES(44,"EE CC","2","XM58392",9);
INSERT INTO gestion_factoria.thge010_nivel (gestion_factoria.thge010_nivel.CD_NIVEL,gestion_factoria.thge010_nivel.NB_NIVEL,gestion_factoria.thge010_nivel.CD_TIPO_NIVEL,gestion_factoria.thge010_nivel.CD_USUARIO_RESP, gestion_factoria.thge010_nivel.CD_NIVEL_SUPERIOR) VALUES(45,"PROCESOS Y CONTRATACIÓN","2","XM58393",9);
INSERT INTO gestion_factoria.thge010_nivel (gestion_factoria.thge010_nivel.CD_NIVEL,gestion_factoria.thge010_nivel.NB_NIVEL,gestion_factoria.thge010_nivel.CD_TIPO_NIVEL,gestion_factoria.thge010_nivel.CD_USUARIO_RESP, gestion_factoria.thge010_nivel.CD_NIVEL_SUPERIOR) VALUES(46,"AA CC / QA","2","XM58394",9);
INSERT INTO gestion_factoria.thge010_nivel (gestion_factoria.thge010_nivel.CD_NIVEL,gestion_factoria.thge010_nivel.NB_NIVEL,gestion_factoria.thge010_nivel.CD_TIPO_NIVEL,gestion_factoria.thge010_nivel.CD_USUARIO_RESP, gestion_factoria.thge010_nivel.CD_NIVEL_SUPERIOR) VALUES(47,"TF FRONTS E INTRANET","2","XM58395",9);
INSERT INTO gestion_factoria.thge010_nivel (gestion_factoria.thge010_nivel.CD_NIVEL,gestion_factoria.thge010_nivel.NB_NIVEL,gestion_factoria.thge010_nivel.CD_TIPO_NIVEL,gestion_factoria.thge010_nivel.CD_USUARIO_RESP, gestion_factoria.thge010_nivel.CD_NIVEL_SUPERIOR) VALUES(48,"NUEVAS SOLUCIONES QA","2","XM58396",9);
INSERT INTO gestion_factoria.thge010_nivel (gestion_factoria.thge010_nivel.CD_NIVEL,gestion_factoria.thge010_nivel.NB_NIVEL,gestion_factoria.thge010_nivel.CD_TIPO_NIVEL,gestion_factoria.thge010_nivel.CD_USUARIO_RESP, gestion_factoria.thge010_nivel.CD_NIVEL_SUPERIOR) VALUES(49,"EXTRANET Y BANCA CORRESPONSAL","2","XM58397",10);
INSERT INTO gestion_factoria.thge010_nivel (gestion_factoria.thge010_nivel.CD_NIVEL,gestion_factoria.thge010_nivel.NB_NIVEL,gestion_factoria.thge010_nivel.CD_TIPO_NIVEL,gestion_factoria.thge010_nivel.CD_USUARIO_RESP, gestion_factoria.thge010_nivel.CD_NIVEL_SUPERIOR) VALUES(50,"INTERNET PERSONAS FÍSICAS Y PORTALES","2","XM58398",10);
INSERT INTO gestion_factoria.thge010_nivel (gestion_factoria.thge010_nivel.CD_NIVEL,gestion_factoria.thge010_nivel.NB_NIVEL,gestion_factoria.thge010_nivel.CD_TIPO_NIVEL,gestion_factoria.thge010_nivel.CD_USUARIO_RESP, gestion_factoria.thge010_nivel.CD_NIVEL_SUPERIOR) VALUES(51,"CANALES ELECTRÓNICOS DE EMPRESAS","2","XM58399",10);
INSERT INTO gestion_factoria.thge010_nivel (gestion_factoria.thge010_nivel.CD_NIVEL,gestion_factoria.thge010_nivel.NB_NIVEL,gestion_factoria.thge010_nivel.CD_TIPO_NIVEL,gestion_factoria.thge010_nivel.CD_USUARIO_RESP, gestion_factoria.thge010_nivel.CD_NIVEL_SUPERIOR) VALUES(52,"CG, DOSIFICADORES","2","XM58400",10);
INSERT INTO gestion_factoria.thge010_nivel (gestion_factoria.thge010_nivel.CD_NIVEL,gestion_factoria.thge010_nivel.NB_NIVEL,gestion_factoria.thge010_nivel.CD_TIPO_NIVEL,gestion_factoria.thge010_nivel.CD_USUARIO_RESP, gestion_factoria.thge010_nivel.CD_NIVEL_SUPERIOR) VALUES(53,"ACLARACIONES","2","XM58401",11);
INSERT INTO gestion_factoria.thge010_nivel (gestion_factoria.thge010_nivel.CD_NIVEL,gestion_factoria.thge010_nivel.NB_NIVEL,gestion_factoria.thge010_nivel.CD_TIPO_NIVEL,gestion_factoria.thge010_nivel.CD_USUARIO_RESP, gestion_factoria.thge010_nivel.CD_NIVEL_SUPERIOR) VALUES(54,"PORTAL DE VOZ","2","XM58402",11);
INSERT INTO gestion_factoria.thge010_nivel (gestion_factoria.thge010_nivel.CD_NIVEL,gestion_factoria.thge010_nivel.NB_NIVEL,gestion_factoria.thge010_nivel.CD_TIPO_NIVEL,gestion_factoria.thge010_nivel.CD_USUARIO_RESP, gestion_factoria.thge010_nivel.CD_NIVEL_SUPERIOR) VALUES(55,"PASIVO","2","XM58403",12);
INSERT INTO gestion_factoria.thge010_nivel (gestion_factoria.thge010_nivel.CD_NIVEL,gestion_factoria.thge010_nivel.NB_NIVEL,gestion_factoria.thge010_nivel.CD_TIPO_NIVEL,gestion_factoria.thge010_nivel.CD_USUARIO_RESP, gestion_factoria.thge010_nivel.CD_NIVEL_SUPERIOR) VALUES(56,"ACTIVO PRÉSTAMOS","2","XM58404",12);
INSERT INTO gestion_factoria.thge010_nivel (gestion_factoria.thge010_nivel.CD_NIVEL,gestion_factoria.thge010_nivel.NB_NIVEL,gestion_factoria.thge010_nivel.CD_TIPO_NIVEL,gestion_factoria.thge010_nivel.CD_USUARIO_RESP, gestion_factoria.thge010_nivel.CD_NIVEL_SUPERIOR) VALUES(57,"SERVICIOS BANCA EMPRESAS","2","XM58405",12);
INSERT INTO gestion_factoria.thge010_nivel (gestion_factoria.thge010_nivel.CD_NIVEL,gestion_factoria.thge010_nivel.NB_NIVEL,gestion_factoria.thge010_nivel.CD_TIPO_NIVEL,gestion_factoria.thge010_nivel.CD_USUARIO_RESP, gestion_factoria.thge010_nivel.CD_NIVEL_SUPERIOR) VALUES(58,"COBRANZA Y DISOLUCIÓN","2","XM58406",12);
INSERT INTO gestion_factoria.thge010_nivel (gestion_factoria.thge010_nivel.CD_NIVEL,gestion_factoria.thge010_nivel.NB_NIVEL,gestion_factoria.thge010_nivel.CD_TIPO_NIVEL,gestion_factoria.thge010_nivel.CD_USUARIO_RESP, gestion_factoria.thge010_nivel.CD_NIVEL_SUPERIOR) VALUES(59,"CONSUMER FINANCE","2","XM58407",12);
INSERT INTO gestion_factoria.thge010_nivel (gestion_factoria.thge010_nivel.CD_NIVEL,gestion_factoria.thge010_nivel.NB_NIVEL,gestion_factoria.thge010_nivel.CD_TIPO_NIVEL,gestion_factoria.thge010_nivel.CD_USUARIO_RESP, gestion_factoria.thge010_nivel.CD_NIVEL_SUPERIOR) VALUES(60,"NÓMINA, PASIVO Y SERVICIOS","2","XM58408",12);
INSERT INTO gestion_factoria.thge010_nivel (gestion_factoria.thge010_nivel.CD_NIVEL,gestion_factoria.thge010_nivel.NB_NIVEL,gestion_factoria.thge010_nivel.CD_TIPO_NIVEL,gestion_factoria.thge010_nivel.CD_USUARIO_RESP, gestion_factoria.thge010_nivel.CD_NIVEL_SUPERIOR) VALUES(61,"CENTRAL DE AUTORIZACIONES","2","XM58409",13);
INSERT INTO gestion_factoria.thge010_nivel (gestion_factoria.thge010_nivel.CD_NIVEL,gestion_factoria.thge010_nivel.NB_NIVEL,gestion_factoria.thge010_nivel.CD_TIPO_NIVEL,gestion_factoria.thge010_nivel.CD_USUARIO_RESP, gestion_factoria.thge010_nivel.CD_NIVEL_SUPERIOR) VALUES(62,"TARJETA DE CRÉDITO","2","XM58410",13);
INSERT INTO gestion_factoria.thge010_nivel (gestion_factoria.thge010_nivel.CD_NIVEL,gestion_factoria.thge010_nivel.NB_NIVEL,gestion_factoria.thge010_nivel.CD_TIPO_NIVEL,gestion_factoria.thge010_nivel.CD_USUARIO_RESP, gestion_factoria.thge010_nivel.CD_NIVEL_SUPERIOR) VALUES(63,"CAMPAÑAS Y LEALTAD DYD","2","XM58411",13);
INSERT INTO gestion_factoria.thge010_nivel (gestion_factoria.thge010_nivel.CD_NIVEL,gestion_factoria.thge010_nivel.NB_NIVEL,gestion_factoria.thge010_nivel.CD_TIPO_NIVEL,gestion_factoria.thge010_nivel.CD_USUARIO_RESP, gestion_factoria.thge010_nivel.CD_NIVEL_SUPERIOR) VALUES(64,"COMERCIOS Y CORRESPONSALES","2","XM58412",13);
INSERT INTO gestion_factoria.thge010_nivel (gestion_factoria.thge010_nivel.CD_NIVEL,gestion_factoria.thge010_nivel.NB_NIVEL,gestion_factoria.thge010_nivel.CD_TIPO_NIVEL,gestion_factoria.thge010_nivel.CD_USUARIO_RESP, gestion_factoria.thge010_nivel.CD_NIVEL_SUPERIOR) VALUES(65,"CONTABILIDAD E INFORMACIONAL","2","XM58413",13);
INSERT INTO gestion_factoria.thge010_nivel (gestion_factoria.thge010_nivel.CD_NIVEL,gestion_factoria.thge010_nivel.NB_NIVEL,gestion_factoria.thge010_nivel.CD_TIPO_NIVEL,gestion_factoria.thge010_nivel.CD_USUARIO_RESP, gestion_factoria.thge010_nivel.CD_NIVEL_SUPERIOR) VALUES(66,"ADMISIÓN SERVICIOS OPERATIVOS","2","XM58414",13);
INSERT INTO gestion_factoria.thge010_nivel (gestion_factoria.thge010_nivel.CD_NIVEL,gestion_factoria.thge010_nivel.NB_NIVEL,gestion_factoria.thge010_nivel.CD_TIPO_NIVEL,gestion_factoria.thge010_nivel.CD_USUARIO_RESP, gestion_factoria.thge010_nivel.CD_NIVEL_SUPERIOR) VALUES(67,"BANCA PATRIMONIAL Y PRIVADA","2","XM58415",13);
INSERT INTO gestion_factoria.thge010_nivel (gestion_factoria.thge010_nivel.CD_NIVEL,gestion_factoria.thge010_nivel.NB_NIVEL,gestion_factoria.thge010_nivel.CD_TIPO_NIVEL,gestion_factoria.thge010_nivel.CD_USUARIO_RESP, gestion_factoria.thge010_nivel.CD_NIVEL_SUPERIOR) VALUES(68,"PRODUCTOS DE PASIVO Y PYME","2","XM58416",13);
INSERT INTO gestion_factoria.thge010_nivel (gestion_factoria.thge010_nivel.CD_NIVEL,gestion_factoria.thge010_nivel.NB_NIVEL,gestion_factoria.thge010_nivel.CD_TIPO_NIVEL,gestion_factoria.thge010_nivel.CD_USUARIO_RESP, gestion_factoria.thge010_nivel.CD_NIVEL_SUPERIOR) VALUES(69,"DISPOSITIVOS","2","XM58417",13);
INSERT INTO gestion_factoria.thge010_nivel (gestion_factoria.thge010_nivel.CD_NIVEL,gestion_factoria.thge010_nivel.NB_NIVEL,gestion_factoria.thge010_nivel.CD_TIPO_NIVEL,gestion_factoria.thge010_nivel.CD_USUARIO_RESP, gestion_factoria.thge010_nivel.CD_NIVEL_SUPERIOR) VALUES(70,"FONDOS Y TRANSFERENCIAS","2","XM58418",14);
INSERT INTO gestion_factoria.thge010_nivel (gestion_factoria.thge010_nivel.CD_NIVEL,gestion_factoria.thge010_nivel.NB_NIVEL,gestion_factoria.thge010_nivel.CD_TIPO_NIVEL,gestion_factoria.thge010_nivel.CD_USUARIO_RESP, gestion_factoria.thge010_nivel.CD_NIVEL_SUPERIOR) VALUES(71,"PI - PERSONAS","2","XM58419",15);
INSERT INTO gestion_factoria.thge010_nivel (gestion_factoria.thge010_nivel.CD_NIVEL,gestion_factoria.thge010_nivel.NB_NIVEL,gestion_factoria.thge010_nivel.CD_TIPO_NIVEL,gestion_factoria.thge010_nivel.CD_USUARIO_RESP, gestion_factoria.thge010_nivel.CD_NIVEL_SUPERIOR) VALUES(72,"CRM / QA","2","XM58420",15);
INSERT INTO gestion_factoria.thge010_nivel (gestion_factoria.thge010_nivel.CD_NIVEL,gestion_factoria.thge010_nivel.NB_NIVEL,gestion_factoria.thge010_nivel.CD_TIPO_NIVEL,gestion_factoria.thge010_nivel.CD_USUARIO_RESP, gestion_factoria.thge010_nivel.CD_NIVEL_SUPERIOR) VALUES(73,"CAMPAÑAS","2","XM58421",15);
INSERT INTO gestion_factoria.thge010_nivel (gestion_factoria.thge010_nivel.CD_NIVEL,gestion_factoria.thge010_nivel.NB_NIVEL,gestion_factoria.thge010_nivel.CD_TIPO_NIVEL,gestion_factoria.thge010_nivel.CD_USUARIO_RESP, gestion_factoria.thge010_nivel.CD_NIVEL_SUPERIOR) VALUES(74,"EVALUATION OF PROJECTS","2","XM58422",16);
INSERT INTO gestion_factoria.thge010_nivel (gestion_factoria.thge010_nivel.CD_NIVEL,gestion_factoria.thge010_nivel.NB_NIVEL,gestion_factoria.thge010_nivel.CD_TIPO_NIVEL,gestion_factoria.thge010_nivel.CD_USUARIO_RESP, gestion_factoria.thge010_nivel.CD_NIVEL_SUPERIOR) VALUES(75,"SEGUROS","2","XM58423",17);
INSERT INTO gestion_factoria.thge010_nivel (gestion_factoria.thge010_nivel.CD_NIVEL,gestion_factoria.thge010_nivel.NB_NIVEL,gestion_factoria.thge010_nivel.CD_TIPO_NIVEL,gestion_factoria.thge010_nivel.CD_USUARIO_RESP, gestion_factoria.thge010_nivel.CD_NIVEL_SUPERIOR) VALUES(76,"FIDUCIARIO","2","XM58424",18);
INSERT INTO gestion_factoria.thge010_nivel (gestion_factoria.thge010_nivel.CD_NIVEL,gestion_factoria.thge010_nivel.NB_NIVEL,gestion_factoria.thge010_nivel.CD_TIPO_NIVEL,gestion_factoria.thge010_nivel.CD_USUARIO_RESP, gestion_factoria.thge010_nivel.CD_NIVEL_SUPERIOR) VALUES(77,"INFORMACIONAL Y FINANZAS","2","XM58425",19);
INSERT INTO gestion_factoria.thge010_nivel (gestion_factoria.thge010_nivel.CD_NIVEL,gestion_factoria.thge010_nivel.NB_NIVEL,gestion_factoria.thge010_nivel.CD_TIPO_NIVEL,gestion_factoria.thge010_nivel.CD_USUARIO_RESP, gestion_factoria.thge010_nivel.CD_NIVEL_SUPERIOR) VALUES(78,"AUTORIDADES Y CUMPLIMIENTO","2","XM58426",19);
INSERT INTO gestion_factoria.thge010_nivel (gestion_factoria.thge010_nivel.CD_NIVEL,gestion_factoria.thge010_nivel.NB_NIVEL,gestion_factoria.thge010_nivel.CD_TIPO_NIVEL,gestion_factoria.thge010_nivel.CD_USUARIO_RESP, gestion_factoria.thge010_nivel.CD_NIVEL_SUPERIOR) VALUES(79,"SISTEMAS PLD Y CUMPLIMIENTO NORMATIVO","2","XM58427",19);
INSERT INTO gestion_factoria.thge010_nivel (gestion_factoria.thge010_nivel.CD_NIVEL,gestion_factoria.thge010_nivel.NB_NIVEL,gestion_factoria.thge010_nivel.CD_TIPO_NIVEL,gestion_factoria.thge010_nivel.CD_USUARIO_RESP, gestion_factoria.thge010_nivel.CD_NIVEL_SUPERIOR) VALUES(80,"RIESGOS","2","XM58428",19);
INSERT INTO gestion_factoria.thge010_nivel (gestion_factoria.thge010_nivel.CD_NIVEL,gestion_factoria.thge010_nivel.NB_NIVEL,gestion_factoria.thge010_nivel.CD_TIPO_NIVEL,gestion_factoria.thge010_nivel.CD_USUARIO_RESP, gestion_factoria.thge010_nivel.CD_NIVEL_SUPERIOR) VALUES(81,"GESTIÓN DE EMPRESAS","2","XM58429",19);
INSERT INTO gestion_factoria.thge010_nivel (gestion_factoria.thge010_nivel.CD_NIVEL,gestion_factoria.thge010_nivel.NB_NIVEL,gestion_factoria.thge010_nivel.CD_TIPO_NIVEL,gestion_factoria.thge010_nivel.CD_USUARIO_RESP, gestion_factoria.thge010_nivel.CD_NIVEL_SUPERIOR) VALUES(82,"DATA MANAGER Y GESTION","2","XM58430",19);
INSERT INTO gestion_factoria.thge010_nivel (gestion_factoria.thge010_nivel.CD_NIVEL,gestion_factoria.thge010_nivel.NB_NIVEL,gestion_factoria.thge010_nivel.CD_TIPO_NIVEL,gestion_factoria.thge010_nivel.CD_USUARIO_RESP, gestion_factoria.thge010_nivel.CD_NIVEL_SUPERIOR) VALUES(83,"TRANSFORMATION SOLUTIONS","2","XM58431",20);
INSERT INTO gestion_factoria.thge010_nivel (gestion_factoria.thge010_nivel.CD_NIVEL,gestion_factoria.thge010_nivel.NB_NIVEL,gestion_factoria.thge010_nivel.CD_TIPO_NIVEL,gestion_factoria.thge010_nivel.CD_USUARIO_RESP, gestion_factoria.thge010_nivel.CD_NIVEL_SUPERIOR) VALUES(84,"TRANSFORMACIÓN CANALES","2","XM58432",20);
