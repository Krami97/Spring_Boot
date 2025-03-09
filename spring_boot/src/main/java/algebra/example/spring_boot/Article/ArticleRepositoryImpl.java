package algebra.example.spring_boot.Article;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
@RequiredArgsConstructor
public class ArticleRepositoryImpl  {

    private final JdbcTemplate jdbcTemplate;


    public List<Article> fachAll(){

        return jdbcTemplate.query("SELECT a.id, a.name, a.description, a.price, a.category_Id, c.name AS categoryName, " +
                "c.description AS categoryDescription FROM Article a LEFT JOIN Category c ON a.category_Id = c.id", new ArticleRowMapper());

    }
    // Optional znaci da cemo dobiti artikl ako postoji ili null ako ga nema u bazi

    public Optional<Article> findById(Integer id){
        String query ="SELECT a.id, a.name, a.description, a.price, a.category_Id, c.name AS categoryName, " +
                "c.description AS categoryDescription FROM Article a LEFT JOIN Category c ON a.category_Id = c.id" +
                " WHERE a.id = ?";
        Map<String, Object> parameters = new HashMap<>();// kad satvimo Object kao tip podatka mozemo prosljediti bilo koji tip podatka
                                                        // to se korisit kako bi mogli prosljediti vise razlicitih tipova podataka
        try {
            return Optional.ofNullable(jdbcTemplate.queryForObject(query, new ArticleRowMapper(), id));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }

    }

    public Article create(Article article){
        String query ="INSERT INTO Article(name,description,price,Category_Id) VALUES(?,?,?,?)";
        jdbcTemplate.update(query,article.getName(),article.getDescription(),article.getPrice(),article.getCategory().getId());



        return article;


    }

    public Article update(Article article){
        String query = "UPDATE Article SET name=?,description = ?,price =?,category_Id=? WHERE id = ?";
        jdbcTemplate.update(query,article.getName(),article.getDescription(),article.getPrice(),article.getCategory().getId(),article.getId());
        return article;
    }

    public void  delete(Integer id){
        String query ="DELETE Article WHERE id = ?";
        jdbcTemplate.update(query,id);
    }

}
