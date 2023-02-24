-- auto Generated on 2023-02-24
-- DROP TABLE IF EXISTS sys_dept;
drop table if exists sys_dept;
CREATE TABLE sys_dept(
 id VARCHAR (50) NOT NULL COMMENT 'id',
 parent_id VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'parentId',
 name VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'name',
 sort_num INT (11) NOT NULL  AUTO_INCREMENT COMMENT 'orderNum',
	create_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'createTime',
	create_by VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'createBy',
	update_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'updateTime',
	update_by VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'updateBy',
	remark VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'remark',
	PRIMARY KEY (id),
    unique key (sort_num)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT 'sys_dept';

INSERT INTO sys_dept (id, parent_id, name, sort_num,  create_by, create_time, update_by, update_time) VALUES ('a52ecd84306e0eee2406efad2646d17e', '', '码珑科技有限责任公司', 1,   '', '2023-02-15 12:12:31', '', '2023-02-15 12:12:31');
INSERT INTO sys_dept (id, parent_id, name, sort_num,  create_by, create_time, update_by, update_time) VALUES ('3c21d910ad2a11edade20242ac140003', 'a52ecd84306e0eee2406efad2646d17e', '综合管理部', 4,   '', '2023-02-15 12:14:02', '', '2023-02-15 12:14:02');
INSERT INTO sys_dept (id, parent_id, name, sort_num,  create_by, create_time, update_by, update_time) VALUES ('401e2f68ad2a11edade20242ac140003', 'a52ecd84306e0eee2406efad2646d17e', '财务资产部', 5,   '', '2023-02-15 12:14:09', '', '2023-02-15 12:14:09');
INSERT INTO sys_dept (id, parent_id, name, sort_num,  create_by, create_time, update_by, update_time) VALUES ('4914382fad2a11edade20242ac140003', 'a52ecd84306e0eee2406efad2646d17e', '人力资源部', 6,   '', '2023-02-15 12:14:24', '', '2023-02-15 12:14:24');
INSERT INTO sys_dept (id, parent_id, name, sort_num,  create_by, create_time, update_by, update_time) VALUES ('4e55dacead2a11edade20242ac140003', 'a52ecd84306e0eee2406efad2646d17e', '党群工作部', 7,   '', '2023-02-15 12:14:33', '', '2023-02-15 12:14:33');
INSERT INTO sys_dept (id, parent_id, name, sort_num,  create_by, create_time, update_by, update_time) VALUES ('518d219dad2a11edade20242ac140003', 'a52ecd84306e0eee2406efad2646d17e', '纪检监督部', 8,   '', '2023-02-15 12:14:38', '', '2023-02-15 12:14:38');
INSERT INTO sys_dept (id, parent_id, name, sort_num,  create_by, create_time, update_by, update_time) VALUES ('552a9354ad2a11edade20242ac140003', 'a52ecd84306e0eee2406efad2646d17e', '生产技术部', 9,   '', '2023-02-15 12:14:44', '', '2023-02-15 12:14:44');
INSERT INTO sys_dept (id, parent_id, name, sort_num,  create_by, create_time, update_by, update_time) VALUES ('5908dd45ad2a11edade20242ac140003', 'a52ecd84306e0eee2406efad2646d17e', '西南分公司', 10,   '', '2023-02-15 12:14:51', '', '2023-02-15 12:14:51');
INSERT INTO sys_dept (id, parent_id, name, sort_num,  create_by, create_time, update_by, update_time) VALUES ('649f6cf6ad2a11edade20242ac140003', '5908dd45ad2a11edade20242ac140003', '后勤保卫部', 11,   '', '2023-02-15 12:15:10', '', '2023-02-15 12:15:10');
INSERT INTO sys_dept (id, parent_id, name, order_num,  create_by, create_time, update_by, update_time) VALUES ('6c01cdebad2a11edade20242ac140003', '5908dd45ad2a11edade20242ac140003', '生产技术部', 12,   '', '2023-02-15 12:15:23', '', '2023-02-15 12:15:23');