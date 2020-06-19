package com.lambdaschool.foundation.controllers;


import com.lambdaschool.foundation.models.Book;
import com.lambdaschool.foundation.models.User;
import com.lambdaschool.foundation.services.BookService;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BooksController {

    @Autowired
    BookService bookService;

//    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping(value = "/books",
            produces = {"application/json"})
    public ResponseEntity<?> listAllUsers()
    {
        List<Book> myBooks = bookService.findAllBooks();
        return new ResponseEntity<>(myBooks,
                HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @DeleteMapping(value = "/book/{bookid}")
    public ResponseEntity<?> deleteBookById(@PathVariable long id)
    {
        bookService.deleteBook(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
