CREATE TABLE `tb_area` (
`area_id`  int(2) NOT NULL AUTO_INCREMENT ,
`area_name`  varchar(255) NOT NULL ,
`priority`  int(2) NOT NULL DEFAULT 0 ,
`create_time`  datetime NULL DEFAULT NULL,
`last_edit_time`  datetime NULL DEFAULT NULL,
PRIMARY KEY (`area_id`),
UNIQUE KEY `UK_AREA`(`area_name`)
)ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
