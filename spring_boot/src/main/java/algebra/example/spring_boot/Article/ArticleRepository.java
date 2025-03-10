package algebra.example.spring_boot.Article;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

// ima vec predefinirane CRUD metode
@Repository
public interface ArticleRepository extends JpaRepository<Article,Integer> {




    List<Article> findByPriceBetweenAndCategory_id(Integer min , Integer max ,Integer CategoryId);

    List<Article> findByNameOrDescriptionIgnoreCase(String name,String description);

    Optional<Article> findFirstByOrderByPriceDesc();

    /*
    Optional<Article> findTop1ByName(String name);//vrati prvi artikl koji je po imenu
    //
    @Query("SELECT a FROM Article a WHERE a.category.name = :name")
    Optional<Article> findByCategoryName(String name);

    List<Article> findByNameAndDescription(String name, String description); // pretrazuje po name i opisu

    List<Article> findByNameOrDescription(String name,String description); // pretrazuje  da se macha name ili opis

    Optional<Article> findByNameLike(String name); // pretrazuje po imenu koje slici

    Optional<Article> findByPriceBetween(BigDecimal price, BigDecimal min , BigDecimal max);

     */
}
