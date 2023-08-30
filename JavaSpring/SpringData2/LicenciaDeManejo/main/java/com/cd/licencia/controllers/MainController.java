package com.cd.licencia.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.cd.licencia.models.Licencia;
import com.cd.licencia.models.Persona;
import com.cd.licencia.services.MainService;

import jakarta.validation.Valid;

@Controller
public class MainController {
	
	@Autowired
	private MainService mainService; 
	
	@GetMapping("/persons/new")
	public String newPersonidex(@ModelAttribute("persona") Persona persona) {
		return "newperson.jsp";
	}
	
	@PostMapping("/persons/new")
	public String newPerson(@Valid @ModelAttribute("persona") Persona persona, BindingResult resultado) {
		if(resultado.hasErrors()) {
			return "newperson.jsp";			
		}		
		mainService.crearPersona(persona);
		return "redirect:/licenses/new";
	}

	@GetMapping("/licenses/new")
	public String newlicense(Model model, @ModelAttribute("licencia") Licencia licencia) {
		//List<Persona> listaPersonas = mainService.todasPersonas();
		List<Persona> listaPersonas = mainService.obtenerPesonasSinLic();
		model.addAttribute("listaPersonas", listaPersonas);
		return "newlicencia.jsp";
	}
	
	@PostMapping("/enviarlicencia/new")
	public String newlicense(@Valid @ModelAttribute("licencia") Licencia licencia, BindingResult resultado, Model model) {
		if(resultado.hasErrors()) {
			List<Persona> listaPersonas = mainService.obtenerPesonasSinLic();
			model.addAttribute("listaPersonas", listaPersonas);
			return "newlicencia.jsp";
		}else {
			mainService.crearLicencia(licencia); 
			return "redirect:/";					
		}
		
	}
	
	@GetMapping("/persons/{id}")
	public String buscarPeronsa(Model model, @PathVariable("id")Long id ){
		
		model.addAttribute("persona", mainService.findPersona(id));				  		
		return "info.jsp";
	}
	
	
	
	
}
