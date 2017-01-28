CREATE DATABASE  IF NOT EXISTS `concesionario` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `concesionario`;
-- MySQL dump 10.13  Distrib 5.6.24, for Win32 (x86)
--
-- Host: 192.168.0.2    Database: concesionario
-- ------------------------------------------------------
-- Server version	5.6.26

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `clientes`
--

DROP TABLE IF EXISTS `clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `clientes` (
  `idCliente` int(11) NOT NULL,
  `cedula` varchar(25) NOT NULL,
  PRIMARY KEY (`idCliente`),
  UNIQUE KEY `cedula_UNIQUE` (`cedula`),
  CONSTRAINT `tipoUsuario/clientes` FOREIGN KEY (`idCliente`) REFERENCES `tiposusuario` (`idTipo`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` VALUES (11,'1023013382'),(12,'1023114330');
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `concesionarios`
--

DROP TABLE IF EXISTS `concesionarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `concesionarios` (
  `idConcesionario` int(11) NOT NULL,
  `nit` varchar(25) NOT NULL,
  PRIMARY KEY (`idConcesionario`),
  UNIQUE KEY `nit_UNIQUE` (`nit`),
  CONSTRAINT `tipoUsuario/concesionario` FOREIGN KEY (`idConcesionario`) REFERENCES `tiposusuario` (`idTipo`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `concesionarios`
--

LOCK TABLES `concesionarios` WRITE;
/*!40000 ALTER TABLE `concesionarios` DISABLE KEYS */;
INSERT INTO `concesionarios` VALUES (2,'12465652'),(3,'15385254'),(8,'252357245'),(1,'3825324'),(4,'52242865'),(5,'52532752'),(6,'52882142'),(7,'53227287'),(9,'565827528'),(10,'572727558');
/*!40000 ALTER TABLE `concesionarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `marcas`
--

DROP TABLE IF EXISTS `marcas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `marcas` (
  `idMarca` int(11) NOT NULL,
  `marca` varchar(45) NOT NULL,
  PRIMARY KEY (`idMarca`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `marcas`
--

LOCK TABLES `marcas` WRITE;
/*!40000 ALTER TABLE `marcas` DISABLE KEYS */;
INSERT INTO `marcas` VALUES (1,'Renault'),(2,'BMW'),(3,'Chery'),(4,'Chevrolet'),(5,'Hyundai'),(6,'Kia'),(7,'Toyota'),(8,'Honda'),(9,'Ford'),(10,'Mazda'),(11,'Volvo'),(12,'Audi'),(13,'Nissan');
/*!40000 ALTER TABLE `marcas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipos`
--

DROP TABLE IF EXISTS `tipos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipos` (
  `idTipo` int(11) NOT NULL,
  `tipo` varchar(45) NOT NULL,
  PRIMARY KEY (`idTipo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipos`
--

LOCK TABLES `tipos` WRITE;
/*!40000 ALTER TABLE `tipos` DISABLE KEYS */;
INSERT INTO `tipos` VALUES (1,'Automovil'),(2,'Camioneta'),(3,'Familiar'),(4,'Deportivo'),(5,'Todo terreno'),(6,'Furgoneta');
/*!40000 ALTER TABLE `tipos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tiposusuario`
--

DROP TABLE IF EXISTS `tiposusuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tiposusuario` (
  `idTipo` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `telefono` varchar(45) NOT NULL,
  `direccion` varchar(45) NOT NULL,
  `contrasena` varchar(45) NOT NULL,
  PRIMARY KEY (`idTipo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tiposusuario`
--

LOCK TABLES `tiposusuario` WRITE;
/*!40000 ALTER TABLE `tiposusuario` DISABLE KEYS */;
INSERT INTO `tiposusuario` VALUES (1,'Auto blitz','6529666','Cra. 70 #95-15','@'),(2,'Demcautos S.A','5931600','Kr 19 #100','@'),(3,'Lyra Motors','6663613','cll 94 #11A -13','@'),(4,'Colyong','6457894','Cra. 15','@'),(5,'Sanautos',' 6348299','Ak. 19','@'),(6,'Geely','6528800','Av. Boyaca #96A - 47','@'),(7,'Ultracar','6589742','Cl. 116 #55a-11','@'),(8,'Cinascar','6060688','Ac 72 #2067','@'),(9,'Jorge Cortes y Cia','2557177','# Esquina, Ak. 24','@'),(10,'AutoMotores Europa','2265858','05, Cl. 126 #60','@'),(11,'Mario Camargo','7643145','cll 97 sur #5-07 este','vSc'),(12,'John Ruiz','7686442','cll 87 #43-76 ','w');
/*!40000 ALTER TABLE `tiposusuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vehiculos`
--

DROP TABLE IF EXISTS `vehiculos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vehiculos` (
  `idVehiculo` int(11) NOT NULL,
  `placa` varchar(8) NOT NULL,
  `marca` int(11) NOT NULL,
  `modelo` int(11) NOT NULL,
  `precio` int(11) NOT NULL,
  `concesionario` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `tipo` int(11) NOT NULL,
  `kilometraje` int(6) NOT NULL,
  PRIMARY KEY (`idVehiculo`),
  UNIQUE KEY `placa_UNIQUE` (`placa`),
  KEY `vehiculos/concesionarios_idx` (`concesionario`),
  KEY `vehiculos/marcas_idx` (`marca`),
  KEY `vehiculos/tipos_idx` (`tipo`),
  CONSTRAINT `vehiculos/concesionarios` FOREIGN KEY (`concesionario`) REFERENCES `concesionarios` (`idConcesionario`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `vehiculos/marcas` FOREIGN KEY (`marca`) REFERENCES `marcas` (`idMarca`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `vehiculos/tipos` FOREIGN KEY (`tipo`) REFERENCES `tipos` (`idTipo`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vehiculos`
