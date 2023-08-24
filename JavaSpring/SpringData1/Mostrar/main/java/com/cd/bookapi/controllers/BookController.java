package com.cd.bookapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.cd.bookapi.models.BookModel;
import com.cd.bookapi.services.BookService;

import jakarta.validation.Valid;


@Controller
public class BookController {
	
	@Autowired
    private BookService bookService;
    
    //Mostrar todos los libros
    @GetMapping("/books")
    public String index(Model model) {
        List<BookModel> books = bookService.allBooks();
        model.addAttribute("books", books);
        return "/books/index.jsp";
    }
    
    @GetMapping("/books/{id}")
    public String index(@PathVariable("id")Long id, Model model) {
        BookModel book = bookService.findBook(id);
        model.addAttribute("book", book);
        return "/books/solo.jsp";
    }
    
    //Crear Libro
    @GetMapping("/books/new")
    public String formularioLibro(@ModelAttribute("book") BookModel book) {
    	return "/books/formlibro.jsp";
    }
	
    @PostMapping("/books")
    public String create(@Valid @ModelAttribute("book") BookModel book, BindingResult result) {
        if (result.hasErrors()) {
            return "/books/new.jsp";
        } else {
            bookService.createBook(book);
            return "redirect:/books";
        }
    }
    
    
}
