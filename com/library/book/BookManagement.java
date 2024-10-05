package com.library.book;

public interface BookManagement {
    void addBook(Book book);

    void removeBook(Book book);

    Book searchBookByTitle(String title);
}
