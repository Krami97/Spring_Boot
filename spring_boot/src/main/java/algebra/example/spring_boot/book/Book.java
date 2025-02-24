package algebra.example.spring_boot.book;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Book {
    private Long id;
    private String title;
    private String author;
    private Long yearPublished;
    private Double price;
}
