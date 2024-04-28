package kz.everset.bookStore.service;

import kz.everset.bookStore.domain.Book;
import kz.everset.bookStore.domain.Book;

import java.util.List;

public interface BookService {
    List<Book> getAllBooks();
    Book getBook(Long id);
    Book addBook(Book book);
    void updateBook(Book book);
    void deleteBook(Long id);
}
