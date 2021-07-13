-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: 39.105.189.229    Database: CRM_Project
-- ------------------------------------------------------
-- Server version	8.0.21

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `PublicPond`
--

DROP TABLE IF EXISTS `PublicPond`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `PublicPond` (
  `PublicPond_Id` int NOT NULL AUTO_INCREMENT,
  `emp_id` int DEFAULT NULL,
  `PublicPond_Name` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `TimeLiness` int DEFAULT '0',
  PRIMARY KEY (`PublicPond_Id`),
  KEY `FK_Reference_26` (`emp_id`),
  CONSTRAINT `FK_Reference_26` FOREIGN KEY (`emp_id`) REFERENCES `employee` (`emp_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `PublicPond_chk_1` CHECK (((`TimeLiness` = 0) or (`TimeLiness` = 1)))
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PublicPond`
--

LOCK TABLES `PublicPond` WRITE;
/*!40000 ALTER TABLE `PublicPond` DISABLE KEYS */;
INSERT INTO `PublicPond` VALUES (1,1,'线索公海',0),(2,2,'客户公海',0);
/*!40000 ALTER TABLE `PublicPond` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `activity`
--

DROP TABLE IF EXISTS `activity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `activity` (
  `Activity_Id` int NOT NULL AUTO_INCREMENT,
  `emp_id` int DEFAULT NULL,
  `Activity_Name` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `Add_Time` timestamp NULL DEFAULT NULL,
  `End_Time` timestamp NULL DEFAULT NULL,
  `Address` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `Activity_State` int DEFAULT NULL,
  `PlanIncome` decimal(12,2) DEFAULT NULL,
  `ActualIncome` decimal(12,2) DEFAULT NULL,
  `ProfitLoss` decimal(12,2) DEFAULT NULL,
  `Activity_Plan` varchar(500) COLLATE utf8_bin DEFAULT NULL,
  `TimeLiness` int DEFAULT '0',
  PRIMARY KEY (`Activity_Id`),
  KEY `FK_Reference_24` (`emp_id`),
  CONSTRAINT `FK_Reference_24` FOREIGN KEY (`emp_id`) REFERENCES `employee` (`emp_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `activity_chk_1` CHECK (((`TimeLiness` = 0) or (`TimeLiness` = 1)))
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `activity`
--

LOCK TABLES `activity` WRITE;
/*!40000 ALTER TABLE `activity` DISABLE KEYS */;
INSERT INTO `activity` VALUES (1,1,'集团六周年庆典','2021-07-12 15:20:04','2021-07-12 15:20:16','湖南株洲',2,100000.00,570000.00,470000.00,'计划通过公司庆典活动，大肆圈一波钱',0),(2,1,'全国遨游推销','2021-07-12 15:21:31','2021-07-12 15:21:39','中国各地',2,1700000.00,30000000.00,28300000.00,'打响集团知名度，在遨游的过程中，把产品推销出去',0),(4,2,'618线上购物节','2021-07-12 15:29:42','2021-07-12 15:29:49','线上活动',2,1000.00,2000000.00,1999000.00,'预计收入要破百万',0),(5,1,'演唱会（推销新产品)','2021-07-12 16:48:08','2021-07-13 12:27:57','湖南长沙',2,510000.00,1000000.00,490000.00,'将新产品名气打出去',0),(6,6,'会面奥巴马','2021-07-13 12:36:25','2021-07-13 12:38:43','美国',2,100000.00,50.00,-99950.00,'与奥巴马一块喝酒',0),(7,1,'公益活动（植树造林）','2021-07-13 12:39:15','2021-07-13 12:39:35','中国',2,2700000.00,1100000.00,-1600000.00,'打造一整片绿洲',0),(8,1,'双11线上购物节','2021-07-13 12:39:40','2021-07-13 12:39:45','线上活动',2,1200.00,20000.00,18800.00,'2800000',0),(9,5,'广告宣传','2021-07-13 12:42:47','2021-07-13 12:42:57','湖南株洲',2,100000.00,10000.00,-90000.00,'一定要将产品的新名号打响',0),(10,1,'全体员工环球旅行','2021-07-13 12:44:37','2021-07-13 12:44:44','全球',2,50000000.00,2000000.00,-48000000.00,'给全体员工长长见识',0),(11,3,'测试删除',NULL,NULL,'测试删除',0,10000.00,NULL,NULL,'测试删除',1),(12,5,'测试001','2021-07-13 14:06:00',NULL,'测试001',1,10000.00,NULL,NULL,'测试001',0),(13,3,'整合测试001','2021-07-13 17:26:46','2021-07-13 17:26:58','整合测试001',2,1000.00,2000.00,1000.00,'整合测试001',0),(14,1,'整合测试0021','2021-07-13 14:06:00',NULL,'整合测试002',1,10000.00,NULL,NULL,'整合测试002',0),(15,5,'测试005','2021-07-13 17:34:52','2021-07-13 17:34:58','测试005',2,12000.00,100.00,-11900.00,'测试005',0),(16,5,'测试006',NULL,NULL,'测试006',0,12000.00,NULL,NULL,'测试006',1);
/*!40000 ALTER TABLE `activity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clue`
--

DROP TABLE IF EXISTS `clue`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `clue` (
  `Clue_Id` int NOT NULL AUTO_INCREMENT COMMENT '线索及客户编号',
  `Clue_Name` varchar(20) NOT NULL COMMENT '线索及客户名称',
  `Clue_Company` varchar(20) DEFAULT NULL COMMENT '线索及客户所属公司',
  `Clue_Contacts` varchar(20) DEFAULT NULL COMMENT '线索及客户联系人',
  `Clue_Phone` varchar(20) DEFAULT NULL COMMENT '线索及客户联系人电话',
  `Conversion_Type` int DEFAULT '0' COMMENT '线索转化状态',
  `TimeLiness` int DEFAULT '0' COMMENT '时效性',
  `Activity_Id` int DEFAULT NULL COMMENT '市场活动编号',
  `PublicPond_Id` int DEFAULT NULL COMMENT '公海编号',
  `emp_id` int DEFAULT NULL COMMENT '职员编号',
  PRIMARY KEY (`Clue_Id`),
  KEY `Activity_Id` (`Activity_Id`),
  KEY `PublicPond_Id` (`PublicPond_Id`),
  KEY `emp_id` (`emp_id`),
  CONSTRAINT `clue_ibfk_1` FOREIGN KEY (`Activity_Id`) REFERENCES `activity` (`Activity_Id`) ON UPDATE CASCADE,
  CONSTRAINT `clue_ibfk_2` FOREIGN KEY (`PublicPond_Id`) REFERENCES `PublicPond` (`PublicPond_Id`) ON UPDATE CASCADE,
  CONSTRAINT `clue_ibfk_3` FOREIGN KEY (`emp_id`) REFERENCES `employee` (`emp_id`) ON UPDATE CASCADE,
  CONSTRAINT `clue_chk_1` CHECK (((`Conversion_Type` = 0) or (`Conversion_Type` = 1))),
  CONSTRAINT `clue_chk_2` CHECK (((`TimeLiness` = 0) or (`TimeLiness` = 1)))
) ENGINE=InnoDB AUTO_INCREMENT=10018 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='单位表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clue`
--

LOCK TABLES `clue` WRITE;
/*!40000 ALTER TABLE `clue` DISABLE KEYS */;
INSERT INTO `clue` VALUES (10000,'禾润实业有限公司','禾润实业有限公司','程远圆','13806720005',1,0,2,2,5),(10001,'瀚海外交部','瀚海集团','Alla','13287849372',1,0,NULL,2,1),(10002,'阿里巴巴技术部','阿里巴巴','马云','15932894839',0,0,NULL,1,NULL),(10003,'小米科技（雷军）','小米科技','雷军','16786862937',0,0,NULL,1,1),(10004,'万达影业','万达集团','王思聪','16786926889',0,0,NULL,1,NULL),(10005,'微软维护部','微软','比尔盖茨','16787967234',1,0,NULL,2,1),(10006,'拼多多技术部','拼多多集团','阿拼','15864283947',0,1,NULL,1,NULL),(10007,'淘宝','阿里巴巴','马云','13465775787',0,0,NULL,1,1),(10008,'极光工作室','天极科技','陈极','15978683234',0,0,1,1,1),(10009,'奎克雨网络科技','奎克雷集团','谭勇','15767334592',0,0,1,1,1),(10011,'永利工作室','永利公司','汤普森','15234878297',1,0,1,2,1),(10012,'谷歌','美利坚合众国','KoBeBranty','15934678927',0,0,6,1,1),(10013,'测试002','测试002','测试002','2345',0,0,12,1,1),(10014,'整合测试002','整合测试002','整合测试002','2345678',1,0,13,2,1),(10015,'整合测试003','整合测试003','整合测试003','123456',1,0,13,2,1),(10016,'整合测试003','整合测试003','整合测试003','1234567',1,0,NULL,2,4),(10017,'整合测试004','整合测试004','整合测试004','12345678',0,0,NULL,1,3);
/*!40000 ALTER TABLE `clue` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `collection_period`
--

DROP TABLE IF EXISTS `collection_period`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `collection_period` (
  `collection_id` int NOT NULL AUTO_INCREMENT,
  `sale_order_id` int DEFAULT NULL COMMENT '销售单号外键id',
  `emp_id` int DEFAULT NULL COMMENT '负责人外键id',
  `beriod_name` varchar(25) COLLATE utf8_bin DEFAULT NULL,
  `blanned_moeny` decimal(19,2) DEFAULT NULL,
  `blanned_date` timestamp NULL DEFAULT NULL,
  `remarks` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`collection_id`),
  KEY `FK_Reference_11` (`emp_id`),
  CONSTRAINT `FK_Reference_11` FOREIGN KEY (`emp_id`) REFERENCES `employee` (`emp_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `collection_period`
--

LOCK TABLES `collection_period` WRITE;
/*!40000 ALTER TABLE `collection_period` DISABLE KEYS */;
INSERT INTO `collection_period` VALUES (1,1,1,'第1期',5000.00,'2021-07-11 11:14:43','无'),(2,1,1,'第2期',1000.00,'2021-07-12 03:55:28','无'),(4,1,1,'第3期次',123.00,'2021-07-13 16:00:00','123'),(5,1,1,'第4期次',5454.00,'2021-07-07 16:00:00','000'),(7,1,1,'第5期次',123.00,'2021-07-05 16:00:00','123'),(11,1,1,'第6期次',123.00,'2021-07-21 16:00:00','123123'),(12,1,1,'第7期次',123.00,'2021-07-21 16:00:00','123123'),(13,4,6,'第1期次',123.00,'2021-07-07 16:00:00','123123'),(14,1,1,'第8期次',123.00,'2021-07-14 16:00:00','123');
/*!40000 ALTER TABLE `collection_period` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `collection_record`
--

DROP TABLE IF EXISTS `collection_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `collection_record` (
  `collection_id` int DEFAULT NULL,
  `record_id` int NOT NULL AUTO_INCREMENT,
  `sale_order_id` int DEFAULT NULL COMMENT '订单外键id',
  `record_static_id` int DEFAULT NULL,
  `emp_id` int DEFAULT NULL,
  `payment_money` decimal(19,2) DEFAULT NULL,
  `payment_date` timestamp NULL DEFAULT NULL,
  `state` int DEFAULT '0',
  `remarks` varchar(600) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`record_id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `collection_record`
--

LOCK TABLES `collection_record` WRITE;
/*!40000 ALTER TABLE `collection_record` DISABLE KEYS */;
INSERT INTO `collection_record` VALUES (1,1,1,1,1,1000.00,'2021-07-11 11:24:41',0,'无'),(1,2,1,1,1,555.00,'2021-07-12 03:53:41',0,'无'),(2,4,1,1,1,222.00,'2021-07-12 03:56:18',0,'无'),(2,10,1,3,1,500.00,'2021-07-26 16:00:00',0,'123'),(4,11,1,2,1,123.00,'2021-07-07 16:00:00',0,'123213'),(2,13,1,1,1,278.00,'2021-06-30 16:00:00',0,'123123'),(1,15,1,2,1,3445.00,'2021-07-22 16:00:00',0,'123321'),(5,16,1,1,1,30.00,'2021-07-20 16:00:00',0,'66'),(5,25,1,1,1,12.00,'2021-07-07 16:00:00',0,'123'),(5,26,1,1,1,222.00,'2021-07-19 16:00:00',0,'123'),(5,27,1,1,1,212.00,'2021-07-12 16:00:00',0,'123'),(7,28,1,1,1,123.00,'2021-07-11 16:00:00',0,'123'),(13,30,4,1,6,123.00,'2021-07-06 16:00:00',0,'123'),(5,32,1,1,1,4978.00,'2021-07-14 16:00:00',0,'123');
/*!40000 ALTER TABLE `collection_record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `employee` (
  `emp_id` int NOT NULL AUTO_INCREMENT,
  `emp_name` varchar(60) COLLATE utf8_bin DEFAULT NULL,
  `emp_phone` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `emp_pwd` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  `emp_quantity` int DEFAULT NULL,
  `TimeLiness` int DEFAULT '0',
  PRIMARY KEY (`emp_id`),
  CONSTRAINT `employee_chk_1` CHECK (((`TimeLiness` = 0) or (`TimeLiness` = 1)))
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,'JFC','13203349965','123456',12,0),(2,'CJJ','15938822984','123456',11,0),(3,'admin','13786375778','123456',0,0),(4,'焦凡超','13203349965','123456',27,0),(5,'唐坪','15673289842','123456',22,0),(6,'石松炼','17757334642','123456',11,0),(7,'欧阳渗','13203325355','123456',26,0),(8,'陈建军','13257338659','123456',17,0),(9,'蒋蓉','15673563242','123456',23,0);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `follow`
--

DROP TABLE IF EXISTS `follow`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `follow` (
  `follow_id` int NOT NULL AUTO_INCREMENT,
  `emp_id` int DEFAULT NULL,
  `Clue_Id` int DEFAULT NULL,
  `follow_type` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `follow_content` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `follow_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `addtime` timestamp NULL DEFAULT NULL,
  `state` int DEFAULT '0',
  PRIMARY KEY (`follow_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `follow`
--

LOCK TABLES `follow` WRITE;
/*!40000 ALTER TABLE `follow` DISABLE KEYS */;
INSERT INTO `follow` VALUES (1,NULL,10001,'电话回访','跟进客户看有无购买产品的意图','2021-07-13 11:27:55','2021-07-11 16:00:00',1),(2,NULL,10002,'多次拜访','了解客户是否有购买意图','2021-07-13 11:28:31','2021-07-12 16:00:00',1),(3,NULL,10002,'电话回访','123','2021-07-13 11:39:20','2021-07-21 16:00:00',0),(4,1,10002,'二次回访','123333','2021-07-13 11:39:39','2021-07-21 16:00:00',0),(5,1,10002,'二次回访','12','2021-07-13 11:42:59',NULL,1),(6,1,10002,'电话回访','1302733','2021-07-13 11:54:22','2021-07-12 16:00:00',1),(7,NULL,10001,'电话回访','内容1','2021-07-13 19:21:11','2021-07-12 16:00:00',0);
/*!40000 ALTER TABLE `follow` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `follow_resource`
--

DROP TABLE IF EXISTS `follow_resource`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `follow_resource` (
  `follow_resource_id` int NOT NULL AUTO_INCREMENT,
  `follow_id` int DEFAULT NULL,
  `resource_type` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  `resource_id` int DEFAULT NULL,
  PRIMARY KEY (`follow_resource_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `follow_resource`
--

LOCK TABLES `follow_resource` WRITE;
/*!40000 ALTER TABLE `follow_resource` DISABLE KEYS */;
/*!40000 ALTER TABLE `follow_resource` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `handle`
--

DROP TABLE IF EXISTS `handle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `handle` (
  `hId` int NOT NULL AUTO_INCREMENT,
  `hand_id` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `hand_action` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `hand_way` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `billId` int DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `hand_stauts` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `hand_time` datetime DEFAULT NULL,
  `hand_emp` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `hand_date` datetime DEFAULT NULL,
  `sum_num` int DEFAULT NULL,
  PRIMARY KEY (`hId`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `handle`
--

LOCK TABLES `handle` WRITE;
/*!40000 ALTER TABLE `handle` DISABLE KEYS */;
INSERT INTO `handle` VALUES (3,'3ckd','出库','销售订单',1,'2021-07-13 20:44:48','已办理','2021-07-12 14:12:16',NULL,'2021-07-12 00:00:00',1),(4,'4krk','出库','其他',1,'2021-07-12 14:39:52','已办理','2021-07-13 16:16:16','李四','2021-07-14 08:00:00',1),(9,NULL,'入库','其他',NULL,'2021-07-13 12:02:37','已办理','2021-07-13 12:02:37',NULL,'2021-07-13 00:00:00',2),(10,NULL,'出库','其他',NULL,'2021-07-13 14:34:12','已办理','2021-07-13 14:34:12',NULL,'2021-07-13 00:00:00',4),(19,NULL,'出库','其他',NULL,'2021-07-13 21:44:34','已办理','2021-07-13 21:44:34',NULL,'2021-07-15 08:00:00',120),(22,NULL,'入库','其他',NULL,'2021-07-14 00:15:15','已办理','2021-07-14 00:15:15',NULL,'2021-07-14 00:00:00',1),(23,NULL,'出库','其他',NULL,'2021-07-14 00:15:45','未办理','2021-07-14 00:15:45',NULL,NULL,120),(24,NULL,'出库','其他',NULL,'2021-07-14 00:44:29','未办理','2021-07-14 00:44:29',NULL,NULL,11),(25,NULL,'入库','其他',NULL,'2021-07-14 00:44:48','已办理','2021-07-14 00:44:48',NULL,'2021-07-14 00:00:00',11);
/*!40000 ALTER TABLE `handle` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `handle_product`
--

DROP TABLE IF EXISTS `handle_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `handle_product` (
  `handle_product_id` int NOT NULL AUTO_INCREMENT,
  `pro_id` int DEFAULT NULL,
  `hId` int DEFAULT NULL,
  `hand_num` int DEFAULT NULL,
  PRIMARY KEY (`handle_product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `handle_product`
--

LOCK TABLES `handle_product` WRITE;
/*!40000 ALTER TABLE `handle_product` DISABLE KEYS */;
INSERT INTO `handle_product` VALUES (6,1,3,1),(7,1,4,1),(8,1,9,2),(9,1,10,4),(18,1,19,120),(21,86,22,1),(22,83,23,120),(23,86,24,11),(24,86,25,11);
/*!40000 ALTER TABLE `handle_product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lead_product`
--

DROP TABLE IF EXISTS `lead_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `lead_product` (
  `lead_product_id` int NOT NULL AUTO_INCREMENT,
  `pro_id` int DEFAULT NULL,
  `lead_id` int DEFAULT NULL,
  `unit_price` decimal(18,2) DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  `subtotal` decimal(18,2) DEFAULT NULL,
  PRIMARY KEY (`lead_product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lead_product`
--

LOCK TABLES `lead_product` WRITE;
/*!40000 ALTER TABLE `lead_product` DISABLE KEYS */;
INSERT INTO `lead_product` VALUES (1,NULL,3,NULL,NULL,NULL),(2,27,3,2999.00,1,2999.00),(3,1,3,4999.00,1,4999.00);
/*!40000 ALTER TABLE `lead_product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `product` (
  `pro_id` int NOT NULL AUTO_INCREMENT,
  `emp_id` int DEFAULT NULL,
  `pro_name` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `pro_price` decimal(18,2) DEFAULT NULL,
  `pro_num` int DEFAULT NULL,
  `pro_status` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `createTime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `pro_type` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `pro_des` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `emp` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `pro_unit` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`pro_id`)
) ENGINE=InnoDB AUTO_INCREMENT=90 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,1,'打印机',4999.00,10,'正常','2021-07-13 16:19:28','cupAi','打印机','李四','台'),(2,2,'笔记本电脑',3999.00,15,'正常','2021-07-13 13:46:30','联想','笔记本电脑','12','台'),(80,NULL,'饮水机',231.00,111,'正常','2021-07-13 12:44:56','A02','饮水机','af','dfs'),(83,NULL,'线上媒体运营',3456.00,12,'正常','2021-07-13 12:45:35',NULL,NULL,'李华','次'),(86,NULL,'定制项目',2000.00,13,'正常','2021-07-13 16:44:48','12','122','李华','次');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `quotation`
--

DROP TABLE IF EXISTS `quotation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `quotation` (
  `quotation_id` int NOT NULL AUTO_INCREMENT,
  `lead_id` int DEFAULT NULL,
  `emp_id` int DEFAULT NULL,
  `Customer_Id` int DEFAULT NULL,
  `quotation_name` char(60) COLLATE utf8_bin DEFAULT NULL,
  `quotation_stage` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  `quotation_amount` decimal(18,2) DEFAULT NULL,
  `effective_date` datetime DEFAULT NULL,
  `quotation_date` datetime DEFAULT NULL,
  `quotation_remark` varchar(600) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`quotation_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quotation`
--

LOCK TABLES `quotation` WRITE;
/*!40000 ALTER TABLE `quotation` DISABLE KEYS */;
/*!40000 ALTER TABLE `quotation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `quotation_product`
--

DROP TABLE IF EXISTS `quotation_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `quotation_product` (
  `quotation_product_id` int NOT NULL AUTO_INCREMENT,
  `quotation_id` int DEFAULT NULL,
  `pro_id` int DEFAULT NULL,
  `unit_price` decimal(18,2) DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  `subtotal` decimal(18,2) DEFAULT NULL,
  PRIMARY KEY (`quotation_product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quotation_product`
--

LOCK TABLES `quotation_product` WRITE;
/*!40000 ALTER TABLE `quotation_product` DISABLE KEYS */;
/*!40000 ALTER TABLE `quotation_product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `receipt`
--

DROP TABLE IF EXISTS `receipt`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `receipt` (
  `receipt_id` int NOT NULL AUTO_INCREMENT,
  `sale_order_id` int DEFAULT NULL COMMENT '订单关联id',
  `collection_id` int DEFAULT NULL,
  `emp_id` int DEFAULT NULL,
  `receipt_name` varchar(60) COLLATE utf8_bin DEFAULT NULL,
  `receipt_money` decimal(19,2) DEFAULT NULL,
  `Bill_title` varchar(25) COLLATE utf8_bin DEFAULT NULL,
  `pay_taxes` varchar(25) COLLATE utf8_bin DEFAULT NULL,
  `remarks` varchar(600) COLLATE utf8_bin DEFAULT NULL,
  `apply` int DEFAULT '0' COMMENT '审批状态默认为0，1是通过，2是驳回',
  `create_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`receipt_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `receipt`
--

LOCK TABLES `receipt` WRITE;
/*!40000 ALTER TABLE `receipt` DISABLE KEYS */;
INSERT INTO `receipt` VALUES (1,1,1,1,'测试开票1',5000.00,'测试联系人','5654616','无',1,'2021-07-13 02:23:12'),(2,1,4,1,'123',123.00,'1231','2213','123',1,'2021-07-13 03:23:12'),(3,1,2,1,'开票开票',1000.00,'123','123','123',1,'2021-07-13 04:23:12'),(7,1,7,1,'123123',123.00,'123','123','123',1,'2021-07-13 18:15:47'),(8,4,13,6,'123',123.00,'123','123','123',1,'2021-07-13 18:20:36'),(9,1,5,1,'123',5454.00,'123','123','123',1,'2021-07-13 18:25:47');
/*!40000 ALTER TABLE `receipt` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `record`
--

DROP TABLE IF EXISTS `record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `record` (
  `record_id` int NOT NULL AUTO_INCREMENT,
  `follow_id` int DEFAULT NULL,
  `record_type` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `record_content` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `record_name` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `record_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`record_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `record`
--

LOCK TABLES `record` WRITE;
/*!40000 ALTER TABLE `record` DISABLE KEYS */;
INSERT INTO `record` VALUES (1,1,'二次跟进','客户对产品很满意','白给','2021-07-13 02:15:49');
/*!40000 ALTER TABLE `record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `record_static`
--

DROP TABLE IF EXISTS `record_static`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `record_static` (
  `record_static_id` int NOT NULL AUTO_INCREMENT,
  `record_static_name` varchar(25) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`record_static_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `record_static`
--

LOCK TABLES `record_static` WRITE;
/*!40000 ALTER TABLE `record_static` DISABLE KEYS */;
INSERT INTO `record_static` VALUES (1,'现金'),(2,'微信'),(3,'支付宝');
/*!40000 ALTER TABLE `record_static` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `return_product`
--

DROP TABLE IF EXISTS `return_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `return_product` (
  `return_product_id` int NOT NULL AUTO_INCREMENT,
  `pro_id` int DEFAULT NULL,
  `sale_return_id` int DEFAULT NULL,
  PRIMARY KEY (`return_product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `return_product`
--

LOCK TABLES `return_product` WRITE;
/*!40000 ALTER TABLE `return_product` DISABLE KEYS */;
/*!40000 ALTER TABLE `return_product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sale_contract`
--

DROP TABLE IF EXISTS `sale_contract`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `sale_contract` (
  `sale_contract_id` int NOT NULL AUTO_INCREMENT,
  `sale_order_id` int DEFAULT NULL,
  `lead_id` int DEFAULT NULL,
  `emp_id` int DEFAULT NULL,
  `Customer_Id` int DEFAULT NULL,
  `contract_name` varchar(60) COLLATE utf8_bin DEFAULT NULL,
  `contract_date` datetime DEFAULT NULL,
  `contract_sate` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  `start_date` datetime DEFAULT NULL,
  `end_date` datetime DEFAULT NULL,
  PRIMARY KEY (`sale_contract_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sale_contract`
--

LOCK TABLES `sale_contract` WRITE;
/*!40000 ALTER TABLE `sale_contract` DISABLE KEYS */;
INSERT INTO `sale_contract` VALUES (1,NULL,NULL,6,10000,'销售合同1','2021-07-13 16:50:04','执行中','2021-07-13 16:50:14','2021-07-14 00:00:00'),(2,NULL,NULL,6,10000,'销售合同2','2021-07-14 00:00:00','执行中','2021-07-14 16:51:19','2021-07-15 00:00:00'),(3,NULL,NULL,6,10000,'销售合同3','2021-07-13 16:52:00','未开始','2021-07-15 00:00:00','2021-07-17 00:00:00'),(4,NULL,3,6,10000,'销售合同4','2021-07-14 03:39:30','执行中','2021-07-13 00:00:00','2021-07-14 03:40:03');
/*!40000 ALTER TABLE `sale_contract` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sale_lead`
--

DROP TABLE IF EXISTS `sale_lead`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `sale_lead` (
  `lead_id` int NOT NULL AUTO_INCREMENT,
  `emp_id` int DEFAULT NULL,
  `Customer_Id` int DEFAULT NULL,
  `Activity_Id` int DEFAULT NULL,
  `lead_name` varchar(60) COLLATE utf8_bin DEFAULT NULL,
  `lead_amount` decimal(18,2) DEFAULT NULL,
  `transaction_date` datetime DEFAULT NULL,
  `lead_stage` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  `lead_type` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  `lead_source` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  `lead_remark` varchar(600) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`lead_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sale_lead`
--

LOCK TABLES `sale_lead` WRITE;
/*!40000 ALTER TABLE `sale_lead` DISABLE KEYS */;
INSERT INTO `sale_lead` VALUES (1,1,10000,1,'测试机会',5000.00,'2021-07-11 19:17:17','初期(10%)','普通机会','独立开发','无'),(3,3,10000,NULL,'销售机会1',7998.00,'2021-07-12 21:54:21','初期(10%)','重大机会','独立开发',NULL);
/*!40000 ALTER TABLE `sale_lead` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sale_order`
--

DROP TABLE IF EXISTS `sale_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `sale_order` (
  `sale_order_id` int NOT NULL AUTO_INCREMENT,
  `lead_id` int DEFAULT NULL,
  `emp_id` int DEFAULT NULL,
  `Customer_Id` int DEFAULT NULL,
  `Activity_Id` int DEFAULT NULL,
  `sale_order_name` varchar(60) COLLATE utf8_bin DEFAULT NULL,
  `sale_order_amount` decimal(18,2) DEFAULT NULL,
  `create_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `transaction_date` datetime DEFAULT NULL,
  `start_date` datetime DEFAULT NULL,
  `end_date` datetime DEFAULT NULL,
  `payment_mothod` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  `sale_order_state` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  `sale_order_remark` varchar(600) COLLATE utf8_bin DEFAULT NULL,
  `sale_contract_id` int DEFAULT NULL,
  PRIMARY KEY (`sale_order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sale_order`
--

LOCK TABLES `sale_order` WRITE;
/*!40000 ALTER TABLE `sale_order` DISABLE KEYS */;
INSERT INTO `sale_order` VALUES (1,1,1,10000,1,'测试销售订单1',20000.00,'2021-07-11 12:40:01','2021-07-11 19:15:43','2021-07-11 19:15:45','2021-07-11 19:15:48','现金','已生效','无',1),(3,3,6,10000,NULL,'销售订单2',8998.00,'2021-07-13 03:42:44','2021-07-13 11:42:41',NULL,NULL,NULL,NULL,NULL,2),(4,3,6,10000,NULL,'销售订单2',8998.00,'2021-07-13 03:42:53','2021-07-13 11:42:41',NULL,NULL,NULL,NULL,NULL,2),(5,3,6,10000,NULL,'销售订单3',4999.00,'2021-07-13 03:45:16','2021-07-13 11:45:07',NULL,NULL,NULL,NULL,NULL,NULL),(6,3,6,10000,NULL,'销售订单3',4999.00,'2021-07-13 03:47:04',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(7,3,6,10000,NULL,'销售订单4',8998.00,'2021-07-13 07:46:07','2021-07-13 15:45:57',NULL,NULL,NULL,NULL,NULL,NULL),(8,NULL,6,10000,NULL,'销售订单4',250.00,'2021-07-13 11:21:36',NULL,NULL,NULL,NULL,NULL,NULL,3);
/*!40000 ALTER TABLE `sale_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sale_product`
--

DROP TABLE IF EXISTS `sale_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `sale_product` (
  `sale_product_id` int NOT NULL AUTO_INCREMENT,
  `sale_order_id` int DEFAULT NULL,
  `pro_id` int DEFAULT NULL,
  `unit_price` decimal(18,2) DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  `subtotal` decimal(18,2) DEFAULT NULL,
  PRIMARY KEY (`sale_product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sale_product`
--

LOCK TABLES `sale_product` WRITE;
/*!40000 ALTER TABLE `sale_product` DISABLE KEYS */;
INSERT INTO `sale_product` VALUES (1,3,NULL,NULL,NULL,NULL),(2,3,2,3999.00,1,3999.00),(3,3,1,4999.00,1,4999.00),(4,4,NULL,NULL,NULL,NULL),(5,4,2,3999.00,1,3999.00),(6,4,1,4999.00,1,4999.00),(7,5,NULL,NULL,NULL,NULL),(8,5,1,4999.00,1,4999.00),(9,6,1,4999.00,1,4999.00),(10,7,2,3999.00,1,3999.00),(11,7,1,4999.00,1,4999.00);
/*!40000 ALTER TABLE `sale_product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sale_return`
--

DROP TABLE IF EXISTS `sale_return`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `sale_return` (
  `sale_return_id` int NOT NULL AUTO_INCREMENT,
  `sale_order_id` int DEFAULT NULL,
  `emp_id` int DEFAULT NULL,
  `Customer_Id` int DEFAULT NULL,
  `sale_return_name` varchar(60) COLLATE utf8_bin DEFAULT NULL,
  `return_date` datetime DEFAULT NULL,
  `return_amount` decimal(18,2) DEFAULT NULL,
  `return_method` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  `return_cause` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  `return_remark` varchar(600) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`sale_return_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sale_return`
--

LOCK TABLES `sale_return` WRITE;
/*!40000 ALTER TABLE `sale_return` DISABLE KEYS */;
INSERT INTO `sale_return` VALUES (1,1,1,1,'测试退货单1','2021-07-01 19:54:40',0.00,'现金','无','无');
/*!40000 ALTER TABLE `sale_return` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `task`
--

DROP TABLE IF EXISTS `task`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `task` (
  `task_id` int NOT NULL AUTO_INCREMENT,
  `emp_id` int DEFAULT NULL,
  `Clue_Id` int DEFAULT NULL,
  `closingtime` timestamp NULL DEFAULT NULL,
  `task` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `task_person` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `task_name` varchar(40) COLLATE utf8_bin DEFAULT NULL,
  `task_state` int DEFAULT '0',
  `endtime` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`task_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `task`
--

LOCK TABLES `task` WRITE;
/*!40000 ALTER TABLE `task` DISABLE KEYS */;
INSERT INTO `task` VALUES (1,8,10002,'2021-07-13 19:25:23','123','123','12345',0,NULL),(2,NULL,10002,'2021-07-13 16:00:00','1','123','12356',0,'2021-07-13 18:06:21'),(3,NULL,10002,'2021-07-13 18:15:01','1','123','2',0,NULL),(4,2,10002,'2021-07-11 16:00:00','1','123','1',1,'2021-07-13 18:57:02'),(5,NULL,10002,'2021-07-20 16:00:00','1','','1',0,NULL),(6,6,10002,'2021-07-13 19:17:14','11','admin','任务1',0,NULL),(7,NULL,10000,'2021-07-13 16:00:00','内容1','','任务2',0,NULL);
/*!40000 ALTER TABLE `task` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `task_emp`
--

DROP TABLE IF EXISTS `task_emp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `task_emp` (
  `id` int NOT NULL AUTO_INCREMENT,
  `emp_id` int DEFAULT NULL,
  `task_id` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `task_emp`
--

LOCK TABLES `task_emp` WRITE;
/*!40000 ALTER TABLE `task_emp` DISABLE KEYS */;
/*!40000 ALTER TABLE `task_emp` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-07-14  4:52:12
