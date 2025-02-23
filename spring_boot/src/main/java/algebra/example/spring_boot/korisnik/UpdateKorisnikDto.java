package algebra.example.spring_boot.korisnik;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UpdateKorisnikDto {
    public String ime;
    public String prezime;
    public String oib;
    public String datumRodenja;
}
