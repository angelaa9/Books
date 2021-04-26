package projectwp.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import projectwp.demo.model.User;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByUsername(String username);

}
