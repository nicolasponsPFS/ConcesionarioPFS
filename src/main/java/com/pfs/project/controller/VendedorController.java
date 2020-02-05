package com.pfs.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pfs.project.model.Vendedor;
import com.pfs.project.service.interfaces.VendedorServiceInterface;

@Controller
@RequestMapping(value = "/vendedor")
public class VendedorController {

	@Autowired
	private VendedorServiceInterface vendedorService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView loginPage() {
		ModelAndView modelAndView = new ModelAndView("login-page");
		modelAndView.addObject("vendedor", new Vendedor());
		return modelAndView;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView loginCheck(@ModelAttribute Vendedor vendedor) {
		Vendedor v = vendedorService.getVendedorByUsername(vendedor.getUsuario());
		ModelAndView modelAndView = new ModelAndView("error-page");
		System.out.println(v.print());
		if (v != null) {
			if (v.getPass().equals(vendedor.getPass())) {
				modelAndView = new ModelAndView("home-page");
				modelAndView.addObject("nombre", v.getNombre());
			}
			else {
				modelAndView.addObject("err", "Contraseña no valida");
			}
		} else {
			modelAndView.addObject("err", "Usuario no valido");
		}
			
		return modelAndView;
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView homePage() {
		ModelAndView modelAndView = new ModelAndView("home-page");
		return modelAndView;
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public ModelAndView signupPage() {
		ModelAndView modelAndView = new ModelAndView("signup-form");
		return modelAndView;
	}

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public ModelAndView addingVendedor(@ModelAttribute Vendedor vendedor) {
		Vendedor v = vendedorService.getVendedorByUsername(vendedor.getNombre());
		ModelAndView modelAndView = new ModelAndView("error-page");
		if (v == null) {
			vendedorService.addVendedor(vendedor);
			modelAndView = new ModelAndView("login-page");
		} else {
			modelAndView.addObject("err", "El usuario "+vendedor.getUsuario()+" ya existe");
		}
		return modelAndView;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editVendedorPage(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("edit-vendedor-form");
		Vendedor vendedor = vendedorService.getVendedor(id);
		modelAndView.addObject("vendedor", vendedor);
		return modelAndView;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public ModelAndView edditingVendedor(@ModelAttribute Vendedor vendedor, @PathVariable Integer id) {

		ModelAndView modelAndView = new ModelAndView("home-page");

		vendedorService.updateVendedor(vendedor);
		return modelAndView;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteVendedor(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("login-page");
		vendedorService.deleteVendedor(id);
		return modelAndView;
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logout() {
		ModelAndView modelAndView = new ModelAndView("login-page");
		return modelAndView;
	}

}
