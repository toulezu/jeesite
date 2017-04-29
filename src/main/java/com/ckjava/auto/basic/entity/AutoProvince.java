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
public class AutoProvince extends DataEntity<AutoProvince> {
	
	private static final long serialVersionUID = 1L;
	private String pid;		// 流水号
	private String pName;		// 省份
	private String pCode;		// 省份代码
	private String pDesc;		// 省份描述
	private AutoArea aid;		// 所属区域 父类
	
	public AutoProvince() {
		super();
	}

	public AutoProvince(String id){
		super(id);
	}

	public AutoProvince(AutoArea aid){
		this.aid = aid;
	}

	@Length(min=1, max=18, message="流水号长度必须介于 1 和 18 之间")
	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}
	
	@Length(min=0, max=255, message="省份长度必须介于 0 和 255 之间")
	public String getPName() {
		return pName;
	}

	public void setPName(String pName) {
		this.pName = pName;
	}
	
	@Length(min=0, max=20, message="省份代码长度必须介于 0 和 20 之间")
	public String getPCode() {
		return pCode;
	}

	public void setPCode(String pCode) {
		this.pCode = pCode;
	}
	
	public String getPDesc() {
		return pDesc;
	}

	public void setPDesc(String pDesc) {
		this.pDesc = pDesc;
	}
	
	@Length(min=0, max=18, message="所属区域长度必须介于 0 和 18 之间")
	public AutoArea getAid() {
		return aid;
	}

	public void setAid(AutoArea aid) {
		this.aid = aid;
	}
	
}