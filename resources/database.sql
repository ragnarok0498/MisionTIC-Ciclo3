-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: localhost    Database: ciencia
-- ------------------------------------------------------
-- Server version	8.0.30

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

--
-- Table structure for table `administrador`
--

DROP TABLE IF EXISTS `administrador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `administrador` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `apellido` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `username` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `correo` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `clave` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `correo` (`correo`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `administrador`
--

LOCK TABLES `administrador` WRITE;
/*!40000 ALTER TABLE `administrador` DISABLE KEYS */;
INSERT INTO `administrador` VALUES (1,'administrador','root','root','root@email.com','$2a$10$NS19pPR.7jUYtWfSQPoTJuLPbqcU/h8CUBKcAiq2G845/3q3gHc82');
/*!40000 ALTER TABLE `administrador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comentarios`
--

DROP TABLE IF EXISTS `comentarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comentarios` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_publicacion` int DEFAULT NULL,
  `nombre` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `apellido` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `correo` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `comentario` varchar(250) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `estado` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `id_publicacion` (`id_publicacion`),
  CONSTRAINT `comentarios_ibfk_1` FOREIGN KEY (`id_publicacion`) REFERENCES `publicaciones` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comentarios`
--

LOCK TABLES `comentarios` WRITE;
/*!40000 ALTER TABLE `comentarios` DISABLE KEYS */;
INSERT INTO `comentarios` VALUES (1,1,'Prueba comentario','Apellido comentario','comment@email.com','Este es un comentario hacerca del experimento','1'),(3,NULL,'Carlos','william','will@email.com','Probamos el campo de comentarios para que un usuario administrador revise ','1');
/*!40000 ALTER TABLE `comentarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `publicaciones`
--

DROP TABLE IF EXISTS `publicaciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `publicaciones` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_admin` int DEFAULT NULL,
  `titulo` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `resumen` varchar(250) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `descripcion` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `categoria` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `estado` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `imagen` longblob,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `id_admin` (`id_admin`),
  CONSTRAINT `publicaciones_ibfk_1` FOREIGN KEY (`id_admin`) REFERENCES `administrador` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `publicaciones`
--

LOCK TABLES `publicaciones` WRITE;
/*!40000 ALTER TABLE `publicaciones` DISABLE KEYS */;
INSERT INTO `publicaciones` VALUES (1,NULL,'Test de publicacion','Esta es un resumen','Aqui mostraremos toda la informacion referente al text','Quimica','1',_binary '26bff3e452ea5456d2b5e8482b75ab6f.jpg'),(2,NULL,'Tercera Ley de Newton','Todos los días enfrentas situaciones parecidas a las que ves en las imágenes. Tienes una idea intuitiva acerca de lo que es la fuerza y de cómo debes aplicarla para mover un objeto, pero, ¿podrías definirla?','Notarás que para que exista una fuerza tienen que interactuar al menos dos objetos o cuerpos.\r\n\r\nEn una de las imágenes interactúan un hombre y un burro, en otra un cohete y el gas que expulsa, y en la última la interacción se da entre el cazador y la bala disparada.\r\n\r\nOtro punto interesante es que cuando actúa una fuerza entre dos objetos, o se cambia su estado de movimiento, o se cambia su estado de reposo: el cohete despega, el burro y el hombre intentan romper el reposo y el cazador que dispara el rifle experimenta un movimiento en sentido contrario al de la bala.\r\nAhora trataremos de explicar por qué sucede todo lo anterior. \r\nhttps://www.youtube.com/watch?v=u-sqXd8Z6IE&t=14s','Fisica','1',NULL),(3,NULL,'Clasificación de la materia','Materia es todo lo que tiene masa y ocupa un lugar en el espacio. La materia está formada por átomos y moléculas. Todo lo que nos rodea e incluso nosotros mismos estamos hechos por materia','Elemento\r\nLos elementos también pueden llamarse sustancias puras simples y están formados por una sola clase de átomos, es decir, átomos con el mismo número de protones en su núcleo y por lo tanto con las mismas propiedades químicas. Los elementos no pueden descomponerse en otras sustancias puras más sencillas por ningún procedimiento. Son sustancias puras simples todos los elementos químicos de la tabla periódica. A las sustancias formadas por moléculas compuestas por átomos iguales también se les considera elementos, por ejemplo el oxígeno gaseoso, oxígeno molecular o dioxígeno.\r\nhttps://www.youtube.com/watch?v=vPaPmrfgmvo','Quimica','1',NULL),(4,NULL,'PLANTEAMIENTO DE UNA ECUACIÓN LINEAL A PARTIR DE UN PROBLEMA','¡Caminante!, Aquí fueron sepultados los restos de Diofanto y los números pueden mostrar, ¡oh, milagro!, cuán larga fue su vida, cuya sexta parte, constituyó su hermosa infancia.','Había transcurrido además la duodécima parte de su vida, cuando de vello se cubrió su barbilla y la séptima parte de su existencia transcurrió en un matrimonio estéril.\r\n\r\nPasó un quinquenio más y le hizo dichoso el nacimiento de su precioso primogénito, que entregó su cuerpo, su hermosa existencia, que duró tan solo la mitad de la de su padre en la tierra.\r\n\r\nY con profunda pena descendió a la sepultura, habiendo sobrevivido cuatro años al deceso de su hijo.\r\n\r\n¿Dime cuántos años había vivido Diofanto cuando le llegó su muerte?\r\nhttps://www.youtube.com/watch?v=4irb_C8Ho6I','Matemáticas','1',NULL);
/*!40000 ALTER TABLE `publicaciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rol`
--

DROP TABLE IF EXISTS `rol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rol` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rol`
--

LOCK TABLES `rol` WRITE;
/*!40000 ALTER TABLE `rol` DISABLE KEYS */;
INSERT INTO `rol` VALUES (1,'ROLE_USER'),(2,'ROLE_USER');
/*!40000 ALTER TABLE `rol` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios_roles`
--

DROP TABLE IF EXISTS `usuarios_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios_roles` (
  `usuario_id` bigint NOT NULL,
  `rol_id` bigint NOT NULL,
  KEY `FK6yxg1lhuv5nievqea7rvn6afm` (`rol_id`),
  KEY `FK11ql2j2plfialhm43qdyjkfa0` (`usuario_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios_roles`
--

LOCK TABLES `usuarios_roles` WRITE;
/*!40000 ALTER TABLE `usuarios_roles` DISABLE KEYS */;
INSERT INTO `usuarios_roles` VALUES (1,1),(3,2);
/*!40000 ALTER TABLE `usuarios_roles` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-10-06  9:28:05
