package com.juswan.betterreads.controllers;


import com.juswan.betterreads.domain.Book;
import com.juswan.betterreads.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;

@Controller
@RequestMapping("/api/genres")
public class GenreController {

    @Autowired
    private GenreService genreService;

    @GetMapping("/{id}/books/")
    public ResponseEntity<Set<Book>> getBooksByGenreId(@PathVariable Long id) {
        Set<Book> books = genreService.getBooksByGenreId(id);
        return ResponseEntity.ok(books);
    }

}
