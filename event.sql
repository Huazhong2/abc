/*
SQLyog Ultimate v11.33 (64 bit)
MySQL - 5.7.20-log : Database - library
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`library` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `library`;

/*Table structure for table `lol_match` */

DROP TABLE IF EXISTS `lol_match`;

CREATE TABLE `lol_match` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(15) DEFAULT NULL,
  `team1_name` varchar(15) DEFAULT NULL,
  `team2_name` varchar(15) DEFAULT NULL,
  `time` varchar(20) DEFAULT NULL,
  `ticket_price` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `lol_match` */

insert  into `lol_match`(`id`,`name`,`team1_name`,`team2_name`,`time`,`ticket_price`) values (1,'wqd','qwd','qwd','wqd',2222);

/*Table structure for table `match_order` */

DROP TABLE IF EXISTS `match_order`;

CREATE TABLE `match_order` (
  `order_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `order_type` varchar(15) DEFAULT NULL,
  `order_name` varchar(15) DEFAULT NULL,
  `user_account` varchar(10) DEFAULT NULL,
  `order_type_id` int(11) DEFAULT NULL,
  `order_time` varchar(20) DEFAULT NULL,
  `ticket_price` int(11) DEFAULT '0',
  `status` varchar(15) DEFAULT NULL,
  `review` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `match_order` */

insert  into `match_order`(`order_id`,`order_type`,`order_name`,`user_account`,`order_type_id`,`order_time`,`ticket_price`,`status`,`review`) values (7,'充值服务','充值订单','1415238952',0,'2020-04-11 12:22:13',1233,'待受理',NULL);

/*Table structure for table `t_review` */

DROP TABLE IF EXISTS `t_review`;

CREATE TABLE `t_review` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `review` varchar(100) DEFAULT NULL,
  `user_account` varchar(10) DEFAULT NULL,
  `order_type_id` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_review` */

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `name` varchar(20) NOT NULL,
  `sex` char(3) NOT NULL,
  `account` varchar(10) NOT NULL,
  `password` text NOT NULL,
  `is_admin` tinyint(1) NOT NULL DEFAULT '0',
  `is_vip` tinyint(1) NOT NULL DEFAULT '0',
  `balance` double NOT NULL DEFAULT '0',
  PRIMARY KEY (`account`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`name`,`sex`,`account`,`password`,`is_admin`,`is_vip`,`balance`) values ('qwd','男','1111111111','37f25c746ff1086a14ae394e5bda45ba',0,0,0),('qwdddddd','女','1231111111','*74BEA379C35D76DA3830537D1D15DFFC5681DEBE',0,0,0),('abcdddd','男','1234567890','*6B5EDDE567F4F29018862811195DBD14B8ADDD2A',0,0,0),('123213','女','1234567891','*7297C3E22DEB91303FC493303A8158AD4231F486',0,0,0),('王志萌','男','1415238952','*6BB4837EB74329105EE4568DDA7DC67ED2CA2AD9',1,0,1738),('wqdvvvvv','男','2222222222','*74BEA379C35D76DA3830537D1D15DFFC5681DEBE',0,0,0);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
