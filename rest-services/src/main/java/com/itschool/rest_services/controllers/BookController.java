package com.itschool.rest_services.controllers;

import com.itschool.rest_services.models.Book;
import com.itschool.rest_services.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/books")
public class BookController {

    @Autowired
    private BookService service;

    @GetMapping
    public ResponseEntity<List<Book>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{title}")
    public ResponseEntity<Book> getBookByTitle(@PathVariable String title) {
        Book book = service.getBookByTitle(title);

        if (book == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(book);
    }

    @PostMapping
    public ResponseEntity<Book> saveBook(@RequestBody Book book) {
        return ResponseEntity.ok(service.addBook(book));
    }

    @DeleteMapping("/{title}")
    public ResponseEntity<Void> deleteBook(@PathVariable String title) {
        service.deleteBook(title);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{title}/borrow")
    public ResponseEntity<Book> borrowBook(@PathVariable String title) {
        Book book = service.borrowBook(title);
        if (book == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(book);
    }

    @PutMapping("/{title}/return")
    public ResponseEntity<Book> returnBook(@PathVariable String title) {
        Book book = service.returnBook(title);
        if (book == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(book);
    }


}
