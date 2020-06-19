package com.lambdaschool.foundation.services;

import com.lambdaschool.foundation.models.Book;
import com.lambdaschool.foundation.models.Section;

import java.util.List;

public interface BookService {

    // CRUD Operation Function Initialization goes here:
    // Create
    Book createNew(Book newBook);

    // Read

    //Find By Section ID
    Book findBookById(long id);


    // Find All Books
    List<Book> findAllBooks();

    // Update
    Book updateBook(long id, Book updateInfo);

    // Delete
    void deleteBook(long id);
}
