package com.cd.eventos.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.cd.eventos.models.EventModel;
import com.cd.eventos.models.LogReg;
import com.cd.eventos.models.Provincia;
import com.cd.eventos.models.User;
import com.cd.eventos.services.EventService;
import com.cd.eventos.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class UserController {
	
	private final UserService userService;
	private final EventService eventService;
	public UserController(UserService uService, EventService eService) {
		this.userService = uService;
		this.eventService = eService;
	}
	
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("login", new LogReg());
		model.addAttribute("provincias", Provincia.provincias);
		return "loginreg.jsp";
	}
	
	
	@PostMapping("/registration")
	public String registro(@Valid @ModelAttribute("user") User usuario, BindingResult resultado, Model model) {
		if(resultado.hasErrors()) {
			model.addAttribute("login", new LogReg());
			model.addAttribute("provincias", Provincia.provincias);
			return "loginreg.jsp";
		}		
		User usuarioRegistrado = userService.registrarUsuario(usuario, resultado);
		model.addAttribute("login", new LogReg());
		if(usuarioRegistrado != null) {
			model.addAttribute("registro", "Greacias por registrarte, ahora logueate!");
		}
		return "loginreg.jsp";
	}
	
	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("login") LogReg logUser, BindingResult resultado, Model model, HttpSession sesion) {
		if(resultado.hasErrors()) {
			model.addAttribute("user", new User());
			return "loginreg.jsp";
		}
		if(userService.autenticaUser(logUser.getEmail(), logUser.getPassword(), resultado)) {
			User usuarioLogueado = userService.encontrarPorEmail(logUser.getEmail());
			sesion.setAttribute("userID", usuarioLogueado.getId());
			return "redirect:/events";
		}else {
			model.addAttribute("error", "Por favor intenta denuevo!");
			model.addAttribute("user", new User());
			return "loginreg.jsp";
		}
	}
 	
	//RENDERIZA LA PLANTILLA BASE
	@GetMapping("/events")
	public String showDashboard(@ModelAttribute("evento")EventModel evento,
			BindingResult resultado,
			HttpSession sesion, Model model) {
		//validar si el usuario está activo
		Long userId = (Long)sesion.getAttribute("userID");
		if(userId == null) {
			return "redirect:/";
		}
		User usuarioUser = userService.encontrarUserPorId(userId);
		model.addAttribute("usuario", usuarioUser);		
		model.addAttribute("provincias", Provincia.provincias);
		model.addAttribute("eventosProvinciaUser", eventService.eventosProvinciaUsuario(usuarioUser.getProvincia()));
		model.addAttribute("eventosProvinciaNoUser", eventService.eventosProvinciaNoUsuario(usuarioUser.getProvincia()));
		return"dashboard.jsp";
	}
	

	
	@GetMapping("/logout")
	public String logout(HttpSession sesion) {
		sesion.setAttribute("userID", null);
		return "redirect:/";
	}
}