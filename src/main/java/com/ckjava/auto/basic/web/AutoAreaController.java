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
import com.ckjava.auto.basic.entity.AutoArea;
import com.ckjava.auto.basic.service.AutoAreaService;

/**
 * 区域管理Controller
 * @author chen_k
 * @version 2017-01-02
 */
@Controller
@RequestMapping(value = "${adminPath}/basic/autoArea")
public class AutoAreaController extends BaseController {

	@Autowired
	private AutoAreaService autoAreaService;
	
	@ModelAttribute
	public AutoArea get(@RequestParam(required=false) String id) {
		AutoArea entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = autoAreaService.get(id);
		}
		if (entity == null){
			entity = new AutoArea();
		}
		return entity;
	}
	
	@RequiresPermissions("basic:autoArea:view")
	@RequestMapping(value = {"list", ""})
	public String list(AutoArea autoArea, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<AutoArea> page = autoAreaService.findPage(new Page<AutoArea>(request, response), autoArea); 
		model.addAttribute("page", page);
		return "auto/basic/autoAreaList";
	}

	@RequiresPermissions("basic:autoArea:view")
	@RequestMapping(value = "form")
	public String form(AutoArea autoArea, Model model) {
		model.addAttribute("autoArea", autoArea);
		return "auto/basic/autoAreaForm";
	}

	@RequiresPermissions("basic:autoArea:edit")
	@RequestMapping(value = "save")
	public String save(AutoArea autoArea, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, autoArea)){
			return form(autoArea, model);
		}
		autoAreaService.save(autoArea);
		addMessage(redirectAttributes, "保存区域成功");
		return "redirect:"+Global.getAdminPath()+"/basic/autoArea/?repage";
	}
	
	@RequiresPermissions("basic:autoArea:edit")
	@RequestMapping(value = "delete")
	public String delete(AutoArea autoArea, RedirectAttributes redirectAttributes) {
		autoAreaService.delete(autoArea);
		addMessage(redirectAttributes, "删除区域成功");
		return "redirect:"+Global.getAdminPath()+"/basic/autoArea/?repage";
	}

}