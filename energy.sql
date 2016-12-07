/*
Navicat MySQL Data Transfer

Source Server         : root@127.0.0.1
Source Server Version : 50610
Source Host           : localhost:3306
Source Database       : energy

Target Server Type    : MYSQL
Target Server Version : 50610
File Encoding         : 65001

Date: 2016-10-21 04:25:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(60) NOT NULL,
  `enabled` int(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1', 'admin', '21232f297a57a5a743894a0e4a801fc3', '1');

-- ----------------------------
-- Table structure for users_roles
-- ----------------------------
DROP TABLE IF EXISTS `users_roles`;
CREATE TABLE `users_roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `rolename` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `IDX_UNI_ROLE_USERNAME` (`username`,`rolename`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users_roles
-- ----------------------------
INSERT INTO `users_roles` VALUES ('2', 'admin', 'ROLE_ADMIN');
INSERT INTO `users_roles` VALUES ('1', 'admin', 'ROLE_USER');
