package com.cd.lookify.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.cd.lookify.models.SongModel;

public interface SongRepo extends CrudRepository<SongModel, Long>{

	//Rewrite the method findAll()
	List<SongModel> findAll();
	
	
	//Write topTen Method
	@Query(value = " SELECT * FROM song ORDER BY rating DESC LIMIT 10;" , nativeQuery = true)
	List<SongModel> getTopTen();
	
	
	//Write findbyArtist
	List<SongModel> findByArtist(String artist);
	
}
