package com.pfs.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.pfs.project.model.Vendedor;
import com.pfs.project.service.VendedorService;

@Controller
@RequestMapping(value = "/vendedor")
@CrossOrigin(origins="*", methods={RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
public class VendedorController {

	@Autowired
	private VendedorService vendedorService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public @ResponseBody String loginCheck(@RequestBody String json) {
		Vendedor vendedor = new Gson().fromJson(json, Vendedor.class);
		Vendedor v = vendedorService.getVendedorByUsername(vendedor.getUsuario());
		if (v != null) {
			if (v.getPass().equals(vendedor.getPass())) {
				return new Gson().toJson(v, Vendedor.class);
			}
			else {
				return new Gson().toJson("Pass");
			}
		}
		return new Gson().toJson("KO");
	}

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public @ResponseBody String addingVendedor(@RequestBody String json) {
		Vendedor vendedor = new Gson().fromJson(json, Vendedor.class);
		Vendedor v = vendedorService.getVendedorByUsername(vendedor.getNombre());
		if (v == null) {
			vendedorService.addVendedor(vendedor);
			return new Gson().toJson(v);
		} else {
			return new Gson().toJson("Exist");
		}
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.PUT)
	public @ResponseBody String edditingVendedor(@RequestBody String json, @PathVariable Integer id) {
		Vendedor vendedor = new Gson().fromJson(json, Vendedor.class);
		vendedorService.updateVendedor(vendedor);
		return new Gson().toJson(vendedor);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public @ResponseBody String deleteVendedor(@PathVariable Integer id) {
		Vendedor v = vendedorService.getVendedor(id);
		vendedorService.deleteVendedor(id);
		return new Gson().toJson(v);
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public @ResponseBody String logout() {
		return null;
	}

}
