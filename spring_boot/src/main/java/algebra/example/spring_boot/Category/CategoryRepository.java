package algebra.example.spring_boot.Category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {
    @Query("SELECT COUNT(id) FROM Article a  WHERE a.category.id = :categoryId")
    Long numberOfArticlesByCategory(Integer categoryId);
}
