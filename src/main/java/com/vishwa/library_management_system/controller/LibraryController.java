package com.vishwa.library_management_system.controller;

import com.vishwa.library_management_system.dto.BookDTO;
import com.vishwa.library_management_system.service.LibraryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/library")
public class LibraryController {

    @Autowired
    private LibraryService libraryService;

    @PostMapping("/add")
    public ResponseEntity<BookDTO> addBook(@Valid @RequestBody BookDTO bookDTO) {
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
//        if (books.isEmpty()) {
//            return ResponseEntity.noContent().build();
//        }
        return ResponseEntity.ok(books);
    }

    @GetMapping("/find/author/{author}")
    public ResponseEntity<List<BookDTO>> findBookByAuthor(@PathVariable String author) {
        List<BookDTO> books = libraryService.findBookByAuthor(author);
//        if (books.isEmpty()) {
//            return ResponseEntity.noContent().build();
//        }
        return ResponseEntity.ok(books);
    }

    @GetMapping("/list/all")
    public ResponseEntity<List<BookDTO>> listAllBooks() {
        List<BookDTO> books = libraryService.listAllBooks();
//        if (books.isEmpty()) {
//            return ResponseEntity.noContent().build();
//        }
        return ResponseEntity.ok(books);
    }

    @GetMapping("/list/available")
    public ResponseEntity<List<BookDTO>> listAvailableBooks(@RequestParam String data) {
        List<BookDTO> books = libraryService.listAvailableBooks(data);
//        if (books.isEmpty()) {
//            return ResponseEntity.noContent().build();
//        }
        return ResponseEntity.ok(books);
    }


    @GetMapping("sortWay")
    public ResponseEntity<List<BookDTO>> listAllSortedBooks(@RequestParam String sortingPram, @RequestParam boolean desOrAse){
        List<BookDTO> books = libraryService.listAllSortedBooks(sortingPram,desOrAse);
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping("pagination")
    public ResponseEntity<List<BookDTO>> paginationOfBooks(@RequestParam int pageNum, @RequestParam int numOfRecordsPerPage){
        List<BookDTO> books = libraryService.paginationOfBooks(pageNum-1,numOfRecordsPerPage);
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping("both")
    public ResponseEntity<List<BookDTO>> paginationOfBooksAndSortByParam(@RequestParam int pageNum, @RequestParam int numOfRecordsPerPage,
                                                                         @RequestParam String sortingPram, @RequestParam boolean desOrAse){
        List<BookDTO> books = libraryService.paginationOfBooksAndSortByParam(pageNum-1,numOfRecordsPerPage,sortingPram,desOrAse);
        return new ResponseEntity<>(books, HttpStatus.OK);
    }
}

