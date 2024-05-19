package bknd.backendbookshelf.service;

import bknd.backendbookshelf.exception.BookNotFoundException;
import bknd.backendbookshelf.model.Book;
import bknd.backendbookshelf.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class bookServiceImpl implements bookService{
    private final BookRepository bookRepository;

    public bookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getBooks() {

        return bookRepository.findAll();
    }

    @Override
    public Book getBook(Long id) {
        return bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(String.format("Book with this Id doesn't exist")));
    }


    @Override
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void deleteBook(Book book) {
        bookRepository.delete(book);
    }
}
