package projectwp.demo.service.impl;
import org.springframework.stereotype.Service;
import projectwp.demo.model.Genre;
import projectwp.demo.model.exceptions.InvalidGenreIdException;
import projectwp.demo.repository.GenreRepository;
import projectwp.demo.service.GenreService;

import java.util.List;

@Service
public class GenreServiceImpl implements GenreService {

    private final GenreRepository genreRepository;

    public GenreServiceImpl(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Override
    public Genre findById(Long id) {
        return this.genreRepository.findById(id).orElseThrow(InvalidGenreIdException::new);
    }

    @Override
    public List<Genre> listAll() {
        return this.genreRepository.findAll();
    }

    @Override
    public Genre create(String name) {
        Genre genre = new Genre(name);
        return this.genreRepository.save(genre);
    }
}
