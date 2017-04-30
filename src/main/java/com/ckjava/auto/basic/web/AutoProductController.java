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
import com.ckjava.auto.basic.entity.AutoProduct;
import com.ckjava.auto.basic.service.AutoProductService;

/**
 * 产品信息Controller
 * @author chen_k
 * @version 2017-04-30
 */
@Controller
@RequestMapping(value = "${adminPath}/basic/autoProduct")
public class AutoProductController extends BaseController {

	@Autowired
	private AutoProductService autoProductService;
	
	@ModelAttribute
	public AutoProduct get(@RequestParam(required=false) String id) {
		AutoProduct entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = autoProductService.get(id);
		}
		if (entity == null){
			entity = new AutoProduct();
		}
		return entity;
	}
	
	@RequiresPermissions("basic:autoProduct:view")
	@RequestMapping(value = {"list", ""})
	public String list(AutoProduct autoProduct, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<AutoProduct> page = autoProductService.findPage(new Page<AutoProduct>(request, response), autoProduct); 
		model.addAttribute("page", page);
		return "auto/basic/autoProductList";
	}

	@RequiresPermissions("basic:autoProduct:view")
	@RequestMapping(value = "form")
	public String form(AutoProduct autoProduct, Model model) {
		model.addAttribute("autoProduct", autoProduct);
		return "auto/basic/autoProductForm";
	}

	@RequiresPermissions("basic:autoProduct:edit")
	@RequestMapping(value = "save")
	public String save(AutoProduct autoProduct, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, autoProduct)){
			return form(autoProduct, model);
		}
		autoProductService.save(autoProduct);
		addMessage(redirectAttributes, "保存产品成功");
		return "redirect:"+Global.getAdminPath()+"/basic/autoProduct/?repage";
	}
	
	@RequiresPermissions("basic:autoProduct:edit")
	@RequestMapping(value = "delete")
	public String delete(AutoProduct autoProduct, RedirectAttributes redirectAttributes) {
		autoProductService.delete(autoProduct);
		addMessage(redirectAttributes, "删除产品成功");
		return "redirect:"+Global.getAdminPath()+"/basic/autoProduct/?repage";
	}

}