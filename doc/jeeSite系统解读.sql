-- 查询用户
SELECT * FROM sys_user WHERE id = 2;
-- 查询用户对应的菜单，src/main/webapp/WEB-INF/views/modules/sys/sysIndex.jsp 要用
SELECT * FROM (
	SELECT DISTINCT
	a.id,
	a.parent_id AS "parent.id",
	a.parent_ids,
	a.name,
	a.href,
	a.target,
	a.icon,
	a.sort,
	a.is_show,
	a.permission,
	a.remarks,
	a.create_by AS "createBy.id",
	a.create_date,
	a.update_by AS "updateBy.id",
	a.update_date,
	a.del_flag,
	p.name AS "parent.name"
	FROM sys_menu a
	LEFT JOIN sys_menu p ON p.id = a.parent_id
	JOIN sys_role_menu rm ON rm.menu_id = a.id
	JOIN sys_role r ON r.id = rm.role_id AND r.useable='1'
	JOIN sys_user_role ur ON ur.role_id = r.id
	JOIN sys_user u ON u.id = ur.user_id AND u.id = '2'
	WHERE a.del_flag = '0' AND r.del_flag = '0' AND u.del_flag = '0'
	ORDER BY a.sort
) a WHERE a.is_show = '1' AND a.`parent.id` = '40';

SELECT * FROM sys_menu WHERE `id` = 100;
SELECT * FROM sys_role_menu rm;
SELECT * FROM sys_user_role WHERE user_id = 2; 

-- ------------------添加一个四级菜单试试
INSERT INTO `sys_menu` (`id`, `parent_id`, `parent_ids`, `name`, `sort`, `href`, `target`, `icon`, `is_show`, `permission`, `create_by`, `create_date`, `update_by`, `update_date`, `remarks`, `del_flag`) VALUES('100','56','0,1,27,71,56,','测试4级菜单','91','/../static/ckfinder/ckfinder.html',NULL,'folder-open','1',NULL,'1','2013-05-27 08:00:00','1','2013-05-27 08:00:00',NULL,'0');
INSERT INTO `sys_role_menu` (`role_id`, `menu_id`) VALUES('1','100');
-- ------------------------------------
-- 获取自己的通知
SELECT 
	COUNT(1)
FROM oa_notify a
JOIN oa_notify_record r ON r.oa_notify_id = a.id AND r.user_id = '2'
			AND r.read_flag = '0'
WHERE a.del_flag = '0'
	AND a.STATUS = '1'

-- 获取cms内容管理模块的树形栏目列表
SELECT 
	a.id AS "id",
	a.parent_id AS "parent.id",
	a.parent_ids AS "parentIds",
	a.site_id AS "site.id",
	a.office_id AS "office.id",
	a.module AS "module",
	a.name AS "name",
	a.image AS "image",
	a.href AS "href",
	a.target AS "target",
	a.description AS "description",
	a.keywords AS "keywords",
	a.sort AS "sort",
	a.in_menu AS "inMenu",
	a.in_list AS "inList",
	a.show_modes AS "showModes",
	a.allow_comment AS "allowComment",
	a.is_audit AS "isAudit",
	a.custom_list_view AS "customListView",
	a.custom_content_view AS "customContentView",
	a.view_config AS "viewConfig",
	a.create_by AS "createBy.id",
	a.create_date AS "createDate",
	a.update_by AS "updateBy.id",
	a.update_date AS "updateDate",
	a.remarks AS "remarks",
	a.del_flag AS "delFlag",
	c.name AS "parent.name",
	c.view_config AS "parent.viewConfig",
	o.name AS "office.name",
	s.theme AS "site.theme"
FROM cms_category a
LEFT JOIN cms_category c ON c.id = a.parent_id
JOIN sys_office o ON o.id = a.office_id
JOIN sys_user u ON u.id = a.create_by
JOIN cms_site s ON a.site_id = s.id
WHERE
a.del_flag = '0'
-- AND a.site_id  = #{site.id}
-- AND a.parent_id  = #{parent.id}
ORDER BY a.site_id,a.sort ASC`jeesite`