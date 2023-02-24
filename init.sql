-- auto Generated on 2023-02-20
-- DROP TABLE IF EXISTS sys_user;
drop table if exists sys_user;
CREATE TABLE sys_user(
 id VARCHAR (50) NOT NULL COMMENT 'id',
 username VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'username',
 `password` VARCHAR (100) NOT NULL DEFAULT '' COMMENT 'password',
	create_time DATETIME  DEFAULT CURRENT_TIMESTAMP COMMENT 'createTime',
	create_by VARCHAR (50)  DEFAULT '' COMMENT 'createBy',
	update_time TIMESTAMP  DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'updateTime',
	update_by VARCHAR (50)  DEFAULT '' COMMENT 'updateBy',
    remark VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'remark',
	PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT 'sys_user';
