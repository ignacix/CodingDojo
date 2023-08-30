package com.cd.lista.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cd.lista.models.ContactModel;

@Repository
public interface ContactRepo extends CrudRepository<ContactModel, Long>{

}
