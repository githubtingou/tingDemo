/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : testboot

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2018-12-03 19:45:06
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin_menu
-- ----------------------------
DROP TABLE IF EXISTS `admin_menu`;
CREATE TABLE `admin_menu` (
  `id` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL,
  `parent_id` varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '父类id',
  `parent_ids` varchar(1000) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '所有父类id',
  `tree_code` varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '排序编号',
  `menu_name` varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `menu_href` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '链接',
  `menu_target` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '目标',
  `menu_icon` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '图标',
  `permission` varchar(1000) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '权限标识',
  `is_show` char(1) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '是否显示（1显示 0隐藏）',
  `status` char(1) COLLATE utf8mb4_unicode_ci DEFAULT '0' COMMENT '状态（0正常 1删除 2停用）',
  `create_by` varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '创建时间',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '更新人',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `remarks` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='系统菜单表';

-- ----------------------------
-- Records of admin_menu
-- ----------------------------

-- ----------------------------
-- Table structure for admin_user
-- ----------------------------
DROP TABLE IF EXISTS `admin_user`;
CREATE TABLE `admin_user` (
  `id` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL,
  `login_name` varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '登录名',
  `login_img` varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '头像',
  `name` varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户名',
  `password` varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '密码',
  `email` varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '邮箱',
  `sex` char(1) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '性别',
  `mobile` varchar(13) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '手机号',
  `sign` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '个性签名',
  `wx_openid` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '微信号',
  `age` int(3) DEFAULT NULL COMMENT '年龄',
  `create_by` varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '更新人',
  `update_date` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `freeze_cause` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '冻结原因',
  `freeze_date` datetime DEFAULT NULL COMMENT '冻结时间',
  `status` char(1) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '状态（0正常 1删除 2停用 3冻结）',
  `login_flag` char(1) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '登录状态',
  `login_ip` varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '最后登录ip',
  `login_date` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '最后登录时间',
  `remarks` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of admin_user
-- ----------------------------

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL,
  `description` varchar(200) DEFAULT NULL,
  `url` varchar(200) NOT NULL,
  `pid` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of sys_permission
-- ----------------------------
INSERT INTO `sys_permission` VALUES ('1', 'ROLE_HOME', 'home', '/', null);
INSERT INTO `sys_permission` VALUES ('2', 'ROLE_ADMIN', 'ABel', '/admin', null);

-- ----------------------------
-- Table structure for sys_permission_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission_role`;
CREATE TABLE `sys_permission_role` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) unsigned NOT NULL,
  `permission_id` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of sys_permission_role
-- ----------------------------
INSERT INTO `sys_permission_role` VALUES ('1', '1', '1');
INSERT INTO `sys_permission_role` VALUES ('2', '1', '2');
INSERT INTO `sys_permission_role` VALUES ('3', '2', '1');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', 'ROLE_ADMIN');
INSERT INTO `sys_role` VALUES ('2', 'ROLE_USER');

-- ----------------------------
-- Table structure for sys_role_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_user`;
CREATE TABLE `sys_role_user` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `sys_user_id` bigint(20) unsigned NOT NULL,
  `sys_role_id` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of sys_role_user
-- ----------------------------
INSERT INTO `sys_role_user` VALUES ('1', '1', '1');
INSERT INTO `sys_role_user` VALUES ('2', '2', '2');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(200) NOT NULL,
  `password` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'admin', 'admin');
INSERT INTO `sys_user` VALUES ('2', 'abel', 'abel');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL,
  `name` varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `age` int(64) DEFAULT NULL,
  `password` varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `status` char(2) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '1', '1', '1', '1');
INSERT INTO `user` VALUES ('10', '10', '10', '10', null);
INSERT INTO `user` VALUES ('11', '11', '11', '11', null);
INSERT INTO `user` VALUES ('12', '12', '12', '12', null);
INSERT INTO `user` VALUES ('123456', '123456', '11', '123456', null);
INSERT INTO `user` VALUES ('13', '13', '13', '13', null);
INSERT INTO `user` VALUES ('14', '14', '14', '14', null);
INSERT INTO `user` VALUES ('15', '15', '15', '15', null);
INSERT INTO `user` VALUES ('16', '16', '16', '16', null);
INSERT INTO `user` VALUES ('17', '17', '17', '17', null);
INSERT INTO `user` VALUES ('18', '18', '18', '18', null);
INSERT INTO `user` VALUES ('19', '19', '19', '19', null);
INSERT INTO `user` VALUES ('2', '2', '2', '2', null);
INSERT INTO `user` VALUES ('20', '20', '20', '20', null);
INSERT INTO `user` VALUES ('21', '21', '21', '21', null);
INSERT INTO `user` VALUES ('22', '22', '22', '22', null);
INSERT INTO `user` VALUES ('23', '23', '23', '23', null);
INSERT INTO `user` VALUES ('24', '24', '24', '24', null);
INSERT INTO `user` VALUES ('26', '26', '26', '26', null);
INSERT INTO `user` VALUES ('3', '3', '3', '3', null);
INSERT INTO `user` VALUES ('4', '4', '4', '4', null);
INSERT INTO `user` VALUES ('4449f8f8050e48079d7d291a99c0d53d', 'wangwu', '20', '$2a$10$dMufkuWHNdgXb5yPHpFR5eYhH2qebC6VrgpA2nVa1I86MYIeVTc/W', '1');
INSERT INTO `user` VALUES ('456', '456', '456', '456', null);
INSERT INTO `user` VALUES ('5', '5', '5', '5', null);
INSERT INTO `user` VALUES ('6', '6', '6', '6', null);
INSERT INTO `user` VALUES ('6d4df0a9595a4f1d843dba9234a8e6f5', 'admin', null, '$2a$10$4wmH4w1p6QxZ0E/jwH5gludlca3n/xxRjDcqrYkfKOaLepU5V8XMu', null);
INSERT INTO `user` VALUES ('7', '7', '7', '7', null);
INSERT INTO `user` VALUES ('77d450eb33d94ece84849d7a440190c7', 'ming', null, '$2a$10$djw6nSpLwVc2UfDJyIRjE.guh9PWt.p6d8IMZE8BWUiypiXriDi/G', null);
INSERT INTO `user` VALUES ('8', '8', '8', '8', null);
INSERT INTO `user` VALUES ('9', '9', '9', '9', null);
INSERT INTO `user` VALUES ('a1bf5bd5ef1a4c45a8b81fc759741080', 'lisi', '20', '$2a$10$IoLf5owgGK4Duy9Satg3lOQHMe3IR5QC/i4jDVUR8l1v7TM1L0nq.', '1');
