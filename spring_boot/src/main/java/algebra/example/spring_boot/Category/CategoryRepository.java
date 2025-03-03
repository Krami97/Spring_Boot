package algebra.example.spring_boot.Category;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CategoryRepository {
    private final JdbcTemplate jdbcTemplate;


    public Optional<List<Category>> fechAll(){
        String query ="SELECT * FROM Category";
        return Optional.of(jdbcTemplate.query(query,new CategoryRowMapper()));
    }


    public Optional<Category> findById(Integer id){
        String query = "SELECT * FROM Category WHERE id=?";
        return Optional.ofNullable(jdbcTemplate.queryForObject(query,new CategoryRowMapper(),id));
    }

    public Optional<Category> create(Category category){
        String query ="INSERT INTO Category(name,description) VALUES(?,?)";
        jdbcTemplate.update(query,category.getName(),category.getDescription());
        return Optional.of(category);
    }

    public Optional<Category> update(Category category){
        String query = "UPDATE Category SET name =? , description = ? WHERE id = ?";
        jdbcTemplate.update(query,category.getName(),category.getDescription(),category.getId());
        return Optional.of(category);
    }

}
