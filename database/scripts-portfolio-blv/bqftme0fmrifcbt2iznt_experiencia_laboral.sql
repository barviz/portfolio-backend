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

SET @@GLOBAL.GTID_PURGED=/*!80000 '+'*/ 'f41d366d-91e5-11e9-8525-cecd028ee826:1-120570126';

--
-- Table structure for table `experiencia_laboral`
--

DROP TABLE IF EXISTS `experiencia_laboral`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `experiencia_laboral` (
  `experiencia_laboral_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `experiencia_laboral_inicio` int(11) DEFAULT NULL,
  `experiencia_laboral_anio_inicio` int(11) DEFAULT NULL,
  `experiencia_laboral_descripcion` varchar(300) NOT NULL,
  `experiencia_laboral_empresa` varchar(45) NOT NULL,
  `experiencia_img_url_logo` varchar(200) NOT NULL,
  `experiencia_laboral_puesto` varchar(45) NOT NULL,
  PRIMARY KEY (`experiencia_laboral_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `experiencia_laboral`
--

LOCK TABLES `experiencia_laboral` WRITE;
/*!40000 ALTER TABLE `experiencia_laboral` DISABLE KEYS */;
INSERT INTO `experiencia_laboral` VALUES (1,2020,2018,'Asistencia en el cuidado de niños, contribuyendo con los padres para satisfacer las necesidades físicas, emocionales, intelectuales y sociales de los infantes, brindándoles, además, las herramientas necesarias para que desarrollen sus habilidades y destrezas durante su crecimiento.','Casa de Familia','https://raw.githubusercontent.com/barviz/portfolio-fronted/master/src/assets/img/experiencia/cuidado-de-ni%C3%B1os.jpg','Cuidado de niños'),(2,2020,2018,'Asistencia en el cuidado de ancianos y sus necesidades, administración y control de medicación, acompañamiento durante traslados, alimentación y mantenimiento básico de la casa.','Casa de Familia','https://raw.githubusercontent.com/barviz/portfolio-fronted/master/src/assets/img/experiencia/cuidado-de-ancianos.jpg','Cuidado de adultos mayores'),(3,2020,2014,'Cuidado de la vivienda y animales domésticos mientras los propietarios se encuentran de viaje.','Casa de Familia','https://raw.githubusercontent.com/barviz/portfolio-fronted/master/src/assets/img/experiencia/housesitting.jpg','Housesitting'),(4,2020,2014,'Ejecución de tareas de aseo, cocina, lavado, planchado, jardinería, cuidado de animales y demás tareas propias del hogar.','Casa de Familia','https://raw.githubusercontent.com/barviz/portfolio-fronted/master/src/assets/img/experiencia/empleada-domestica.jpg','Empleada Doméstica');
/*!40000 ALTER TABLE `experiencia_laboral` ENABLE KEYS */;
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

-- Dump completed on 2022-08-24 15:50:22
