package com.cd.lenguajes.services;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cd.lenguajes.models.LenguajeModel;
import com.cd.lenguajes.repositories.LenguajeRepo;

@Service
public class LenguajeService {
	
	@Autowired
	private LenguajeRepo lenguajeRepo;
	
	//Return all languages
	public List<LenguajeModel> allLenguajes(){
		return lenguajeRepo.findAll();
	}
	
	//create a new Language
	public LenguajeModel createLenguaje(LenguajeModel l) {
		return lenguajeRepo.save(l);
	}
	
	// Get information about a language
	public LenguajeModel findLeanguaje(Long id) {
		Optional<LenguajeModel> optionalLenguaje = lenguajeRepo.findById(id);
		if(optionalLenguaje.isPresent()) {
			return optionalLenguaje.get();
		}else {
			return null;
		}
	}
	
	//Upload
	public LenguajeModel updateLenguaje(LenguajeModel lenguaje) {
		LenguajeModel lenguajeSelected = findLeanguaje(lenguaje.getId());		
		lenguajeSelected.setName(lenguaje.getName());;
		lenguajeSelected.setCreator(lenguaje.getCreator());
		lenguajeSelected.setVersion(lenguaje.getVersion());
		return lenguajeRepo.save(lenguajeSelected);		
	}	
	
	//Delete
	public void deleteLenguaje(Long id) {
		lenguajeRepo.deleteById(id);
	}		
}
