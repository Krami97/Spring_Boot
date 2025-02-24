package algebra.example.spring_boot.book;


import jakarta.validation.Valid;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;




@RequiredArgsConstructor
@RestController
@RequestMapping("/book")
public class BookControler {
    public final BookService service;

    @GetMapping("/{id}")
    public ResponseEntity<Book> FindByID(@PathVariable  Long id){
        Book book = service.findById(id);
        return ResponseEntity.ok(book);
    }


    @PostMapping
    public ResponseEntity<Book> create(@Valid @RequestBody CreateBookDto dto){
        Book book = service.create(dto);
        return ResponseEntity.status(201).body(book);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Book> update(@Valid @RequestBody UpdateBookDto dto, @PathVariable Long id){
        Book book =  service.update(dto,id);
        return ResponseEntity.ok(book);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build(); // vraca 204
    }


}
