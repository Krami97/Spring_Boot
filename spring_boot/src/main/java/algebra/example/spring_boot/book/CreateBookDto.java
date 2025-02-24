package algebra.example.spring_boot.book;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateBookDto {
    @Size(min =3)
    public String title;
    @NotBlank
    public String author;
    @Min(1500)
    @Max(2025)
    public Long yearPublished;
    @Positive
    public Double price;
}
