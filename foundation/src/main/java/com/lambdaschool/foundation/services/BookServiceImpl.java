package com.lambdaschool.foundation.services;

import com.lambdaschool.foundation.exceptions.ResourceNotFoundException;
import com.lambdaschool.foundation.models.Book;
import com.lambdaschool.foundation.models.Section;
import com.lambdaschool.foundation.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "bookService")
public class BookServiceImpl implements BookService{

    @Autowired
    BookRepo bookrepo;


    @Override
    public Book createNew(Book newBook) {
        Book book = new Book();
        book.setBooktitle(newBook.getBooktitle());
        book.setCopy(newBook.getCopy());
        book.setIsbn(newBook.getIsbn());
        bookrepo.save(book);
        return book;
    }

    @Override
    public Book findBookById(long id){

        return bookrepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book id " + id + " not found!"));
    }

    @Override
    public List<Book> findAllBooks() {

        List<Book> books = new ArrayList<>();
        bookrepo.findAll().iterator().forEachRemaining(books::add);
        return books;
    }

    @Override
    public Book updateBook(long id, Book updateInfo) {
        Book book = findBookById(id);
        if(book.getBooktitle() != null){
            book.setBooktitle(updateInfo.getBooktitle());
        }
        if(book.getCopy() != 0){
            book.setCopy(updateInfo.getCopy());
        }
        if(book.getIsbn() != null){
            book.setIsbn(updateInfo.getIsbn());
        }

        return book;
    }

    @Override
    public void deleteBook(long id) {
        Book book = findBookById(id);
        bookrepo.delete(book);
    }
}
