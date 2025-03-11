package algebra.example.spring_boot.Category;

import algebra.example.spring_boot.Category.dto.CreateCategoryDto;
import algebra.example.spring_boot.Category.dto.UpdateCategoryDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {

    public final CategoryServiceImpl categoryServiceImpl;

    @GetMapping
    public ResponseEntity<List<Category>> fechAll(){
        return ResponseEntity.status(200).body(categoryServiceImpl.fechAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Category> findById(@PathVariable Integer id){
        return ResponseEntity.status(200).body(categoryServiceImpl.findById(id));
    }
    @PostMapping
    public ResponseEntity<Category> create(@Valid @RequestBody CreateCategoryDto dto){
        Category category = categoryServiceImpl.create(dto);
        return ResponseEntity.status(201).body(category);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Category> update(@Valid @RequestBody UpdateCategoryDto dto , @PathVariable Integer id){
        Category category = categoryServiceImpl.update(dto,id);
        return ResponseEntity.status(200).body(category);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Integer id) {
        categoryServiceImpl.delete(id);
        return ResponseEntity.status(204).build();
    }

    @GetMapping("/{id}/count-articles")
    public ResponseEntity<Long>numberOfArticlesByCategory(@PathVariable Integer id){
        Long numberOfArticles = categoryServiceImpl.numberOfArticlesByCategory(id);
        return ResponseEntity.status(200).body(numberOfArticles);
    }





}
