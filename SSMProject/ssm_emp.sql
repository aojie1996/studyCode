/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50625
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50625
File Encoding         : 65001

Date: 2018-08-21 15:31:28
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for ssm_emp
-- ----------------------------
DROP TABLE IF EXISTS `ssm_emp`;
CREATE TABLE `ssm_emp` (
  `emp_id` int(11) NOT NULL AUTO_INCREMENT,
  `emp_name` varchar(255) NOT NULL,
  `gender` char(1) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `d_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`emp_id`),
  KEY `d_id` (`d_id`),
  CONSTRAINT `d_id` FOREIGN KEY (`d_id`) REFERENCES `ssm_dept` (`dept_id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ssm_emp
-- ----------------------------
INSERT INTO `ssm_emp` VALUES ('1', 'aaa', 'M', 'aaa@qq.com', '1');
INSERT INTO `ssm_emp` VALUES ('2', 'lll', 'M', 'aaa@qq.com', '1');
INSERT INTO `ssm_emp` VALUES ('3', 'bbb', 'w', 'aaa@qq.com', '2');
INSERT INTO `ssm_emp` VALUES ('4', 'ccc', 'M', 'aaa@qq.com', '1');
INSERT INTO `ssm_emp` VALUES ('5', 'ddd', 'w', 'aaa@qq.com', '1');
INSERT INTO `ssm_emp` VALUES ('6', 'eee', 'M', 'aaa@qq.com', '2');
INSERT INTO `ssm_emp` VALUES ('7', 'fff', 'w', 'aaa@qq.com', '1');
INSERT INTO `ssm_emp` VALUES ('8', 'ggg', 'M', 'aaa@qq.com', '1');
INSERT INTO `ssm_emp` VALUES ('9', 'hhh', 'w', 'aaa@qq.com', '2');
INSERT INTO `ssm_emp` VALUES ('10', 'iii', 'M', 'aaa@qq.com', '2');
INSERT INTO `ssm_emp` VALUES ('11', 'jjj', 'w', 'aaa@qq.com', '1');
INSERT INTO `ssm_emp` VALUES ('12', 'kkk', 'M', 'aaa@qq.com', '1');
INSERT INTO `ssm_emp` VALUES ('13', 'lsa', 'M', 'aaa@qq.com', '1');
INSERT INTO `ssm_emp` VALUES ('14', 'bdb', 'w', 'aaa@qq.com', '2');
INSERT INTO `ssm_emp` VALUES ('15', 'cfc', 'M', 'aaa@qq.com', '1');
INSERT INTO `ssm_emp` VALUES ('16', 'pld', 'w', 'aaa@qq.com', '1');
INSERT INTO `ssm_emp` VALUES ('17', 'efe', 'M', 'aaa@qq.com', '2');
INSERT INTO `ssm_emp` VALUES ('18', 'fhy', 'w', 'aaa@qq.com', '1');
INSERT INTO `ssm_emp` VALUES ('19', 'rtg', 'M', 'aaa@qq.com', '1');
INSERT INTO `ssm_emp` VALUES ('20', 'jhh', 'w', 'aaa@qq.com', '2');
INSERT INTO `ssm_emp` VALUES ('21', 'tgi', 'M', 'aaa@qq.com', '2');
INSERT INTO `ssm_emp` VALUES ('22', 'pon', 'w', 'aaa@qq.com', '1');
INSERT INTO `ssm_emp` VALUES ('24', 'ygd', 'F', 'ygd@qq.com', '2');
INSERT INTO `ssm_emp` VALUES ('25', 'ygc', 'M', 'ygc1@qq.com', '2');
INSERT INTO `ssm_emp` VALUES ('26', 'ygda', 'M', 'ygd@qq.coma', '1');
INSERT INTO `ssm_emp` VALUES ('27', 'bgc', 'M', 'bgc@qq.com', '1');
INSERT INTO `ssm_emp` VALUES ('28', 'map', 'M', 'map11@qq.com', '1');
INSERT INTO `ssm_emp` VALUES ('29', 'bgcqwqeqwe', 'M', '', '1');
INSERT INTO `ssm_emp` VALUES ('30', 'bgcqwqeqwe', 'w', 'map@qq.com', '1');
INSERT INTO `ssm_emp` VALUES ('31', 'bgcaaaa', 'w', 'aaa@qq.com', '1');
SET FOREIGN_KEY_CHECKS=1;
