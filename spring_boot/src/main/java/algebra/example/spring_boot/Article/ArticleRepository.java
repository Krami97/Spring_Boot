package algebra.example.spring_boot.Article;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
@RequiredArgsConstructor
public class ArticleRepository {

    private final JdbcTemplate jdbcTemplate;


    public List<Article> fachAll(){
        return jdbcTemplate.query("SELECT a.id, a.name, a.description, a.price, a.categoryId, c.name AS categoryName, " +
                "c.description AS categoryDescription FROM Article a LEFT JOIN Category c ON a.categoryId = c.id", new ArticleRowMapper());

    }
    // Optional znaci da cemo dobiti artikl ako postoji ili null ako ga nema u bazi
    public Optional<Article> findById(Integer id){
        String query ="SELECT a.id, a.name, a.description, a.price, a.categoryId, c.name AS categoryName, " +
                "c.description AS categoryDescription FROM Article a LEFT JOIN Category c ON a.categoryId = c.id" +
                " WHERE a.id = ?";
        Map<String, Object> parameters = new HashMap<>();// kad satvimo Object kao tip podatka mozemo prosljediti bilo koji tip podatka
                                                        // to se korisit kako bi mogli prosljediti vise razlicitih tipova podataka

        parameters.put("articleId",id);
        return Optional.ofNullable((Article)jdbcTemplate.queryForObject(query,new ArticleRowMapper(),id));

    }

    public Article create(Article article){
        String query ="INSERT INTO Article(name,description,price,CategoryId) VALUES(?,?,?,?)";
        jdbcTemplate.update(query,article.getName(),article.getDescription(),article.getPrice(),article.getCategory().getId());



            return article;


    }
    public Article update(Article article){
        String query = "UPDATE Article SET name=?,description = ?,price =?,categoryId=? WHERE id = ?";
        jdbcTemplate.update(query,article.getName(),article.getDescription(),article.getPrice(),article.getCategory().getId());
        return article;
    }

}
