/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.ckjava.auto.basic.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.ckjava.auto.basic.entity.AutoVersion;
import com.ckjava.auto.basic.dao.AutoVersionDao;

/**
 * 版本管理Service
 * @author chen_k
 * @version 2017-04-30
 */
@Service
@Transactional(readOnly = true)
public class AutoVersionService extends CrudService<AutoVersionDao, AutoVersion> {

	public AutoVersion get(String id) {
		return super.get(id);
	}
	
	public List<AutoVersion> findList(AutoVersion autoVersion) {
		return super.findList(autoVersion);
	}
	
	public Page<AutoVersion> findPage(Page<AutoVersion> page, AutoVersion autoVersion) {
		return super.findPage(page, autoVersion);
	}
	
	@Transactional(readOnly = false)
	public void save(AutoVersion autoVersion) {
		super.save(autoVersion);
	}
	
	@Transactional(readOnly = false)
	public void delete(AutoVersion autoVersion) {
		super.delete(autoVersion);
	}
	
}