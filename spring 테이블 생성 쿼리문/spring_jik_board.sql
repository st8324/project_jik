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
-- Table structure for table `board`
--

DROP TABLE IF EXISTS `board`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `board` (
  `num` int NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `contents` longtext NOT NULL,
  `writer` varchar(15) NOT NULL,
  `registered` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `views` int NOT NULL DEFAULT '0',
  `valid` varchar(1) NOT NULL DEFAULT 'I',
  `type` varchar(45) NOT NULL DEFAULT 'NORMAL',
  `oriNo` int NOT NULL,
  `groupOrd` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`num`),
  KEY `writer_idx` (`writer`),
  CONSTRAINT `writer` FOREIGN KEY (`writer`) REFERENCES `member` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=78 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `board`
--

LOCK TABLES `board` WRITE;
/*!40000 ALTER TABLE `board` DISABLE KEYS */;
INSERT INTO `board` VALUES (40,'qwe','qwe','qwe','2021-07-15 15:42:57',20,'I','NORMAL',40,0),(41,'다중 첨부파일','다중','qwe','2021-07-15 16:32:41',21,'D','NORMAL',41,0),(42,'첨부','첨부','qwe','2021-07-16 09:43:18',1,'D','NORMAL',42,0),(43,'첨부첨부','','qwe','2021-07-16 10:31:52',5,'I','NORMAL',43,0),(44,'7월 16일','','qwe','2021-07-16 15:31:42',0,'I','NORMAL',44,0),(45,'첨부 테스트','','qwe','2021-07-16 15:34:40',27,'I','NORMAL',45,0),(46,'7월 19일','ㄴㄴ','qwe','2021-07-19 11:00:01',1,'D','NORMAL',46,0),(47,'7월 19일','ㄴㄴ','qwe','2021-07-19 11:04:01',1,'D','NORMAL',47,0),(48,'7월 19일(수정)','dd','qwe','2021-07-19 11:12:21',18,'I','NORMAL',48,0),(49,'7월 19일(첨부 없음)','','qwe','2021-07-19 14:21:35',7,'I','NORMAL',49,0),(50,'써머노트 테스트','<p><span style=\"background-color: rgb(255, 255, 0);\">안녕하세요.</span></p>','qwe','2021-07-19 16:19:05',6,'I','NORMAL',50,0),(51,'써머노트','<h1>제목 테스트</h1><p><font color=\"#000000\"><span style=\"background-color: rgb(255, 255, 0);\">안녕하세요.</span></font></p><ul><li><font color=\"#000000\"><span style=\"background-color: rgb(255, 255, 0);\">내용1</span></font></li><li><font color=\"#000000\"><span style=\"background-color: rgb(255, 255, 0);\">내용2</span></font></li><li><a href=\"http://www.naver.com\" target=\"_blank\">네이버</a></li><li><font color=\"#000000\"><span style=\"background-color: rgb(255, 255, 0);\"><br></span></font></li></ul>','qwe','2021-07-19 16:22:38',213,'I','NORMAL',51,0),(52,'문의합니다.','<p><font color=\"#000000\" style=\"background-color: rgb(255, 0, 0);\">ㅇㅇ</font></p>','qwe','2021-07-22 10:52:55',3,'I','NORMAL',52,0),(53,'문의하신 내용의 답변입니다','<h1>7월 22일 테스트</h1><p><br></p><h1>7월 22일 테스트</h1>','qwe','2021-07-22 10:59:45',269,'I','NORMAL',52,1),(54,'새로운 답변입니다','답변입니다.','qweqweqwe','2021-07-30 10:45:48',1,'I','NORMAL',52,2),(55,'123','123','qwe','2021-07-30 12:20:52',0,'I','NORMAL',55,0),(56,'7월 30일','내용','qwe','2021-07-30 12:30:08',1,'I','NORMAL',56,0),(57,'문의합니다','문의','qwe','2021-07-30 12:31:01',0,'I','NORMAL',57,0),(58,'문의합니다','문의하신 내용은 xxx하면 됩니다.','qwe','2021-07-30 12:44:09',0,'I','NORMAL',57,1),(59,'문의합니다 답변','ㅇㅇㅇ','qwe','2021-07-30 12:44:28',0,'I','NORMAL',57,2),(60,'문의합니다-수정','수정된 내용','qwe','2021-07-30 12:45:00',0,'D','NORMAL',60,0),(61,'문의합니다2','문의한 내용은 xxx','qwe','2021-07-30 12:49:37',0,'D','NORMAL',60,1),(62,'7월 19일','답변 내용','qwe','2021-08-02 09:55:43',0,'I','NORMAL',46,1),(63,'8월 2일 게시글','내용','qwe','2021-08-02 11:08:00',0,'I','NORMAL',63,0),(64,'8월2일 첨부 테스트','테스트','qwe','2021-08-02 11:42:15',3,'I','NORMAL',64,0),(65,'첨부 테스트2','','qwe','2021-08-02 11:43:05',8,'D','NORMAL',65,0),(66,'8월 2일 13시','ㅇㅇ','qwe','2021-08-02 12:59:18',2,'D','NORMAL',66,0),(67,'첨부2개','<font color=\"#000000\" style=\"background-color: rgb(255, 255, 0);\">첨부 2개</font>','qwe','2021-08-02 14:19:44',10,'I','NORMAL',67,0),(68,'일반게시판','<p>ㅇㅇ</p>','qwe','2021-08-02 15:43:26',1,'I','NORMAL',68,0),(69,'공지사항입니다','<p>공지사항입니다<br></p>','qwe','2021-08-02 15:48:24',10,'I','NOTICE',69,0),(70,'공지사항2','<p>공지사항</p>','qwe','2021-08-02 16:17:18',1,'I','NOTICE',70,0),(71,'공지사항3','<p>공지사항</p>','qwe','2021-08-02 16:17:42',0,'I','NOTICE',71,0),(72,'공지','','qwe','2021-08-02 16:18:13',2,'I','NOTICE',72,0),(73,'공지사항4','<p>00</p>','qwe','2021-08-02 16:19:37',3,'D','NOTICE',73,0),(74,'123','<p>123</p>','qwe','2021-08-02 17:27:02',11,'I','NORMAL',74,0),(75,'8월 3일','<p>ㅇㅇ</p>','qwe','2021-08-03 10:13:57',1,'I','NORMAL',75,0),(76,'8월 3일 공지사항','<p>ㅇㅇ</p>','qwe','2021-08-03 10:14:14',1,'I','NOTICE',76,0),(77,'여름 할인','<p>ㅇㅇㅇㅇㅇ</p>','qwe','2021-08-03 10:15:32',0,'I','IMAGE',77,0);
/*!40000 ALTER TABLE `board` ENABLE KEYS */;
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
