/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.ckjava.auto.basic.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.ckjava.auto.basic.entity.AutoProvince;
import com.ckjava.auto.basic.dao.AutoProvinceDao;

/**
 * 省份管理Service
 * @author chen_k
 * @version 2017-01-02
 */
@Service
@Transactional(readOnly = true)
public class AutoProvinceService extends CrudService<AutoProvinceDao, AutoProvince> {

	public AutoProvince get(String id) {
		return super.get(id);
	}
	
	public List<AutoProvince> findList(AutoProvince autoProvince) {
		return super.findList(autoProvince);
	}
	
	public Page<AutoProvince> findPage(Page<AutoProvince> page, AutoProvince autoProvince) {
		return super.findPage(page, autoProvince);
	}
	
	@Transactional(readOnly = false)
	public void save(AutoProvince autoProvince) {
		super.save(autoProvince);
	}
	
	@Transactional(readOnly = false)
	public void delete(AutoProvince autoProvince) {
		super.delete(autoProvince);
	}
	
}