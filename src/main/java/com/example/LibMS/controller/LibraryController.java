package com.example.LibMS.controller;

import com.example.LibMS.dto.BookDTO;
import com.example.LibMS.entity.Book;
import com.example.LibMS.service.LibraryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/library")
public class LibraryController {

    @Autowired
    private LibraryService libraryService;

    @PostMapping("/add")
    public ResponseEntity<BookDTO> addBook(@Validated @RequestBody BookDTO bookDTO) {
        BookDTO addedBook = libraryService.addBook(bookDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedBook);
    }

    @DeleteMapping("/remove/{isbn}")
    public ResponseEntity<Void> removeBook(@PathVariable String isbn) {
        libraryService.removeBook(isbn);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/find/title/{title}")
    public ResponseEntity<List<BookDTO>> findBookByTitle(@PathVariable String title) {
        List<BookDTO> books = libraryService.findBookByTitle(title);
        if (books.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(books);
    }

    @GetMapping("/find/author/{author}")
    public ResponseEntity<List<BookDTO>> findBookByAuthor(@PathVariable String author) {
        List<BookDTO> books = libraryService.findBookByAuthor(author);
        if (books.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(books);
    }

    @GetMapping("/list/all")
    public ResponseEntity<List<BookDTO>> listAllBooks() {
        List<BookDTO> books = libraryService.listAllBooks();
        if (books.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(books);
    }

    @GetMapping("/list/available")
    public ResponseEntity<List<BookDTO>> listAvailableBooks() {
        List<BookDTO> books = libraryService.listAvailableBooks();
        if (books.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(books);
    }
}

