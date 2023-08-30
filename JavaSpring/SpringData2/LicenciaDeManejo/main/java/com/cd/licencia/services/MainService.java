package com.cd.licencia.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cd.licencia.models.Licencia;
import com.cd.licencia.models.Persona;
import com.cd.licencia.repositories.LicenciaRepo;
import com.cd.licencia.repositories.PersonaRepo;

@Service
public class MainService {
	
	@Autowired
	private PersonaRepo personaRepo;
	
	@Autowired
	private LicenciaRepo licenciaRepo;
	
	
	//Methods
	
	public Persona crearPersona(Persona persona) {
		return personaRepo.save(persona) ;
	}
	
	
	
	public List<Persona> todasPersonas(){
		return personaRepo.findAll();
	}
	
	public Licencia crearLicencia(Licencia licencia) {
		licencia.setNumber(this.gererarNumLic());
		return licenciaRepo.save(licencia);
	}
	
	public List<Persona> obtenerPesonasSinLic(){
		return personaRepo.findByLicenseIdIsNull();
	}
	
	public Persona findPersona(Long id) {
		Optional<Persona>optionalPersona =  personaRepo.findById(id);
		if(optionalPersona.isPresent()) {
			return optionalPersona.get();
		}else {
			return null;
		}	
	}
	
	// MÉTODO PARA RETORNAR NUMERO CONCATENADO
		public Integer gererarNumLic() {
			Licencia lic = licenciaRepo.findTopByOrderByNumberDesc();
			if(lic == null) {
				return 1;
			}else {
				Integer numeroMayor = lic.getNumber()+1;
				return numeroMayor;
				
			}
		}
}
