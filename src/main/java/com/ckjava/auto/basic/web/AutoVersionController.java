/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.ckjava.auto.basic.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.ckjava.auto.basic.entity.AutoVersion;
import com.ckjava.auto.basic.service.AutoVersionService;

/**
 * 版本管理Controller
 * @author chen_k
 * @version 2017-01-02
 */
@Controller
@RequestMapping(value = "${adminPath}/basic/autoVersion")
public class AutoVersionController extends BaseController {

	@Autowired
	private AutoVersionService autoVersionService;
	
	@ModelAttribute
	public AutoVersion get(@RequestParam(required=false) String id) {
		AutoVersion entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = autoVersionService.get(id);
		}
		if (entity == null){
			entity = new AutoVersion();
		}
		return entity;
	}
	
	@RequiresPermissions("basic:autoVersion:view")
	@RequestMapping(value = {"list", ""})
	public String list(AutoVersion autoVersion, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<AutoVersion> page = autoVersionService.findPage(new Page<AutoVersion>(request, response), autoVersion); 
		model.addAttribute("page", page);
		return "auto/basic/autoVersionList";
	}

	@RequiresPermissions("basic:autoVersion:view")
	@RequestMapping(value = "form")
	public String form(AutoVersion autoVersion, Model model) {
		model.addAttribute("autoVersion", autoVersion);
		return "auto/basic/autoVersionForm";
	}

	@RequiresPermissions("basic:autoVersion:edit")
	@RequestMapping(value = "save")
	public String save(AutoVersion autoVersion, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, autoVersion)){
			return form(autoVersion, model);
		}
		autoVersionService.save(autoVersion);
		addMessage(redirectAttributes, "保存版本成功");
		return "redirect:"+Global.getAdminPath()+"/basic/autoVersion/?repage";
	}
	
	@RequiresPermissions("basic:autoVersion:edit")
	@RequestMapping(value = "delete")
	public String delete(AutoVersion autoVersion, RedirectAttributes redirectAttributes) {
		autoVersionService.delete(autoVersion);
		addMessage(redirectAttributes, "删除版本成功");
		return "redirect:"+Global.getAdminPath()+"/basic/autoVersion/?repage";
	}

}