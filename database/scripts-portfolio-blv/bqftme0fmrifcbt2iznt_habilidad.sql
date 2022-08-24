-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: bqftme0fmrifcbt2iznt-mysql.services.clever-cloud.com    Database: bqftme0fmrifcbt2iznt
-- ------------------------------------------------------
-- Server version	8.0.15-5

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
SET @MYSQLDUMP_TEMP_LOG_BIN = @@SESSION.SQL_LOG_BIN;
SET @@SESSION.SQL_LOG_BIN= 0;

--
-- GTID state at the beginning of the backup 
--

SET @@GLOBAL.GTID_PURGED=/*!80000 '+'*/ 'f41d366d-91e5-11e9-8525-cecd028ee826:1-120570123';

--
-- Table structure for table `habilidad`
--

DROP TABLE IF EXISTS `habilidad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `habilidad` (
  `habilidad_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `habilidad_img_url_logo` varchar(200) NOT NULL,
  `habilidad_nombre` varchar(45) NOT NULL,
  `habilidad_porcentaje` int(11) DEFAULT NULL,
  PRIMARY KEY (`habilidad_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `habilidad`
--

LOCK TABLES `habilidad` WRITE;
/*!40000 ALTER TABLE `habilidad` DISABLE KEYS */;
INSERT INTO `habilidad` VALUES (1,'https://raw.githubusercontent.com/barviz/portfolio-fronted/master/src/assets/img/soft%20skills/adaptabilidad.png','Adaptabilidad',80),(2,'https://raw.githubusercontent.com/barviz/portfolio-fronted/master/src/assets/img/soft%20skills/autonomia-proactividad.png','Autonomía y Proactividad',70),(3,'https://raw.githubusercontent.com/barviz/portfolio-fronted/master/src/assets/img/soft%20skills/buena-comunicacion.png','Buena Comunicación',70),(4,'https://raw.githubusercontent.com/barviz/portfolio-fronted/master/src/assets/img/soft%20skills/creatividad.png','Creatividad',85),(5,'https://raw.githubusercontent.com/barviz/portfolio-fronted/master/src/assets/img/soft%20skills/habilidades-sociales.png','Habilidades Sociales',70),(6,'https://raw.githubusercontent.com/barviz/portfolio-fronted/master/src/assets/img/soft%20skills/manejo-estres.png','Manejo del estrés',100),(7,'https://raw.githubusercontent.com/barviz/portfolio-fronted/master/src/assets/img/soft%20skills/organizacion-trabajo.png','Organización del trabajo',80),(8,'https://raw.githubusercontent.com/barviz/portfolio-fronted/master/src/assets/img/soft%20skills/pensamiento-critico.png','Pensamiento Crítico',80),(9,'https://raw.githubusercontent.com/barviz/portfolio-fronted/master/src/assets/img/soft%20skills/puntualidad.png','Puntualidad',100),(10,'https://raw.githubusercontent.com/barviz/portfolio-fronted/master/src/assets/img/soft%20skills/resolucion-problemas.png','Resolución de Problemas',80),(11,'https://raw.githubusercontent.com/barviz/portfolio-fronted/master/src/assets/img/soft%20skills/trabajo-equipo.png','Trabajo en Equipo',80);
/*!40000 ALTER TABLE `habilidad` ENABLE KEYS */;
UNLOCK TABLES;
SET @@SESSION.SQL_LOG_BIN = @MYSQLDUMP_TEMP_LOG_BIN;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-08-24 15:50:18
