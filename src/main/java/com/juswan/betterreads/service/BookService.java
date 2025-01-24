package com.juswan.betterreads.service;
import com.juswan.betterreads.domain.Book;
import com.juswan.betterreads.domain.Genre;
import com.juswan.betterreads.repository.BookRepository;
import com.juswan.betterreads.repository.GenreRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository repository;
    private  final GenreRepository genreRepository;
    //    private GenreRepository genreRepository;

    public BookService(BookRepository repository, GenreRepository genreRepository) {
        this.repository = repository;
        this.genreRepository = genreRepository;
    }

    public Book saveBook(Book book) {
        return repository.save(book);
    }

    public Book getBookByName(String name) {
        return repository.findByName(name).orElse(null);
    }

    public List<Book> getBooks() {
        return repository.findAll();
    }

}
