/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.ckjava.auto.basic.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 版本管理Entity
 * @author chen_k
 * @version 2017-04-30
 */
public class AutoVersion extends DataEntity<AutoVersion> {
	
	private static final long serialVersionUID = 1L;
	private String versionName;		// 版本名称
	private String versionCode;		// 版本代码
	private String versionDesc;		// 描述
	private Date beginDate;		// 开始时间
	private Date endDate;		// 结束时间
	private String productId;		// 关联产品id
	
	public AutoVersion() {
		super();
	}

	public AutoVersion(String id){
		super(id);
	}

	@Length(min=0, max=200, message="版本名称长度必须介于 0 和 200 之间")
	public String getVersionName() {
		return versionName;
	}

	public void setVersionName(String versionName) {
		this.versionName = versionName;
	}
	
	@Length(min=0, max=20, message="版本代码长度必须介于 0 和 20 之间")
	public String getVersionCode() {
		return versionCode;
	}

	public void setVersionCode(String versionCode) {
		this.versionCode = versionCode;
	}
	
	@Length(min=0, max=1000, message="描述长度必须介于 0 和 1000 之间")
	public String getVersionDesc() {
		return versionDesc;
	}

	public void setVersionDesc(String versionDesc) {
		this.versionDesc = versionDesc;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	@Length(min=0, max=11, message="关联产品id长度必须介于 0 和 11 之间")
	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}
	
}