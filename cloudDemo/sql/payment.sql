/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50720
Source Host           : 127.0.0.1:3306
Source Database       : 1804

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2020-05-30 21:04:36
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for payment
-- ----------------------------
DROP TABLE IF EXISTS `payment`;
CREATE TABLE `payment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `serial` varchar(255) CHARACTER SET utf16 DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1266639933460824066 DEFAULT CHARSET=utf8mb4;
