-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: localhost    Database: canteendb
-- ------------------------------------------------------
-- Server version	8.0.26

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
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comment` (
  `cid` int NOT NULL AUTO_INCREMENT,
  `did` int NOT NULL,
  `uid` int NOT NULL,
  `sid` int NOT NULL,
  `date` datetime NOT NULL,
  `detail` varchar(100) COLLATE utf8_general_mysql500_ci NOT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_general_mysql500_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
INSERT INTO `comment` VALUES (1,1,2,1,'2023-04-17 11:29:35','测试');
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dishes`
--

DROP TABLE IF EXISTS `dishes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dishes` (
  `did` int NOT NULL AUTO_INCREMENT,
  `dname` varchar(45) COLLATE utf8_general_mysql500_ci NOT NULL,
  `dprice` int NOT NULL,
  `dimage` varchar(100) COLLATE utf8_general_mysql500_ci DEFAULT NULL,
  `sid` int NOT NULL,
  `detail` varchar(100) COLLATE utf8_general_mysql500_ci DEFAULT NULL,
  PRIMARY KEY (`did`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_general_mysql500_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dishes`
--

LOCK TABLES `dishes` WRITE;
/*!40000 ALTER TABLE `dishes` DISABLE KEYS */;
/*!40000 ALTER TABLE `dishes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `room`
--

DROP TABLE IF EXISTS `room`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `room` (
  `rid` int NOT NULL AUTO_INCREMENT,
  `rname` varchar(45) COLLATE utf8_general_mysql500_ci NOT NULL,
  `date` datetime NOT NULL,
  PRIMARY KEY (`rid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_general_mysql500_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `room`
--

LOCK TABLES `room` WRITE;
/*!40000 ALTER TABLE `room` DISABLE KEYS */;
INSERT INTO `room` VALUES (1,'一食堂','2023-04-16 17:09:37'),(2,'二食堂','2023-04-17 17:09:23'),(4,'三食堂','2023-04-16 18:29:04');
/*!40000 ALTER TABLE `room` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shop`
--

DROP TABLE IF EXISTS `shop`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shop` (
  `sid` int NOT NULL AUTO_INCREMENT,
  `sname` varchar(45) COLLATE utf8_general_mysql500_ci NOT NULL,
  `rid` int NOT NULL,
  `location` varchar(45) COLLATE utf8_general_mysql500_ci DEFAULT NULL,
  `manager` varchar(45) COLLATE utf8_general_mysql500_ci NOT NULL,
  `tel` char(11) COLLATE utf8_general_mysql500_ci NOT NULL,
  PRIMARY KEY (`sid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_general_mysql500_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shop`
--

LOCK TABLES `shop` WRITE;
/*!40000 ALTER TABLE `shop` DISABLE KEYS */;
INSERT INTO `shop` VALUES (1,'F+牛肉饭',1,'二楼最里面','未知','12345678910'),(2,'F-牛肉饭',2,'一楼最里面','蟹肉羹','12345678910');
/*!40000 ALTER TABLE `shop` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shopcar`
--

DROP TABLE IF EXISTS `shopcar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shopcar` (
  `carid` int NOT NULL AUTO_INCREMENT,
  `uid` int NOT NULL,
  `did` int NOT NULL,
  `sid` int NOT NULL,
  `count` int NOT NULL,
  PRIMARY KEY (`carid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_general_mysql500_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shopcar`
--

LOCK TABLES `shopcar` WRITE;
/*!40000 ALTER TABLE `shopcar` DISABLE KEYS */;
/*!40000 ALTER TABLE `shopcar` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `uid` int NOT NULL AUTO_INCREMENT,
  `uname` varchar(45) COLLATE utf8_general_mysql500_ci NOT NULL,
  `pwd` varchar(45) COLLATE utf8_general_mysql500_ci NOT NULL,
  `flag` char(1) COLLATE utf8_general_mysql500_ci NOT NULL DEFAULT 'c',
  `tel` char(11) COLLATE utf8_general_mysql500_ci NOT NULL,
  `uavatar` varchar(100) COLLATE utf8_general_mysql500_ci DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_general_mysql500_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'test','123','c','12345678910',NULL),(2,'代金龙','123','a','12345678910',NULL),(3,'王亦','123','c','12345678910',NULL),(4,'test1','123456','c','12345678910',NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-04-18 11:54:18
