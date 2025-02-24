package algebra.example.spring_boot.product;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;



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

}
