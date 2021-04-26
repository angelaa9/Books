package projectwp.demo.service.impl;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import projectwp.demo.model.Role;
import projectwp.demo.model.User;
import projectwp.demo.model.exceptions.InvalidUsernameException;
import projectwp.demo.repository.UserRepository;
import projectwp.demo.service.UserService;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User create(String username, String password, Role role) {
        String encryptedpassword=this.passwordEncoder.encode(password);
        User user = new User(username, encryptedpassword, role);
        return this.userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user= this.userRepository.findByUsername(username).orElseThrow(InvalidUsernameException::new);

        UserDetails userDetails = new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), Stream.of(new SimpleGrantedAuthority(user.getRole().toString())).collect(Collectors.toList()));
        return userDetails;
    }
}
