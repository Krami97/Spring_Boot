package algebra.example.spring_boot.Article;

import algebra.example.spring_boot.Article.dto.CreateArticleDto;
import algebra.example.spring_boot.Article.dto.UpdateArticleDto;
import algebra.example.spring_boot.Category.Category;
import algebra.example.spring_boot.Category.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.util.InternalException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService {
    private final ArticleRepository articleRepository;
    private final CategoryRepository categoryRepository; // potrebna kakao bi mogli kreirati article u postojecoj kategoriji



    public List<Article> fachAll(){

        return articleRepository.findAll();
    }

    public Optional<Article> findById(Integer id){
        Optional<Article> article = articleRepository.findById(id);

        return article;// vraca artikl iz optionala

    }

    public Article create(CreateArticleDto dto){
        Optional<Category> category = categoryRepository.findById(dto.getCategoryId());
        if(category.isEmpty()){ // provjeravamo dali kategorija postoji
            throw new NoSuchElementException();
        }

        Article article = new Article(dto.getName(),dto.getDescription(),dto.getPrice(),category.get());
        return articleRepository.save(article);
    }

    public Article update(Integer id, UpdateArticleDto dto){
        Optional<Article> article = articleRepository.findById(id);
        if(article.isEmpty()){
            throw new NoSuchElementException();
        }
        Optional<Category> category = categoryRepository.findById(dto.getCategoryId());
        if(category.isEmpty()){
            throw new NoSuchElementException();
        }
        Article articleForUpdate = article.get();
        articleForUpdate.setName(dto.getName());
        articleForUpdate.setDescription(dto.getDescription());
        articleForUpdate.setPrice(dto.getPrice());
        articleForUpdate.setCategory(category.get());
        articleForUpdate.setId(id);
        return articleRepository.save(articleForUpdate);

    }

    public void delete (Integer id ){
        Optional<Article> article = articleRepository.findById(id);
        if (article.isEmpty()){
            throw new InternalException("Article not found");
        }
        articleRepository.delete(article.get());
    }


}
