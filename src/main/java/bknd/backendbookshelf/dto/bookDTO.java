package bknd.backendbookshelf.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class bookDTO {
     Long book_id;
     String title;
     String author;
     int pages;
     int rating;


}
