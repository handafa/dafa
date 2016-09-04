/*
Navicat MySQL Data Transfer

Source Server         : 本地连接
Source Server Version : 50155
Source Host           : localhost:3306
Source Database       : dafa

Target Server Type    : MYSQL
Target Server Version : 50155
File Encoding         : 65001

Date: 2013-01-19 16:49:56
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_sys_dictionaries`
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_dictionaries`;
CREATE TABLE `t_sys_dictionaries` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='@author 韩大发\r\n@time 2013-01-12\r\n@summary 数据字典主表';

-- ----------------------------
-- Records of t_sys_dictionaries
-- ----------------------------

-- ----------------------------
-- Table structure for `t_sys_dictionaries_children`
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_dictionaries_children`;
CREATE TABLE `t_sys_dictionaries_children` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='@author 韩大发\r\n@time 2013-01-12\r\n@summary 数据字典子表';

-- ----------------------------
-- Records of t_sys_dictionaries_children
-- ----------------------------

-- ----------------------------
-- Table structure for `t_sys_groups`
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_groups`;
CREATE TABLE `t_sys_groups` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `group_id` varchar(255) DEFAULT NULL COMMENT '组织编码',
  `group_name` varchar(255) DEFAULT NULL COMMENT '组织名称',
  `father_node` int(255) DEFAULT NULL COMMENT '父节点',
  `if_father` int(11) DEFAULT NULL COMMENT '是否是父节点0非1是',
  `weight` int(11) DEFAULT NULL COMMENT '排序',
  `note` varchar(255) DEFAULT NULL COMMENT '备注',
  `status` int(1) DEFAULT NULL COMMENT '有效状态',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `creater` varchar(255) DEFAULT NULL COMMENT '创建者',
  `update_time` datetime DEFAULT NULL COMMENT '更改时间',
  `updater` varchar(255) DEFAULT NULL COMMENT '更改者',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8 COMMENT='@author \r\n@time 2013-01-11\r\n@summary 组织表';

-- ----------------------------
-- Records of t_sys_groups
-- ----------------------------
INSERT INTO `t_sys_groups` VALUES ('-1', '1', '组织目录', '-2', '1', '1', '组织目录', null, null, null, null, null);
INSERT INTO `t_sys_groups` VALUES ('1', '1001', '中华人民共和国', '-1', '1', '1', '中华', '1', null, null, '2013-01-15 14:33:53', '2013-01-15 14:33:53');
INSERT INTO `t_sys_groups` VALUES ('2', '10001000', '山东省', '1', '1', '1', '山东省', '1', '2013-01-11 15:07:34', null, '2013-01-11 15:07:37', null);
INSERT INTO `t_sys_groups` VALUES ('3', '10001002', '山西省', '1', '1', '2', '山西省', '1', '2013-01-15 11:38:05', null, '2013-01-15 14:20:07', '2013-01-15 14:20:07');
INSERT INTO `t_sys_groups` VALUES ('4', '10001003', '江苏省', '1', '1', '3', '江苏省', '1', '2013-01-15 11:54:57', null, '2013-01-15 14:20:21', '2013-01-15 14:20:21');
INSERT INTO `t_sys_groups` VALUES ('6', '100010001009', '日照市', '2', '1', '1', '日照，我的故乡！', '1', '2013-01-15 12:34:01', null, '2013-01-15 14:22:54', '2013-01-15 14:22:54');
INSERT INTO `t_sys_groups` VALUES ('7', '100010001006', '济南市', '2', '0', '1', '济南市', '1', '2013-01-15 12:34:20', null, '2013-01-15 14:17:39', '2013-01-15 14:17:39');
INSERT INTO `t_sys_groups` VALUES ('9', '100010001005', '青岛市', '2', '0', '2', '青岛', '1', '2013-01-15 13:11:48', null, '2013-01-15 14:18:10', '2013-01-15 14:18:10');
INSERT INTO `t_sys_groups` VALUES ('10', '100010001005', '淄博市', '2', '0', '4', '淄博', '1', '2013-01-15 13:57:06', null, '2013-01-15 14:18:30', '2013-01-15 14:18:30');
INSERT INTO `t_sys_groups` VALUES ('11', '100010001007', '莱芜市', '2', '0', '5', '莱芜', '1', '2013-01-15 13:58:17', null, '2013-01-15 14:19:30', '2013-01-15 14:19:30');
INSERT INTO `t_sys_groups` VALUES ('12', '1000100010081000', '岚山区', '6', '1', '1', '大爱岚山', '1', '2013-01-15 14:20:59', null, '2013-01-15 14:20:59', null);
INSERT INTO `t_sys_groups` VALUES ('13', '1002', '美利坚合众国', '-1', '0', '2', '美利坚合众国', '1', '2013-01-15 14:24:06', null, '2013-01-15 14:33:38', '2013-01-15 14:33:38');
INSERT INTO `t_sys_groups` VALUES ('15', '1003', '大不列颠', '-1', '0', '3', '大不列颠', '1', '2013-01-15 14:29:42', null, '2013-01-15 14:33:17', '2013-01-15 14:33:17');
INSERT INTO `t_sys_groups` VALUES ('16', '1004', '德意志共和国', '-1', '0', '1', '德意志共和国', '1', '2013-01-15 14:34:38', null, '2013-01-15 14:34:38', null);
INSERT INTO `t_sys_groups` VALUES ('17', '1005', '法兰西合众国', '-1', '0', '1', '法兰西合众国', '1', '2013-01-15 14:36:25', null, '2013-01-15 14:36:51', '2013-01-15 14:36:51');
INSERT INTO `t_sys_groups` VALUES ('18', '1006', '意大利', '-1', '0', '5', '意大利', '1', '2013-01-15 14:39:17', null, '2013-01-15 14:39:17', null);
INSERT INTO `t_sys_groups` VALUES ('19', '100010031001', '南京', '4', '0', '1', '南京', '1', '2013-01-15 14:40:49', null, '2013-01-15 14:40:49', null);
INSERT INTO `t_sys_groups` VALUES ('20', '100010021001', '大同市', '3', '0', '1', '大同', '1', '2013-01-15 14:47:32', null, '2013-01-15 14:47:32', null);
INSERT INTO `t_sys_groups` VALUES ('21', '11007', '小日本', '-1', '1', '7', '小日本', '1', '2013-01-18 09:44:58', null, '2013-01-18 09:44:58', null);
INSERT INTO `t_sys_groups` VALUES ('23', '10011005', '钓鱼岛', '1', '0', '1', '\'钓鱼岛是中国的。\' 的确是', '1', '2013-01-18 10:59:37', null, '2013-01-18 11:03:39', '2013-01-18 11:03:39');
INSERT INTO `t_sys_groups` VALUES ('26', '110071005', '名古屋', '21', '0', '2', '名古屋的清酒a', '1', '2013-01-18 11:24:56', null, '2013-01-18 21:13:20', '2013-01-18 21:13:20');
INSERT INTO `t_sys_groups` VALUES ('27', '100010001008100010011001', '虎山镇', '12', '0', '1', '虎山镇飞', '1', '2013-01-18 11:42:14', null, '2013-01-18 15:39:28', '2013-01-18 15:39:28');
INSERT INTO `t_sys_groups` VALUES ('30', '10001000100810001002', '汾水', '12', '0', '1', '汾水', '1', '2013-01-18 21:07:14', null, '2013-01-18 21:07:14', null);
INSERT INTO `t_sys_groups` VALUES ('32', '1000100010091002', '东港区', '6', '1', '2', '东港区', '1', '2013-01-18 21:13:50', null, '2013-01-18 21:13:50', null);
INSERT INTO `t_sys_groups` VALUES ('33', '10001000100910021001', '涛雒镇', '32', '0', '1', '丁肇中的故乡！！！', '1', '2013-01-18 21:14:22', null, '2013-01-18 21:14:22', null);

-- ----------------------------
-- Table structure for `t_sys_menus`
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_menus`;
CREATE TABLE `t_sys_menus` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) DEFAULT NULL COMMENT '菜单名称',
  `url` varchar(255) DEFAULT NULL COMMENT '菜单链接',
  `father_node` int(11) DEFAULT NULL COMMENT '父节点',
  `if_father` int(1) DEFAULT NULL COMMENT '是否是父节点：0否；1是',
  `weight` int(4) DEFAULT '0' COMMENT '权重：排序',
  `status` int(1) DEFAULT '1' COMMENT '状态：0无效；1有效',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8 COMMENT='@author 韩大发\r\n@summary 系统菜单的信息表';

-- ----------------------------
-- Records of t_sys_menus
-- ----------------------------
INSERT INTO `t_sys_menus` VALUES ('20', '角色管理', 'page/role/role.jsp', '-1', '0', '3', '1', '2013-01-07 15:02:21', '2013-01-07 15:02:21');
INSERT INTO `t_sys_menus` VALUES ('21', '组织管理', 'page/group/group.jsp', '-1', '0', '2', '1', '2013-01-07 15:03:51', '2013-01-14 14:55:59');
INSERT INTO `t_sys_menus` VALUES ('22', '菜单维护', 'page/menu/menu.jsp', '-1', '0', '1', '1', '2013-01-14 14:51:03', '2013-01-14 14:51:03');
INSERT INTO `t_sys_menus` VALUES ('23', '用户管理', 'page/user/user.jsp', '-1', '0', '4', '1', '2013-01-14 14:51:26', '2013-01-14 14:51:26');
INSERT INTO `t_sys_menus` VALUES ('24', '角色授权', 'page/role/rolemenu.jsp', '-1', '0', '5', '1', '2013-01-15 15:02:29', '2013-01-15 15:18:49');
INSERT INTO `t_sys_menus` VALUES ('25', '数据授权', 'page/user/userdata.jsp', '-1', '0', '6', '1', '2013-01-15 15:05:55', '2013-01-15 15:05:55');
INSERT INTO `t_sys_menus` VALUES ('27', '数据字典', 'page/user/userdata.jsp', '-1', '0', '7', '1', null, null);

-- ----------------------------
-- Table structure for `t_sys_menu_btns`
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_menu_btns`;
CREATE TABLE `t_sys_menu_btns` (
  `menu_id` int(11) DEFAULT NULL COMMENT '菜单编码',
  `btn_id` varchar(255) DEFAULT NULL COMMENT '按钮',
  `btn_name` varchar(255) DEFAULT NULL COMMENT '按钮备注'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_sys_menu_btns
-- ----------------------------
INSERT INTO `t_sys_menu_btns` VALUES ('20', 'ADD', '增加');
INSERT INTO `t_sys_menu_btns` VALUES ('20', 'MODIFY', '修改');
INSERT INTO `t_sys_menu_btns` VALUES ('20', 'DELETE', '删除');
INSERT INTO `t_sys_menu_btns` VALUES ('21', 'ADD', '增加');
INSERT INTO `t_sys_menu_btns` VALUES ('21', 'MODIFY', '修改');
INSERT INTO `t_sys_menu_btns` VALUES ('21', 'DELETE', '删除');
INSERT INTO `t_sys_menu_btns` VALUES ('22', 'ADD', '增加');
INSERT INTO `t_sys_menu_btns` VALUES ('22', 'MODIFY', '修改');
INSERT INTO `t_sys_menu_btns` VALUES ('22', 'DELETE', '删除');
INSERT INTO `t_sys_menu_btns` VALUES ('23', 'ADD', '增加');
INSERT INTO `t_sys_menu_btns` VALUES ('23', 'MODIFY', '修改');
INSERT INTO `t_sys_menu_btns` VALUES ('23', 'DELETE', '删除');
INSERT INTO `t_sys_menu_btns` VALUES ('23', 'PSW_RESET', '密码重置');
INSERT INTO `t_sys_menu_btns` VALUES ('24', 'AUTHORIZE', '授权');
INSERT INTO `t_sys_menu_btns` VALUES ('25', 'AUTHORIZE', '授权');

-- ----------------------------
-- Table structure for `t_sys_roles`
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_roles`;
CREATE TABLE `t_sys_roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_name` varchar(255) DEFAULT NULL COMMENT '角色名称',
  `weight` int(11) DEFAULT NULL COMMENT '排序',
  `node` varchar(255) DEFAULT NULL COMMENT '备注',
  `status` int(11) DEFAULT NULL COMMENT '有效状态',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `creater` varchar(255) DEFAULT NULL COMMENT '创建者',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `updater` varchar(255) DEFAULT NULL COMMENT '修改者',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='@author \r\n@time 2013-01-11\r\n@summary 角色表';

-- ----------------------------
-- Records of t_sys_roles
-- ----------------------------
INSERT INTO `t_sys_roles` VALUES ('1', '系统管理员', '1', '系统管理员', '1', null, null, null, null);
INSERT INTO `t_sys_roles` VALUES ('3', '科员', '3', '科员不贪污，只受贿', '1', '2013-01-14 21:29:05', '2013-01-14 21:29:05', '2013-01-14 21:48:21', '2013-01-14 21:48:21');
INSERT INTO `t_sys_roles` VALUES ('4', '处长', '4', '处长一年贪污多少', '1', '2013-01-14 21:29:50', '2013-01-14 21:29:50', '2013-01-14 21:32:12', '2013-01-14 21:32:12');
INSERT INTO `t_sys_roles` VALUES ('5', '局长', '5', '局长啊', '1', '2013-01-14 21:47:51', '2013-01-14 21:47:51', '2013-01-14 21:47:51', '2013-01-14 21:47:51');
INSERT INTO `t_sys_roles` VALUES ('6', '部长', '6', '部长', '1', '2013-01-14 21:49:05', '2013-01-14 21:49:05', '2013-01-14 21:49:05', '2013-01-14 21:49:05');
INSERT INTO `t_sys_roles` VALUES ('7', '临时工', '2', '可怜的临时工', '1', '2013-01-15 08:47:22', '2013-01-15 08:47:22', '2013-01-15 08:47:22', '2013-01-15 08:47:22');

-- ----------------------------
-- Table structure for `t_sys_role_data_groups`
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_role_data_groups`;
CREATE TABLE `t_sys_role_data_groups` (
  `role_id` int(11) DEFAULT NULL COMMENT '角色主键',
  `group_id` int(11) DEFAULT NULL COMMENT '组织主键',
  `status` int(11) DEFAULT NULL COMMENT '有效状态',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `creater` varchar(255) DEFAULT NULL COMMENT '创建者'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='@author 韩大发\r\n@summary 角色组织数据授权';

-- ----------------------------
-- Records of t_sys_role_data_groups
-- ----------------------------

-- ----------------------------
-- Table structure for `t_sys_role_data_users`
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_role_data_users`;
CREATE TABLE `t_sys_role_data_users` (
  `role_id` int(11) DEFAULT NULL COMMENT '角色主键',
  `user_id` int(11) DEFAULT NULL COMMENT '用户主键',
  `status` int(11) DEFAULT NULL COMMENT '有效状态',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `creater` varchar(255) DEFAULT NULL COMMENT '创建者'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='@author 韩大发\r\n@summary 角色组织数据授权';

-- ----------------------------
-- Records of t_sys_role_data_users
-- ----------------------------

-- ----------------------------
-- Table structure for `t_sys_role_menus`
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_role_menus`;
CREATE TABLE `t_sys_role_menus` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) DEFAULT NULL COMMENT '角色编码',
  `menu_id` int(11) DEFAULT NULL COMMENT '菜单编码',
  `btn_id` varchar(11) DEFAULT NULL COMMENT '按钮',
  `status` int(1) DEFAULT NULL COMMENT '有效状态',
  `create_time` datetime DEFAULT NULL COMMENT '建立时间',
  `creater` varchar(255) DEFAULT NULL COMMENT '建立者',
  `update_time` datetime DEFAULT NULL COMMENT '更改时间',
  `updater` varchar(255) DEFAULT NULL COMMENT '更改者',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=134 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_sys_role_menus
-- ----------------------------
INSERT INTO `t_sys_role_menus` VALUES ('77', '4', '22', '', '1', '2013-01-18 22:53:52', null, '2013-01-18 22:53:52', null);
INSERT INTO `t_sys_role_menus` VALUES ('78', '4', '22', 'ADD', '1', '2013-01-18 22:53:52', null, '2013-01-18 22:53:52', null);
INSERT INTO `t_sys_role_menus` VALUES ('79', '4', '22', 'MODIFY', '1', '2013-01-18 22:53:52', null, '2013-01-18 22:53:52', null);
INSERT INTO `t_sys_role_menus` VALUES ('80', '4', '22', 'DELETE', '1', '2013-01-18 22:53:52', null, '2013-01-18 22:53:52', null);
INSERT INTO `t_sys_role_menus` VALUES ('81', '5', '23', '', '1', '2013-01-18 22:54:21', null, '2013-01-18 22:54:21', null);
INSERT INTO `t_sys_role_menus` VALUES ('82', '5', '23', 'ADD', '1', '2013-01-18 22:54:21', null, '2013-01-18 22:54:21', null);
INSERT INTO `t_sys_role_menus` VALUES ('83', '5', '23', 'MODIFY', '1', '2013-01-18 22:54:21', null, '2013-01-18 22:54:21', null);
INSERT INTO `t_sys_role_menus` VALUES ('84', '5', '23', 'DELETE', '1', '2013-01-18 22:54:21', null, '2013-01-18 22:54:21', null);
INSERT INTO `t_sys_role_menus` VALUES ('85', '5', '23', 'PSW_RESET', '1', '2013-01-18 22:54:21', null, '2013-01-18 22:54:21', null);
INSERT INTO `t_sys_role_menus` VALUES ('86', '6', '25', '', '1', '2013-01-18 22:54:36', null, '2013-01-18 22:54:36', null);
INSERT INTO `t_sys_role_menus` VALUES ('87', '6', '20', '', '1', '2013-01-18 22:54:36', null, '2013-01-18 22:54:36', null);
INSERT INTO `t_sys_role_menus` VALUES ('88', '6', '20', 'ADD', '1', '2013-01-18 22:54:36', null, '2013-01-18 22:54:36', null);
INSERT INTO `t_sys_role_menus` VALUES ('89', '6', '20', 'MODIFY', '1', '2013-01-18 22:54:36', null, '2013-01-18 22:54:36', null);
INSERT INTO `t_sys_role_menus` VALUES ('90', '6', '20', 'DELETE', '1', '2013-01-18 22:54:36', null, '2013-01-18 22:54:36', null);
INSERT INTO `t_sys_role_menus` VALUES ('99', '1', '21', '', '1', '2013-01-19 10:44:27', null, '2013-01-19 10:44:27', null);
INSERT INTO `t_sys_role_menus` VALUES ('100', '1', '21', 'ADD', '1', '2013-01-19 10:44:27', null, '2013-01-19 10:44:27', null);
INSERT INTO `t_sys_role_menus` VALUES ('101', '1', '21', 'MODIFY', '1', '2013-01-19 10:44:27', null, '2013-01-19 10:44:27', null);
INSERT INTO `t_sys_role_menus` VALUES ('102', '1', '21', 'DELETE', '1', '2013-01-19 10:44:27', null, '2013-01-19 10:44:27', null);
INSERT INTO `t_sys_role_menus` VALUES ('103', '1', '22', '', '1', '2013-01-19 10:44:27', null, '2013-01-19 10:44:27', null);
INSERT INTO `t_sys_role_menus` VALUES ('104', '1', '22', 'ADD', '1', '2013-01-19 10:44:27', null, '2013-01-19 10:44:27', null);
INSERT INTO `t_sys_role_menus` VALUES ('105', '1', '22', 'MODIFY', '1', '2013-01-19 10:44:28', null, '2013-01-19 10:44:28', null);
INSERT INTO `t_sys_role_menus` VALUES ('106', '1', '22', 'DELETE', '1', '2013-01-19 10:44:28', null, '2013-01-19 10:44:28', null);
INSERT INTO `t_sys_role_menus` VALUES ('107', '1', '23', '', '1', '2013-01-19 10:44:28', null, '2013-01-19 10:44:28', null);
INSERT INTO `t_sys_role_menus` VALUES ('108', '1', '23', 'ADD', '1', '2013-01-19 10:44:28', null, '2013-01-19 10:44:28', null);
INSERT INTO `t_sys_role_menus` VALUES ('109', '1', '23', 'MODIFY', '1', '2013-01-19 10:44:28', null, '2013-01-19 10:44:28', null);
INSERT INTO `t_sys_role_menus` VALUES ('110', '1', '23', 'DELETE', '1', '2013-01-19 10:44:28', null, '2013-01-19 10:44:28', null);
INSERT INTO `t_sys_role_menus` VALUES ('111', '1', '23', 'PSW_RESET', '1', '2013-01-19 10:44:28', null, '2013-01-19 10:44:28', null);
INSERT INTO `t_sys_role_menus` VALUES ('112', '1', '24', '', '1', '2013-01-19 10:44:28', null, '2013-01-19 10:44:28', null);
INSERT INTO `t_sys_role_menus` VALUES ('113', '1', '24', 'AUTHORIZE', '1', '2013-01-19 10:44:28', null, '2013-01-19 10:44:28', null);
INSERT INTO `t_sys_role_menus` VALUES ('114', '1', '25', '', '1', '2013-01-19 10:44:28', null, '2013-01-19 10:44:28', null);
INSERT INTO `t_sys_role_menus` VALUES ('115', '1', '25', 'AUTHORIZE', '1', '2013-01-19 10:44:28', null, '2013-01-19 10:44:28', null);
INSERT INTO `t_sys_role_menus` VALUES ('116', '1', '20', '', '1', '2013-01-19 10:44:28', null, '2013-01-19 10:44:28', null);
INSERT INTO `t_sys_role_menus` VALUES ('117', '1', '20', 'ADD', '1', '2013-01-19 10:44:28', null, '2013-01-19 10:44:28', null);
INSERT INTO `t_sys_role_menus` VALUES ('118', '1', '20', 'MODIFY', '1', '2013-01-19 10:44:28', null, '2013-01-19 10:44:28', null);
INSERT INTO `t_sys_role_menus` VALUES ('119', '1', '20', 'DELETE', '1', '2013-01-19 10:44:28', null, '2013-01-19 10:44:28', null);
INSERT INTO `t_sys_role_menus` VALUES ('126', '3', '21', '', '1', '2013-01-19 11:08:27', null, '2013-01-19 11:08:27', null);
INSERT INTO `t_sys_role_menus` VALUES ('127', '3', '21', 'ADD', '1', '2013-01-19 11:08:27', null, '2013-01-19 11:08:27', null);
INSERT INTO `t_sys_role_menus` VALUES ('128', '3', '21', 'MODIFY', '1', '2013-01-19 11:08:27', null, '2013-01-19 11:08:27', null);
INSERT INTO `t_sys_role_menus` VALUES ('129', '3', '21', 'DELETE', '1', '2013-01-19 11:08:27', null, '2013-01-19 11:08:27', null);
INSERT INTO `t_sys_role_menus` VALUES ('130', '3', '22', '', '1', '2013-01-19 11:08:27', null, '2013-01-19 11:08:27', null);
INSERT INTO `t_sys_role_menus` VALUES ('131', '3', '22', 'MODIFY', '1', '2013-01-19 11:08:27', null, '2013-01-19 11:08:27', null);
INSERT INTO `t_sys_role_menus` VALUES ('132', '3', '23', '', '1', '2013-01-19 11:08:27', null, '2013-01-19 11:08:27', null);
INSERT INTO `t_sys_role_menus` VALUES ('133', '3', '23', 'PSW_RESET', '1', '2013-01-19 11:08:27', null, '2013-01-19 11:08:27', null);

-- ----------------------------
-- Table structure for `t_sys_users`
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_users`;
CREATE TABLE `t_sys_users` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `number` varchar(255) DEFAULT NULL COMMENT '用户编码',
  `user_name` varchar(255) DEFAULT NULL COMMENT '用户姓名',
  `login_name` varchar(255) DEFAULT NULL COMMENT '登陆账号',
  `groupId` varchar(255) DEFAULT NULL COMMENT '组织编码',
  `roleId` int(11) DEFAULT NULL COMMENT '角色编码',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `sex` varchar(255) DEFAULT NULL COMMENT '性别',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `birthday` date DEFAULT NULL COMMENT '生日',
  `degree` varchar(255) DEFAULT NULL COMMENT '学历',
  `picture` varchar(255) DEFAULT NULL COMMENT '照片',
  `mobile` varchar(255) DEFAULT NULL COMMENT '手机号码',
  `tel` varchar(255) DEFAULT NULL COMMENT '电话',
  `qq` varchar(255) DEFAULT NULL COMMENT 'qq',
  `email` varchar(255) DEFAULT NULL COMMENT '电子邮箱',
  `entry_time` date DEFAULT NULL COMMENT '入职时间',
  `note` varchar(255) DEFAULT NULL COMMENT '备注',
  `weight` int(11) DEFAULT NULL COMMENT '排序',
  `status` int(1) DEFAULT '1' COMMENT '0:无效;1:有效',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `creater` varchar(255) DEFAULT NULL COMMENT '创建者',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `updater` varchar(255) DEFAULT NULL COMMENT '修改者',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COMMENT='@author 韩大发\r\n@summary 系统用户的信息表';

-- ----------------------------
-- Records of t_sys_users
-- ----------------------------
INSERT INTO `t_sys_users` VALUES ('12', 'cs_001', '测试一', 'cs_001', '16', '0', '96e79218965eb72c92a549dd5a330112', 'boy', '23', '2013-01-01', '1003', null, '', '', '', '', '2013-01-06', '', null, '1', '2013-01-12 14:44:56', null, '2013-01-12 14:44:56', null);
INSERT INTO `t_sys_users` VALUES ('13', 'cs_002', '测试二', 'cs_002', '1', '0', '96e79218965eb72c92a549dd5a330112', 'boy', '12', '2013-01-01', '1004', null, '', '', '', '', '2013-01-04', '', null, '1', '2013-01-12 15:03:30', null, '2013-01-12 15:03:30', null);
INSERT INTO `t_sys_users` VALUES ('14', 'cs_003', 'cs003', 'cs_003', '16', '0', '96e79218965eb72c92a549dd5a330112', 'boy', '14', '2013-01-02', '1005', null, '', '', '', '', '2013-01-04', '', null, '1', '2013-01-12 15:04:56', null, '2013-01-12 15:04:56', null);
INSERT INTO `t_sys_users` VALUES ('15', 'cs_004', '测试四', 'cs_004', '21', '1', '96e79218965eb72c92a549dd5a330112', 'girl', '13', '2013-01-01', '1001', null, '', '', '', '', '2013-01-05', '', null, '1', '2013-01-12 15:06:01', null, '2013-01-12 15:06:01', null);
INSERT INTO `t_sys_users` VALUES ('16', 'cs_005', '测试5号', 'cs005', '17', '0', '96e79218965eb72c92a549dd5a330112', 'girl', '24', '2013-01-14', '1005', null, null, null, null, null, '2013-01-31', null, null, '1', '2013-01-14 14:19:50', null, '2013-01-14 14:19:50', null);

-- ----------------------------
-- Table structure for `t_sys_user_admins`
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_user_admins`;
CREATE TABLE `t_sys_user_admins` (
  `id` int(11) NOT NULL DEFAULT '0',
  `login_name` varchar(255) DEFAULT NULL COMMENT '登陆名称',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='@author 韩大发\r\n@time 2013-01-14\r\n@summary 此表保存超级管理员';

-- ----------------------------
-- Records of t_sys_user_admins
-- ----------------------------
