package kz.everset.bookStore.controller;

import kz.everset.bookStore.domain.Author;
import kz.everset.bookStore.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {
    @Autowired
    AuthorService authorService;
    @GetMapping
    public List<Author> getAllAuthors(){
        return authorService.getAllAuthors();
    }

    @GetMapping("/{id}")
    public Author getAuthor(@RequestParam Long id){
        return authorService.getAuthor(id);
    }

    @PostMapping
    public Author addAuthor(@RequestBody Author author){
        return authorService.addAuthor(author);
    }

    @PutMapping("/{id}")
    public void updateAuthor(@RequestBody Author author){
        authorService.updateAuthor(author);
    }

    @DeleteMapping("/{id}")
    public void deleteAuthor(@RequestParam Long id){
        authorService.deleteAuthor(id);
    }

}
