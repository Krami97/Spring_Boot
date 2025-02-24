package algebra.example.spring_boot.product;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor  // samo final  , dok all sve  <- dependencie injections
public class ProductController {

    private final ProductService service;

    @GetMapping("/{id}")
    public ResponseEntity<Product> FindByID(@PathVariable  Long id){
        Product product = service.findById(id);
        return ResponseEntity.ok(product);
    }

    @GetMapping()
    public ResponseEntity<List<Product>> fetchAll(){
        List<Product> products  = service.fetchAll();
        return ResponseEntity.ok(products);
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@Valid @RequestBody CreateProductDto dto){
        Product product = service.create(dto);
        return ResponseEntity.status(201).body(product);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@RequestBody UpdateProductDto dto, @PathVariable Long id){
        Product product =  service.update(id,dto);
        return ResponseEntity.ok(product);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build(); // vraca 204
    }


}
