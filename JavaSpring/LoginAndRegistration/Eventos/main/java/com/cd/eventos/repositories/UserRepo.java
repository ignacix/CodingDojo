package com.cd.eventos.repositories;

import org.springframework.data.repository.CrudRepository;

import com.cd.eventos.models.User;


public interface UserRepo extends CrudRepository<User, Long>{

	User findByEmail(String email);
	
	
}