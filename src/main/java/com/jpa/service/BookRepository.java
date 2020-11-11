package com.jpa.service;


import com.jpa.entity.Book;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

    Book findByIsbn(String isbn);

    List<Book> findByTitleContaining(String title);

    int deleteByIsbn(String isbn);

    @Modifying
    @Query("update Book b set b.title = ?1 where b.isbn = ?2")
    int updateByIsbn(String title, String isbn);

    @Query("Select title from Book b where b.isbn = ?1")
    String fetchBookTitleByIsbn(String isbn);
}
