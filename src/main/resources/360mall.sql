/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : 360mall

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2017-11-30 15:30:07
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for cart
-- ----------------------------
DROP TABLE IF EXISTS `cart`;
CREATE TABLE `cart` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `gid` int(11) DEFAULT NULL,
  `img` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `num` int(11) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cart
-- ----------------------------
INSERT INTO `cart` VALUES ('1', '10114', 'det1.jpg', '360手机奇酷青春版移动联通双4G辰光银', '阳光白', '999.00', '1', 'admin');
INSERT INTO `cart` VALUES ('2', '10103', 'det1.jpg', '360手机f4标准版全网通', '阳光白', '777.00', '2', 'admin');
INSERT INTO `cart` VALUES ('3', '10101', 'det9.jpg', '360手机N4S全网通版（7天之内发货）', '阳光白', '888.00', '2', 'admin');
INSERT INTO `cart` VALUES ('4', '10102', 'det13.jpg', '360手机Q5 全网通', '阳光白', '999.00', '1', 'admin');
INSERT INTO `cart` VALUES ('10', '10101', 'det9.jpg', '360手机N4S全网通版（7天之内发货）', '阳光白', '888.00', '1', null);

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `stock` varchar(255) DEFAULT NULL,
  `img1` varchar(255) DEFAULT NULL,
  `img2` varchar(255) DEFAULT NULL,
  `img3` varchar(255) DEFAULT NULL,
  `img4` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10109 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('10101', '360手机N4S全网通版（7天之内发货）', '888.00', '18', 'det9.jpg', 'det10.jpg', 'det11.jpg', 'det12.jpg');
INSERT INTO `goods` VALUES ('10103', '360手机f4标准版全网通', '777.00', '44', 'det1.jpg', 'det6.jpg', 'det2.jpg', 'det4.jpg');
INSERT INTO `goods` VALUES ('10104', '360手机奇酷青春版移动联通双4G辰光银', '997.00', '99', 'det1.jpg', 'det2.jpg', 'det3.jpg', 'det4.jpg');
INSERT INTO `goods` VALUES ('10105', '360手机N4全网通阳光白', '666.00', '88', 'det5.jpg', 'det6.jpg', 'det7.jpg', 'det8.jpg');
INSERT INTO `goods` VALUES ('10106', '360闪充闪放双涡轮引擎快充移动电源10000mAh', '99.00', '65', 'det17.png', 'det18.png', 'det19.png', 'det20.png');
INSERT INTO `goods` VALUES ('10107', '360 环音耳机立体声效', '88.00', '100', 'det21.png', 'det22.png', 'det23.png', 'det24.png');
INSERT INTO `goods` VALUES ('10108', '360充电宝耳机组合套装完美无损音质', '188.00', '33', 'det25.png', 'det23.png', 'det20.png', 'det24.png');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) DEFAULT NULL,
  `pass_word` varchar(255) DEFAULT NULL,
  `cellphone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', '123456', '13023046077');
INSERT INTO `user` VALUES ('2', '792435323', '123456', null);
