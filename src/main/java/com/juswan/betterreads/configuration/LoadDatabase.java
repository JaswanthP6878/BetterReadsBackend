package com.juswan.betterreads.configuration;


import com.juswan.betterreads.domain.Book;
import com.juswan.betterreads.domain.Genre;
import com.juswan.betterreads.domain.Shelf;
import com.juswan.betterreads.domain.User;
import com.juswan.betterreads.repository.BookRepository;
import com.juswan.betterreads.repository.ShelfRepository;
import com.juswan.betterreads.repository.UserRepository;
import com.juswan.betterreads.service.BookService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.Set;


@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
    @Bean
    public CommandLineRunner  loadUsers(UserRepository repository, BookRepository bookRepository, ShelfRepository shelfRepository) {
        Book book = new Book("BreakFast For Champions", "Kurt Vonegut", new Date());
        Genre genre = new Genre("Humor");
        Genre genre2 = new Genre("Satire");
        Shelf toRead = new Shelf("toRead");
        User suresh = new User("suresh", "raina", "sraina", "$2a$10$8cjz47bjbR4Mn8GMg9IZx.vyjhLXR/SKKMSZ9.mP9vpMu0ssKi8GW", "USER" );
        book.setGenres(Set.of(genre, genre2));
        toRead.setBooks(Set.of(book));
        toRead.setUser(suresh);
        suresh.setShelfs(Set.of(toRead));

        return args -> {
            log.info("added row{}", repository.save(suresh));
//            log.info("added row" + bookRepository.save(book));
        };
    }
}
