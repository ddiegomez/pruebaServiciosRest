CREATE DATABASE  IF NOT EXISTS `pruebaServicios` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `pruebaServicios`;
-- MySQL dump 10.13  Distrib 5.6.19, for osx10.7 (i386)
--
-- Host: localhost    Database: pruebaServicios
-- ------------------------------------------------------
-- Server version	5.6.21

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
-- Table structure for table `Customers`
--

DROP TABLE IF EXISTS `Customers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Customers` (
  `CUSTOMER_ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(45) DEFAULT NULL,
  `LASTNAME` varchar(45) DEFAULT NULL,
  `PHONE` varchar(45) DEFAULT NULL,
  `EMAIL` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`CUSTOMER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Customers`
--

LOCK TABLES `Customers` WRITE;
/*!40000 ALTER TABLE `Customers` DISABLE KEYS */;
INSERT INTO `Customers` VALUES (1,'AA','AAAA','123456789','correo@domino.com'),(2,'BB','BBBB','123456789','correo@domino.com'),(3,'CC','CCCC','123456789','correo@domino.com'),(4,'DD','DDDD','123456789','correo@domino.com'),(5,'EE','EEEE','123456789','correo@domino.com'),(6,'FF','FFFF','123456789','correo@domino.com'),(7,'GG','GGGG','123456789',NULL);
/*!40000 ALTER TABLE `Customers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Invoices`
--

DROP TABLE IF EXISTS `Invoices`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Invoices` (
  `INVOICE_ID` int(11) NOT NULL AUTO_INCREMENT,
  `DATE` datetime DEFAULT NULL,
  `PAID` int(11) DEFAULT NULL,
  `YEAR` int(11) DEFAULT NULL,
  `CUSTOMER_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`INVOICE_ID`),
  KEY `CUSTOMER_ID_FK_idx` (`CUSTOMER_ID`),
  CONSTRAINT `CUSTOMER_ID_FK` FOREIGN KEY (`CUSTOMER_ID`) REFERENCES `Customers` (`CUSTOMER_ID`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Invoices`
--

LOCK TABLES `Invoices` WRITE;
/*!40000 ALTER TABLE `Invoices` DISABLE KEYS */;
INSERT INTO `Invoices` VALUES (1,'2015-01-01 00:00:00',1,2015,1),(2,'2015-12-19 08:23:46',0,2015,1),(3,'2015-12-19 08:26:50',0,2015,1),(4,'2015-12-19 08:27:25',0,2015,1),(5,'2015-12-19 08:27:26',0,2015,1),(6,'2015-12-19 08:27:26',0,2015,1),(7,'2015-12-19 08:27:27',0,2015,1),(8,'2015-12-19 08:27:27',0,2015,1),(9,'2015-12-19 08:27:27',0,2015,1),(10,'2015-12-19 08:30:17',0,2015,1);
/*!40000 ALTER TABLE `Invoices` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `InvoicesProducts`
--

DROP TABLE IF EXISTS `InvoicesProducts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `InvoicesProducts` (
  `INVOICE_PRODUCT_ID` int(11) NOT NULL AUTO_INCREMENT,
  `INVOICE_ID` int(11) NOT NULL,
  `PRODUCT_ID` int(11) NOT NULL,
  `QUANTITY` int(11) NOT NULL,
  `PRICE` varchar(45) NOT NULL,
  `TAX` int(11) DEFAULT NULL,
  PRIMARY KEY (`INVOICE_PRODUCT_ID`),
  KEY `PRODUCT_ID_FK_idx` (`PRODUCT_ID`),
  KEY `INVOICE_ID_FK_idx` (`INVOICE_ID`),
  CONSTRAINT `INVOICE_ID_FK` FOREIGN KEY (`INVOICE_ID`) REFERENCES `Invoices` (`INVOICE_ID`) ON UPDATE CASCADE,
  CONSTRAINT `PRODUCT_ID_FK` FOREIGN KEY (`PRODUCT_ID`) REFERENCES `Products` (`PRODUCT_ID`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `InvoicesProducts`
--

LOCK TABLES `InvoicesProducts` WRITE;
/*!40000 ALTER TABLE `InvoicesProducts` DISABLE KEYS */;
INSERT INTO `InvoicesProducts` VALUES (1,1,2,2,'14.00',21),(2,1,1,2,'10.20',21),(3,10,1,1,'10.2',21),(4,10,2,3,'14.0',21);
/*!40000 ALTER TABLE `InvoicesProducts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Products`
--

DROP TABLE IF EXISTS `Products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Products` (
  `PRODUCT_ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(45) DEFAULT NULL,
  `DESCRIPTION` varchar(45) DEFAULT NULL,
  `PRICE` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`PRODUCT_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Products`
--

LOCK TABLES `Products` WRITE;
/*!40000 ALTER TABLE `Products` DISABLE KEYS */;
INSERT INTO `Products` VALUES (1,'Producto 1','Es un producto 1','10.20'),(2,'Producto 2','Es el producto 2','14.00'),(3,'Producto 3','Es el producto 3','24.99'),(4,'Producto 4','Es el producto 4','23.45');
/*!40000 ALTER TABLE `Products` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-12-19  8:44:53
