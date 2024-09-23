package com.mreblan.authorservice.service;

import com.mreblan.authorservice.models.Author;

import java.util.List;

public interface AuthorService {

    List<Author> getAllAuthors();

    Author       getAuthorById(Long id);

    Author       saveAuthor(Author author);

    Author       updateAuthor(Long id, Author author);

    void         deleteAuthorById(Long id);


}
