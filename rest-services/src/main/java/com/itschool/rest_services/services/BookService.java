package com.itschool.rest_services.services;

import com.itschool.rest_services.models.Book;
import com.itschool.rest_services.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository repository;

    public List<Book> findAll() {
        return repository.findAll();
    }

    public Book getBookByTitle(String title) {
        return repository.findByTitle(title);
    }

    public Book addBook(Book book) {
        return repository.save(book);
    }

    public void deleteBook(String title) {
        repository.deleteByTitle(title);
    }

    public Book borrowBook(String title) {
        Book book = repository.findByTitle(title);

        if (book != null && !book.isBorrowed()) {
            book.setBorrowed(true);
            return book;
        }

        return null;
    }

    public Book returnBook(String title) {
        Book book = repository.findByTitle(title);

        if (book != null && book.isBorrowed()) {
            book.setBorrowed(false);
            return book;
        }

        return null;
    }
}
