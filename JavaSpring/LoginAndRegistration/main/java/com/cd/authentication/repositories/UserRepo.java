package com.cd.authentication.repositories;

import org.springframework.data.repository.CrudRepository;

import com.cd.authentication.models.User;


public interface UserRepo extends CrudRepository<User, Long>{

	User findByEmail(String email);
	
	
}
