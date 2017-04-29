/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.ckjava.auto.basic.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 产品信息Entity
 * @author chen_k
 * @version 2017-01-02
 */
public class AutoVersion extends DataEntity<AutoVersion> {
	
	private static final long serialVersionUID = 1L;
	private String vid;		// 流水号
	private String vName;		// 版本名称
	private String vCode;		// 版本代码
	private String vDesc;		// 描述
	private Date beginDate;		// 开始时间
	private Date endDate;		// 结束时间
	private AutoProduct pid;		// 关联产品id 父类
	
	public AutoVersion() {
		super();
	}

	public AutoVersion(String id){
		super(id);
	}

	public AutoVersion(AutoProduct pid){
		this.pid = pid;
	}

	@Length(min=1, max=11, message="流水号长度必须介于 1 和 11 之间")
	public String getVid() {
		return vid;
	}

	public void setVid(String vid) {
		this.vid = vid;
	}
	
	@Length(min=0, max=200, message="版本名称长度必须介于 0 和 200 之间")
	public String getVName() {
		return vName;
	}

	public void setVName(String vName) {
		this.vName = vName;
	}
	
	@Length(min=0, max=20, message="版本代码长度必须介于 0 和 20 之间")
	public String getVCode() {
		return vCode;
	}

	public void setVCode(String vCode) {
		this.vCode = vCode;
	}
	
	@Length(min=0, max=1000, message="描述长度必须介于 0 和 1000 之间")
	public String getVDesc() {
		return vDesc;
	}

	public void setVDesc(String vDesc) {
		this.vDesc = vDesc;
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
	public AutoProduct getPid() {
		return pid;
	}

	public void setPid(AutoProduct pid) {
		this.pid = pid;
	}
	
}