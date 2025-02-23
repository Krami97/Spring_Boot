package algebra.example.spring_boot.korisnik;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/korisnik")
@RequiredArgsConstructor
public class KorisnikController {

    private  final KorisnikService service;
    @GetMapping("/{id}")
    public Korisnik FindByID(@PathVariable Long id){
        return service.findById(id);
    }

    @GetMapping()
    public List<Korisnik> fetchAll(){
        return service.fetchAll();
    }

    @PostMapping
    public Korisnik create(@RequestBody CreateKorisnikDto dto){
        return service.create(dto);
    }


    @PutMapping("/{id}")
    public Korisnik update(@RequestBody UpdateKorisnikDto dto, @PathVariable Long id){
        return service.update(id,dto);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }


}
