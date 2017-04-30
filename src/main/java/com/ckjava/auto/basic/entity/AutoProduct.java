/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.ckjava.auto.basic.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 产品信息Entity
 * @author chen_k
 * @version 2017-04-30
 */
public class AutoProduct extends DataEntity<AutoProduct> {
	
	private static final long serialVersionUID = 1L;
	private String productName;		// 产品名称
	private String productCode;		// 产品代码
	private String productDesc;		// 产品描述
	
	public AutoProduct() {
		super();
	}

	public AutoProduct(String id){
		super(id);
	}

	@Length(min=0, max=200, message="产品名称长度必须介于 0 和 200 之间")
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	@Length(min=0, max=20, message="产品代码长度必须介于 0 和 20 之间")
	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	
	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}
	
}