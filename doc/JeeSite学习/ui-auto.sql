/*
SQLyog Ultimate v8.32 
MySQL - 5.5.34-MariaDB-log : Database - jeesite
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

/*Table structure for table `auto_product` */

DROP TABLE IF EXISTS `auto_product`;

CREATE TABLE `auto_product` (
  `pid` int(11) NOT NULL AUTO_INCREMENT COMMENT '流水号',
  `pname` varchar(200) DEFAULT NULL COMMENT '产品名称',
  `pcode` varchar(20) DEFAULT NULL COMMENT '产品代码',
  `desc` longtext COMMENT '产品描述',
  `remarks` varchar(1000) DEFAULT NULL COMMENT '备注',
  `create_by` varchar(100) DEFAULT NULL COMMENT '创建者',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(100) DEFAULT NULL COMMENT '更新者',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `del_flag` char(1) DEFAULT NULL COMMENT '删除标记',
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `auto_product` */

LOCK TABLES `auto_product` WRITE;

insert  into `auto_product`(`pid`,`pname`,`pcode`,`desc`,`remarks`,`create_by`,`create_date`,`update_by`,`update_date`,`del_flag`) values (1,'android APP','android_app','android 产品线',NULL,NULL,NULL,NULL,NULL,'0'),(2,'ios APP','ios_app','ios 产品线',NULL,NULL,NULL,NULL,NULL,'0'),(3,'erp','erp','留学业务相关，公司业务人员使用',NULL,NULL,NULL,NULL,NULL,'0'),(4,'h5','h5','html5，pc端用户',NULL,NULL,NULL,NULL,NULL,'0');

UNLOCK TABLES;

/*Table structure for table `auto_version` */

DROP TABLE IF EXISTS `auto_version`;

CREATE TABLE `auto_version` (
  `vid` int(11) NOT NULL AUTO_INCREMENT COMMENT '流水号',
  `vname` varchar(200) DEFAULT NULL COMMENT '版本名称',
  `vcode` varchar(20) DEFAULT NULL COMMENT '版本代码',
  `desc` varchar(1000) DEFAULT NULL COMMENT '描述',
  `begin_date` datetime DEFAULT NULL COMMENT '开始时间',
  `end_date` datetime DEFAULT NULL COMMENT '结束时间',
  `pid` int(11) DEFAULT NULL COMMENT '关联产品id',
  `create_by` varchar(100) DEFAULT NULL COMMENT '创建者',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(100) DEFAULT NULL COMMENT '更新者',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注',
  `del_flag` char(1) DEFAULT NULL COMMENT '删除标记',
  PRIMARY KEY (`vid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `auto_version` */

LOCK TABLES `auto_version` WRITE;

UNLOCK TABLES;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
