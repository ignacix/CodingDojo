package com.cd.eventos.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cd.eventos.models.EventModel;
import com.cd.eventos.repositories.EventRepo;

@Service
public class EventService {
	
	private final EventRepo eventRepo;
	public EventService(EventRepo eRepo) {
		this.eventRepo = eRepo;
	}
	
	public EventModel crearEvento(EventModel evento) {
		return eventRepo.save(evento);
	}
	
	public EventModel actualizarEvento(EventModel evento) {
		return eventRepo.save(evento);
	}
	
	public void eliminarEvento(Long id) {
		eventRepo.deleteById(id);
	}
	
	public List<EventModel> eventosProvinciaUsuario(String provincia){
		return eventRepo.findByProvincia(provincia);
	}
	
	public List<EventModel> eventosProvinciaNoUsuario(String provincia){
		return eventRepo.findByProvinciaIsNot(provincia);
	}
	
	//Evento para traer de la base de datos 
	public EventModel unEvento(Long id) {
		return eventRepo.findById(id).orElse(null);
	}
	
}
