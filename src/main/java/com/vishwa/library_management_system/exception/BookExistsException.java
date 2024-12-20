package com.vishwa.library_management_system.exception;

public class BookExistsException extends RuntimeException{
    public BookExistsException(String message) {
        super(message);
    }
}
