## 模板

CREATE TABLE `***_***` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `status` tinyint(4) NOT NULL COMMENT '状态',
  `creator` int(11) NOT NULL COMMENT '创建人',
  `createDate` bigint(20) NOT NULL COMMENT '创建时间',
  `lastModifier` int(11) NOT NULL COMMENT '修改人',
  `lastModDate` bigint(20) NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户|用户管理|基础管理|CreateBaseDomain\n用户';

