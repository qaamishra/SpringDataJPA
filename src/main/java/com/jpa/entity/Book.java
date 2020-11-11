package com.jpa.entity;

import javax.persistence.*;

@Entity
public class Book {

    public Book() {
    }

    @Id//Primary key
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    @Column(unique = true, name = "isbn")
    private String isbn;

    public Book(Long id, String title, String isbn) {
        this.id = id;
        this.title = title;
        this.isbn = isbn;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                '}';
    }
}
