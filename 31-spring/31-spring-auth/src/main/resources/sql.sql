DROP TABLE IF EXISTS auth_user;
CREATE TABLE auth_user (
  id BIGINT(20) AUTO_INCREMENT NOT NULL,
  name varchar(64) NOT NULL,
  pwd varchar(64) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



DROP TABLE IF EXISTS auth_role;
CREATE TABLE auth_role (
  id BIGINT(20) AUTO_INCREMENT NOT NULL,
  name varchar(64) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS auth_function;
CREATE TABLE auth_function (
  id BIGINT(20) AUTO_INCREMENT NOT NULL,
  name varchar(64) NOT NULL,
  parent_id BIGINT(20) NOT NULL,
  url varchar(128) NOT NULL,
  serial_num int NOT NULL,
  accordion int NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS auth_role_function;
CREATE TABLE auth_role_function (
  id BIGINT(20) AUTO_INCREMENT NOT NULL,
  role_id BIGINT(20) NOT NULL,
  function_id BIGINT(20) NOT NULL,
  status int NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS auth_user_role;
CREATE TABLE auth_user_role (
  id BIGINT(20) AUTO_INCREMENT NOT NULL,
  role_id BIGINT(20) NOT NULL,
  user_id BIGINT(20) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;




