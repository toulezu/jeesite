/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.test.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.test.entity.AutoProduct;

/**
 * 产品信息DAO接口
 * @author chen_k
 * @version 2017-01-01
 */
@MyBatisDao
public interface AutoProductDao extends CrudDao<AutoProduct> {
	
}