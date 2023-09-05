package com.cd.eventos.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.cd.eventos.models.EventModel;
import com.cd.eventos.models.Provincia;
import com.cd.eventos.models.User;
import com.cd.eventos.services.EventService;
import com.cd.eventos.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class EventController {
	
	private final EventService eventService;
	private final UserService userService;
	public EventController(EventService eService, UserService uService) {
		this.eventService = eService;
		this.userService = uService;
	}
	
	
	@PostMapping("/nuevo/evento")
	public String createEvent(@Valid @ModelAttribute("evento") EventModel evento, BindingResult resultado,Model model, HttpSession sesion) {
		//VALIDAR SI LA SESION ESTA ACTIVA
		Long userId = (Long)sesion.getAttribute("userID");
		if(userId == null) {
			return "redirect:/";
		}
		if(resultado.hasErrors()) {			
			User usuarioUser = userService.encontrarUserPorId(userId);
			model.addAttribute("usuario", usuarioUser);		
			model.addAttribute("provincias", Provincia.provincias);
			return "dashboard.jsp";
		}
		eventService.crearEvento(evento);
		return "redirect:/events";
	}
	
	
	//EDITAR EVENTO
	@GetMapping("/events/{idEvento}/edit")
	public String formEdicionEvento(@PathVariable("idEvento")Long idEvento,
			@ModelAttribute("evento")EventModel evento, HttpSession sesion,
			Model model) {
		//validar si el usuario está activo
		Long userId = (Long)sesion.getAttribute("userID");
		if(userId == null) {
			return "redirect:/";
		}
		EventModel unEvento = eventService.unEvento(idEvento);
		if(unEvento == null){
			return "redirect:/";			
		}
		User usuarioUser = userService.encontrarUserPorId(userId);
		model.addAttribute("usuario", usuarioUser);		
		model.addAttribute("provincias", Provincia.provincias);
		model.addAttribute("evento", unEvento);
		return"edit.jsp";
	}
	
	@PutMapping("/events/{id}/edit")
	public String StringeditarEvento(@Valid @ModelAttribute("evento") EventModel evento,
			BindingResult resultado, @PathVariable("id")Long idEvento, HttpSession sesion,
			Model model) {
		//VALIDAR SI LA SESION ESTA ACTIVA
		Long userId = (Long)sesion.getAttribute("userID");
		if(userId == null) {
			return "redirect:/";
		}
		User usuarioUser = userService.encontrarUserPorId(userId);
		if(resultado.hasErrors()) {
			model.addAttribute("usuario", usuarioUser);		
			model.addAttribute("provincias", Provincia.provincias);		
			return"edit.jsp";
		}
		eventService.actualizarEvento(evento);
		return "redirect:/events";

	}
	
	@DeleteMapping("/events/{id}/delete")
	public String borrar(@PathVariable("id")Long idEvento) {
		eventService.eliminarEvento(idEvento);
		return "redirect:/events";
		
	}
	

}
