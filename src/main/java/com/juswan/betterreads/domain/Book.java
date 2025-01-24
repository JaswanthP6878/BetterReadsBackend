package com.juswan.betterreads.domain;


import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "books")

public class Book {
    @GeneratedValue
    @Id
    private Long id;
    private String name;
    private String author;
    private Date dateOfPublishing;

    Book() {}

    public Book(String name, String author, Date dateOfPublishing) {
        this.name = name;
        this.author = author;
        this.dateOfPublishing = dateOfPublishing;
    }

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "book_genre",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private Set<Genre> genres;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getDateOfPublishing() {
        return dateOfPublishing;
    }

    public void setDateOfPublishing(Date dateOfPublishing) {
        this.dateOfPublishing = dateOfPublishing;
    }

    public Set<Genre> getGenres() {
        return genres;
    }

    public void setGenres(Set<Genre> genres) {
        this.genres = genres;
    }

    public Long getId() {
        return id;
    }
}
