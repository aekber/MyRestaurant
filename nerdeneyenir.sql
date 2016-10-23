CREATE DATABASE  IF NOT EXISTS `nerdeneyenir` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `nerdeneyenir`;
-- MySQL dump 10.13  Distrib 5.5.38, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: nerdeneyenir
-- ------------------------------------------------------
-- Server version	5.5.38-0ubuntu0.12.04.1

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
-- Table structure for table `food`
--

DROP TABLE IF EXISTS `food`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `food` (
  `foodid` int(11) NOT NULL AUTO_INCREMENT,
  `categoryid` int(11) DEFAULT NULL,
  `restaurantid` int(11) DEFAULT NULL,
  `isfoodactive` tinyint(1) DEFAULT '1',
  `foodname` varchar(100) COLLATE utf8_turkish_ci DEFAULT NULL,
  `comment` text COLLATE utf8_turkish_ci,
  `popularity` int(11) DEFAULT NULL,
  `insertdate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updatedate` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`foodid`)
) ENGINE=InnoDB AUTO_INCREMENT=1020 DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `food`
--

LOCK TABLES `food` WRITE;
/*!40000 ALTER TABLE `food` DISABLE KEYS */;
INSERT INTO `food` VALUES (1001,2001,3001,1,'Adana Kebap','Adana Kebap-ilk defa bu sekilde kotu geldi. Her zaman taze gelen ekmek bu sefer buzluktan cikarilmis sekilde geldi. \n\nNormalde citir citir olan sandvic ekmegini sanirim hazirlayip buzdolabina atmislar. ',1,'2014-07-28 20:24:32','2014-11-10 20:12:53'),(1002,2002,3002,1,'Burmalı Kadayif','Burmali Kadayif-ilk defa bu sekilde kotu geldi. Her zaman taze gelen ekmek bu sefer buzluktan cikarilmis sekilde geldi. Normalde citir citir olan sandvic ekmegini sanirim hazirlayip buzdolabina atmislar. Yiyemedim biraktim. Normalde yapmazlardi sasirdim. Hazir dolaptan gelecekse migrostan hazir sandvic alirdim yani.',1,'2014-07-29 11:13:49','2014-08-30 14:34:12'),(1003,2003,3001,1,'Kavurmalı Pide','Kavurmali Pide-ilk defa bu sekilde kotu geldi. Her zaman taze gelen ekmek bu sefer buzluktan cikarilmis sekilde geldi. Normalde citir citir olan sandvic ekmegini sanirim hazirlayip buzdolabina atmislar. Yiyemedim biraktim. Normalde yapmazlardi sasirdim. Hazir dolaptan gelecekse migrostan hazir sandvic alirdim yani.',1,'2014-07-29 11:22:53','2014-08-30 10:46:24'),(1005,2001,3002,1,'Patlıcan Kebabı','Patlican Kebabi-ilk defa bu sekilde kotu geldi. Her zaman taze gelen ekmek bu sefer buzluktan cikarilmis sekilde geldi. Normalde citir citir olan sandvic ekmegini sanirim hazirlayip buzdolabina atmislar. Yiyemedim biraktim. Normalde yapmazlardi sasirdim. Hazir dolaptan gelecekse migrostan hazir sandvic alirdim yani.',0,'2014-08-01 19:34:50','2014-09-01 08:16:40'),(1006,2002,3002,1,'Sütlü Nurettin','Sütlü Nurettin-ilk defa bu sekilde kotu geldi. Her zaman taze gelen ekmek bu sefer buzluktan cikarilmis sekilde geldi. Normalde citir citir olan sandvic ekmegini sanirim hazirlayip buzdolabina atmislar. Yiyemedim biraktim. Normalde yapmazlardi sasirdim. Hazir dolaptan gelecekse migrostan hazir sandvic alirdim yani.',0,'2014-08-01 19:38:41','2014-08-17 19:22:04'),(1007,2009,3003,1,'Su Böreği','Su Böregi-ilk defa bu sekilde kotu geldi. Her zaman taze gelen ekmek bu sefer buzluktan cikarilmis sekilde geldi. Normalde citir citir olan sandvic ekmegini sanirim hazirlayip buzdolabina atmislar. Yiyemedim biraktim. Normalde yapmazlardi sasirdim. Hazir dolaptan gelecekse migrostan hazir sandvic alirdim yani.',0,'2014-08-02 07:04:26','2014-08-30 10:46:12'),(1008,2001,3001,1,'Denemeci','denemeci-ilk defa bu sekilde kotu geldi. Her zaman taze gelen ekmek bu sefer buzluktan cikarilmis sekilde geldi. Normalde citir citir olan sandvic ekmegini sanirim hazirlayip buzdolabina atmislar. Yiyemedim biraktim. Normalde yapmazlardi sasirdim. Hazir dolaptan gelecekse migrostan hazir sandvic alirdim yani.',0,'2014-08-02 12:51:48','2014-08-19 05:30:31'),(1009,2001,3001,1,'Tavuk Kebap','bilocan-ilk defa bu sekilde kotu geldi. Her zaman taze gelen ekmek bu sefer buzluktan cikarilmis sekilde geldi. Normalde citir citir olan sandvic ekmegini sanirim hazirlayip buzdolabina atmislar. Yiyemedim biraktim. Normalde yapmazlardi sasirdim. Hazir dolaptan gelecekse migrostan hazir sandvic alirdim yani.',0,'2014-08-02 22:37:30','2014-08-18 08:05:04'),(1012,2002,3003,0,'Künefe','Künefe-ilk defa bu sekilde kotu geldi. Her zaman taze gelen ekmek bu sefer buzluktan cikarilmis sekilde geldi. Normalde citir citir olan sandvic ekmegini sanirim hazirlayip buzdolabina atmislar. Yiyemedim biraktim. Normalde yapmazlardi sasirdim. Hazir dolaptan gelecekse migrostan hazir sandvic alirdim yani.',0,'2014-08-04 17:43:11','2014-08-17 19:21:49'),(1013,2002,3005,1,'Güllaç','Gullac-ilk defa bu sekilde kotu geldi. Her zaman taze gelen ekmek bu sefer buzluktan cikarilmis sekilde geldi. Normalde citir citir olan sandvic ekmegini sanirim hazirlayip buzdolabina atmislar. Yiyemedim biraktim. Normalde yapmazlardi sasirdim. Hazir dolaptan gelecekse migrostan hazir sandvic alirdim yani.',0,'2014-08-11 16:49:12','2014-09-01 08:16:56'),(1014,2009,3008,1,'Çiğ Börek','Konya\'nın cazibe merkezi olan Mengüç Caddesi\'nde restore edilmiş tarihi Konya evlerinin bulunduğu bölge olan Konya Kültür Sokağı\'nda otantik bir Konya evinde 150 kişi kapasiteli 4 oda ve kamelyadan oluşan mekanda kültür ile iç içe Konya\'nın geleneksel yemeği olan Etliekmek lezzeti.',0,'2014-08-24 13:16:01','2014-08-30 10:42:42'),(1015,2002,3009,0,'teryted','hfhukfgkugk?gk',0,'2014-08-24 18:28:02','2014-08-24 18:18:11'),(1016,2010,3010,1,'Dondurma','Masanın başında, dondurma vitrinin arkasında külaha dondurmayı koyan, dondurma döven, dört kuşaktır bu müze olmuş pastane adı dondurma ile bütünleşmiş MADO nun doğduğu yerdir.\n\nHerşeyi yerinde yemek lazım ve dondurmayı da Yaşar Pastanesinde ilk olarak deneyin derim küçük bir dip not keçi sütüyle yapılmış en güzel dondurmayı tadabileceğiniz yer..',0,'2014-08-27 18:05:48','2014-08-30 08:34:50'),(1017,2001,3011,1,'Adana Kebap','Salaş ama mükemmel bir mekan.Kebapları, özellikle Adana kebap mükemmel.Mezeler gerçekten harika.Fiyatlar çok normal.Ağız tadıyla rakı meze kebap yapılacak ender mekanlardan biri.',0,'2014-08-29 18:55:16','2014-08-30 08:32:56'),(1018,2001,3012,1,'Balık Izgara','This code simply creates a cursor querying all the records of the table tbl_countries. The moveToFirst() method is used to position the cursor pointer at the beginning of the data set. \n\nThen loop through the records in the cursor. The method isAfterLast() returns a boolean if the pointer is past the last record in the cursor. Use the moveToNext() method to traverse through the records in the cursor. ',0,'2014-09-08 19:49:22','2014-09-08 19:47:09'),(1019,2001,3013,0,'ribbo porsiyon','İç piyasada altının gramının 80 liraya gerileyebileceğini, ons fiyatının 1.000 dolara inmesi halinde altının iç piyasadaki gram fiyatı ile ilgili 65-70 liraların konuşulabileceğini vurgulayan Karlıova, altının gramının mart ayına kadar 80 ila 87 lira arasında dalgalanabileceğini kaydetti. Fiyatların gerilemesiyle altın borcu olanlarla düğünü olanların Kapalıçarşı\'ya rağbet ettiğine dikkati çeken Karlıova, bu ilginin, altının gerçek fiyatının üzerinde olmasını sağladığına da belirterek şöyle devam etti:',0,'2014-11-07 10:45:58','2014-11-07 10:43:33');
/*!40000 ALTER TABLE `food` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `foodcategory`
--

DROP TABLE IF EXISTS `foodcategory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `foodcategory` (
  `foodcategoryid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) COLLATE utf8_turkish_ci NOT NULL,
  PRIMARY KEY (`foodcategoryid`)
) ENGINE=InnoDB AUTO_INCREMENT=2011 DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `foodcategory`
--

LOCK TABLES `foodcategory` WRITE;
/*!40000 ALTER TABLE `foodcategory` DISABLE KEYS */;
INSERT INTO `foodcategory` VALUES (2001,'Kebaplar'),(2002,'Tatlılar'),(2003,'Pideler'),(2004,'Zeytin Yağlılar'),(2008,'Kahvaltılar'),(2009,'Börekler'),(2010,'Dondurmalar');
/*!40000 ALTER TABLE `foodcategory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `foodimage`
--

DROP TABLE IF EXISTS `foodimage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `foodimage` (
  `foodimageid` int(11) NOT NULL AUTO_INCREMENT,
  `foodid` int(11) NOT NULL,
  `image` varchar(100) COLLATE utf8_turkish_ci DEFAULT NULL,
  `insertdate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`foodimageid`)
) ENGINE=InnoDB AUTO_INCREMENT=5052 DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `foodimage`
--

LOCK TABLES `foodimage` WRITE;
/*!40000 ALTER TABLE `foodimage` DISABLE KEYS */;
INSERT INTO `foodimage` VALUES (5001,1001,'1408876534884.jpg','2014-08-11 14:56:33'),(5003,1005,'1407876641387.jpg','2014-08-12 20:52:49'),(5004,1009,'1408719904372.jpg','2014-08-12 20:52:49'),(5005,1008,'1408719869270.jpg','2014-08-12 20:52:49'),(5006,1001,'1407942816233.jpg','2014-08-12 20:52:49'),(5007,1002,'1407876641387.jpg','2014-08-12 20:52:49'),(5008,1002,'1407876641387.jpg','2014-08-12 20:52:49'),(5009,1003,'1407876641387.jpg','2014-08-12 20:52:49'),(5010,1003,'1407876641387.jpg','2014-08-12 20:52:49'),(5011,1005,'1407876641387.jpg','2014-08-12 20:52:49'),(5012,1006,'1407876641387.jpg','2014-08-12 20:52:49'),(5013,1006,'1407876641387.jpg','2014-08-12 20:52:49'),(5014,1007,'1407876641387.jpg','2014-08-12 20:52:49'),(5015,1007,'1407876641387.jpg','2014-08-12 20:52:49'),(5016,1008,'1407876641387.jpg','2014-08-12 20:52:49'),(5017,1009,'1407876641387.jpg','2014-08-12 20:52:49'),(5018,1012,'1407876641387.jpg','2014-08-12 20:52:49'),(5019,1012,'1407876641387.jpg','2014-08-12 20:52:49'),(5020,1013,'1407876641387.jpg','2014-08-12 20:52:49'),(5021,1013,'1407876641387.jpg','2014-08-12 20:52:49'),(5022,1001,'1407943613964.jpg','2014-08-13 15:26:56'),(5023,1014,'1408996366276.jpg','2014-08-24 13:51:24'),(5041,1016,'1409337819006.jpg','2014-08-29 18:43:40'),(5042,1016,'1409337839019.jpg','2014-08-29 18:44:02'),(5043,1016,'1409337859232.jpg','2014-08-29 18:44:22'),(5044,1017,'1410417424736.jpg','2014-08-29 19:00:06'),(5045,1017,'1410417398815.jpg','2014-08-29 19:00:11'),(5050,1018,'1410205832327.jpg','2014-09-08 19:50:34');
/*!40000 ALTER TABLE `foodimage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `restaurant`
--

DROP TABLE IF EXISTS `restaurant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `restaurant` (
  `restaurantid` int(11) NOT NULL AUTO_INCREMENT,
  `addressid` int(11) DEFAULT NULL,
  `isrestaurantactive` tinyint(1) DEFAULT '1',
  `name` varchar(100) COLLATE utf8_turkish_ci NOT NULL,
  `insertdate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updatedate` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`restaurantid`)
) ENGINE=InnoDB AUTO_INCREMENT=3014 DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `restaurant`
--

LOCK TABLES `restaurant` WRITE;
/*!40000 ALTER TABLE `restaurant` DISABLE KEYS */;
INSERT INTO `restaurant` VALUES (3001,4001,1,'Eyvan Et Lokantası','2014-07-28 20:25:32','2014-08-30 10:46:54'),(3002,4002,1,'İmam Çağdaş','2014-07-31 20:02:45','2014-08-30 08:30:46'),(3003,4004,1,'Sahan Et Lokantası','2014-08-01 20:55:28','2014-09-19 10:42:00'),(3005,4005,1,'Kebabçı Celal','2014-08-02 07:12:44','2014-09-19 10:41:24'),(3008,4008,1,'Zahide Ev Yemekleri A.Ş','2014-08-24 13:15:08','2014-09-12 09:36:45'),(3009,4009,0,'Sen pişir ben yiyim','2014-08-24 18:26:08','2014-08-30 09:16:55'),(3010,4010,1,'Yaşar Pastanesi','2014-08-27 17:58:54','2014-08-30 09:18:36'),(3011,4011,1,'Öz Asma Altı Kebap Salonu ','2014-08-29 18:54:17','2014-09-19 10:41:13'),(3012,4012,1,'Tuzla Balıkçısı','2014-09-08 19:48:28','2014-09-08 19:48:28'),(3013,4013,0,'ribbo','2014-11-07 10:45:02','2014-11-07 10:45:02');
/*!40000 ALTER TABLE `restaurant` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `restaurantaddress`
--

DROP TABLE IF EXISTS `restaurantaddress`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `restaurantaddress` (
  `restaddresid` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(300) COLLATE utf8_turkish_ci NOT NULL,
  `province` varchar(60) COLLATE utf8_turkish_ci DEFAULT NULL,
  `phone` varchar(50) COLLATE utf8_turkish_ci NOT NULL,
  `website` varchar(100) COLLATE utf8_turkish_ci DEFAULT NULL,
  `latitude` decimal(10,8) NOT NULL,
  `longitude` decimal(11,8) NOT NULL,
  PRIMARY KEY (`restaddresid`)
) ENGINE=InnoDB AUTO_INCREMENT=4014 DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `restaurantaddress`
--

LOCK TABLES `restaurantaddress` WRITE;
/*!40000 ALTER TABLE `restaurantaddress` DISABLE KEYS */;
INSERT INTO `restaurantaddress` VALUES (4001,'Turgut Özal Bulvari No:25 Seyhan','Adana','03222352569','http://www.eyvankebap.com.tr',36.98823000,35.32054200),(4002,'Karataş mah. 404 sokak no:20 Şahinbey','Gaziantep','03423393134','http://www.imamcagdas.com',36.98823000,35.32054200),(4004,'denememe emememe meme','Gaziantep','02123692514','http://www.ddd.cc',36.98823000,35.32054200),(4005,'vevrev revrv  vrve','İzmir','452352432','http://www.xxx.cc.tr',36.98823000,35.32054200),(4006,'?smet Pa?a Mh. 46100','Kahramanmara?','+90 344 225 0808','http://www.yasardondurma.com',36.98823000,35.32054200),(4007,'knlkjbhkjbhkljn lhklnjlkjlk jlhjkhkjhkj','Ankara','0156564564654','http://www.ddd.cc',36.98823000,35.32054200),(4008,'knlkjbhkjbhkljn lhklnjlkjlk ğşüçöıİĞÜŞÇÖ','Ankara','02123692514','http://www.ddd.cc',36.98823000,35.32054200),(4009,'deneme adress','İstanbul','7687687687','rytytrtyryt',36.98823000,35.32054200),(4010,'İsmetpaşa Mah. Trabzon Cad. 46000','Kahramanmaraş','(0344) 225 0808','http://www.mado.com.tr/',36.98823000,35.32054200),(4011,'Kocavezir Mah. Pazarlar Cd No:11 Kuruköprü','Antalya','(0322) 351 4028','',36.98823000,35.32054200),(4012,'dfdfdsfsdf','İstanbul','02163213232','http://www.ddd.cc',36.98823000,35.32054200),(4013,'sdad','Adana','44234234','errwrwr',25.23232300,25.23232300);
/*!40000 ALTER TABLE `restaurantaddress` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `user_name` varchar(15) NOT NULL,
  `user_pass` varchar(128) NOT NULL,
  PRIMARY KEY (`user_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('ekber','202cb962ac59075b964b07152d234b70');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_role` (
  `user_name` varchar(15) NOT NULL,
  `role_name` varchar(15) NOT NULL,
  PRIMARY KEY (`user_name`,`role_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES ('ekber','admin');
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-11-14 23:23:18
