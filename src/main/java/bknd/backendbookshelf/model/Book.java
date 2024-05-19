package bknd.backendbookshelf.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "books")
public class Book
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long book_id;
    String title;
    String author;
    int pages;
    int rating;


}
