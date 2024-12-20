# Library Management System

This is Library Management System it has multiple departments and each departments has multiple books, but same book does not exist in another department.

## Built-In Reliability

+ **Exception Handling:** Ensures smooth operation by gracefully handling errors and providing meaningful feedback to users.
+ **Column Constraints and Patterns:** Enforces data integrity through predefined rules and validations.
+ **Logging:** Maintains detailed logs to track system activities and assist in debugging and monitoring.

## Features

+ **Book Entity:** Represent a book with attributes like title, author, ISBN, genre, publication year, Departments, and availability (boolean).
+ **Library Management:** Manage a collection of books in multiple departments.
+ **Add Book:** Adds a book to the library's Departments collection (check for duplicates based on ISBN)(addBook(Book book)).
+ **Remove Book:** Removes a book by ISBN (removeBook(String ISBN)).
+ **Find BookBy Title:** Returns a list of books matching the title (caseinsensitive search)(findBookByTitle(String title)).
+ **Find BookBy Author:** Returns a list of books by the author (caseinsensitive search)(findBookByAuthor(String author)).
+ **List All Books:** Returns a list of all books in the library(listAllBooks()).
+ **List Available Books():** Returns a list of available books(listAvailableBooks()).
+ **LibraryMenu:** (Optional) Create a simple text-based menu for library operations (add, remove, search, list, exit).

## Components

+ **Backend:** Java Spring Boot is used for building the backend APIs.
+ **Java Version:** Java JDK 17
+ **Spring Boot Version:** 3.4.0
+ **Database:** MySQL 8 is used as the database management system.
+ **Library Database:** Contains all the books.
+ **API Calls:** Postman is used for testing and interacting with the backend APIs.

## Usage

+ **Setup MySQL Database:** Set up MySQL and create one databases: Librarydb
+ **Run the Application:** Run the Java Spring Boot application to start the backend server.
+ **User Operations:** Use Postman or any REST client to interact with the backend APIs for library management system.

## Development Setup

+ **Clone the Repository:** Clone this repository to your local machine.
+ **Configure Database:** Set up MySQL and configure the database connection in the application properties file.
+ **Run the Application:** Run the Spring Boot application locally using your IDE or Maven command line.
+ **API Testing:** Use Postman to test the backend APIs for library management system.
