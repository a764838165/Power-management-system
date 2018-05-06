/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50537
Source Host           : localhost:3306
Source Database       : shoppingdb

Target Server Type    : MYSQL
Target Server Version : 50537
File Encoding         : 65001

Date: 2017-03-27 18:08:40
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `category`
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `cgId` int(50) NOT NULL AUTO_INCREMENT,
  `cgName` varchar(100) NOT NULL,
  PRIMARY KEY (`cgId`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('10', '衣服');
INSERT INTO `category` VALUES ('11', '电脑');
INSERT INTO `category` VALUES ('12', '书籍');
INSERT INTO `category` VALUES ('13', '生活用品');

-- ----------------------------
-- Table structure for `collect`
-- ----------------------------
DROP TABLE IF EXISTS `collect`;
CREATE TABLE `collect` (
  `cId` int(50) NOT NULL AUTO_INCREMENT,
  `cUserId` varchar(100) NOT NULL,
  `cUserName` varchar(100) NOT NULL,
  `cShopId` varchar(50) NOT NULL,
  PRIMARY KEY (`cId`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of collect
-- ----------------------------
INSERT INTO `collect` VALUES ('24', '19', 'pony1028', '14');
INSERT INTO `collect` VALUES ('25', '19', 'pony1028', '15');
INSERT INTO `collect` VALUES ('26', '19', 'pony1028', '7');

-- ----------------------------
-- Table structure for `review`
-- ----------------------------
DROP TABLE IF EXISTS `review`;
CREATE TABLE `review` (
  `rid` int(50) NOT NULL AUTO_INCREMENT,
  `rUserId` varchar(50) NOT NULL,
  `rUserName` varchar(100) NOT NULL,
  `rShopId` varchar(100) NOT NULL,
  `rReviewContent` varchar(300) NOT NULL,
  `rReplyContent` varchar(300) DEFAULT NULL,
  `rCreatime` varchar(100) NOT NULL,
  PRIMARY KEY (`rid`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of review
-- ----------------------------
INSERT INTO `review` VALUES ('16', '3', 'Pony', '4', '谢谢王医生的祝福', '新的一年要开心哦', '2017-02-06 15:33');
INSERT INTO `review` VALUES ('17', '19', 'pony1028', '7', '哟哟哟', '', '2017-03-02 10:11');
INSERT INTO `review` VALUES ('18', '19', 'pony1028', '7', '我哦哟', '', '2017-03-02 10:12');
INSERT INTO `review` VALUES ('19', '19', 'pony1028', '7', '我的购买', '', '2017-03-02 10:15');
INSERT INTO `review` VALUES ('20', '19', 'pony1028', '7', '我的购买我的', '', '2017-03-02 10:49');
INSERT INTO `review` VALUES ('21', '19', 'pony1028回复pony1028', '7', '', '', '2017-03-02 11:18');
INSERT INTO `review` VALUES ('22', '19', 'pony1028回复pony1028', '7', '', '', '2017-03-02 11:18');
INSERT INTO `review` VALUES ('23', '19', 'pony1028回复pony1028', '7', '我的测试', '', '2017-03-02 11:39');
INSERT INTO `review` VALUES ('24', '19', 'pony1028', '5', '一年又一年', '', '2017-03-02 11:40');
INSERT INTO `review` VALUES ('25', '19', 'pony1028回复pony1028', '5', '我哦的', '', '2017-03-02 11:40');
INSERT INTO `review` VALUES ('26', '23', 'ponylove', '10', '我喜欢', '', '2017-03-03 09:19');
INSERT INTO `review` VALUES ('27', '23', 'ponylove', '6', '哟哟dadadada', '', '2017-03-03 09:28');
INSERT INTO `review` VALUES ('28', '18', 'pony', '6', '我的数据', '', '2017-03-03 10:20');
INSERT INTO `review` VALUES ('29', '26', 'tom', '10', '我的评论', '', '2017-03-03 15:08');
INSERT INTO `review` VALUES ('30', '26', 'tom回复ponylove', '10', '我对你的回复', '', '2017-03-03 15:08');

-- ----------------------------
-- Table structure for `shop`
-- ----------------------------
DROP TABLE IF EXISTS `shop`;
CREATE TABLE `shop` (
  `sId` int(50) NOT NULL AUTO_INCREMENT,
  `sName` varchar(100) NOT NULL,
  `sMoney` varchar(100) NOT NULL,
  `sPhone` varchar(100) NOT NULL,
  `sMessage` varchar(100) NOT NULL,
  `sImage` varchar(500) NOT NULL,
  `sCreatime` varchar(100) NOT NULL,
  `userId` varchar(100) NOT NULL,
  `sState` varchar(50) NOT NULL,
  `sPayUsererId` varchar(50) DEFAULT NULL,
  `sPayUserName` varchar(100) DEFAULT NULL,
  `sCategory` varchar(100) NOT NULL,
  PRIMARY KEY (`sId`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shop
-- ----------------------------
INSERT INTO `shop` VALUES ('5', '手机', '5000', '15249243002', '我的产品', '20170227180957.jpg,40a4121a0de1035497dd5b1be5e22408.jpg,8d4e394f7a78fe67633038484d32bfee.jpg,f0003cffb54179d88bb7067b1359c88c.jpg', '08:42', '19', '1', '', null, '10');
INSERT INTO `shop` VALUES ('6', '电脑', '6000', '1524243002', '哦用', '8d4e394f7a78fe67633038484d32bfee.jpg,f0003cffb54179d88bb7067b1359c88c.jpg', '08:47', '19', '2', '23', 'ponylove', '11');
INSERT INTO `shop` VALUES ('7', '房子', '5000', '15249243002', '摸摸摸', 'a6b530da80a8cc6a64464104d43c0274.jpg,mmexport1488441286592.jpg', '09:15', '19', '1', '', null, '10');
INSERT INTO `shop` VALUES ('10', '测试产品', '600', '15249243002', '哟哟哟', '20170227173507.jpg,20170227175206.jpg,20170227180710.jpg,20170227180957.jpg,8d4e394f7a78fe67633038484d32bfee.jpg,f0003cffb54179d88bb7067b1359c88c.jpg,20170301_020341.jpg,S70302-101551.jpg', '08:43', '19', '2', '26', 'tom', '13');
INSERT INTO `shop` VALUES ('11', '书记', '66', '15249243002', '喔喔喔', '20170226_095040.jpg,S70226-102427.jpg,44f13dad3384161f4086589a871401b1.jpg', '09:19', '23', '1', '', null, '12');
INSERT INTO `shop` VALUES ('12', '我的手机', '666', '15249243002', '哟哟哟', 'mmexport1488441286592.jpg', '10:49', '19', '1', null, null, '12');
INSERT INTO `shop` VALUES ('13', '我的电脑最好了', '5000', '15249428888', '这个是我的电脑', 'Screenshot_2017-03-03-15-03-17.png,Screenshot_2017-03-03-15-03-21.png,Screenshot_2017-03-03-15-03-48.png,Screenshot_2017-03-03-15-03-56.png', '15:07', '26', '1', null, null, '13');
INSERT INTO `shop` VALUES ('14', '我Mook', '666', '55555', '他们', 'S70327-153418.jpg', '16:09', '19', '1', null, null, '11');
INSERT INTO `shop` VALUES ('15', '衣服', '5555', '1525', '拉拉裤', '2e968922b717a4543d287479386c32d3.jpg,e449da8d8f54be75106341d1584853be.jpg,f41966d0cb59480e91103566df404564.jpg,cd4f86adddf369a6c7b3132907e5b7dd.jpg,aba4fbde71bc71cf8e48607c31be1da4.jpg,5df8d69b7208661a13e5fe00df88920a.jpg,6ef00a11682c3f09c318432a3d1fef66.jpg,8681bb0e575090cd82e00d26d443ac2c.jpg', '16:10', '19', '1', null, null, '12');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uid` int(50) NOT NULL AUTO_INCREMENT,
  `uname` varchar(100) NOT NULL,
  `uphone` varchar(100) NOT NULL,
  `upswd` varchar(100) NOT NULL,
  `utime` varchar(100) NOT NULL,
  `utype` varchar(50) NOT NULL,
  `adminState` varchar(50) NOT NULL,
  `uimage` varchar(500) NOT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('18', 'pony', '15249243', '123456', '2017-02-28 23:11', '1', '2', '');
INSERT INTO `user` VALUES ('19', 'pony1028', '15249243002', '123456', '2017-02-28 23:12', '2', '2', '');
INSERT INTO `user` VALUES ('23', 'ponylove', '15249248989', '123456', '2017-03-02 17:27', '1', '2', 'f0003cffb54179d88bb7067b1359c88c.jpg,a6b530da80a8cc6a64464104d43c0274.jpg');
INSERT INTO `user` VALUES ('25', 'ay', '15249245656', '123456', '2017-03-03 08:46', '1', '3', 'mmexport1488441286592.jpg');
INSERT INTO `user` VALUES ('26', 'tom', '15249242323', '123456', '2017-03-03 15:06', '2', '2', 'Screenshot_2017-03-03-15-03-21.png,Screenshot_2017-03-03-15-03-56.png');
