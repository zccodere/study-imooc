CREATE TABLE `employee` (
  `employee_id` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '员工编号',
  `employee_name` varchar(32) NOT NULL DEFAULT '' COMMENT '员工名称',
  PRIMARY KEY (`employee_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='员工表';

CREATE TABLE `project` (
  `project_id` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '项目编号',
  `project_name` varchar(32) NOT NULL DEFAULT '' COMMENT '项目名称',
  PRIMARY KEY (`project_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='项目表';

CREATE TABLE `project_employee` (
  `relation_project_id` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '项目编号',
  `relation_employee_id` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '员工编号',
  PRIMARY KEY (`relation_project_id`,`relation_employee_id`) USING BTREE,
  KEY `fk_employee_id` (`relation_employee_id`),
  CONSTRAINT `fk_employee_id` FOREIGN KEY (`relation_employee_id`) REFERENCES `employee` (`employee_id`),
  CONSTRAINT `fk_project_id` FOREIGN KEY (`relation_project_id`) REFERENCES `project` (`project_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='项目员工表';
 