package algebra.example.spring_boot.product;

import algebra.example.spring_boot.product.dto.CreateProductDto;
import algebra.example.spring_boot.product.dto.UpdateProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

//service klase upravljaju poslovnom logikom
@Service //ili @Component  oznacaju "beans klasu" spring bootu , pos
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{
    public final ProductRepository productRepository;
    @Override
    public Product create(CreateProductDto dto){
        LocalDateTime now = LocalDateTime.now();
        Product product = new Product(dto.getName(),dto.getQuantity(),dto.getDescription(),dto.getPrice(),dto.isAvailable(),now);
        productRepository.save(product);
        return product;
    }
    @Override
    public Product update(Integer id, UpdateProductDto dto){
        Optional<Product> product = productRepository.findById(id);
        if (product.isEmpty()){
            throw new RuntimeException("Product not found");
        }
        Product uppdatedProduct = product.get();
        uppdatedProduct.setName(dto.getName());
        uppdatedProduct.setDescription(dto.getDescription());
        uppdatedProduct.setQuantity(dto.getQuantity());
        uppdatedProduct.setPrice(dto.getPrice());
        productRepository.save(uppdatedProduct);
        return uppdatedProduct;

    }
    @Override
    public Product findById(Integer id){
        Optional<Product> product = productRepository.findById(id);
        if(product.isEmpty()){
            throw new RuntimeException("Product not found");
        }
        return product.get();
    }
    @Override
    public List<Product> fetchAll(){
        List<Product> products = productRepository.findAll();
        return  products;
    }
    @Override
    public void delete(Integer id){
        Optional<Product> product = productRepository.findById(id);
        if (product.isEmpty()){
            throw new RuntimeException("Product not found");
        }
        productRepository.delete(product.get());
    }
    @Override
    public List<Product> findByName(String name){
        List<Product> products = productRepository.findByName(name);

        return products;
    }
    @Override
    public List<Product> findPriceBetween(BigDecimal priceMin, BigDecimal priceMax){
        List<Product> products = productRepository.findByPriceBetween(priceMin,priceMax);
        return products;
    }
    @Override
    public List<Product> findAvailableProducts(){
        List<Product> products = productRepository.findByAvailableTrue();
        return products;
    }
    @Override
    public List<Product> findDescriptionContains(String description){
        List<Product> products = productRepository.findByDescriptionLike("%"+description+"%");
        return products;
    }

    @Override
    public List<Product> findByPriceNotBetween(BigDecimal priceMin, BigDecimal priceMax) {
        List<Product> products = productRepository.findByPriceNotBetween(priceMin,priceMax);
        return products;
    }

    @Override
    public List<Product> findByAvailableFalse() {
        List<Product> products = productRepository.findByAvailableFalse();
        return products;
    }

    @Override
    public List<Product> findByDescriptionLike(String description) {
        List<Product> products = productRepository.findByDescriptionLike("%"+description+"%");
        return products;
    }

    @Override
    public List<Product> findByDescriptionNotLike(String description) {
        List<Product> products = productRepository.findByDescriptionNotLike("%"+description+"%");
        return products;
    }

    @Override
    public List<Product> findByDescriptionIsNull(String description) {
        List<Product> products = productRepository.findByDescriptionIsNull(description);
        return products;
    }

}
