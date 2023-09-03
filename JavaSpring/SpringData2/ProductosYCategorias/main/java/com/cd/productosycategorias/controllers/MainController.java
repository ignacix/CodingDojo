package com.cd.productosycategorias.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cd.productosycategorias.services.MainService;

@Controller
public class MainController {
	
	private final MainService mainServ;
	public MainController(MainService mainS) {
		this.mainServ = mainS;
	}

	@GetMapping("/")
	public String root(Model modelo) {
		modelo.addAttribute("productos", mainServ.todosProductos() );
		return "index.jsp";
	}
}
