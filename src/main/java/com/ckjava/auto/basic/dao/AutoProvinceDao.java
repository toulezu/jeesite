/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.ckjava.auto.basic.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.ckjava.auto.basic.entity.AutoProvince;

/**
 * 省份管理DAO接口
 * @author chen_k
 * @version 2017-04-30
 */
@MyBatisDao
public interface AutoProvinceDao extends CrudDao<AutoProvince> {
	
}