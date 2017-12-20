-- MySQL dump 10.13  Distrib 5.7.17, for Win32 (AMD64)
--
-- Host: 127.0.0.1    Database: multi_mall
-- ------------------------------------------------------
-- Server version	5.7.17

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `tb_category`
--

DROP TABLE IF EXISTS `tb_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `description` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `content` text COLLATE utf8_unicode_ci,
  `create_time` datetime NOT NULL,
  `last_modify_time` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `category_title_uindex` (`title`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_category`
--

LOCK TABLES `tb_category` WRITE;
/*!40000 ALTER TABLE `tb_category` DISABLE KEYS */;
INSERT INTO `tb_category` VALUES (1,'手机','这里没有内容','这里没有简介','2017-12-20 18:12:47','2017-12-20 18:12:50'),(3,'电脑','电脑是你另外一个女朋友，一定要好好对待','你要写歌，会Hello World','2017-12-20 21:17:41','2017-12-20 21:17:41');
/*!40000 ALTER TABLE `tb_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_category_tag`
--

DROP TABLE IF EXISTS `tb_category_tag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_category_tag` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tag_name` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `category_id` int(11) DEFAULT NULL,
  `create_time` datetime NOT NULL,
  `last_modify_time` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `tb_category_tag_tag_name_uindex` (`tag_name`),
  KEY `tb_category_tag_tb_category_id_fk` (`category_id`),
  CONSTRAINT `tb_category_tag_tb_category_id_fk` FOREIGN KEY (`category_id`) REFERENCES `tb_category` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_category_tag`
--

LOCK TABLES `tb_category_tag` WRITE;
/*!40000 ALTER TABLE `tb_category_tag` DISABLE KEYS */;
INSERT INTO `tb_category_tag` VALUES (1,'2017新款',1,'2017-12-20 13:22:13','2017-12-20 13:22:19'),(4,'双11促销',3,'2017-12-20 21:23:26','2017-12-20 21:23:26'),(5,'年中大促销',1,'2017-12-20 21:45:52','2017-12-20 21:45:52');
/*!40000 ALTER TABLE `tb_category_tag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_product`
--

DROP TABLE IF EXISTS `tb_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `price` double NOT NULL,
  `content` text COLLATE utf8_unicode_ci,
  `is_tao_bao` varchar(2) COLLATE utf8_unicode_ci DEFAULT NULL,
  `link` varchar(300) COLLATE utf8_unicode_ci DEFAULT NULL,
  `category_id` int(11) DEFAULT NULL,
  `create_time` datetime NOT NULL,
  `last_modify_time` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `tb_product_title_uindex` (`title`),
  KEY `tb_product_tb_category_id_fk` (`category_id`),
  CONSTRAINT `tb_product_tb_category_id_fk` FOREIGN KEY (`category_id`) REFERENCES `tb_category` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_product`
--

LOCK TABLES `tb_product` WRITE;
/*!40000 ALTER TABLE `tb_product` DISABLE KEYS */;
INSERT INTO `tb_product` VALUES (11,'一加3手机荣耀登场，走过路过不要错过,+99换赠酸枝保护套',0,'看看不要钱','y','www.google.com',1,'2017-12-20 18:12:36','2017-12-20 18:12:41');
/*!40000 ALTER TABLE `tb_product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_product_tag`
--

DROP TABLE IF EXISTS `tb_product_tag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_product_tag` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tag_name` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `product_id` int(11) NOT NULL,
  `create_time` datetime NOT NULL,
  `last_modify_time` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `tb_product_tag_tb_product_id_fk` (`product_id`),
  CONSTRAINT `tb_product_tag_tb_product_id_fk` FOREIGN KEY (`product_id`) REFERENCES `tb_product` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_product_tag`
--

LOCK TABLES `tb_product_tag` WRITE;
/*!40000 ALTER TABLE `tb_product_tag` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_product_tag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_user`
--

DROP TABLE IF EXISTS `tb_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `pwd` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `avatar` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `phone` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `location` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `last_modify_time` datetime NOT NULL,
  `create_time` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `tb_user_username_uindex` (`username`),
  UNIQUE KEY `tb_user_email_uindex` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=9530 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_user`
--

LOCK TABLES `tb_user` WRITE;
/*!40000 ALTER TABLE `tb_user` DISABLE KEYS */;
INSERT INTO `tb_user` VALUES (9529,'tianyeling','nihaoma','nihao.jpg','tianyeling@163.com','13645857110',NULL,'2017-12-13 16:52:51','2017-12-13 15:49:22');
/*!40000 ALTER TABLE `tb_user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-12-20 22:46:52
