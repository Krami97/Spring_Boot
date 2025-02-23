package algebra.example.spring_boot.korisnik;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Korisnik {
    private Long id;
    private String ime;
    private String prezime;
    private String oib;
    private String datumRodenja;
}
