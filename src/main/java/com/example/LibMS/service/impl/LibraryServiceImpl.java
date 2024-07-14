package com.example.LibMS.service.impl;

import com.example.LibMS.entity.Book;
import com.example.LibMS.exception.NoDataFoundException;
import com.example.LibMS.repository.BookRepository;
import com.example.LibMS.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryServiceImpl implements LibraryService {

    @Autowired
    private BookRepository bookRepository;

    public Book addBook(Book book) {
        if (bookRepository.existsById(book.getId())) {
            throw new RuntimeException("Book with ISBN " + book.getIsbn() + " already exists.");
        }
        return bookRepository.save(book);
    }

    public void removeBook(String isbn) {
        Book book = bookRepository.findByIsbn(isbn);
        if (book != null) {
            bookRepository.delete(book);
        } else {
            throw new RuntimeException("Book with ISBN " + isbn + " not found.");
        }
    }

    public List<Book> findBookByTitle(String title) {
        List<Book> books = bookRepository.findByTitleIgnoreCase(title);
        if (books.isEmpty()) {
            throw new NoDataFoundException("No books found with title: " + title);
        }
        return books;
    }

    public List<Book> findBookByAuthor(String author) {
        List<Book> books = bookRepository.findByAuthorIgnoreCase(author);
        if (books.isEmpty()) {
            throw new NoDataFoundException("No books found by author: " + author);
        }
        return books;
    }

    public List<Book> listAllBooks() {
        List<Book> books = bookRepository.findAll();
        if (books.isEmpty()) {
            throw new NoDataFoundException("No books found in the library.");
        }
        return books;
    }

    public List<Book> listAvailableBooks() {
        List<Book> books = bookRepository.findByAvailability(true);
        if (books.isEmpty()) {
            throw new NoDataFoundException("No available books found in the library.");
        }
        return books;
    }
}

