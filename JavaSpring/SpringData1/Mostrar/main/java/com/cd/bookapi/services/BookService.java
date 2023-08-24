package com.cd.bookapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cd.bookapi.models.BookModel;
import com.cd.bookapi.repositories.BookRepo;

@Service
public class BookService {
	
    //Agregando el book al repositorio como una dependencia
    private BookRepo bookRepository;
    
    public BookService(BookRepo bookRepository) {
        this.bookRepository = bookRepository;
    }
    //Devolviendo todos los libros.
    public List<BookModel> allBooks() {
        return bookRepository.findAll();
    }
    //Creando un libro.
    public BookModel createBook(BookModel b) {
        return bookRepository.save(b);
    }
    //Obteniendo la información de un libro
    public BookModel findBook(Long id) {
        Optional<BookModel> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
    
    //Actualizar 
    public BookModel actualizarLibro(BookModel libro) {
    	BookModel libroSelected = findBook(libro.getId());
    	libroSelected.setTitle(libro.getTitle());
    	libroSelected.setDescription(libro.getDescription());
    	libroSelected.setLanguage(libro.getLanguage());
    	libroSelected.setNumberOfPages(libro.getNumberOfPages());
    	return bookRepository.save(libroSelected);    	    	   
    }
    
    //Delete
    public void deleteLibro(Long id) {
    	bookRepository.deleteById(id);
    }

}
