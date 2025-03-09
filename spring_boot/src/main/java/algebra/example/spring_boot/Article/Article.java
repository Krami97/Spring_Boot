package algebra.example.spring_boot.Article;

import algebra.example.spring_boot.Category.Category;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String description;

    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name="categoryId")
    private Category category;

    public Article(Integer id, BigDecimal price, String description, String name) {
        this.id = id;
        this.price = price;
        this.description = description;
        this.name = name;
    }

    public Article(String name, String description, BigDecimal price, Category category) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
    }
}
