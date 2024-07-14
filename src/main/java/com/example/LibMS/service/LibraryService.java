package com.example.LibMS.service;

import com.example.LibMS.entity.Book;

import java.util.List;

public interface LibraryService {
    Book addBook(Book book);
    void removeBook(String isbn);
    List<Book> findBookByTitle(String title);
    List<Book> findBookByAuthor(String author);
    List<Book> listAllBooks();
    List<Book> listAvailableBooks();

}
