package algebra.example.spring_boot.Category;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {

    public final CategoryRepository categoryRepository;

    public List<Category> fechAll(){
        Optional<List<Category>> categories =categoryRepository.fechAll();
        if(categories.isEmpty()){
            throw new NoSuchElementException();
        }
        return categories.get();
    }

    public Category findById(Integer id){
        Optional<Category> category = categoryRepository.findById(id);
        if(category.isEmpty()){
            throw new NoSuchElementException();
        }
        return category.get();
    }

    public Category create(CreateCategoryDto dto){
        Category category = new Category();
        category.setName(dto.getName());
        category.setDescription(dto.getDescription());
        Optional<Category> newCategory = categoryRepository.create(category);
        if(newCategory.isEmpty()){
            throw new NoSuchElementException();
        }
        return newCategory.get();
    }

    public Category update(UpdateCategoryDto dto,Integer id){
        Category category = new Category();
        category.setId(id);
        category.setName(dto.getName());
        category.setDescription(dto.getDescription());

        Optional<Category> updatedCategory = categoryRepository.update(category);
        if(updatedCategory.isEmpty()){
            throw new NoSuchElementException();
        }
        return updatedCategory.get();
    }
}

