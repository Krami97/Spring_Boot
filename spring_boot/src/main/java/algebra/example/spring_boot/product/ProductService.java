package algebra.example.spring_boot.product;

import org.springframework.stereotype.Service;

import java.util.List;

//service klase upravljaju poslovnom logikom
@Service //ili @Component  oznacaju "beans klasu" spring bootu , pos
public class ProductService {

    public Product create(CreateProductDto dto){
        return new Product(12l,dto.getName(), dto.getQuantity());
    }

    public Product update(Long id, UpdateProductDto dto){
        Product productFromDb  = new Product(12l , "old name",11);

        productFromDb.setName(dto.getName());
        return productFromDb;
    }
    public Product findById(Long id){
        return new Product(id,"some name from db",11);
    }
    public List<Product> fetchAll(){
        return List.of(new Product(12l , " name1",10),new Product(13l , "old name2",11));
    }

    public void delete(Long id){
        System.out.println("Product se brise iz baze podtaka id: "+ id);
        // logika za brisanje
    }
}
