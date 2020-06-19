package com.lambdaschool.foundation.services;


import com.lambdaschool.foundation.models.Author;

import java.util.List;


public interface AuthorService {

    Author addAuthor(Author newAthor);
    List<Author> findAllAuthors();
    Author findAuthorById(long id);
    Author updateAuthor(long id, Author newInfo);
    void deleteAuthor(long id);

}
