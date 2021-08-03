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
-- Table structure for table `file`
--

DROP TABLE IF EXISTS `file`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `file` (
  `num` int NOT NULL AUTO_INCREMENT,
  `board` int NOT NULL,
  `name` varchar(255) NOT NULL,
  `state` varchar(1) NOT NULL DEFAULT 'I',
  `ori_name` varchar(255) NOT NULL,
  `thumbnail` varchar(1) NOT NULL DEFAULT 'N',
  PRIMARY KEY (`num`),
  KEY `board_idx` (`board`),
  CONSTRAINT `board` FOREIGN KEY (`board`) REFERENCES `board` (`num`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `file`
--

LOCK TABLES `file` WRITE;
/*!40000 ALTER TABLE `file` DISABLE KEYS */;
INSERT INTO `file` VALUES (1,40,'/2021/07/15/f83b9890-a2ad-4257-9a61-0bf256af3f39_.gitconfig','I','.gitconfig','N'),(2,41,'/2021/07/15/d1468e9c-7b68-4328-babf-7c368872c6e6_Squirrel-CheckForUpdate.log','D','Squirrel-CheckForUpdate.log','N'),(3,41,'/2021/07/15/4ef8eb3b-2a7e-49b7-a635-78ae09e88bf9_Squirrel-Shortcut.log','D','Squirrel-Shortcut.log','N'),(4,43,'/2021/07/16/d0691608-2890-4a5e-8aa4-55d86e773bf6_Squirrel-Shortcut.log','I','Squirrel-Shortcut.log','N'),(5,43,'/2021/07/16/7115fe5b-c00c-431e-8ed0-2b78d3b4e1b7_Squirrel-CheckForUpdate.log','D','Squirrel-CheckForUpdate.log','N'),(6,43,'/2021/07/16/c1e61df6-97c1-4775-8903-04d6db2467ff_Update.exe','D','Update.exe','N'),(7,43,'/2021/07/16/bf92ed18-353b-4c1a-a1e6-cb8e0496d634_20210716_자바_출석.PNG','I','20210716_자바_출석.PNG','N'),(8,44,'/2021/07/16/ebf8a71a-ae38-4f91-8400-00adf1640895_Zoom.exe','I','Zoom.exe','N'),(9,45,'/2021/07/16/80e6fc6a-8bca-467c-917e-f907c2233ff1_annoter.dll','I','annoter.dll','N'),(10,46,'/2021/07/19/7cf5167e-dc77-4c2e-8346-608a16c33c28_엑셀 평가 연습문제.xlsx','D','엑셀 평가 연습문제.xlsx','N'),(11,47,'/2021/07/19/d8bfc7af-eccd-4cb5-b8a1-bea33136d591_평가 연습문제.hwp','D','평가 연습문제.hwp','N'),(12,48,'/2021/07/19/9b7f6c55-ad28-4dd7-856a-804a2c114367_20210719_자바_출석.PNG','D','20210719_자바_출석.PNG','N'),(13,49,'/2021/07/19/2f9bbf77-b773-470c-bd14-6b3de6f66d48_eclipse.exe','D','eclipse.exe','N'),(14,49,'/2021/07/19/e27a7a0f-426f-492c-b98c-232a0c870e3c_eclipse.ini','D','eclipse.ini','N'),(15,48,'/2021/07/19/fddf16c9-c533-4a8d-87d7-3416d1690f98_eclipse.exe','I','eclipse.exe','N'),(16,64,'/2021/08/02/962e0be0-b5e4-472d-9103-0669490fc75d_20210721_자바_출석.PNG','I','20210721_자바_출석.PNG','N'),(17,65,'/2021/08/02/d248cdda-ca2f-47b8-8dda-a125022bb4ea_20210721_자바_출석.PNG','D','20210721_자바_출석.PNG','N'),(18,65,'/2021/08/02/0a08dde7-9543-4002-8d15-a8aca4a370c9_20210722_자바_출석.PNG','D','20210722_자바_출석.PNG','N'),(19,65,'/2021/08/02/c1d35b06-9cd1-4fd9-91b6-d50d564acbd4_20210723_자바_출석.PNG','D','20210723_자바_출석.PNG','N'),(20,66,'/2021/08/02/cc8c8bd3-d79e-4e3e-95ae-c8d926935f3c_20210723_자바_출석.PNG','D','20210723_자바_출석.PNG','N'),(21,67,'/2021/08/02/60db4b19-0bce-42ad-84ef-f488cd476b96_20210723_자바_출석.PNG','D','20210723_자바_출석.PNG','N'),(22,67,'/2021/08/02/19207bbc-ef6d-4278-9199-9da684d862dd_20210721_자바_출석.PNG','D','20210721_자바_출석.PNG','N'),(23,67,'/2021/08/02/26190e2c-88b7-4c5f-a034-0c31b14ff6f1_20210721_자바_출석.PNG','D','20210721_자바_출석.PNG','N'),(24,67,'/2021/08/02/fda0f333-a7f3-4ed9-b8b6-d9e68d35efef_20210726_자바_출석.PNG','I','20210726_자바_출석.PNG','N'),(25,67,'/2021/08/02/c1d68f1f-c63c-48c5-8d12-a0db398a2b4f_20210722_자바_출석.PNG','I','20210722_자바_출석.PNG','N'),(26,73,'/2021/08/02/fba5d606-f836-4947-887c-b8172a11ced9_20210723_자바_출석.PNG','D','20210723_자바_출석.PNG','N'),(27,74,'/2021/08/02/9b7c53fe-6cbd-4ca0-9cbc-6a337d104d52_20210721_자바_출석.PNG','D','20210721_자바_출석.PNG','N'),(28,74,'/2021/08/02/712dce2b-2f80-4f0f-ac3a-c7c299032d5c_20210722_자바_출석.PNG','D','20210722_자바_출석.PNG','N'),(29,74,'/2021/08/02/b170bd0b-7d8f-45ee-859a-5f18fbf0f6c3_20210723_자바_출석.PNG','D','20210723_자바_출석.PNG','N'),(30,74,'/2021/08/02/a8012d21-a310-4a0c-8dcb-3fbd73b94aab_20210721_자바_출석.PNG','D','20210721_자바_출석.PNG','N'),(31,74,'/2021/08/02/159ec0b5-1fc3-4470-b6ab-a3fa9fadcccf_20210722_자바_출석.PNG','D','20210722_자바_출석.PNG','N'),(32,74,'/2021/08/02/01b5975d-f5a2-4521-b225-c3ec64ab4e4a_20210728_자바_출석.PNG','I','20210728_자바_출석.PNG','N'),(33,74,'/2021/08/02/c02a71bc-4f04-48f5-99ff-3c9ad68f110b_20210728_자바_출석.PNG','I','20210728_자바_출석.PNG','N'),(34,75,'/2021/08/03/9f26169e-d43e-4659-927e-ea57fcd7edb3_20210721_자바_출석.PNG','I','20210721_자바_출석.PNG','N'),(35,76,'/2021/08/03/ba67d5c8-211d-46d7-9e61-b51cf81bf582_20210723_자바_출석.PNG','I','20210723_자바_출석.PNG','N'),(36,77,'/2021/08/03/e3186422-89c1-4469-80d8-51cefa52ae8a_20210721_자바_출석.PNG','I','20210721_자바_출석.PNG','N'),(37,77,'/2021/08/03/5df7590d-0504-4a2f-a246-898e77e5aab7_dog.jpg','I','dog.jpg','Y');
/*!40000 ALTER TABLE `file` ENABLE KEYS */;
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
