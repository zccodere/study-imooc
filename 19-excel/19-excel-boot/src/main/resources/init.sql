-- ----------------------------
-- Table structure for import_data
-- ----------------------------
DROP TABLE IF EXISTS `import_data`;
CREATE TABLE `import_data` (
  `id` bigint(20) NOT NULL,
  `dealDate` varchar(255) DEFAULT NULL,
  `dealStatus` varchar(255) DEFAULT NULL,
  `importDataType` varchar(255) DEFAULT NULL,
  `importDate` varchar(255) DEFAULT NULL,
  `importStatus` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of import_data
-- ----------------------------
INSERT INTO `import_data` VALUES ('1', '2017-07-08 16:09:08', '1', 'student', '2017-07-08 16:09:08', '1');

-- ----------------------------
-- Table structure for import_data_detail
-- ----------------------------
DROP TABLE IF EXISTS `import_data_detail`;
CREATE TABLE `import_data_detail` (
  `id` bigint(20) NOT NULL,
  `col0` varchar(255) DEFAULT NULL,
  `col1` varchar(255) DEFAULT NULL,
  `col2` varchar(255) DEFAULT NULL,
  `col3` varchar(255) DEFAULT NULL,
  `col4` varchar(255) DEFAULT NULL,
  `col5` varchar(255) DEFAULT NULL,
  `col6` varchar(255) DEFAULT NULL,
  `col7` varchar(255) DEFAULT NULL,
  `col8` varchar(255) DEFAULT NULL,
  `col9` varchar(255) DEFAULT NULL,
  `dealFailCode` varchar(255) DEFAULT NULL,
  `dealFailMsg` varchar(255) DEFAULT NULL,
  `dealStatus` varchar(255) DEFAULT NULL,
  `importId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of import_data_detail
-- ----------------------------

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` bigint(20) NOT NULL,
  `age` varchar(255) DEFAULT NULL,
  `birthday` varchar(255) DEFAULT NULL,
  `hobby` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `num` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', '20', '2000-01-01', '看电影', '张三', '001', '男');
INSERT INTO `student` VALUES ('2', '18', '2001-04-12', '骑车', '林志玲', '002', '女');
INSERT INTO `student` VALUES ('3', '20', '2005-01-01', '玩游戏', '李四', '003', '男');
INSERT INTO `student` VALUES ('4', '18', '2001-04-12', '骑车', '林志玲', '004', '女');
INSERT INTO `student` VALUES ('5', '20', '2007-09-18', '看电影', '杨幂', '005', '女');
INSERT INTO `student` VALUES ('6', '18', '2002-07-12', '骑车', '刘亦菲', '006', '女');
