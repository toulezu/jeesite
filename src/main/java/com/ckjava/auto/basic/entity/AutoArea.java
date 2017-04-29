/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.ckjava.auto.basic.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 区域管理Entity
 * @author chen_k
 * @version 2017-01-02
 */
public class AutoArea extends DataEntity<AutoArea> {
	
	private static final long serialVersionUID = 1L;
	private String aid;		// 流水号
	private String areaName;		// 区域名称
	private String areaCode;		// 区域代码
	private String areaDesc;		// 区域描述
	
	public AutoArea() {
		super();
	}

	public AutoArea(String id){
		super(id);
	}

	@Length(min=1, max=18, message="流水号长度必须介于 1 和 18 之间")
	public String getAid() {
		return aid;
	}

	public void setAid(String aid) {
		this.aid = aid;
	}
	
	@Length(min=0, max=255, message="区域名称长度必须介于 0 和 255 之间")
	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	
	@Length(min=0, max=50, message="区域代码长度必须介于 0 和 50 之间")
	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	
	public String getAreaDesc() {
		return areaDesc;
	}

	public void setAreaDesc(String areaDesc) {
		this.areaDesc = areaDesc;
	}
	
}