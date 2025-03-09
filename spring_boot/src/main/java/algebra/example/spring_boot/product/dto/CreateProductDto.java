package algebra.example.spring_boot.product.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Data
@AllArgsConstructor
public class CreateProductDto {

    @NotBlank
    @Size(min = 3 , max =13)
    public String name;

    @NotNull
    @Min(2)
    @Max(13)
    public Integer quantity;

    private String description;

    private BigDecimal price;

    private boolean available;



}
