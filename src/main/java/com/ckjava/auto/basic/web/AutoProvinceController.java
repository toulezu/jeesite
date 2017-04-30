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
import com.ckjava.auto.basic.entity.AutoProvince;
import com.ckjava.auto.basic.service.AutoProvinceService;

/**
 * 省份管理Controller
 * @author chen_k
 * @version 2017-04-30
 */
@Controller
@RequestMapping(value = "${adminPath}/basic/autoProvince")
public class AutoProvinceController extends BaseController {

	@Autowired
	private AutoProvinceService autoProvinceService;
	
	@ModelAttribute
	public AutoProvince get(@RequestParam(required=false) String id) {
		AutoProvince entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = autoProvinceService.get(id);
		}
		if (entity == null){
			entity = new AutoProvince();
		}
		return entity;
	}
	
	@RequiresPermissions("basic:autoProvince:view")
	@RequestMapping(value = {"list", ""})
	public String list(AutoProvince autoProvince, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<AutoProvince> page = autoProvinceService.findPage(new Page<AutoProvince>(request, response), autoProvince); 
		model.addAttribute("page", page);
		return "auto/basic/autoProvinceList";
	}

	@RequiresPermissions("basic:autoProvince:view")
	@RequestMapping(value = "form")
	public String form(AutoProvince autoProvince, Model model) {
		model.addAttribute("autoProvince", autoProvince);
		return "auto/basic/autoProvinceForm";
	}

	@RequiresPermissions("basic:autoProvince:edit")
	@RequestMapping(value = "save")
	public String save(AutoProvince autoProvince, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, autoProvince)){
			return form(autoProvince, model);
		}
		autoProvinceService.save(autoProvince);
		addMessage(redirectAttributes, "保存省份成功");
		return "redirect:"+Global.getAdminPath()+"/basic/autoProvince/?repage";
	}
	
	@RequiresPermissions("basic:autoProvince:edit")
	@RequestMapping(value = "delete")
	public String delete(AutoProvince autoProvince, RedirectAttributes redirectAttributes) {
		autoProvinceService.delete(autoProvince);
		addMessage(redirectAttributes, "删除省份成功");
		return "redirect:"+Global.getAdminPath()+"/basic/autoProvince/?repage";
	}

}