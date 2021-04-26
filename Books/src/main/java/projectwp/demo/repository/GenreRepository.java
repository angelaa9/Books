package projectwp.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import projectwp.demo.model.Genre;

public interface GenreRepository extends JpaRepository<Genre, Long> {

}
