# Library-Management-System
Implement Library Management System
A library has multiple departments and each departments has multiple books, but same book 
does not exist in another department
You need to develop a Library Management system and Leadership Board.
Requirements:
• Classes:
1. Book: Represent a book with attributes like title, author, ISBN, genre, publication year, 
Departments, and availability (boolean). Implement appropriate getters and setters.
2. Library: Manage a collection of books in multiple departments. It should include 
methods:
3. addBook(Book book): Adds a book to the library's Departments collection (check for 
duplicates based on ISBN).
4. removeBook(String ISBN): Removes a book by ISBN.
5. findBookByTitle(String title): Returns a list of books matching the title (caseinsensitive search).
6. findBookByAuthor(String author): Returns a list of books by the author (caseinsensitive search).
7. listAllBooks(): Returns a list of all books in the library.
8. listAvailableBooks(): Returns a list of available books.
9. LibraryMenu: (Optional) Create a simple text-based menu for library operations (add, 
remove, search, list, exit).

• Unit Tests:
Write unit tests for all methods in the Book and Library classes using a testing framework 
like JUnit (encouraged). This demonstrates the candidate's understanding of test-driven 
development (TDD) principles.
