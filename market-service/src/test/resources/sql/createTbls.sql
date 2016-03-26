# ************************************************************
# Sequel Pro SQL dump
# Version 4096
#
# http://www.sequelpro.com/
# http://code.google.com/p/sequel-pro/
#
# Host: 172.16.120.111 (MySQL 5.5.34-0ubuntu0.13.04.1)
# Database: mubs
# Generation Time: 2014-11-19 04:47:31 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table mubs_data_model
# ------------------------------------------------------------

CREATE TABLE `mubs_data_model` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `creator` int(11) NOT NULL COMMENT '创建人',
  `createDate` bigint(11) NOT NULL COMMENT '创建时间',
  `lastModifier` int(11) NOT NULL COMMENT '修改人',
  `lastModDate` bigint(11) NOT NULL COMMENT '修改时间',
  `status` tinyint(4) NOT NULL COMMENT '状态',
  `priority` int(11) NOT NULL DEFAULT '1000' COMMENT '优先级',
  `modelId` int(11) NOT NULL COMMENT '其对应的模型主体id',
  `assignUrl` varchar(32) NOT NULL DEFAULT '' COMMENT '分配的url',
  `whereSql` varchar(512) NOT NULL DEFAULT '' COMMENT '追加数据权限的sql',
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '按**维度设置',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='数据权限模型|数据权限设置|基础管理|CreateBaseDomain\n数据权限model';



# Dump of table mubs_datagroup
# ------------------------------------------------------------

CREATE TABLE `mubs_datagroup` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(16) NOT NULL DEFAULT '' COMMENT '名称',
  `number` varchar(16) NOT NULL DEFAULT '' COMMENT '编码',
  `description` varchar(64) NOT NULL DEFAULT '' COMMENT '描述',
  `status` tinyint(4) NOT NULL COMMENT '状态',
  `creator` int(11) NOT NULL COMMENT '创建人',
  `createDate` bigint(11) NOT NULL COMMENT '创建时间',
  `lastModifier` int(11) NOT NULL COMMENT '修改人',
  `lastModDate` bigint(11) NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='数据组|数据组管理|基础管理|CreateBaseDomain\n数据组';



# Dump of table mubs_datagroup_data
# ------------------------------------------------------------

CREATE TABLE `mubs_datagroup_data` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `creator` int(11) NOT NULL COMMENT '创建人',
  `createDate` bigint(11) NOT NULL COMMENT '创建时间',
  `lastModifier` int(11) NOT NULL COMMENT '修改人',
  `lastModDate` bigint(11) NOT NULL COMMENT '修改时间',
  `status` tinyint(4) NOT NULL COMMENT '状态',
  `dataModelId` int(11) NOT NULL COMMENT '数据权限model id',
  `dataId` int(11) NOT NULL COMMENT '对应id',
  `groupId` int(11) NOT NULL COMMENT '数据组id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='数据组数据|数据组分配|基础管理|CreateBaseDomain\n数据组数据，数据组和数据的对应关系';



# Dump of table mubs_model
# ------------------------------------------------------------

CREATE TABLE `mubs_model` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `creator` int(11) NOT NULL COMMENT '创建人',
  `createDate` bigint(11) NOT NULL COMMENT '创建时间',
  `lastModifier` int(11) NOT NULL COMMENT '修改人',
  `lastModDate` bigint(11) NOT NULL COMMENT '修改时间',
  `status` tinyint(4) NOT NULL COMMENT '状态',
  `name` varchar(16) NOT NULL DEFAULT '' COMMENT '名称',
  `tblName` varchar(32) DEFAULT NULL COMMENT '对应表名',
  `description` varchar(64) NOT NULL DEFAULT '' COMMENT '描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='业务模型|业务模型|基础管理|CreateBaseDomain\n业务模型(人员、薪酬等)';

LOCK TABLES `mubs_model` WRITE;
/*!40000 ALTER TABLE `mubs_model` DISABLE KEYS */;


