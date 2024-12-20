package com.vishwa.library_management_system.repository;

import com.vishwa.library_management_system.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    Book findByIsbn(String isbn);
    List<Book> findByTitleIgnoreCase(String title);
    List<Book> findByAuthorIgnoreCase(String author);
    List<Book> findByAvailability(boolean b);

}

