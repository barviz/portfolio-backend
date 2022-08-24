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

SET @@GLOBAL.GTID_PURGED=/*!80000 '+'*/ 'f41d366d-91e5-11e9-8525-cecd028ee826:1-120570116';

--
-- Table structure for table `educacion`
--

DROP TABLE IF EXISTS `educacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `educacion` (
  `educacion_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `educacion_anio_fin` int(11) DEFAULT NULL,
  `educacion_anio_inicio` int(11) DEFAULT NULL,
  `educacion_img_url_logo` varchar(200) NOT NULL,
  `educacion_institucion` varchar(45) NOT NULL,
  `educacion_titulo` varchar(45) NOT NULL,
  PRIMARY KEY (`educacion_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `educacion`
--

LOCK TABLES `educacion` WRITE;
/*!40000 ALTER TABLE `educacion` DISABLE KEYS */;
INSERT INTO `educacion` VALUES (1,2022,2022,'https://raw.githubusercontent.com/barviz/portfolio-fronted/master/src/assets/img/educacion/oraclealura.jpg','Oracle/AluraLatam','ONE: Oracle Next Education'),(2,2022,2022,'https://portinos-cloudfront.portinos.com/wp-content/uploads/2017/03/thumbnail_codo-a-codo.jpg','Ministerio de Educación','Codo a Codo: Testing/QA'),(3,2022,2021,'https://raw.githubusercontent.com/barviz/portfolio-fronted/master/src/assets/img/educacion/yo-programo2.jpg','Ministerio de Desarrollo Productivo','Argentina Programa: #YoProgramo'),(4,2021,2022,'https://raw.githubusercontent.com/barviz/portfolio-fronted/master/src/assets/img/educacion/proyectottec.png','Ministerio de Educación','Proyecto T.Tec'),(5,2022,2022,'https://raw.githubusercontent.com/barviz/portfolio-fronted/master/src/assets/img/educacion/ingles.jpg','Ministerio de Desarrollo Productivo','Argentina Programa: #Inglés'),(6,2021,2021,'https://raw.githubusercontent.com/barviz/portfolio-fronted/master/src/assets/img/educacion/se-programar.jpg','Ministerio de Desarrollo Productivo','Argentina Programa: #SeProgramar'),(7,2009,2007,'https://raw.githubusercontent.com/barviz/portfolio-fronted/master/src/assets/img/educacion/eemn36.jpg','E.E.M n°36 \"Esteban Echeverría\"','Bachiller en Humanidades y Cs. Sociales');
/*!40000 ALTER TABLE `educacion` ENABLE KEYS */;
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

-- Dump completed on 2022-08-24 15:50:03
