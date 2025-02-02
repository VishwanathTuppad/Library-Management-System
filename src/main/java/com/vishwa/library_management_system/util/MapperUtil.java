package com.vishwa.library_management_system.util;

import com.vishwa.library_management_system.dto.BookDTO;
import com.vishwa.library_management_system.entity.Book;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MapperUtil {

    // Convert Book entity to BookDTO
    public static BookDTO convertBookEntityToDto(Book book) {
        if (book == null) {
            return null;
        }
        BookDTO bookDTO = new BookDTO();
        bookDTO.setId(book.getId());
        bookDTO.setTitle(book.getTitle());
        bookDTO.setAuthor(book.getAuthor());
        bookDTO.setIsbn(book.getIsbn());
        bookDTO.setGenre(book.getGenre());
        bookDTO.setPublicationYear(book.getPublicationYear());
        bookDTO.setDepartment(book.getDepartment());
        bookDTO.setAvailability(book.getAvailability());
        return bookDTO;
    }

    // Convert Book entity to BookDTO
    public static List<BookDTO> convertBookEntityToDto(List<Book> books) {
        if (books == null || books.isEmpty()) {
            return Collections.emptyList();
        }
        return books.stream().map(book -> {
            BookDTO bookDTO = new BookDTO();
            bookDTO.setId(book.getId());
            bookDTO.setTitle(book.getTitle());
            bookDTO.setAuthor(book.getAuthor());
            bookDTO.setIsbn(book.getIsbn());
            bookDTO.setGenre(book.getGenre());
            bookDTO.setPublicationYear(book.getPublicationYear());
            bookDTO.setDepartment(book.getDepartment());
            bookDTO.setAvailability(book.getAvailability());
            return bookDTO;
        }).collect(Collectors.toList());
    }

    // Convert BookDTO to Book entity
    public static Book convertBookDtoToEntity(BookDTO bookDTO) {
        if (bookDTO == null) {
            return null;
        }
        Book book = new Book();
       // book.setId(bookDTO.getId());
        book.setTitle(bookDTO.getTitle());
        book.setAuthor(bookDTO.getAuthor());
        book.setIsbn(bookDTO.getIsbn());
        book.setGenre(bookDTO.getGenre());
        book.setPublicationYear(bookDTO.getPublicationYear());
        book.setDepartment(bookDTO.getDepartment());
        book.setAvailability(bookDTO.getAvailability());
        return book;
    }
}

