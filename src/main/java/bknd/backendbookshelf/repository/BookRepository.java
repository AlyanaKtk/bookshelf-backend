package bknd.backendbookshelf.repository;

import bknd.backendbookshelf.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    @Override
    public List<Book> findAll(); //поиск всех книг


}
