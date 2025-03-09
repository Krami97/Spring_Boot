package algebra.example.spring_boot.Category.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateCategoryDto {
    @NotBlank
    @Size(max=50)
    public String name;
    @NotBlank
    @Size(max=250)
    public String description;
}