/*!40000 ALTER TABLE `mubs_model` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table mubs_resource
# ------------------------------------------------------------

CREATE TABLE `mubs_resource` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `url` varchar(256) NOT NULL DEFAULT '' COMMENT '页面url',
  `orderNum` int(11) NOT NULL DEFAULT '0' COMMENT '顺序',
  `parentId` int(11) DEFAULT NULL COMMENT '父页面,null为顶层页面',
  `number` varchar(32) NOT NULL DEFAULT '' COMMENT '编码',
  `longNumber` varchar(128) NOT NULL DEFAULT '' COMMENT '长编码',
  `name` varchar(16) NOT NULL DEFAULT '' COMMENT '资源名称',
  `creator` int(11) NOT NULL COMMENT '创建人',
  `createDate` bigint(11) NOT NULL COMMENT '创建时间',
  `lastModifier` int(11) NOT NULL COMMENT '修改人',
  `lastModDate` bigint(11) NOT NULL COMMENT '修改时间',
  `description` varchar(256) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '描述',
  `modelId` int(11) DEFAULT NULL COMMENT '主模型id  和 数据权限相关',
  `bizModelName` varchar(16) NOT NULL DEFAULT '' COMMENT '业务模型名称|在同一个业务系统里不允许有同名的业务模型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='资源|资源管理|基础管理|CreateBaseDomain\n资源，一般为页面';

LOCK TABLES `mubs_resource` WRITE;
/*!40000 ALTER TABLE `mubs_resource` DISABLE KEYS */;


/*!40000 ALTER TABLE `mubs_resource` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table mubs_resource_action
# ------------------------------------------------------------

CREATE TABLE `mubs_resource_action` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `resourceId` int(11) NOT NULL COMMENT '所属资源id',
  `divId` varchar(11) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '页面元素id',
  `actionScript` varchar(512) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '按钮对应的操作脚本',
  `name` varchar(16) NOT NULL DEFAULT '' COMMENT '操作名称',
  `actionAlias` varchar(16) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '操作标识',
  `creator` int(11) NOT NULL COMMENT '创建人',
  `createDate` bigint(11) NOT NULL COMMENT '创建时间',
  `lastModifier` int(11) NOT NULL COMMENT '修改人',
  `lastModDate` bigint(11) NOT NULL COMMENT '修改时间',
  `description` varchar(256) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '' COMMENT '描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='资源操作|资源管理|基础管理|CreateBaseDomain\n页面对应的操作';

LOCK TABLES `mubs_resource_action` WRITE;
/*!40000 ALTER TABLE `mubs_resource_action` DISABLE KEYS */;

/*!40000 ALTER TABLE `mubs_resource_action` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table mubs_resource_grid
# ------------------------------------------------------------

CREATE TABLE `mubs_resource_grid` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `creator` int(11) NOT NULL COMMENT '创建人',
  `createDate` bigint(11) NOT NULL COMMENT '创建时间',
  `lastModifier` int(11) NOT NULL COMMENT '修改人',
  `lastModDate` bigint(11) NOT NULL COMMENT '修改时间',
  `status` tinyint(4) NOT NULL COMMENT '状态',
  `resId` int(11) NOT NULL COMMENT '资源id',
  `displayName` varchar(32) NOT NULL DEFAULT '' COMMENT ' 显示名称',
  `colId` varchar(32) NOT NULL DEFAULT '' COMMENT 'grid列id',
  `orderNum` int(11) NOT NULL COMMENT '顺序号',
  `width` int(11) NOT NULL COMMENT '显示的宽度',
  `edittype` varchar(16) DEFAULT '' COMMENT '编辑器类型',
  `editable` varchar(8) NOT NULL DEFAULT 'true' COMMENT '是否可编辑|false,编辑页面不显示',
  `editoptions` varchar(256) NOT NULL DEFAULT '{}' COMMENT 'json',
  `editrules` varchar(256) NOT NULL DEFAULT '{}' COMMENT '校验规则|提交到服务器前的有效性校验',
  `formatter` varchar(32) DEFAULT '""' COMMENT '格式化函数',
  `formatoptions` varchar(256) DEFAULT '{}' COMMENT '格式化参数json',
  `unformat` varchar(16) DEFAULT NULL COMMENT '扩展编辑器',
  `hide` tinyint(4) DEFAULT '0' COMMENT '隐藏|1列表和编辑页面都不显示',
  `unedit` tinyint(4) DEFAULT '0' COMMENT '不可编辑|编辑页面不可编辑，但在表格和编辑页面显示',
  `description` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '描述',
  `moduleName` varchar(45) DEFAULT NULL COMMENT '模块名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='资源grid|资源grid管理|基础管理|CreateBaseDomain\n页面 grid的元数据描述';

LOCK TABLES `mubs_resource_grid` WRITE;
/*!40000 ALTER TABLE `mubs_resource_grid` DISABLE KEYS */;


