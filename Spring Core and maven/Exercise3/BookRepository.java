package com.library.repository;

public class BookRepository {

    public void getBookDetails() {

        System.out.println("Fetching book details from repository...");

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
