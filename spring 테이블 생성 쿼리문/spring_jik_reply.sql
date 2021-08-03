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
-- Table structure for table `reply`
--

DROP TABLE IF EXISTS `reply`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reply` (
  `rp_num` int NOT NULL AUTO_INCREMENT,
  `rp_bd_num` int NOT NULL,
  `rp_me_id` varchar(15) NOT NULL,
  `rp_content` longtext NOT NULL,
  `rp_valid` varchar(1) NOT NULL DEFAULT 'I',
  `rp_regDate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `rp_upDate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`rp_num`),
  KEY `rp_me_id_idx` (`rp_me_id`),
  KEY `rp_bd_num_idx` (`rp_bd_num`),
  CONSTRAINT `rp_bd_num` FOREIGN KEY (`rp_bd_num`) REFERENCES `board` (`num`),
  CONSTRAINT `rp_me_id` FOREIGN KEY (`rp_me_id`) REFERENCES `member` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reply`
--

LOCK TABLES `reply` WRITE;
/*!40000 ALTER TABLE `reply` DISABLE KEYS */;
INSERT INTO `reply` VALUES (1,51,'qwe','댓글1','I','2021-07-21 10:45:11','2021-07-21 10:45:11'),(2,51,'qwe','댓글2','I','2021-07-21 11:44:12','2021-07-21 11:44:12'),(3,51,'abcd1234','댓글3','I','2021-07-21 12:03:15','2021-07-21 12:03:15'),(4,51,'qwe','댓글4 - 수정123','I','2021-07-21 12:44:17','2021-07-22 10:06:10'),(5,51,'qwe','댓글5','D','2021-07-21 12:44:21','2021-07-21 16:50:46'),(6,51,'qwe','댓글5','I','2021-07-21 17:31:02','2021-07-21 17:31:02'),(7,51,'qwe','댓글6(수정)-4','I','2021-07-21 17:32:20','2021-07-22 11:20:28'),(8,53,'qwe','23일 댓글','I','2021-07-23 10:35:17','2021-07-23 10:35:17'),(9,53,'qwe','23일 댓글','I','2021-07-23 10:45:13','2021-07-23 10:45:13'),(10,53,'qwe','등록 11:04','I','2021-07-23 11:04:53','2021-07-23 11:04:53'),(11,53,'qwe','123','I','2021-07-23 11:06:12','2021-07-23 11:06:12'),(12,53,'qwe','new','I','2021-07-23 13:05:33','2021-07-23 13:05:33'),(13,53,'qwe','new2','D','2021-07-23 13:07:13','2021-07-23 13:07:13'),(14,53,'qwe','새로운 댓글','D','2021-07-23 14:28:53','2021-07-23 14:28:53'),(15,53,'qwe','댓글','I','2021-07-23 14:30:05','2021-07-23 14:30:05'),(16,53,'qwe','ㅂㅈㄷ - 7월 26일 수정','I','2021-07-23 14:30:22','2021-07-23 14:30:22'),(17,53,'qwe','ㅂㅈㄷ','I','2021-07-23 14:31:02','2021-07-23 14:31:02'),(18,53,'qwe','11 - 수정','I','2021-07-23 14:45:51','2021-07-23 14:45:51'),(19,53,'qwe','22 - 수정','I','2021-07-23 14:45:57','2021-07-23 14:45:57'),(20,53,'qwe','7월 26일 댓글','D','2021-07-26 09:38:43','2021-07-26 09:38:43'),(21,53,'qwe','수정 기능 123 - 댓글 수정','D','2021-07-26 10:39:58','2021-07-26 10:39:58'),(22,53,'abcd1234','댓글','I','2021-07-26 10:51:54','2021-07-26 10:51:54');
/*!40000 ALTER TABLE `reply` ENABLE KEYS */;
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
