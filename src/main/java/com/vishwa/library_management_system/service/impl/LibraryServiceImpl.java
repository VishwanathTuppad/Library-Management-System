package com.vishwa.library_management_system.service.impl;

import com.vishwa.library_management_system.dto.BookDTO;
import com.vishwa.library_management_system.entity.Book;
import com.vishwa.library_management_system.exception.NoDataFoundException;
import com.vishwa.library_management_system.repository.BookRepository;
import com.vishwa.library_management_system.service.LibraryService;
import com.vishwa.library_management_system.util.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Sort;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import java.util.List;

@Service
public class LibraryServiceImpl implements LibraryService {

    @Autowired
    private BookRepository bookRepository;

    public BookDTO addBook(BookDTO bookDTO) {
//        if (bookRepository.existsById(bookDTO.getId())) {
//            throw new BookExistsException("Book with ID " + bookDTO.getIsbn() + " already exists.");
//        }
        Book book=MapperUtil.convertBookDtoToEntity(bookDTO);
        return MapperUtil.convertBookEntityToDto(bookRepository.save(book));

    }

    public void removeBook(String isbn) {
        Book book = bookRepository.findByIsbn(isbn);
        if (book != null) {
            bookRepository.delete(book);
        } else {
            throw new NoDataFoundException("Book with ISBN " + isbn + " not found.");
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

    public List<BookDTO> listAvailableBooks(String data ) {
        List<Book> books = bookRepository.findByAvailability(data);
        if (books.isEmpty()) {
            throw new NoDataFoundException("No available books found in the library.");
        }
        return MapperUtil.convertBookEntityToDto(books);
    }

    @Override
    public List<BookDTO> listAllSortedBooks(String sortingByGenre, boolean desOrAse) {
        Direction direction= desOrAse? Direction.DESC: Direction.ASC;
        Sort sort= Sort.by(direction,sortingByGenre);
        List<Book> books= bookRepository.findAll(sort);
        return MapperUtil.convertBookEntityToDto(books);
       // return List.of();
    }

    @Override
    public List<BookDTO> paginationOfBooks(int pageNum, int numOfRecordsPerPage) {
        Pageable pageable= PageRequest.of(pageNum,numOfRecordsPerPage);
        List<Book> books= bookRepository.findAll(pageable).toList();
        return MapperUtil.convertBookEntityToDto(books);
    }

    @Override
    public List<BookDTO> paginationOfBooksAndSortByParam(int pageNum, int numOfRecordsPerPage, String sortingPram, boolean desOrAse) {
        Direction direction= desOrAse? Direction.DESC: Direction.ASC;
        Sort sort= Sort.by(direction,sortingPram);
        Pageable pageable= PageRequest.of(pageNum,numOfRecordsPerPage,sort);
        List<Book> books= bookRepository.findAll(pageable).toList();
        return MapperUtil.convertBookEntityToDto(books);
    }
}

