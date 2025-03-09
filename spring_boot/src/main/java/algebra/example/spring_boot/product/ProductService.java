package algebra.example.spring_boot.product;

import algebra.example.spring_boot.product.dto.CreateProductDto;
import algebra.example.spring_boot.product.dto.UpdateProductDto;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {

    Product create(CreateProductDto dto);

    Product update(Integer id, UpdateProductDto dto);
    Product findById(Integer id);
    List<Product> fetchAll();
    void delete(Integer id);
    List<Product>  findByName(String name);

    List<Product> findPriceBetween(BigDecimal priceMin, BigDecimal priceMax);
    List<Product> findAvailableProducts();
    List<Product> findDescriptionContains(String description);

    List<Product> findByPriceNotBetween(BigDecimal priceMin , BigDecimal priceMax);

    List<Product> findByAvailableFalse();
    List<Product> findByDescriptionLike(String description);
    List<Product> findByDescriptionNotLike(String description);
    List<Product> findByDescriptionIsNull(String description);



}
