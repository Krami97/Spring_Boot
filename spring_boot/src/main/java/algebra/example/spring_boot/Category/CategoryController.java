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

    public final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Category>> fechAll(){
        return ResponseEntity.status(200).body(categoryService.fechAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Category> findById(@PathVariable Integer id){
        return ResponseEntity.status(200).body(categoryService.findById(id));
    }
    @PostMapping
    public ResponseEntity<Category> create(@Valid @RequestBody CreateCategoryDto dto){
        Category category = categoryService.create(dto);
        return ResponseEntity.status(201).body(category);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Category> update(@Valid @RequestBody UpdateCategoryDto dto , @PathVariable Integer id){
        Category category = categoryService.update(dto,id);
        return ResponseEntity.status(200).body(category);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Integer id) {
        categoryService.delete(id);
        return ResponseEntity.status(204).build();
    }





}
