/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50625
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50625
File Encoding         : 65001

Date: 2018-08-21 15:31:34
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for ssm_dept
-- ----------------------------
DROP TABLE IF EXISTS `ssm_dept`;
CREATE TABLE `ssm_dept` (
  `dept_id` int(11) NOT NULL AUTO_INCREMENT,
  `dept_name` varchar(255) NOT NULL,
  PRIMARY KEY (`dept_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ssm_dept
-- ----------------------------
INSERT INTO `ssm_dept` VALUES ('1', '开发部');
INSERT INTO `ssm_dept` VALUES ('2', '业务部');
SET FOREIGN_KEY_CHECKS=1;
