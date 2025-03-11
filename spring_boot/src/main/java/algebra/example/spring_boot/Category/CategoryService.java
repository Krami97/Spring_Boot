package algebra.example.spring_boot.Category;

import algebra.example.spring_boot.Category.dto.CreateCategoryDto;
import algebra.example.spring_boot.Category.dto.UpdateCategoryDto;

import java.util.List;


public interface CategoryService {

    List<Category> fechAll();

    Category findById(Integer id);

    Category create(CreateCategoryDto dto);

    Category update(UpdateCategoryDto dto, Integer id);

    void delete (Integer id );

    Long numberOfArticlesByCategory(Integer categoryId);
}
