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
) a WHERE a.is_show = '1' AND a.`parent.id` = '56' ;

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

