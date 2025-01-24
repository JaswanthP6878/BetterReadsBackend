package com.juswan.betterreads.service;

import com.juswan.betterreads.domain.Book;
import com.juswan.betterreads.domain.Genre;
import com.juswan.betterreads.repository.BookRepository;
import com.juswan.betterreads.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class GenreService {

    @Autowired
    private GenreRepository repository;

    @Autowired
    private BookRepository bookRepository;

    public List<Genre>  getAllGenres() {
        return repository.findAll();
    }

    public Optional<Genre> findGenreById(Long id) {
        return repository.findById(id);
    }

    public Set<Book> getBooksByGenreId(Long genreId) {
        Genre genre = repository.findById(genreId).orElseThrow(
                () ->  new RuntimeException("Genre not found")
        );
        return genre.getBooks();
    }
}
