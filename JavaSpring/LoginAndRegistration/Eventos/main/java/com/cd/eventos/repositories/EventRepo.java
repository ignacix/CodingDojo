package com.cd.eventos.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cd.eventos.models.EventModel;

@Repository
public interface EventRepo extends CrudRepository<EventModel, Long> {

	
	List<EventModel> findByProvincia(String provincia);
	
	List<EventModel> findByProvinciaIsNot(String provincia);
	
	
}
