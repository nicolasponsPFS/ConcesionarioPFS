package com.pfs.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pfs.project.model.Vendedor;

@Controller
public class LinkController {
	
	@Autowired
	private Vendedor vendedor;
	
	@RequestMapping(value="/")
	public String mainPage() {
		System.out.println(vendedor.toString());
		if(vendedor.getId() == null)
			return "redirect:/vendedor/login";
		return "redirect:/vendedor/home";
	}
	
	@RequestMapping(value="/index")
	public String indexPage() {
		return mainPage();
	}
	
}