/*!40000 ALTER TABLE `mubs_resource_grid` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table mubs_role
# ------------------------------------------------------------

CREATE TABLE `mubs_role` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(32) NOT NULL DEFAULT '' COMMENT '角色名称',
  `creator` int(11) NOT NULL COMMENT '创建人',
  `createDate` bigint(11) NOT NULL COMMENT '创建时间',
  `lastModifier` int(11) NOT NULL COMMENT '修改人',
  `lastModDate` bigint(11) NOT NULL COMMENT '修改时间',
  `description` varchar(256) NOT NULL DEFAULT '' COMMENT '描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色|角色管理|基础管理|CreateBaseDomain\n角色';

LOCK TABLES `mubs_role` WRITE;
/*!40000 ALTER TABLE `mubs_role` DISABLE KEYS */;


/*!40000 ALTER TABLE `mubs_role` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table mubs_role_resource
# ------------------------------------------------------------

CREATE TABLE `mubs_role_resource` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `creator` int(11) NOT NULL COMMENT '创建人',
  `createDate` bigint(11) NOT NULL COMMENT '创建时间',
  `lastModifier` int(11) NOT NULL COMMENT '修改人',
  `lastModDate` bigint(11) NOT NULL COMMENT '修改时间',
  `status` tinyint(4) NOT NULL COMMENT '状态',
  `resourceId` int(11) NOT NULL COMMENT '资源id',
  `resourceActionId` int(11) NOT NULL COMMENT '功能按钮id',
  `roleId` int(11) NOT NULL COMMENT '角色id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色资源|角色资源分配|基础管理|CreateBaseDomain\n角色所管辖的页面资源';

LOCK TABLES `mubs_role_resource` WRITE;
/*!40000 ALTER TABLE `mubs_role_resource` DISABLE KEYS */;



/*!40000 ALTER TABLE `mubs_role_resource` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table mubs_role_user
# ------------------------------------------------------------

CREATE TABLE `mubs_role_user` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `creator` int(11) NOT NULL COMMENT '创建人',
  `createDate` bigint(11) NOT NULL COMMENT '创建时间',
  `lastModifier` int(11) NOT NULL COMMENT '修改人',
  `lastModDate` bigint(11) NOT NULL COMMENT '修改时间',
  `status` tinyint(4) NOT NULL COMMENT '状态',
  `userId` int(11) NOT NULL COMMENT '用户id',
  `roleId` int(11) NOT NULL COMMENT '角色id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色|用户角色分配|基础管理|CreateBaseDomain\n用户对应的角色';

LOCK TABLES `mubs_role_user` WRITE;
/*!40000 ALTER TABLE `mubs_role_user` DISABLE KEYS */;


/*!40000 ALTER TABLE `mubs_role_user` ENABLE KEYS */;
UNLOCK TABLES;




# Dump of table mubs_user_datagroup
# ------------------------------------------------------------

CREATE TABLE `mubs_user_datagroup` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `creator` int(11) NOT NULL COMMENT '创建人',
  `createDate` bigint(11) NOT NULL COMMENT '创建时间',
  `lastModifier` int(11) NOT NULL COMMENT '修改人',
  `lastModDate` bigint(11) NOT NULL COMMENT '修改时间',
  `status` tinyint(4) NOT NULL COMMENT '状态',
  `datagroupId` int(11) NOT NULL COMMENT '数据组id',
  `userId` int(11) NOT NULL COMMENT '用户id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户数据组|用户数据组分配|基础管理|CreateBaseDomain\n用户和数据组对应关系';




/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
