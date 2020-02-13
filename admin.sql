/*
 Navicat Premium Data Transfer

 Source Server         : mydb
 Source Server Type    : MySQL
 Source Server Version : 50641
 Source Host           : localhost:3306
 Source Schema         : contacts

 Target Server Type    : MySQL
 Target Server Version : 50641
 File Encoding         : 65001

 Date: 11/11/2019 21:08:10
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `password` varchar(255) DEFAULT NULL,
  `admin_name` varchar(255) DEFAULT NULL,
  `contacts_name` varchar(255) DEFAULT NULL,
  `phoneNumber` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `open_id` varchar(255) DEFAULT NULL,
  `Invitation_code` varchar(255) DEFAULT NULL,
  `del_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=MyISAM AUTO_INCREMENT=10104 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of admin
-- ----------------------------
BEGIN;
INSERT INTO `admin` VALUES (10089, '698d51a19d8a121ce581499d7b701668', '董嘉楠', 'Test+1555513556770', '15158716108', '2019-04-17 23:05:57', '2019-05-10 11:36:14', 'obdz10AalhvLp4nTtNhQ_V36PRks', 'MTAwODk2MTA4', '2019-09-01 00:00:00');
INSERT INTO `admin` VALUES (10095, '698d51a19d8a121ce581499d7b701668', '董嘉楠', '通讯录测试001+1557460449560', '15158716108', '2019-05-10 11:54:10', '2019-05-10 23:10:39', 'obdz10AalhvLp4nTtNhQ_V36PRks', 'MTAwOTU2MTA4', '2019-07-01 00:00:00');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
