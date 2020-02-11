package com.pfs.project.controller;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.pfs.project.model.Coche;
import com.pfs.project.model.Vendedor;
import com.pfs.project.service.CocheServiceImpl;
import com.pfs.project.service.CocheService;
import com.pfs.project.util.CustomResponse;

@Controller
@RequestMapping(value="/coche")
public class CocheController {

	@Autowired
	private CocheService cocheService;
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public @ResponseBody CustomResponse addingCoche(@ModelAttribute Coche coche) {
		CustomResponse response = new CustomResponse();
		cocheService.addCoche(coche);
		response.setMsg("Coche añadido correctamente");
		response.setBody(coche.toJSON());
		return response;
	}
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public @ResponseBody CustomResponse listOfCoches() {
		CustomResponse response = new CustomResponse();
		List<Coche> coches = cocheService.getCoches();
		JSONObject array = new JSONObject();
		array.put("coches", coches);
		response.setMsg("Correcto");
		response.setBody(array);
		return response;
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.PUT)
	public @ResponseBody CustomResponse edditingCoche(@ModelAttribute Coche coche, @PathVariable Integer id) {
		CustomResponse response = new CustomResponse();
		cocheService.updateCoche(coche);
		response.setMsg("Coche "+coche.getId() + " editado correctamente");
		response.setBody(coche.toJSON());
		return response;
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
	public @ResponseBody CustomResponse deleteCoche(@PathVariable Integer id) {
		CustomResponse response = new CustomResponse();
		cocheService.deleteCoche(id);
		response.setMsg("Coche "+ id + " eliminado correctamente");
		response.setBody(new Coche().toJSON());
		return response;
	}
	
}
