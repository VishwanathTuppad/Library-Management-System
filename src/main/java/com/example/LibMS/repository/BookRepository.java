package com.example.LibMS.repository;

import com.example.LibMS.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByAvailability(boolean b);

    List<Book> findByAuthorIgnoreCase(String author);

    List<Book> findByTitleIgnoreCase(String title);

    Book findByIsbn(String isbn);
}

