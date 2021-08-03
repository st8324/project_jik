-- MySQL dump 10.13  Distrib 8.0.25, for Win64 (x86_64)
--
-- Host: localhost    Database: spring_jik
-- ------------------------------------------------------
-- Server version	8.0.25

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
-- Table structure for table `member`
--

DROP TABLE IF EXISTS `member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `member` (
  `id` varchar(15) NOT NULL,
  `pw` varchar(255) NOT NULL,
  `gender` varchar(1) NOT NULL DEFAULT 'M',
  `email` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL DEFAULT ' ',
  `authority` varchar(45) NOT NULL DEFAULT 'USER',
  `session_id` varchar(255) DEFAULT NULL,
  `session_limit` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member`
--

LOCK TABLES `member` WRITE;
/*!40000 ALTER TABLE `member` DISABLE KEYS */;
INSERT INTO `member` VALUES ('123123123','$2a$10$RRIHrtmi9SjC5KMS3lpio.dxo4Db2hwxBljuhxoSfaCzPdzNpLnDy','M','123@naver.com','123','USER','none','2021-08-02 16:40:54'),('abcd1234','$2a$10$RQj1y8qnGYnsq270MO5pHOvWKhCcPbAEVPK4EMXESPP0k2TapWk.G','M','stajun@gmail.com','abcd1234','USER',NULL,NULL),('qwe','$2a$10$6J8kz.EG82UAGa1eUSQ2OeUNaBu2gzvF.37slHOfUn9oamw7uDncy','M','stajun@naver.com','qwe','SUPER ADMIN','BC148F3AFAFB4B948DC54FF3BC3FEAEC','2021-08-09 17:07:22'),('qweqweqwe','$2a$10$RjkEK29/LM2HLiCmusXCvucKvkeO/go11uobFrdltoejgh33fNlKS','M','qweqweqwe@naver.com','홍길동','ADMIN',NULL,NULL);
/*!40000 ALTER TABLE `member` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-08-03 10:28:13
