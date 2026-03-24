package com.springframeworkd.spring6webapp.controllers;
import com.springframeworkd.spring6webapp.domain.Book;
import com.springframeworkd.spring6webapp.services.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping( "/books")
    public String listBooks(Model model) {
        Iterable<Book> books = bookService.findAll();
        model.addAttribute("books", books);
        return "books/list";
    }
}
