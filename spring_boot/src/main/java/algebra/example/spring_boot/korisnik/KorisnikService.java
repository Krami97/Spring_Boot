package algebra.example.spring_boot.korisnik;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KorisnikService {

    public Korisnik create (CreateKorisnikDto dto){
        return new Korisnik(1L,dto.getIme(), dto.getPrezime(), dto.getOib(), dto.getDatumRodenja());

    }
    public Korisnik update(Long id,UpdateKorisnikDto dto){
        Korisnik korisnikFromDb = new Korisnik(22L,"ime","prezime","1234567890","22.02.2025");
        korisnikFromDb.setIme(dto.getIme());
        korisnikFromDb.setPrezime(dto.getPrezime());
        korisnikFromDb.setDatumRodenja(dto.getDatumRodenja());
        korisnikFromDb.setOib(dto.getOib());
        return korisnikFromDb;
    }

    public Korisnik findById(Long id){
        Korisnik korisnikFromDB = new Korisnik(22L,"ime","prezime","1234567890","22.02.2025");
        return korisnikFromDB;
    }

    public List<Korisnik> fetchAll(){
        return List.of(new Korisnik(22L,"ime","prezime","1234567890","22.02.2025"),new Korisnik(23L,"ime2","prezime2","1234567890","22.02.2025"));
    }
    public void delete(Long id){
        System.out.println("Korisnik se brise iz baze podataka id: " + id);
        //brisanje korinika
    }


}
