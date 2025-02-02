package com.juswan.betterreads.repository;

import com.juswan.betterreads.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Book>  findByName(String name);
    List<Book> findByGenresId(Long genreId);
}
