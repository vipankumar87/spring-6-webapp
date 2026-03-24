package com.springframeworkd.spring6webapp.services;

import com.springframeworkd.spring6webapp.domain.Author;

public interface AuthorService {
    Iterable<Author> findAll();
}
