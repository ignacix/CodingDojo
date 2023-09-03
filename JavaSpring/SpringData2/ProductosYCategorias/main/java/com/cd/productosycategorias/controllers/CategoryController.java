package com.cd.productosycategorias.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.cd.productosycategorias.models.CategoryModel;
import com.cd.productosycategorias.services.MainService;

import jakarta.validation.Valid;

@Controller
public class CategoryController {
	
	
	// INYECCION DE DEPENDECIAS
	private final MainService mainServ;
	public CategoryController(MainService service) {
		this.mainServ = service;
	}
	
	@GetMapping("/categories/new")
	public String formProduct(@ModelAttribute("categoria") CategoryModel categoria) {
		return "nuevacategoria.jsp";
	}
	
	@PostMapping("/categories/new")
	public String nuevoProduct(@Valid @ModelAttribute("categoria") CategoryModel categoria, 
			BindingResult resultado) {
		if (resultado.hasErrors()) {

			return "nuevacategoria.jsp";
		}
		mainServ.crearCategoria(categoria);
		return "redirect:/";
	}
}
