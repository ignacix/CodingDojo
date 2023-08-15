package com.cd.mostrarfecha.controllers;



import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;




@Controller
public class MainController {
	
	@GetMapping("")
	public String index() {
		return "index.jsp";
	}
	
	@GetMapping("/date")
	public String date(Model model) {
		SimpleDateFormat fecha = new SimpleDateFormat("EEEE, MMM d, yyyy");
		Date date = new Date();
		model.addAttribute("fecha", fecha.format(date));
		return "date.jsp";
	}
	
	@GetMapping("/time")
	public String time(Model model) {
		SimpleDateFormat format = new SimpleDateFormat("h:mm a");
		Date date = new Date();
		model.addAttribute("time", format.format(date));
		return "time.jsp";
	}
}
