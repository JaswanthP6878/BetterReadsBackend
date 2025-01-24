package com.juswan.betterreads.domain;


import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "shelf")
public class Shelf {
    @Id
    @GeneratedValue
    private long id;
    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "book_shelf",
            joinColumns = @JoinColumn(name = "shelf_id"),
            inverseJoinColumns =  @JoinColumn(name = "book_id")
    )
    private Set<Book> books;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    Shelf() {}

    public Shelf(String name) {
        this.name = name;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
