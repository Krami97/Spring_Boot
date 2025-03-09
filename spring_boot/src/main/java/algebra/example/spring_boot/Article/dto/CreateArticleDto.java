package algebra.example.spring_boot.Article.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;


import java.math.BigDecimal;

@Data
@AllArgsConstructor

public class CreateArticleDto {
    @NotBlank
    @Size(max=50)
    public String name;
    @NotBlank
    @Size(max=250)
    public String description;
    @NotNull
    @Positive
    public BigDecimal price;
    @NotNull
    @Positive
    public Integer categoryId;
}
