/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 100134
Source Host           : localhost:3306
Source Database       : tssystem

Target Server Type    : MYSQL
Target Server Version : 100134
File Encoding         : 65001

Date: 2019-12-30 17:51:53
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admindao
-- ----------------------------
DROP TABLE IF EXISTS `admindao`;
CREATE TABLE `admindao` (
  `Aid` int(10) NOT NULL,
  `Aname` varchar(30) NOT NULL,
  `Apwd` varchar(10) NOT NULL,
  PRIMARY KEY (`Aid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admindao
-- ----------------------------
INSERT INTO `admindao` VALUES ('1', '管理员', '1');
INSERT INTO `admindao` VALUES ('2', '2', '2');
INSERT INTO `admindao` VALUES ('12', '1', '1');
INSERT INTO `admindao` VALUES ('123', '管理员2', '123');

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `Cnum` int(6) NOT NULL AUTO_INCREMENT,
  `Cno` int(6) NOT NULL,
  `Cname` varchar(20) NOT NULL,
  `Ctime` int(2) NOT NULL,
  `Ccredit` int(2) NOT NULL,
  PRIMARY KEY (`Cnum`,`Cno`),
  KEY `Cname` (`Cname`),
  KEY `Cno` (`Cno`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('1', '95001', '数据库原理', '64', '4');
INSERT INTO `course` VALUES ('2', '95002', '操作系统', '64', '3');
INSERT INTO `course` VALUES ('3', '95003', '计算机网络', '64', '4');
INSERT INTO `course` VALUES ('4', '95004', 'JAVA', '64', '4');
INSERT INTO `course` VALUES ('6', '95005', '脚本编程', '48', '3');
INSERT INTO `course` VALUES ('8', '95007', '软件测试', '64', '3');
INSERT INTO `course` VALUES ('11', '95008', '软件工程', '48', '3');
INSERT INTO `course` VALUES ('12', '95009', '软件构造', '48', '3');

-- ----------------------------
-- Table structure for score
-- ----------------------------
DROP TABLE IF EXISTS `score`;
CREATE TABLE `score` (
  `Sno` int(10) NOT NULL,
  `Sname` varchar(20) NOT NULL,
  `Cno` int(10) NOT NULL,
  `Cname` varchar(20) DEFAULT NULL,
  `Sscore` decimal(10,0) DEFAULT '0',
  `Rescore` decimal(10,0) DEFAULT '0',
  PRIMARY KEY (`Sno`,`Cno`),
  KEY `Cname` (`Cname`),
  KEY `Cno` (`Cno`),
  KEY `Sname` (`Sname`),
  CONSTRAINT `Cname` FOREIGN KEY (`Cname`) REFERENCES `course` (`Cname`),
  CONSTRAINT `Cno` FOREIGN KEY (`Cno`) REFERENCES `course` (`Cno`),
  CONSTRAINT `Sname` FOREIGN KEY (`Sname`) REFERENCES `student` (`Sname`),
  CONSTRAINT `Sno` FOREIGN KEY (`Sno`) REFERENCES `student` (`Sno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of score
-- ----------------------------
INSERT INTO `score` VALUES ('201720824', '殷名远', '95001', '数据库原理', '100', '0');
INSERT INTO `score` VALUES ('201720824', '殷名远', '95002', '操作系统', '100', '0');
INSERT INTO `score` VALUES ('201720824', '殷名远', '95003', '计算机网络', '100', '0');
INSERT INTO `score` VALUES ('201720824', '殷名远', '95004', 'JAVA', '100', '0');
INSERT INTO `score` VALUES ('201720825', '郭书衡', '95004', 'JAVA', '100', '0');
INSERT INTO `score` VALUES ('201720826', '郭世豪', '95004', 'JAVA', '100', '0');
INSERT INTO `score` VALUES ('201720827', '高磊', '95004', 'JAVA', '100', '0');
INSERT INTO `score` VALUES ('201720828', '游晶', '95001', '数据库原理', '100', '0');
INSERT INTO `score` VALUES ('201720831', '张三', '95001', '数据库原理', '90', '0');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `Sno` int(10) NOT NULL,
  `Sname` varchar(30) NOT NULL,
  `Sgender` char(2) NOT NULL,
  `Sage` int(2) NOT NULL,
  `Sbirthday` datetime DEFAULT '1999-01-01 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  `Sclass` varchar(10) NOT NULL,
  `Smajor` varchar(20) NOT NULL,
  `Sdept` varchar(20) NOT NULL,
  `Spwd` varchar(10) NOT NULL DEFAULT '123',
  PRIMARY KEY (`Sno`),
  KEY `Sname` (`Sname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('201720801', '于兆万', '男', '20', '2019-12-30 10:27:48', '2017208', '软件工程', '信息工程学院', '123');
INSERT INTO `student` VALUES ('201720802', '马文哲', '男', '20', '2019-12-30 10:28:45', '2017208', '软件工程', '信息工程学院', '123');
INSERT INTO `student` VALUES ('201720803', '王潇熠', '女', '20', '2019-12-30 10:29:33', '2017208', '软件工程', '信息工程学院', '123');
INSERT INTO `student` VALUES ('201720804', '王志远', '男', '20', '2019-12-30 10:30:17', '2017208', '软件工程', '信息工程学院', '123');
INSERT INTO `student` VALUES ('201720805', '兰洁', '男', '20', '2019-12-30 10:30:55', '2017208', '软件工程', '信息工程学院', '123');
INSERT INTO `student` VALUES ('201720806', '司范', '男', '20', '1999-01-01 00:00:00', '2017208', '软件工程', '信息工程学院', '123');
INSERT INTO `student` VALUES ('201720807', '孙萌', '男', '20', '1999-01-01 00:00:00', '2017208', '软件工程', '信息工程学院', '123');
INSERT INTO `student` VALUES ('201720808', '池俊鹏', '男', '20', '1999-01-01 00:00:00', '2017208', '软件工程', '信息工程学院', '123');
INSERT INTO `student` VALUES ('201720809', '许皓然', '男', '20', '1999-01-01 00:00:00', '2017208', '软件工程', '信息工程学院', '123');
INSERT INTO `student` VALUES ('201720810', '张云磊', '男', '20', '1999-01-01 00:00:00', '2017208', '软件工程', '信息工程学院', '123');
INSERT INTO `student` VALUES ('201720811', '张国谦', '男', '20', '1999-01-01 00:00:00', '2017208', '软件工程', '信息工程学院', '123');
INSERT INTO `student` VALUES ('201720812', '李乐飞', '男', '20', '1999-01-01 00:00:00', '2017208', '软件工程', '信息工程学院', '123');
INSERT INTO `student` VALUES ('201720813', '李相霏', '男', '20', '1999-01-01 00:00:00', '2017208', '软件工程', '信息工程学院', '123');
INSERT INTO `student` VALUES ('201720814', '陈华', '女', '20', '1999-01-01 00:00:00', '2017208', '软件工程', '信息工程学院', '123');
INSERT INTO `student` VALUES ('201720815', '陈天琪', '男', '20', '1999-01-01 00:00:00', '2017208', '软件工程', '信息工程学院', '123');
INSERT INTO `student` VALUES ('201720816', '陈秋阳', '女', '20', '1999-01-01 00:00:00', '2017208', '软件工程', '信息工程学院', '123');
INSERT INTO `student` VALUES ('201720817', '陈铁滨', '男', '20', '1999-01-01 00:00:00', '2017208', '软件工程', '信息工程学院', '123');
INSERT INTO `student` VALUES ('201720819', '者怡垚', '女', '20', '1999-01-01 00:00:00', '2017208', '软件工程', '信息工程学院', '123');
INSERT INTO `student` VALUES ('201720820', '范康', '男', '20', '1999-01-01 00:00:00', '2017208', '软件工程', '信息工程学院', '123');
INSERT INTO `student` VALUES ('201720821', '姜业成', '男', '20', '1999-01-01 00:00:00', '2017208', '软件工程', '信息工程学院', '123');
INSERT INTO `student` VALUES ('201720822', '赵霞', '女', '20', '1999-01-01 00:00:00', '2017208', '软件工程', '信息工程学院', '123');
INSERT INTO `student` VALUES ('201720823', '徐志磊', '男', '20', '1999-01-01 00:00:00', '2017208', '软件工程', '信息工程学院', '123');
INSERT INTO `student` VALUES ('201720824', '殷名远', '男', '20', '1999-02-14 00:00:00', '2017208', '软件工程', '信息工程学院', '123');
INSERT INTO `student` VALUES ('201720825', '郭书衡', '男', '20', '1998-12-17 00:00:00', '2017208', '软件工程', '信息工程学院', '123');
INSERT INTO `student` VALUES ('201720826', '郭世豪', '男', '20', '1999-08-20 00:00:00', '2017208', '软件工程', '信息工程学院', '123');
INSERT INTO `student` VALUES ('201720827', '高磊', '男', '20', '1999-09-20 00:00:00', '2017208', '软件工程', '信息工程学院', '123');
INSERT INTO `student` VALUES ('201720828', '游晶', '男', '20', '1999-08-30 00:00:00', '2017208', '软件工程', '信息工程学院', '123');
INSERT INTO `student` VALUES ('201720829', '熊龙君', '男', '20', '1998-12-20 00:00:00', '2017208', '软件工程', '信息工程学院', '123');
INSERT INTO `student` VALUES ('201720831', '张三', '男', '20', '1999-01-01 00:00:00', '2017208', '软件工程', '信息工程学院', '123');
SET FOREIGN_KEY_CHECKS=1;
