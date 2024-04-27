package kz.everset.bookStore.service.impl;

import kz.everset.bookStore.domain.Author;
import kz.everset.bookStore.repo.AuthorRepository;
import kz.everset.bookStore.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    private AuthorRepository authorRepository;
    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public Author getAuthor(Long id) {
        return authorRepository.findById(id).orElseThrow(() -> new NoSuchElementException("No such author_id"));
    }

    @Override
    public Author addAuthor(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public void updateAuthor(Author author) {
        Author oldAuthor = getAuthor(author.getId());
        if (author.getBiography() != null){
            oldAuthor.setBiography(author.getBiography());
        }
        if (author.getName() != null){
            oldAuthor.setName(author.getName());
        }
        authorRepository.save(oldAuthor);
    }

    @Override
    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }
}
