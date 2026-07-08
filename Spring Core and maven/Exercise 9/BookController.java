public package com.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.library.entity.Book;
import com.library.repository.BookRepository;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookRepository repository;

    // Create
    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return repository.save(book);
    }

    // Read All
    @GetMapping
    public List<Book> getAllBooks() {
        return repository.findAll();
    }

    // Read by ID
    @GetMapping("/{id}")
    public Book getBook(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    // Update
    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id,
                           @RequestBody Book book) {

        book.setId(id);
        return repository.save(book);
    }

    // Delete
    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable Long id) {

        repository.deleteById(id);

        return "Book Deleted Successfully";
    }

} 
