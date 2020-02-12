package com.pfs.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.pfs.project.model.Coche;
import com.pfs.project.service.CocheService;

@Controller
@RequestMapping(value="/coche")
@CrossOrigin(origins="*", methods={RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
public class CocheController {

	@Autowired
	private CocheService cocheService;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public @ResponseBody String getCoche(@PathVariable Integer id) {
		Coche coche = cocheService.getCoche(id);
		return new Gson().toJson(coche);
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public @ResponseBody String addingCoche(@RequestBody String json) {
		System.out.println(json);
		Coche coche = new Gson().fromJson(json, Coche.class);
		cocheService.addCoche(coche);
		return new Gson().toJson(coche);
	}
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public @ResponseBody String listOfCoches() {
		System.out.println("lista de coches");
		List<Coche> coches = cocheService.getCoches();
		return new Gson().toJson(coches);
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.PUT)
	public @ResponseBody String edditingCoche(@RequestBody String json, @PathVariable Integer id) {
		Coche coche = new Gson().fromJson(json, Coche.class);
		cocheService.updateCoche(coche);
		return new Gson().toJson(coche);
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
	public @ResponseBody String deleteCoche(@PathVariable Integer id) {
		Coche coche = cocheService.getCoche(id);
		cocheService.deleteCoche(id);
		return new Gson().toJson(coche);
	}
	
}
