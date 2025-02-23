package algebra.example.spring_boot.product;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor  // samo final  , dok all sve  <- dependencie injections
public class ProductController {

    private final ProductService service;

    @GetMapping("/{id}")
    public Product FindByID(@PathVariable  Long id){
        return service.findById(id);
    }

    @GetMapping()
    public List<Product> fetchAll(){
        return service.fetchAll();
    }

    @PostMapping
    public Product createProduct(@RequestBody CreateProductDto dto){
        return service.create(dto);
    }


    @PutMapping("/{id}")
    public Product updateProduct(@RequestBody UpdateProductDto dto, @PathVariable Long id){
        return service.update(id,dto);
    }
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id){
        service.delete(id);
    }


}
