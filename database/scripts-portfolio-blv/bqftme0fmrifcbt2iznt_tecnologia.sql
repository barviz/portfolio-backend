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

SET @@GLOBAL.GTID_PURGED=/*!80000 '+'*/ 'f41d366d-91e5-11e9-8525-cecd028ee826:1-120570121';

--
-- Table structure for table `tecnologia`
--

DROP TABLE IF EXISTS `tecnologia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tecnologia` (
  `tecnologia_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `tecnologia_img_url_logo` varchar(200) NOT NULL,
  `tecnologia_nombre` varchar(45) NOT NULL,
  `tecnologia_porcentaje` int(11) DEFAULT NULL,
  PRIMARY KEY (`tecnologia_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tecnologia`
--

LOCK TABLES `tecnologia` WRITE;
/*!40000 ALTER TABLE `tecnologia` DISABLE KEYS */;
INSERT INTO `tecnologia` VALUES (1,'https://raw.githubusercontent.com/barviz/portfolio-fronted/master/src/assets/img/hard%20skills/angular.png','Angular',80),(2,'https://raw.githubusercontent.com/barviz/portfolio-fronted/master/src/assets/img/hard%20skills/bootstrap.png','Bootstrap',80),(3,'https://raw.githubusercontent.com/barviz/portfolio-fronted/master/src/assets/img/hard%20skills/css2.png','CSS',80),(4,'https://raw.githubusercontent.com/barviz/portfolio-fronted/master/src/assets/img/hard%20skills/git.png','Git',80),(5,'https://raw.githubusercontent.com/barviz/portfolio-fronted/master/src/assets/img/hard%20skills/hibernate.png','Hibernate',60),(6,'https://raw.githubusercontent.com/barviz/portfolio-fronted/master/src/assets/img/hard%20skills/html.png','HTML',80),(7,'https://raw.githubusercontent.com/barviz/portfolio-fronted/master/src/assets/img/hard%20skills/java.png','JAVA',90),(8,'https://raw.githubusercontent.com/barviz/portfolio-fronted/master/src/assets/img/hard%20skills/javascript.png','JavaScript',70),(9,'https://raw.githubusercontent.com/barviz/portfolio-fronted/master/src/assets/img/hard%20skills/mysql.png','MySQL',90),(10,'https://raw.githubusercontent.com/barviz/portfolio-fronted/master/src/assets/img/hard%20skills/node.png','Node',50),(11,'https://raw.githubusercontent.com/barviz/portfolio-fronted/master/src/assets/img/hard%20skills/react.png','React',40),(12,'https://raw.githubusercontent.com/barviz/portfolio-fronted/master/src/assets/img/hard%20skills/spring%20boot.png','Spring Boot',90),(13,'https://raw.githubusercontent.com/barviz/portfolio-fronted/master/src/assets/img/hard%20skills/thymeleaf.png','Thymeleaf',70);
/*!40000 ALTER TABLE `tecnologia` ENABLE KEYS */;
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

-- Dump completed on 2022-08-24 15:50:13
