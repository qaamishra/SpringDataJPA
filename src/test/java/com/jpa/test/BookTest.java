package com.jpa.test;

import com.jpa.Application;
import com.jpa.entity.Book;
import com.jpa.service.BookService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest(classes = Application.class)
@RunWith(SpringRunner.class)
public class BookTest {

    @Autowired
    BookService bookService;

    @Test
    public void Scenario1() {

        //Create Book
        List<Book> books = new ArrayList<Book>();
        books.add(new Book(651L, "BookA", "5689501"));
        books.add(new Book(652L, "BookB", "5689502"));
        books.add(new Book(653L, "BookC", "5689503"));
        bookService.createBook(books);

        //Fetch -delete and fetch the same to see if deleted
        System.out.println("\nBook Object After Creation :\n"+bookService.fetchBookByIsbn("5689501").toString());
        Assert.assertEquals(1, bookService.deleteBookByIsbn("5689501"));
        Assert.assertNull(null, bookService.fetchBookByIsbn("5689501"));

        //Update and verify
        bookService.updateByIsbn("hello", "5689502");
        System.out.println("\nBook Object after update :\n");
        System.out.println(bookService.fetchBookByIsbn("5689502").toString());

        System.out.println("\n\nGet Title :" + bookService.fetchBookTitleByIsbn("5689502"));
        Assert.assertEquals("hello", bookService.fetchBookTitleByIsbn("5689502"));


    }
}
