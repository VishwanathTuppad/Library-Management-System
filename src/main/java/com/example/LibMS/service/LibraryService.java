package com.example.LibMS.service;

import com.example.LibMS.dto.BookDTO;
import com.example.LibMS.entity.Book;

import java.util.List;

public interface LibraryService {
    BookDTO addBook(BookDTO bookDTO);
    void removeBook(String isbn);
    List<BookDTO> findBookByTitle(String title);
    List<BookDTO> findBookByAuthor(String author);
    List<BookDTO> listAllBooks();
    List<BookDTO> listAvailableBooks();

}
