package com.springframeworkd.spring6webapp.services;

import com.springframeworkd.spring6webapp.domain.Author;
import com.springframeworkd.spring6webapp.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }
    @Override
    public Iterable<Author> findAll() {
        return this.authorRepository.findAll();
    }
}
