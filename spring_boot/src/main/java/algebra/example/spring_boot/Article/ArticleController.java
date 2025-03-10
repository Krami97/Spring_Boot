package algebra.example.spring_boot.Article;

import algebra.example.spring_boot.Article.dto.CreateArticleDto;
import algebra.example.spring_boot.Article.dto.UpdateArticleDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/articles")
@RequiredArgsConstructor
public class ArticleController {
    private final ArticleService articleService;


    @GetMapping
    public ResponseEntity<List<Article>> fetchAll(){
        List<Article> articles = articleService.fachAll();
        return ResponseEntity.ok(articles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Article> findById(@PathVariable Integer id){
        Optional<Article> article = articleService.findById(id);

        if (article.isEmpty()){
            return ResponseEntity.status(404).build();
        }
        return ResponseEntity.status(200).body(article.get());
    }

    @PostMapping
    public ResponseEntity<Article> create(@Valid @RequestBody CreateArticleDto dto){
        Article article = articleService.create(dto);
        return ResponseEntity.status(201).body(article);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Article> update(@Valid @RequestBody UpdateArticleDto dto, @PathVariable Integer id){
        Article article = articleService.update(id,dto);
        return ResponseEntity.status(200).body(article);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Integer id) {
        articleService.delete(id);
        return ResponseEntity.status(204).build();
    }
    @GetMapping("/price_categoryId")
    public ResponseEntity<List<Article>> findByPriceBetweenAndCategory_id(@RequestParam("min")Integer min ,
                                                                          @RequestParam("max")Integer max,
                                                                          @RequestParam("category_id") Integer id){
        List<Article> articles = articleService.findByPriceBetweenAndCategory_id(min,max,id);
        if(articles.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.status(200).body(articles);
    }

    @GetMapping("/nameOrDescription")
    public ResponseEntity<List<Article>> findByNameOrDescriptionIgnoreCase(@RequestParam(value = "name",required = false)String name, @RequestParam(value = "description",required = false)String description){
        List<Article> articles = articleService.findByNameOrDescriptionIgnoreCase(name,description);
        if(articles.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.status(200).body(articles);
    }

    @GetMapping("/top-expensive")
    public ResponseEntity<Article> findMostExpensive(){
        Article article = articleService.findMostExpensive();

        return ResponseEntity.status(200).body(article);
    }


}
