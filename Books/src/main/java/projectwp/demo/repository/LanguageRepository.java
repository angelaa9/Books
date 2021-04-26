package projectwp.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import projectwp.demo.model.Language;

public interface LanguageRepository extends JpaRepository<Language, Integer> {

}
