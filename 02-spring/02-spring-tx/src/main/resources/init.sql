CREATE TABLE `account` (
  `name` varchar(32) NOT NULL DEFAULT '' COMMENT '账号',
  `money` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '金额（元）',
  PRIMARY KEY (`name`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `account`(`name`, `money`) VALUES ('aaa', 10000.00);
INSERT INTO `account`(`name`, `money`) VALUES ('bbb', 10000.05);
