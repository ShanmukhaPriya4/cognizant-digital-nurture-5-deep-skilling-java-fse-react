package com.library.service;

import com.library.repository.BookRepository;

public class BookService {

    private BookRepository bookRepository;

    // Constructor Injection
    public BookService(BookRepository bookRepository) {
        System.out.println("Constructor Injection Executed");
        this.bookRepository = bookRepository;
    }

    // Setter Injection
    public void setBookRepository(BookRepository bookRepository) {
        System.out.println("Setter Injection Executed");
        this.bookRepository = bookRepository;
    }

    public void displayBook() {
        System.out.println("BookService is running...");
        bookRepository.getBookDetails();
    }

}
