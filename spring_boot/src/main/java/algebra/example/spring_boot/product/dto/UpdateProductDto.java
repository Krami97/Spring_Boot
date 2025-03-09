package algebra.example.spring_boot.product.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class UpdateProductDto {

    public String name;

    public Integer quantity;

    private String description;

    private BigDecimal price;

    private boolean available;


}
