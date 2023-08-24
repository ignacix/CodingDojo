package com.cd.bookapi.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cd.bookapi.models.BookModel;

@Repository
public interface BookRepo extends CrudRepository<BookModel, Long>{
	
    //Este método recupera todos los libros de la base de datos
    List<BookModel> findAll();
    //Este método encuentra un libro por su descripción
    List<BookModel> findByDescriptionContaining(String search);
    //Este método cuenta cuántos libros contiene cierta cadena en el título
    Long countByTitleContaining(String search);
    //Este método borra un libro que empieza con un título específico
    Long deleteByTitleStartingWith(String search);
    

}
