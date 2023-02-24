drop table if exists sys_role;
CREATE TABLE sys_role(
                         id VARCHAR (50) NOT NULL COMMENT 'id',
                         name VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'name',
                         sort_num INT (11) NOT NULL AUTO_INCREMENT COMMENT 'sortNum',
                         create_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'createTime',
                         create_by VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'createBy',
                         update_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP  COMMENT 'updateTime',
                         update_by VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'updateBy',
                         remark VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'remark',
                         PRIMARY KEY (id),
                         unique key (sort_num)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT 'sys_role';
