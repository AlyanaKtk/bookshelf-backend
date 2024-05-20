package bknd.backendbookshelf.controller;

import bknd.backendbookshelf.dto.bookDTO;
import bknd.backendbookshelf.model.Book;
import bknd.backendbookshelf.service.bookService;
import bknd.backendbookshelf.utils.mapBook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/books")
public class BookController {

    private final bookService bookservice;
    private final mapBook mapBooker;
    public BookController(bookService bookservice, mapBook mapBooker) {
        this.bookservice = bookservice;
        this.mapBooker = mapBooker;

    }
    @GetMapping("/") //READ
    @ResponseBody
    public List<bookDTO> getAllBooks()
    {
        List<Book> books = bookservice.getBooks();

        return books.stream().map(mapBooker::toDTO).collect(Collectors.toList());
    }
    @GetMapping("/{book_id}") //READ
    @ResponseBody
    public bookDTO getBook(@PathVariable(name = "book_id") Long id)
    {
        Book book = bookservice.getBook(id);
        return mapBooker.toDTO(book);
    }

    @PostMapping("/") //CREATE
    @ResponseBody
    public bookDTO createBook(@RequestBody bookDTO bookdto)
    {
        Book book = mapBooker.toBook(bookdto);
        return mapBooker.toDTO(bookservice.saveBook(book));
    }
    @PutMapping("/{book_id}") //UPDATE
    @ResponseBody
    public bookDTO updateBook(@PathVariable(name = "book_id") Long id, @RequestBody Book book)
    {
        Book book2 = bookservice.getBook(id);
        book2.setTitle(book.getTitle());
        book2.setAuthor(book.getAuthor());
        book2.setRating(book.getRating());
        book2.setPages(book.getPages());
        bookservice.saveBook(book2);
        return mapBooker.toDTO(book2);
    }
    @DeleteMapping("/{book_id}") //DELETE
    @ResponseBody
    public bookDTO deleteBook(@PathVariable(name = "book_id") Long id)
    {
        Book book = bookservice.getBook(id);
        bookservice.deleteBook(book);
        return mapBooker.toDTO(book);
    }



}
