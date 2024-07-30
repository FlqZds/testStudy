/*
SQLyog Community v12.09 (64 bit)
MySQL - 8.0.36 : Database - rbac
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
/*Table structure for table `role_action_right` */

DROP TABLE IF EXISTS `role_action_right`;

CREATE TABLE `role_action_right` (
  `id` int NOT NULL AUTO_INCREMENT,
  `roleid` int DEFAULT NULL,
  `rightid` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb3;

/*Data for the table `role_action_right` */

insert  into `role_action_right`(`id`,`roleid`,`rightid`) values (20,2,30),(21,1,30),(22,1,31);

/*Table structure for table `role_right` */

DROP TABLE IF EXISTS `role_right`;

CREATE TABLE `role_right` (
  `rrid` int NOT NULL AUTO_INCREMENT,
  `roleid` int NOT NULL,
  `rightid` int NOT NULL,
  PRIMARY KEY (`rrid`),
  KEY `roleid` (`roleid`) USING BTREE,
  KEY `rightid` (`rightid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=340 DEFAULT CHARSET=utf8mb3;

/*Data for the table `role_right` */

insert  into `role_right`(`rrid`,`roleid`,`rightid`) values (300,1,19),(301,1,20),(302,1,21),(303,1,22),(304,1,23),(305,1,24),(306,1,25),(307,1,26),(308,1,27),(309,1,28),(310,1,29),(334,2,23),(335,2,24),(336,2,25),(337,2,29),(338,2,26),(339,1,30);

/*Table structure for table `tb_actionright` */

DROP TABLE IF EXISTS `tb_actionright`;

CREATE TABLE `tb_actionright` (
  `rightid` int NOT NULL AUTO_INCREMENT,
  `right_code` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '权限码',
  `righttext` varchar(200) DEFAULT NULL,
  `righttype` tinyint DEFAULT NULL COMMENT '0: 父节点 1:子节点',
  `righturl` varchar(200) DEFAULT NULL,
  `parentid` int DEFAULT NULL COMMENT '父Id',
  PRIMARY KEY (`rightid`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb3;

/*Data for the table `tb_actionright` */

insert  into `tb_actionright`(`rightid`,`right_code`,`righttext`,`righttype`,`righturl`,`parentid`) values (29,'','动作权限',0,NULL,0),(30,'TEST_SEARCH','查询',1,'/check/search',29),(31,'TEST_AUDIT','审批',1,'/check/admin/aduit',29);

/*Table structure for table `tb_good` */

DROP TABLE IF EXISTS `tb_good`;

CREATE TABLE `tb_good` (
  `good_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(25) NOT NULL,
  `price` decimal(10,0) NOT NULL,
  `des` varchar(100) DEFAULT NULL,
  `type_id` int NOT NULL,
  PRIMARY KEY (`good_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `tb_good` */

insert  into `tb_good`(`good_id`,`name`,`price`,`des`,`type_id`) values (1,'雨伞','20','一把伞',0),(2,'水杯','17','一个简单的水杯',1);

/*Table structure for table `tb_right` */

DROP TABLE IF EXISTS `tb_right`;

CREATE TABLE `tb_right` (
  `rightid` int NOT NULL AUTO_INCREMENT,
  `righttext` varchar(200) DEFAULT NULL,
  `righttype` int DEFAULT NULL COMMENT '0: 父节点 1:子节点',
  `righturl` varchar(200) DEFAULT NULL,
  `parentid` int DEFAULT NULL,
  `is_menu` bit(1) DEFAULT NULL COMMENT '1:菜单权限 0:button权限',
  PRIMARY KEY (`rightid`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb3;

/*Data for the table `tb_right` */

insert  into `tb_right`(`rightid`,`righttext`,`righttype`,`righturl`,`parentid`,`is_menu`) values (19,'资源管理',0,'',0,''),(20,'资源列表',1,'/source/list',19,''),(21,'资源添加',1,'/source/add',19,''),(22,'资源审核',1,'/source/judge',19,''),(23,'用户管理',0,'',0,''),(24,'信息编辑',1,'/users/edit',23,''),(25,'用户列表',1,'/users/manage',23,''),(26,'用户日志',1,'/user/logger',23,''),(27,'其他设置',0,'',0,''),(28,'主题美化',1,'/setting/theme',27,''),(29,'AI集成',1,'/setting/plugins',27,''),(30,'小工具',1,'/setting/tinykits',27,'');

/*Table structure for table `tb_role` */

DROP TABLE IF EXISTS `tb_role`;

CREATE TABLE `tb_role` (
  `roleid` int NOT NULL AUTO_INCREMENT,
  `rolename` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`roleid`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb3;

/*Data for the table `tb_role` */

insert  into `tb_role`(`roleid`,`rolename`) values (1,'admin'),(2,'user'),(11,'people'),(12,'zoukx'),(13,'zkx');

/*Table structure for table `tb_user` */

DROP TABLE IF EXISTS `tb_user`;

CREATE TABLE `tb_user` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `account` bigint NOT NULL COMMENT '账户',
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '用户名',
  `userPassword` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '',
  `role_id` int NOT NULL,
  `nikname` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '昵称',
  `role_name` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '角色名',
  `avatar_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT '' COMMENT '头像',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `tb_user` */

insert  into `tb_user`(`user_id`,`account`,`username`,`userPassword`,`role_id`,`nikname`,`role_name`,`avatar_url`) values (1,111,'张春晖','111',1,'一只小甜甜','admin',''),(2,135790,'丁元英','135790',2,'遥远的道友','user',''),(3,21312312312,'罗生严','12454123f',2,'医者','user',''),(4,489416,'埃隆·松赞·浩山塔门','888999',1,'长生天','admin','');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
