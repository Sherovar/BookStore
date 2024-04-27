package kz.everset.bookStore.service.impl;

import kz.everset.bookStore.domain.Book;
import kz.everset.bookStore.domain.Category;
import kz.everset.bookStore.repo.BookRepository;
import kz.everset.bookStore.service.AuthorService;
import kz.everset.bookStore.service.BookService;
import kz.everset.bookStore.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;


@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorService authorService;
    @Autowired
    private CategoryService categoryService;

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBook(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("No such book_id"));
    }

    @Override
    public Book addBook(Book book) {
        book.setAuthor(authorService.getAuthor(book.getAuthor().getId()));
        book.setCategory(categoryService.getCategory(book.getCategory().getId()));
        return bookRepository.save(book);
    }

    @Override
    public void updateBook(Book book) {
        Book oldBook = getBook(book.getId());
        if (book.getAuthor() != null) {
            oldBook.setAuthor(book.getAuthor());
        }
        if (book.getIsbn() != null){
            oldBook.setIsbn(book.getIsbn());
        }
        if (book.getPrice() != null){
            oldBook.setPrice(book.getPrice());
        }
        if (book.getTitle() != null){
            oldBook.setTitle(book.getTitle());
        }
        if (book.getAuthor() != null){
            oldBook.setAuthor(authorService.getAuthor(book.getAuthor().getId()));
        }
        if (book.getCategory() != null){
            oldBook.setCategory(categoryService.getCategory(book.getCategory().getId()));
        }
        bookRepository.save(oldBook);
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}
