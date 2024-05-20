package bknd.backendbookshelf.service;

import bknd.backendbookshelf.exception.BookNotFoundException;
import bknd.backendbookshelf.model.Book;
import bknd.backendbookshelf.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class bookServiceImpl implements bookService{ //сервис книги, имплементация CRUD
    private final BookRepository bookRepository;

    public bookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getBooks() { //поиск всех книг

        return bookRepository.findAll();
    }

    @Override
    public Book getBook(Long id) { //поиск одной книги с возможностью появления исключения
        return bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(String.format("Book with this Id doesn't exist")));
    }


    @Override
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    } //сохранение книги

    @Override
    public void deleteBook(Book book) {
        bookRepository.delete(book);
    } //удаление книги
}
