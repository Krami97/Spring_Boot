package algebra.example.spring_boot.product;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private  String name;

    private Integer quantity;

    private String description;

    private BigDecimal price;

    private boolean available;

    private LocalDateTime createdAt;


    public Product(String name, Integer quantity, String description,BigDecimal price,boolean available,LocalDateTime createdAt){
        this.name = name;
        this.quantity = quantity;
        this.description = description;
        this.price = price;
        this.available = available;
        this.createdAt = createdAt;
    }
}