--

LOCK TABLES `vehiculos` WRITE;
/*!40000 ALTER TABLE `vehiculos` DISABLE KEYS */;
INSERT INTO `vehiculos` VALUES (1,'MIL-105',2,2015,99500000,1,20,1,10800),(2,'GHT-234',4,2013,46000000,4,40,2,74274),(3,'JYY-765',7,2014,98000000,6,30,2,26000),(4,'HRD-684',5,2012,49900000,8,40,2,74000),(5,'HTF-340',1,2012,38000000,5,44,1,35000),(6,'JUK-348',9,2010,58000000,3,25,3,61000),(7,'ASF-604',3,2013,38000000,6,50,6,62000),(8,'HKU-089',9,2011,30000000,10,43,1,36124),(9,'KUJ-485',13,2016,85000000,2,34,3,13600),(10,'OKJ-457',12,2014,107500000,8,25,4,11400),(11,'YDS-325',3,2010,10800000,2,47,1,63700),(12,'XXX-XX2',2,2010,83000000,1,16,4,29100),(13,'KBO-000',1,2010,21000000,6,67,1,71650),(14,'IWL-675',6,2016,68000000,7,45,3,6350),(15,'GTR-494',10,2015,62000000,10,21,4,19944),(16,'ZYV-067',11,2014,120000000,3,32,1,17500),(17,'MUQ-728',8,2014,118000000,5,67,2,37018),(18,'BUD--230',8,1996,10800000,2,12,1,201500),(19,'IMS-821',6,2016,49500000,7,55,2,15000),(20,'KNL-111',4,2010,45000000,4,64,2,59238);
/*!40000 ALTER TABLE `vehiculos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ventas`
--

DROP TABLE IF EXISTS `ventas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ventas` (
  `idVenta` int(11) NOT NULL,
  `idCliente` int(11) NOT NULL,
  `idVehiculo` int(11) NOT NULL,
  `fecha` date NOT NULL,
  PRIMARY KEY (`idVenta`),
  KEY `ventas/clientes_idx` (`idCliente`),
  KEY `ventas/vehiculos_idx` (`idVehiculo`),
  CONSTRAINT `ventas/clientes` FOREIGN KEY (`idCliente`) REFERENCES `clientes` (`idCliente`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `ventas/vehiculos` FOREIGN KEY (`idVehiculo`) REFERENCES `vehiculos` (`idVehiculo`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ventas`
--

LOCK TABLES `ventas` WRITE;
/*!40000 ALTER TABLE `ventas` DISABLE KEYS */;
/*!40000 ALTER TABLE `ventas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'concesionario'
--
/*!50003 DROP FUNCTION IF EXISTS `setContrasena` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `setContrasena`(contra varchar(45)) RETURNS varchar(45) CHARSET utf8
BEGIN
declare con varchar(45);
declare salida varchar(45);
set con = concat('conce',contra,'sionario');

set salida= (select aes_encrypt('mario1609',con));
RETURN salida;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-01-27 20:05:15
