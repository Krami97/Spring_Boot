package algebra.example.spring_boot.Category;

import algebra.example.spring_boot.Category.dto.CreateCategoryDto;
import algebra.example.spring_boot.Category.dto.UpdateCategoryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService{

    public final CategoryRepository categoryRepository;
    @Override
    public List<Category> fechAll(){
        List<Category> categories = categoryRepository.findAll();

        return categories;
    }
    @Override
    public Category findById(Integer id){
        Optional<Category> category = categoryRepository.findById(id);
        if(category.isEmpty()){
            throw new NoSuchElementException();
        }
        return category.get();
    }
    @Override
    public Category create(CreateCategoryDto dto) {
        Category category = new Category();
        category.setName(dto.getName());
        category.setDescription(dto.getDescription());
        Category newCategory = categoryRepository.save(category);

        return newCategory;
    }
    @Override
    public Category update(UpdateCategoryDto dto, Integer id){
        Category category = new Category();
        category.setId(id);
        category.setName(dto.getName());
        category.setDescription(dto.getDescription());

        Category updatedCategory = categoryRepository.save(category);

        return updatedCategory;
    }
    @Override
    public void delete (Integer id ){
        Optional<Category> category = categoryRepository.findById(id);
        if(category.isEmpty()){
            throw new RuntimeException("No such Category");
        }
            categoryRepository.delete(category.get());

    }

    @Override
    public Long numberOfArticlesByCategory(Integer categoryId) {
        return categoryRepository.numberOfArticlesByCategory(categoryId);
    }
}

