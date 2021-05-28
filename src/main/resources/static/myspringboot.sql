-- 创建数据库
create schema `ssnail_pdw` collate utf8mb4_general_ci;

-- 创建用户表
DROP TABLE IF EXISTS `ss_user`;
CREATE TABLE `ss_user` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(20) DEFAULT NULL COMMENT '用户名',
  `password` varchar(32) DEFAULT NULL COMMENT '密码',
  `date_create` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `date_update` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COMMENT='用户表'

-- 创建角色表
DROP TABLE IF EXISTS `ss_role`;
CREATE TABLE `ss_role` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_type` int(2) unsigned NOT NULL COMMENT '角色类型',
  `description` varchar(50) DEFAULT NULL COMMENT '角色描述',
  `date_create` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `date_update` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COMMENT='角色表'

create table ss_user_role
(
    user_id bigint not null comment '用户id',
    role_id bigint not null comment '角色表id',
    date_create datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    date_update datetime default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP comment '更新时间',
    constraint ss_user_role_pk
        primary key (user_id, role_id)
)
    comment '用户角色表';
