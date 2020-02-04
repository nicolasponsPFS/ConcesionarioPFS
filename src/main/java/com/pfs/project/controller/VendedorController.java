package com.pfs.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pfs.project.model.Vendedor;
import com.pfs.project.service.VendedorService;
import com.pfs.project.service.interfaces.VendedorServiceInterface;

@Controller
@RequestMapping(value="/vendedor")
public class VendedorController {

	@Autowired
	private VendedorServiceInterface vendedorService;
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public ModelAndView addVendedorPage() {
		ModelAndView modelAndView = new ModelAndView("add-vendedor-form");
		modelAndView.addObject("vendedor", new Vendedor());
		return modelAndView;
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public ModelAndView addingVendedor(@ModelAttribute Vendedor vendedor) {
		
		ModelAndView modelAndView = new ModelAndView("home");
		vendedorService.addVendedor(vendedor);
		
		String message = "Vendedor was successfully added.";
		modelAndView.addObject("message", message);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/list")
	public ModelAndView listOfVendedor() {
		ModelAndView modelAndView = new ModelAndView("list-of-vendedores");
		
		List<Vendedor> vendedores = vendedorService.getVendedores();
		modelAndView.addObject("vendedores", vendedores);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public ModelAndView editVendedorPage(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("edit-vendedor-form");
		Vendedor vendedor = vendedorService.getVendedor(id);
		modelAndView.addObject("vendedor",vendedor);
		return modelAndView;
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.POST)
	public ModelAndView edditingVendedor(@ModelAttribute Vendedor vendedor, @PathVariable Integer id) {
		
		ModelAndView modelAndView = new ModelAndView("home");
		
		vendedorService.updateVendedor(vendedor);
		
		String message = "Vendedor was successfully edited.";
		modelAndView.addObject("message", message);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public ModelAndView deleteVendedor(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("home");
		vendedorService.deleteVendedor(id);
		String message = "Vendedor was successfully deleted.";
		modelAndView.addObject("message", message);
		return modelAndView;
	}
	
	
}
