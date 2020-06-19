package com.lambdaschool.foundation.repository;

import com.lambdaschool.foundation.models.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepo extends CrudRepository<Book, Long> {}
