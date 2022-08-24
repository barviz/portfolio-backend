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

SET @@GLOBAL.GTID_PURGED=/*!80000 '+'*/ 'f41d366d-91e5-11e9-8525-cecd028ee826:1-120570111';

--
-- Table structure for table `proyecto`
--

DROP TABLE IF EXISTS `proyecto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `proyecto` (
  `proyecto_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `proyecto_anio` int(11) DEFAULT NULL,
  `proyecto_descripcion` varchar(300) NOT NULL,
  `proyecto_img_url_logo` varchar(200) NOT NULL,
  `proyecto_link` varchar(100) NOT NULL,
  `proyecto_nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`proyecto_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proyecto`
--

LOCK TABLES `proyecto` WRITE;
/*!40000 ALTER TABLE `proyecto` DISABLE KEYS */;
INSERT INTO `proyecto` VALUES (1,2022,'Aplicación de arquitectura distribuida con diseño de interfaz de usuario, una base de datos y APIs para proveer a través de internet la información.','https://raw.githubusercontent.com/barviz/portfolio-fronted/master/src/assets/img/proyecto/portfolio.jpg','https://github.com/barviz/portfolio-backend','Portfolio Web'),(2,2022,'Sistema web desarrollado para un club barrial que se dedica a ofrecer actividades deportivas y recreativas. (en proceso)','https://raw.githubusercontent.com/barviz/portfolio-fronted/master/src/assets/img/proyecto/cazoapp.jpg','https://github.com/barviz/cazoApp','CAZOApp'),(3,2022,'Aplicación que muestra el pronóstico del tiempo por 7 días.','https://raw.githubusercontent.com/barviz/portfolio-fronted/master/src/assets/img/proyecto/climaapp.jpg','https://github.com/barviz/climaApp','ClimaApp'),(4,2022,'Desafío Oracle ONE: Proyecto Ecommerce. (en proceso)','https://raw.githubusercontent.com/barviz/portfolio-fronted/master/src/assets/img/proyecto/ecommerce.png','https://github.com/barviz/ecommerceApp','Ecommerce'),(5,2022,'Desafío Oracle ONE: Proyecto Portfolio. (en proceso)','https://raw.githubusercontent.com/barviz/portfolio-fronted/master/src/assets/img/proyecto/portfolio2.png','https://github.com/barviz/portfolioApp','Portfolio'),(6,2022,'Challenge ONE - Lógica de Programación - Encriptador de Texto','https://user-images.githubusercontent.com/96797843/183551410-64847fa8-ffd6-4478-837d-9ba5d5f5058a.png','https://github.com/barviz/encriptadorApp','Encriptador'),(7,2022,'Challenge ONE - Lógica de Programación - Juego del Ahorcado','https://user-images.githubusercontent.com/96797843/184508536-e529bcfe-6112-4e3c-a3ea-5cf0f28fafa4.png','https://github.com/barviz/ahorcadoApp','Ahorcado'),(8,2022,'Proyecto de front-end donde se desarrolla una página web básica.','https://user-images.githubusercontent.com/96797843/183224790-fb06c2fe-2d96-408d-8243-2cb3c3094e47.png','https://github.com/barviz/peluqueria-canina','Peluquería Canina'),(9,2022,'Aplicación librería con sistema de guardado de libros. (en proceso)','https://raw.githubusercontent.com/barviz/portfolio-fronted/master/src/assets/img/proyecto/libreria.jpg','https://github.com/barviz/libreriaApp','Librería Web'),(10,2022,'Proyecto de front-end donde se desarrollan funcionalidades para que los usuarios de los stores de esta clínica puedan gestionar a los pacientes de una forma más fácil y con un registro y control más accesible, más eficiente y eficaz.','https://user-images.githubusercontent.com/96797843/183271908-ca061f7d-e901-4747-a45a-f47e6a2bec03.png','https://github.com/barviz/clinica-nutricion','Clínica de Nutrición'),(11,2022,'Proyecto de front-end donde se desarrolla un sitio web responsivo con Flexbox.','https://user-images.githubusercontent.com/96797843/184732678-7db8da3a-c566-4bc7-bef7-ab4630244d15.png','https://github.com/barviz/mini-market','Mini Market'),(12,2022,'Proyecto de front-end donde se desarrolla un sitio web responsivo con CSS Grid.','https://user-images.githubusercontent.com/96797843/185273461-877b3d9c-2557-4e32-95d7-fd8ed461e8d9.png','https://github.com/barviz/tienda-virtual','Tienda Virtual'),(13,2022,'Proyecto de front-end donde se desarrolla un layout responsivo.','https://user-images.githubusercontent.com/96797843/185724056-4255827b-d9fc-4f95-8e6a-71ac08b7a6b5.png','https://github.com/barviz/servicio-internet','Servicio Internet'),(14,2022,'Proyecto de front-end donde se desarrolla una página web haciendo hincapié en la arquitectura CSS utilizando metodologías como Atomic Design y BEM.','https://user-images.githubusercontent.com/96797843/186046091-04278820-089d-4fd8-a046-3f00455833ff.png','https://barviz.github.io/recetario-alimenticio/','Recetario Alimenticio');
/*!40000 ALTER TABLE `proyecto` ENABLE KEYS */;
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

-- Dump completed on 2022-08-24 15:49:58
