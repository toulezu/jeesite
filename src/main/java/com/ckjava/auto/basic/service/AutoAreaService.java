/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.ckjava.auto.basic.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.ckjava.auto.basic.entity.AutoArea;
import com.ckjava.auto.basic.dao.AutoAreaDao;

/**
 * 区域管理Service
 * @author chen_k
 * @version 2017-04-30
 */
@Service
@Transactional(readOnly = true)
public class AutoAreaService extends CrudService<AutoAreaDao, AutoArea> {

	public AutoArea get(String id) {
		return super.get(id);
	}
	
	public List<AutoArea> findList(AutoArea autoArea) {
		return super.findList(autoArea);
	}
	
	public Page<AutoArea> findPage(Page<AutoArea> page, AutoArea autoArea) {
		return super.findPage(page, autoArea);
	}
	
	@Transactional(readOnly = false)
	public void save(AutoArea autoArea) {
		super.save(autoArea);
	}
	
	@Transactional(readOnly = false)
	public void delete(AutoArea autoArea) {
		super.delete(autoArea);
	}
	
}