package com.library.controller;

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

    // Create a Book
    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return repository.save(book);
    }

    // Get All Books
    @GetMapping
    public List<Book> getAllBooks() {
        return repository.findAll();
    }

    // Get Book by ID
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Integer id) {
        return repository.findById(id).orElse(null);
    }

    // Update Book
    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Integer id,
                           @RequestBody Book book) {

        book.setId(id);
        return repository.save(book);
    }

    // Delete Book
    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable Integer id) {

        repository.deleteById(id);

        return "Book Deleted Successfully";
    }
}