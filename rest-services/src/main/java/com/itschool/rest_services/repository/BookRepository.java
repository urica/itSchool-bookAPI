package com.itschool.rest_services.repository;

import com.itschool.rest_services.models.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BookRepository {
    private Map<String, Book> books = new HashMap<>();

    public List<Book> findAll() {
        return new ArrayList<>(books.values());
    }

    public Book findByTitle(String title) {
        return books.get(title);
    }

    public Book save(Book book) {
        books.put(book.getTitle(), book);
        return book;
    }

    public void deleteByTitle(String title) {
        books.remove(title);
    }
}
