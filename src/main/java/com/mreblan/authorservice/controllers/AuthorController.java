package com.mreblan.authorservice.controllers;

import com.mreblan.authorservice.models.Author;
import com.mreblan.authorservice.service.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/authors")
public class AuthorController {

    private final AuthorService service;

    @GetMapping
    public List<Author> getAllAuthors() { return service.getAllAuthors(); }

    @GetMapping("/{id}")
    public Author getAuthorById(@PathVariable Long id) { return service.getAuthorById(id); }

    @PostMapping("/create_author")
    public String createAuthor(@RequestBody Author author) {
        service.saveAuthor(author);

        return "Author saved!";
    }

    @PutMapping("/{id}/update_author")
    public Author updateAuthor(@PathVariable Long id, @RequestBody Author author) { return service.updateAuthor(id, author); }

    @DeleteMapping("/{id}")
    public String deleteAuthorById(@PathVariable Long id) {
        service.deleteAuthorById(id);

        return "Author deleted!";
    }
}
