package algebra.example.spring_boot.product;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {

    List<Product> findByName(String name);

    List<Product> findByPriceBetween(BigDecimal priceMin , BigDecimal priceMax);

    @Query("SELECT p FROM Product p WHERE p.price NOT BETWEEN :priceMin AND :priceMax")
    List<Product> findByPriceNotBetween(BigDecimal priceMin , BigDecimal priceMax);

    List<Product> findByAvailableTrue();

    @Query("SELECT p FROM Product p WHERE p.available = False")
    List<Product> findByAvailableFalse();


    List<Product> findByDescriptionLike(String description);

    @Query("SELECT p FROM Product p WHERE p.description LIKE :description")
    List<Product> findByDescriptionLike2(String description);

    @Query("SELECT p FROM Product p WHERE p.description NOT LIKE :description")
    List<Product> findByDescriptionNotLike(String description);


    @Query("SELECT p FROM Product p WHERE p.description IS NULL")
    List<Product> findByDescriptionIsNull(String description);

}
