package com.cd.lenguajes.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.cd.lenguajes.models.LenguajeModel;
import com.cd.lenguajes.services.LenguajeService;

import jakarta.validation.Valid;

@Controller
public class LenguajeController {
	
	@Autowired
	private LenguajeService lenguajeService;
	
	@GetMapping("/lenguaje")
	public String index(Model model, @ModelAttribute("leng")LenguajeModel leng) {
		List<LenguajeModel> lenguaje = lenguajeService.allLenguajes();
		model.addAttribute("lenguaje", lenguaje);
		return "/lenguajes/index.jsp";
	}
	
	@PostMapping("/lenguaje")
	public String create(@Valid @ModelAttribute("leng") LenguajeModel leng, BindingResult result) {
		if(result.hasErrors()) {
			return "/lenguajes/index.jsp";
		}else {
			lenguajeService.createLenguaje(leng);
			return "redirect:/lenguaje";
		}		
	}
		
	@GetMapping("/lenguaje/{id}")
	public String show(@PathVariable("id")Long id, Model model) {
		LenguajeModel lenguajeActual = lenguajeService.findLeanguaje(id);
		model.addAttribute("lenguaje", lenguajeActual);
		return "lenguajes/delete.jsp";
	}
	
	@GetMapping("/lenguaje/{id}/edit")
	public String showEdit(@PathVariable("id")Long id, Model model) {
		LenguajeModel lenguajeActual = lenguajeService.findLeanguaje(id);
		model.addAttribute("lenguaje", lenguajeActual);
		
		return "lenguajes/edit.jsp";
	}
	
	
	@PutMapping("/lenguaje/{id}")
	public String edit(@Valid @ModelAttribute("lenguaje") LenguajeModel lenguaje, BindingResult result) {
		if(result.hasErrors()) {
			return "/lenguajes/edit.jsp";
		}else {
			lenguajeService.updateLenguaje(lenguaje) ;
			return "redirect:/lenguaje";
		}
	}
	
	@DeleteMapping("/lenguaje/{id}")
	public String delete(@PathVariable("id")Long id){
		 lenguajeService.deleteLenguaje(id);
		return "redirect:/lenguaje";
	}
	
	
	
}
