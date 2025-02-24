package algebra.example.spring_boot.book;

import org.springframework.stereotype.Service;

@Service
public class BookService {

    public Book create(CreateBookDto dto){
        return new Book(1L, dto.getTitle(), dto.getAuthor(), dto.getYearPublished(), dto.getPrice());

    }
    public Book update(UpdateBookDto dto, Long id){
        Book bookFromDB = new Book(1L,"perina prica","pero",1999L,22.25);
        bookFromDB.setAuthor(dto.getAuthor());
        bookFromDB.setPrice(dto.getPrice());
        bookFromDB.setTitle(dto.getTitle());
        bookFromDB.setYearPublished(dto.getYearPublished());
        return bookFromDB;
    }

    public Book findById(Long id){
        Book bookFromDB = new Book(id,"perina prica","pero",1999L,22.25);
        return bookFromDB;
    }
    public void delete(Long id){
        System.out.println("Book with id: "+id+" deleted");
        // code za brisanje knjige
    }
}
