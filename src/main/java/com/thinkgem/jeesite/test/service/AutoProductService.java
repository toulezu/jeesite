/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.test.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.test.entity.AutoProduct;
import com.thinkgem.jeesite.test.dao.AutoProductDao;

/**
 * 产品信息Service
 * @author chen_k
 * @version 2017-01-01
 */
@Service
@Transactional(readOnly = true)
public class AutoProductService extends CrudService<AutoProductDao, AutoProduct> {

	public AutoProduct get(String id) {
		return super.get(id);
	}
	
	public List<AutoProduct> findList(AutoProduct autoProduct) {
		return super.findList(autoProduct);
	}
	
	public Page<AutoProduct> findPage(Page<AutoProduct> page, AutoProduct autoProduct) {
		return super.findPage(page, autoProduct);
	}
	
	@Transactional(readOnly = false)
	public void save(AutoProduct autoProduct) {
		super.save(autoProduct);
	}
	
	@Transactional(readOnly = false)
	public void delete(AutoProduct autoProduct) {
		super.delete(autoProduct);
	}
	
}