package com.pfs.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.pfs.project.model.Coche;
import com.pfs.project.model.Vendedor;
import com.pfs.project.service.CocheService;
import com.pfs.project.service.VendedorService;

@Controller
@RequestMapping(value = "/vendedor/{idVendedor}/coche")
@CrossOrigin(origins="*", methods={RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
public class VendedorCocheController {

	@Autowired
	private VendedorService vendedorService;
	
	@Autowired
	private CocheService cocheService;
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public @ResponseBody String listCochesVendedor(@PathVariable Integer idVendedor) {
		Vendedor v = vendedorService.getVendedor(idVendedor);
		List<Coche> coches = vendedorService.getCochesVendedor(v);
		return new Gson().toJson(coches);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public @ResponseBody String detailCocheVendedor(@PathVariable Integer idVendedor, @PathVariable Integer id) {
		Coche c = cocheService.getCoche(id);
		return new Gson().toJson(c);
	}
	
	@RequestMapping(value="/{id}/sell", method=RequestMethod.PUT)
	public @ResponseBody String sellCocheVendedor(@PathVariable Integer idVendedor, @PathVariable Integer id) {
		Coche c = cocheService.getCoche(id);
		Vendedor v = vendedorService.getVendedor(idVendedor);
		c.setVendedor(v);
		cocheService.updateCoche(c);
		return new Gson().toJson(c);
	}
	
	@RequestMapping(value="/{id}/refund", method=RequestMethod.PUT)
	public @ResponseBody String refundCocheVendedor(@PathVariable Integer cocheId) {
		Coche c = cocheService.getCoche(cocheId);
		Vendedor v = vendedorService.getVendedor(1);
		c.setVendedor(v);
		cocheService.updateCoche(c);
		return new Gson().toJson(c);
	}
}
