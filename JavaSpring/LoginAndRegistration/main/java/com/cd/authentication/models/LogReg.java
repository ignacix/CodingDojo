package com.cd.authentication.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class LogReg {

  	@NotBlank(message="Por favor ingresa un correo electrónico")
  	@Email(message="El ingreso")
    private String email;
  	
  	@NotBlank(message="Por favor, ingresa el password")
  	@Size(min=8, max=64, message="Password debe contener mínimo 8 caracteres")
    private String password;
  	
  	public LogReg(){
  		
  	}
  	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
    
	
}
