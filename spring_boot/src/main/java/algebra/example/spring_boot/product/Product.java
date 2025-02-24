package algebra.example.spring_boot.product;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {

    private long id;
    private  String name;
    private Integer quantity;
}
