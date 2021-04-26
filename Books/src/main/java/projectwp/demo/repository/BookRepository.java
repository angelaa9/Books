package projectwp.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import projectwp.demo.model.Book;
import projectwp.demo.model.Genre;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAllByNameLikeAndGenresContaining(String name, Genre Genre);
    List<Book> findAllByNameLike(String name);
    List<Book> findAllByGenresContaining(Genre genre);

}
