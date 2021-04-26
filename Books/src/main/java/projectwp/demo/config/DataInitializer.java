package projectwp.demo.config;

import org.springframework.stereotype.Component;
import projectwp.demo.model.Role;
import projectwp.demo.model.User;
import projectwp.demo.service.BookService;
import projectwp.demo.service.GenreService;
import projectwp.demo.service.LanguageService;
import projectwp.demo.service.UserService;
import javax.annotation.PostConstruct;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class DataInitializer {

    public static final String ADMIN = "admin";

    private final UserService userService;

    private final GenreService genreService;

    private final BookService bookService;

    private final LanguageService languageService;


    public DataInitializer(UserService userService, GenreService genreService, BookService bookService, LanguageService languageService) {
        this.userService = userService;
        this.genreService = genreService;
        this.bookService = bookService;
        this.languageService = languageService;

    }

    @PostConstruct
    public void initData() {
        User admin = this.userService.create(ADMIN, ADMIN, Role.ROLE_ADMIN);

        for (int i = 1; i < 6; i++) {
            this.genreService.create("Genre " + i);
        }

        for (int i = 1; i < 11; i++) {
            this.bookService.create("Book " + i, 20.9 * i, i, Stream.of(1L, i % 5L + 1).collect(Collectors.toList()));
        }
    }
}
