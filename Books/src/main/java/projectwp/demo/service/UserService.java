package projectwp.demo.service;
import projectwp.demo.model.Role;
import projectwp.demo.model.User;

public interface UserService {

    User create(String username, String password, Role role);

}
