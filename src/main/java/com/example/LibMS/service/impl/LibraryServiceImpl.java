package com.example.LibMS.service.impl;

import com.example.LibMS.dto.BookDTO;
import com.example.LibMS.entity.Book;
import com.example.LibMS.exception.NoDataFoundException;
import com.example.LibMS.repository.BookRepository;
import com.example.LibMS.service.LibraryService;
import com.example.LibMS.util.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryServiceImpl implements LibraryService {

    @Autowired
    private BookRepository bookRepository;

    public BookDTO addBook(BookDTO bookDTO) {
        if (bookRepository.existsById(bookDTO.getId())) {
            throw new RuntimeException("Book with ISBN " + bookDTO.getIsbn() + " already exists.");
        }
        Book book=MapperUtil.convertBookDtoToEntity(bookDTO);
        return MapperUtil.convertBookEntityToDto(bookRepository.save(book));

    }

    public void removeBook(String isbn) {
        Book book = bookRepository.findByIsbn(isbn);
        if (book != null) {
            bookRepository.delete(book);
        } else {
            throw new RuntimeException("Book with ISBN " + isbn + " not found.");
        }
    }

    public List<BookDTO> findBookByTitle(String title) {
        List<Book> books = bookRepository.findByTitleIgnoreCase(title);
        if (books.isEmpty()) {
            throw new NoDataFoundException("No books found with title: " + title);
        }
        return MapperUtil.convertBookEntityToDto(books);

    }

    public List<BookDTO> findBookByAuthor(String author) {
        List<Book> books = bookRepository.findByAuthorIgnoreCase(author);
        if (books.isEmpty()) {
            throw new NoDataFoundException("No books found by author: " + author);
        }
        return MapperUtil.convertBookEntityToDto(books);
    }

    public List<BookDTO> listAllBooks() {
        List<Book> books = bookRepository.findAll();
        if (books.isEmpty()) {
            throw new NoDataFoundException("No books found in the library.");
        }
        return MapperUtil.convertBookEntityToDto(books);
    }

    public List<BookDTO> listAvailableBooks() {
        List<Book> books = bookRepository.findByAvailability(true);
        if (books.isEmpty()) {
            throw new NoDataFoundException("No available books found in the library.");
        }
        return MapperUtil.convertBookEntityToDto(books);
    }
}

