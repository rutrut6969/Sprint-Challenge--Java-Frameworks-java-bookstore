package com.lambdaschool.foundation.services;

import com.lambdaschool.foundation.exceptions.ResourceNotFoundException;
import com.lambdaschool.foundation.models.Author;
import com.lambdaschool.foundation.repository.AuthorRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class AuthorServiceImpl implements AuthorService{

    @Autowired
    AuthorRepo authRepo;

    @Override
    public Author addAuthor(Author newAuthor) {
        Author author = new Author();

        author.setFirstname(newAuthor.getFirstname());
        author.setLastname(newAuthor.getLastname());

        authRepo.save(author);
        return author;

    }

    @Override
    public List<Author> findAllAuthors() {
        List<Author> found = new ArrayList<>();
        authRepo.findAll().iterator().forEachRemaining(found::add);
        return found;
    }

    @Override
    public Author findAuthorById(long id) {
        Author found = authRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Author id " + id + " not found!"));
        return found;
    }

    @Override
    public Author updateAuthor(long id, Author newInfo) {
        Author found = findAuthorById(id);
        found.setLastname(newInfo.getLastname());
        found.setFirstname(newInfo.getFirstname());
        authRepo.save(found);
        return found;
    }

    @Override
    public void deleteAuthor(long id) {
        Author found = findAuthorById(id);
        authRepo.delete(found);
    }
}
