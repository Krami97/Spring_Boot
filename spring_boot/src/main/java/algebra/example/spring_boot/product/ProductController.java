package algebra.example.spring_boot.product;

import algebra.example.spring_boot.product.dto.CreateProductDto;
import algebra.example.spring_boot.product.dto.UpdateProductDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor  // samo final  , dok all sve  <- dependencie injections
public class ProductController {

    private final ProductServiceImpl service;

    @GetMapping("/{id}")
    public ResponseEntity<Product> FindByID(@PathVariable Integer id) {
        Product product = service.findById(id);
        return ResponseEntity.ok(product);
    }

    @GetMapping()
    public ResponseEntity<List<Product>> fetchAll() {
        List<Product> products = service.fetchAll();
        return ResponseEntity.ok(products);
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@Valid @RequestBody CreateProductDto dto) {
        Product product = service.create(dto);
        return ResponseEntity.status(201).body(product);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@RequestBody UpdateProductDto dto, @PathVariable Integer id) {
        Product product = service.update(id, dto);
        return ResponseEntity.ok(product);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build(); // vraca 204
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<Product>> findByName(@PathVariable String name) {
        List<Product> products = service.findByName(name);
        if(products.isEmpty()){
            return ResponseEntity.status(204).body(products);
        }
        return ResponseEntity.status(200).body(products);
    }

    @GetMapping("price_between/{min}/{max}")
    public ResponseEntity<List<Product>> findPriceBetween(@PathVariable BigDecimal min, @PathVariable BigDecimal max) {
        List<Product> products = service.findPriceBetween(min, max);
        if(products.isEmpty()){
            return ResponseEntity.status(204).body(products);
        }
        return ResponseEntity.status(200).body(products);
    }
    @GetMapping("/available")
    public ResponseEntity<List<Product>> findAvailable(){
        List<Product> products = service.findAvailableProducts();
        if(products.isEmpty()){
            return ResponseEntity.status(204).body(products);
        }
        return  ResponseEntity.status(200).body(products);
    }
    @GetMapping("/description_contains/{description}")
    public ResponseEntity<List<Product>> findByDescriptionContains(@PathVariable String description){
        List<Product> products = service.findDescriptionContains(description);
        if(products.isEmpty()){
            return ResponseEntity.status(204).body(products);
        }
        return ResponseEntity.status(200).body(products);
    }

    @GetMapping("/price_not_between/{min}/{max}")
    public ResponseEntity<List<Product>> findByPriceNotBetween(@PathVariable BigDecimal min, @PathVariable BigDecimal max) {
        List<Product> products = service.findByPriceNotBetween(min, max);
        if(products.isEmpty()){
            return ResponseEntity.status(204).body(products);
        }
        return ResponseEntity.status(200).body(products);
    }

    @GetMapping("/not_available")
    public ResponseEntity<List<Product>> findAvailableFalse() {
        List<Product> products = service.findByAvailableFalse();
        if(products.isEmpty()){
            return ResponseEntity.status(204).body(products);
        }
        return ResponseEntity.status(200).body(products);
    }

    @GetMapping("/description_like/{description}")
    public ResponseEntity<List<Product>> findByDescriptionLike(@PathVariable String description) {
        List<Product> products = service.findByDescriptionLike(description);
        if(products.isEmpty()){
            return ResponseEntity.status(204).body(products);
        }
        return ResponseEntity.status(200).body(products);
    }

    @GetMapping("/description_not_like/{description}")
    public ResponseEntity<List<Product>> findByDescriptionNotLike(@PathVariable String description) {
        List<Product> products = service.findByDescriptionNotLike(description);
        if(products.isEmpty()){
            return ResponseEntity.status(204).body(products);
        }
        return ResponseEntity.status(200).body(products);
    }

    @GetMapping("/description_is_null")
    public ResponseEntity<List<Product>> findByDescriptionIsNull(String description) {
        List<Product> products = service.findByDescriptionIsNull(description);
        if(products.isEmpty()){
            return ResponseEntity.status(204).body(products);
        }
        return ResponseEntity.status(200).body(products);
    }

}
