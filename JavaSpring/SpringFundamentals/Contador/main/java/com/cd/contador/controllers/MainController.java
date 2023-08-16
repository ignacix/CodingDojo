package com.cd.contador.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {

	//MÉTODOS DE CLASE	
	private void setContadorSesion(HttpSession sesion, int numeroVeces) {
		sesion.setAttribute("contador", numeroVeces);
	}
	
	private int getContadorSesion(HttpSession sesion) {
		Object valorSesion = sesion.getAttribute("contador");
		if(valorSesion == null){
			setContadorSesion(sesion, 0);
			valorSesion = sesion.getAttribute("contador");
		}
		return (int) valorSesion; 
	}
	
	
	//MÉTODOS DE RUTA
	
	@GetMapping("/your_server/counter")
	public String counter(HttpSession sesion) {			
		return "counter.jsp";		
	}
	
	@GetMapping("/your_server")
	public String yourServer(HttpSession sesion) {
		int contador = this.getContadorSesion(sesion);
		sesion.setAttribute("contador", contador+1);		
		return "index.jsp";
	}
	
	@GetMapping("/your_server/double")
	public String doble(HttpSession sesion) {
		int contador = this.getContadorSesion(sesion);
		sesion.setAttribute("contador", contador+2);		
		return "double.jsp";
	}

	@GetMapping("your_server/reset")
	public String reset(HttpSession sesion) {
		this.setContadorSesion(sesion, 0);
		return"reset.jsp";
	}
	
}
