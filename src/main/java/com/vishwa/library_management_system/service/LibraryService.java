package com.vishwa.library_management_system.service;

import com.vishwa.library_management_system.dto.BookDTO;

import java.util.List;

public interface LibraryService {
    BookDTO addBook(BookDTO bookDTO);
    void removeBook(String isbn);
    List<BookDTO> findBookByTitle(String title);
    List<BookDTO> findBookByAuthor(String author);
    List<BookDTO> listAllBooks();
    List<BookDTO> listAvailableBooks();

}