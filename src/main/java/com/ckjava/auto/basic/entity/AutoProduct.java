/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.ckjava.auto.basic.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 产品信息Entity
 * @author chen_k
 * @version 2017-01-02
 */
public class AutoProduct extends DataEntity<AutoProduct> {
	
	private static final long serialVersionUID = 1L;
	private String pid;		// 流水号
	private String pName;		// 产品名称
	private String pCode;		// 产品代码
	private String pDesc;		// 产品描述
	
	public AutoProduct() {
		super();
	}

	public AutoProduct(String id){
		super(id);
	}

	@Length(min=1, max=11, message="流水号长度必须介于 1 和 11 之间")
	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}
	
	@Length(min=0, max=200, message="产品名称长度必须介于 0 和 200 之间")
	public String getPName() {
		return pName;
	}

	public void setPName(String pName) {
		this.pName = pName;
	}
	
	@Length(min=0, max=20, message="产品代码长度必须介于 0 和 20 之间")
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
	
}