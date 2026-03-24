package com.springframeworkd.spring6webapp.repositories;

import com.springframeworkd.spring6webapp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
