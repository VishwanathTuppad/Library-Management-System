package com.vishwa.library_management_system.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {

    //@NotNull(message = "Book ID cannot be null")
    private Long id;

    @NotBlank(message = "Title cannot be blank")
    @Size(min = 2, max = 100, message = "Title must be between 2 and 100 characters")
    private String title;

    @NotBlank(message = "Author cannot be blank")
    @Size(min = 2, max = 50, message = "Author must be between 2 and 50 characters")
    private String author;

    @NotBlank(message = "ISBN cannot be blank")
    @Pattern(
            regexp = "\\d{13}|\\d{10}",
            message = "ISBN must be a valid 10 or 13-digit number"
    )
    private String isbn;

    @NotBlank(message = "Genre cannot be blank")
    @Size(min = 3, max = 30, message = "Genre must be between 3 and 30 characters")
    private String genre;

    @Positive(message = "Publication year must be a positive number")
    private int publicationYear;

    @NotBlank(message = "Department cannot be blank")
    @Size(min = 2, max = 50, message = "Department must be between 2 and 50 characters")
    private String department;

    private String availability;

    // Getters and Setters
}

