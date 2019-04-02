package beans.helper;

import domain.Post;
import domain.User;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import services.UserService;
import services.UserServiceImpl;

/**
 *
 * @author abraham
 */
@Named
@RequestScoped
public class UserHelper implements Serializable {

    @Inject
    UserService userService;
    private List<User> users;

    @PostConstruct
    public void init() {
        users = userService.getAllUsers();
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }

    
}
