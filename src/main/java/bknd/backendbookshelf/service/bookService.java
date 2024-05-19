package bknd.backendbookshelf.service;

import bknd.backendbookshelf.model.Book;

import java.util.List;
import java.util.Optional;

public interface bookService {
    List<Book> getBooks();
    Book getBook(Long id);
    Book saveBook(Book book);
    void deleteBook(Book book);
}
