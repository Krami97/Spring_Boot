package algebra.example.spring_boot.Article;

import algebra.example.spring_boot.Article.dto.CreateArticleDto;
import algebra.example.spring_boot.Article.dto.UpdateArticleDto;
import algebra.example.spring_boot.Category.Category;
import algebra.example.spring_boot.Category.CategoryRepositoryImpl;
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
    private final CategoryRepositoryImpl categoryRepositoryImpl; // potrebna kakao bi mogli kreirati article u postojecoj kategoriji


    @Override
    public List<Article> fachAll(){

        return articleRepository.findAll();
    }
    @Override
    public Optional<Article> findById(Integer id){
        Optional<Article> article = articleRepository.findById(id);

        return article;// vraca artikl iz optionala

    }
    @Override
    public Article create(CreateArticleDto dto){
        Optional<Category> category = categoryRepositoryImpl.findById(dto.getCategoryId());
        if(category.isEmpty()){ // provjeravamo dali kategorija postoji
            throw new NoSuchElementException();
        }

        Article article = new Article(dto.getName(),dto.getDescription(),dto.getPrice(),category.get());
        return articleRepository.save(article);
    }
    @Override
    public Article update(Integer id, UpdateArticleDto dto){
        Optional<Article> article = articleRepository.findById(id);
        if(article.isEmpty()){
            throw new NoSuchElementException();
        }
        Optional<Category> category = categoryRepositoryImpl.findById(dto.getCategoryId());
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
    @Override
    public void delete (Integer id ){
        Optional<Article> article = articleRepository.findById(id);
        if (article.isEmpty()){
            throw new InternalException("Article not found");
        }
        articleRepository.delete(article.get());
    }

    @Override
    public List<Article> findByPriceBetweenAndCategory_id(Integer min, Integer max, Integer CategoryId) {
        List<Article> articles = articleRepository.findByPriceBetweenAndCategory_id(min,max,CategoryId);
        return articles;
    }

    @Override
    public List<Article> findByNameOrDescriptionIgnoreCase(String name, String description) {
        List<Article> articles = articleRepository.findByNameOrDescriptionIgnoreCase(name,description);
        return articles;
    }

    @Override
    public Article findMostExpensive() {
        Optional<Article> article = articleRepository.findFirstByOrderByPriceDesc();
        if(article.isEmpty()){
            throw new RuntimeException("No article");
        }
        return article.get();
    }


}
