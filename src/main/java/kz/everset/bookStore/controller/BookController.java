package kz.everset.bookStore.controller;

import kz.everset.bookStore.domain.Book;
import kz.everset.bookStore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("books")
public class BookController {
    @Autowired
    BookService bookService;

    @GetMapping
    public List<Book> getAllCategories(){
        return bookService.getAllBooks();
    }

    @GetMapping("{id}")
    public Book getBook(@RequestParam Long id){
        return bookService.getBook(id);
    }

    @PostMapping
    public Book addBook(@RequestBody Book book){
        return bookService.addBook(book);
    }

    @PutMapping("{id}")
    public void updateBook(@RequestBody Book book){
        bookService.updateBook(book);
    }

    @DeleteMapping("{id}")
    public void deleteBook(@RequestParam Long id){
        bookService.deleteBook(id);
    }
}
