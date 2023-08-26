package com.cd.lookify.controllers;

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
import org.springframework.web.bind.annotation.RequestParam;

import com.cd.lookify.models.SongModel;
import com.cd.lookify.services.SongService;

import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;

@Controller
public class SongController {

	@Autowired
	private SongService songService;
	
	@GetMapping("/")
	public String index(Model model ) {
		return "/pestañas/index.jsp";
	}
	
	@GetMapping("/dashboard")
	public String dashboard(Model model) {
		List<SongModel> listSong = songService.allSongs();
		model.addAttribute("listSong", listSong);
		return"/pestañas/dashboard.jsp";
	}
	
	@GetMapping("/songs/new")
	public String newSong(Model model, @ModelAttribute("song") SongModel song) {		
		return"/pestañas/new.jsp";
	}
	
	@PostMapping("/songs/new")
	public String create(@Valid @ModelAttribute("song") SongModel song, BindingResult result) {
		if(result.hasErrors()) {
			return "/pestañas/new.jsp";
		}else {
			songService.createSong(song);
			return "redirect:/dashboard";
		}		
	}
	
	@GetMapping("/songs/{id}")
	public String showInfo(Model model, @PathVariable("id")Long id) {
		SongModel songSelected = songService.findSong(id);
		model.addAttribute("song", songSelected);
		return "/pestañas/details.jsp";
	}
	
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable("id")Long id) {
		songService.deleteSong(id);
		return "redirect:/dashboard";
	}
	
	@GetMapping("/search/topTen")
	public String showTop(Model model) {
		List<SongModel> listTopTen = songService.getTopTen();
		model.addAttribute("listaTopTen", listTopTen);
		return"/pestañas/top.jsp";
	}
	
	@GetMapping("/search")
	public String redirectShowArtist(Model model,@RequestParam("artist") String artist ) {
		model.addAttribute("artist", artist);
		return "redirect:/search/" + artist;
	}
	
	@GetMapping("/search/{artist}")
	public String showArtist(Model model, @PathVariable("artist")String artist) {		
		List<SongModel> songArtist = songService.findByArtist(artist);
		if(artist.isEmpty() || artist == null) {
			return "redirect:/search";
		}else {
			model.addAttribute("songsArtist", songArtist);
			model.addAttribute("artista", songArtist.get(0).getArtist());
			return"/pestañas/search.jsp";			
		}
	}
	
	
	
	
}
