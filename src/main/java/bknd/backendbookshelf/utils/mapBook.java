package bknd.backendbookshelf.utils;

import bknd.backendbookshelf.dto.bookDTO;
import bknd.backendbookshelf.model.Book;
import org.springframework.stereotype.Service;

@Service
public class mapBook {
    public Book toBook(bookDTO dto){
        Book book = new Book();
        book.setBook_id(dto.getBook_id());
        book.setTitle(dto.getTitle());
        book.setAuthor(dto.getAuthor());
        book.setRating(dto.getRating());
        book.setPages(dto.getPages());
        return book;
    }
    public bookDTO toDTO(Book book){
        bookDTO dto = new bookDTO();
        dto.setBook_id(book.getBook_id());
        dto.setTitle(book.getTitle());
        dto.setAuthor(book.getAuthor());
        dto.setRating(book.getRating());
        dto.setPages(book.getPages());
        return dto;
    }
}
