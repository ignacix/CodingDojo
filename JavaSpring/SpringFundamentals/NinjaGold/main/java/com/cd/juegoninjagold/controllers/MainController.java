package com.cd.juegoninjagold.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {
	
	@GetMapping("/")
	public String raiz() {
		return "redirect:/gold";
	}
	
	@GetMapping("/gold")
	public String index(HttpSession sesion , Model model) {
		if(sesion.getAttribute("gold")==null) {
			sesion.setAttribute("gold", 0);			
		}			
		if(sesion.getAttribute("resultados")== null){
			sesion.setAttribute("resultados", new ArrayList<String>());
		}
		model.addAttribute("resultados", sesion.getAttribute("resultados"));
		model.addAttribute("gold", sesion.getAttribute("gold"));
		return "index.jsp";
	}
	
	@PostMapping("/gold")
	public String enviarOro(HttpSession sesion, @RequestParam(value="lugar")String lugar){
		
		//Variables
		int oro = 0;
		ArrayList<String> resultados = new ArrayList<String>();
		SimpleDateFormat formato = new SimpleDateFormat("MMMM D Y h:mm a");
		
		//Inicializar si esta vacía
		
		if(sesion.getAttribute("gold")== null) {
			sesion.setAttribute("gold", oro);
			sesion.setAttribute("resultados", resultados);
		}else {
			oro = (int)sesion.getAttribute("gold");
			resultados = (ArrayList<String>) sesion.getAttribute("resultados");
	 
			
			int cantidad; 
			switch (lugar) {
				case "farm":
					cantidad = new Random().nextInt(11)+10;
					oro += cantidad;
					resultados.add(0, "You entered a "+ lugar+" and earned "+ cantidad+" ("+formato.format(new Date())+")");
					break;
				case "cave":
					cantidad = new Random().nextInt(6)+5;
					oro += cantidad;
					resultados.add(0, "You entered a "+ lugar+" and earned "+ cantidad+" ("+formato.format(new Date())+")");
					break;
				case "house":
					cantidad = new Random().nextInt(4)+2;
					oro += cantidad;
					resultados.add(0, "You entered a "+ lugar+" and earned "+ cantidad+" ("+formato.format(new Date())+")");
					break;
				case "casino":
					boolean suerte = ThreadLocalRandom.current().nextBoolean();
					cantidad = new Random().nextInt(51);
					if(suerte) {
						oro += cantidad;
						resultados.add(0, "You entered a "+ lugar+" and earned "+ cantidad+" ("+formato.format(new Date())+")");
					}else {
						oro -= cantidad;
						resultados.add(0, "You entered a "+ lugar+" and lost -"+ cantidad+" ("+formato.format(new Date())+")");
					}
					break;
			}
			
			
		}
		sesion.setAttribute("gold", oro);
		sesion.setAttribute("resultados", resultados);
		return "redirect:/gold";
	}
}
