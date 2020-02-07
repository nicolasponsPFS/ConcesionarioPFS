package com.pfs.project.controller;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pfs.project.model.Coche;
import com.pfs.project.model.Vendedor;
import com.pfs.project.service.interfaces.CocheServiceInterface;
import com.pfs.project.service.interfaces.VendedorServiceInterface;
import com.pfs.project.util.CustomResponse;

@Controller
@RequestMapping(value = "/vendedor/{idVendedor}/coche")
public class VendedorCocheController {

	@Autowired
	private VendedorServiceInterface vendedorService;
	
	@Autowired
	private CocheServiceInterface cocheService;
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public @ResponseBody CustomResponse listCochesVendedor(@PathVariable Integer idVendedor) {
		CustomResponse response = new CustomResponse();
		Vendedor v = vendedorService.getVendedor(idVendedor);
		List<Coche> coches = vendedorService.getCochesVendedor(v);
		response.setMsg("Coches del vendedor "+ v.getUsuario());
		JSONObject array = new JSONObject();
		array.put("coches", coches);
		response.setBody(array);
		return null;
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public @ResponseBody CustomResponse detailCocheVendedor(@PathVariable Integer idVendedor, @PathVariable Integer id) {
		CustomResponse response = new CustomResponse();
		Coche c = cocheService.getCoche(id);
		response.setMsg("Correcto");
		response.setBody(c.toJSON());
		return response;
	}
	
	@RequestMapping(value="/{id}/sell", method=RequestMethod.PUT)
	public @ResponseBody CustomResponse sellCocheVendedor(@PathVariable Integer idVendedor, @PathVariable Integer id) {
		CustomResponse response = new CustomResponse();
		Coche c = cocheService.getCoche(id);
		Vendedor v = vendedorService.getVendedor(idVendedor);
		c.setVendedor(v);
		cocheService.updateCoche(c);
		response.setMsg("Coche "+c.getMatricula()+" añadido al vendedor "+v.getUsuario());
		response.setBody(c.toJSON());
		return response;
	}
	
	@RequestMapping(value="/{id}/refund", method=RequestMethod.PUT)
	public @ResponseBody CustomResponse refundCocheVendedor(@PathVariable Integer cocheId) {
		CustomResponse response = new CustomResponse();
		Coche c = cocheService.getCoche(cocheId);
		Vendedor v = vendedorService.getVendedor(1);
		c.setVendedor(v);
		cocheService.updateCoche(c);
		response.setMsg("Coche "+c.getMatricula()+" eliminado al vendedor "+v.getUsuario());
		response.setBody(c.toJSON());
		return response;
	}
}
