package com.cd.authentication.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.cd.authentication.models.User;
import com.cd.authentication.repositories.UserRepo;

@Service
public class UserService {
	
	private final UserRepo userRepo;
	public UserService(UserRepo usRepo) {
		this.userRepo = usRepo;
	}
	
	
	// User Register
	public User registrarUsuario(User user, BindingResult resultado) {
		
		User usuarioRegistrado = userRepo.findByEmail(user.getEmail());
		
		if(usuarioRegistrado != null) {
			resultado.rejectValue("email", "Matches", "Correo electrónico ya existe");			
		}
		if(!user.getPassword().equals(user.getPasswordConfirmation())) {
			resultado.rejectValue("password", "Matches", "El Password no coincide");
		}
		if(resultado.hasErrors()) {
			return null;
		}		
		String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		user.setPassword(hashed);
		return userRepo.save(user);
					
	}	
	
	//Auntenticación del usuario
	
	public Boolean autenticaUser(String email, String password, BindingResult resultado) {
		User usuario = userRepo.findByEmail(email);
		if(usuario == null) {
			resultado.rejectValue("email", "Matches", "El usuario no esta registrado");
			return false;
		}else {
			if(BCrypt.checkpw(password, usuario.getPassword())) {
				return true;
			}else {
				resultado.rejectValue("password", "Matches", "Password no valido");
				return false;
			}
		}
	}
	
	//Encontrar por email
	
	public User encontrarPorEmail(String email) {
		return userRepo.findByEmail(email);
	}
	
	// Enocntrar User por ID
	
	public User encontrarUserPorId(Long id) {
		Optional<User> user = userRepo.findById(id);
		if(user.isPresent()) {
			return user.get();
		}
		return null;
	}
	
	
}
