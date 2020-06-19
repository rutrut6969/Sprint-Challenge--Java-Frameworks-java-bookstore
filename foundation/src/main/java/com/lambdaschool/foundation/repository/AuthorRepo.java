package com.lambdaschool.foundation.repository;

import com.lambdaschool.foundation.models.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepo extends CrudRepository<Author, Long> {}
