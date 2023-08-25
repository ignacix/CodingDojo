package com.cd.lenguajes.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cd.lenguajes.models.LenguajeModel;

public interface LenguajeRepo extends CrudRepository<LenguajeModel, Long>{
	
	//Rewrite the method
	List<LenguajeModel> findAll();
}
