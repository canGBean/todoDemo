/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : todobear

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2020-06-18 14:44:06
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `todos`
-- ----------------------------
DROP TABLE IF EXISTS `todos`;
CREATE TABLE `todos` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `date` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `abstracts` varchar(200) DEFAULT NULL,
  `detail` varchar(400) DEFAULT NULL,
  `status` int(11) DEFAULT NULL COMMENT '0:已办 1:待办 999:其他',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of todos
-- ----------------------------
INSERT INTO `todos` VALUES ('3', '2020-05-15 08:00:00', '1A1AA3', 'qw', '1', '2020-05-15 14:25:59');
INSERT INTO `todos` VALUES ('4', '2020-05-15 08:00:00', '1A1AA3', 'qw', '1', '2020-05-15 14:26:34');
INSERT INTO `todos` VALUES ('5', '2020-05-15 08:00:00', '1A1AA3', 'qwqeqwe', '1', '2020-05-15 14:31:54');
INSERT INTO `todos` VALUES ('6', '2020-05-15 12:13:47', '1A12312dddddddd1AA3', 'qw1231233', '1', '2020-05-15 14:33:13');
INSERT INTO `todos` VALUES ('7', '2020-05-15 12:13:47', '1A12312dddddddd1AA3', 'qw1231233', '1', '2020-05-15 14:33:24');
INSERT INTO `todos` VALUES ('8', '2020-05-19 12:13:47', '但是防守对方', '上的放松的方式对方的身份第三方的身份', '1', '2020-05-15 14:34:36');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(40) NOT NULL,
  `password` varchar(40) NOT NULL,
  `avatar` varchar(200) DEFAULT NULL,
  `roles` varchar(100) DEFAULT NULL,
  `token` varchar(40) DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  `lastlogin_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `lastlogout_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('2', 'guest', 'guest', 'https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif', 'guest', '61dac789740a4326aff29ab8d2000c27', '2020-05-15 13:06:32', null, null);
INSERT INTO `user` VALUES ('3', 'admin', 'admin', 'https://gw.alipayobjects.com/zos/antfincdn/XAosXuNZyF/BiazfanxmamNRoxxVxka.png', 'admin', '6e1d2c0e4e9f4d8f80c71964972ab87e', '2020-05-08 20:06:13', '2020-05-15 19:34:57', '2020-05-15 19:49:32');
INSERT INTO `user` VALUES ('4', 'guest', 'guest', 'https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif', 'guest', '5c931015d6ab470c8630a0b9a19c2a43', '2020-05-08 20:09:33', null, null);
INSERT INTO `user` VALUES ('5', 'guest', 'guest', 'https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif', 'guest', '74df5edf6a2b4b5db9366479717e0ba8', '2020-05-08 20:15:41', null, null);
INSERT INTO `user` VALUES ('6', 'guest', 'guest', 'https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif', 'guest', '5e2c178322fb455eb38bc65c4031d5d6', '2020-05-15 13:22:20', null, null);
INSERT INTO `user` VALUES ('7', 'guest', 'guest', 'https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif', 'guest', '149de2b37a56458ab37ad8de6bf17957', '2020-05-15 13:24:42', null, null);
INSERT INTO `user` VALUES ('8', 'guest', 'guest', 'https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif', 'guest', 'c523184781324bf8b0f9c7c7ec2a4e7d', '2020-05-15 13:24:56', null, null);
INSERT INTO `user` VALUES ('9', 'guest1', 'guest1', 'https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif', 'guest', 'dec3b371229949bf895774afb7ed6ede', '2020-05-15 14:25:04', null, null);
