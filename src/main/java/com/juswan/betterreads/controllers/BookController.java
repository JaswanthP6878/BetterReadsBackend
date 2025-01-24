package com.juswan.betterreads.controllers;

import com.juswan.betterreads.domain.Book;
import com.juswan.betterreads.service.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/api/books/")
    List<Book> getBooks() {
       return bookService.getBooks();
    }

    @GetMapping("/api/books/{name}")
    Book getBookByName(@PathVariable String name)  {
        return bookService.getBookByName(name);
    }
}
