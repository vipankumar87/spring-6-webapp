package com.springframeworkd.spring6webapp.services;

import com.springframeworkd.spring6webapp.domain.Book;

public interface BookService {
    Iterable<Book> findAll();
}
