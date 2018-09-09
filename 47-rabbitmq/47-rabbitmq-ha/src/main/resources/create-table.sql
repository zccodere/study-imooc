CREATE TABLE `t_order` (
  `id` varchar(128) NOT NULL,
  `name` varchar(128) DEFAULT NULL,
  `message_id` varchar(128) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `broker_message_log` (
  `message_id` varchar(128) NOT NULL COMMENT '消息ID',
  `message` varchar(4000) DEFAULT NULL COMMENT '消息内容',
  `try_count` int(4) DEFAULT '0' COMMENT '重试次数',
  `status` varchar(10) DEFAULT NULL COMMENT '投递状态（0：投递中；1：投递成功；2：投递失败）',
  `next_retry` timestamp NULL DEFAULT '0000-00-00 00:00:00',
  `create_time` timestamp NULL DEFAULT '0000-00-00 00:00:00',
  `update_time` timestamp NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`message_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
