package com.example.LibMS.controller;

import com.example.LibMS.entity.Book;
import com.example.LibMS.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/library")
public class LibraryController {

    @Autowired
    private LibraryService libraryService;

    @PostMapping("/add")
    public Book addBook(@RequestBody Book book) {
        return libraryService.addBook(book);
    }

    @DeleteMapping("/remove/{isbn}")
    public void removeBook(@PathVariable String isbn) {
        libraryService.removeBook(isbn);
    }

    @GetMapping("/find/title/{title}")
    public List<Book> findBookByTitle(@PathVariable String title) {
        return libraryService.findBookByTitle(title);
    }

    @GetMapping("/find/author/{author}")
    public List<Book> findBookByAuthor(@PathVariable String author) {
        return libraryService.findBookByAuthor(author);
    }

    @GetMapping("/list/all")
    public List<Book> listAllBooks() {
        return libraryService.listAllBooks();
    }

    @GetMapping("/list/available")
    public List<Book> listAvailableBooks() {
        return libraryService.listAvailableBooks();
    }
}

