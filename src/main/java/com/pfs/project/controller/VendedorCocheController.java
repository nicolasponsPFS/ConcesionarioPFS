package com.pfs.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pfs.project.model.Coche;
import com.pfs.project.model.Vendedor;
import com.pfs.project.service.interfaces.CocheServiceInterface;
import com.pfs.project.service.interfaces.VendedorServiceInterface;

@Controller
@RequestMapping(value = "/vendedor/coche")
public class VendedorCocheController {

	@Autowired
	private VendedorServiceInterface vendedorService;
	
	@Autowired
	private CocheServiceInterface cocheService;
	
	@Autowired
	private Vendedor vendedor;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView listCochesVendedor() {
		ModelAndView modelAndView = new ModelAndView("list-coche");
		List<Coche> coches = vendedorService.getCochesVendedor(this.vendedor.getId());
		//TODO tratar coches
		return modelAndView;
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ModelAndView detailCocheVendedor(@PathVariable Integer cocheId) {
		ModelAndView modelAndView = new ModelAndView("coche-page");
		Coche c = cocheService.getCoche(cocheId);
		//TODO tratar coche
		return modelAndView;
	}
	
	@RequestMapping(value="/{id}/sell", method=RequestMethod.PUT)
	public ModelAndView sellCocheVendedor(@PathVariable Integer cocheId) {
		ModelAndView modelAndView = new ModelAndView("coche-page");
		Coche c = cocheService.getCoche(cocheId);
		c.setIdVendedor(vendedor);
		cocheService.updateCoche(c);
		//TODO Mostrar alerta
		System.out.println(c.toString());
		return modelAndView;
	}
	
	@RequestMapping(value="/{id}/refund", method=RequestMethod.PUT)
	public ModelAndView refundCocheVendedor(@PathVariable Integer cocheId) {
		ModelAndView modelAndView = new ModelAndView("coche-page");
		Coche c = cocheService.getCoche(cocheId);
		Vendedor v = vendedorService.getVendedor(1);
		c.setIdVendedor(v);
		cocheService.updateCoche(c);
		//TODO Mostrar alerta
		System.out.println(c.toString());
		return modelAndView;
	}
}
