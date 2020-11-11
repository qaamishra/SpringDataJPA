package com.jpa.service;

import com.jpa.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public Iterable<Book> createBook(List<Book> bookList) {
        return bookRepository.saveAll(bookList);
    }

    public Book fetchBookByIsbn(String Isbn) {
        return bookRepository.findByIsbn(Isbn);
    }

    @Transactional
    public int deleteBookByIsbn(String Isbn) {
        return bookRepository.deleteByIsbn(Isbn);
    }

    @Transactional
    public int updateByIsbn(String title, String Isbn) {
        return bookRepository.updateByIsbn(title, Isbn);
    }

    public String fetchBookTitleByIsbn(String Isbn) {
        return bookRepository.fetchBookTitleByIsbn(Isbn);
    }
}
