package com.example.LibMS.service.impl;

import com.example.LibMS.entity.Book;
import com.example.LibMS.repository.BookRepository;
import com.example.LibMS.service.impl.LibraryServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class LibraryServiceImplTest {

    @InjectMocks
    private LibraryServiceImpl libraryService;

    @Mock
    private BookRepository bookRepository;

    private Book book;

    @BeforeEach
    void setUp() {
        book = new Book(1L, "Test Title", "Test Author", "123456", "Fiction", 2020, "Dept1", true);
    }

    @Test
    void addBook() {
        when(bookRepository.save(book)).thenReturn(book);
        Book savedBook = libraryService.addBook(book);
        assertNotNull(savedBook);
        assertEquals(book.getIsbn(), savedBook.getIsbn());
        verify(bookRepository, times(1)).save(book);
    }

    @Test
    void removeBook() {
        when(bookRepository.findByIsbn(book.getIsbn())).thenReturn(book);
        doNothing().when(bookRepository).delete(book);
        libraryService.removeBook(book.getIsbn());
        verify(bookRepository, times(1)).delete(book);
    }

    @Test
    void findBookByTitle() {
        when(bookRepository.findByTitleIgnoreCase("Test Title")).thenReturn(Arrays.asList(book));
        List<Book> books = libraryService.findBookByTitle("Test Title");
        assertEquals(1, books.size());
        assertEquals(book.getTitle(), books.get(0).getTitle());
        verify(bookRepository, times(1)).findByTitleIgnoreCase("Test Title");
    }

    @Test
    void findBookByAuthor() {
        when(bookRepository.findByAuthorIgnoreCase("Test Author")).thenReturn(Arrays.asList(book));
        List<Book> books = libraryService.findBookByAuthor("Test Author");
        assertEquals(1, books.size());
        assertEquals(book.getAuthor(), books.get(0).getAuthor());
        verify(bookRepository, times(1)).findByAuthorIgnoreCase("Test Author");
    }

    @Test
    void listAllBooks() {
        when(bookRepository.findAll()).thenReturn(Arrays.asList(book));
        List<Book> books = libraryService.listAllBooks();
        assertEquals(1, books.size());
        verify(bookRepository, times(1)).findAll();
    }

    @Test
    void listAvailableBooks() {
        when(bookRepository.findByAvailability(true)).thenReturn(Arrays.asList(book));
        List<Book> books = libraryService.listAvailableBooks();
        assertEquals(1, books.size());
        verify(bookRepository, times(1)).findByAvailability(true);
    }
}

