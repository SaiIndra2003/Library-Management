package com.library.book;

import java.util.ArrayList;
import java.util.List;

public class BookManager implements BookManagement {
    private final List<Book> books;

    public BookManager() {
        this.books = new ArrayList<>();
    }

    @Override
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Added com.library.book.Book: " + book.getTitle());
    }

    @Override
    public void removeBook(Book book) {
        books.remove(book);
        System.out.println("Removed com.library.book.Book: " + book.getTitle());
    }

    @Override
    public Book searchBookByTitle(String title) {
        return books.stream().filter(book -> book.getTitle().equalsIgnoreCase(title)).findFirst().orElse(null);
    }
}
