package projectwp.demo.service;
import projectwp.demo.model.Genre;
import java.util.List;

public interface GenreService {

    Genre findById(Long id);

    List<Genre> listAll();

    Genre create(String name);
}
