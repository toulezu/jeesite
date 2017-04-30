/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.ckjava.auto.basic.entity;

import org.hibernate.validator.constraints.Length;
import com.thinkgem.jeesite.modules.sys.entity.Area;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 省份管理Entity
 * @author chen_k
 * @version 2017-04-30
 */
public class AutoProvince extends DataEntity<AutoProvince> {
	
	private static final long serialVersionUID = 1L;
	private String provinceName;		// 省份
	private String provinceCode;		// 省份代码
	private String provinceDesc;		// 省份描述
	private Area area;		// 所属区域
	
	public AutoProvince() {
		super();
	}

	public AutoProvince(String id){
		super(id);
	}

	@Length(min=0, max=255, message="省份长度必须介于 0 和 255 之间")
	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}
	
	@Length(min=0, max=20, message="省份代码长度必须介于 0 和 20 之间")
	public String getProvinceCode() {
		return provinceCode;
	}

	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}
	
	public String getProvinceDesc() {
		return provinceDesc;
	}

	public void setProvinceDesc(String provinceDesc) {
		this.provinceDesc = provinceDesc;
	}
	
	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}
	
}