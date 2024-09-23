package com.mreblan.authorservice.service.impl;

import com.mreblan.authorservice.models.Author;
import com.mreblan.authorservice.repository.AuthorsRepository;
import com.mreblan.authorservice.service.AuthorService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@AllArgsConstructor
@Service
public class AuthorServiceImpl implements AuthorService {

    private AuthorsRepository repository;

    @Override
    public List<Author> getAllAuthors() {
        String logMessage = "All authors returned";
        log.info(logMessage);

        return repository.findAll();
    }

    @Override
    public Author getAuthorById(Long id) {
        String logMessage = String.format("Author with id -- %d -- returned", id);
        log.info(logMessage);

        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Author with id -- " + id + " -- not found"));
    }

    @Override
    public Author saveAuthor(Author author) {
        String logMessage = String.format("Author saved:\n%s", author.toString());
        log.info(logMessage);

        return repository.save(author);

    }

    @Override
    public Author updateAuthor(Long id, Author author) {
        Author existingAuthor = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Author with id -- " + id + " -- not found"));

        existingAuthor.setFirstName(author.getFirstName());
        existingAuthor.setLastName(author.getLastName());
        existingAuthor.setUsername(author.getUsername());
        existingAuthor.setEmail(author.getEmail());
        existingAuthor.setPassword(author.getPassword());

        String logMessage = String.format("Author update:\n%s", author.toString());
        log.info(logMessage);

        return repository.save(existingAuthor);
    }

    @Override
    public void deleteAuthorById(Long id) {
        String logMessage = String.format("Author with id -- %d -- deleted", id);
        log.info(logMessage);

        repository.deleteById(id);
    }
}
