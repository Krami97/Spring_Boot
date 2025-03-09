package algebra.example.spring_boot.Article;

import algebra.example.spring_boot.Article.dto.CreateArticleDto;
import algebra.example.spring_boot.Article.dto.UpdateArticleDto;

import java.util.List;
import java.util.Optional;

public interface ArticleService {

    List<Article> fachAll();

    Optional<Article> findById(Integer id);

    Article create(CreateArticleDto dto);

    Article update(Integer id, UpdateArticleDto dto);

    void delete(Integer id);
}
