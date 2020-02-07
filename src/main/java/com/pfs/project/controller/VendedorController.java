package com.pfs.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.pfs.project.model.Vendedor;
import com.pfs.project.service.interfaces.VendedorServiceInterface;
import com.pfs.project.util.CustomResponse;

@Controller
@RequestMapping(value = "/vendedor")
public class VendedorController {

	@Autowired
	private VendedorServiceInterface vendedorService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public @ResponseBody CustomResponse loginCheck(@ModelAttribute Vendedor vendedor) {
		Vendedor v = vendedorService.getVendedorByUsername(vendedor.getUsuario());
		CustomResponse response = new CustomResponse();
		if (v != null) {
			if (v.getPass().equals(vendedor.getPass())) {
				response.setMsg("Correcto");
				response.setBody(v.toJSON());
			}
			else {
				response.setMsg("Contraseña no valida");
			}
		} else {
			response.setMsg("Usuario no valido");
		}
			
		return response;
	}

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public @ResponseBody CustomResponse addingVendedor(@ModelAttribute Vendedor vendedor) {
		Vendedor v = vendedorService.getVendedorByUsername(vendedor.getNombre());
		CustomResponse response = new CustomResponse();
		if (v == null) {
			vendedorService.addVendedor(vendedor);
			response.setMsg("Usuario registrado correctamente");
			response.setBody(vendedor.toJSON());
		} else {
			response.setMsg("El usuario "+vendedor.getUsuario()+" ya existe");
		}
		return response;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.PUT)
	public @ResponseBody CustomResponse edditingVendedor(@ModelAttribute Vendedor vendedor, @PathVariable Integer id) {
		CustomResponse response = new CustomResponse();
		vendedorService.updateVendedor(vendedor);
		response.setMsg("Usuario actualizado correctamente");
		response.setBody(vendedor.toJSON());
		return response;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public @ResponseBody CustomResponse deleteVendedor(@PathVariable Integer id) {
		CustomResponse response = new CustomResponse();
		vendedorService.deleteVendedor(id);
		response.setMsg("Usuario borrado con id: "+id);
		return response;
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public @ResponseBody CustomResponse logout() {
		CustomResponse response = new CustomResponse();
		response.setMsg("Adios!");
		response.setBody(new Vendedor().toJSON());
		return response;
	}

}
