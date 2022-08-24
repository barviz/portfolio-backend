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

SET @@GLOBAL.GTID_PURGED=/*!80000 '+'*/ 'f41d366d-91e5-11e9-8525-cecd028ee826:1-120570107';

--
-- Table structure for table `persona_resumen`
--

DROP TABLE IF EXISTS `persona_resumen`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `persona_resumen` (
  `persona_resumen_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `persona_resumen_descripcion` varchar(2000) NOT NULL,
  PRIMARY KEY (`persona_resumen_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persona_resumen`
--

LOCK TABLES `persona_resumen` WRITE;
/*!40000 ALTER TABLE `persona_resumen` DISABLE KEYS */;
INSERT INTO `persona_resumen` VALUES (1,'Hola! Mi nombre es Bárbara. Estoy muy interesada en insertarme en el ambiente IT. Considero que me abriría un horizonte de posibilidades muy grande para desarrollarme tanto personal como profesionalmente. Como persona apasionada por la tecnología me encuentro actualmente formando parte de programas de formación en programación con perspectiva social y de género orientados a reducir las brechas de la desigualdad. Gracias a ellos he descubierto una nueva forma de pensar, más organizada y lógica lo que me motiva a crear cosas nuevas y lograr transformar mi vida. Te invito a conocer más de mí en las demás secciones o si necesitas más información, no dudes en preguntarme. Gracias por visitar mi portfolio!');
/*!40000 ALTER TABLE `persona_resumen` ENABLE KEYS */;
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

-- Dump completed on 2022-08-24 15:49:53
