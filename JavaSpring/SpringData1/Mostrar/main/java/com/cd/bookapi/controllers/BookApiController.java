package com.cd.bookapi.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cd.bookapi.models.BookModel;
import com.cd.bookapi.services.BookService;

@RestController
public class BookApiController {

    private final BookService bookService;
    public BookApiController(BookService bookService){
        this.bookService = bookService;
    }
    
    // Mostrar info de todos los libros
    @GetMapping("/api/books")
    public List<BookModel> index() {
        return bookService.allBooks();
    }
    
    // Crear un libro
    @PostMapping(value="/api/books")
    public BookModel create(@RequestParam(value="title") String title,
    		@RequestParam(value="description") String desc,
    		@RequestParam(value="language") String lang,
    		@RequestParam(value="pages") Integer numOfPages) {
        BookModel book = new BookModel(title, desc, lang, numOfPages);
        return bookService.createBook(book);
    }
    
    // Buscar info de un libro en específico
    @GetMapping("/api/books/{id}")
    public BookModel show(@PathVariable("id") Long id) {
        BookModel book = bookService.findBook(id);
        return book;
    }
    
    //Actualizar info 
    @PutMapping("/api/books/{id}")
    public BookModel actualizar(@PathVariable("id") Long id,
    		@RequestParam(value="title") String title,
    		@RequestParam(value="description") String desc,
    		@RequestParam(value="language") String lang,
    		@RequestParam(value="pages") Integer numOfPages){
    		BookModel libro = new BookModel(id, title, desc, lang, numOfPages);
    		return bookService.actualizarLibro(libro);
    }
    
    @DeleteMapping("/api/books/{id}")
    public void borrar(@PathVariable("id")Long id){
    	bookService.deleteLibro(id);
    }
    
    
    
}
