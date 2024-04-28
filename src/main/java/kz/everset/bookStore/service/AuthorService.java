package kz.everset.bookStore.service;

import kz.everset.bookStore.domain.Author;

import java.util.List;

public interface AuthorService {
    List<Author> getAllAuthors();
    Author getAuthor(Long id);
    Author addAuthor(Author author);
    void updateAuthor(Author author);
    void deleteAuthor(Long id);

}
