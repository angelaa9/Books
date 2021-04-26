package projectwp.demo.service;
import projectwp.demo.model.Book;
import java.util.List;

public interface BookService {

    List<Book> listAllBooks();

    Book findById(Long id);

    Book create(String name, Double price, Integer quantity, List<Long> genres);

    Book update(Long id, String name, Double price, Integer quantity, List<Long> genres);

    Book delete(Long id);

    List<Book> listBooksByNameAndGenre(String name, Long genreId);

}
