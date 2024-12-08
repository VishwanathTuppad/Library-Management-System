//package com.example.LibMS.controller;
//
//import com.example.LibMS.entity.Book;
//import com.example.LibMS.service.LibraryService;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.Mockito;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//import java.util.Arrays;
//
//import static org.mockito.Mockito.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//@ExtendWith(MockitoExtension.class)
//@WebMvcTest(LibraryController.class)
//class LibraryControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private LibraryService libraryService;
//
//    private Book book;
//
//    @BeforeEach
//    void setUp() {
//        book = new Book(1L, "Test Title", "Test Author", "123456", "Fiction", 2020, "Dept1", true);
//    }
//
//    @Test
//    void addBook() throws Exception {
//        when(libraryService.addBook(any(Book.class))).thenReturn(book);
//
//        mockMvc.perform(MockMvcRequestBuilders.post("/api/library/add")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content("{\"title\":\"Test Title\",\"author\":\"Test Author\",\"isbn\":\"123456\",\"genre\":\"Fiction\",\"publicationYear\":2020,\"department\":\"Dept1\",\"availability\":true}"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.title").value("Test Title"))
//                .andExpect(jsonPath("$.author").value("Test Author"))
//                .andExpect(jsonPath("$.isbn").value("123456"))
//                .andExpect(jsonPath("$.genre").value("Fiction"));
//
//        verify(libraryService, times(1)).addBook(any(Book.class));
//    }
//
//    @Test
//    void removeBook() throws Exception {
//        doNothing().when(libraryService).removeBook(book.getIsbn());
//
//        mockMvc.perform(MockMvcRequestBuilders.delete("/api/library/remove/{isbn}", book.getIsbn()))
//                .andExpect(status().isOk());
//
//        verify(libraryService, times(1)).removeBook(book.getIsbn());
//    }
//
//    @Test
//    void findBookByTitle() throws Exception {
//        when(libraryService.findBookByTitle("Test Title")).thenReturn(Arrays.asList(book));
//
//        mockMvc.perform(MockMvcRequestBuilders.get("/api/library/find/title/{title}", "Test Title")
//                        .accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$[0].title").value("Test Title"));
//
//        verify(libraryService, times(1)).findBookByTitle("Test Title");
//    }
//
//    @Test
//    void findBookByAuthor() throws Exception {
//        when(libraryService.findBookByAuthor("Test Author")).thenReturn(Arrays.asList(book));
//
//        mockMvc.perform(MockMvcRequestBuilders.get("/api/library/find/author/{author}", "Test Author")
//                        .accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$[0].author").value("Test Author"));
//
//        verify(libraryService, times(1)).findBookByAuthor("Test Author");
//    }
//
//    @Test
//    void listAllBooks() throws Exception {
//        when(libraryService.listAllBooks()).thenReturn(Arrays.asList(book));
//
//        mockMvc.perform(MockMvcRequestBuilders.get("/api/library/list/all")
//                        .accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$[0].title").value("Test Title"));
//
//        verify(libraryService, times(1)).listAllBooks();
//    }
//
//    @Test
//    void listAvailableBooks() throws Exception {
//        when(libraryService.listAvailableBooks()).thenReturn(Arrays.asList(book));
//
//        mockMvc.perform(MockMvcRequestBuilders.get("/api/library/list/available")
//                        .accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$[0].title").value("Test Title"));
//
//        verify(libraryService, times(1)).listAvailableBooks();
//    }
//}
//
