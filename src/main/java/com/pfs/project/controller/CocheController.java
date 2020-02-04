package com.pfs.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pfs.project.model.Coche;
import com.pfs.project.service.CocheService;
import com.pfs.project.service.interfaces.CocheServiceInterface;

@Controller
@RequestMapping(value="/coche")
public class CocheController {

	@Autowired
	private CocheServiceInterface cocheService;
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public ModelAndView addCochePage() {
		ModelAndView modelAndView = new ModelAndView("add-coche-form");
		modelAndView.addObject("coche", new Coche());
		return modelAndView;
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public ModelAndView addingCoche(@ModelAttribute Coche coche) {
		
		ModelAndView modelAndView = new ModelAndView("home");
		cocheService.addCoche(coche);
		
		String message = "Coche was successfully added.";
		modelAndView.addObject("message", message);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/list")
	public ModelAndView listOfCoches() {
		ModelAndView modelAndView = new ModelAndView("list-of-teams");
		
		List<Coche> coches = cocheService.getCoches();
		modelAndView.addObject("coches", coches);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public ModelAndView editCochePage(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("edit-team-form");
		Coche coche = cocheService.getCoche(id);
		modelAndView.addObject("coche",coche);
		return modelAndView;
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.POST)
	public ModelAndView edditingCoche(@ModelAttribute Coche coche, @PathVariable Integer id) {
		
		ModelAndView modelAndView = new ModelAndView("home");
		
		cocheService.updateCoche(coche);
		
		String message = "Coche was successfully edited.";
		modelAndView.addObject("message", message);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public ModelAndView deleteCoche(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("home");
		cocheService.deleteCoche(id);
		String message = "Coche was successfully deleted.";
		modelAndView.addObject("message", message);
		return modelAndView;
	}
	
}
