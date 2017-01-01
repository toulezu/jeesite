/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.test.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 产品信息Entity
 * @author chen_k
 * @version 2017-01-01
 */
public class AutoProduct extends DataEntity<AutoProduct> {
	
	private static final long serialVersionUID = 1L;
	private String pid;		// 流水号
	private String pname;		// 产品名称
	private String pcode;		// 产品代码
	private String pdesc;		// 产品描述
	
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
	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}
	
	@Length(min=0, max=20, message="产品代码长度必须介于 0 和 20 之间")
	public String getPcode() {
		return pcode;
	}

	public void setPcode(String pcode) {
		this.pcode = pcode;
	}
	
	public String getPdesc() {
		return pdesc;
	}

	public void setPdesc(String pdesc) {
		this.pdesc = pdesc;
	}
	
}