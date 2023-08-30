package com.cd.lista.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cd.lista.models.ContactModel;
import com.cd.lista.models.StudentModel;
import com.cd.lista.repositories.ContactRepo;
import com.cd.lista.repositories.StudentRepo;

@Service
public class ApiService {

	@Autowired
	private StudentRepo studentRepo;
	
	@Autowired
	private ContactRepo contactRepo;
	
	public List<StudentModel> listStudents(){
		return studentRepo.findAll();
	}
	
	
	public StudentModel createStudent(StudentModel s) {
		return studentRepo.save(s);
	}
	
	public ContactModel createContact(ContactModel c) {
		return contactRepo.save(c);
	}
	
}


